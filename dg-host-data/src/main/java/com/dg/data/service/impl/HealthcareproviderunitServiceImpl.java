
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderunitDAO;
import com.dg.data.model.db.Healthcareproviderunit;
import com.dg.data.service.HealthcareproviderunitService;

/**
 * @author DoctorGlobe HealthcareproviderunitService CountryService
 */

@Service("healthcareproviderunitService")
public class HealthcareproviderunitServiceImpl
		extends GenericServiceImpl<Healthcareproviderunit>
		implements HealthcareproviderunitService {

	@Autowired
	public HealthcareproviderunitServiceImpl(
			HealthcareproviderunitDAO genericDAO) {
		super(genericDAO);
	}

}