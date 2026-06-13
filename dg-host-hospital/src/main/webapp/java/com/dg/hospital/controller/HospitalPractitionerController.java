package com.dg.hospital.controller;

import java.io.File;
import java.math.BigInteger;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.hospital.form.PractitionerAttestationsForm;
import com.dg.hospital.form.PractitionerLanguageForm;
import com.dg.hospital.form.PractitionerMethodForm;
import com.dg.hospital.form.PractitionerPhotoForm;
import com.dg.hospital.form.PractitionerSpecialtyForm;
import com.dg.hospital.form.PractitionerStatsForm;
import com.dg.hospital.form.PractitionerTreatmentForm;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodPractitionerModel;
import com.dg.hospital.model.PractitionerModel;
import com.dg.hospital.service.HospitalPractitionerService;
import com.dg.hospital.service.UserService;

@Controller
public class HospitalPractitionerController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalPractitionerController.class);
	
	@Autowired
	private HospitalPractitionerService hospitalPractitionerService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * index action
	*/
	@RequestMapping(value = "/home/practitioner", method = RequestMethod.GET)
	public String indexAction(Model model) {
		model.addAttribute("hospitalPractitionerList", hospitalPractitionerService.getHospitalPractitionerModel(userService.getCurrentHealthcareprovider()));
		model.addAttribute("specialtyList", hospitalPractitionerService.getHospitalPractitionerSpecialty(userService.getCurrentHealthcareprovider()));
		return "practitioner/index";
	}
	
	/**
	 * add action
	*/
	@RequestMapping(value = "/home/practitioner/add", method = RequestMethod.GET)
	public String addAction(PractitionerSpecialtyForm practitionerSpecialtyForm,Model model) {		
		practitionerSpecialtyForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());		
		model.addAttribute("specialtyList", hospitalPractitionerService.getAllSpecialty());
		model.addAttribute("practitionertypeList", hospitalPractitionerService.getAllPractitionertype());
		return "practitioner/add";
	}
	
	/**
	 * add post action
	*/
	@RequestMapping(value = "/home/practitioner/add", method = RequestMethod.POST)	
	public String addPostAction(PractitionerSpecialtyForm practitionerSpecialtyForm,RedirectAttributes redirectAttributes,Model model) {
		
		Boolean edited = hospitalPractitionerService.addPractitionerSpecialty(practitionerSpecialtyForm,false);
		if(!edited){
			model.addAttribute("error", "0");
		}else{
			redirectAttributes.addFlashAttribute("success", "1");
			return "redirect:/home/practitioner";
		}
		model.addAttribute("specialtyList", hospitalPractitionerService.getAllSpecialty());	
		model.addAttribute("practitionertypeList", hospitalPractitionerService.getAllPractitionertype());
		return "practitioner/add";
	}
	
	/**
	 * edit action
	*/
	@RequestMapping(value = "/home/practitioner/edit", method = RequestMethod.GET)
	public String editAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerSpecialtyForm practitionerSpecialtyForm,Model model) {	
		practitionerSpecialtyForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		practitionerSpecialtyForm.setPractitionerModel(hospitalPractitionerService.getPractitionerById(id));
		model.addAttribute("specialtyList", hospitalPractitionerService.getSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));		
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));
		model.addAttribute("practitionertypeList", hospitalPractitionerService.getAllPractitionertype());
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(id));
		return "practitioner/edit";
	}
	
	/**
	 * edit post action
	*/
	@RequestMapping(value = "/home/practitioner/edit", method = RequestMethod.POST)	
	public String editPostAction(PractitionerSpecialtyForm practitionerSpecialtyForm,RedirectAttributes redirectAttributes,Model model) {		
		Boolean edited = hospitalPractitionerService.addPractitionerSpecialty(practitionerSpecialtyForm,true);
		if(!edited){
			model.addAttribute("error", "0");
		}else{
			redirectAttributes.addFlashAttribute("success", "1");
			redirectAttributes.addAttribute("id", practitionerSpecialtyForm.getPractitionerModel().getId());
			return "redirect:/home/practitioner/edit";
		}
		model.addAttribute("specialtyList", hospitalPractitionerService.getSpecialtyFormList(practitionerSpecialtyForm.getPractitionerModel().getId(),userService.getCurrentHealthcareprovider()));		
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(practitionerSpecialtyForm.getPractitionerModel().getId(),userService.getCurrentHealthcareprovider()));
		model.addAttribute("practitionertypeList", hospitalPractitionerService.getAllPractitionertype());
		model.addAttribute("id",practitionerSpecialtyForm.getPractitionerModel().getId());
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(practitionerSpecialtyForm.getPractitionerModel().getId()));
		return "practitioner/edit";
	}
	
	/**
	 * medical action
	*/
	@RequestMapping(value = "/home/practitioner/medical", method = RequestMethod.GET)
	public String medicalAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerModel practitionerModel,Model model){
		model.addAttribute("practitionerModel", hospitalPractitionerService.getPractitionerById(id));
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(id));
		return "practitioner/medical";
	}
	
	/**
	 * medical action
	*/
	@RequestMapping(value = "/home/practitioner/medical", method = RequestMethod.POST)
	public String medicalPostAction(@Valid PractitionerModel practitionerModel,RedirectAttributes redirectAttributes,Model model){
		Integer edited = hospitalPractitionerService.setPractitioner(practitionerModel);
		if(edited > 0){
			redirectAttributes.addFlashAttribute("success", "1");
			redirectAttributes.addAttribute("id", practitionerModel.getId());
			return "redirect:/home/practitioner/medical";
		}
		model.addAttribute("id", practitionerModel.getId());
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(practitionerModel.getId()));
		return "practitioner/medical";
	}
	
	/**
	 * treatment action
	*/
	@RequestMapping(value = "/home/practitioner/treatment", method = RequestMethod.GET)
	public String treatmentAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "sp", required = false) BigInteger specialty,PractitionerTreatmentForm practitionerTreatmentForm,Model model){
		practitionerTreatmentForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		practitionerTreatmentForm.setPractitioner(id);
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));		
		if(specialty != null){
			model.addAttribute("treatmentList", hospitalPractitionerService.getTreatmentFormList(id,userService.getCurrentHealthcareprovider(),specialty));		
			model.addAttribute("selectedTreatmentList", hospitalPractitionerService.getPractitionerTreatmentFormList(id,userService.getCurrentHealthcareprovider(),specialty));
		}
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(id));	
		return "practitioner/treatment";
	}
	
	/**
	 * treatment action
	*/
	@RequestMapping(value = "/home/practitioner/treatment", method = RequestMethod.POST)
	public String treatmentPostAction(@Valid PractitionerTreatmentForm practitionerTreatmentForm,RedirectAttributes redirectAttributes,Model model){
		Boolean result = hospitalPractitionerService.editPractitionerTreatment(practitionerTreatmentForm);
		if(result){
			redirectAttributes.addFlashAttribute("success", "1");
			redirectAttributes.addAttribute("id", practitionerTreatmentForm.getPractitioner());
			redirectAttributes.addAttribute("sp", practitionerTreatmentForm.getPractitionerSpecialty());
			return "redirect:/home/practitioner/treatment";
		}else{
			redirectAttributes.addFlashAttribute("error", "1");
			redirectAttributes.addAttribute("id", practitionerTreatmentForm.getPractitioner());
			redirectAttributes.addAttribute("sp", practitionerTreatmentForm.getPractitionerSpecialty());
			return "redirect:/home/practitioner/treatment";		
		}		
	}
	
	/**
	 * method action
	*/
	@RequestMapping(value = "/home/practitioner/method", method = RequestMethod.GET)
	public String methodAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "sp", required = false) BigInteger specialty,@RequestParam(value = "t", required = false) BigInteger treatment,PractitionerMethodForm practitionerMethodForm,Model model){
		practitionerMethodForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		practitionerMethodForm.setPractitioner(id);
		practitionerMethodForm.setPractitionerMethodFormModel(hospitalPractitionerService.getPractitionerMethodFormModel(null,null,userService.getCurrentHealthcareprovider(),id));
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));		
		if(specialty != null){					
			model.addAttribute("selectedTreatmentList", hospitalPractitionerService.getPractitionerTreatmentFormList(id,userService.getCurrentHealthcareprovider(),specialty));
		}
		if(treatment != null){
			practitionerMethodForm.setPractitionerMethodFormModel(hospitalPractitionerService.getPractitionerMethodFormModel(specialty,treatment,userService.getCurrentHealthcareprovider(),id));
		}
		model.addAttribute("methodList", hospitalPractitionerService.getAllMethod());
		model.addAttribute("currencyList", hospitalPractitionerService.getAllCurrency());
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(id));		
		return "practitioner/method";
	}
	
	/**
	 * method action
	*/
	@RequestMapping(value = "/home/practitioner/method", method = RequestMethod.POST)
	public String methodPostAction(@Valid PractitionerMethodForm practitionerMethodForm,BindingResult results,RedirectAttributes redirectAttributes,Model model){
		if(results.hasErrors()){			
			logger.info("error found during submit hospitality form = {}",results.getErrorCount());
			redirectAttributes.addFlashAttribute("error", "1");
			redirectAttributes.addAttribute("id", practitionerMethodForm.getPractitioner());
			redirectAttributes.addAttribute("sp", practitionerMethodForm.getSpecialty());
			redirectAttributes.addAttribute("t", practitionerMethodForm.getTreatment());
			return "redirect:/home/practitioner/method";		
		}else{
			Boolean result = hospitalPractitionerService.editPractitionerMethod(practitionerMethodForm);
			if(result){
				redirectAttributes.addFlashAttribute("success", "1");
				redirectAttributes.addAttribute("id", practitionerMethodForm.getPractitioner());
				redirectAttributes.addAttribute("sp", practitionerMethodForm.getSpecialty());
				redirectAttributes.addAttribute("t", practitionerMethodForm.getTreatment());
				return "redirect:/home/practitioner/method";
			}else{
				redirectAttributes.addFlashAttribute("error", "1");
				redirectAttributes.addAttribute("id", practitionerMethodForm.getPractitioner());
				redirectAttributes.addAttribute("sp", practitionerMethodForm.getSpecialty());
				redirectAttributes.addAttribute("t", practitionerMethodForm.getTreatment());
				return "redirect:/home/practitioner/method";		
			}		
		}
	}
	
	/**
	 * language action
	*/
	@RequestMapping(value = "/home/practitioner/language", method = RequestMethod.GET)
	public String languageAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerLanguageForm practitionerLanguageForm,Model model) {
		practitionerLanguageForm.setPractitioner(id);
		practitionerLanguageForm.setPractitionerLanguageFormModel(hospitalPractitionerService.getPractitionerLanguageFormModel(id));
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(id));
		return "practitioner/language";
	}
	
	/**
	 * language post action
	*/
	@RequestMapping(value = "/home/practitioner/language", method = RequestMethod.POST)
	public String languagePostAction(@Valid PractitionerLanguageForm practitionerLanguageForm,RedirectAttributes redirectAttributes,Model model) {		
		Boolean edited = hospitalPractitionerService.editPractitionerLanguage(practitionerLanguageForm);		
		if(edited){			
				redirectAttributes.addFlashAttribute("success", "1");
				redirectAttributes.addAttribute("id", practitionerLanguageForm.getPractitioner());
				return "redirect:/home/practitioner/language";
		}		
		practitionerLanguageForm.setPractitionerLanguageFormModel(hospitalPractitionerService.getPractitionerLanguageFormModel(practitionerLanguageForm.getPractitioner()));
		model.addAttribute("id", practitionerLanguageForm.getPractitioner());
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(practitionerLanguageForm.getPractitioner()));
		return "practitioner/language";
	}
	
	/**
	 * attestation action
	*/
	@RequestMapping(value = "/home/practitioner/attestation", method = RequestMethod.GET)
	public String attestationAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerAttestationsForm practitionerAttestationsForm,Model model) {
		practitionerAttestationsForm.setPractitioner(id);
		practitionerAttestationsForm.setPractitionerAttestationsFormModel(hospitalPractitionerService.getPractitionerAttestationsFormModel(id));
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(id));
		return "practitioner/attestation";
	}
	
	/**
	 * attestation post action
	*/
	@RequestMapping(value = "/home/practitioner/attestation", method = RequestMethod.POST)
	public String attestationPostAction(@Valid PractitionerAttestationsForm practitionerAttestationsForm,RedirectAttributes redirectAttributes,Model model) {		
		Boolean edited = hospitalPractitionerService.editPractitionerAttestations(practitionerAttestationsForm);		
		if(edited){			
				redirectAttributes.addFlashAttribute("success", "1");
				redirectAttributes.addAttribute("id", practitionerAttestationsForm.getPractitioner());
				return "redirect:/home/practitioner/attestation";
		}		
		practitionerAttestationsForm.setPractitionerAttestationsFormModel(hospitalPractitionerService.getPractitionerAttestationsFormModel(practitionerAttestationsForm.getPractitioner()));
		model.addAttribute("id", practitionerAttestationsForm.getPractitioner());
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(practitionerAttestationsForm.getPractitioner()));
		return "practitioner/attestation";
	}
	
	/**
	 * stats action
	*/
	@RequestMapping(value = "/home/practitioner/stats", method = RequestMethod.GET)
	public String statsAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "sp", required = false) BigInteger specialty,@RequestParam(value = "t", required = false) BigInteger treatment,@RequestParam(value = "m", required = false) BigInteger method,PractitionerStatsForm practitionerStatsForm,Model model) {
		practitionerStatsForm.setPractitioner(id);
		practitionerStatsForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		practitionerStatsForm.setPractitionerStatsFormModel(hospitalPractitionerService.getPractitionerStatsFormModelList(null,null,null,id,userService.getCurrentHealthcareprovider()));
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));		
		if(specialty != null){					
			model.addAttribute("selectedTreatmentList", hospitalPractitionerService.getPractitionerTreatmentFormList(id,userService.getCurrentHealthcareprovider(),specialty));
		}
		if(treatment != null){
			model.addAttribute("selectedMethodList", hospitalPractitionerService.getPractitionerMethodFormList(id, userService.getCurrentHealthcareprovider(), specialty, treatment));
		}
		if(specialty != null && treatment != null && method != null){
			practitionerStatsForm.setPractitionerStatsFormModel(hospitalPractitionerService.getPractitionerStatsFormModelList(specialty,treatment,method,id,userService.getCurrentHealthcareprovider()));			
		}
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerById(id));
		return "practitioner/stats";
	}
	
	/**
	 * stats action
	*/
	@RequestMapping(value = "/home/practitioner/stats", method = RequestMethod.POST)
	public String statsPostAction(@Valid PractitionerStatsForm practitionerStatsForm,RedirectAttributes redirectAttributes,Model model) {		
		Boolean edited = hospitalPractitionerService.editHospitalSpecialtyTreatmentMethodPractitionerStat(practitionerStatsForm);
		redirectAttributes.addAttribute("id", practitionerStatsForm.getPractitioner());
		redirectAttributes.addAttribute("sp", practitionerStatsForm.getSpecialty());
		redirectAttributes.addAttribute("t", practitionerStatsForm.getTreatment());
		redirectAttributes.addAttribute("m", practitionerStatsForm.getMethod());
		if(edited){
			redirectAttributes.addFlashAttribute("success", "1");			
			return "redirect:/home/practitioner/stats";
		}else{
			redirectAttributes.addFlashAttribute("error", "1");
			return "redirect:/home/practitioner/stats";
		}
	}
	
	@RequestMapping(value = "/home/practitioner/photo", method = RequestMethod.GET)
	public String photoAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerPhotoForm practitionerPhotoForm,Model model) {
		practitionerPhotoForm.setId(id);
		model.addAttribute("success", 0);
		return "practitioner/photo";
	}
	
	@RequestMapping(value = "/home/practitioner/photo", method = RequestMethod.POST)
	public String photoAction(@Valid PractitionerPhotoForm practitionerPhotoForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,@RequestParam(value ="file",required = false) MultipartFile file,MultipartHttpServletRequest request,Model model) {
		model.addAttribute("success", 0);
		if (bindingResult.hasErrors()) {    		  
	  	      logger.error("Got {} errors during save practitioner photo", bindingResult.getErrorCount());  	    
	  	      return "practitioner/photo";
		}		
		if(!file.isEmpty() && practitionerPhotoForm.getId() != null){
			  try{
				  String filename = file.getOriginalFilename();
				  File f = new File("/tmp/" +file.getOriginalFilename());
				  file.transferTo(f);				  			  
				  PractitionerModel practitionerModel = hospitalPractitionerService.getPractitionerById(practitionerPhotoForm.getId());
				  practitionerModel.setPhoto(filename);
				  BigInteger edited = hospitalPractitionerService.editPractitioner(practitionerModel);
				  logger.info("practitioner id {}",edited);
				  if(practitionerPhotoForm.getId().equals(edited)){
					  model.addAttribute("success", 1);
					  model.addAttribute("path", practitionerModel.getPhoto());					  				  
				  }
			  }catch(Exception ex){
				logger.info(ex.getMessage());  
			  }  
	  	}	
		return "practitioner/photo";
	}
	
	@RequestMapping(value = "/home/practitioner/delete", method = RequestMethod.GET)
	public String deleteAction(@RequestParam(value = "id", required = true) BigInteger id,RedirectAttributes redirectAttributes) {
		if(id != null){
			HospitalSpecialtyTreatmentMethodPractitionerModel model = hospitalPractitionerService.getHospitalSpecialtyTreatmentMethodPractitionerById(id);
			if(model.getId() != null){
				model.setActive(false);
				hospitalPractitionerService.setHospitalSpecialtyTreatmentMethodPractitioner(model);
				return "redirect:/home/practitioner";
			}
		}
		return "practitioner/index";
	} 
}