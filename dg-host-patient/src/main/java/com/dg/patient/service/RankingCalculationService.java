package com.dg.patient.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dg.patient.model.HealthcareproviderModel;
/**
 * @author DoctorGlobe
 * 
 */

public class RankingCalculationService {

	private static final Logger logger = LoggerFactory.getLogger(RankingCalculationService.class);

	private Double distanceWeight;
	private Double bonusWeight;
	private Double volumeWeight;

	/**
	 * @param distanceWeight
	 */
	public void setDistanceWeight(Double distanceWeight) {
		this.distanceWeight = distanceWeight;
	}

	/**
	 * @return distanceWeight
	 */
	public Double getDistanceWeight() {
		return this.distanceWeight;
	}

	/**
	 * @param bonusWeight
	 */
	public void setBonusWeight(Double bonusWeight) {
		this.bonusWeight = bonusWeight;
	}

	/**
	 * @return bonusWeight
	 */
	public Double getBonusWeight() {
		return this.bonusWeight;
	}

	/**
	 * @param volumeWeight
	 */
	public void setVolumeWeight(Double volumeWeight) {
		this.volumeWeight = volumeWeight;
	}

	/**
	 * @return volumeWeight
	 */
	public Double getVolumeWeight() {
		return this.volumeWeight;
	}

	/**
	 * This function set the ranking of hospitals based on distance,origin price
	 * and performance.
	 * @param healthcareproviderModel
	 * @param originPrice
	 * @return the list of HealthcareproviderModel
	 */
	public List<HealthcareproviderModel> setRanking(
			List<HealthcareproviderModel> healthcareproviderModel,
			Double originPrice) {

		HashMap<Integer, Double> ratingValueMap = new HashMap<Integer, Double>();
		HashMap<Integer, Double> ratingMap = new HashMap<Integer, Double>();
		HashMap<Integer, Integer> healthcareproviderRatingMap = new HashMap<Integer, Integer>();

		for (HealthcareproviderModel model : healthcareproviderModel) {
			Double total = 0.0;
			if (model.getDistance() != null) {
				total += this.getDistanceVal(model.getDistance()) * this.getDistanceWeight();
			}
			else {
				total += 0.0;
			}

			if (originPrice != null) {
				total += this.getBonusVal(model.getEstimatedCost(), originPrice) * this.getBonusWeight();
			}
			else {
				total += 0.0;
			}

			if (model.getNumberPerformedLastYear() != null) {
				total += this.getQualityVal(model) * this.getVolumeWeight();
			}
			ratingValueMap.put(model.getId(), total);
		}
		ratingMap = this.getSortByValues(ratingValueMap);
		 logger.info("rating map {}",ratingMap);
		Integer topRank = ratingMap.size();
		for (Integer key : ratingMap.keySet()) {
			healthcareproviderRatingMap.put(key, topRank--);
		}
		for (HealthcareproviderModel model : healthcareproviderModel) {
			if (healthcareproviderRatingMap.containsKey(model.getId())) {
				model.setRanking(healthcareproviderRatingMap.get(model.getId()));
			}
		}
		Collections.sort(healthcareproviderModel, RankingCalculationService.healthcareproviderRank);
		return healthcareproviderModel;
	}

	/* Comparator for sorting the list by ranking */
	private static Comparator<HealthcareproviderModel> healthcareproviderRank = new Comparator<HealthcareproviderModel>() {
		public int compare(HealthcareproviderModel h1,
				HealthcareproviderModel h2) {
			Integer rank1 = h1.getRanking();
			Integer rank2 = h2.getRanking();
			return rank1 - rank2;
		}
	};
	
	/**
	 * Gets the distance value
	 * @param distance
	 * @return double
	 */
	private Double getDistanceVal(Double distance) {
		return getDistanceVal_new(distance);
	}

	private Double getDistanceVal_new(Double distance) {
		Double distanceVal = 0.0;
		
		// Fast reduction of distance value within the first 200 miles.
		// findme: should be taken from the required distance for flight configuration value.
		if (distance <= 200)
			distanceVal = 100 - distance * 0.4;
		
		// slower reduction beyond 200 miles (once you take a flight, another mile is not so important
		else if (distance <= 2000)
			distanceVal = 20 - (distance-200) * 20/1800;
		
		// No value beyond 2,000 miles (this is just a guessed number. Could be 1,000 or 3,000 miles).
		else
			distanceVal = 0.0;

		return distanceVal;
	}

	/**
	 * Gets the distance value
	 * @param distance
	 * @return double
	 */
	private Double getDistanceVal_old(Double distance) {
		Double distanceVal = 0.0;
		if (distance <= 5) {
			distanceVal = 100.0;
		}
		else if (distance <= 10) {
			distanceVal = 95.0;
		}
		else if (distance <= 20) {
			distanceVal = 90.0;
		}
		else if (distance <= 50) {
			distanceVal = 80.0;
		}
		else if (distance <= 100) {
			distanceVal = 70.0;
		}
		else if (distance <= 200) {
			distanceVal = 50.0;
		}
		else if (distance <= 500) {
			distanceVal = 40.0;
		}
		else if (distance <= 1000) {
			distanceVal = 30.0;
		}
		else if (distance <= 2000) {
			distanceVal = 20.0;
		}
		else if (distance <= 5000) {
			distanceVal = 10.0;
		}
		else {
			distanceVal = 0.0;
		}
		return distanceVal;
	}

	/**
	 * Gets the quaility value of hospital based on number_performed_last_year
	 * by hospital
	 * @param number_performed_last_year
	 * @return douuble
	 */
	private Double getQualityVal(HealthcareproviderModel model) {
		return getQualityVal_new(model);
	}

	
	private Double getQualityVal_new(HealthcareproviderModel model) {
		// Findme: Big hack, Does not make sense to rely on those string values that were set by host data. Setting those string should probably move to host patient.
		
		Double qualityVal = 0.0;
		
		if (model.getVolume().equals("High")) {
			qualityVal = 100.0;
		}
		else if (model.getVolume().equals("Moderately High")) {
			qualityVal = 75.0;
		}
		else if (model.getVolume().equals("Moderate")) {
			qualityVal = 50.0;
		}
		else if (model.getVolume().equals("Moderately Low")) {
			qualityVal = 25.0;
		}
		else if (model.getVolume().equals("Low")) {
			qualityVal = 0.0;
		}
		else  {
			logger.error("The olmue String that was set - {}, doest not match any of the options above",model.getVolume());
		}
		
		return qualityVal;
	}
	
	private Double getQualityVal_old(HealthcareproviderModel model) {
		Integer number_performed_last_year = model.getNumberPerformedLastYear();
		
		Double qualityVal = 0.0;
		if (number_performed_last_year > 1000) {
			qualityVal = 100.0;
		}
		else {
			qualityVal = Double.valueOf(number_performed_last_year / 10);
		}
		return qualityVal;
	}
	
	// Saving ratio over 0.8 receives 100% of this attribute. Below that, the
	// value of this attribute is proportionally reduced.
	private Double getBonusVal(Double estimatedCost, Double originCost) {
		Double bonusVal = 0.0;
		Double savingRatio = (originCost - estimatedCost) / originCost;

		if (savingRatio > 0.8) {
			bonusVal = 100.0;
		}
		else {
			// (savingRatio * 10) / 8) * 100
			bonusVal = savingRatio * 125;
		}
		return bonusVal;
	}

	/**
	 * This function sorted the hashMap values
	 * @param map
	 * @return sorted hashmap
	 */
	private HashMap<Integer, Double> getSortByValues(HashMap<Integer, Double> map) {
		List<Map.Entry<Integer, Double>> list = new LinkedList<Map.Entry<Integer, Double>>(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
				return ((Comparable<Double>) ((Map.Entry<Integer, Double>) (o1)).getValue())
						.compareTo(((Map.Entry<Integer, Double>) (o2)).getValue());
			}
		});
		
		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap<Integer, Double> sortedHashMap = new LinkedHashMap<Integer, Double>();
		for (Iterator<Map.Entry<Integer, Double>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Integer, Double> entry = it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
}