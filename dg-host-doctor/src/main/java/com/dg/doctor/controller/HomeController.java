package com.dg.doctor.controller;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.doctor.form.PostMessageForm;
import com.dg.doctor.model.PatientCaseBookingModel;
import com.dg.doctor.model.PatientDetailModel;
import com.dg.doctor.model.PractitionerModel;
import com.dg.doctor.model.UserModel;
import com.dg.doctor.service.PractitionerService;
import com.dg.doctor.service.UserService;

@Controller
public class HomeController{

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);	
	
	@Autowired
	private PractitionerService practitionerService;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("userImage")
	public String getUserImage(){		
		 if(userService.isLoggedIn()){
			 PractitionerModel model = practitionerService.getPractitioner(userService.getCurrentUserId());
			 return "/tmp/practitioner/"+model.getId()+"/photo/"+model.getPhoto();
		 }
		 return null;
	}	
	
	@ModelAttribute("userName")
	public String getUserName(){		
		 if(userService.isLoggedIn()){
			 PractitionerModel model = practitionerService.getPractitioner(userService.getCurrentUserId());
			 return model.getFirstName()+" "+model.getLastName();
		 }
		 return null;
	}	
	
	@RequestMapping(value = "/home/index", method = RequestMethod.GET)
	public String home(Model model) {
		 List<PatientDetailModel> patientModelList = null;
		 List<PatientDetailModel> patientFileList = new ArrayList<PatientDetailModel>();
		 List<PatientDetailModel> patientMessageList = new ArrayList<PatientDetailModel>();
		 List<PatientDetailModel> patientConferenceList = new ArrayList<PatientDetailModel>();
		 List<PatientDetailModel> patientList = new ArrayList<PatientDetailModel>();
		 Set<BigInteger> result = new HashSet<BigInteger>();		
		 Set<BigInteger> result1 = new HashSet<BigInteger>();
		 Set<BigInteger> result2 = new HashSet<BigInteger>();
		 Set<BigInteger> result3 = new HashSet<BigInteger>();		 
		 Integer totalNewMessages = 0;
		 Integer totalScheduledCalls = 0;
		 Integer totalWeekCalls = 0;
		 
		 if(userService.isLoggedIn()){
			 patientModelList = practitionerService.getPatientDetail(userService.getCurrentUserId());
			 if(!patientModelList.isEmpty()){
				 for(PatientDetailModel p: patientModelList){					
					    if(result.add(p.getPatientcasefileId())&& p.getPatientcasefileId() !=null){
		    				patientFileList.add(p);
		    			}			    		
		    			if(result1.add(p.getPcmId()) && p.getPcmId() !=null && (p.getSender() == userService.getCurrentUserId().intValue() || p.getReceiver() == userService.getCurrentUserId().intValue() )){
		    				patientMessageList.add(p);
		    			}
		    			if(result2.add(p.getPatientconferenceId()) && p.getPatientconferenceId() !=null){
		    				patientConferenceList.add(p);
		    			}
		    			if(result3.add(p.getPatientcaseId())){
		    				patientList.add(p);
		    			} 					 
	    		 }
				 
				 for(PatientDetailModel patient: patientList){
		    			Integer totalFiles = 0;		    			
		    			Integer totalMessages = 0;		    			
		    			Integer newMessages = 0;
		    			for(PatientDetailModel pfl: patientFileList){		    					
		    				if(patient.getPatientcaseId().equals(pfl.getPatientcaseId())){
		    					totalFiles+=1;
		    					patient.setTotalFiles(totalFiles);
		    				}
		    			}
		    			for(PatientDetailModel pcm: patientMessageList){		    			
		    				if(patient.getPatientcaseId().equals(pcm.getPatientcaseId())){
		    					totalMessages+=1;
		    					patient.setTotalMessages(totalMessages);
		    					if(pcm.getPcmStatus().equalsIgnoreCase("open")){
		    						newMessages +=1;
		    						patient.setNewMessages(newMessages);
		    					}
		    				}
		    			}		    			
		    		}
		    		for(PatientDetailModel pcm: patientMessageList){
		    			if(pcm.getPcmStatus().equalsIgnoreCase("Open")){
		    			    totalNewMessages +=1;	
		    			}
		    		}
		    		for(PatientDetailModel pcl: patientConferenceList){
		    			if(!pcl.getConferenceDt().toString().equalsIgnoreCase("1970-01-01 00:00:00.0") && pcl.getPatientconferenceStatus().equalsIgnoreCase("Accepted")){
		    				totalScheduledCalls +=1;	
		    			}
		    			if(pcl.getWeekCall() >=1 && pcl.getWeekCall() <=7 && pcl.getPatientconferenceStatus().equalsIgnoreCase("Accepted")){
		    				totalWeekCalls +=1;
		    			}
		    		}
			 }
		 }
		 model.addAttribute("patientList", patientList);
		 model.addAttribute("totalDocuments",patientFileList.size());
		 model.addAttribute("totalNewMessages",totalNewMessages);
		 model.addAttribute("totalScheduledCalls",totalScheduledCalls);
		 model.addAttribute("totalWeekCalls",totalWeekCalls);
		 return "home/index"; 
	}
	
	@RequestMapping(value = "/home/view", method = RequestMethod.GET)
	public String view(@RequestParam(value = "pc", required = false) BigInteger pc,@RequestParam(value = "msg", required = false) Integer msg,Model model) {		
		Set<BigInteger> result = new HashSet<BigInteger>();
		Set<BigInteger> result1 = new HashSet<BigInteger>();
		Set<BigInteger> result2 = new HashSet<BigInteger>();
		Set<BigInteger> result3 = new HashSet<BigInteger>();
		Set<BigInteger> result4 = new HashSet<BigInteger>();
		List<PatientDetailModel> patientModelList = null;
		List<PatientDetailModel> patientList = new ArrayList<PatientDetailModel>();
		List<PatientDetailModel> patientCaseMessageList = new ArrayList<PatientDetailModel>();
		List<PatientDetailModel> patientFileList = new ArrayList<PatientDetailModel>();		
		List<PatientDetailModel> patientConferenceList = new ArrayList<PatientDetailModel>();
		List<PatientDetailModel> patientBookingList = new ArrayList<PatientDetailModel>();
		Integer totalNewMessages = 0;		
		Boolean found = false;
		TimeZone timeZone = null;
		String patientTimeZone = null;
		if(userService.isLoggedIn()){		    	
		    	if(pc != null){
		    		patientModelList = practitionerService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
		    		if(!patientModelList.isEmpty()){
			    		for(PatientDetailModel p: patientModelList){
			    			if(p.getCountryCode() != null){							
							    timeZone = practitionerService.getTimeZone(p.getCountryCode(), p.getCity());							    
							    patientTimeZone = practitionerService.getGMTFormatTimeZone(timeZone);
							    p.setPatientTimezone(patientTimeZone);								    
							}else{
								timeZone = TimeZone.getTimeZone("GMT 00:00");
								timeZone = practitionerService.getTimeZone(p.getCountryCode(), p.getCity());
								patientTimeZone = practitionerService.getGMTFormatTimeZone(timeZone);
							    p.setPatientTimezone(patientTimeZone);	
							}
			    			if(result.add(p.getId()) && p.getId() != null && p.getPractitioner().equals(userService.getCurrentUserId())){			    				
			    				patientList.add(p);
			    			}	
			    			if(result1.add(p.getPcmId()) && p.getPcmId() != null && (p.getSender() == userService.getCurrentUserId().intValue() || p.getReceiver() == userService.getCurrentUserId().intValue() )){
			    			    if(p.getSenderType().equalsIgnoreCase("Patient")){
			    			    	p.setPcmClass("patientarticle");
			    			    }			    			    
			    				patientCaseMessageList.add(p);
			    			}
			    			if(result2.add(p.getPatientcasefileId()) && p.getPatientcasefileId() != null){
			    				patientFileList.add(p);
			    			}
			    			if(result3.add(p.getPatientconferenceId()) && !p.getPatientconferenceStatus().equalsIgnoreCase("Delete")){			    				
								DateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy");
				    			String conferenceDate = dateFormat2.format(p.getConferenceDt());
				    			model.addAttribute("conferenceDate", conferenceDate);    							    			
				    			p.setPatientConferenceDate(practitionerService.getTimeZoneConvert(p.getConferenceDt(), p.getConferenceTimezone(), patientTimeZone, "MMM dd, yyyy"));
								p.setPatientConferenceTime(practitionerService.getTimeZoneConvert(p.getConferenceDt(), p.getConferenceTimezone(), patientTimeZone, "hh:mm a"));			    				   
								patientConferenceList.add(p);
			    			}
			    			if(result4.add(p.getBookingId()) && p.getBookingId() != null && !p.getBookingStatus().equalsIgnoreCase("Delete")){
			    				DateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy");				    			
				    			model.addAttribute("bookingDate", dateFormat2.format(p.getBookingDt()));    							    			
				    			p.setPatientBookingDate(practitionerService.getTimeZoneConvert(p.getBookingDt(), p.getBookingTimezone(), patientTimeZone, "MMM dd, yyyy"));
								p.setPatientBookingTime(practitionerService.getTimeZoneConvert(p.getBookingDt(), p.getBookingTimezone(), patientTimeZone, "hh:mm a"));								
			    				patientBookingList.add(p);
			    			}
			    		}
			    		
			    		for(PatientDetailModel pcm: patientCaseMessageList){
			    			if(pcm.getPcmStatus().equalsIgnoreCase("Open")){
			    			    totalNewMessages +=1;	
			    			}
			    			if(pcm.getPatientconferenceStatus().equalsIgnoreCase("Delete")){
			    				found = true;
			    			}
			    		}
			    		if(found){
			    			return "redirect:/home/index";
			    		}
		    		}else{
		    			return "redirect:/home/index";
		    		}
		    		
		    		if(msg == 1 && !patientCaseMessageList.isEmpty()){
		    			practitionerService.updatePatientCaseMessage(pc,userService.getCurrentUserId().intValue(),"Practitioner");		
		    		}
		    	}
		    	model.addAttribute("practitionerPhoto", userService.getPhoto());
		 }
		if(msg != null){
			model.addAttribute("msg",msg);			
		}
		
		model.addAttribute("patientList",patientList); 
		model.addAttribute("patientCaseMessageList",patientCaseMessageList);
		model.addAttribute("patientFileList",patientFileList);
		model.addAttribute("patientConferenceList",patientConferenceList);
		model.addAttribute("patientBookingList",patientBookingList);
		model.addAttribute("totalNewMessages",totalNewMessages);
		return "home/view"; 
	}	
}