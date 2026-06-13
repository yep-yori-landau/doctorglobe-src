package com.dg.doctor.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.doctor.form.CancelForm;
import com.dg.doctor.form.PatientBookingForm;
import com.dg.doctor.model.PatientCaseBookingModel;
import com.dg.doctor.model.PatientCaseMessagesModel;
import com.dg.doctor.model.PatientModel;
import com.dg.doctor.model.PractitionerModel;


public class BookingService extends RestService{
	
	private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
	
	private SearchUrlService searchUrlService;		
	  
	public SearchUrlService getSearchUrlService(){
		  return this.searchUrlService;
	}
	  
	public void setSearchUrlService(SearchUrlService searchUrlService){
		  this.searchUrlService = searchUrlService;
	}
	
	public Boolean edit(PatientBookingForm form){
		UserService userService = new UserService();
		PatientCaseBookingModel pcb = new PatientCaseBookingModel();
		String reference = "DG-"+form.getPatientcase()+"-"+form.getReceiver()+"-"+userService.getCurrentUserId();
		pcb.setId(form.getId());
		pcb.setReference(reference);
		pcb.setBookingDt(form.getBookingDt());
		pcb.setPatientCase(form.getPatientcase());
		pcb.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(form.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
		pcb.setStatus(form.getStatus());
		pcb.setTimezone(form.getTimezone());
		int edited = this.editPatientCaseBooking(pcb);
		if(edited > 0){
			this.updatePatientCaseStatus(form.getPatientcase(), "In Progress");
			PatientCaseMessagesModel patientcasemessage = new PatientCaseMessagesModel();
    		patientcasemessage.setReference(reference);
    		patientcasemessage.setSenderType("Practitioner");
    		patientcasemessage.setSender(userService.getCurrentUserId());
    		patientcasemessage.setReceiverType("Patient");
    		patientcasemessage.setReceiver(form.getReceiver());
    		patientcasemessage.setSubject(form.getSubject());
    		patientcasemessage.setBody(form.getBody());
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	  
    		Date date = new Date();
    		patientcasemessage.setSentDt(dateFormat.format(date));
    		patientcasemessage.setStatus("open");
    		patientcasemessage.setPatientCase(form.getPatientcase());
    		int result = this.editPatientCaseMessage(patientcasemessage);
    		if(result > 0){    			
    			return true;
    		}
		}
		return false;
	}
	
	public Boolean deleteCase(CancelForm form){
		  UserService userService = new UserService();
		  Integer res = this.updatePatientConferenceStatus(form.getPatientcase(), form.getHcpstmp(), "Delete");
		  Integer res1 = this.updatePatientBookingStatus(form.getPatientcase(), form.getHcpstmp(), "Delete");
		  if(res > 0 || res1 > 0){
			  PatientCaseMessagesModel patientcasemessage = new PatientCaseMessagesModel();
			  	String subject = "Schedule Procedure Canceled";
	        	String message = "Schedule Procedure Canceled";
	        	if(form.getDeletecase()){
	        		subject = "Delete Case";
	        		message = "Case Deleted By Doctor";
	        	}
			  	String reference = "DG-"+form.getPatientcase()+"-"+form.getReceiver()+"-"+userService.getCurrentUserId();
			  	patientcasemessage.setReference(reference);
	    		patientcasemessage.setSenderType("Practitioner");
	    		patientcasemessage.setSender(userService.getCurrentUserId());
	    		patientcasemessage.setReceiverType("Patient");
	    		patientcasemessage.setReceiver(form.getReceiver());
	    		patientcasemessage.setSubject(subject);
	    		patientcasemessage.setBody(message);
	    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	  
	    		Date date = new Date();
	    		patientcasemessage.setSentDt(dateFormat.format(date));
	    		patientcasemessage.setStatus("Read");
	    		patientcasemessage.setPatientCase(form.getPatientcase());
	    		this.editPatientCaseMessage(patientcasemessage);
	    		MailService mailService = new MailService();
    			PatientModel model = this.getPatient(form.getReceiver());
    			PractitionerModel practitioner = this.getPractitioner(userService.getCurrentUserId());
    			if(model.getId() != null){
    				mailService.sendMail(model.getEmail(), subject, message, "conference.html", null, model.getFirstName() + " "+ model.getLastName(),practitioner.getFirstName() + " "+ practitioner.getLastName(),form.getPatientcase().intValue(),true,false);
    	        	mailService.sendMail(practitioner.getEmail(), subject, message, "conference.html", null, practitioner.getFirstName() + " " + practitioner.getLastName(), "Doctor Globe", form.getPatientcase().intValue(),false,true);
    				logger.info("Delete Case Mail Sent successfully to Patient {}",model.getId());
    			}
			  return true;
		  }
		  return false;
	  }
}