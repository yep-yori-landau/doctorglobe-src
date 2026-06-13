package com.dg.patient.model;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
/**
 * @author DoctorGlobe
 * 
 */
public class HospitalFilterModel {

	/**
	 * The amenitiesMap of HospitalFilterModel
	 */
	private HashMap<Integer, List> amenitiesMap;

	/**
	 * The healthcareproviderImageMap of HospitalFilterModel
	 */
	private HashMap<Integer, List> healthcareproviderImageMap;

	/**
	 * The volumeCountMap of HospitalFilterModel
	 */
	private HashMap<String, Integer> volumeCountMap;

	/**
	 * The treatmentName of HospitalFilterModel
	 */
	private String treatmentName;

	/**
	 * The distanceList of HospitalFilterModel
	 */
	private List<Double> distanceList;

	/**
	 * The estimated costSet of HospitalFilterModel
	 */
	private Set<Double> estimatedCostSet;

	/**
	 * The bonusSet of HospitalFilterModel
	 */
	private Set<Double> bonusSet;

	/**
	 * The flighthourList of HospitalFilterModel
	 */
	private List<Double> flighthourList;

	/**
	 * The stateCode of HospitalFilterModel
	 */
	private String stateCode;

	/**
	 * The cityName of HospitalFilterModel
	 */
	private String cityName;

	/**
	 * The currency of HospitalFilterModel
	 */
	private String currency;

	/**
	 * 
	 * @return amenitesMap
	 */
	public HashMap<Integer, List> getAmentiesMap() {
		return amenitiesMap;
	}

	/**
	 * 
	 * @param amenitiesMap
	 */
	public void setAmentiesMap(HashMap<Integer, List> amenitiesMap) {
		this.amenitiesMap = amenitiesMap;
	}

	/**
	 * 
	 * @return healthcareproviderImageMap
	 */
	public HashMap<Integer, List> getHealthcareproviderImageMap() {
		return healthcareproviderImageMap;
	}

	/**
	 * 
	 * @param healthcareproviderImageMap
	 */
	public void setHealthcareproviderImageMap(
			HashMap<Integer, List> healthcareproviderImageMap) {
		this.healthcareproviderImageMap = healthcareproviderImageMap;
	}

	/**
	 * 
	 * @return volumeCountMap
	 */
	public HashMap<String, Integer> getVolumeCountMap() {
		return volumeCountMap;
	}

	/**
	 * 
	 * @param volumeCountMap
	 */
	public void setVolumeCountMap(HashMap<String, Integer> volumeCountMap) {
		this.volumeCountMap = volumeCountMap;
	}

	/**
	 * 
	 * @return treatmentName
	 */
	public String getTreatmentName() {
		return treatmentName;
	}

	/**
	 * 
	 * @return treatmentName
	 */
	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	/**
	 * 
	 * @return distanceList
	 */
	public List<Double> getDistanceList() {
		return distanceList;
	}

	/**
	 * 
	 * @param distanceList
	 */
	public void setDistanceList(List<Double> distanceList) {
		this.distanceList = distanceList;
	}

	/**
	 * 
	 * @return flighthourList
	 */
	public List<Double> getFlighthourList() {
		return flighthourList;
	}

	/**
	 * 
	 * @param flighthourList
	 */
	public void setFlighthourList(List<Double> flighthourList) {
		this.flighthourList = flighthourList;
	}

	/**
	 * 
	 * @return estimatedCostSet
	 */
	public Set<Double> getEstimatedCostSet() {
		return estimatedCostSet;
	}

	/**
	 * 
	 * @param estimatedCostSet
	 */
	public void setEstimatedCostSet(Set<Double> estimatedCostSet) {
		this.estimatedCostSet = estimatedCostSet;
	}
	
	/**
	 * 
	 * @return bounsList
	 */
	public Set<Double> getBonusSet() {
		return bonusSet;
	}

	/**
	 * 
	 * @param bonusSet
	 */
	public void setBonusSet(Set<Double> bonusSet) {
		this.bonusSet = bonusSet;
	}

	/**
	 * 
	 * @return stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * 
	 * @return stateCode
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * 
	 * @return cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * 
	 * @return cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * 
	 * @return cityName
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
