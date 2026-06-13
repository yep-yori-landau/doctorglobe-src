
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.CorporatecompanyInsuranceDAO;
import com.dg.data.model.db.CorporatecompanyInsurance;
import com.dg.data.service.CorporatecompanyInsuranceService;

/**
 * @author DoctorGlobe CorporatecompanyInsuranceService Implementation
 */

@Service("corporatecompanyInsuranceService")
public class CorporatecompanyInsuranceServiceImpl
		extends GenericServiceImpl<CorporatecompanyInsurance>
		implements CorporatecompanyInsuranceService {

	@Autowired
	public CorporatecompanyInsuranceServiceImpl(
			CorporatecompanyInsuranceDAO genericDAO) {
		super(genericDAO);
	}
}
