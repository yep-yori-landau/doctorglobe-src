package com.dg.data.service;

import com.dg.data.model.db.EmployeeCorporatecompany;
import com.dg.data.model.domain.EmployeeCorporatecompanyDetail;

/**
 * This is a EmployeeCorporatecompany service interface which includes the most
 * fundamental service operations for EmployeeCorporatecompany object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface EmployeeCorporatecompanyService
		extends GenericService<EmployeeCorporatecompany> {

	/**
	 * get employee corporate company details by patient id
	 * @param patient
	 * @return EmployeeCorporatecompanyDetail Model
	 */
	public EmployeeCorporatecompanyDetail findByPaytient(Integer patient);

}
