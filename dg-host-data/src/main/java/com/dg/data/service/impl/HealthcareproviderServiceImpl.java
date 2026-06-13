
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
//import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import javax.management.ImmutableDescriptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderDAO;
import com.dg.data.model.db.Healthcareprovider;
import com.dg.data.model.db.Patient;
import com.dg.data.model.db.TreatmentPrice;
import com.dg.data.model.domain.EmployeeCorporatecompanyDetail;
import com.dg.data.model.domain.HealthcareproviderDetail;
import com.dg.data.model.domain.PatientLatLonModel;
import com.dg.data.service.CityService;
import com.dg.data.service.DistanceCalculatorService;
import com.dg.data.service.EmployeeCorporatecompanyService;
import com.dg.data.service.ExchangeRateService;
import com.dg.data.service.HealthcareproviderRatingWeightageService;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.PatientService;
import com.dg.data.service.PractitionerService;
import com.dg.data.service.RankingCalculationService;
import com.dg.data.service.TreatmentPriceService;

@Service("healthcareproviderService")
public class HealthcareproviderServiceImpl
		extends GenericServiceImpl<Healthcareprovider>
		implements HealthcareproviderService {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderServiceImpl.class);

	private HealthcareproviderDAO healthcareproviderDAO;

	private PatientService patientService;

	private CityService cityService;

	private HealthcareproviderRatingWeightageService healthcareproviderRatingWeightageService;

	private PractitionerService practitionerService;

	private EmployeeCorporatecompanyService employeeCorporatecompanyService;

	private DistanceCalculatorService distanceCalculatorService;

	private ExchangeRateService exchangerateService;

	private TreatmentPriceService treatmentPriceService;

	private RankingCalculationService rankingCalculationService;

	@Autowired
	public HealthcareproviderServiceImpl(HealthcareproviderDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderDAO = (HealthcareproviderDAO) genericDAO;
	}

	/**
	 * 
	 * @return patientService
	 */
	public PatientService getPatientService() {
		return this.patientService;
	}

	/**
	 * 
	 * @param patientService
	 */
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	/**
	 * 
	 * @return cityService
	 */
	public CityService getCityService() {
		return this.cityService;
	}

	/**
	 * 
	 * @param patientService
	 */
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	/**
	 * 
	 * @return healthcareproviderRatingWeightageService
	 */
	public HealthcareproviderRatingWeightageService getHealthcareproviderRatingWeightageService() {
		return this.healthcareproviderRatingWeightageService;
	}

	/**
	 * 
	 * @param healthcareproviderRatingWeightageService
	 */
	public void setHealthcareproviderRatingWeightageService(
			HealthcareproviderRatingWeightageService healthcareproviderRatingWeightageService) {
		this.healthcareproviderRatingWeightageService = healthcareproviderRatingWeightageService;
	}

	/**
	 * 
	 * @return practitionerService
	 */
	public PractitionerService getPractitionerService() {
		return this.practitionerService;
	}

	/**
	 * 
	 * @param practitionerService
	 */
	public void setPractitionerService(
			PractitionerService practitionerService) {
		this.practitionerService = practitionerService;
	}

	/**
	 * 
	 * @return employeeCorporatecompanyService
	 */
	public EmployeeCorporatecompanyService getEmployeeCorporatecompanyService() {
		return this.employeeCorporatecompanyService;
	}

	/**
	 * 
	 * @param employeeCorporatecompanyService
	 */
	public void setEmployeeCorporatecompanyService(
			EmployeeCorporatecompanyService employeeCorporatecompanyService) {
		this.employeeCorporatecompanyService = employeeCorporatecompanyService;
	}

	/**
	 * 
	 * @return distanceCalculatorService
	 */
	public DistanceCalculatorService getDistanceCalculatorService() {
		return this.distanceCalculatorService;
	}

	/**
	 * 
	 * @param distanceCalculatorService
	 */
	public void setDistanceCalculatorService(
			DistanceCalculatorService distanceCalculatorService) {
		this.distanceCalculatorService = distanceCalculatorService;
	}

	/**
	 * @return the exchangerateService
	 */
	public ExchangeRateService getExchangerateService() {
		return this.exchangerateService;
	}

	/**
	 * 
	 * @param exchangerateService
	 */
	public void setExchangerateService(
			ExchangeRateService exchangerateService) {
		this.exchangerateService = exchangerateService;
	}

	/**
	 * 
	 * @return treatmentPriceService
	 */
	public TreatmentPriceService getTreatmentPriceService() {
		return this.treatmentPriceService;
	}

	/**
	 * 
	 * @param treatmentPriceService
	 */
	public void setTreatmentPriceService(
			TreatmentPriceService treatmentPriceService) {
		this.treatmentPriceService = treatmentPriceService;
	}

	/**
	 * 
	 * @param rankingCalculationService
	 */
	public void setRankingCalculationService(
			RankingCalculationService rankingCalculationService) {
		this.rankingCalculationService = rankingCalculationService;
	}

	/**
	 * 
	 * @return rankingCalculationService
	 */
	public RankingCalculationService getRankingCalculationService() {
		return this.rankingCalculationService;
	}

	@Override
	public List<HealthcareproviderDetail> findByTreatmentId(Integer id,
			String currency) {
		return this.healthcareproviderDAO.findByTreatmentId(id, currency);
	}

	// Findme: This logic is fine for distance, but may not be good for volume and/or ranking. It is okay for now, since we have only a single entry per healthcareprovider.
	// However, it will be tricky when we have multiple entries per healthcareprovier for the following reason:
	// If each hcpstp has its own volume and own price, the lowest price may have the highest volume. As each healthcareprovider shows a single entry in the initial search result, this healthcareprovider
	// will either show high price and low volume, or low price with high volume (depend on which brings a higher total rating). Regardless, it is not clear what should be shown on the page
	// for that healthcare provider. The best of all worlds, or the best single hcpstp entry.
	// Findme 2: This logic is probably not related to the data host. For example, setting volume strings is a client logic (data should not be aware what percentages is high, what percentages is low, etc.).
	// Alternatively, may need to be a business logic layer between data and patient which is patient related.
	@Override
	public List<HealthcareproviderDetail> setHealthcareproviderDetails(List<HealthcareproviderDetail> healthcareproviderDetail,
																	   Integer treatment, Integer patient, String currency) {
		logger.info("hospital ranking 2");
		Set<Integer> 				    result 				= new HashSet<Integer>();
		Boolean 						patientLatLonFound 	= false;
		MutableDouble 					patientLat 			= new MutableDouble(0.0);
		MutableDouble 					patientLon 			= new MutableDouble(0.0);
		HashMap<Integer, Double> 		distanceMap 		= new HashMap<Integer, Double>();
		HashMap<Integer, String> 		volumeMap 			= new HashMap<Integer, String>();	// Mapping of healthcareprovider id to its volume string (like "low", "high", etc.)
		List<HealthcareproviderDetail>  uniqueHealthcareproviderDetail = new ArrayList<HealthcareproviderDetail>();
		
		try {
			patientLatLonFound = findBestMatchForPatientLatLon(patient, patientLat, patientLon);

			// Create a unique list of healthcareproviders. Various operations will be done on the unique entry, and extend to all entries.
			for (HealthcareproviderDetail f : healthcareproviderDetail) {
				if (result.add(f.getId())) {
					uniqueHealthcareproviderDetail.add(f);
				}
			}
			logInfo(patientLat, patientLon);
			
			Integer myPositionInOrderedVolumeList = 1;

			Collections.sort(uniqueHealthcareproviderDetail, this.healthcareproviderVolume);
			for (HealthcareproviderDetail healthCareProviderDetail : uniqueHealthcareproviderDetail) {
				Double distance 	= getDistance(patientLatLonFound, healthCareProviderDetail, patientLat, patientLon, patient);
				String myVolumeStr 	= getVolumeString(myPositionInOrderedVolumeList, uniqueHealthcareproviderDetail.size());

				distanceMap.put(healthCareProviderDetail.getId(), distance);
				volumeMap.put(healthCareProviderDetail.getId(), myVolumeStr);

				myPositionInOrderedVolumeList++;
			}
			
			// Findme: This is where we extend the values calculated for one of the hcpstp entries to other hcpstp entries which have the same healthcareprovider. 
			// Again, in multiple entries for the same healthcareprovider, only distance can be shared across the same healthcareprovider. It is unclear about the rest (see comment above).
			for (HealthcareproviderDetail model : healthcareproviderDetail) {
				if (volumeMap.containsKey(model.getId())) {
					model.setVolume(volumeMap.get(model.getId()));
				}
				if (distanceMap.containsKey(model.getId())) {
					model.setDistance(distanceMap.get(model.getId()));
					model.setFlighthours(distanceCalculatorService.getFlightHours(model.getDistance()));
					model.setFlighttime(distanceCalculatorService.getFlightTime(model.getDistance()));
				}
			}
		}
		catch (Exception ex) {
			logger.info("Exception found in setting details for healthcareprovider :", ex.getMessage());
		}
		return healthcareproviderDetail;
	}

	/* Comparator for sorting the list by ranking */
	public static Comparator<HealthcareproviderDetail> healthcareproviderRank = new Comparator<HealthcareproviderDetail>() {
		public int compare(HealthcareproviderDetail h1,
				HealthcareproviderDetail h2) {
			Integer rank1 = h1.getRanking();
			Integer rank2 = h2.getRanking();
			return rank1 - rank2;
		}
	};

	/* Comparator for sorting the list by volume */
	public static Comparator<HealthcareproviderDetail> healthcareproviderVolume = new Comparator<HealthcareproviderDetail>() {
		public int compare(HealthcareproviderDetail h1, HealthcareproviderDetail h2) {
			Integer a = h1.getNumberPerformedLastYear();
			Integer b = h2.getNumberPerformedLastYear();
			return b - a;
		}
	};

	// Helper function to log information
	private void logInfo(MutableDouble patientLat, MutableDouble patientLon) {
		double distanceWeight = this.getRankingCalculationService().getDistanceWeight();
		double bonusWeight 	  = this.getRankingCalculationService().getBonusWeight();
		double volumeWeight   = this.getRankingCalculationService().getVolumeWeight();
	
		logger.info("patient lat {}", patientLat.getValue());
		logger.info("patient lat {}", patientLon.getValue());
		logger.info("config distance weight  {}", distanceWeight);
		logger.info("config bonus weight {}", bonusWeight);
		logger.info("config volume weight {}", volumeWeight);
	}
	
	// Helper function to calculate and return the distance value. Also return the distance via the function input parameter
	private Double getDistance(boolean patientLatLonFound, HealthcareproviderDetail healthCareProviderDetail, 
			MutableDouble patientLat, MutableDouble patientLon, Integer patient) {
		Double distance = 0.0;
		
		if (patientLatLonFound) {
			if (patientLat.getValue() == 0.0 || patientLon.getValue() == 0.0)
				logger.error("Should never happen. Patient lat and long should have been confirmed to be valid at that point. Patient is: [" + patient);

			if (healthCareProviderDetail.getLat() == null || healthCareProviderDetail.getLon() == null) {
				logger.error("Need to fix lat/lon for the Healthcareprovider[" + healthCareProviderDetail.getId() + "]");
				if (latAndLongValid(healthCareProviderDetail.getCityLat(), healthCareProviderDetail.getCityLon())) {
					distance = distanceCalculatorService.getDistance(patientLat.getValue(), patientLon.getValue(), healthCareProviderDetail.getCityLat(), healthCareProviderDetail.getCityLon(), null);
				}
				else {
					logger.error("Need to fix lat/lon for the city id[cityId]: " + healthCareProviderDetail.getCity());
				}
				logger.error("Need to fix lat/lon for the given hospital id [hospitalId]: " + healthCareProviderDetail.getId());
			}
			else {
				if ((!healthCareProviderDetail.getLat().equals(0.0) && !healthCareProviderDetail.getLon().equals(0.0))) {
					distance = distanceCalculatorService.getDistance(patientLat.getValue(), patientLon.getValue(), Double.valueOf(healthCareProviderDetail.getLat()), Double.valueOf(healthCareProviderDetail.getLon()), null);
				}
				else {
					logger.error("Need to fix lat/lon for the given hospital id or patient id [hospitalId, patientId]: " + healthCareProviderDetail.getId() + ", " + patient);
				}
				// For logging only:
				if (healthCareProviderDetail.getId() == 866) {
					logger.info("lat and lon {} ,{}", healthCareProviderDetail.getLat(), healthCareProviderDetail.getLon());
					logger.info("patient lat and lon {} ,{}", patientLat, patientLon);
					distance = distanceCalculatorService.getDistance(patientLat.getValue(), patientLon.getValue(), Double.valueOf(healthCareProviderDetail.getLat()), Double.valueOf(healthCareProviderDetail.getLon()), null);
					logger.info("distance {}", distance);
				}
			}
		}
		
		return distance;
	}

	
	// Helper function to find the appropriate volume string based on the position of the healthcareprovider within a sort by volume list
	private String getVolumeString(int myPositionInOrderedVolumeList, int numOfHealthCareProviders) {
		String myVolumeString = "";
		
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// Findme: Don't change those string. The patient app has some logic based on those strings (clearly a big hack, but was easiest, and should be changed ASAP).
		// see: com.dg.patient.service.RankingCalculationService.java
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if (myPositionInOrderedVolumeList <= (int) (numOfHealthCareProviders * .10)) {
			myVolumeString = "High";
		}
		else if (myPositionInOrderedVolumeList > (int) (numOfHealthCareProviders * .10) && myPositionInOrderedVolumeList <= (int) (numOfHealthCareProviders * .30)) {
			myVolumeString = "Moderately High";
		}
		else if (myPositionInOrderedVolumeList > (int) (numOfHealthCareProviders * .30) && myPositionInOrderedVolumeList <= (int) (numOfHealthCareProviders * .70)) {
			myVolumeString = "Moderate";
		}
		else if (myPositionInOrderedVolumeList > (int) (numOfHealthCareProviders * .70) && myPositionInOrderedVolumeList <= (int) (numOfHealthCareProviders * .90)) {
			myVolumeString = "Moderately Low";
		}
		else if (myPositionInOrderedVolumeList > (int) (numOfHealthCareProviders * .90) && myPositionInOrderedVolumeList <= (int) (numOfHealthCareProviders)) {
			myVolumeString = "Low";
		}
		
		return myVolumeString;
	}

	/*
	 * Helper function to find the best possible lat and long match for patient.
	 * First, try to get the patinet's address lat long, and if those can't be found, get the employee's company's address lat and long
	 * 
	 * Findme (Yori): Seems like this function has a bug (although will not be exposed if patient's data is not missing):
	 * Assume patient city is null, but patient model lat and long exist
	 * In this case, lat and long will be set properly, but patientCityFound will be false.
	 * The system will go into the second if statement and may override the patient lat long with the company's address lat long.
	 * This is a minor bug. Better to catch the logger information for patient lat long not found and fix the data.
	 */
	private boolean findBestMatchForPatientLatLon(Integer patient, MutableDouble patientLat, MutableDouble patientLon) {
		PatientLatLonModel patientModel 		= new PatientLatLonModel();
		Patient 		   dependentModel 		= this.getPatientService().get(patient);
		boolean			   patientLatLonFound	= false;
		Boolean 		   patientCityFound 	= false;

		
		patientModel = patientService.findLatLonById(patient);
		logger.info("patient lat lon model detail {}", patientModel.toString());
		if (patientModel.getId() != null) {
			if (patientModel.getCity() != null) {
				if (latAndLongValid(patientModel.getLat(), patientModel.getLon())) {
					patientLat.setValue(patientModel.getLat());
					patientLon.setValue(patientModel.getLon());
					patientLatLonFound = true;
					logger.info("patient lat & lon found [lat,lon] [" + patientModel.getLat() + "," + patientModel.getLon() + "]");
				}
				else if (latAndLongValid(patientModel.getCityLat(), patientModel.getCityLon())) {
					patientLat.setValue(patientModel.getCityLat());
					patientLon.setValue(patientModel.getCityLon());
					patientLatLonFound = true;
					logger.info("patient city,lat & lon found [city,lat,lon] [" + patientModel.getCity() + "," + patientModel.getCityLat() + "," + patientModel.getCityLon() + "]");
				}
				patientCityFound = true;
			}
			else if (latAndLongValid(patientModel.getLat(), patientModel.getLon())) {
				patientLat.setValue(patientModel.getLat());
				patientLon.setValue(patientModel.getLon());
				patientLatLonFound = true;
			}
		}

		// Could not find patient lat long. Try to use the company's city lat and long
		if (!patientCityFound) {
			EmployeeCorporatecompanyDetail employeeCorporateCompanyModel = new EmployeeCorporatecompanyDetail();

			logger.error("patient city,lat,lon not found");
			employeeCorporateCompanyModel = employeeCorporatecompanyService.findByPaytient(patient);
			if (employeeCorporateCompanyModel.getId() == null && dependentModel.getDependent() != null) {
				employeeCorporateCompanyModel = employeeCorporatecompanyService.findByPaytient(dependentModel.getDependent().intValue());
			}
			if (employeeCorporateCompanyModel.getId() != null && employeeCorporateCompanyModel.getCity() != null) {
				if (!patientLatLonFound && latAndLongValid(employeeCorporateCompanyModel.getCityLat(), employeeCorporateCompanyModel.getCityLon())) { 
					patientLat.setValue(employeeCorporateCompanyModel.getCityLat());
					patientLon.setValue(employeeCorporateCompanyModel.getCityLon());
					patientLatLonFound = true;
				}
			}
		}
		
		return patientLatLonFound;
	}
	
	private boolean latAndLongValid(Double lat, Double lon) {
		boolean valid = (lat != null) && (lon != null) && (lat != 0.0) && (lon != 0.0);
		
		return valid;
	}
	
	private class MutableDouble {
		double value;

		public MutableDouble(double val) {
			value = val;
		}
		
		void setValue(double val) {
			value = val;
		}
		double getValue() {
			return value;
		}
	}
}
