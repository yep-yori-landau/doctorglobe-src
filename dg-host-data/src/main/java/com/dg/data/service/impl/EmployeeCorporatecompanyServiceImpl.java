
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.EmployeeCorporatecompanyDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.EmployeeCorporatecompany;
import com.dg.data.model.domain.EmployeeCorporatecompanyDetail;
import com.dg.data.service.EmployeeCorporatecompanyService;

/**
 * @author DoctorGlobe EmployeeCorporatecompanyService CountryService
 */

@Service("employeeCorporatecompanyService")
public class EmployeeCorporatecompanyServiceImpl
		extends GenericServiceImpl<EmployeeCorporatecompany>
		implements EmployeeCorporatecompanyService {

	private EmployeeCorporatecompanyDAO employeeCorporatecompanyDAO;

	@Autowired
	public EmployeeCorporatecompanyServiceImpl(
			EmployeeCorporatecompanyDAO genericDAO) {
		super(genericDAO);
		this.employeeCorporatecompanyDAO = (EmployeeCorporatecompanyDAO) genericDAO;
	}

	/**
	 * get employee corporate company details by patient id
	 * @param patient
	 * @return EmployeeCorporatecompanyDetail Model
	 */
	@Override
	public EmployeeCorporatecompanyDetail findByPaytient(Integer patient) {
		return this.employeeCorporatecompanyDAO.findByPatient(patient);
	}

}