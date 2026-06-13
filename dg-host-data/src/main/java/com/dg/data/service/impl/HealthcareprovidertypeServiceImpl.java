
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareprovidertypeDAO;
import com.dg.data.model.db.Healthcareprovidertype;
import com.dg.data.service.HealthcareprovidertypeService;

/**
 * @author DoctorGlobe HealthcareprovidertypeService CountryService
 */

@Service("healthcareprovidertypeService")
public class HealthcareprovidertypeServiceImpl
		extends GenericServiceImpl<Healthcareprovidertype>
		implements HealthcareprovidertypeService {

	@Autowired
	public HealthcareprovidertypeServiceImpl(
			HealthcareprovidertypeDAO genericDAO) {
		super(genericDAO);
	}

}