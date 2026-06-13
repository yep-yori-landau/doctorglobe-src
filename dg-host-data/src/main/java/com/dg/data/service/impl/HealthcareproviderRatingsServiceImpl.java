
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderRatingsDAO;
import com.dg.data.model.db.HealthcareproviderRatings;
import com.dg.data.service.HealthcareproviderRatingsService;

/**
 * @author DoctorGlobe HealthcareproviderRatingsService CountryService
 */

@Service("healthcareproviderRatingsService")
public class HealthcareproviderRatingsServiceImpl
		extends GenericServiceImpl<HealthcareproviderRatings>
		implements HealthcareproviderRatingsService {

	private HealthcareproviderRatingsDAO healthcareproviderRatingsDAO;

	@Autowired
	public HealthcareproviderRatingsServiceImpl(
			HealthcareproviderRatingsDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderRatingsDAO = (HealthcareproviderRatingsDAO) genericDAO;
	}

	/**
	 * get list of health care provider ratings by health care provider id
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderRatings> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderRatingsDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
