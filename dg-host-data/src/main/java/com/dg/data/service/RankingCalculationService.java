package com.dg.data.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RankingCalculationService {

	private Double distanceWeight;

	private Double bonusWeight;

	private Double volumeWeight;

	/**
	 * 
	 * @param distanceWeight
	 */
	public void setDistanceWeight(Double distanceWeight) {
		this.distanceWeight = distanceWeight;
	}

	/**
	 * 
	 * @return distanceWeight
	 */
	public Double getDistanceWeight() {
		return this.distanceWeight;
	}

	/**
	 * 
	 * @param bonusWeight
	 */
	public void setBonusWeight(Double bonusWeight) {
		this.bonusWeight = bonusWeight;
	}

	/**
	 * 
	 * @return bonusWeight
	 */
	public Double getBonusWeight() {
		return this.bonusWeight;
	}

	/**
	 * 
	 * @param volumeWeight
	 */
	public void setVolumeWeight(Double volumeWeight) {
		this.volumeWeight = volumeWeight;
	}

	/**
	 * 
	 * @return volumeWeight
	 */
	public Double getVolumeWeight() {
		return this.volumeWeight;
	}

	public Double getDistanceVal(Double distance) {
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

	public Double getQualityVal(Integer number_performed_last_year) {
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
	public Double getBonusVal(Double estimatedCost, Double originCost) {
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

	public HashMap getSortByValues(HashMap<Integer, Double> map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
}