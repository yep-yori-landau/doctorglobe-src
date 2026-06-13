package com.dg.patient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

import com.dg.patient.model.PractitionerModel;
import com.dg.patient.model.HospitalSpecialtyTreatmentMethodPractitionerModel;
import com.dg.patient.form.ResetPasswordForm;
import com.dg.patient.form.SelectDoctorForm;
import com.dg.patient.model.AssociateModel;
import com.dg.patient.model.AssociationModel;
import com.dg.patient.model.CityModel;
import com.dg.patient.model.Corporatecompany;
import com.dg.patient.model.CorporatecompanyPatientModel;
import com.dg.patient.model.CountryModel;
import com.dg.patient.model.EmployeeCorporatecompanyDetailModel;
import com.dg.patient.model.HospitalPractitionerModel;
import com.dg.patient.model.PatientCaseBookingModel;
import com.dg.patient.model.PatientCaseMessagesModel;
import com.dg.patient.model.PatientCaseModel;
import com.dg.patient.model.PatientConferenceDetailModel;
import com.dg.patient.model.PatientConferenceModel;
import com.dg.patient.model.PatientLatLonModel;
import com.dg.patient.model.PatientModel;
import com.dg.patient.model.PatientcaseDetailModel;
import com.dg.patient.model.PatientcasePriceModel;
import com.dg.patient.model.Practitioner;
import com.dg.patient.model.StateModel;
import com.dg.patient.model.UserModel;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DoctorGlobe
 * 
 */

public class UserService implements UserDetailsService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);

	private SearchUrlService searchUrlService;

	private String loginUrl;

	private String associateUrl;

	private String associationUrl;

	private String corporatecompanyUrl;

	private MailService mailService;

	/**
	 * Get the searchUrlService
	 * @return search url service
	 */
	public SearchUrlService getSearchUrlService() {
		return this.searchUrlService;
	}

	/**
	 * set searchUrlService
	 * @param searchUrlService
	 */
	public void setSearchUrlService(SearchUrlService searchUrlService) {
		this.searchUrlService = searchUrlService;
	}

	/**
	 * Get the login url
	 * @return login url
	 */
	public String getLoginUrl() {
		return this.loginUrl;
	}

	/**
	 * set loginUrl
	 * @param loginUrl
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	/**
	 * get associate url
	 * @return associate url
	 */
	public String getAssociateUrl() {
		return this.associateUrl;
	}

	/**
	 * set associate url
	 * @param associateUrl
	 */
	public void setAssociateUrl(String associateUrl) {
		this.associateUrl = associateUrl;
	}

	/**
	 * 
	 * @return association url
	 */
	public String getAssociationUrl() {
		return this.associationUrl;
	}

	/**
	 * 
	 * @param associationUrl
	 */
	public void setAssociationUrl(String associationUrl) {
		this.associationUrl = associationUrl;
	}

	/**
	 * Get the corporatecompanyUrl
	 * @return corporatecompanyUrl
	 */
	public String getCorporatecompanyUrl() {
		return this.corporatecompanyUrl;
	}

	/**
	 * Set the corporatecompanyUrl
	 * @param corporatecompanyUrl set the corporatecompanyUrl
	 */
	public void setCorporatecompanyUrl(String corporatecompanyUrl) {
		this.corporatecompanyUrl = corporatecompanyUrl;
	}

	/**
	 * Get the imageUrl
	 * @return imageUrl
	 */
	public String getImageUrl() {
		return this.getSearchUrlService().getImageUrl();
	}

	/**
	 * Get the emailService
	 * @return mailService
	 */
	public MailService getMailService() {
		return this.mailService;
	}

	/**
	 * Set the mailService
	 * @param mailService set the mailService
	 */
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	/**
	 * check user is valid or not based on email and current url
	 * @param emailWithUrl
	 * @throws UsernameNotFoundException if the user could not be found
	 * @return a fully populated user record if user valid
	 */
	@Override
	public UserDetails loadUserByUsername(String emaiWithUrl)
			throws UsernameNotFoundException {
		String[] split = emaiWithUrl.split("--");
		String username = split[0];
		String currentUrl = split[1];
		String url = this.getLoginUrl() + username + "/active/" + 1;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientModel> responseEntity = restTemplate
					.getForEntity(url, PatientModel.class);
			PatientModel model = responseEntity.getBody();
			if (model.getId() == null) {
				return this.loadAssociateUserByUsername(username, currentUrl);
			}
			Corporatecompany ccModel = this
					.getCorporatecompanyByPatient(model.getId());
			
			// Verify that if user belongs to corporate company, user also access via the designated corporate company url
			if (ccModel.getId() != null && !ccModel.getWhitelabelUrl().equalsIgnoreCase(currentUrl)) {
				throw new UsernameNotFoundException("user url not matched");
			}

			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(
					"ROLE_USER");
			authorities.add(userAuthority);
			UserDetails user = new UserModel(model.getEmail(),
					model.getPassword(), true, true, true, true, authorities,
					model.getId(), model.getPhoto(),
					model.getFirstName() + " " + model.getLastName(),
					model.getUserAgreement(), false, ccModel.getTheme(),
					ccModel.getWhitelabelUrl(), null, model.getDependent());
			logger.info("username  {}", user.getUsername());
			Authentication authToken = new UsernamePasswordAuthenticationToken(
					user.getUsername(), user.getPassword(),
					user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authToken);
			return user;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * check user is valid or not based on id and current url
	 * @param id the unique id of user
	 * @param currentUrl the unique url of user
	 * @throws UsernameNotFoundException if the user could not be found
	 * * @return a fully populated user record
	 */
	public UserDetails loadUserById(BigInteger id, String currentUrl)
			throws UsernameNotFoundException {
		try {
			HttpServletRequest request = null;
			BigInteger associateId = this.getCurrentUserId();
			String theme = this.getUserTheme(request);
			SecurityContextHolder.getContext().setAuthentication(null);
			PatientModel model = this.getPatientById(id);
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(
					"ROLE_USER");
			authorities.add(userAuthority);
			Corporatecompany ccModel = this
					.getCorporatecompanyByPatient(model.getId());
			if (ccModel.getId() == null && model.getDependent() != null) {
				ccModel = this
						.getCorporatecompanyByPatient(model.getDependent());
			}
			if (!ccModel.getWhitelabelUrl().equalsIgnoreCase(currentUrl)) {
				ccModel.setTheme(theme);
			}
			UserDetails user = new UserModel(model.getEmail(),
					model.getPassword(), true, true, true, true, authorities,
					model.getId(), model.getPhoto(),
					model.getFirstName() + " " + model.getLastName(),
					model.getUserAgreement(), false, ccModel.getTheme(),
					ccModel.getWhitelabelUrl(), associateId,
					model.getDependent());
			Authentication authToken = new UsernamePasswordAuthenticationToken(
					user, user.getPassword(), user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authToken);
			return user;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * check associate user is valid or not
	 * @param username
	 * @param currentUrl
	 * @throws UsernameNotFoundException if the user could not be found
	 * @return @return a fully populated user record
	 */
	public UserDetails loadAssociateUserByUsername(String username,
			String currentUrl) throws UsernameNotFoundException {
		String url = this.getAssociateUrl() + username + "/active/" + 1;
		String theme = null;
		logger.info("associate url Found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<AssociateModel> responseEntity = restTemplate
					.getForEntity(url, AssociateModel.class);
			AssociateModel model = responseEntity.getBody();
			if (model.getId() == null) {
				throw new UsernameNotFoundException("associate user not found");
			}
			if (model.getAssociation() != null) {
				AssociationModel associationModel = this
						.getAssociatonModelById(model.getAssociation());
				logger.info("associate user whitelabel url {}",
						associationModel.getWhitelabelUrl());
				logger.info("associate user current url {}", currentUrl);
				if (!associationModel.getWhitelabelUrl()
						.equalsIgnoreCase(currentUrl)) {
					throw new UsernameNotFoundException(
							"associate user url not matched");
				}
				if (associationModel.getTheme() != ""
						|| associationModel.getTheme().isEmpty()) {
					theme = associationModel.getTheme();
				}
			}
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(
					"ROLE_ASSOCIATE");
			authorities.add(userAuthority);
			UserDetails user = new UserModel(model.getEmail(),
					model.getPassword(), true, true, true, true, authorities,
					model.getId(), null,
					model.getFirstName() + " " + model.getLastName(), true,
					true, theme, currentUrl, null, null);
			Authentication authToken = new UsernamePasswordAuthenticationToken(
					user.getUsername(), user.getPassword(),
					user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authToken);
			return user;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * check associate user is valid or not
	 * @param id
	 * @param currentUrl
	 * @throws UsernameNotFoundException if the user could not be found
	 * @return @return a fully populated user record
	 */
	public UserDetails loadAssociationUserById(BigInteger id, String currentUrl)
			throws UsernameNotFoundException {
		try {
			HttpServletRequest request = null;
			String theme = this.getUserTheme(request);
			SecurityContextHolder.getContext().setAuthentication(null);
			AssociateModel model = this.getAssociateById(id);
			if (model.getId() == null) {
				throw new UsernameNotFoundException("associate user not found");
			}
			if (model.getAssociation() != null) {
				AssociationModel associationModel = this
						.getAssociatonModelById(model.getAssociation());
				logger.info("associate user whitelabel url {}",
						associationModel.getWhitelabelUrl());
				logger.info("associate user current url {}", currentUrl);
				if (!associationModel.getWhitelabelUrl()
						.equalsIgnoreCase(currentUrl)) {
					throw new UsernameNotFoundException(
							"associate user url not matched");
				}
				if (associationModel.getTheme() != ""
						|| associationModel.getTheme().isEmpty()) {
					theme = associationModel.getTheme();
				}
			}
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(
					"ROLE_ASSOCIATE");
			authorities.add(userAuthority);
			UserDetails user = new UserModel(model.getEmail(),
					model.getPassword(), true, true, true, true, authorities,
					model.getId(), null,
					model.getFirstName() + " " + model.getLastName(), true,
					true, theme, currentUrl, null, null);
			Authentication authToken = new UsernamePasswordAuthenticationToken(
					user, user.getPassword(), user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authToken);
			return user;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Get association data Search for association by id
	 * @param id
	 * @return association model
	 */
	public AssociationModel getAssociatonModelById(BigInteger id) {
		String url = this.getAssociationUrl() + "/get/" + id;
		logger.info("Url Founed {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<AssociationModel> responseEntity = restTemplate
					.getForEntity(url, AssociationModel.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Add/Edit patient data in database
	 * @param PatientModel
	 * @return integer patient id
	 */
	public Integer registerPatient(PatientModel model) {
		BigInteger userid = this.getCurrentUserId();
		if (this.getCurrentUserId() == null) {
			if (model.getId() != null) {
				userid = model.getId();
			}
			else {
				userid = BigInteger.valueOf(0);
			}
		}
		String url = this.getSearchUrlService().getPatientBaseUrl()
				+ "/create/user/" + userid + "/type/patient";
		logger.info("url found {}", url);
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
	 * Add/Edited patient case
	 * @param patient
	 * @param treatment
	 * @return patient case id
	 */
	public BigInteger addPatientCase(BigInteger patient, BigInteger treatment) {
		PatientCaseModel patientCase = new PatientCaseModel();
		patientCase.setId(null);
		patientCase.setDescription("DG-0-" + patient);
		patientCase.setStatus("Open");
		patientCase.setPatient(patient);
		patientCase.setTreatment(treatment);
		List<PatientcaseDetailModel> pcm = this
				.getPatientCasesByPatientId(patient);
		boolean found = false;
		BigInteger pcmId = null;
		for (PatientcaseDetailModel p : pcm) {
			if (p.getTreatment().equals(treatment)) {
				found = true;
				pcmId = p.getId();
				break;
			}
		}
		if (found) {
			return pcmId;
		}
		else {
			pcmId = BigInteger.valueOf(this.setPatientCase(patientCase,patient.intValue()));
			return pcmId;
		}
	}

	/**
	 * Add/Edit patient case detail in database
	 * @param model
	 * @return integer
	 */
	public Integer setPatientCase(PatientCaseModel model) {
		String url = this.getSearchUrlService().getPatientCaseBaseUrl()
				+ "/create/user/" + this.getCurrentUserId() + "/type/patient";
		logger.info("url found = {}", url);
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
	 * Add/Edit patient case detail in database
	 * @param model
	 * @return integer
	 */
	public Integer setPatientCase(PatientCaseModel model,Integer patientId) {
		String url = this.getSearchUrlService().getPatientCaseBaseUrl()
				+ "/create/user/" + patientId + "/type/patient";
		logger.info("url found = {}", url);
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
	 * Gets number of patient case for below treatment
	 * @param patient
	 * @param treatment
	 * @return integer
	 */
	public Integer checkTreatment(BigInteger patient, Integer treatment) {
		String url = this.getSearchUrlService().getBaseUrl()
				+ this.getSearchUrlService().getPatientCaseUrl() + "/patient/"
				+ patient + "/treatment/" + treatment;
		logger.info("url is {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Integer> responseEntity = restTemplate
					.getForEntity(url, Integer.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * Search for patients case Get Patient case detail data
	 * @param pateint
	 * @return list of patient case detail model
	 */
	public List<PatientcaseDetailModel> getPatientCasesByPatientId(
			BigInteger patient) {
		String url = this.getSearchUrlService().getPatientCaseBaseUrl()
				+ "/get/patient/" + patient;
		logger.info("url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientcaseDetailModel[]> responseEntity = restTemplate
					.getForEntity(url, PatientcaseDetailModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Search for patients Get Patient data
	 * @param id
	 * @return patientModel
	 */
	public PatientModel getPatientById(BigInteger id) {
		String url = this.getSearchUrlService().getPatientBaseUrl() + "/get/"
				+ id;
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
	 * Add/Edit patientConference data in database
	 * @param PatientConferenceModel model
	 * @return Integer
	 */
	public Integer setPatientConference(PatientConferenceModel model) {
		String url = this.getSearchUrlService().getPatientConferenceBaseUrl()
				+ "/create/user/" + this.getCurrentUserId() + "/type/patient";
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
	 * Add/Edit patientConference data in database
	 * @param PatientConferenceModel model
	 * @return Integer
	 */
	public Integer setApiPatientConference(PatientConferenceModel model,Integer patientId) {
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
	 * Add/Edit patientCaseBooking data in database
	 * @param PatientCaseBookingModel model
	 * @return Integer
	 */
	public Integer setPatientCaseBooking(PatientCaseBookingModel model) {
		String url = this.getSearchUrlService().getPatientCaseBookingBaseUrl()
				+ "/create/user/" + this.getCurrentUserId() + "/type/patient";
		logger.info("url found {}", url);
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
	 * Gets patient conference details
	 * @param patientcase
	 * @param patient
	 * @return list of PatientConferenceModel
	 */
	public List<PatientConferenceDetailModel> getPatientConferenceDetail(
			Integer patientcase, BigInteger patient) {
		String url = this.getSearchUrlService().getPatientConferenceBaseUrl()
				+ "/get/patientcase/" + patientcase + "/patient/" + patient;
		logger.info("url foudned {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientConferenceDetailModel[]> responseEntity = restTemplate
					.getForEntity(url, PatientConferenceDetailModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets patient conference details
	 * @param patientcase
	 * @param hcpstmp
	 * @return list of PatientConferenceModel
	 */
	public List<PatientConferenceModel> getPatientConferenceModel(
			BigInteger patientcase, BigInteger hcpstmp) {
		String url = this.getSearchUrlService().getPatientConferenceBaseUrl()
				+ "/get/patientcase/" + patientcase + "/hcpstmp/" + hcpstmp;
		logger.info("url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientConferenceModel[]> responseEntity = restTemplate
					.getForEntity(url, PatientConferenceModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets of patient case booking details
	 * @param patientcase
	 * @param hcpstmp
	 * @return list of PatientCaseBookingModel
	 */
	public List<PatientCaseBookingModel> getPatientCaseBookingModel(
			BigInteger patientcase, BigInteger hcpstmp) {
		String url = this.getSearchUrlService().getPatientCaseBookingBaseUrl()
				+ "/get/patientcase/" + patientcase + "/hcpstmp/" + hcpstmp;
		logger.info("url founded {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientCaseBookingModel[]> responseEntity = restTemplate
					.getForEntity(url, PatientCaseBookingModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Add/Edit patient case messages data in database
	 * @param model
	 * @return Integer
	 */
	public Integer setPatientCaseMessage(PatientCaseMessagesModel model) {
		String url = this.getSearchUrlService().getPatientCaseMessagesBaseUrl()
				+ "/create";
		logger.info("url found ={}", url);
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
	 * Get all cites data
	 * @return list of cities
	 */
	public List<CityModel> getCity() {
		String url = this.getSearchUrlService().getCityBaseUrl() + "/getAll";
		logger.info("url foudned {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CityModel[]> responseEntity = restTemplate
					.getForEntity(url, CityModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets Practitioner details
	 * @param id
	 * @return Practitioner
	 */
	public Practitioner getPractitioner(BigInteger id) {
		String url = this.getSearchUrlService().getPractitionerBaseUrl()
				+ "/get/" + id;
		logger.info("Url Founed {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Practitioner> responseEntity = restTemplate
					.getForEntity(url, Practitioner.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets all countries data
	 * @return list of CountryModel
	 */
	public List<CountryModel> getCountry() {
		String url = this.getSearchUrlService().getCountryBaseUrl() + "/getAll";
		logger.info("url foudned {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CountryModel[]> responseEntity = restTemplate
					.getForEntity(url, CountryModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets all states data
	 * @return list of StateModel
	 */
	public List<StateModel> getState() {
		String url = this.getSearchUrlService().getStateBaseUrl() + "/getAll";
		logger.info("url foud {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<StateModel[]> responseEntity = restTemplate
					.getForEntity(url, StateModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets all cities data
	 * @return list of CityModel
	 */
	public List<CityModel> getCityByState() {
		String url = this.getSearchUrlService().getCityBaseUrl() + "/getAll";
		logger.info("url foud {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CityModel[]> responseEntity = restTemplate
					.getForEntity(url, CityModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets all country states data
	 * @param country
	 * @return list of StateModel
	 */
	public List<StateModel> getStateByCountry(Integer country) {
		String url = this.getSearchUrlService().getStateBaseUrl()
				+ "/get/country/" + country;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<StateModel[]> responseEntity = restTemplate
					.getForEntity(url, StateModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets all country cities data
	 * @param country
	 * @return list of CityModel
	 */
	public List<CityModel> getCityByCountry(Integer country) {
		String url = this.getSearchUrlService().getCityBaseUrl()
				+ "/get/country/" + country;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CityModel[]> responseEntity = restTemplate
					.getForEntity(url, CityModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets all state cities data
	 * @param state the unique id of state
	 * @return list of CityModel
	 */
	public List<CityModel> getCityByState(Integer state) {
		String url = this.getSearchUrlService().getCityBaseUrl() + "/get/state/"
				+ state;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CityModel[]> responseEntity = restTemplate
					.getForEntity(url, CityModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets the details of a city
	 * @param id the unique id of city
	 * @return CityModel
	 */
	public CityModel getCityById(Integer id) {
		String url = this.getSearchUrlService().getCityBaseUrl() + "/get/" + id;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CityModel> responseEntity = restTemplate
					.getForEntity(url, CityModel.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets the details of patient
	 * @param email the unique email address of user
	 * @return PatientModel
	 */
	public PatientModel getPatientByEmail(String email) {
		String url = this.getSearchUrlService().getPatientBaseUrl()
				+ "/get/email/" + email + "/active/" + 1;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientModel> responseEntity = restTemplate
					.getForEntity(url, PatientModel.class);
			PatientModel model = responseEntity.getBody();
			return model;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * update patient password
	 * @param id the unique id of user
	 * @param old_password the old password of user
	 * @param new_password the new password of user
	 * @return Integer
	 */
	public Integer resetPassword(Integer id, String old_password,
			String new_password) {
		String url = this.getSearchUrlService().getPatientBaseUrl()
				+ "/reset/id/" + id + "/old_password/" + old_password
				+ "/new_password/" + new_password;
		logger.info("url found", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Integer> responseEntity = restTemplate
					.getForEntity(url, Integer.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * Update associate user password
	 * @param id
	 * @param old_password
	 * @param new_password
	 * @return Integer
	 */
	public Integer associateUserPasswordReset(Integer id, String old_password,
			String new_password) {
		String url = this.getSearchUrlService().getAssociateBaseUrl()
				+ "/reset/" + id + "/" + old_password + "/" + new_password;
		logger.info("url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Integer> responseEntity = restTemplate
					.getForEntity(url, Integer.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * Gets current user id
	 * @return BigInteger
	 */
	public BigInteger getCurrentUserId() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user.getId();
		}
		return null;
	}

	/**
	 * Gets current user email
	 * @return string
	 */
	public String getCurrentUserEmail() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user.getUsername();
		}
		return null;
	}

	/**
	 * Checks if a user is logged in
	 * @return boolean
	 */
	public Boolean isLoggedIn() {
		if (this.getCurrentUserId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Gets current user name
	 * @return string
	 */
	public String getCurrentUserName() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user.getName();
		}
		return null;
	}

	/**
	 * Gets current user model
	 * @return UserModel
	 */
	public UserModel getCurrentUserModel() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user;
		}
		return null;
	}

	/**
	 * check user file type is valid or not
	 * @param filetype
	 * @return boolean
	 */
	public Boolean fileTypeValidate(String filetype) {
		Boolean result = false;
		if (filetype.equalsIgnoreCase("image/jpg")) {
			result = true;
		}
		else if (filetype.equalsIgnoreCase("image/jpeg")) {
			result = true;
		}
		else if (filetype.equalsIgnoreCase("image/gif")) {
			result = true;
		}
		else if (filetype.equalsIgnoreCase("image/png")) {
			result = true;
		}

		return result;
	}

	/**
	 * check user uploaded file type is valid or not
	 * @param filetype
	 * @return boolean
	 */
	public Boolean uploadFileTypeValidate(String filetype) {
		Boolean result = false;
		if (filetype.equalsIgnoreCase("image/jpg")) {
			result = true;
		}
		else if (filetype.equalsIgnoreCase("image/jpeg")) {
			result = true;
		}
		else if (filetype.equalsIgnoreCase("image/gif")) {
			result = true;
		}
		else if (filetype.equalsIgnoreCase("image/png")) {
			result = true;
		}
		else if (filetype.equalsIgnoreCase("application/pdf")) {
			result = true;
		}
		return result;
	}

	/**
	 * Encoded passwordString in MD5
	 * @param passwordString
	 * @throws Exception
	 * @return string
	 */
	public String getMD5(String passwordString) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(passwordString.getBytes());
		byte[] digest = md.digest();
		StringBuffer password = new StringBuffer();
		for (byte b : digest) {
			password.append(String.format("%02x", b & 0xff));
		}
		return password.toString();
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
	 * Gets total number of patient conference exist for treatment
	 * @param patient
	 * @param treatment
	 * @return Integer
	 */
	public Integer getTotalPatientTreatmentConference(BigInteger patient,
			Integer treatment) {
		String url = this.getSearchUrlService().getPatientConferenceBaseUrl()
				+ "/get/patient/" + patient + "/treatment/" + treatment;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Integer> responseEntity = restTemplate
					.getForEntity(url, Integer.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * Gets Employee corporate company details for patient
	 * @param patient
	 * @return EmployeeCorporatecompanyDetailModel
	 */
	public EmployeeCorporatecompanyDetailModel getEmployeeCorporatecompanyDetailModelByPatient(
			BigInteger patient) {
		String url = this.getSearchUrlService()
				.getEmployeeCorporatecompanyBaseUrl() + "/get/patient/"
				+ patient;
		logger.info("url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<EmployeeCorporatecompanyDetailModel> responseEntity = restTemplate
					.getForEntity(url,
							EmployeeCorporatecompanyDetailModel.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets patient city latitude,longitude details
	 * @param patient
	 * @return PatientLatLonModel
	 */
	public PatientLatLonModel getPatientLatLonModel(BigInteger patient) {
		String url = this.getSearchUrlService().getPatientBaseUrl()
				+ "/getlatlon/" + patient;
		logger.info("Url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientLatLonModel> responseEntity = restTemplate
					.getForEntity(url, PatientLatLonModel.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Checks if a patient is corporate patient or not
	 * @return boolean
	 */
	public Boolean getIsCorporatePatient() {
		EmployeeCorporatecompanyDetailModel model = this
				.getEmployeeCorporatecompanyDetailModelByPatient(
						this.getCurrentUserId());
		Boolean found = model.getId() != null;
		if (!found && this.getDependent() != null) {
			model = this.getEmployeeCorporatecompanyDetailModelByPatient(
					this.getDependent());
			found = model.getId() != null;
		}
		return found;
	}
	
	/**
	 * Checks if a patient is corporate patient or not
	 * @return boolean
	 */
	public Boolean getApiUserIsCorporatePatient(BigInteger patientId,BigInteger dependentId) {
		EmployeeCorporatecompanyDetailModel model = this
				.getEmployeeCorporatecompanyDetailModelByPatient(
						patientId);
		Boolean found = model.getId() != null;
		if (!found && dependentId != null) {
			model = this.getEmployeeCorporatecompanyDetailModelByPatient(
					dependentId);
			found = model.getId() != null;
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
			String body, String status, BigInteger pc) {
		Boolean result = false;
		PatientCaseMessagesModel patientcasemessage = new PatientCaseMessagesModel();
		String reference = "DG-" + pc + "-" + this.getCurrentUserId() + "-"
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
		Integer edit = this.setPatientCaseMessage(patientcasemessage);
		if (edit > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * Get patient city model for current user
	 * @return CityModel
	 */
	public CityModel getPatientCityModel() {
		PatientModel pm = this.getPatientByEmail(this.getCurrentUserEmail());
		CityModel model = new CityModel();
		if (pm.getId() != null && pm.getCity() != null) {
			model = this.getCityById(pm.getCity().intValue());
		}
		if ((model.getLat() == null && model.getLon() == null)
				&& this.getIsCorporatePatient()) {
			EmployeeCorporatecompanyDetailModel eccModel = this
					.getEmployeeCorporatecompanyDetailModelByPatient(
							this.getCurrentUserId());
			if (eccModel.getCity() != null) {
				model = this.getCityById(eccModel.getCity().intValue());
			}
		}
		return model;
	}

	/**
	 * Gets current user city id
	 * @return BigInteger
	 */
	public BigInteger getPatientCity() {
		PatientModel pm = this.getPatientByEmail(this.getCurrentUserEmail());
		CityModel model = new CityModel();
		if (pm.getId() != null && pm.getCity() != null) {
			model = this.getCityById(pm.getCity().intValue());
		}
		if (model.getId() == null) {
			EmployeeCorporatecompanyDetailModel eccModel = this
					.getEmployeeCorporatecompanyDetailModelByPatient(
							this.getCurrentUserId());
			if (eccModel.getCity() != null) {
				model = this.getCityById(eccModel.getCity().intValue());
			}
		}
		return model.getId();
	}

	/**
	 * Add/Edit patient case price data in database
	 * @param model
	 * @return Integer
	 */
	public Integer setPatientcasePrice(PatientcasePriceModel model) {
		String url = this.getSearchUrlService().getPatientcasePriceBaseUrl()
				+ "/create/user/" + this.getCurrentUserId() + "/type/patient";
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
	 * Get patient case price data
	 * @param patientcase
	 * @param hcpstmp
	 * @return patientcasepriceModel
	 */
	public PatientcasePriceModel getPatientcasePriceModel(
			BigInteger patientcase, BigInteger hcpstmp) {
		String url = this.getSearchUrlService().getPatientcasePriceBaseUrl()
				+ "/get/patientcase/" + patientcase + "/hcpstmp/" + hcpstmp;
		logger.info("url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientcasePriceModel> responseEntity = restTemplate
					.getForEntity(url, PatientcasePriceModel.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets patient case booking data
	 * @param patient
	 * @param treatment
	 * @return PaitentCaseBookingModel
	 */
	public List<PatientCaseBookingModel> getPatientCaseBookingModelByPatientAndTreatment(
			BigInteger patient, Integer treatment) {
		String url = this.getSearchUrlService().getPatientCaseBookingBaseUrl()
				+ "/get/patient/" + patient + "/treatment/" + treatment;
		logger.info("url is {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PatientCaseBookingModel[]> responseEntity = restTemplate
					.getForEntity(url, PatientCaseBookingModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
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
			Double bonus_list_price) {
		Boolean result = false;
		Integer edited = 0;
		PatientcasePriceModel model = this.getPatientcasePriceModel(patientcase,
				hcpstmp);
		if (model.getId() != null) {
			model.setListPrice(list_price);
			model.setYoupayListPrice(youpay_list_price);
			model.setBonusListPrice(bonus_list_price);
			edited = this.setPatientcasePrice(model);
		}
		else {
			model.setListPrice(list_price);
			model.setYoupayListPrice(youpay_list_price);
			model.setBonusListPrice(bonus_list_price);
			model.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
					hcpstmp);
			model.setPatientCase(patientcase);
			edited = this.setPatientcasePrice(model);
		}
		if (edited > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * Get sorted state detail based on country
	 * @param country id
	 * @return sorted state list in ascending order
	 */
	public List<StateModel> getStateByCountryAsc(Integer country) {
		List<StateModel> stateList = this.getStateByCountry(country);
		Collections.sort(stateList, this.stateName);
		return stateList;
	}

	/**
	 * Get sorted state detail based on country
	 * @param country id
	 * @return sorted state list in ascending order
	 */
	public List<CityModel> getCityByCountryAsc(Integer country) {
		List<CityModel> cityList = this.getCityByCountry(country);
		Collections.sort(cityList, this.cityName);
		return cityList;
	}

	/**
	 * Get sorted state detail based on country
	 * @param country id
	 * @return sorted state list in ascending order
	 */
	public List<CityModel> getCityByStateAsc(Integer state) {
		List<CityModel> cityList = this.getCityByState(state);
		Collections.sort(cityList, this.cityName);
		return cityList;
	}

	/* Comparator for sorting the list by asc */
	public static Comparator<StateModel> stateName = new Comparator<StateModel>() {
		public int compare(StateModel s1, StateModel s2) {
			return s1.getName().compareToIgnoreCase(s2.getName());
		}
	};

	/* Comparator for sorting the list by asc */
	public static Comparator<CityModel> cityName = new Comparator<CityModel>() {
		public int compare(CityModel c1, CityModel c2) {
			return c1.getName().compareToIgnoreCase(c2.getName());
		}
	};

	/**
	 * delete user image file
	 * @param filePath
	 * @return boolean
	 */
	public Boolean deleteFile(String filePath) {
		boolean result = false;
		File file = new File(filePath);
		result = file.delete();
		return result;
	}

	/**
	 * set current user agreement value in session
	 * @param user_agreement
	 */
	public void setUserAgreement(Boolean user_agreement) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			user.setUserAgreement(user_agreement);
		}
	}

	/**
	 * Get current user agreement value
	 * @return boolean
	 */
	public Boolean getUserAgreement() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			PatientModel pm = this.getPatientById(((UserModel) myuser).getId());
			return pm.getUserAgreement();
		}
		return false;
	}

	/**
	 * Checks if current user is associate user or not
	 * @return true
	 */
	public Boolean getAssociateUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user.getAssociateUser();
		}
		return false;
	}

	/**
	 * Gets current user logged url
	 * @return string
	 */
	public String getUserUrl() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user.getUserUrl();
		}
		return null;
	}

	/**
	 * Gets current associate user id
	 * @return BigInteger
	 */
	public BigInteger getAssociateId() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user.getAssociateId();
		}
		return null;
	}

	/**
	 * Gets user dependent id
	 * @return BigInteger
	 */
	public BigInteger getDependent() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user.getDependent();
		}
		return null;
	}

	/**
	 * Gets associate user belongs corporate company patient details
	 * @param associateUser
	 * @return CorporatecompanyPatientModel list
	 */
	public List<CorporatecompanyPatientModel> getCorporatecompanyPatientModel(
			BigInteger associateUser) {
		String url = this.getSearchUrlService().getAssociateBaseUrl()
				+ "/getpatient/" + associateUser;
		logger.info("url is {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CorporatecompanyPatientModel[]> responseEntity = restTemplate
					.getForEntity(url, CorporatecompanyPatientModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets corporate company patient details
	 * @param associateUser
	 * @param search
	 * @param cc
	 * @return CorporatecompanyPatientModel list
	 */
	public List<CorporatecompanyPatientModel> getCorporatecompanyPatientModel(
			BigInteger associateUser, String search, BigInteger cc) {
		String url = this.getSearchUrlService().getAssociateBaseUrl()
				+ "/get/corporate-company/" + associateUser + "/" + search + "/"
				+ cc;
		logger.info("url is {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CorporatecompanyPatientModel[]> responseEntity = restTemplate
					.getForEntity(url, CorporatecompanyPatientModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets associate user corporate company list
	 * @param associateUser
	 * @return corporate company patient list
	 */
	public List<Corporatecompany> getCorporatecompanyList(
			BigInteger associateUser) {
		String url = this.getSearchUrlService().getAssociateBaseUrl()
				+ "/get/corporate-company/" + associateUser;
		logger.info("url is {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Corporatecompany[]> responseEntity = restTemplate
					.getForEntity(url, Corporatecompany[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets corporate company patient list
	 * @param search
	 * @param cc
	 * @return CorporatecompanyPatientModel list
	 */
	public List<CorporatecompanyPatientModel> getCorporateCompanyPatientList(
			String search, BigInteger cc) {
		logger.info("search {}", search);
		if (search.equals("") || search == null || search.isEmpty()) {
			search = null;
		}
		List<CorporatecompanyPatientModel> corporatecompanyList = this
				.getCorporatecompanyPatientModel(this.getCurrentUserId(),
						search, cc);
		return corporatecompanyList;
	}

	/**
	 * Gets patient corporate company detail
	 * @param patient
	 * @return Corporatecompany
	 */
	public Corporatecompany getCorporatecompanyByPatient(BigInteger patient) {
		String url = this.getCorporatecompanyUrl() + "/get/patient/" + patient;
		logger.info("corporate company url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Corporatecompany> responseEntity = restTemplate
					.getForEntity(url, Corporatecompany.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets corporate company detail for url
	 * @param hostProto
	 * @param hostUrl
	 * @return
	 */
	public Corporatecompany getCorporatecompanyByWhitelableUrl(String hostProto,
			String hostUrl) {
		String url = this.getCorporatecompanyUrl() + "/get/" + hostProto + "/"
				+ hostUrl + "/";
		logger.info("corporate company url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Corporatecompany> responseEntity = restTemplate
					.getForEntity(url, Corporatecompany.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets association detail for url
	 * @param hostProto
	 * @param hostUrl
	 * @return AssociationModel
	 */
	public AssociationModel getAssociationByWhitelableUrl(String hostProto,
			String hostUrl) {
		String url = this.getAssociationUrl() + "/get/" + hostProto + "/"
				+ hostUrl + "/";
		logger.info("association  whitelable url found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<AssociationModel> responseEntity = restTemplate
					.getForEntity(url, AssociationModel.class);
			return responseEntity.getBody();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Get current user theme
	 * @param HttpServletRequest
	 * @return string
	 */
	public String getUserTheme(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			if (user.getUserTheme() != null) {
				return user.getUserTheme() + "/";
			}
		}
		else {
			String hostProto = request.getHeader("X-Forwarded-Proto");
			String hostUrl = request.getHeader("X-Forwarded-Host");
			String url, proto;
			logger.info("request header {}", hostUrl);
			if (hostUrl == null) {
				url = request.getServerName();
				proto = request.getScheme();
			}
			else {
				url = hostUrl;
				proto = hostProto;
			}
			Corporatecompany model = this
					.getCorporatecompanyByWhitelableUrl(proto, url);
			if (model.getId() != null && model.getTheme() != null) {
				return model.getTheme() + "/";
			}
			else {
				AssociationModel associationModel = this
						.getAssociationByWhitelableUrl(proto, url);
				if (associationModel.getId() != null
						&& associationModel.getTheme() != null) {
					return associationModel.getTheme() + "/";
				}
			}
		}
		return null;
	}

	/**
	 * Check user profile is show or not
	 * @return boolean
	 */
	public Boolean getIsProfileShow() {
		return this.getSearchUrlService().getIsProfileShow();
	}

	/**
	 * Gets associate user patient result pagination limit
	 * @return Integer
	 */
	public Integer getAdminUserPaginationLimit() {
		return this.getSearchUrlService().getPaginationLimit();
	}

	/**
	 * Gets associate user details
	 * @param email
	 * @return AssociateModel
	 */
	public AssociateModel getAssociateByEmail(String email) {
		String url = this.getSearchUrlService().getAssociateBaseUrl()
				+ "/get/email/" + email + "/active/" + 1;
		logger.info("Url Found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<AssociateModel> responseEntity = restTemplate
					.getForEntity(url, AssociateModel.class);
			AssociateModel model = responseEntity.getBody();
			return model;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Gets associate user details
	 * @param id
	 * @return AssociateModel
	 */
	public AssociateModel getAssociateById(BigInteger id) {
		String url = this.getSearchUrlService().getAssociateBaseUrl() + "/get/"
				+ id;
		logger.info("Url Found {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<AssociateModel> responseEntity = restTemplate
					.getForEntity(url, AssociateModel.class);
			AssociateModel model = responseEntity.getBody();
			return model;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Get current user url
	 * @param request
	 * @return string
	 */
	public String getCurrentUrl(HttpServletRequest request) {
		String hostProto = request.getHeader("X-Forwarded-Proto");
		String hostUrl = request.getHeader("X-Forwarded-Host");
		logger.info("request header {}", hostUrl);
		if (hostUrl == null) {
			hostUrl = request.getScheme() + "://" + request.getServerName();
		}
		else {
			hostUrl = hostProto + "://" + hostUrl;
		}
		return hostUrl;
	}

	/**
	 * Gets current user host url
	 * @param url
	 * @return String
	 */
	public String getHostUrl(String url) {
		String hostUrl = url;
		if (!this.getSearchUrlService().getEnvironment()
				.equalsIgnoreCase("production")) {
			hostUrl = this.getSearchUrlService().getHostUrl();
		}
		return hostUrl;
	}

	/**
	 * check if user email is valid then send reset password email
	 * @param email
	 * @param currentUrl
	 * @return boolean false if user email exist as a patient or associate user
	 */
	public boolean checkForgotUserEmail(String email, String currentUrl) {
		boolean errorFound = false;
		try {
			PatientModel patient = this.getPatientByEmail(email);
			if (patient.getId() != null) {
				Corporatecompany ccModel = this
						.getCorporatecompanyByPatient(patient.getId());
				// If whiteLabelURL is null, then patient is not part of corporate company. 
				// Findme: Will be better to check it properly and not by checking the whitelabel field
				if (ccModel.getWhitelabelUrl() != null && !ccModel.getWhitelabelUrl().equalsIgnoreCase(currentUrl)) {
					errorFound = true;
				}
				else {
					mailService.sendResetMail(email, "Reset Password",
							"Please click below url to change your password.",
							"reset.html", patient.getId().intValue(),
							patient.getFirstName(), patient.getPassword(), "p",
							this.getHostUrl(currentUrl));
					errorFound = false;
				}
			}
			else {
				AssociateModel associateModel = this.getAssociateByEmail(email);
				if (associateModel.getId() != null) {
					if (associateModel.getAssociation() != null) {
						AssociationModel associationModel = this
								.getAssociatonModelById(
										associateModel.getAssociation());
						if (!associationModel.getWhitelabelUrl()
								.equalsIgnoreCase(currentUrl)) {
							errorFound = true;
						}
						else {
							mailService.sendResetMail(email, "Reset Password",
									"Please click below url to change your password.",
									"reset.html",
									associateModel.getId().intValue(),
									associateModel.getFirstName(),
									associateModel.getPassword(), "a",
									this.getHostUrl(currentUrl));
							errorFound = false;
						}
					}
				}
				else {
					errorFound = true;
				}
			}
		}
		catch (Exception ex) {
			errorFound = true;
			logger.info("Exception found {}", ex.getMessage());
		}
		return errorFound;
	}

	/**
	 * reset password for patient or association user
	 * @param resetform
	 * @param currentUrl
	 * @return boolean true if password reset
	 */
	public boolean resetPassword(ResetPasswordForm resetform,
			String currentUrl) {
		boolean errorFound = false;
		try {
			if (resetform.getId() != null && resetform.getOldPassword() != null
					&& resetform.getType() != null) {
				Integer id = 0;
				if (resetform.getType().equalsIgnoreCase("p")) {
					Corporatecompany ccModel = this
							.getCorporatecompanyByPatient(
									BigInteger.valueOf(resetform.getId()));
					logger.info("user whitelabel {}",
							ccModel.getWhitelabelUrl());
					logger.info("user currrenturi {}", currentUrl);

					// If whiteLabelURL is null, then patient is not part of corporate company. 
					// Findme: Will be better to check it properly and not by checking the whitelabel field
					if (ccModel.getWhitelabelUrl() != null && !ccModel.getWhitelabelUrl().equalsIgnoreCase(currentUrl)) {
						logger.info("error found : user url not matched");
						errorFound = true;
					}
					else {
						id = this.resetPassword(resetform.getId(),
								resetform.getOldPassword(),
								resetform.getNewPassword());
					}
				}
				else if (resetform.getType().equalsIgnoreCase("a")) {
					AssociateModel associateModel = this.getAssociateById(
							BigInteger.valueOf(resetform.getId()));
					if (associateModel.getId() != null) {
						if (associateModel.getAssociation() != null) {
							AssociationModel associationModel = this
									.getAssociatonModelById(
											associateModel.getAssociation());
							logger.info("associate user whitelabel url {}",
									associationModel.getWhitelabelUrl());
							logger.info("associate user current url {}",
									currentUrl);
							if (!associationModel.getWhitelabelUrl()
									.equalsIgnoreCase(currentUrl)) {
								logger.info(
										"error found : associate user url not matched");
								errorFound = true;
							}
							else {
								id = this.associateUserPasswordReset(
										resetform.getId(),
										resetform.getOldPassword(),
										resetform.getNewPassword());
							}
						}
					}
				}
				errorFound = (id == 0);
			}
		}
		catch (Exception ex) {
			errorFound = true;
			logger.info("Exception found {}", ex.getMessage());
		}
		return errorFound;
	}

	/**
	 * set patient user_agreement true in database
	 * @return 1
	 */
	public Integer setUserAgreement() {
		PatientModel pm = this.getPatientById(this.getCurrentUserId());
		pm.setUserAgreement(true);
		this.registerPatient(pm);
		return 1;
	}

	/**
	 * Gets user selected hospital practitioner details
	 * @param practitionerModelList
	 * @param practitionerId
	 * @return PractitionerModel
	 */
	public PractitionerModel getSelectedPractitionerModel(
			List<PractitionerModel> practitionerModelList,
			Integer practitionerId) {
		Set<Integer> result = new HashSet<Integer>();
		PractitionerModel practitionerModel = new PractitionerModel();
		if (!practitionerModelList.isEmpty()) {
			for (PractitionerModel p : practitionerModelList) {
				if (result.add(p.getId()) && p.getId().equals(practitionerId)) {
					practitionerModel = p;
				}
			}
		}
		return practitionerModel;
	}

	/**
	 * check patientConference
	 * @param model
	 * @return
	 */
	public boolean editPatientConference(BigInteger patientcase,
			BigInteger hcpstmp) {
		PatientConferenceModel patientConferenceModel = new PatientConferenceModel();
		patientConferenceModel.setStatus("Created");
		patientConferenceModel.setConferenceDt("1970-01-01");
		patientConferenceModel.setPatientCase(patientcase);
		patientConferenceModel
				.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
						hcpstmp);
		List<PatientConferenceModel> patientconference = this
				.getPatientConferenceModel(patientcase, hcpstmp);
		boolean found = false;
		boolean alreadyExist = false;
		for (PatientConferenceModel p : patientconference) {
			if (p.getId() != null) {
				patientConferenceModel.setId(p.getId());
				patientConferenceModel.setTimezone(p.getTimezone());
				this.setPatientConference(patientConferenceModel);
				found = false;
				alreadyExist = true;
				break;
			}
		}
		if (!alreadyExist) {
			this.setPatientConference(patientConferenceModel);
			found = true;
		}
		return found;
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
	public void addNewPatientCase(BigInteger patientcase, BigInteger hcpstmp,
			BigInteger healthcareprovider, Double lp, Double ylp, Double blp,
			PractitionerModel practitionerModel) {
		String emailAddress = this.getCurrentUserEmail();
		if (this.getIsCorporatePatient()) {
			EmployeeCorporatecompanyDetailModel employeeCorporatecompanyDetailModel = new EmployeeCorporatecompanyDetailModel();
			employeeCorporatecompanyDetailModel = this
					.getEmployeeCorporatecompanyDetailModelByPatient(
							this.getCurrentUserId());
			if (employeeCorporatecompanyDetailModel.getEmail() != null
					&& employeeCorporatecompanyDetailModel.getEmail() != "") {
				emailAddress = employeeCorporatecompanyDetailModel.getEmail();
			}
		}
		if (patientcase != null) {
			this.addPatientcasePrice(patientcase, hcpstmp, lp, ylp, blp);
			boolean found = this.editPatientConference(patientcase, hcpstmp);
			if (found) {
				PatientModel pm = this.getPatientById(this.getCurrentUserId());
				mailService.sendInterviewRequestRegisteredMail(emailAddress,
						"Thank you for your hospital choice",
						"interview_request_registered.html",
						patientcase.intValue(),
						pm.getFirstName() + " " + pm.getLastName(),
						practitionerModel.getName(),
						practitionerModel.getHealthcareproviderName(),
						practitionerModel.getTreatmentName());
				this.editPatientCaseMessage("System", BigInteger.valueOf(0),
						"System", pm.getId(), "Patient Case Created",
						"A New Patient Case is created", "read", patientcase);
			}
		}

	}
	
	

	/**
	 * get user patient case data
	 * @return user selected patient case map
	 */
	public TreeMap<BigInteger, String> getPatientcasesMap() {
		HashMap<BigInteger, String> patientcasesMap = new HashMap<BigInteger, String>();
		List<PatientcaseDetailModel> patientcases = this
				.getPatientCasesByPatientId(this.getCurrentUserId());
		BigInteger pc = null;
		for (PatientcaseDetailModel patientcase : patientcases) {
			if (patientcase.getId() != null) {
				patientcasesMap.put(patientcase.getId(),
						patientcase.getTreatmentName());
				pc = patientcase.getId();
			}
		}
		if (this.getCurrentUserModel().getPatientcase() == null) {
			this.getCurrentUserModel().setPatientcase(pc);
		}
		if (pc == null) {
			this.getCurrentUserModel().setPatientcase(null);
		}
		TreeMap<BigInteger, String> sortedPatientcase = new TreeMap<BigInteger, String>(
				patientcasesMap);
		return sortedPatientcase;
	}

	/**
	 * get hospital selected confirm icon
	 * @return right icon if user selected any hospital
	 */
	public String getHospitalSelectedIcon() {
		String icon = "";
		if (this.getCurrentUserModel().getPatientcase() != null) {
			icon = "file-right-sign";
		}
		return icon;
	}

	public String getHospitalPractitionerSelectedIcon() {
		String icon = "";
		Boolean found = false;
		if (this.getCurrentUserModel().getPatientcase() != null) {
			List<PatientConferenceDetailModel> patientConferenceList = new ArrayList<PatientConferenceDetailModel>();
			patientConferenceList = this.getPatientConferenceDetail(
					this.getCurrentUserModel().getPatientcase().intValue(),
					this.getCurrentUserId());
			if (!patientConferenceList.isEmpty()) {
				Practitioner genericPractitioner = this
						.getPractitionerByName("generic");
				for (PatientConferenceDetailModel patientConferenceDetailModel : patientConferenceList) {
					if (patientConferenceDetailModel
							.getPractitioner() != genericPractitioner.getId()) {
						found = true;
					}
				}
			}
		}
		if (found) {
			icon = "file-right-sign";
		}
		return icon;
	}

	/**
	 * get user selected hospitals data
	 * @param id
	 * @param pc
	 * @return hashmap of user selected hospitals
	 */
	public TreeMap<BigInteger, String> getSelectedHospitalList(BigInteger id,
			BigInteger pc) {
		HashMap<BigInteger, String> hospitalMap = new HashMap<BigInteger, String>();
		List<PatientConferenceDetailModel> patientConferenceList = new ArrayList<PatientConferenceDetailModel>();
		logger.info("pc {}", pc);
		if (pc != null) {
			patientConferenceList = this
					.getPatientConferenceDetail(pc.intValue(), id);
			if (!patientConferenceList.isEmpty()) {
				for (PatientConferenceDetailModel patientConferenceDetailModel : patientConferenceList) {
					if (patientConferenceDetailModel
							.getHealthcareprovider() != null) {
						hospitalMap.put(
								patientConferenceDetailModel
										.getHealthcareproviderSpecialtyTreatmentMethod(),
								patientConferenceDetailModel
										.getHealthcareproviderName());
					}
				}
			}
		}
		TreeMap<BigInteger, String> sortedHospitalMap = new TreeMap<BigInteger, String>(
				hospitalMap);
		return sortedHospitalMap;
	}

	/**
	 * get hospital speciality treatment method practitioner data
	 * @param healthcareprovider_speciality_treatment_method
	 * @return HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	public HospitalSpecialtyTreatmentMethodPractitionerModel getHospitalSpecialtyTreatmentMethodPractitionerById(
			BigInteger id) {
		String url = this.getSearchUrlService()
				.getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()
				+ "/get/" + id;
		logger.info(
				"Get Hospital Speciality Treatment Method Practitioner By id url found ={}",
				url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<HospitalSpecialtyTreatmentMethodPractitionerModel> responseEntity = restTemplate
					.getForEntity(url,
							HospitalSpecialtyTreatmentMethodPractitionerModel.class);
			return responseEntity.getBody();
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * gets current user hospital specialty treatment method id
	 * @return BigInteger
	 */
	public BigInteger getHstm() {
		BigInteger hstm = null;
		TreeMap<BigInteger, String> sortedHospitalMap = this
				.getSelectedHospitalList(this.getCurrentUserId(),
						this.getCurrentUserModel().getPatientcase());
		for (BigInteger key : sortedHospitalMap.keySet()) {
			hstm = key;
			break;
		}
		return hstm;
	}

	/**
	 * gets current user hospital_specialty_treatment_method_practitioner id
	 * @param hstm
	 * @return BigInteger
	 */
	public BigInteger getHstmp(BigInteger hstm) {
		BigInteger hstmp = null;
		List<PatientConferenceDetailModel> patientConferenceList = new ArrayList<PatientConferenceDetailModel>();
		patientConferenceList = this.getPatientConferenceDetail(
				this.getCurrentUserModel().getPatientcase().intValue(),
				this.getCurrentUserId());

		if (!patientConferenceList.isEmpty()) {
			for (PatientConferenceDetailModel patientConferenceDetailModel : patientConferenceList) {
				if (patientConferenceDetailModel
						.getHealthcareproviderSpecialtyTreatmentMethod()
						.equals(hstm)) {
					hstmp = patientConferenceDetailModel
							.getHealthcareproviderSpecialtyTreatmentMethodPractitioner();
				}
			}
		}
		return hstmp;
	}

	/**
	 * Get hospital treatment method practitioner id
	 * @param hstm
	 * @return hstmp id
	 */
	public BigInteger getSelectedHstmp(BigInteger hstm) {
		BigInteger hstmp = null;
		if (hstm != null) {
			List<PatientConferenceDetailModel> patientConferenceList = new ArrayList<PatientConferenceDetailModel>();
			patientConferenceList = this.getPatientConferenceDetail(
					this.getCurrentUserModel().getPatientcase().intValue(),
					this.getCurrentUserId());

			if (!patientConferenceList.isEmpty()) {
				for (PatientConferenceDetailModel patientConferenceDetailModel : patientConferenceList) {
					if (patientConferenceDetailModel
							.getHealthcareproviderSpecialtyTreatmentMethod()
							.equals(hstm)) {
						hstmp = patientConferenceDetailModel
								.getHealthcareproviderSpecialtyTreatmentMethodPractitioner();
					}
				}
			}
		}
		return hstmp;
	}

	/**
	 * Get hospital Practitioner details
	 * @param hstm
	 * @return list of hospitalPractitionerModel
	 */
	public List<HospitalPractitionerModel> getHstmPractitionerList(
			BigInteger hstm) {
		String url = this.getSearchUrlService()
				.getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()
				+ "/get/hstmid/" + hstm;
		logger.info(
				"Get Hospital Speciality Treatment Method Practitioner By hstm url found ={}",
				url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<HospitalPractitionerModel[]> responseEntity = restTemplate
					.getForEntity(url, HospitalPractitionerModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * update patientconference if user select already exist practitioner add
	 * default practitioner detail in databse if user inpur practitioner name
	 * add hospital treatment method practitioner if user inpur practitioner
	 * name
	 * @param form
	 * @return true if user select practitioner request updated
	 */
	public Boolean setHosptialPracititoner(SelectDoctorForm form) {
		/*
		 * logger.info("selected practitioner {}",form.getSelectedHstmp());
		 * logger.info("selected practitioner first name {}"
		 * ,form.getFirstName()); logger.info(
		 * "selected practitioner last name {}",form.getLastName());
		 */
		BigInteger currentHstmp = this.getHstmp(form.getHstm());
		logger.info("current practitioner hstmp id {}", currentHstmp);
		logger.info("select booking date {}", form.getBookingDate());
		if (form.getSelectedHstmp() != null) {
			this.updatePatientConference(
					this.getCurrentUserModel().getPatientcase(), currentHstmp,
					form.getSelectedHstmp());
			this.updatePatientcasePrice(
					this.getCurrentUserModel().getPatientcase(), currentHstmp,
					form.getSelectedHstmp());
			if (form.getBookingDate() != null) {
				this.updatePatientcaseBooking(
						this.getCurrentUserModel().getPatientcase(),
						currentHstmp, form.getSelectedHstmp(),
						form.getBookingDate());
			}
		}
		else if (!form.getFirstName().trim().isEmpty() && form.getFirstName().trim().length() > 0) {
			Practitioner genericPractitioner = this
					.getPractitionerByName("generic");
			Double healthcareproviderPrice = 0.0;
			BigInteger role = null;
			BigInteger type = null;
			if (genericPractitioner.getId() != null) {
				role = genericPractitioner.getRole();
				type = genericPractitioner.getType();
				HospitalSpecialtyTreatmentMethodPractitionerModel hcpstmpGenericModel = this
						.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(
								form.getHstm(), genericPractitioner.getId());
				if (hcpstmpGenericModel.getId() != null) {
					healthcareproviderPrice = hcpstmpGenericModel
							.getHealthcareproviderPrice();
				}
			}
			Integer id = this.setDefaultPractiioner(form.getFirstName(),
					form.getLastName(), role, type);
			logger.info("practitioner id {}", id);
			if (id != null && id != 0) {

				HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
				hstmpModel.setCurrency("USD");
				hstmpModel.setPractitioner(BigInteger.valueOf(id));
				hstmpModel.setHealthcareproviderPrice(healthcareproviderPrice);
				hstmpModel.setPractitionerPrice(0.0);
				hstmpModel.setAnesthesiaPrice(0.0);
				hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(
						form.getHstm());
				hstmpModel.setActive(true);
				hstmpModel.setVerified(false);
				int result = this
						.setHospitalSpecialtyTreatmentMethodPractitioner(
								hstmpModel);
				if (result > 0) {
					HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModels = this
							.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(
									form.getHstm(), BigInteger.valueOf(id));
					if (hstmpModels.getId() != null) {
						this.updatePatientConference(
								this.getCurrentUserModel().getPatientcase(),
								currentHstmp, hstmpModels.getId());
						this.updatePatientcasePrice(
								this.getCurrentUserModel().getPatientcase(),
								currentHstmp, hstmpModels.getId());
					}
				}

			}
		}
		return true;
	}

	/**
	 * update patientconference data
	 * @param patientcase
	 * @param hcpstmp
	 * @param update_hcpstmp
	 * @return true if patientconference data updated
	 */
	public boolean updatePatientConference(BigInteger patientcase,
			BigInteger hcpstmp, BigInteger update_hcpstmp) {
		List<PatientConferenceModel> patientconference = this
				.getPatientConferenceModel(patientcase, hcpstmp);
		boolean found = false;
		for (PatientConferenceModel p : patientconference) {
			if (p.getId() != null) {
				p.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
						update_hcpstmp);
				this.setPatientConference(p);
				found = true;
			}
		}
		return found;
	}

	/**
	 * update patientcase price data
	 * @param patientcase
	 * @param hcpstmp
	 * @param update_hcpstmp
	 * @return true if patientcase price data updated
	 */
	public boolean updatePatientcasePrice(BigInteger patientcase,
			BigInteger hcpstmp, BigInteger update_hcpstmp) {
		PatientcasePriceModel model = this.getPatientcasePriceModel(patientcase,
				hcpstmp);
		boolean found = false;
		if (model.getId() != null) {
			model.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
					update_hcpstmp);
			this.setPatientcasePrice(model);
			found = true;
		}
		return found;
	}

	/**
	 * update patientconference data
	 * @param patientcase
	 * @param hcpstmp
	 * @param update_hcpstmp
	 * @return true if patientconference data updated
	 */
	public boolean updatePatientcaseBooking(BigInteger patientcase,
			BigInteger hcpstmp, BigInteger update_hcpstmp, String bookingDt) {
		boolean found = false;
		try {
			List<PatientCaseBookingModel> patientcasebooking = this
					.getPatientCaseBookingModel(patientcase, hcpstmp);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			DateFormat dateFormat1 = new SimpleDateFormat("MMM dd, yyyy");
			Date date = dateFormat1.parse(bookingDt);
			String bookingDate = dateFormat.format(date);
			for (PatientCaseBookingModel p : patientcasebooking) {
				if (p.getId() != null) {
					p.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
							update_hcpstmp);
					p.setBookingDt(bookingDate);
					this.setPatientCaseBooking(p);
					found = true;
				}
			}
			if (!found) {
				PatientCaseBookingModel model = new PatientCaseBookingModel();
				model.setReference("DG-0-" + this.getCurrentUserId());
				model.setStatus("Open");
				model.setBookingDt(bookingDate);
				model.setPatientCase(patientcase);
				model.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
						update_hcpstmp);
				logger.info("add new booking with date {}", bookingDate);
				this.setPatientCaseBooking(model);
				found = true;
			}
		}
		catch (Exception ex) {
			logger.info("Date exception found {}", ex.getMessage());
		}
		return found;
	}

	/**
	 * Add/Edit practitioner data in database
	 * @param practitioner model
	 * @return id
	 */
	public Integer setPractitioner(Practitioner model) {
		String url = this.getSearchUrlService().getPractitionerBaseUrl()
				+ "/create/user/" + this.getCurrentUserId() + "/type/patient/";
		logger.info("Pracititoner create url found ={}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Integer> responseEntity = restTemplate
					.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * Get Practitioner details
	 * @param id
	 * @return practitioner
	 */
	public Practitioner getPractitionerById(BigInteger id) {
		String url = this.getSearchUrlService().getPractitionerBaseUrl()
				+ "/get/" + id;
		logger.info("Practitioner url by id found ={}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Practitioner> responseEntity = restTemplate
					.getForEntity(url, Practitioner.class);
			return responseEntity.getBody();
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * Get Practitioner details
	 * @param name
	 * @return Practitioner model
	 */
	public Practitioner getPractitionerByName(String name) {
		String url = this.getSearchUrlService().getPractitionerBaseUrl()
				+ "/get-name/" + name;
		logger.info("Practitioner url by name found ={}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Practitioner> responseEntity = restTemplate
					.getForEntity(url, Practitioner.class);
			return responseEntity.getBody();
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * Get HospitalSpecialtyTreatmentMethodPractitioner details
	 * @param healthcareprovider_specialty_treatment_method
	 * @param practitioner
	 * @return hospital specialty treatment method practitioner
	 */
	public HospitalSpecialtyTreatmentMethodPractitionerModel getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(
			BigInteger hstm, BigInteger practitioner) {
		String url = this.getSearchUrlService()
				.getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()
				+ "/get/hstm/" + hstm + "/practitioner/" + practitioner;
		logger.info(
				"Get Hospital Speciality Treatment Method Practitioner By Healthcareprovider And Practitioner specialty treatment method url found ={}",
				url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<HospitalSpecialtyTreatmentMethodPractitionerModel> responseEntity = restTemplate
					.getForEntity(url,
							HospitalSpecialtyTreatmentMethodPractitionerModel.class);
			return responseEntity.getBody();
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * Adds/Edits a HospitalSpecialtyTreatmentMethodPractitioner to the database
	 * @param HospitalSpecialtyTreatmentMethodPractitioner
	 * @return integer
	 */
	public Integer setHospitalSpecialtyTreatmentMethodPractitioner(
			HospitalSpecialtyTreatmentMethodPractitionerModel model) {
		String url = this.getSearchUrlService()
				.getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()
				+ "/create/user/" + this.getCurrentUserId() + "/type/patient/";
		logger.info(
				"Hospital Specialty Treatment Method Practitioner create url found ={}",
				url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<Integer> responseEntity = restTemplate
					.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * Adds/Edits a default practitioner details to the database
	 * @param first_name
	 * @param last_name
	 * @return inserted practitioner id
	 */
	public Integer setDefaultPractiioner(String first_name, String last_name,
			BigInteger role, BigInteger type) {
		String time = String.valueOf(System.currentTimeMillis());
		String email = first_name.toLowerCase().replace(" ", "") + time
				+ "@doctorglobe.com";
		Practitioner model = new Practitioner();
		model.setTitle("Dr");
		model.setFirstName(first_name);
		model.setLastName(last_name);
		model.setGender("U");
		model.setEmail(email);
		model.setPassword("dummypassword");
		model.setUsaCertification("None");
		model.setUsaTraining(false);
		model.setType(type);
		model.setRole(role);
		return this.setPractitioner(model);
	}

	/**
	 * check healthcareprovider if patient already selected
	 * @param patient
	 * @param treatment
	 * @param hcpstmp
	 * @return boolean
	 */
	public Boolean checkPractitionerByPatientTreatment(BigInteger pc,
			Integer treatment, BigInteger hstmp) {
		Boolean found = false;
		List<PatientConferenceModel> patientConference = new ArrayList<PatientConferenceModel>();
		HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = this
				.getHospitalSpecialtyTreatmentMethodPractitionerById(hstmp);
		if (hstmpModel.getId() != null) {
			List<HospitalPractitionerModel> hospitalPractitionerModel = this
					.getHstmPractitionerList(hstmpModel
							.getHealthcareproviderSpecialtyTreatmentMethod());
			if (!hospitalPractitionerModel.isEmpty()) {
				for (HospitalPractitionerModel hpModel : hospitalPractitionerModel) {
					patientConference = this.getPatientConferenceModel(pc,
							hpModel.getId());
					if (!patientConference.isEmpty()) {
						found = true;
						break;
					}
				}
			}
		}
		return found;
	}

	/**
	 * Gets patient case id for treatment
	 * @param treatment
	 * @return BigInteger
	 */
	public BigInteger getPatientcaseByTreatment(Integer treatment) {
		List<PatientcaseDetailModel> patientcases = this
				.getPatientCasesByPatientId(this.getCurrentUserId());
		BigInteger pc = null;
		if (!patientcases.isEmpty()) {
			for (PatientcaseDetailModel patientcase : patientcases) {
				if (patientcase.getId() != null && patientcase.getTreatment()
						.equals(BigInteger.valueOf(treatment))) {
					pc = patientcase.getId();
					break;
				}
			}
		}
		return pc;
	}

	/**
	 * Remove generic doctor in hospital practitioner list
	 * @param hstm
	 * @return HospitalPractitionerModel list
	 */
	public List<HospitalPractitionerModel> getWithoutGenericHstmPractitionerList(
			BigInteger hstm) {
		if (hstm != null) {
			List<HospitalPractitionerModel> hospitalPractitionerList = this
					.getHstmPractitionerList(hstm);
			List<HospitalPractitionerModel> hpList = new ArrayList<HospitalPractitionerModel>();
			Practitioner genericPractitioner = this
					.getPractitionerByName("generic");
			BigInteger practitionerId = BigInteger.valueOf(0);
			if (genericPractitioner.getId() != null) {
				practitionerId = genericPractitioner.getId();
			}
			for (HospitalPractitionerModel hpModel : hospitalPractitionerList) {
				if (hpModel.getPractitioner() != practitionerId) {
					hpList.add(hpModel);
				}
			}
			return hpList;
		}
		return null;
	}

	/**
	 * Gets patient case treatment name
	 * @return string
	 */
	public String getPatientCaseTreatmentName() {
		String treatmentName = null;
		if (this.getCurrentUserModel().getPatientcase() != null) {
			List<PatientcaseDetailModel> patientcases = this
					.getPatientCasesByPatientId(this.getCurrentUserId());
			if (!patientcases.isEmpty()) {
				for (PatientcaseDetailModel patientcase : patientcases) {
					if (patientcase.getId().equals(
							this.getCurrentUserModel().getPatientcase())) {
						treatmentName = patientcase.getTreatmentName();
						break;
					}
				}
			}
		}
		return treatmentName;
	}

	/**
	 * Check user myarea is show or not
	 * @return boolean
	 */
	public Boolean getIsMyareaShow() {
		return this.getSearchUrlService().getIsMyareaShow();
	}

	/**
	 * Get Added Procedure Date
	 * @param hcpstmp
	 * @return bookingDate
	 */
	public String getBookingDate(BigInteger hcpstmp) {
		String bookingDate = "";
		try {
			if (this.getCurrentUserModel().getPatientcase() != null) {
				List<PatientCaseBookingModel> patientcasebooking = this
						.getPatientCaseBookingModel(
								this.getCurrentUserModel().getPatientcase(),
								hcpstmp);
				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				DateFormat dateFormat1 = new SimpleDateFormat("MMM dd, yyyy");
				for (PatientCaseBookingModel p : patientcasebooking) {
					if (p.getId() != null) {
						Date date = dateFormat.parse(p.getBookingDt());
						bookingDate = dateFormat1.format(date);
					}
				}
			}
		}
		catch (Exception ex) {
			logger.info("Date exception found {}", ex.getMessage());
		}
		return bookingDate;
	}

}