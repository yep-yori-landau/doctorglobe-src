package com.dg.doctor.controller;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

import com.dg.doctor.form.CancelForm;
import com.dg.doctor.form.PatientBookingForm;
import com.dg.doctor.model.PatientDetailModel;
import com.dg.doctor.model.PatientModel;
import com.dg.doctor.model.PractitionerModel;
import com.dg.doctor.service.MailService;
import com.dg.doctor.service.BookingService;
import com.dg.doctor.service.UserService;

/**
 * 
 * Handles requests for the application booking procedure page.
 *
 */
@Controller
public class BookingController{
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	/**
	 * 
	 * @param pc
	 * @param patientBookingForm
	 * @param model
	 * @action booking edit get method
	 */
	@RequestMapping(value = "/home/booking/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "pc", required = false) BigInteger pc,PatientBookingForm patientBookingForm,Model model){
		List<PatientDetailModel> patientModelList = null;		
		List<PatientDetailModel> patientConferenceList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();		
		String patientTimeZone = null;
		TimeZone timeZone = null;
		model.addAttribute("procedureFound", false);
		if(userService.isLoggedIn()){ 
			if(pc != null){
			    		patientModelList = bookingService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
			    		if(!patientModelList.isEmpty()){
			    			for(PatientDetailModel p: patientModelList){			    				
			    				if(result.add(p.getPatientconferenceId()) && p.getPatientconferenceId() !=null && !p.getPatientconferenceStatus().equalsIgnoreCase("Delete")){
			    					patientConferenceList.add(p);
			    				}
			    			}
			    		}
			    		if(!patientConferenceList.isEmpty()){			
							patientBookingForm.setPatientcase(pc);
							for(PatientDetailModel p: patientConferenceList){
								if(p.getCountryCode() != null){								
								    timeZone = bookingService.getTimeZone(p.getCountryCode(), p.getCity());								    								    
								    patientTimeZone = bookingService.getGMTFormatTimeZone(timeZone);
								    model.addAttribute("patientTimeZone", patientTimeZone);
								}else{
									timeZone = TimeZone.getTimeZone("GMT 00:00");
									patientTimeZone = bookingService.getGMTFormatTimeZone(timeZone);
								    model.addAttribute("patientTimeZone", patientTimeZone);
								}
								if(p.getBookingId() != null){
									patientBookingForm.setId(p.getBookingId());								
									patientBookingForm.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
									patientBookingForm.setReceiver(p.getId());
									patientBookingForm.setStatus("Open");
									//patientBookingForm.setTimezone(p.getBookingTimezone());
									if(!p.getBookingDt().toString().equalsIgnoreCase("1970-01-01 00:00:00.0") && !p.getBookingStatus().equalsIgnoreCase("Delete")){
										DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
										DateFormat dateFormat1 = new SimpleDateFormat("hh:mm a");
										DateFormat dateFormat2 = new SimpleDateFormat("EEEE dd MMMM yyyy");
										patientBookingForm.setBookingDt(dateFormat.format(p.getBookingDt()));
										patientBookingForm.setTime(dateFormat1.format(p.getBookingDt()));
										model.addAttribute("schedule", 0);
										patientBookingForm.setSubject("Rescheduled Procedure Book");
										model.addAttribute("bookingDate",dateFormat2.format(p.getBookingDt()));
										model.addAttribute("bookingTime",dateFormat1.format(p.getBookingDt()));
										String practitionerTimeZone = bookingService.getPractitionerTimeZone(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());								
										patientBookingForm.setTimezone(practitionerTimeZone);								
										model.addAttribute("practitionerTimeZone", practitionerTimeZone);
										logger.info("patienttimezone {}",p.getBookingTimezone());
										if(!p.getBookingTimezone().equalsIgnoreCase(patientTimeZone)){									
											model.addAttribute("patientBookingDate",bookingService.getTimeZoneConvert(p.getBookingDt(), p.getBookingTimezone(), patientTimeZone, "EEEE dd MMMM yyyy"));
											model.addAttribute("patientBookingTime",bookingService.getTimeZoneConvert(p.getBookingDt(), p.getBookingTimezone(), patientTimeZone, "hh:mm a"));	 
										}else{
											model.addAttribute("patientBookingDate",dateFormat2.format(p.getBookingDt()));
											model.addAttribute("patientBookingTime",dateFormat1.format(p.getBookingDt()));
										}
									}else{
										DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
										patientBookingForm.setBookingDt(dateFormat.format(new Date()));
										model.addAttribute("schedule", 1);
										patientBookingForm.setSubject("Scheduled Procedure Book");
									}								
								}else{
									patientBookingForm.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
									patientBookingForm.setReceiver(p.getId());
									patientBookingForm.setStatus("Open");
									model.addAttribute("schedule", 1);
									patientBookingForm.setSubject("Scheduled Procedure Book");
								}
								String practitionerTimeZone = bookingService.getPractitionerTimeZone(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());								
								patientBookingForm.setTimezone(practitionerTimeZone);						
								model.addAttribute("practitionerTimeZone", practitionerTimeZone);
								model.addAttribute("patientname", p.getName());
								model.addAttribute("timezone",p.getConferenceTimezone());						
								
				    			if(bookingService.getIsProcedureExist(p.getId(),p.getTreatment(),p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner())){
				    				model.addAttribute("procedureFound", true);
				    			}
							}							
						}	
			}				
		}
		model.addAttribute("patientBookingForm", patientBookingForm);
		return "booking/edit";
	}
	
	@RequestMapping(value = "/home/booking/edit", method = RequestMethod.POST)
	public String edit(@Valid PatientBookingForm patientBookingForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){		 
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during schedule procedure",
					bindingResult.getErrorCount());
			model.addAttribute("error", 1);
			return "booking/edit";
		} 		
		if(patientBookingForm.getPatientcase() != null){
			try{
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				DateFormat dateFormat1 = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
				String bookingDate = patientBookingForm.getBookingDt() + " " + patientBookingForm.getTime();
				Date date = dateFormat1.parse(bookingDate);				
				patientBookingForm.setBookingDt(dateFormat.format(date));				
				logger.info("Booking Date ={}",patientBookingForm.getBookingDt());
				patientBookingForm.setBookingDt(dateFormat.format(date));
				Boolean edited = bookingService.edit(patientBookingForm);
				if(edited){				
	    			PatientModel pm = bookingService.getPatient(patientBookingForm.getReceiver());
	    			PractitionerModel practitioner = bookingService.getPractitioner(userService.getCurrentUserId());
	    			if(pm.getId() != null){
	    				mailService.sendMail(pm.getEmail(), patientBookingForm.getSubject(), patientBookingForm.getBody().replaceAll(System.getProperty("line.separator"), "<br/>"), "conference.html", bookingDate, pm.getFirstName() + " "+ pm.getLastName(),practitioner.getFirstName()+" "+practitioner.getLastName(),patientBookingForm.getPatientcase().intValue(),true,false);
	    				logger.info("Procedure Booked Mail Sent successfully to Patient {}",pm.getId());
	    			}
					redirectAttributes.addFlashAttribute("message", "1");
	    			redirectAttributes.addAttribute("pc", patientBookingForm.getPatientcase());
	    			return "redirect:/home/booking/edit";
				}
			}catch(Exception ex){
				logger.info("Date error found :{}",ex.getMessage());
			}
		}
		model.addAttribute("patientBookingForm", patientBookingForm);
		return "booking/edit";
	}
	
	/**
	 * 
	 * @param pc
	 * @param patientBookingForm
	 * @param model
	 * @action booking edit get method
	 */
	@RequestMapping(value = "/home/booking/cancel", method = RequestMethod.GET)
	public String cancel(@RequestParam(value = "pc", required = false) BigInteger pc,PatientBookingForm patientBookingForm,Model model){
		List<PatientDetailModel> patientModelList = null;		
		List<PatientDetailModel> patientConferenceList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();		
		if(userService.isLoggedIn()){ 
			if(pc != null){
			    		patientModelList = bookingService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
			    		if(!patientModelList.isEmpty()){
			    			for(PatientDetailModel p: patientModelList){			    				
			    				if(result.add(p.getPatientconferenceId()) && p.getPatientconferenceId() !=null && !p.getPatientconferenceStatus().equalsIgnoreCase("Delete")){
			    					patientConferenceList.add(p);
			    				}
			    			}
			    		}
			    		if(!patientConferenceList.isEmpty()){			
							patientBookingForm.setPatientcase(pc);
							for(PatientDetailModel p: patientConferenceList){								
								patientBookingForm.setId(p.getBookingId());								
								patientBookingForm.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
								patientBookingForm.setReceiver(p.getId());
								patientBookingForm.setStatus("Cancel");
								patientBookingForm.setTimezone(p.getBookingTimezone());
								if(p.getBookingDt() != null && !p.getBookingStatus().equalsIgnoreCase("Delete")){
									DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
									DateFormat dateFormat1 = new SimpleDateFormat("hh:mm a");
									patientBookingForm.setBookingDt(dateFormat.format(p.getBookingDt()));									
									patientBookingForm.setTime(dateFormat1.format(p.getBookingDt()));
									patientBookingForm.setSubject("Schedule Procedure Canceled By Doctor");
									patientBookingForm.setBody("Schedule Procedure Canceled By Doctor");
								}
								model.addAttribute("patientname", p.getName());
								model.addAttribute("timezone",p.getConferenceTimezone());
								model.addAttribute("procedureFound", false);
				    			if(bookingService.getIsProcedureExist(p.getId(),p.getTreatment(),p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner())){
				    				model.addAttribute("procedureFound", true);
				    			}
							}							
						}	
			}				
		}
		model.addAttribute("patientBookingForm", patientBookingForm);
		return "booking/cancel";
	}
	
	@RequestMapping(value = "/home/booking/cancel", method = RequestMethod.POST)
	public String cancel(@Valid PatientBookingForm patientBookingForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){		 
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during schedule procedure",
					bindingResult.getErrorCount());
			logger.info("errror {}",bindingResult.getFieldErrors());
			model.addAttribute("error", 1);
			return "booking/cancel";
		} 		
		if(patientBookingForm.getPatientcase() != null){
			try{
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				DateFormat dateFormat1 = new SimpleDateFormat("MMM dd, yyyy HH:mm");
				Date date = dateFormat1.parse(patientBookingForm.getBookingDt());
				patientBookingForm.setBookingDt(dateFormat.format(date));
				Boolean edited = bookingService.edit(patientBookingForm);
				if(edited){				
	    			PatientModel pm = bookingService.getPatient(patientBookingForm.getReceiver());
	    			PractitionerModel practitioner = bookingService.getPractitioner(userService.getCurrentUserId());
	    			if(pm.getId() != null){
	    				mailService.sendMail(pm.getEmail(), patientBookingForm.getSubject(), patientBookingForm.getBody(), "conference.html", patientBookingForm.getBookingDt(), pm.getFirstName() + " "+ pm.getLastName(),practitioner.getFirstName()+" "+practitioner.getLastName(),patientBookingForm.getPatientcase().intValue(),true,false);
	    				logger.info("Procedure Canceled Mail Sent successfully to Patient {}",pm.getId());
	    			}
					redirectAttributes.addFlashAttribute("message", "1");
	    			redirectAttributes.addAttribute("pc", patientBookingForm.getPatientcase());
	    			return "redirect:/home/booking/cancel";
				}
			}catch(Exception ex){
				logger.info("Date error found :{}",ex.getMessage());
			}
		}
		model.addAttribute("patientBookingForm", patientBookingForm);
		return "booking/cancel";
	}
	
	@RequestMapping(value = "/home/case/delete", method = RequestMethod.GET)
	public String deletecase(@RequestParam(value = "pc", required = false) BigInteger pc,@RequestParam(value = "dc", required = false) Integer dc,CancelForm cancelForm,Model model){
		List<PatientDetailModel> patientModelList = null;
		List<PatientDetailModel> patientBookingList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();
		if(userService.isLoggedIn()){ 
			if(pc != null){
			    		patientModelList = bookingService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());			    		
			    		if(!patientModelList.isEmpty()){
			    			for(PatientDetailModel p: patientModelList){
			    				if(result.add(p.getPatientconferenceId()) && p.getPatientconferenceId() !=null && !p.getPatientconferenceStatus().equalsIgnoreCase("Delete")){
			    					patientBookingList.add(p);
			    				}
			    			}
			    		}
			    		if(!patientBookingList.isEmpty()){						
							for(PatientDetailModel p: patientBookingList){
								cancelForm.setPatientcase(pc);
					 			cancelForm.setHcpstmp(p.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
					 			cancelForm.setReceiver(p.getId());
					 			cancelForm.setDeletecase(false);
					 			if(dc == 1){
					 				cancelForm.setDeletecase(true);
					 			}
					 			model.addAttribute("patientname", p.getName());
							}
						}	
			}				
		}
		model.addAttribute("cancelForm", cancelForm);
		model.addAttribute("dc",dc);
		return "booking/delete";
	}
	
	@RequestMapping(value = "/home/case/delete", method = RequestMethod.POST)
	public String deletecase(@Valid CancelForm cancelForm,BindingResult bindingResult,RedirectAttributes redirectAttributes){
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during cancel schedule",
					bindingResult.getErrorCount());			
			return "booking/delete";
		}
		if(cancelForm.getPatientcase() != null && cancelForm.getHcpstmp() != null){
			Boolean result = bookingService.deleteCase(cancelForm);
			if(result){
				PatientModel pm = bookingService.getPatient(cancelForm.getReceiver());
    			PractitionerModel practitioner = bookingService.getPractitioner(userService.getCurrentUserId());
    			if(pm.getId() != null){
    				String subject = "Delete Case";
    	        	String message = "Case Deleted By Doctor";
    	        	if(cancelForm.getDeletecase()){
    	        		subject = "Delete Case";
    	        		message = "Case Deleted by Doctor";
    	        	}
    	        	mailService.sendMail(pm.getEmail(), subject, message, "conference.html", null, pm.getFirstName() + " "+ pm.getLastName(),practitioner.getFirstName() + " "+ practitioner.getLastName(),cancelForm.getPatientcase().intValue(),true,false);
    	        	mailService.sendMail(practitioner.getEmail(), subject, message, "conference.html", null, practitioner.getFirstName() + " " + practitioner.getLastName(), "Doctor Globe", cancelForm.getPatientcase().intValue(),false,true);
    				logger.info("Case Delete Mail Sent successfully to Patient {}",pm.getId());
    			}
				redirectAttributes.addFlashAttribute("message", "1");
				return "redirect:/home/case/delete";
			}
		}
		return "booking/delete";
	}
	
	/**
	 * 
	 * @param pc
	 * @param patientBookingForm
	 * @param model
	 * @return show booking calendar
	 */
	@RequestMapping(value = "/home/booking/view", method = RequestMethod.GET)
	public String view(@RequestParam(value = "pc", required = false) BigInteger pc,Model model){
		List<PatientDetailModel> patientModelList = null;
		List<PatientDetailModel> patientBookingList = new ArrayList<PatientDetailModel>();
		Set<BigInteger> result = new HashSet<BigInteger>();
		TimeZone timeZone = null;
		String patientTimeZone = null;
		if(userService.isLoggedIn() && pc!=null){		
			patientModelList = bookingService.getPatientDetailByPatientcase(pc, userService.getCurrentUserId());
		 		if(!patientModelList.isEmpty()){
		   			for(PatientDetailModel p: patientModelList){
		   				if(result.add(p.getBookingId()) && p.getBookingId() !=null && !p.getBookingStatus().equalsIgnoreCase("Delete")){
		   					if(p.getCountryCode() != null){								
							    timeZone = bookingService.getTimeZone(p.getCountryCode(), p.getCity());		
							    patientTimeZone = bookingService.getGMTFormatTimeZone(timeZone);
							    p.setPatientTimezone(patientTimeZone);							    
							}else{
								timeZone = TimeZone.getTimeZone("GMT 00:00");
								patientTimeZone = bookingService.getGMTFormatTimeZone(timeZone);
								p.setPatientTimezone(patientTimeZone);
							}
		   					DateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy");													
			    			String bookingDate = dateFormat2.format(p.getBookingDt());			    			
			    			model.addAttribute("bookingDate", bookingDate);    				 
							p.setPatientBookingDate(bookingService.getTimeZoneConvert(p.getBookingDt(), p.getBookingTimezone(), patientTimeZone, "MMM dd, yyyy"));
							p.setPatientBookingTime(bookingService.getTimeZoneConvert(p.getBookingDt(), p.getBookingTimezone(), patientTimeZone, "hh:mm a"));
		   					patientBookingList.add(p);
		   				}
		   			}
		   		}		
		}
		model.addAttribute("patientBookingList", patientBookingList);
		return "booking/view";
	}
	
}