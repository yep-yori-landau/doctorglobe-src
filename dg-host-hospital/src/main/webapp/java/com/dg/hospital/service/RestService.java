package com.dg.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dg.hospital.form.HospitalForm;
import com.dg.hospital.model.AccreditationModel;
import com.dg.hospital.model.AclRolesModel;
import com.dg.hospital.model.AmenityModel;
import com.dg.hospital.model.AttestationsModel;
import com.dg.hospital.model.ChainModel;
import com.dg.hospital.model.CityModel;
import com.dg.hospital.model.CountryModel;
import com.dg.hospital.model.CuisineModel;
import com.dg.hospital.model.EquipmentModel;
import com.dg.hospital.model.FeatureModel;
import com.dg.hospital.model.HospitalAccreditationModel;
import com.dg.hospital.model.HospitalAmenityModel;
import com.dg.hospital.model.HospitalCuisineModel;
import com.dg.hospital.model.HospitalEquipmentModel;
import com.dg.hospital.model.HospitalHospitaltypeModel;
import com.dg.hospital.model.HospitalInsuranceModel;
import com.dg.hospital.model.HospitalLanguageModel;
import com.dg.hospital.model.HospitalModel;
import com.dg.hospital.model.HospitalPhotoModel;
import com.dg.hospital.model.HospitalPractitionerModel;
import com.dg.hospital.model.HospitalRatingsModel;
import com.dg.hospital.model.HospitalSpecialtyModel;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodModel;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodPractitionerModel;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodPractitionerStatModel;
import com.dg.hospital.model.HospitalUnitFeatureModel;
import com.dg.hospital.model.HospitaltypeModel;
import com.dg.hospital.model.HospitalunitModel;
import com.dg.hospital.model.InsuranceModel;
import com.dg.hospital.model.MethodModel;
import com.dg.hospital.model.PractitionerAttestationsModel;
import com.dg.hospital.model.PractitionerLanguageModel;
import com.dg.hospital.model.PractitionerModel;
import com.dg.hospital.model.PractitionertypeModel;
import com.dg.hospital.model.RatingcompaniesModel;
import com.dg.hospital.model.SpecialtyModel;
import com.dg.hospital.model.SpecialtyTreatmentModel;
import com.dg.hospital.model.StateModel;
import com.dg.hospital.model.StatsModel;
import com.dg.hospital.model.TreatmentModel;



public class RestService{
	
	private static final Logger logger = LoggerFactory.getLogger(RestService.class);
	  
	private RestUrlService restUrlService;
	
	public RestUrlService getRestUrlService()
	{
	   return this.restUrlService;
	}
	  
	public void setRestUrlService(RestUrlService restUrlService)
	{
	   this.restUrlService = restUrlService;
	}	
	
	/**
	 * 
	 * @return hospital 
	 */
	public HospitalModel getHospital(BigInteger id){
		String url = this.getRestUrlService().getHealthcareproviderUrl()+"/get/id/"+id;
		logger.info("Hospital url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalModel> responseEntity = restTemplate.getForEntity(url, HospitalModel.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return hospital 
	 */
	public List<HospitalModel> getAllHospital(){
		String url = this.getRestUrlService().getHealthcareproviderUrl()+"/getAll";
		logger.info("Hospital url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalModel[]> responseEntity = restTemplate.getForEntity(url, HospitalModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return hospital 
	 */
	public Integer setHospital(HospitalForm model){
		String url = this.getRestUrlService().getHealthcareproviderUrl()+"/create";
		logger.info("Hospital added url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return all equipments
	 */
	public List<EquipmentModel> getAllEquipments(){
		String url = this.getRestUrlService().getEquipmentUrl()+"/getAll";
		logger.info("equipments url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<EquipmentModel[]> responseEntity = restTemplate.getForEntity(url, EquipmentModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return hospital equipments
	 */
	public List<HospitalEquipmentModel> getHospitalEquipments(BigInteger healthcareprovider){
		String url = this.getRestUrlService().getHealthcareproviderEquipmentUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("hospital equipments url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalEquipmentModel[]> responseEntity = restTemplate.getForEntity(url, HospitalEquipmentModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public Integer setHospitalEquipment(HospitalEquipmentModel model) {
		String url = this.getRestUrlService().getHealthcareproviderEquipmentUrl()+"/create";
		logger.info("Hospital Equipment url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return all accreditation
	 */
	public List<AccreditationModel> getAllAccreditation(){
		String url = this.getRestUrlService().getAccreditationUrl()+"/getAll";
		logger.info("accreditation url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<AccreditationModel[]> responseEntity = restTemplate.getForEntity(url, AccreditationModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return hospital accreditation
	 */
	public List<HospitalAccreditationModel> getHospitalAccreditation(BigInteger healthcareprovider){
		String url = this.getRestUrlService().getHealthcareproviderAccreditationUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("hospital equipments url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalAccreditationModel[]> responseEntity = restTemplate.getForEntity(url, HospitalAccreditationModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public Integer setHospitalAccreditation(HospitalAccreditationModel model) {
		String url = this.getRestUrlService().getHealthcareproviderAccreditationUrl()+"/create";
		logger.info("Hospital Accreditation url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer deleteHospitalAccreditation(BigInteger id){
		String url = this.getRestUrlService().getHealthcareproviderAccreditationUrl()+"/delete/id/"+id;
		logger.info("Hospital Accreditation Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	
	
	/**
	 * 
	 * @return all hospitaltype
	 */
	public List<HospitaltypeModel> getAllHospitaltype(){
		String url = this.getRestUrlService().getHealthcareprovidertypeUrl()+"/getAll";
		logger.info("healthcareprovidertype url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitaltypeModel[]> responseEntity = restTemplate.getForEntity(url, HospitaltypeModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return hospital hospitaltype
	 */
	public List<HospitalHospitaltypeModel> getHospitalHospitaltype(BigInteger healthcareprovider){
		String url = this.getRestUrlService().getHealthcareproviderHealthcareprovidertypeUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("Hospital Hospitaltype url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalHospitaltypeModel[]> responseEntity = restTemplate.getForEntity(url, HospitalHospitaltypeModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public Integer setHospitalHospitaltype(HospitalHospitaltypeModel model) {
		String url = this.getRestUrlService().getHealthcareproviderHealthcareprovidertypeUrl()+"/create";
		logger.info("Hospital Hospitaltype url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer deleteHospitalHospitaltype(BigInteger id){
		String url = this.getRestUrlService().getHealthcareproviderHealthcareprovidertypeUrl()+"/delete/id/"+id;
		logger.info("Hospital Hospital type Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return all feature
	 */
	public List<FeatureModel> getAllFeature() {
		String url = this.getRestUrlService().getFeatureUrl()+"/getAll";
		logger.info("Feature url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<FeatureModel[]> responseEntity = restTemplate.getForEntity(url, FeatureModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return all Hospital Unit
	 */
	public List<HospitalunitModel> getAllHospitalunit() {
		String url = this.getRestUrlService().getHealthcareproviderunitUrl()+"/getAll";
		logger.info("Hospital unit url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalunitModel[]> responseEntity = restTemplate.getForEntity(url, HospitalunitModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return hospital hospitalunitfeature
	 */
	public List<HospitalUnitFeatureModel> getHospitalUnitFeature(BigInteger healthcareprovider){
		String url = this.getRestUrlService().getHealthcareproviderUnitFeatureUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("Hospital Unit Feature url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalUnitFeatureModel[]> responseEntity = restTemplate.getForEntity(url, HospitalUnitFeatureModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public Integer setHospitalUnitFeature(HospitalUnitFeatureModel model) {
		String url = this.getRestUrlService().getHealthcareproviderUnitFeatureUrl()+"/create";
		logger.info("Hospital Unit Feature create url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer deleteHospitalUnitFeature(BigInteger id){
		String url = this.getRestUrlService().getHealthcareproviderUnitFeatureUrl()+"/delete/id/"+id;
		logger.info("Hospital Unit Feature Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return all amenity
	 */
	public List<AmenityModel> getAllAmenity() {
		String url = this.getRestUrlService().getAmenityUrl()+"/getAll";
		logger.info("Amenity url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<AmenityModel[]> responseEntity = restTemplate.getForEntity(url, AmenityModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return hospital amenity
	 */
	public List<HospitalAmenityModel> getHospitalAmenity(
			BigInteger healthcareprovider) {
		String url = this.getRestUrlService().getHealthcareproviderAmenityUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("Hospital Amenity url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalAmenityModel[]> responseEntity = restTemplate.getForEntity(url, HospitalAmenityModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public Integer setHospitalAmenity(HospitalAmenityModel model) {
		String url = this.getRestUrlService().getHealthcareproviderAmenityUrl()+"/create";
		logger.info("Hospital Amenity create url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer deleteHospitalAmenity(BigInteger id){
		String url = this.getRestUrlService().getHealthcareproviderAmenityUrl()+"/delete/id/"+id;
		logger.info("Hospital Amenity Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return all cuisine
	 */
	public List<CuisineModel> getAllCuisine() {
		String url = this.getRestUrlService().getCuisineUrl()+"/getAll";
		logger.info("Cuisine url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<CuisineModel[]> responseEntity = restTemplate.getForEntity(url, CuisineModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return hospital cuisine
	 */
	public List<HospitalCuisineModel> getHospitalCuisine(
			BigInteger healthcareprovider) {
		String url = this.getRestUrlService().getHealthcareproviderCuisineUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("Hospital Cuisine url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalCuisineModel[]> responseEntity = restTemplate.getForEntity(url, HospitalCuisineModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public Integer setHospitalCuisine(HospitalCuisineModel model) {
		String url = this.getRestUrlService().getHealthcareproviderCuisineUrl()+"/create";
		logger.info("Hospital Cuisine url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}	
	
	/**
	 * 
	 * @return boolean
	 */
	public Integer deleteHospitalCuisine(BigInteger id){
		String url = this.getRestUrlService().getHealthcareproviderCuisineUrl()+"/delete/id/"+id;
		logger.info("Hospital Cuisine Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return hospital language list
	 */
	public List<HospitalLanguageModel> getHospitalLanguage(
			BigInteger healthcareprovider) {
		String url = this.getRestUrlService().getHealthcareproviderLanguageUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("Hospital Cuisine url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalLanguageModel[]> responseEntity = restTemplate.getForEntity(url, HospitalLanguageModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public Integer setHospitalLanguage(HospitalLanguageModel model) {
		String url = this.getRestUrlService().getHealthcareproviderLanguageUrl()+"/create";
		logger.info("Hospital Language create url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	public Integer deleteHospitalLanguage(Integer id) {		
		String url = this.getRestUrlService().getHealthcareproviderLanguageUrl()+"/delete/id/"+id;
		logger.info("Hospital Language Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	/**
	 * 
	 * @return all insurance
	 */
	public List<InsuranceModel> getAllInsurance(){
		String url = this.getRestUrlService().getInsuranceUrl()+"/getAll";
		logger.info("Insurance url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<InsuranceModel[]> responseEntity = restTemplate.getForEntity(url, InsuranceModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return hospital insurance
	 */
	public List<HospitalInsuranceModel> getHospitalInsurance(BigInteger healthcareprovider){
		String url = this.getRestUrlService().getHealthcareproviderInsuranceUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("Hospital Insurance url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalInsuranceModel[]> responseEntity = restTemplate.getForEntity(url, HospitalInsuranceModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return integer
	 */
	public Integer setHospitalInsurance(HospitalInsuranceModel model){
		String url = this.getRestUrlService().getHealthcareproviderInsuranceUrl()+"/create";
		logger.info("Hospital Insurance url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public Boolean deleteHospitalInsuranceByHealthcareprovider(BigInteger healthcareprovider){
		String url = this.getRestUrlService().getHealthcareproviderInsuranceUrl()+"/delete/healthcareprovider/"+healthcareprovider;
		logger.info("Hospital Insurance Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(url, Boolean.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return false;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public Integer deleteHospitalInsurance(BigInteger id){
		String url = this.getRestUrlService().getHealthcareproviderInsuranceUrl()+"/delete/id/"+id;
		logger.info("Hospital Insurance Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return hospital photo list
	 */
	public List<HospitalPhotoModel> getHospitalImages(
			BigInteger healthcareprovider) {
		String url = this.getRestUrlService().getHealthcareproviderPhotoUrl()+"/get/healthcareprovider/"+healthcareprovider;
		logger.info("Hospital Photo url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalPhotoModel[]> responseEntity = restTemplate.getForEntity(url, HospitalPhotoModel[].class);
			return Arrays.asList(responseEntity.getBody());		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @return hospital photo model
	 */
	public HospitalPhotoModel getHospitalPhotoById(
			BigInteger id) {
		String url = this.getRestUrlService().getHealthcareproviderPhotoUrl()+"/get/id/"+id;
		logger.info("Hospital Photo url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<HospitalPhotoModel> responseEntity = restTemplate.getForEntity(url, HospitalPhotoModel.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return integer
	 */
	public Integer setHospitalPhoto(HospitalPhotoModel model){
		String url = this.getRestUrlService().getHealthcareproviderPhotoUrl()+"/create";
		logger.info("Hospital Photo url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public Integer deleteHospitalPhoto(BigInteger id){
		String url = this.getRestUrlService().getHealthcareproviderPhotoUrl()+"/delete/id/"+id;
		logger.info("Hospital Photo Delete url found ={}",url);
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
			return responseEntity.getBody();		
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return null;
	}
	
	/**
	   * Search for country
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<CountryModel> getCountry() {    
	    String url = this.getRestUrlService().getCountryUrl() + "/getAll";		
	    logger.info("country url found {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<CountryModel[]> responseEntity = restTemplate.getForEntity(url, CountryModel[].class);      
	      return Arrays.asList(responseEntity.getBody());            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  /**
	   * Search for state
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<StateModel> getState() {    
	    String url = this.getRestUrlService().getStateUrl() + "/getAll";		
	    logger.info("state url found {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<StateModel[]> responseEntity = restTemplate.getForEntity(url, StateModel[].class);      
	      return Arrays.asList(responseEntity.getBody());            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  /**
	   * Search for city
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<CityModel> getCityByState() {    
	    String url = this.getRestUrlService().getCityUrl() + "/getAll";		
	    logger.info("city url found {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<CityModel[]> responseEntity = restTemplate.getForEntity(url, CityModel[].class);      
	      return Arrays.asList(responseEntity.getBody());            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  /**
	   * Search for state
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<StateModel> getStateByCountry(Integer country) {    
	    String url = this.getRestUrlService().getStateUrl() + "/get/country/"+country;		
	    logger.info("url found {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<StateModel[]> responseEntity = restTemplate.getForEntity(url, StateModel[].class);      
	      return Arrays.asList(responseEntity.getBody());            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }

	/**
	   * Search for city
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<CityModel> getCityByCountry(Integer country) {    
	    String url = this.getRestUrlService().getCityUrl() + "/get/country/"+country;		
	    logger.info("url found {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<CityModel[]> responseEntity = restTemplate.getForEntity(url, CityModel[].class);      
	      return Arrays.asList(responseEntity.getBody());            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  /**
	   * Search for city
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<CityModel> getCityByState(Integer state) {    
	    String url = this.getRestUrlService().getCityUrl() + "/get/state/"+state;		
	    logger.info("url found {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<CityModel[]> responseEntity = restTemplate.getForEntity(url, CityModel[].class);      
	      return Arrays.asList(responseEntity.getBody());            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  /**
	   * Search for city
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public CityModel getCityById(Integer id) {    
	    String url = this.getRestUrlService().getCityUrl() + "/get/id/"+id;		
	    logger.info("url found {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<CityModel> responseEntity = restTemplate.getForEntity(url, CityModel.class);      
	      return responseEntity.getBody();            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  /**
		 * 
		 * @return all chain 
		 */
		public List<ChainModel> getAllChain(){
			String url = this.getRestUrlService().getChainUrl()+"/getAll";
			logger.info("Chain url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<ChainModel[]> responseEntity = restTemplate.getForEntity(url, ChainModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return all chain 
		 */
		public List<RatingcompaniesModel> getAllRatingcompanies(){
			String url = this.getRestUrlService().getRatingcompaniesUrl()+"/getAll";
			logger.info("Chain url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<RatingcompaniesModel[]> responseEntity = restTemplate.getForEntity(url, RatingcompaniesModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}	
		
		/**
		 * 
		 * @param healthcareprovider
		 * @return hospital ratings
		 */
		public List<HospitalRatingsModel> getHospitalRatings(
				BigInteger healthcareprovider) {
			String url = this.getRestUrlService().getHealthcareproviderRatingsUrl()+"/get/healthcareprovider/"+healthcareprovider;
			logger.info("Hospital Ratings url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalRatingsModel[]> responseEntity = restTemplate.getForEntity(url, HospitalRatingsModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
	
		/**
		 * 
		 * @return integer
		 */
		public Integer setHospitalRatings(HospitalRatingsModel model){
			String url = this.getRestUrlService().getHealthcareproviderRatingsUrl()+"/create";
			logger.info("Hospital ratings create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
	
		/**
		 * 
		 * @return all currency
		 */
		public List<String> getAllCurrency(){
			ArrayList<String> currencys = new ArrayList<String>();
		    Locale[] locs = Locale.getAvailableLocales();

		    for(Locale loc : locs) {
		        try {
		            String val=Currency.getInstance(loc).getCurrencyCode();
		            if(!currencys.contains(val))
		                currencys.add(val);
		        } catch(Exception exc)
		        {
		          // logger.info("locale not found");
		        }
		        Collections.sort(currencys);
		    }
		    return currencys;
		}
		
		/**
		 * 
		 * @return all specialty
		 */
		public List<SpecialtyModel> getAllSpecialty(){
			String url = this.getRestUrlService().getSpecialtyUrl()+"/getAll";
			logger.info("Speciality url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<SpecialtyModel[]> responseEntity = restTemplate.getForEntity(url, SpecialtyModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return all specialty treatment
		 */
		public List<SpecialtyTreatmentModel> getAllSpecialtyTreatment(){
			String url = this.getRestUrlService().getSpecialtyTreatmentUrl()+"/getAll";
			logger.info("Speciality Treatment url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<SpecialtyTreatmentModel[]> responseEntity = restTemplate.getForEntity(url, SpecialtyTreatmentModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return all specialty treatment
		 */
		public List<SpecialtyTreatmentModel> getSpecialtyTreatmentBySpeciality(BigInteger specialty){
			String url = this.getRestUrlService().getSpecialtyTreatmentUrl()+"/get/specialty/"+specialty;
			logger.info("Find Speciality Treatment by speciality url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<SpecialtyTreatmentModel[]> responseEntity = restTemplate.getForEntity(url, SpecialtyTreatmentModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param id
		 * @return hospital specialty
		 */
		public HospitalSpecialtyModel getHospitalSpecialtyById(
				BigInteger id) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyUrl()+"/get/id/"+id;
			logger.info("Get Hospital Specialty By id url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyModel> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyModel.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareprovider
		 * @return hospital specialty
		 */
		public List<HospitalSpecialtyModel> getHospitalSpecialty(
				BigInteger healthcareprovider) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyUrl()+"/get/healthcareprovider/"+healthcareprovider;
			logger.info("Get Hospital Specialty By Healthcareprovider url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyModel[]> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param id 
		 * @return boolean
		 */
		public Integer deleteHospitalSpecialty(BigInteger id){
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyUrl()+"/delete/id/"+id;
			logger.info("Hospital Specialty Delete url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param HospitalSpecialtyModel
		 * @return integer
		 */
		public Integer setHospitalSpecialty(HospitalSpecialtyModel model){
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyUrl()+"/create";
			logger.info("Hospital Specialty create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return all treatment
		 */
		public List<TreatmentModel> getAllTreatment(){
			String url = this.getRestUrlService().getTreatmentUrl()+"/getAll";
			logger.info("Speciality url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<TreatmentModel[]> responseEntity = restTemplate.getForEntity(url, TreatmentModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param id
		 * @return hospital specialty treatment method
		 */
		public HospitalSpecialtyTreatmentMethodModel getHospitalSpecialtyTreatmentMethodById(
				BigInteger id) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodUrl()+"/get/id/"+id;
			logger.info("Get Hospital Specialty Treatment Method By Id url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodModel> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodModel.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareproviderSpecialty
		 * @return hospital specialty treatment method
		 */
		public List<HospitalSpecialtyTreatmentMethodModel> getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(
				BigInteger healthcareproviderSpecialty) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodUrl()+"/get/healthcareprovider_specialty/"+healthcareproviderSpecialty;
			logger.info("Get Hospital Specialty Treatment Method By Healthcareprovider Speciality url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodModel[]> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareproviderSpecialty
		 * @param treatment
		 * @return hospital specialty treatment method
		 */
		public List<HospitalSpecialtyTreatmentMethodModel> getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatment(
				BigInteger healthcareproviderSpecialty,BigInteger treatment) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodUrl()+"/get/healthcareprovider_specialty/"+healthcareproviderSpecialty+"/treatment/"+treatment;
			logger.info("Get Hospital Specialty Treatment Method By Healthcareprovider Speciality url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodModel[]> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareproviderSpecialty
		 * @param treatment
		 * @param method
		 * @return hospital specialty treatment method
		 */
		public HospitalSpecialtyTreatmentMethodModel getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatmentMethod(
				BigInteger healthcareproviderSpecialty,BigInteger treatment,BigInteger method) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodUrl()+"/get/healthcareprovider_specialty/"+healthcareproviderSpecialty+"/treatment/"+treatment+"/method/"+method;
			logger.info("Get Hospital Specialty Treatment Method By Healthcareprovider Speciality url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodModel> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodModel.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareprovider
		 * @return hospital specialty treatment method
		 */
		public List<HospitalSpecialtyTreatmentMethodModel> getHospitalSpecialtyTreatmentMethodByHealthcareprovider(
				BigInteger healthcareprovider) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodUrl()+"/get/healthcareprovider/"+healthcareprovider;
			logger.info("Get Hospital Specialty Treatment Method By Healthcareprovider url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodModel[]> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param HospitalSpecialtyModel
		 * @return integer
		 */
		public Integer setHospitalSpecialtyTreatmentMethod(HospitalSpecialtyTreatmentMethodModel model){
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodUrl()+"/create";
			logger.info("Hospital Specialty Treatment Method create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param id 
		 * @return boolean
		 */
		public Integer deleteHospitalSpecialtyTreatmentMethod(BigInteger id){
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodUrl()+"/delete/id/"+id;
			logger.info("Hospital Specialty Treatment Method Delete url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return all method
		 */
		public List<MethodModel> getAllMethod(){
			String url = this.getRestUrlService().getMethodUrl()+"/getAll";
			logger.info("Speciality url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<MethodModel[]> responseEntity = restTemplate.getForEntity(url, MethodModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param HospitalSpecialtyModel
		 * @return integer
		 */
		public Integer setHospitalSpecialtyTreatmentMethodPractitioner(HospitalSpecialtyTreatmentMethodPractitionerModel model){			
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()+"/create";
			logger.info("Hospital Specialty Treatment Method Practitioner create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareprovider_specialty_treatment_method
		 * @return hospital specialty treatment method practitioner
		 */
		public List<HospitalSpecialtyTreatmentMethodPractitionerModel> getHospitalSpecialtyTreatmentMethodPractitionerByHstm(
				BigInteger hstm) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()+"/get/hstm/"+hstm;
			logger.info("Get Hospital Speciality Treatment Method Practitioner By Healthcareprovider specialty treatment method url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodPractitionerModel[]> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodPractitionerModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareprovider_specialty_treatment_method
		 * @param practitioner
		 * @return hospital specialty treatment method practitioner
		 */
		public HospitalSpecialtyTreatmentMethodPractitionerModel getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(
				BigInteger hstm,BigInteger practitioner) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()+"/get/hstm/"+hstm+"/practitioner/"+practitioner;
			logger.info("Get Hospital Speciality Treatment Method Practitioner By Healthcareprovider And Practitioner specialty treatment method url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodPractitionerModel> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodPractitionerModel.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareprovider_speciality_treatment_method
		 * @return hospital speciality treatment method practitioner
		 */
		public List<HospitalSpecialtyTreatmentMethodPractitionerModel> getHospitalSpecialtyTreatmentMethodPractitionerByHealthcareprovider(
				BigInteger healthcareprovider) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()+"/get/healthcareprovider/"+healthcareprovider;
			logger.info("Get Hospital Specialty Treatment Method Practitioner By Healthcareprovider url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodPractitionerModel[]> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodPractitionerModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareprovider_speciality_treatment_method
		 * @return hospital speciality treatment method practitioner
		 */
		public HospitalSpecialtyTreatmentMethodPractitionerModel getHospitalSpecialtyTreatmentMethodPractitionerById(
				BigInteger id) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodPractitionerUrl()+"/get/id/"+id;
			logger.info("Get Hospital Speciality Treatment Method Practitioner By id url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodPractitionerModel> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodPractitionerModel.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return all practitioners
		 */
		public List<PractitionerModel> getAllPractitioner(){
			String url = this.getRestUrlService().getPractitionerUrl()+"/getAll";
			logger.info("Practitioner url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<PractitionerModel[]> responseEntity = restTemplate.getForEntity(url, PractitionerModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;		
		}
		
		/**
		 * @param id
		 * @return pracitioner model
		 */
		public PractitionerModel getPractitionerById(BigInteger id){
			String url = this.getRestUrlService().getPractitionerUrl()+"/get/id/"+id;
			logger.info("Practitioner url by id found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<PractitionerModel> responseEntity = restTemplate.getForEntity(url, PractitionerModel.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
	
		/**
		 * 
		 * @return all hospital practitioner
		 */
		public List<HospitalPractitionerModel> getHospitalPractitioner(BigInteger healthcareprovider){
			String url = this.getRestUrlService().getPractitionerUrl()+"/get/healthcareprovider/"+healthcareprovider;
			logger.info("Hospital Practitioner url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalPractitionerModel[]> responseEntity = restTemplate.getForEntity(url, HospitalPractitionerModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return practitioner language
		 */
		public List<PractitionerLanguageModel> getPractitionerLanguage(BigInteger practitioner){
			String url = this.getRestUrlService().getPractitionerLanguageUrl()+"/get/practitioner/"+practitioner;
			logger.info("Practitioner Language url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<PractitionerLanguageModel[]> responseEntity = restTemplate.getForEntity(url, PractitionerLanguageModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param PractitionerLangaugeModel
		 * @return integer
		 */
		public Integer setPractitionerLanguage(PractitionerLanguageModel model){
			String url = this.getRestUrlService().getPractitionerLanguageUrl()+"/create";
			logger.info("Practitioner Language create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param id 
		 * @return boolean
		 */
		public Integer deletePractitionerLanguage(BigInteger id){
			String url = this.getRestUrlService().getPractitionerLanguageUrl()+"/delete/id/"+id;
			logger.info("Practitioner Language Delete url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return attestations 
		 */
		public List<AttestationsModel> getAllAttestations(){
			String url = this.getRestUrlService().getAttestationsUrl()+"/getAll";
			logger.info("Attestations url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<AttestationsModel[]> responseEntity = restTemplate.getForEntity(url, AttestationsModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return practitioner attestations
		 */
		public List<PractitionerAttestationsModel> getPractitionerAttestations(BigInteger practitioner){
			String url = this.getRestUrlService().getAttestationsPractitionerUrl()+"/get/practitioner/"+practitioner;
			logger.info("Practitioner Language url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<PractitionerAttestationsModel[]> responseEntity = restTemplate.getForEntity(url, PractitionerAttestationsModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param PractitionerAttestationsModel
		 * @return integer
		 */
		public Integer setPractitionerAttestations(PractitionerAttestationsModel model){
			String url = this.getRestUrlService().getAttestationsPractitionerUrl()+"/create";
			logger.info("Practitioner Attestations create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param id 
		 * @return boolean
		 */
		public Integer deletePractitionerAttestations(BigInteger id){
			String url = this.getRestUrlService().getAttestationsPractitionerUrl()+"/delete/id/"+id;
			logger.info("Practitioner Attestations Delete url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		public List<SpecialtyModel> getHospitalSpecialtyFormList(BigInteger healthcareprovider){
			List<SpecialtyModel> hospitalSpecialtyFormList = new ArrayList<SpecialtyModel>();
			List<SpecialtyModel> specialtyModelList = this.getAllSpecialty();
			List<HospitalSpecialtyModel> hospitalSpecialtyModelList = this.getHospitalSpecialty(healthcareprovider);
			if(hospitalSpecialtyModelList != null){
				for(SpecialtyModel sm : specialtyModelList){
					for(HospitalSpecialtyModel hsm: hospitalSpecialtyModelList){
						if(sm.getId().equals(hsm.getSpecialty())){					
							hospitalSpecialtyFormList.add(sm);
						}
					}
				}
			}
			return hospitalSpecialtyFormList;		
		}
		
		public List<SpecialtyModel> getSpecialtyFormList(BigInteger healthcareprovider){
			Boolean found =false;
			List<SpecialtyModel> specialtyFormList = new ArrayList<SpecialtyModel>();
			List<SpecialtyModel> specialtyModelList = this.getAllSpecialty();
			List<HospitalSpecialtyModel> hospitalSpecialtyModelList = this.getHospitalSpecialty(healthcareprovider);
			
			if(hospitalSpecialtyModelList != null){
				for(SpecialtyModel specialtyModel : specialtyModelList){
					found = false;
					for(HospitalSpecialtyModel hsm: hospitalSpecialtyModelList){
						if(specialtyModel.getId().equals(hsm.getSpecialty())){
							found = true;
						}
					}
					if(!found){
						specialtyFormList.add(specialtyModel);
					}
				}
			}else{
				specialtyFormList = this.getAllSpecialty();
			}
			return specialtyFormList;
		}
		
		/**
		 * 
		 * @param model
		 * @return id
		 */
		public Integer setPractitioner(PractitionerModel model) {
			String url = this.getRestUrlService().getPractitionerUrl()+"/create";
			logger.info("Pracititoner create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return practitionertype
		 */
		public List<PractitionertypeModel> getAllPractitionertype(){
			String url = this.getRestUrlService().getPractitionertypeUrl()+"/getAll";
			logger.info("Practitioner type url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<PractitionertypeModel[]> responseEntity = restTemplate.getForEntity(url, PractitionertypeModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @return AclRoles
		 */
		public List<AclRolesModel> getAllAclRoles(){
			String url = this.getRestUrlService().getAclRolesUrl()+"/getAll";
			logger.info("AclRoles url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<AclRolesModel[]> responseEntity = restTemplate.getForEntity(url, AclRolesModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		public BigInteger getPractitionerRole(){
			BigInteger role = null;
			try{
				List<AclRolesModel> aclRolesModelList = this.getAllAclRoles();
				for(AclRolesModel model : aclRolesModelList){
					if(model.getRole().equalsIgnoreCase("practitioner")){
						role = model.getId();
						logger.info("Practitioner role found ={}",role);
					}
				}
				if(role == null){
					throw new Exception("practitioner role not exist");
				}
			}catch(Exception ex){
				logger.info(ex.getMessage());
			}			
			return role;
		}
		
		public BigInteger getTreatmentGeneralId(){
			BigInteger id = null;
			try{
				List<TreatmentModel> treatmentsList = this.getAllTreatment();
				for(TreatmentModel model : treatmentsList){
					if(model.getName().equalsIgnoreCase("general")){
						id = model.getId();
						logger.info("General Treatment found ={}",id);
					}
				}
				if(id == null){
					throw new Exception("General Treatment not exist");
				}
			}catch(Exception ex){
				logger.info(ex.getMessage());
			}			
			return id;
		}
		
		public BigInteger getMethodGeneralId(){
			BigInteger id = null;
			try{
				List<MethodModel> methodsList = this.getAllMethod();
				for(MethodModel model : methodsList){
					if(model.getName().equalsIgnoreCase("general")){
						id = model.getId();
						logger.info("General method found ={}",id);
					}
				}
				if(id == null){
					throw new Exception("General Treatment not exist");
				}
			}catch(Exception ex){
				logger.info(ex.getMessage());
			}			
			return id;
		}
		
		/**
		 * 
		 * @return Stats
		 */
		public List<StatsModel> getStats(){
			String url = this.getRestUrlService().getStatsUrl()+"/getAll";
			logger.info("Stats url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<StatsModel[]> responseEntity = restTemplate.getForEntity(url, StatsModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param healthcareprovider_specialty_treatment_method_practitioner
		 * @param practitioner
		 * @return hospital_specialty_treatment_method_practitioner_stat List
		 */
		public List<HospitalSpecialtyTreatmentMethodPractitionerStatModel> getHospitalSpecialtyTreatmentMethodPractitionerStatByHstmp(
				BigInteger hstmp) {
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodPractitionerStatUrl()+"/get/hstmp/"+hstmp;
			logger.info("Get Hospital Speciality Treatment Method Practitioner Stat By hstmp url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<HospitalSpecialtyTreatmentMethodPractitionerStatModel[]> responseEntity = restTemplate.getForEntity(url, HospitalSpecialtyTreatmentMethodPractitionerStatModel[].class);
				return Arrays.asList(responseEntity.getBody());		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
		
		/**
		 * @param HospitalSpecialtyTreatmentMethodPractitionerStatModel
		 * @return integer
		 */
		public Integer setHospitalSpecialtyTreatmentMethodPractitionerStat(HospitalSpecialtyTreatmentMethodPractitionerStatModel model){
			String url = this.getRestUrlService().getHealthcareproviderSpecialtyTreatmentMethodPractitionerStatUrl()+"/create";
			logger.info("Hospital Speciality Treatment Method Practitioner Stat create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
}