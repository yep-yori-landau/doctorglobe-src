
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderPractitionerDAO;
import com.dg.data.model.db.HealthcareproviderPractitioner;
import com.dg.data.service.HealthcareproviderPractitionerService;

/**
 * @author DoctorGlobe HealthcareproviderPractitionerService CountryService
 */

@Service("healthcareproviderPractitionerService")
public class HealthcareproviderPractitionerServiceImpl
		extends GenericServiceImpl<HealthcareproviderPractitioner>
		implements HealthcareproviderPractitionerService {

	private HealthcareproviderPractitionerDAO healthcareproviderPractitionerDAO;

	@Autowired
	public HealthcareproviderPractitionerServiceImpl(
			HealthcareproviderPractitionerDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderPractitionerDAO = (HealthcareproviderPractitionerDAO) genericDAO;
	}

	/**
	 * get list of health care provider Practitioner by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderPractitioner> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderPractitionerDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
