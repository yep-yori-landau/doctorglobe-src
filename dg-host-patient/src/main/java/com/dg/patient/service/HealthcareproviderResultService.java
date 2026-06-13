package com.dg.patient.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.dg.patient.model.EmployeeCorporatecompanyDetailModel;
import com.dg.patient.model.HealthcareproviderModel;
import com.dg.patient.model.HospitalFilterModel;
import com.dg.patient.model.PatientCaseBookingModel;
import com.dg.patient.model.PatientLatLonModel;
/**
 * @author DoctorGlobe
 * 
 */
@Service
public class HealthcareproviderResultService {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderResultService.class);

	private UserService userService;

	private CalculateService calculateService;

	private OriginPriceCalculationService originPriceService;

	/**
	 * 
	 * @return userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * 
	 * @param userService set the userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 
	 * @return calculateService
	 */
	public CalculateService getCalculateService() {
		return calculateService;
	}

	/**
	 * 
	 * @param calculateService set thet calculateService
	 */
	public void setCalculateService(CalculateService calculateService) {
		this.calculateService = calculateService;
	}

	/**
	 * 
	 * @return originPriceService
	 */
	public OriginPriceCalculationService getOriginPriceCalculationService() {
		return originPriceService;
	}

	/**
	 * 
	 * @param originPriceService set the originPriceService
	 */
	public void setOriginPriceCalculationService(
			OriginPriceCalculationService originPriceService) {
		this.originPriceService = originPriceService;
	}

	/**
	 * Gets unique healthcareprovider list
	 * @param healthcareproviders list
	 * @return HealthcareproviderModel list
	 */
	public List<HealthcareproviderModel> getUniqueHealthcareprovider(
			List<HealthcareproviderModel> healthcareproviders, double originPrice) {
		List<HealthcareproviderModel> healthcareproviderList = new ArrayList<HealthcareproviderModel>();
//		Double originPrice = this.getOriginPriceCalculationService().getOrginPrice(healthcareproviders, null, null);
		EmployeeCorporatecompanyDetailModel employeeCorporatecompanyDetailModel = new EmployeeCorporatecompanyDetailModel();
		PatientLatLonModel patientLatLonModel = this.getUserService()
				.getPatientLatLonModel(
						this.getUserService().getCurrentUserId());

		BigInteger patientCountry = null;
		Set<Integer> result = new HashSet<Integer>();
		HashMap<Integer, List> amenitiesMap = new HashMap<Integer, List>();
		HashMap<Integer, List> accreditationMap = new HashMap<Integer, List>();
		HashMap<Integer, List> expertsMap = new HashMap<Integer, List>();
		HashMap<Integer, List> youGetUpToMap = new HashMap<Integer, List>();
		HashMap<Integer, List> youPayUpToMap = new HashMap<Integer, List>();
		HashMap<Integer, List> estimatedCostMap = new HashMap<Integer, List>();
		HashMap<Integer, List> practitionerMap = new HashMap<Integer, List>();
		HashMap<Integer, List> availableMap = new HashMap<Integer, List>();
		HashMap<Integer, List> ratingMap = new HashMap<Integer, List>();
		HashMap<Integer, List> unitMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderImageMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderAllImageMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderAllVideoMap = new HashMap<Integer, List>();
		HashMap<Integer, List> equipmentMap = new HashMap<Integer, List>();
		HashMap<String, List> featureMap = new HashMap<String, List>();
		HashMap<Integer, List> hcpfeatureMap = new HashMap<Integer, List>();
		HashMap<String, List> unitDescriptionMap = new HashMap<String, List>();
		HashMap<Integer, List> hcpAmenities = new HashMap<Integer, List>();
		HashMap<Integer, List> hcpEquipments = new HashMap<Integer, List>();

		Set<String> regions = new HashSet<String>();
		Set<String> equipments = new HashSet<String>();
		Set<String> amenities = new HashSet<String>();
		Set<String> accreditations = new HashSet<String>();
		Set<Integer> ratings = new HashSet<Integer>();
		Set<Double> estimatedCost = new HashSet<Double>();
		Set<Double> bonusSet = new HashSet<Double>();
		HashMap<String, Integer> regionsMap = new HashMap<String, Integer>();
		LinkedHashMap<String, Integer> volumeMap = this.getVolumeMap();
		HashMap<String, Integer> volumeCountMap = this.getVolumeCountMap();
		HashMap<String, Integer> amenityMap = new HashMap<String, Integer>();
		HashMap<String, Integer> equipmentsMap = new HashMap<String, Integer>();

		ArrayList list;
		List<Double> distanceList = new ArrayList<Double>();
		List<Double> flighthourList = new ArrayList<Double>();
		List<HealthcareproviderModel> totalHospitalResult = new ArrayList<HealthcareproviderModel>();
		List<HealthcareproviderModel> limitedHospitalResult = new ArrayList<HealthcareproviderModel>();
		List<HealthcareproviderModel> totalResult = new ArrayList<HealthcareproviderModel>();

		HospitalFilterModel hospitalFilter = new HospitalFilterModel();
		Boolean isCorporatePatient = false;

		if (this.getUserService().getIsCorporatePatient()) {
			employeeCorporatecompanyDetailModel = this.getUserService()
					.getEmployeeCorporatecompanyDetailModelByPatient(
							this.getUserService().getCurrentUserId());
			if (employeeCorporatecompanyDetailModel.getId() == null
					&& this.getUserService().getDependent() != null) {
				employeeCorporatecompanyDetailModel = this.getUserService()
						.getEmployeeCorporatecompanyDetailModelByPatient(
								this.getUserService().getDependent());
			}
			if (patientLatLonModel.getCity() != null) {
				patientCountry = patientLatLonModel.getCountry();
			}
			else if (employeeCorporatecompanyDetailModel.getCity() != null) {
				patientCountry = employeeCorporatecompanyDetailModel
						.getCountry();
			}
			isCorporatePatient = true;
		}

		if (!healthcareproviders.isEmpty()) {
			for (HealthcareproviderModel f : healthcareproviders) {
				if (f.getDistance() < this.getUserService()
						.getSearchUrlService()
						.getMinimumDistanceForAirTravel()) {
					f.setFlighthours(0.0);
				}
				if (f.getStateCode() != null && f.getAhaId() != null) {
					if (f.getUsnewsName() != null) {
						f.setRatingUrl(this.getUserService()
								.getSearchUrlService().getRatingUrl()
								+ f.getStateCode() + "/"
								+ f.getName().replaceAll(" ", "-").toLowerCase()
								+ "-" + f.getAhaId() + "/" + f.getUsnewsName());
					}
					else {
						f.setRatingUrl(this.getUserService()
								.getSearchUrlService().getRatingUrl()
								+ f.getStateCode() + "/"
								+ f.getName().replaceAll(" ", "-").toLowerCase()
								+ "-" + f.getAhaId());
					}
					//Build and set the USNews report doctor link:
					String doctorsURL = buildDoctorsURL(f);
					f.setDoctorsUrl(doctorsURL);
				}
				if (isCorporatePatient) {
					// Don't consider this hospital entry if its part of a private network which the user is not registered to.
					if (f.getCorporatecompanyInsurance() != null
							&& !employeeCorporatecompanyDetailModel.getCorporatecompanyInsurance().equals(f.getCorporatecompanyInsurance())) {
						continue;
					}
					f.setYouPayUpTo(this.getCalculateService().getYouPayUpTo(
							employeeCorporatecompanyDetailModel, originPrice));
					f.setYouGetUpTo(this.getCalculateService().getYouGetUpTo(
							employeeCorporatecompanyDetailModel, originPrice,
							f.getYouPayUpTo(),
							this.getDestinationCost(f, patientCountry)));
					f.setIsAvailable(
							this.getCalculateService().getHospitalIsAvailable(
									employeeCorporatecompanyDetailModel,
									originPrice, f.getYouPayUpTo(),
									this.getDestinationCost(f,
											patientCountry)));
				}
				else {
					f.setYouPayUpTo(0.0);
					f.setYouGetUpTo(0.0);
					if (f.getEstimatedCost() == null
							|| f.getEstimatedCost() <= 0) {
						f.setIsAvailable(false);
					}
					else {
						f.setIsAvailable(true);
					}
				}

				// Hospital becomes unavailable if its price is too high in comparison to origin price and Corporate comapny settings
				if (f.getIsAvailable()) {
					regions.add(f.getRegionName());
					if (f.getAmenity() != null && f.getIsDisplay()) {
						amenities.add(f.getAmenity().replace('/', ' '));
					}
					if (f.getEstimatedCost() != null) {
						estimatedCost.add(f.getEstimatedCost());
					}
					//findme: Why does the first entry found is being used? What about multiple entries from different networks (like Medicare and private network)?
					// What about multiple doctors from the same network (on the same hospital/procedure/method)?
					if (result.add(f.getId())) {
						healthcareproviderList.add(f);
					}

					if (!amenitiesMap.containsKey(f.getId())) {
						if (f.getAmenity() != null && f.getIsDisplay()) {
							List<String> arrayList = new ArrayList<String>();
							arrayList.add(f.getAmenity().replace('/', ' '));
							amenitiesMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getAmenity() != null && f.getIsDisplay()) {
							List<String> arrayList = (List) amenitiesMap
									.get(f.getId());
							arrayList.add(f.getAmenity().replace('/', ' '));
						}
					}

					if (!estimatedCostMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getEstimatedCost() != 0) {
							arrayList.add(f.getEstimatedCost());
							estimatedCostMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getEstimatedCost() != 0) {
							List arrayList = (List) estimatedCostMap
									.get(f.getId());
							arrayList.add(f.getEstimatedCost());
						}
					}
					if (!youPayUpToMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getYouPayUpTo() != 0) {
							arrayList.add(f.getYouPayUpTo());
							youPayUpToMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getYouPayUpTo() != 0) {
							List arrayList = (List) youPayUpToMap
									.get(f.getId());
							arrayList.add(f.getYouPayUpTo());
						}
					}
					if (!youGetUpToMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getYouGetUpTo() != 0) {
							arrayList.add(f.getYouGetUpTo());
							youGetUpToMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getYouGetUpTo() != 0) {
							List arrayList = (List) youGetUpToMap
									.get(f.getId());
							arrayList.add(f.getYouGetUpTo());
						}
					}

					if (!healthcareproviderImageMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getHealthcareproviderImage() != null
								&& f.getIsPrimary()) {
							arrayList.add("/doctorglobe-hospital/hospital/"
									+ f.getId() + "/photo/"
									+ f.getHealthcareproviderImage());
							healthcareproviderImageMap.put(f.getId(),
									arrayList);
						}
						else {
							String icon = f.getVolume().toLowerCase()
									.replace(" ", "");
							arrayList.add("/resources/img/" + icon + ".png");
							healthcareproviderImageMap.put(f.getId(),
									arrayList);
						}
					}
				}
			}
		}

		// This is a unique list of hospitals, each has a low enough price for display
		if (!healthcareproviderList.isEmpty()) {
			Integer count = 1;
			for (HealthcareproviderModel fm : healthcareproviderList) {

				if (equipmentMap.containsKey(fm.getId())) {
					String equipment = "";
					Set set = new HashSet(equipmentMap.get(fm.getId()));
					list = new ArrayList(set);
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) != null) {
							equipment += list.get(i).toString().replace(" ", "")
									+ " ";
						}
					}
					fm.setEquipment(equipment.toLowerCase());
				}
				if (amenitiesMap.containsKey(fm.getId())) {
					String amenity = "";
					Set set = new HashSet(amenitiesMap.get(fm.getId()));
					list = new ArrayList(set);
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) != null) {
							if (amenityMap.containsKey(list.get(i))) {
								amenityMap
										.put(list.get(i).toString(),
												amenityMap
														.get(list.get(i)
																.toString())
														+ 1);
							}
							else {
								amenityMap.put(list.get(i).toString(), 1);
							}
							amenity += list.get(i).toString().replace(" ", "")
									+ " ";
						}
					}
					fm.setAmenity(amenity.toLowerCase());
				}
				if (accreditationMap.containsKey(fm.getId())) {
					String accreditation = "";
					Set set = new HashSet(accreditationMap.get(fm.getId()));
					list = new ArrayList(set);
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) != null) {
							accreditation += list.get(i).toString().replace(" ",
									"") + " ";
						}
					}
					fm.setAccreditation(accreditation.toLowerCase());
				}
				if (expertsMap.containsKey(fm.getId())) {
					Set set = new HashSet(expertsMap.get(fm.getId()));
					if (set.contains(0)) {
						set.remove(0);
					}
					fm.setExperts(set.size());

				}
				if (estimatedCostMap.containsKey(fm.getId())) {
					Set set = new HashSet(estimatedCostMap.get(fm.getId()));
					double mincost = (Double) Collections.min(set);
					double maxcost = (Double) Collections.max(set);
					fm.setEstimatedCost(mincost);
				}
				if (youGetUpToMap.containsKey(fm.getId())) {
					Set set = new HashSet(youGetUpToMap.get(fm.getId()));
					double minYouGetUpTo = (Double) Collections.min(set);
					fm.setYouGetUpTo(minYouGetUpTo);
				}
				if (youPayUpToMap.containsKey(fm.getId())) {
					Set set = new HashSet(youPayUpToMap.get(fm.getId()));
					double maxYouPayUpTo = (Double) Collections.max(set);
					fm.setYouPayUpTo(maxYouPayUpTo);
				}

				if (fm.getRegionName() != null && fm.getIsAvailable()) {
					if (regionsMap.containsKey(fm.getRegionName())) {
						regionsMap.put(fm.getRegionName(),
								regionsMap.get(fm.getRegionName()) + 1);
					}
					else {
						regionsMap.put(fm.getRegionName(), 1);
					}
				}
				if (fm.getYouGetUpTo() != null) {
					bonusSet.add(fm.getYouGetUpTo());
				}
				if (fm.getDistance() != null) {
					distanceList.add(fm.getDistance());
				}
				if (fm.getFlighthours() != null) {
					flighthourList.add(fm.getFlighthours());
				}
				if (volumeCountMap.containsKey(fm.getVolume())) {
					volumeCountMap.put(fm.getVolume(),
							volumeCountMap.get(fm.getVolume()) + 1);
				}

				if (this.getVolumeDefaultFilter().contains(fm.getVolume())) {
					totalHospitalResult.add(fm);
				}
			}
		}
		hospitalFilter
				.setHealthcareproviderImageMap(healthcareproviderImageMap);
		hospitalFilter.setAmentiesMap(amenitiesMap);
		hospitalFilter.setVolumeCountMap(volumeCountMap);
		hospitalFilter.setDistanceList(distanceList);
		hospitalFilter.setEstimatedCostSet(estimatedCost);
		hospitalFilter.setBonusSet(bonusSet);
		hospitalFilter.setFlighthourList(flighthourList);
		if (patientLatLonModel.getLat() != null
				&& patientLatLonModel.getLat() != null) {
			hospitalFilter.setCityName(patientLatLonModel.getCityName());
			hospitalFilter.setStateCode(patientLatLonModel.getStateCode());
		}
		for (HealthcareproviderModel f : totalHospitalResult) {
			f.setHospitalFilterModel(hospitalFilter);
		}
		return totalHospitalResult;
	}
	
	/**
	 * Gets unique healthcareprovider list
	 * @param healthcareproviders list
	 * @return HealthcareproviderModel list
	 */
	public List<HealthcareproviderModel> getApiUniqueHealthcareprovider(
			List<HealthcareproviderModel> healthcareproviders,BigInteger patientId,BigInteger dependentId) {
		List<HealthcareproviderModel> healthcareproviderList = new ArrayList<HealthcareproviderModel>();
		Double originPrice = this.getOriginPriceCalculationService()
				.getOrginPrice(healthcareproviders, null, null);
		EmployeeCorporatecompanyDetailModel employeeCorporatecompanyDetailModel = new EmployeeCorporatecompanyDetailModel();
		PatientLatLonModel patientLatLonModel = this.getUserService()
				.getPatientLatLonModel(
						patientId);

		BigInteger patientCountry = null;
		Set<Integer> result = new HashSet<Integer>();		
		HashMap<Integer, List> expertsMap = new HashMap<Integer, List>();
		HashMap<Integer, List> youGetUpToMap = new HashMap<Integer, List>();
		HashMap<Integer, List> youPayUpToMap = new HashMap<Integer, List>();
		HashMap<Integer, List> estimatedCostMap = new HashMap<Integer, List>();
		HashMap<Integer, List> practitionerMap = new HashMap<Integer, List>();
		HashMap<Integer, List> availableMap = new HashMap<Integer, List>();
		HashMap<Integer, List> ratingMap = new HashMap<Integer, List>();
		HashMap<Integer, List> unitMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderImageMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderAllImageMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderAllVideoMap = new HashMap<Integer, List>();
		
		Set<String> regions = new HashSet<String>();		
		Set<Integer> ratings = new HashSet<Integer>();
		Set<Double> estimatedCost = new HashSet<Double>();
		Set<Double> bonusSet = new HashSet<Double>();
		HashMap<String, Integer> regionsMap = new HashMap<String, Integer>();
		LinkedHashMap<String, Integer> volumeMap = this.getVolumeMap();
		HashMap<String, Integer> volumeCountMap = this.getVolumeCountMap();
		HashMap<String, Integer> amenityMap = new HashMap<String, Integer>();
		HashMap<String, Integer> equipmentsMap = new HashMap<String, Integer>();

		ArrayList list;
		List<Double> distanceList = new ArrayList<Double>();
		List<Double> flighthourList = new ArrayList<Double>();
		List<HealthcareproviderModel> totalHospitalResult = new ArrayList<HealthcareproviderModel>();
		List<HealthcareproviderModel> limitedHospitalResult = new ArrayList<HealthcareproviderModel>();
		List<HealthcareproviderModel> totalResult = new ArrayList<HealthcareproviderModel>();

		HospitalFilterModel hospitalFilter = new HospitalFilterModel();
		Boolean isCorporatePatient = false;

		if (this.getUserService().getApiUserIsCorporatePatient(patientId,dependentId)) {
			employeeCorporatecompanyDetailModel = this.getUserService()
					.getEmployeeCorporatecompanyDetailModelByPatient(
							patientId);
			if (employeeCorporatecompanyDetailModel.getId() == null
					&& dependentId != null) {
				employeeCorporatecompanyDetailModel = this.getUserService()
						.getEmployeeCorporatecompanyDetailModelByPatient(
								dependentId);
			}
			if (patientLatLonModel.getCity() != null) {
				patientCountry = patientLatLonModel.getCountry();
			}
			else if (employeeCorporatecompanyDetailModel.getCity() != null) {
				patientCountry = employeeCorporatecompanyDetailModel
						.getCountry();
			}
			isCorporatePatient = true;
		}

		if (!healthcareproviders.isEmpty()) {
			for (HealthcareproviderModel f : healthcareproviders) {
				if (f.getDistance() < this.getUserService()
						.getSearchUrlService()
						.getMinimumDistanceForAirTravel()) {
					f.setFlighthours(0.0);
				}
				if (f.getStateCode() != null && f.getAhaId() != null) {
					if (f.getUsnewsName() != null) {
						f.setRatingUrl(this.getUserService()
								.getSearchUrlService().getRatingUrl()
								+ f.getStateCode() + "/"
								+ f.getName().replaceAll(" ", "-").toLowerCase()
								+ "-" + f.getAhaId() + "/" + f.getUsnewsName());
					}
					else {
						f.setRatingUrl(this.getUserService()
								.getSearchUrlService().getRatingUrl()
								+ f.getStateCode() + "/"
								+ f.getName().replaceAll(" ", "-").toLowerCase()
								+ "-" + f.getAhaId());
					}
					//Build and set the USNews report doctor link:
					String doctorsURL = buildDoctorsURL(f);
					f.setDoctorsUrl(doctorsURL);
				}
				if (isCorporatePatient) {
					if (f.getCorporatecompanyInsurance() != null
							&& !employeeCorporatecompanyDetailModel
									.getCorporateCompany()
									.equals(f.getCorporatecompanyInsurance())) {
						continue;
					}
					f.setYouPayUpTo(this.getCalculateService().getYouPayUpTo(
							employeeCorporatecompanyDetailModel, originPrice));
					f.setYouGetUpTo(this.getCalculateService().getYouGetUpTo(
							employeeCorporatecompanyDetailModel, originPrice,
							f.getYouPayUpTo(),
							this.getDestinationCost(f, patientCountry)));
					f.setIsAvailable(
							this.getCalculateService().getHospitalIsAvailable(
									employeeCorporatecompanyDetailModel,
									originPrice, f.getYouPayUpTo(),
									this.getDestinationCost(f,
											patientCountry)));
					f.setDestinationCost(this.getDestinationCost(f, patientCountry));
				}
				else {
					f.setYouPayUpTo(0.0);
					f.setYouGetUpTo(0.0);
					if (f.getEstimatedCost() == null
							|| f.getEstimatedCost() <= 0) {
						f.setIsAvailable(false);
					}
					else {
						f.setIsAvailable(true);
					}
				}

				if (f.getIsAvailable()) {
					regions.add(f.getRegionName());
					
					if (f.getEstimatedCost() != null) {
						estimatedCost.add(f.getEstimatedCost());
					}
					if (result.add(f.getId())) {
						healthcareproviderList.add(f);
					}				

					if (!estimatedCostMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getEstimatedCost() != 0) {
							arrayList.add(f.getEstimatedCost());
							estimatedCostMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getEstimatedCost() != 0) {
							List arrayList = (List) estimatedCostMap
									.get(f.getId());
							arrayList.add(f.getEstimatedCost());
						}
					}
					if (!youPayUpToMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getYouPayUpTo() != 0) {
							arrayList.add(f.getYouPayUpTo());
							youPayUpToMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getYouPayUpTo() != 0) {
							List arrayList = (List) youPayUpToMap
									.get(f.getId());
							arrayList.add(f.getYouPayUpTo());
						}
					}
					if (!youGetUpToMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getYouGetUpTo() != 0) {
							arrayList.add(f.getYouGetUpTo());
							youGetUpToMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getYouGetUpTo() != 0) {
							List arrayList = (List) youGetUpToMap
									.get(f.getId());
							arrayList.add(f.getYouGetUpTo());
						}
					}

					if (!healthcareproviderImageMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getHealthcareproviderImage() != null
								&& f.getIsPrimary()) {
							arrayList.add("/doctorglobe-hospital/hospital/"
									+ f.getId() + "/photo/"
									+ f.getHealthcareproviderImage());
							healthcareproviderImageMap.put(f.getId(),
									arrayList);
						}
						else {
							String icon = f.getVolume().toLowerCase()
									.replace(" ", "");
							arrayList.add("/resources/img/" + icon + ".png");
							healthcareproviderImageMap.put(f.getId(),
									arrayList);
						}
					}
				}
			}
		}

		if (!healthcareproviderList.isEmpty()) {
			Integer count = 1;
			for (HealthcareproviderModel fm : healthcareproviderList) {				
				if (expertsMap.containsKey(fm.getId())) {
					Set set = new HashSet(expertsMap.get(fm.getId()));
					if (set.contains(0)) {
						set.remove(0);
					}
					fm.setExperts(set.size());

				}
				if (estimatedCostMap.containsKey(fm.getId())) {
					Set set = new HashSet(estimatedCostMap.get(fm.getId()));
					double mincost = (Double) Collections.min(set);
					double maxcost = (Double) Collections.max(set);
					fm.setEstimatedCost(mincost);
				}
				if (youGetUpToMap.containsKey(fm.getId())) {
					Set set = new HashSet(youGetUpToMap.get(fm.getId()));
					double minYouGetUpTo = (Double) Collections.min(set);
					fm.setYouGetUpTo(minYouGetUpTo);
				}
				if (youPayUpToMap.containsKey(fm.getId())) {
					Set set = new HashSet(youPayUpToMap.get(fm.getId()));
					double maxYouPayUpTo = (Double) Collections.max(set);
					fm.setYouPayUpTo(maxYouPayUpTo);
				}

				if (fm.getRegionName() != null && fm.getIsAvailable()) {
					if (regionsMap.containsKey(fm.getRegionName())) {
						regionsMap.put(fm.getRegionName(),
								regionsMap.get(fm.getRegionName()) + 1);
					}
					else {
						regionsMap.put(fm.getRegionName(), 1);
					}
				}
				if (fm.getYouGetUpTo() != null) {
					bonusSet.add(fm.getYouGetUpTo());
				}
				if (fm.getDistance() != null) {
					distanceList.add(fm.getDistance());
				}
				if (fm.getFlighthours() != null) {
					flighthourList.add(fm.getFlighthours());
				}
				if (volumeCountMap.containsKey(fm.getVolume())) {
					volumeCountMap.put(fm.getVolume(),
							volumeCountMap.get(fm.getVolume()) + 1);
				}

				if (this.getVolumeDefaultFilter().contains(fm.getVolume())) {
					totalHospitalResult.add(fm);
				}
			}
		}		
		return totalHospitalResult;
	}

	/**
	 * Gets filtered hospital list based on below params
	 * @param healthcareproviders
	 * @param regionFilter
	 * @param amenityFilter
	 * @param volumeFilter
	 * @param distanceFilter
	 * @param priceFilter
	 * @param sortingFilter
	 * @param textFilter
	 * @param filterSelected
	 * @param sliderChange
	 * @param limit
	 * @param reset
	 * @param flighthourFilter
	 * @return HealthcareproviderModel list
	 */
	public List<HealthcareproviderModel> getFilteredHealthcareprovider(
			List<HealthcareproviderModel> healthcareproviders,
			List<String> regionFilter, List<String> amenityFilter,
			List<String> volumeFilter, Double distanceFilter,
			Double priceFilter, String sortingFilter, String textFilter,
			Boolean filterSelected, Boolean sliderChange, Integer limit,
			Boolean reset, Double flighthourFilter, double originPrice) {
		List<HealthcareproviderModel> healthcareproviderList = new ArrayList<HealthcareproviderModel>();
//		Double originPrice = this.getOriginPriceCalculationService()
//				.getOrginPrice(healthcareproviders, null, null);
		EmployeeCorporatecompanyDetailModel employeeCorporatecompanyDetailModel = new EmployeeCorporatecompanyDetailModel();
		PatientLatLonModel patientLatLonModel = this.getUserService()
				.getPatientLatLonModel(
						this.getUserService().getCurrentUserId());
		BigInteger patientCountry = null;
		Set<Integer> result = new HashSet<Integer>();
		HashMap<Integer, List> amenitiesMap = new HashMap<Integer, List>();
		HashMap<Integer, List> accreditationMap = new HashMap<Integer, List>();
		HashMap<Integer, List> expertsMap = new HashMap<Integer, List>();
		HashMap<Integer, List> youGetUpToMap = new HashMap<Integer, List>();
		HashMap<Integer, List> youPayUpToMap = new HashMap<Integer, List>();
		HashMap<Integer, List> estimatedCostMap = new HashMap<Integer, List>();
		HashMap<Integer, List> practitionerMap = new HashMap<Integer, List>();
		HashMap<Integer, List> availableMap = new HashMap<Integer, List>();
		HashMap<Integer, List> ratingMap = new HashMap<Integer, List>();
		HashMap<Integer, List> unitMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderImageMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderAllImageMap = new HashMap<Integer, List>();
		HashMap<Integer, List> healthcareproviderAllVideoMap = new HashMap<Integer, List>();
		HashMap<Integer, List> equipmentMap = new HashMap<Integer, List>();
		HashMap<String, List> featureMap = new HashMap<String, List>();
		HashMap<Integer, List> hcpfeatureMap = new HashMap<Integer, List>();
		HashMap<String, List> unitDescriptionMap = new HashMap<String, List>();
		HashMap<Integer, List> hcpAmenities = new HashMap<Integer, List>();
		HashMap<Integer, List> hcpEquipments = new HashMap<Integer, List>();

		Set<String> regions = new HashSet<String>();
		Set<String> equipments = new HashSet<String>();
		Set<String> amenities = new HashSet<String>();
		Set<String> accreditations = new HashSet<String>();
		Set<Integer> ratings = new HashSet<Integer>();
		Set<Double> estimatedCost = new HashSet<Double>();
		Set<Double> bonusSet = new HashSet<Double>();
		HashMap<String, Integer> regionsMap = new HashMap<String, Integer>();
		LinkedHashMap<String, Integer> volumeMap = this.getVolumeMap();
		HashMap<String, Integer> volumeCountMap = this.getVolumeCountMap();
		HashMap<String, Integer> amenityMap = new HashMap<String, Integer>();
		HashMap<String, Integer> equipmentsMap = new HashMap<String, Integer>();

		ArrayList list;
		List<Double> distanceList = new ArrayList<Double>();
		List<Double> flighthourList = new ArrayList<Double>();
		List<HealthcareproviderModel> totalHospitalResult = new ArrayList<HealthcareproviderModel>();
		List<HealthcareproviderModel> limitedHospitalResult = new ArrayList<HealthcareproviderModel>();
		List<HealthcareproviderModel> totalResult = new ArrayList<HealthcareproviderModel>();

		HospitalFilterModel hospitalFilter = new HospitalFilterModel();
		Boolean isCorporatePatient = false;
		Boolean forcorporate = false;
		String currency = null;
		if (this.getUserService().getIsCorporatePatient()) {
			employeeCorporatecompanyDetailModel = this.getUserService()
					.getEmployeeCorporatecompanyDetailModelByPatient(
							this.getUserService().getCurrentUserId());
			if (employeeCorporatecompanyDetailModel.getId() == null
					&& this.getUserService().getDependent() != null) {
				employeeCorporatecompanyDetailModel = this.getUserService()
						.getEmployeeCorporatecompanyDetailModelByPatient(
								this.getUserService().getDependent());
			}
			if (patientLatLonModel.getCity() != null) {
				patientCountry = patientLatLonModel.getCountry();
			}
			else if (employeeCorporatecompanyDetailModel.getCity() != null) {
				patientCountry = employeeCorporatecompanyDetailModel
						.getCountry();
			}
			isCorporatePatient = true;
			forcorporate = true;
		}

		if (!healthcareproviders.isEmpty()) {
			for (HealthcareproviderModel f : healthcareproviders) {
				if (f.getDistance() < this.getUserService()
						.getSearchUrlService()
						.getMinimumDistanceForAirTravel()) {
					f.setFlighthours(0.0);
				}
				if (f.getStateCode() != null && f.getAhaId() != null) {
					if (f.getUsnewsName() != null) {
						f.setRatingUrl(this.getUserService()
								.getSearchUrlService().getRatingUrl()
								+ f.getStateCode() + "/"
								+ f.getName().replaceAll(" ", "-").toLowerCase()
								+ "-" + f.getAhaId() + "/" + f.getUsnewsName());
					}
					else {
						f.setRatingUrl(this.getUserService()
								.getSearchUrlService().getRatingUrl()
								+ f.getStateCode() + "/"
								+ f.getName().replaceAll(" ", "-").toLowerCase()
								+ "-" + f.getAhaId());
					}
					//Build and set the USNews report doctor link:
					String doctorsURL = buildDoctorsURL(f);
					f.setDoctorsUrl(doctorsURL);
				}
				if (isCorporatePatient) {
					if (f.getCorporatecompanyInsurance() != null
							&& !employeeCorporatecompanyDetailModel
									.getCorporateCompany()
									.equals(f.getCorporatecompanyInsurance())) {
						continue;
					}
					f.setYouPayUpTo(this.getCalculateService().getYouPayUpTo(
							employeeCorporatecompanyDetailModel, originPrice));
					f.setYouGetUpTo(this.getCalculateService().getYouGetUpTo(
							employeeCorporatecompanyDetailModel, originPrice,
							f.getYouPayUpTo(),
							this.getDestinationCost(f, patientCountry)));
					f.setIsAvailable(
							this.getCalculateService().getHospitalIsAvailable(
									employeeCorporatecompanyDetailModel,
									originPrice, f.getYouPayUpTo(),
									this.getDestinationCost(f,
											patientCountry)));
				}
				else {
					f.setYouPayUpTo(0.0);
					f.setYouGetUpTo(0.0);
					if (f.getEstimatedCost() == null
							|| f.getEstimatedCost() <= 0) {
						f.setIsAvailable(false);
					}
					else {
						f.setIsAvailable(true);
					}
				}

				if (f.getIsAvailable()) {
					regions.add(f.getRegionName());
					if (f.getAmenity() != null && f.getIsDisplay()) {
						amenities.add(f.getAmenity().replace('/', ' '));
					}
					if (f.getEstimatedCost() != null) {
						estimatedCost.add(f.getEstimatedCost());
					}
					if (result.add(f.getId())) {
						healthcareproviderList.add(f);
					}

					if (!amenitiesMap.containsKey(f.getId())) {
						if (f.getAmenity() != null && f.getIsDisplay()) {
							List<String> arrayList = new ArrayList<String>();
							arrayList.add(f.getAmenity().replace('/', ' '));
							amenitiesMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getAmenity() != null && f.getIsDisplay()) {
							List<String> arrayList = (List) amenitiesMap
									.get(f.getId());
							arrayList.add(f.getAmenity().replace('/', ' '));
						}
					}

					if (!estimatedCostMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getEstimatedCost() != 0) {
							arrayList.add(f.getEstimatedCost());
							estimatedCostMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getEstimatedCost() != 0) {
							List arrayList = (List) estimatedCostMap
									.get(f.getId());
							arrayList.add(f.getEstimatedCost());
						}
					}
					if (!youPayUpToMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getYouPayUpTo() != 0) {
							arrayList.add(f.getYouPayUpTo());
							youPayUpToMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getYouPayUpTo() != 0) {
							List arrayList = (List) youPayUpToMap
									.get(f.getId());
							arrayList.add(f.getYouPayUpTo());
						}
					}
					if (!youGetUpToMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getYouGetUpTo() != 0) {
							arrayList.add(f.getYouGetUpTo());
							youGetUpToMap.put(f.getId(), arrayList);
						}
					}
					else {
						if (f.getYouGetUpTo() != 0) {
							List arrayList = (List) youGetUpToMap
									.get(f.getId());
							arrayList.add(f.getYouGetUpTo());
						}
					}

					if (!healthcareproviderImageMap.containsKey(f.getId())) {
						List arrayList = new ArrayList();
						if (f.getHealthcareproviderImage() != null
								&& f.getIsPrimary()) {
							arrayList.add("/doctorglobe-hospital/hospital/"
									+ f.getId() + "/photo/"
									+ f.getHealthcareproviderImage());
							healthcareproviderImageMap.put(f.getId(),
									arrayList);
						}
						else {
							String icon = f.getVolume().toLowerCase()
									.replace(" ", "");
							arrayList.add("/resources/img/" + icon + ".png");
							healthcareproviderImageMap.put(f.getId(),
									arrayList);
						}
					}
				}
			}
		}

		if (!healthcareproviderList.isEmpty()) {
			Integer count = 1;
			Boolean found = false, filterFound = false;
			for (HealthcareproviderModel fm : healthcareproviderList) {
				found = false;
				if (!filterSelected) {
					found = true;
				}
				if (equipmentMap.containsKey(fm.getId())) {
					String equipment = "";
					Set set = new HashSet(equipmentMap.get(fm.getId()));
					list = new ArrayList(set);
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) != null) {
							equipment += list.get(i).toString().replace(" ", "")
									+ " ";
						}
					}
					fm.setEquipment(equipment.toLowerCase());
				}
				if (amenitiesMap.containsKey(fm.getId())) {
					String amenity = "";
					Set set = new HashSet(amenitiesMap.get(fm.getId()));
					list = new ArrayList(set);
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) != null) {
							if (amenityMap.containsKey(list.get(i))) {
								amenityMap
										.put(list.get(i).toString(),
												amenityMap
														.get(list.get(i)
																.toString())
														+ 1);
							}
							else {
								amenityMap.put(list.get(i).toString(), 1);
							}
							amenity += list.get(i).toString().replace(" ", "")
									+ " ";
						}
					}
					fm.setAmenity(amenity.toLowerCase());
				}
				if (accreditationMap.containsKey(fm.getId())) {
					String accreditation = "";
					Set set = new HashSet(accreditationMap.get(fm.getId()));
					list = new ArrayList(set);
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) != null) {
							accreditation += list.get(i).toString().replace(" ",
									"") + " ";
						}
					}
					fm.setAccreditation(accreditation.toLowerCase());
				}
				if (expertsMap.containsKey(fm.getId())) {
					Set set = new HashSet(expertsMap.get(fm.getId()));
					if (set.contains(0)) {
						set.remove(0);
					}
					fm.setExperts(set.size());

				}
				if (estimatedCostMap.containsKey(fm.getId())) {
					Set set = new HashSet(estimatedCostMap.get(fm.getId()));
					double mincost = (Double) Collections.min(set);
					double maxcost = (Double) Collections.max(set);
					fm.setEstimatedCost(mincost);
				}
				if (youGetUpToMap.containsKey(fm.getId())) {
					Set set = new HashSet(youGetUpToMap.get(fm.getId()));
					double minYouGetUpTo = (Double) Collections.min(set);
					fm.setYouGetUpTo(minYouGetUpTo);
				}
				if (youPayUpToMap.containsKey(fm.getId())) {
					Set set = new HashSet(youPayUpToMap.get(fm.getId()));
					double maxYouPayUpTo = (Double) Collections.max(set);
					fm.setYouPayUpTo(maxYouPayUpTo);
				}

				if (fm.getRegionName() != null && fm.getIsAvailable()) {
					if (regionsMap.containsKey(fm.getRegionName())) {
						regionsMap.put(fm.getRegionName(),
								regionsMap.get(fm.getRegionName()) + 1);
					}
					else {
						regionsMap.put(fm.getRegionName(), 1);
					}
				}
				if (fm.getYouGetUpTo() != null) {
					bonusSet.add(fm.getYouGetUpTo());
				}
				if (fm.getDistance() != null) {
					distanceList.add(fm.getDistance());
				}
				if (fm.getFlighthours() != null) {
					flighthourList.add(fm.getFlighthours());
				}

				if (sliderChange) {
					if (fm.getDistance() != null && !forcorporate) {
						if (fm.getDistance() <= distanceFilter
								&& fm.getEstimatedCost() >= priceFilter) {
							if (volumeCountMap.containsKey(fm.getVolume())) {
								volumeCountMap.put(fm.getVolume(),
										volumeCountMap.get(fm.getVolume()) + 1);
							}
						}
					}
					else if (fm.getDistance() != null && forcorporate) {
						if (fm.getDistance() <= distanceFilter
								&& fm.getYouGetUpTo() >= priceFilter) {
							if (volumeCountMap.containsKey(fm.getVolume())) {
								volumeCountMap.put(fm.getVolume(),
										volumeCountMap.get(fm.getVolume()) + 1);
							}
						}
					}
				}

				if (regionFilter != null
						&& regionFilter.contains(fm.getRegionName())) {
					found = true;
				}
				if (regionFilter != null) {
					found = found && volumeFilter != null
							&& !volumeFilter.contains(fm.getVolume());
				}
				else if (volumeFilter != null
						&& volumeFilter.contains(fm.getVolume())) {
					found = true;
				}

				if (found && distanceFilter != null) {
					if (fm.getDistance() != null) {
						found = fm.getDistance() <= distanceFilter;
					}
				}
				if (found && priceFilter != null) {
					if (!forcorporate) {
						found = fm.getEstimatedCost() >= priceFilter;
					}
					else {
						found = fm.getYouGetUpTo() >= priceFilter;
					}
				}

				if (found && flighthourFilter != null) {
					found = fm.getFlighthours() <= flighthourFilter;
				}

				if (found) {
					if (textFilter != null) {
						if (fm.getName().toLowerCase()
								.contains(textFilter.toLowerCase())) {
							totalHospitalResult.add(fm);
						}
					}
					else {
						totalHospitalResult.add(fm);
					}
				}
			}
		}
		hospitalFilter
				.setHealthcareproviderImageMap(healthcareproviderImageMap);
		hospitalFilter.setAmentiesMap(amenitiesMap);
		hospitalFilter.setVolumeCountMap(volumeCountMap);
		if (patientLatLonModel.getLat() != null
				&& patientLatLonModel.getLat() != null) {
			logger.info("city Name {}", patientLatLonModel.getCityName());
			hospitalFilter.setCityName(patientLatLonModel.getCityName());
			hospitalFilter.setStateCode(patientLatLonModel.getStateCode());
		}
		for (HealthcareproviderModel f : totalHospitalResult) {
			f.setHospitalFilterModel(hospitalFilter);
		}
		return totalHospitalResult;
	}

	/**
	 * Disabled healthcareprovider if patient already selected
	 * @param limitedHospitalResult
	 * @param resultLimit
	 * @param treatment
	 * @return HealthcareproviderModel list
	 */
	public List<HealthcareproviderModel> getLimitedHospitalResults(
			List<HealthcareproviderModel> limitedHospitalResult,
			Integer resultLimit, Integer treatment) {
		List<HealthcareproviderModel> displayHospitalResult = new ArrayList<HealthcareproviderModel>();
		BigInteger pc = userService.getPatientcaseByTreatment(treatment);
		logger.info("patient case found for treatment {}", pc);
		for (HealthcareproviderModel f : limitedHospitalResult) {
			if (displayHospitalResult.size() < resultLimit) {
				if (pc != null) {
					if (userService.checkPractitionerByPatientTreatment(pc,
							treatment, f.getHcpstmpId())) {
//Findme: Disabling the next line is a hack to enable concierge to select the same hospital multiple times.
//						f.setIsDisabled(true);
					}
				}
				displayHospitalResult.add(f);
			}
		}
		return displayHospitalResult;
	}

	/**
	 * Gets destination cost of hospital depend upon patient country
	 * @param model
	 * @param patientCountry
	 * @return double
	 */
	public Double getDestinationCost(HealthcareproviderModel model,
			BigInteger patientCountry) {
		Double destinationCost = 0.0;
		// logger.info("hospital id ,cost,country,patientCountry
		// ["+model.getId()+","+model.getEstimatedCost()+","+model.getCountry()+","+patientCountry+"]");
		if (model.getEstimatedCost() != null) {
			destinationCost = model.getEstimatedCost();
		}
		Integer totalDays = 0;
		if (model.getDistance() > this.getUserService().getSearchUrlService()
				.getMinimumDistanceForHotel()) {
			totalDays = model.getBeforeDays() + model.getAfterDays()
					+ model.getTreatmentDays();
			destinationCost += totalDays * model.getDailyExpense();
		}
		if (model.getDistance() > this.getUserService().getSearchUrlService()
				.getMinimumDistanceForAirTravel()) {
			if (model.getCountry().equals(patientCountry)) {
				destinationCost += 2 * this.getUserService()
						.getSearchUrlService().getDomesticFlightCost();
			}
			else {
				destinationCost += 2 * this.getUserService()
						.getSearchUrlService().getInternationalFlightCost();
			}
		}
		else {
			destinationCost += 2 * (model.getDistance() * this.getUserService()
					.getSearchUrlService().getTaxiCostPerMileToHospital());
		}
		// logger.info("destination Cost for hospital
		// ["+model.getId()+","+destinationCost+"]");
		return destinationCost;
	}

	/**
	 * Gets default volume filter values list
	 * @return string list
	 */
	public List<String> getVolumeDefaultFilter() {
		List<String> volumeList = new ArrayList<String>();
		volumeList.add("High");
		volumeList.add("Moderately High");
		volumeList.add("Moderate");
		volumeList.add("Moderately Low");
		volumeList.add("Low");
		return volumeList;
	}

	/**
	 * Gets default volume filter count values list
	 * @return LinkedHashMap<String,Integer>
	 */
	public LinkedHashMap<String, Integer> getVolumeMap() {
		LinkedHashMap<String, Integer> volumeMap = new LinkedHashMap<String, Integer>();
		volumeMap.put("High", 0);
		volumeMap.put("Moderately High", 0);
		volumeMap.put("Moderate", 0);
		volumeMap.put("Moderately Low", 0);
		volumeMap.put("Low", 0);
		return volumeMap;
	}

	/**
	 * Gets default hospital volume count map
	 * @return HashMap
	 */
	public HashMap<String, Integer> getVolumeCountMap() {
		HashMap<String, Integer> volumeMap = new HashMap<String, Integer>();
		volumeMap.put("High", 0);
		volumeMap.put("Moderately High", 0);
		volumeMap.put("Moderate", 0);
		volumeMap.put("Moderately Low", 0);
		volumeMap.put("Low", 0);
		return volumeMap;
	}

	/**
	 * Gets hospital result page filter data
	 * @param healthcareprovider
	 * @return HospitalFilterModel
	 */
	public HospitalFilterModel getHospitalFilterModel(
			List<HealthcareproviderModel> healthcareprovider) {
		HospitalFilterModel model = new HospitalFilterModel();
		for (HealthcareproviderModel f : healthcareprovider) {
			f.getHospitalFilterModel().setTreatmentName(f.getTreatmentName());
			f.getHospitalFilterModel().setCurrency(f.getCurrencyCode());
			model = f.getHospitalFilterModel();
			break;
		}
		return model;
	}

	/**
	 * Check patient conference limit is valid or not
	 * @param treatment
	 * @return boolean
	 */
	public Boolean getLimitExceed(Integer treatment) {
		boolean limitExceed = false;
		Integer totalTreatmentConference = this.getUserService()
				.getTotalPatientTreatmentConference(
						this.getUserService().getCurrentUserId(), treatment);
		if (this.getUserService().getSearchUrlService()
				.getCaseConferenceLimit() <= totalTreatmentConference) {
			limitExceed = true;
		}
		List<PatientCaseBookingModel> pcbList = this.getUserService()
				.getPatientCaseBookingModelByPatientAndTreatment(
						this.getUserService().getCurrentUserId(), treatment);
		if (!pcbList.isEmpty()) {
			limitExceed = true;
		}
		return limitExceed;
	}

	/**
	 * Check if user result size is valid or not
	 * @param result size
	 * @return boolean
	 */
	public Boolean getViewMore(Integer resultSize, Integer limit) {
		return resultSize > this.getUserService().getSearchUrlService()
				.getResultLimit() * limit;
	}

	/**
	 * Gets sorted healthcareprovider list based on user selected sorting filter
	 * @param totalHospitalResult
	 * @param sortingFilter
	 * @return HealthcareproviderModel list
	 */
	public List<HealthcareproviderModel> getSortBy(
			List<HealthcareproviderModel> totalHospitalResult,
			String sortingFilter) {

		if (sortingFilter != null
				&& !sortingFilter.equalsIgnoreCase("rankings")) {
			if (sortingFilter.equalsIgnoreCase("bonus")) {
				Collections.sort(totalHospitalResult, this.bonusSorting);
			}
			else if (sortingFilter.equalsIgnoreCase("price")) {
				Collections.sort(totalHospitalResult, this.costSorting);
			}
			else if (sortingFilter.equalsIgnoreCase("volume")) {
				Collections.sort(totalHospitalResult, this.volumeSorting);
			}
			else if (sortingFilter.equalsIgnoreCase("distancelh")) {
				Collections.sort(totalHospitalResult, this.distanceSorting);
			}
			else if (sortingFilter.equalsIgnoreCase("distancehl")) {
				Collections.sort(totalHospitalResult, this.distanceDescSorting);
			}
		}
		return totalHospitalResult;
	}

	/* Comparator for sorting the list by bonus desc order */
	public static Comparator<HealthcareproviderModel> bonusSorting = new Comparator<HealthcareproviderModel>() {
		public int compare(HealthcareproviderModel h1,
				HealthcareproviderModel h2) {
			Double bonus1 = h1.getYouGetUpTo();
			Double bonus2 = h2.getYouGetUpTo();
			int result = bonus1.compareTo(bonus2);
			if (result > 0)
				return -1;
			else if (result < 0)
				return 1;
			else
				return 0;
		}
	};

	/* Comparator for sorting the list by cost */
	public static Comparator<HealthcareproviderModel> costSorting = new Comparator<HealthcareproviderModel>() {
		public int compare(HealthcareproviderModel h1,
				HealthcareproviderModel h2) {
			Double a = h1.getEstimatedCost();
			Double b = h2.getEstimatedCost();
			int result = a.compareTo(b);
			if (result < 0)
				return -1;
			else if (result > 0)
				return 1;
			else
				return 0;
		}
	};

	/* Comparator for sorting the list by volume */
	public static Comparator<HealthcareproviderModel> volumeSorting = new Comparator<HealthcareproviderModel>() {
		public int compare(HealthcareproviderModel h1,
				HealthcareproviderModel h2) {
			if (h1.getNumberPerformedLastYear() != null) {
				int a = h1.getNumberPerformedLastYear();
				int b = h2.getNumberPerformedLastYear();
				return b - a;
			}
			return 0;
		}
	};

	/* Comparator for sorting the list by distance */
	public static Comparator<HealthcareproviderModel> distanceSorting = new Comparator<HealthcareproviderModel>() {
		public int compare(HealthcareproviderModel h1,
				HealthcareproviderModel h2) {
			if (h1.getDistance() != null) {
				Double a = h1.getDistance();
				Double b = h2.getDistance();
				int result = a.compareTo(b);
				if (result < 0)
					return -1;
				else if (result > 0)
					return 1;
				else
					return 0;
			}
			return 0;
		}
	};

	/* Comparator for sorting the list by distance */
	public static Comparator<HealthcareproviderModel> distanceDescSorting = new Comparator<HealthcareproviderModel>() {
		public int compare(HealthcareproviderModel h1,
				HealthcareproviderModel h2) {
			if (h1.getDistance() != null) {
				Double a = h1.getDistance();
				Double b = h2.getDistance();
				int result = b.compareTo(a);
				if (result < 0)
					return -1;
				else if (result > 0)
					return 1;
				else
					return 0;
			}
			return 0;
		}
	};

	/* Build the URL that points to the doctors comparison page for a given Healthcareprovider */
	private String buildDoctorsURL(HealthcareproviderModel f) {
		String doctorsURL = this.getUserService().getSearchUrlService().getRatingUrl()
				//findme: doctor should have their own link in the property file (don't build on top of main USNews link)
				// The code below points to the filter doctors page
				+ "../../doctors/search?"
				+ "hospital=" + f.getAhaId()
				+ "&sort=name-asc"
				+ "&specialty=" + f.getUsnewsDoctorLink();
				
		// The code below points to the hospital's doctors page. It may be better, but USNews has a bug that prevents us from using it.
//			+ f.getStateCode() + "/"
//			+ f.getName().replaceAll(" ", "-").toLowerCase()
//			+ "-" + f.getAhaId()
//			+ "/doctors/"
//			+ f.getUsnewsDoctorLink();
		
		return doctorsURL;
	}
}