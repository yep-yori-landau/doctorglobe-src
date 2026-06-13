package com.dg.patient.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.patient.model.HealthcareproviderModel;
/**
 * @author DoctorGlobe
 * 
 */
public class OriginPriceCalculationService {

	private static final Logger logger = LoggerFactory
			.getLogger(OriginPriceCalculationService.class);

	private Double minimumHospitalNumForOriginPrice;

	private Double originRadius;

	public void setMinimumHospitalNumForOriginPrice(
			Double minimumHospitalNumForOriginPrice) {
		this.minimumHospitalNumForOriginPrice = minimumHospitalNumForOriginPrice;
	}

	public Double getMinimumHospitalNumForOriginPrice() {
		return minimumHospitalNumForOriginPrice;
	}

	public void setOriginRadius(Double originRadius) {
		this.originRadius = originRadius;
	}

	public Double getOriginRadius() {
		return originRadius;
	}

	/**
	 * Get Origin price based on below params
	 * @param healthcareproviderModel the list of healthcareproviderModel
	 * @param originRadius the double value of origin radius
	 * @param minimumHospitalNumForOriginPrice 
	 * @return double
	 */
	public Double getOrginPrice(
			List<HealthcareproviderModel> healthcareproviderModel,
			Double originRadius, Double minimumHospitalNumForOriginPrice) {
		Double originPrice = 0.0;
		Double totalProcedures = 0.0;
		Double hospitalCost = 0.0;
		Integer count = 0;
		List<HealthcareproviderModel> uniqueHealthcareproviderModelList = new ArrayList<HealthcareproviderModel>();
		Set<Integer> result = new HashSet<Integer>();
		for (HealthcareproviderModel model : healthcareproviderModel) {
			if (result.add(model.getId())) {
				uniqueHealthcareproviderModelList.add(model);
			}
		}
		if (originRadius == null) {
			originRadius = this.getOriginRadius();
		}
		if (minimumHospitalNumForOriginPrice == null) {
			minimumHospitalNumForOriginPrice = this
					.getMinimumHospitalNumForOriginPrice();
		}
		logger.info("origin Radius = {}", originRadius);
		logger.info("minimumHospitalNumForOriginPrice = {}",
				minimumHospitalNumForOriginPrice);
		if (minimumHospitalNumForOriginPrice <= 0) {
			return 0.0;
		}

		if (!uniqueHealthcareproviderModelList.isEmpty()) {
			if (uniqueHealthcareproviderModelList
					.size() < minimumHospitalNumForOriginPrice) {
				minimumHospitalNumForOriginPrice = Double
						.valueOf(uniqueHealthcareproviderModelList.size());
			}
			count = 0;
			for (HealthcareproviderModel model : uniqueHealthcareproviderModelList) {
				if (model.getDistance() <= originRadius) {
					logger.info(
							"orgin price hospital id,name,distance,cost,procedure,total cost [ "
									+ model.getId() + " ," + model.getName()
									+ " ," + model.getDistance() + " ,"
									+ model.getEstimatedCost() + " ,"
									+ model.getNumberPerformedLastYear() + " ,"
									+ model.getNumberPerformedLastYear()
											* model.getEstimatedCost()
									+ "]");
					hospitalCost += model.getEstimatedCost()
							* model.getNumberPerformedLastYear();
					totalProcedures += model.getNumberPerformedLastYear();
					count++;
				}
			}
			if (count >= minimumHospitalNumForOriginPrice) {
				logger.info("total Hospital found {}", count);
				logger.info("total Hospital cost {}", hospitalCost);
				logger.info("total Hospital procedures {}", totalProcedures);
				originPrice = hospitalCost / totalProcedures;
			}
			else {
				originPrice = this.getOrginPrice(
						uniqueHealthcareproviderModelList, originRadius * 2,
						minimumHospitalNumForOriginPrice);
			}
		}
		return originPrice;
	}
}