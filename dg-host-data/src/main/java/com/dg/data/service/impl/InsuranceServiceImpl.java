
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.InsuranceDAO;
import com.dg.data.model.db.Insurance;
import com.dg.data.service.InsuranceService;

/**
 * @author DoctorGlobe InsuranceService CountryService
 */

@Service("insuranceService")
public class InsuranceServiceImpl extends GenericServiceImpl<Insurance>
		implements InsuranceService {

	@Autowired
	public InsuranceServiceImpl(InsuranceDAO genericDAO) {
		super(genericDAO);
	}
}
