package com.dg.patient.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.patient.exception.ApiException;
import com.dg.patient.model.HealthcareproviderModel;
import com.dg.patient.model.PatientCaseBookingModel;
import com.dg.patient.model.PatientModel;
import com.dg.patient.model.TreatmentModel;
import com.dg.patient.model.api.ApiErrorResponse;
import com.dg.patient.model.api.Booking;
import com.dg.patient.model.api.Hospital;
import com.dg.patient.model.api.Treatment;
import com.dg.patient.service.ApiService;
import com.dg.patient.service.HealthcareproviderResultService;
import com.dg.patient.service.OriginPriceCalculationService;
import com.dg.patient.service.RankingCalculationService;
import com.dg.patient.service.SearchService;
import com.dg.patient.service.UserService;

/**
 * Handles requests for the application home page.
 * 
 * @author DoctorGlobe
 */
@Controller
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private SearchService searchService;

	@Autowired
	private HealthcareproviderResultService healthcareproviderResultService;

	@Autowired
	private RankingCalculationService rankingService;

	@Autowired
	private UserService userService;

	@Autowired
	private OriginPriceCalculationService orignPriceService;
	
	@Autowired
	private ApiService apiService;


	/**
	 * Handle api origin price action
	 * @param treatmentId
	 * @return
	 */
	@RequestMapping(value = "/api/originprice/{treatmentId}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody String originCost(@PathVariable Integer treatmentId) {
		if (userService.isLoggedIn()) {
			List<HealthcareproviderModel> healthcareproviders = searchService.healthcareproviders(treatmentId, userService.getCurrentUserId());
			Integer						  originPrice 	  	  = orignPriceService.getOrginPrice(healthcareproviders, null, null).intValue();

			return "Origin Price: " + originPrice;
		}
		return "Need to be logged in";
	}
	
	/**
	 * Handle api healthcareproviders  price action
	 * @param treatmentId
	 * @param sortOrder
 	 * @param count
	 * @return
	 */
	@RequestMapping(value = "/api/hospitals/{treatmentId}/{sortOrder}/{count}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<HealthcareproviderModel> originCost(@PathVariable Integer treatmentId,
			@PathVariable String sortOrder,
			@PathVariable Integer count) {
		if (userService.isLoggedIn()) {
			List<HealthcareproviderModel> healthcareproviders = searchService.healthcareproviders(treatmentId, userService.getCurrentUserId());

			Double originPrice 	  = orignPriceService.getOrginPrice(healthcareproviders, null, null);
			healthcareproviders   = healthcareproviderResultService.getUniqueHealthcareprovider(healthcareproviders, originPrice);
			healthcareproviders   = rankingService.setRanking(healthcareproviders, originPrice);
			healthcareproviders   = healthcareproviderResultService.getSortBy(healthcareproviders, sortOrder);

			for (HealthcareproviderModel model : healthcareproviders) {
				model.setHospitalFilterModel(null);	// Just to simplify the results
			}
			
//			return healthcareproviders.subList(0, count);
			return healthcareproviders.subList(0, 10);
		}
		return null;
	}
	
	/**
	 * Handle api treatment action
	 * @param treatmentId
	 * @return treatment
	 */
	@RequestMapping(value = "/api/treatment/{treatmentId}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Treatment getTreatmentModel(@PathVariable Integer treatmentId) throws ApiException {
		return apiService.getWithoutGeneralTreatmentById(treatmentId);
	}
	
	/**
	 * Handle api treatment action	 
	 * @return treatment
	 */
	@RequestMapping(value = "/api/treatments", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Treatment> getAllTreatment() {
		return apiService.getWithoutGeneralTreatmentList();
	}
	
	/**
	 * Handle api hospitals action
	 * @param treatmentId
	 * @return treatment
	 */
	@RequestMapping(value = "/api/hospitals/{phoneNumber}/{treatmentId}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Hospital> getHospitals(@PathVariable String phoneNumber,@PathVariable Integer treatmentId) throws ApiException {
		PatientModel patientModel = apiService.getPatientByPhoneNumber(phoneNumber);
		if(patientModel.getId() == null){
			throw new ApiException("Invalid Phone number",1002);
		}else{
			List<HealthcareproviderModel> healthcareproviders = searchService.healthcareproviders(treatmentId, patientModel.getId());
			healthcareproviders   = healthcareproviderResultService.getApiUniqueHealthcareprovider(healthcareproviders,patientModel.getId(),patientModel.getDependent());
			double originPrice 		  = orignPriceService.getOrginPrice(healthcareproviders, null, null);
			healthcareproviders   = rankingService.setRanking(healthcareproviders, originPrice);
			return apiService.getApiHospital(healthcareproviders,originPrice);
		}		
	}
	
	/**
	 * Handle api hospitals action
	 * @param treatmentId
	 * @return treatment
	 */
	@RequestMapping(value = "/api/hospitals/{phoneNumber}/{treatmentId}/{hospitalId}/{hcpstmpId}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Booking getHospitals(@PathVariable String phoneNumber,@PathVariable Integer treatmentId,@PathVariable BigInteger hospitalId,@PathVariable BigInteger hcpstmpId) throws ApiException {
		Booking booking = new Booking();
		PatientModel patientModel = apiService.getPatientByPhoneNumber(phoneNumber);
		if(patientModel.getId() == null){
			throw new ApiException("Invalid Phone number",1002);
		}else{
			List<HealthcareproviderModel> healthcareproviders = searchService.healthcareproviders(treatmentId, patientModel.getId());
			healthcareproviders   = healthcareproviderResultService.getApiUniqueHealthcareprovider(healthcareproviders,patientModel.getId(),patientModel.getDependent());
			apiService.checkApiUserLimit(patientModel.getId(), treatmentId);
			Integer pc = apiService.setApiPatientCase(healthcareproviders,patientModel,treatmentId,hcpstmpId,hospitalId);
			if(pc != null){
				booking.setId(pc);
			}			
		}	
		return booking;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)    
    public ResponseEntity<ApiErrorResponse> handle(MethodArgumentNotValidException exception) {
		ApiErrorResponse error = new ApiErrorResponse();		
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<ApiErrorResponse>(error, HttpStatus.OK);       
    }
	
	@ExceptionHandler(Exception.class)    
    public ResponseEntity<ApiErrorResponse> handle(Exception exception) {
		ApiErrorResponse error = new ApiErrorResponse();		
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<ApiErrorResponse>(error, HttpStatus.OK);       
    }
	
	@ExceptionHandler(ApiException.class)    
    public ResponseEntity<ApiErrorResponse> handle(ApiException exception) {
		ApiErrorResponse error = new ApiErrorResponse();		
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorCode(exception.getCode());
		error.setMessage(exception.getMessage());
		return new ResponseEntity<ApiErrorResponse>(error, HttpStatus.OK);       
    }	
}
