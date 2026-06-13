
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderHealthcareprovidertypeDAO;
import com.dg.data.model.db.HealthcareproviderHealthcareprovidertype;
import com.dg.data.service.HealthcareproviderHealthcareprovidertypeService;

/**
 * @author DoctorGlobe HealthcareproviderHealthcareprovidertypeService
 * CountryService
 */

@Service("healthcareproviderHealthcareprovidertypeService")
public class HealthcareproviderHealthcareprovidertypeServiceImpl
		extends GenericServiceImpl<HealthcareproviderHealthcareprovidertype>
		implements HealthcareproviderHealthcareprovidertypeService {

	private HealthcareproviderHealthcareprovidertypeDAO healthcareproviderHealthcareprovidertypeDAO;

	@Autowired
	public HealthcareproviderHealthcareprovidertypeServiceImpl(
			HealthcareproviderHealthcareprovidertypeDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderHealthcareprovidertypeDAO = (HealthcareproviderHealthcareprovidertypeDAO) genericDAO;
	}

	/**
	 * get list of health care provider type by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderHealthcareprovidertype> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderHealthcareprovidertypeDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
