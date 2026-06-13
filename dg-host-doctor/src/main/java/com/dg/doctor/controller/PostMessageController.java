package com.dg.doctor.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.doctor.form.PostMessageForm;
import com.dg.doctor.model.PatientDetailModel;
import com.dg.doctor.model.PatientModel;
import com.dg.doctor.model.PractitionerModel;
import com.dg.doctor.service.MailService;
import com.dg.doctor.service.PostMessageService;
import com.dg.doctor.service.UserService;

/**
 * 
 * Handles requests for the application post message page.
 *
 */
@Controller
public class PostMessageController{
	
	private static final Logger logger = LoggerFactory.getLogger(PostMessageController.class);
	
	@Autowired
	private PostMessageService postMessageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/home/postmessage/edit", method = RequestMethod.GET)
	public String edit(PostMessageForm postMessageForm,@RequestParam(value = "pc", required = false) BigInteger pc,@RequestParam(value = "subject", required = false) String subject,Model model){
		List<PatientDetailModel> patientModelList = null;
		List<PatientDetailModel> patientList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();
		
		if(userService.isLoggedIn()){
			if(pc != null){
				postMessageForm.setPatientcase(pc);
				patientModelList = postMessageService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
	    		if(!patientModelList.isEmpty()){
	    			for(PatientDetailModel p: patientModelList){
		    			if(result.add(p.getId())&& p.getId() !=null){
		    				patientList.add(p);
		    			}
		    			model.addAttribute("procedureFound", false);
		    			if(postMessageService.getIsProcedureExist(p.getId(),p.getTreatment(),p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner())){
		    				model.addAttribute("procedureFound", true);
		    			}
	    			}	
	    		}
			}
		}
		model.addAttribute("patientList", patientList);
		model.addAttribute("postMessageForm", postMessageForm);
		return "postmessage/edit";
	}
	
	@RequestMapping(value = "/home/postmessage/edit", method = RequestMethod.POST)
	public String edit(@Valid PostMessageForm postMessageForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during post message sent",
					bindingResult.getErrorCount());
			model.addAttribute("error", 1);
			return "home/postmessage";
		} 		
		if(postMessageForm.getPatientcase() != null){
			Boolean edited = postMessageService.edit(postMessageForm);
			if(edited){
				PatientModel pm = postMessageService.getPatient(postMessageForm.getReceiver());
    			PractitionerModel practitioner = postMessageService.getPractitioner(userService.getCurrentUserId());
    	        if(pm.getId() != null){
    	        	mailService.sendMail(pm.getEmail(), "Doctor Message", postMessageForm.getBody().replaceAll(System.getProperty("line.separator"), "<br/>"), "conference.html", null, pm.getFirstName() + " "+ pm.getLastName(),practitioner.getFirstName() + " "+ practitioner.getLastName(),postMessageForm.getPatientcase().intValue(),true,false);
    	        }
    			redirectAttributes.addFlashAttribute("message", "1");
    			redirectAttributes.addAttribute("pc", postMessageForm.getPatientcase());
    			return "redirect:/home/postmessage/edit";
			}
		}
		return "postmessage/edit";
	}
	
}