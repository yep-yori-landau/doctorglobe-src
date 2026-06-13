package com.dg.doctor.controller;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

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

import com.dg.doctor.form.PatientConferenceForm;
import com.dg.doctor.model.PatientCaseBookingModel;
import com.dg.doctor.model.PatientDetailModel;
import com.dg.doctor.model.PatientModel;
import com.dg.doctor.model.PractitionerModel;
import com.dg.doctor.service.ScheduleService;
import com.dg.doctor.service.MailService;
import com.dg.doctor.service.UserService;

/**
 * 
 *
 */
@Controller
public class ScheduleController{
	
private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/home/schedule/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "pc", required = true) BigInteger pc,@RequestParam(value = "id", required = true) BigInteger id,PatientConferenceForm patientConferenceForm,Model model){
		List<PatientDetailModel> patientModelList = null;		
		List<PatientDetailModel> patientConferenceList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();
		TimeZone timeZone = null;	
		String patientTimeZone = null;		
		
		if(userService.isLoggedIn()){ 
			if(pc != null){
				patientModelList = scheduleService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
				if(!patientModelList.isEmpty()){
	    			for(PatientDetailModel p: patientModelList){			    				
	    				if(result.add(p.getPatientconferenceId()) && p.getPatientconferenceId() !=null && !p.getPatientconferenceStatus().equalsIgnoreCase("Delete")){
	    					patientConferenceList.add(p);
	    				}
	    			}
	    		}
				
				if(!patientConferenceList.isEmpty()){
					patientConferenceForm.setPatientcase(pc);
					for(PatientDetailModel p: patientConferenceList){
						if(p.getPatientconferenceId().equals(id)){
							patientConferenceForm.setId(p.getPatientconferenceId());
							patientConferenceForm.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
							patientConferenceForm.setReceiver(p.getId());
							patientConferenceForm.setStatus("Proposed");
							if(p.getCountryCode() != null){
								//logger.info("country {}",p.getCountryCode());
								//logger.info("city {}",p.getCity());
							    timeZone = scheduleService.getTimeZone(p.getCountryCode(), p.getCity());
							    //logger.info("TimeZone {}",timeZone);
							    patientTimeZone = scheduleService.getGMTFormatTimeZone(timeZone);
							    model.addAttribute("patientTimeZone", patientTimeZone);
							}else{
								timeZone = TimeZone.getTimeZone("GMT 00:00");
								patientTimeZone = scheduleService.getGMTFormatTimeZone(timeZone);
								model.addAttribute("patientTimeZone", patientTimeZone);
							}
							patientConferenceForm.setTimezone(p.getConferenceTimezone());
							if(!p.getConferenceDt().toString().equalsIgnoreCase("1970-01-01 00:00:00.0")){
								DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
								DateFormat dateFormat1 = new SimpleDateFormat("hh:mm a");
								DateFormat dateFormat2 = new SimpleDateFormat("EEEE dd MMMM yyyy");
								patientConferenceForm.setConferenceDt(dateFormat.format(p.getConferenceDt()));
								patientConferenceForm.setTime(dateFormat1.format(p.getConferenceDt()));
								patientConferenceForm.setSubject("Reschedule Conference Call");
								model.addAttribute("schedule", 0);
								model.addAttribute("conferenceDate",dateFormat2.format(p.getConferenceDt()));
								model.addAttribute("conferenceTime",dateFormat1.format(p.getConferenceDt()));																
								String practitionerTimeZone = scheduleService.getPractitionerTimeZone(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());								
								patientConferenceForm.setTimezone(practitionerTimeZone);								
								model.addAttribute("practitionerTimeZone", practitionerTimeZone);
								if(!p.getConferenceTimezone().equalsIgnoreCase(patientTimeZone)){									
									model.addAttribute("patientConferenceDate",scheduleService.getTimeZoneConvert(p.getConferenceDt(), p.getConferenceTimezone(), patientTimeZone, "EEEE dd MMMM yyyy"));
									model.addAttribute("patientConferenceTime",scheduleService.getTimeZoneConvert(p.getConferenceDt(), p.getConferenceTimezone(), patientTimeZone, "hh:mm a"));	 
								}else{
									model.addAttribute("patientConferenceDate",dateFormat2.format(p.getConferenceDt()));
									model.addAttribute("patientConferenceTime",dateFormat1.format(p.getConferenceDt()));
								}
							}else{
								patientConferenceForm.setSubject("Schedule Conference Call");							
								model.addAttribute("schedule", 1);					
							}									
							model.addAttribute("patientname", p.getName());
							model.addAttribute("timezone",p.getConferenceTimezone());
							model.addAttribute("procedureFound", false);
			    			if(scheduleService.getIsProcedureExist(p.getId(),p.getTreatment(),p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner())){
			    				model.addAttribute("procedureFound", true);
			    			}							
						}
					}
				}
			}
		}		
		model.addAttribute("patientConferenceForm", patientConferenceForm);
		return "schedule/edit";
	}
	
	@RequestMapping(value = "/home/schedule/edit", method = RequestMethod.POST)
	public String edit(@Valid PatientConferenceForm patientConferenceForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
		PatientModel pm = scheduleService.getPatient(patientConferenceForm.getReceiver());
		model.addAttribute("patientname", pm.getFirstName()+" "+pm.getLastName());
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during schedule conference call",
					bindingResult.getErrorCount());
			model.addAttribute("error", 1);
			return "schedule/edit";
		} 		
		if(patientConferenceForm.getPatientcase() != null){
			try{	
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				DateFormat dateFormat1 = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
				String conferenceDate = patientConferenceForm.getConferenceDt() + " " + patientConferenceForm.getTime();				
				Date date = dateFormat1.parse(conferenceDate);			
				patientConferenceForm.setConferenceDt(dateFormat.format(date));
				Boolean edited = scheduleService.edit(patientConferenceForm);
				if(edited){				
	    	        PractitionerModel practitioner = scheduleService.getPractitioner(userService.getCurrentUserId());
	    	        if(pm.getId() != null){
	    	        	mailService.sendMail(pm.getEmail(), "Schedule Conference", patientConferenceForm.getBody().replaceAll(System.getProperty("line.separator"), "<br/>"), "conference.html", conferenceDate, pm.getFirstName() + " "+ pm.getLastName(),practitioner.getFirstName() + " "+ practitioner.getLastName(),patientConferenceForm.getPatientcase().intValue(),true,false);
	    	        }
	    	        redirectAttributes.addFlashAttribute("message", "1");
	    			redirectAttributes.addAttribute("pc", patientConferenceForm.getPatientcase());			    			
	    			redirectAttributes.addAttribute("id", patientConferenceForm.getId());
	    			return "redirect:/home/schedule/edit";
				}
			}catch(Exception ex){
				logger.info("Date error :{}",ex.getMessage());
			}
		}
		model.addAttribute("patientConferenceForm", patientConferenceForm);
		return "schedule/edit";
	}
	
	@RequestMapping(value = "/home/schedule/cancel", method = RequestMethod.GET)
	public String cancel(@RequestParam(value = "pc", required = false) BigInteger pc,@RequestParam(value = "id", required = true) BigInteger id,PatientConferenceForm patientConferenceForm,Model model){
		List<PatientDetailModel> patientModelList = null;		
		List<PatientDetailModel> patientConferenceList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();		
		if(userService.isLoggedIn()){ 
			if(pc != null){
				patientModelList = scheduleService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
				if(!patientModelList.isEmpty()){
	    			for(PatientDetailModel p: patientModelList){			    				
	    				if(result.add(p.getPatientconferenceId()) && p.getPatientconferenceId() !=null && !p.getPatientconferenceStatus().equalsIgnoreCase("Delete")){
	    					patientConferenceList.add(p);
	    				}
	    			}
	    		}
				
				if(!patientConferenceList.isEmpty()){
					patientConferenceForm.setPatientcase(pc);
					for(PatientDetailModel p: patientConferenceList){
						if(p.getPatientconferenceId().equals(id)){
							patientConferenceForm.setId(p.getPatientconferenceId());
							patientConferenceForm.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
							patientConferenceForm.setReceiver(p.getId());						
							patientConferenceForm.setStatus("Rejected");
							patientConferenceForm.setTimezone(p.getConferenceTimezone());
							patientConferenceForm.setConferenceDt(p.getConferenceDt().toString());
							patientConferenceForm.setTime(p.getConferenceDt().toString());
							patientConferenceForm.setSubject("Cancel Conference Call");			
							patientConferenceForm.setBody("Cancel Conference Call");
							model.addAttribute("patientname", p.getName());
							model.addAttribute("procedureFound", false);
			    			if(scheduleService.getIsProcedureExist(p.getId(),p.getTreatment(),p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner())){
			    				model.addAttribute("procedureFound", true);
			    			}
						}
					}
				}
			}
		}
		model.addAttribute("patientConferenceForm", patientConferenceForm);
		return "schedule/cancel";
	}
	
	@RequestMapping(value = "/home/schedule/cancel", method = RequestMethod.POST)
	public String cancel(@Valid PatientConferenceForm patientConferenceForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
		PatientModel pm = scheduleService.getPatient(patientConferenceForm.getReceiver());
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during schedule conference call cancel",
					bindingResult.getErrorCount());
			model.addAttribute("error", 1);
			return "schedule/cancel";
		} 		
		if(patientConferenceForm.getPatientcase() != null){
			Boolean edited = scheduleService.edit(patientConferenceForm);
			if(edited){				
    	        PractitionerModel practitioner = scheduleService.getPractitioner(userService.getCurrentUserId());
    	        if(pm.getId() != null){
    	        	mailService.sendMail(pm.getEmail(), "Cancel Conference Call", patientConferenceForm.getBody(), "conference.html", null, pm.getFirstName() + " "+ pm.getLastName(),practitioner.getFirstName() + " "+ practitioner.getLastName(),patientConferenceForm.getPatientcase().intValue(),true,false);
    	        }
    	        redirectAttributes.addFlashAttribute("message", "1");
    			redirectAttributes.addAttribute("pc", patientConferenceForm.getPatientcase());			    			
    			redirectAttributes.addAttribute("id", patientConferenceForm.getId());
    			return "redirect:/home/schedule/cancel";
			}
		}
		model.addAttribute("patientname", pm.getFirstName()+" "+pm.getLastName());
		model.addAttribute("patientConferenceForm", patientConferenceForm);
		return "schedule/cancel";
	}
	
	@RequestMapping(value = "/home/schedule/view", method = RequestMethod.GET)
	public String view(@RequestParam(value = "pc", required = false) BigInteger pc,Model model){
		List<PatientDetailModel> patientModelList = null;		
		List<PatientDetailModel> patientConferenceList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();
		TimeZone timeZone = null;
		String patientTimeZone = null;
		if(userService.isLoggedIn()){ 
			if(pc != null){
				patientModelList = scheduleService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
				if(!patientModelList.isEmpty()){
	    			for(PatientDetailModel p: patientModelList){			    				
	    				if(result.add(p.getPatientconferenceId()) && p.getPatientconferenceId() !=null && !p.getPatientconferenceStatus().equalsIgnoreCase("Delete")){
	    					if(p.getCountryCode() != null){								
							    timeZone = scheduleService.getTimeZone(p.getCountryCode(), p.getCity());
							    patientTimeZone = scheduleService.getGMTFormatTimeZone(timeZone);
							    p.setPatientTimezone(patientTimeZone);							    
							}else{
								timeZone = TimeZone.getTimeZone("GMT 00:00");
								patientTimeZone = scheduleService.getGMTFormatTimeZone(timeZone);
								p.setPatientTimezone(patientTimeZone);
							}	    					
							DateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy");													
			    			String conferenceDate = dateFormat2.format(p.getConferenceDt());			    			
			    			model.addAttribute("conferenceDate", conferenceDate);    				 
							p.setPatientConferenceDate(scheduleService.getTimeZoneConvert(p.getConferenceDt(), p.getConferenceTimezone(), patientTimeZone, "MMM dd, yyyy"));
							p.setPatientConferenceTime(scheduleService.getTimeZoneConvert(p.getConferenceDt(), p.getConferenceTimezone(), patientTimeZone, "hh:mm a"));							
	    					patientConferenceList.add(p);
	    				}
	    			}
	    		}
			}
		}
		model.addAttribute("patientConferenceList", patientConferenceList);
		return "schedule/view";
	}
	
	@RequestMapping(value = "/home/schedule/add", method = RequestMethod.GET)
	public String add(@RequestParam(value = "pc", required = false) BigInteger pc,PatientConferenceForm patientConferenceForm,Model model){
		List<PatientDetailModel> patientModelList = null;		
		List<PatientDetailModel> patientConferenceList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();		
		BigInteger hstmp;		
		
		if(userService.isLoggedIn()){ 
			if(pc != null){
				patientModelList = scheduleService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
				
				if(!patientModelList.isEmpty()){
	    			for(PatientDetailModel p: patientModelList){			    				
	    				if(result.add(p.getPatientconferenceId()) && p.getPatientconferenceId() !=null && !p.getPatientconferenceStatus().equalsIgnoreCase("Delete")){
	    					patientConferenceList.add(p);
	    				}
	    			}
	    		}
				
				if(!patientConferenceList.isEmpty()){
					patientConferenceForm.setPatientcase(pc);
					for(PatientDetailModel p: patientConferenceList){				
						if(p.getConferenceDt().toString().equalsIgnoreCase("1970-01-01 00:00:00.0")){
							patientConferenceForm.setId(p.getPatientconferenceId());
						}
						if(p.getCountryCode() != null){							
						    TimeZone timeZone = scheduleService.getTimeZone(p.getCountryCode(), p.getCity());								    
						    model.addAttribute("patientTimeZone", scheduleService.getGMTFormatTimeZone(timeZone));
						}else{
							TimeZone timeZone = TimeZone.getTimeZone("GMT 00:00");
							model.addAttribute("patientTimeZone", scheduleService.getGMTFormatTimeZone(timeZone));
						}
						patientConferenceForm.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
						patientConferenceForm.setReceiver(p.getId());
						patientConferenceForm.setStatus("Proposed");						
						patientConferenceForm.setSubject("Schedule Conference Call");
						DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");	
						patientConferenceForm.setConferenceDt(dateFormat.format(new Date()));
						String practitionerTimeZone = scheduleService.getPractitionerTimeZone(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());								
						patientConferenceForm.setTimezone(practitionerTimeZone);						
						model.addAttribute("practitionerTimeZone", practitionerTimeZone);
						model.addAttribute("schedule", 1);					
						model.addAttribute("patientname", p.getName());
						model.addAttribute("timezone",p.getConferenceTimezone());						
		    			hstmp = p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner();
		    			model.addAttribute("procedureFound", false);
		    			if(scheduleService.getIsProcedureExist(p.getId(),p.getTreatment(),hstmp)){
		    				model.addAttribute("procedureFound", true);
		    			}
					}
				}
			}
		}		
		model.addAttribute("patientConferenceForm", patientConferenceForm);
		return "schedule/add";
	}
	
	@RequestMapping(value = "/home/schedule/add", method = RequestMethod.POST)
	public String add(@Valid PatientConferenceForm patientConferenceForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
		PatientModel pm = scheduleService.getPatient(patientConferenceForm.getReceiver());
		model.addAttribute("patientname", pm.getFirstName()+" "+pm.getLastName());
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during schedule conference call",
					bindingResult.getAllErrors());			
			return "schedule/add";
		} 		
		if(patientConferenceForm.getPatientcase() != null){
			try{	
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				DateFormat dateFormat1 = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
				String conferenceDate = patientConferenceForm.getConferenceDt() + " " + patientConferenceForm.getTime();				
				Date date = dateFormat1.parse(conferenceDate);								
				patientConferenceForm.setConferenceDt(dateFormat.format(date));				
				Boolean edited = scheduleService.edit(patientConferenceForm);
				if(edited){				
	    	        PractitionerModel practitioner = scheduleService.getPractitioner(userService.getCurrentUserId());
	    	        if(pm.getId() != null){
	    	        	mailService.sendMail(pm.getEmail(), "Schedule Conference", patientConferenceForm.getBody().replaceAll(System.getProperty("line.separator"), "<br/>"), "conference.html", conferenceDate, pm.getFirstName() + " "+ pm.getLastName(),practitioner.getFirstName() + " "+ practitioner.getLastName(),patientConferenceForm.getPatientcase().intValue(),true,false);
	    	        }
	    	        redirectAttributes.addFlashAttribute("message", "1");
	    			redirectAttributes.addAttribute("pc", patientConferenceForm.getPatientcase());			    			
	    			return "redirect:/home/schedule/add";
				}
			}catch(Exception ex){
				logger.info("Date error :{}",ex.getMessage());
			}
		}
		model.addAttribute("patientConferenceForm", patientConferenceForm);
		return "schedule/add";
	}	
}