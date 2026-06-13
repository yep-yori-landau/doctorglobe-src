package com.dg.doctor.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.doctor.form.PostMessageForm;
import com.dg.doctor.model.PatientCaseMessagesModel;


public class PostMessageService extends RestService
{
	private static final Logger logger = LoggerFactory.getLogger(PostMessageService.class);
	
	private SearchUrlService searchUrlService;		
	  
	public SearchUrlService getSearchUrlService(){
		  return this.searchUrlService;
	}
	  
	public void setSearchUrlService(SearchUrlService searchUrlService){
		  this.searchUrlService = searchUrlService;
	}
	
	public Boolean edit(PostMessageForm model){
		UserService userService = new UserService();
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
		patientcasemessage.setStatus("open");
		patientcasemessage.setPatientCase(model.getPatientcase());
		int res = this.editPatientCaseMessage(patientcasemessage);
		if(res > 0){
			return true;
		}
		return false;
	}
}