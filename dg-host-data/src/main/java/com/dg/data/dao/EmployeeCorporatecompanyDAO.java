package com.dg.data.dao;

import com.dg.data.model.db.EmployeeCorporatecompany;
import com.dg.data.model.domain.EmployeeCorporatecompanyDetail;

/**
 * This is a EmployeeCorporatecompany DAO interface which includes the most
 * fundamental DAO operations (findByPatient, etc) for any
 * EmployeeCorporatecompany object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */
public interface EmployeeCorporatecompanyDAO
		extends GenericDAO<EmployeeCorporatecompany> {

	/**
	 * Find the EmployeeCorporatecompanyDetail based on patient id
	 * @param patient the unique id of patient
	 * @return EmployeeCorporatecompanyDetail
	 */
	EmployeeCorporatecompanyDetail findByPatient(Integer patient);

}