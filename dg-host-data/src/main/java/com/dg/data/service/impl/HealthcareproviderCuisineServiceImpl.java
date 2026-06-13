
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderCuisineDAO;
import com.dg.data.model.db.HealthcareproviderCuisine;
import com.dg.data.service.HealthcareproviderCuisineService;

/**
 * @author DoctorGlobe HealthcareproviderCuisineService CountryService
 */

@Service("healthcareproviderCuisineService")
public class HealthcareproviderCuisineServiceImpl
		extends GenericServiceImpl<HealthcareproviderCuisine>
		implements HealthcareproviderCuisineService {

	private HealthcareproviderCuisineDAO healthcareproviderCuisineDAO;

	@Autowired
	public HealthcareproviderCuisineServiceImpl(
			HealthcareproviderCuisineDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderCuisineDAO = (HealthcareproviderCuisineDAO) genericDAO;
	}

	/**
	 * get list of health care provider Cuisine by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderCuisine> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderCuisineDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
