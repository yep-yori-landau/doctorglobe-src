
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderAmenityDAO;
import com.dg.data.model.db.HealthcareproviderAmenity;
import com.dg.data.service.HealthcareproviderAmenityService;

/**
 * @author DoctorGlobe HealthcareproviderAmenityService CountryService
 */

@Service("healthcareproviderAmenityService")
public class HealthcareproviderAmenityServiceImpl
		extends GenericServiceImpl<HealthcareproviderAmenity>
		implements HealthcareproviderAmenityService {

	private HealthcareproviderAmenityDAO healthcareproviderAmenityDAO;

	@Autowired
	public HealthcareproviderAmenityServiceImpl(
			HealthcareproviderAmenityDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderAmenityDAO = (HealthcareproviderAmenityDAO) genericDAO;
	}

	/**
	 * get list of health care provider Amenity by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderAmenity> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderAmenityDAO
				.findByHealthacareprovider(healthcareprovider);
	}

}
