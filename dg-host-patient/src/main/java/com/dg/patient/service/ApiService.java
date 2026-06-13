package com.dg.patient.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dg.patient.exception.ApiException;
import com.dg.patient.model.ApiUser;
import com.dg.patient.model.EmployeeCorporatecompanyDetailModel;
import com.dg.patient.model.HealthcareproviderModel;
import com.dg.patient.model.PatientCaseBookingModel;
import com.dg.patient.model.PatientCaseMessagesModel;
import com.dg.patient.model.PatientConferenceModel;
import com.dg.patient.model.PatientModel;
import com.dg.patient.model.PatientcasePriceModel;
import com.dg.patient.model.PractitionerModel;
import com.dg.patient.model.TreatmentModel;
import com.dg.patient.model.api.Hospital;
import com.dg.patient.model.api.Treatment;

/**
 * ApiService
 * @author DoctorGlobe
 * 
 */
@Service("apiService")
public class ApiService{
	
	private static final Logger logger = LoggerFactory
			.getLogger(ApiService.class);
	
	private SearchUrlService searchUrlService;
	
	private UserService userService;
	
	private SearchService searchService;

	public SearchUrlService getSearchUrlService() {
		return this.searchUrlService;
	}

	public void setSearchUrlService(SearchUrlService searchUrlService) {
		this.searchUrlService = searchUrlService;
	}
	
	public UserService getUserService() {
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public SearchService getSearchService() {
		return this.searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	
	/**
	 * Search for treatments
	 * @param id
	 * @return treatmentmodel
	 */
	public TreatmentModel getTreatmentById(Integer id)  {
		String url = this.getSearchUrlService().getTreatmentBaseUrl() + "/get/" + id;
		logger.info("url {}",url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<TreatmentModel> responseEntity = restTemplate
					.getForEntity(url, TreatmentModel.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			//throw new ApiException("No Record Found.",1003);			
		}		
		return null;
	}
	
	/**
	 * Search for treatments
	 * @return list of treatment model
	 */
	public List<TreatmentModel> getAllTreatments() {
		String url = this.getSearchUrlService().getTreatmentBaseUrl() + "/getAll";
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<TreatmentModel[]> responseEntity = restTemplate
					.getForEntity(url, TreatmentModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Get Treatment list
	 * @return list of treatments
	 */
	public List<Treatment> getWithoutGeneralTreatmentList(){
		List<Treatment> treatmentList = new ArrayList<Treatment>();
		for(TreatmentModel model:this.getAllTreatments()){
			if(!model.getName().equalsIgnoreCase("standard")){
				Treatment treatment = new Treatment();
				treatment.setId(model.getId());
				treatment.setName(model.getName());
				treatmentList.add(treatment);
			}
		}
		return treatmentList;
	}
	
	/**
	 * Get Treatment By id
	 * @return treatment
	 */
	public Treatment getWithoutGeneralTreatmentById(Integer id) throws ApiException{
		Treatment treatment = new Treatment();
		try{			
			TreatmentModel model = this.getTreatmentById(id);
			if(model.getId() != null && !model.getName().equalsIgnoreCase("standard")){
					treatment.setId(model.getId());
					treatment.setName(model.getName());			
			}
		}catch(Exception ex){
			throw new ApiException("No Record Found.",1003);
		}
		return treatment;
	}	
	
	/**
	 * Get Active Api user by username	  
	 * @param userName	 
	 * @return ApiUser model 
	 */	
	public ApiUser getApiUserByUserName(String userName){
		String url = this.getSearchUrlService().getApiUserBaseUrl() + "/get/" + userName+"/1";
		logger.info("url {}",url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<ApiUser> responseEntity = restTemplate
					.getForEntity(url,ApiUser.class);
			return responseEntity.getBody();
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	public Boolean getAuthentication(String userName,String password){
		try{
			ApiUser apiUserModel = this.getApiUserByUserName(userName);
			if(apiUserModel.getId() != null && apiUserModel.getPassword().equalsIgnoreCase(this.getSHA1(password))){
				return true;
			}
		}catch(Exception ex){
			logger.info("Exception found {}",ex.getMessage());
		}
		return false;
	}
	
	/**
	 * Search for patients Get Patient data
	 * @param id
	 * @return patientModel
	 */
	public PatientModel getPatientByPhoneNumber(String phoneNumber) {
		String url = this.getSearchUrlService().getPatientBaseUrl() + "/get/"
				+ phoneNumber+"/1";
		logger.info("Url Found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientModel> responseEntity = restTemplate
					.getForEntity(url, PatientModel.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Encoded passwordString in sha1
	 * @param passwordString
	 * @throws Exception
	 * @return string
	 */
	public String getSHA1(String passwordString) throws Exception {
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		sha1.reset();
		sha1.update(passwordString.getBytes());
		byte[] digest = sha1.digest();
		StringBuffer password = new StringBuffer();
		for (byte b : digest) {
			password.append(String.format("%02x", b));
		}
		return password.toString();
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @param originPrice
	 * @return api hospital details
	 */
	public List<Hospital> getApiHospital(List<HealthcareproviderModel> healthcareprovider,Double originPrice){
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		for(HealthcareproviderModel model:healthcareprovider){
			Hospital hospitalModel = new Hospital();
			hospitalModel.setId(model.getId());
			hospitalModel.setName(model.getName());
			hospitalModel.setStreet(model.getAddress_1());
			hospitalModel.setCity(model.getCityName());
			hospitalModel.setState(model.getStateName());
			hospitalModel.setCountry(model.getCountryName());
			hospitalModel.setZip(model.getZipCode());
			hospitalModel.setLatitude(model.getLat());
			hospitalModel.setLongitude(model.getLon());
			hospitalModel.setWebsite(model.getWebsite());
			hospitalModel.setRanking(model.getRanking());
			hospitalModel.setDistance(model.getDistance());
			hospitalModel.setDestinationPrice(Double.valueOf(Math.round(model.getDestinationCost())));
			hospitalModel.setVolumne(model.getVolume());
			hospitalModel.setTreatmentName(model.getTreatmentName());
			hospitalModel.setOriginPrice(Double.valueOf(Math.round(originPrice)));
			hospitalModel.setMaxBonus(Double.valueOf(Math.round(model.getYouGetUpTo())));
			hospitalModel.setOutOfPocket(Double.valueOf(Math.round(model.getYouPayUpTo())));
			hospitalModel.setFlightTime(model.getFlighttime());
			hospitalModel.setHcpstmpId(model.getHcpstmpId());
			hospitalList.add(hospitalModel);			
		}
		return hospitalList;
	}
	
	/**
	 * Check Api User patient limit
	 * @param patientId
	 * @param treatmentId
	 * @return
	 * @throws ApiException
	 */
	public Boolean checkApiUserLimit(BigInteger patientId,Integer treatmentId) throws ApiException {
		List<PatientCaseBookingModel> pcbList = userService
				.getPatientCaseBookingModelByPatientAndTreatment(
						patientId, treatmentId);
		Integer totalTreatmentConference = this.getUserService()
				.getTotalPatientTreatmentConference(
						patientId, treatmentId);
		logger.info("totalTreatmentConference found {}",totalTreatmentConference);
		if (this.getSearchUrlService()
				.getCaseConferenceLimit() <= totalTreatmentConference
				|| !pcbList.isEmpty()) {
			throw new ApiException("Either you have exceeded the limit to schedule conference or already booked a procedure with a doctor for same treatment.",1004);
		}
		return true;
	}
	
	/**
	 * Add/Edit patient case price data in database
	 * @param model
	 * @return Integer
	 */
	public Integer setPatientcasePrice(PatientcasePriceModel model,Integer patientId) {
		String url = this.getSearchUrlService().getPatientcasePriceBaseUrl()
				+ "/create/user/" + patientId + "/type/patient";
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Integer> responseEntity = restTemplate
					.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}
	
	/**
	 * Add/Edit patient case price data in database
	 * @param patientcase
	 * @param hcpstmp
	 * @param list_price
	 * @param youpay_list_price
	 * @param bonus_list_price
	 * @return true if patient case price add/edited
	 */
	public Boolean addPatientcasePrice(BigInteger patientcase,
			BigInteger hcpstmp, Double list_price, Double youpay_list_price,
			Double bonus_list_price,Integer patientId) {
		Boolean result = false;
		Integer edited = 0;
		PatientcasePriceModel model = this.getUserService().getPatientcasePriceModel(patientcase,
				hcpstmp);
		if (model.getId() != null) {
			model.setListPrice(list_price);
			model.setYoupayListPrice(youpay_list_price);
			model.setBonusListPrice(bonus_list_price);
			edited = this.setPatientcasePrice(model,patientId);
		}
		else {
			model.setListPrice(list_price);
			model.setYoupayListPrice(youpay_list_price);
			model.setBonusListPrice(bonus_list_price);
			model.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
					hcpstmp);
			model.setPatientCase(patientcase);
			edited = this.setPatientcasePrice(model,patientId);
		}
		if (edited > 0) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Add/Edit patientConference data in database
	 * @param PatientConferenceModel model
	 * @return Integer
	 */
	public Integer setPatientConference(PatientConferenceModel model,Integer patientId) {
		String url = this.getSearchUrlService().getPatientConferenceBaseUrl()
				+ "/create/user/" + patientId + "/type/patient";
		logger.info("url found", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Integer> responseEntity = restTemplate
					.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}
	
	
	/**
	 * check patientConference
	 * @param model
	 * @return
	 */
	public boolean editPatientConference(BigInteger patientcase,
			BigInteger hcpstmp,Integer patientId) {
		PatientConferenceModel patientConferenceModel = new PatientConferenceModel();
		patientConferenceModel.setStatus("Created");
		patientConferenceModel.setConferenceDt("1970-01-01");
		patientConferenceModel.setPatientCase(patientcase);
		patientConferenceModel
				.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
						hcpstmp);
		List<PatientConferenceModel> patientconference = this.getUserService()
				.getPatientConferenceModel(patientcase, hcpstmp);
		boolean found = false;
		boolean alreadyExist = false;
		for (PatientConferenceModel p : patientconference) {
			if (p.getId() != null) {
				patientConferenceModel.setId(p.getId());
				patientConferenceModel.setTimezone(p.getTimezone());
				this.setPatientConference(patientConferenceModel,patientId);
				found = false;
				alreadyExist = true;
				break;
			}
		}
		if (!alreadyExist) {
			this.setPatientConference(patientConferenceModel,patientId);
			found = true;
		}
		return found;
	}
	
	/**
	 * Add Patient case message
	 * @param senderType
	 * @param sender
	 * @param receiverType
	 * @param receiver
	 * @param subject
	 * @param body
	 * @param status
	 * @param pc
	 * @return Boolean
	 */
	public Boolean editPatientCaseMessage(String senderType, BigInteger sender,
			String receiverType, BigInteger receiver, String subject,
			String body, String status, BigInteger pc,BigInteger patientId) {
		Boolean result = false;
		PatientCaseMessagesModel patientcasemessage = new PatientCaseMessagesModel();
		String reference = "DG-" + pc + "-" + patientId + "-"
				+ receiver;
		patientcasemessage.setId(null);
		patientcasemessage.setReference(reference);
		patientcasemessage.setSenderType(senderType);
		patientcasemessage.setSender(sender);
		patientcasemessage.setReceiverType(receiverType);
		patientcasemessage.setReceiver(receiver);
		patientcasemessage.setSubject(subject);
		patientcasemessage.setBody(body);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		patientcasemessage.setSentDt(dateFormat.format(date));
		patientcasemessage.setStatus(status);
		patientcasemessage.setPatientCase(pc);
		Integer edit = this.getUserService().setPatientCaseMessage(patientcasemessage);
		if (edit > 0) {
			result = true;
		}
		return result;
	}
	
	/**
	 * add paient case in database add patientcase price detail
	 * @param patientcase
	 * @param hcpstmp
	 * @param healthcareprovider
	 * @param lp
	 * @param ylp
	 * @param blp
	 * @param practitionerModel
	 */
	public void addApiNewPatientCase(BigInteger patientcase, BigInteger hcpstmp,
			BigInteger healthcareprovider, Double lp, Double ylp, Double blp,
			PractitionerModel practitionerModel,PatientModel patientModel) {
		String emailAddress = patientModel.getEmail();
		if (this.getUserService().getApiUserIsCorporatePatient(patientModel.getId(),patientModel.getDependent())) {
			EmployeeCorporatecompanyDetailModel employeeCorporatecompanyDetailModel = new EmployeeCorporatecompanyDetailModel();
			employeeCorporatecompanyDetailModel = this.getUserService()
					.getEmployeeCorporatecompanyDetailModelByPatient(
							patientModel.getId());
			if (employeeCorporatecompanyDetailModel.getEmail() != null
					&& employeeCorporatecompanyDetailModel.getEmail() != "") {
				emailAddress = employeeCorporatecompanyDetailModel.getEmail();
			}
		}
		if (patientcase != null) {
			this.addPatientcasePrice(patientcase, hcpstmp, lp, ylp, blp,patientModel.getId().intValue());
			boolean found = this.editPatientConference(patientcase, hcpstmp,patientModel.getId().intValue());
			if (found) {				
				this.getUserService().getMailService().sendInterviewRequestRegisteredMail(emailAddress,
						"Thank you for your hospital choice",
						"interview_request_registered.html",
						patientcase.intValue(),
						patientModel.getFirstName() + " " + patientModel.getLastName(),
						practitionerModel.getName(),
						practitionerModel.getHealthcareproviderName(),
						practitionerModel.getTreatmentName());
				this.editPatientCaseMessage("System", BigInteger.valueOf(0),
						"System", patientModel.getId(), "Patient Case Created",
						"A New Patient Case is created", "read", patientcase,patientModel.getId());
			}
		}

	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @param patientModel
	 * @param treatment
	 * @param hcpstmpId
	 * @return
	 * @throws ApiException
	 */
	public Integer setApiPatientCase(List<HealthcareproviderModel> healthcareprovider,PatientModel patientModel,Integer treatment,BigInteger hcpstmpId,BigInteger hospitalId) throws ApiException{
		HealthcareproviderModel hospitalModel = new HealthcareproviderModel();
		PractitionerModel practitionerModel = new PractitionerModel();
		BigInteger patientcase = null;
		if(healthcareprovider.isEmpty()){
			throw new ApiException("Hospital Records Not Found",1005);
		}else{
			for(HealthcareproviderModel model:healthcareprovider){				
				if(model.getId().equals(hospitalId.intValue()) && model.getHcpstmpId().equals(hcpstmpId)){
					hospitalModel = model;
					logger.info("hospital found {}",true);
					break;
				}
			}
		}
		if(hospitalModel.getId() != null){				
			patientcase = this.getUserService().addPatientCase(patientModel.getId(),
					BigInteger.valueOf(treatment));
			List<PractitionerModel> practitionersList = this.getSearchService().practitioners(
					hospitalId.intValue(),treatment,patientModel.getId());
			practitionerModel = this.getUserService()
					.getSelectedPractitionerModel(practitionersList, hospitalModel.getPractitioner().intValue());
			this.addApiNewPatientCase(patientcase, hcpstmpId, hospitalId,
					hospitalModel.getEstimatedCost(), hospitalModel.getYouPayUpTo(), hospitalModel.getYouGetUpTo(), practitionerModel,patientModel);
			
		}else{
			throw new ApiException("Hospital Record Not Found",1005);
		}		
		return patientcase.intValue();
	}
	
}