package com.dg.doctor.service;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.doctor.form.PatientConferenceForm;
import com.dg.doctor.model.PatientCaseMessagesModel;
import com.dg.doctor.model.PatientConferenceModel;
import com.dg.doctor.model.PractitionerCountryModel;


public class ScheduleService extends RestService{
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);
	
	private SearchUrlService searchUrlService;		
	  
	public SearchUrlService getSearchUrlService(){
		  return this.searchUrlService;
	}
	  
	public void setSearchUrlService(SearchUrlService searchUrlService){
		  this.searchUrlService = searchUrlService;
	}
	
	public Boolean edit(PatientConferenceForm model){
		UserService userService = new UserService();
		PatientConferenceModel pcm = new PatientConferenceModel();
		pcm.setId(model.getId());
		pcm.setConferenceDt(model.getConferenceDt());
		pcm.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(model.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
		pcm.setPatientCase(model.getPatientcase());
		pcm.setStatus(model.getStatus());
		pcm.setTimezone(model.getTimezone());
		int edited = this.editPatientConferecne(pcm);
		if(edited > 0){
			PatientCaseMessagesModel patientcasemessage = new PatientCaseMessagesModel();
			String reference = "DG-"+model.getPatientcase()+"-"+model.getReceiver()+"-"+userService.getCurrentUserId();
    		patientcasemessage.setReference(reference);
    		patientcasemessage.setSenderType("Practitioner");
    		patientcasemessage.setSender(userService.getCurrentUserId());
    		patientcasemessage.setReceiverType("Patient");
    		patientcasemessage.setReceiver(model.getReceiver());
    		patientcasemessage.setSubject(model.getSubject());
    		patientcasemessage.setBody(model.getBody());
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	  
    		Date date = new Date();
    		patientcasemessage.setSentDt(dateFormat.format(date));
    		patientcasemessage.setStatus("Open");
    		patientcasemessage.setPatientCase(model.getPatientcase());
    		int result = this.editPatientCaseMessage(patientcasemessage);
    		if(result > 0){
    			return true;
    		}
		}
		return false;
	}	
}