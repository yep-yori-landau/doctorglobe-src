/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.SpecialtyTreatment;

/**
 * This is a SpecialtyTreatment DAO interface which includes the most
 * fundamental DAO operations (findBySpecialty, etc) for SpecialtyTreatment
 * object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface SpecialtyTreatmentDAO extends GenericDAO<SpecialtyTreatment> {

	/**
	 * Find the list of SpecialtyTreatment object based on specialty id
	 * @param specialty the unique id of specialty
	 * @return the list of SpecialtyTreatment object or null if it cannot be
	 * found
	 */
	public List<SpecialtyTreatment> findBySpecialty(BigInteger specialty);
}
