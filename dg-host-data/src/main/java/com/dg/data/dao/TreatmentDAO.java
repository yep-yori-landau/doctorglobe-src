/**
 * 
 */
package com.dg.data.dao;

import java.util.List;

import com.dg.data.model.db.Treatment;
import com.dg.data.model.domain.TreatmentSearchModel;

/**
 * This is a Treatment DAO interface which includes the most fundamental DAO
 * operations (findByName, etc) for Treatment object It also extends the generic
 * DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface TreatmentDAO extends GenericDAO<Treatment> {

	/**
	 * Find the list of Treatment object based on treatment name
	 * @param name the name of treatment
	 * @return the list of Treatment object or null if it cannot be found
	 */
	public List<Treatment> findByName(String name);

	/**
	 * Find the list of TreatmentSearchModel object based on treatment name
	 * @param name the name of treatment
	 * @return the list of TreatmentSearchModel object or null if it cannot be
	 * found
	 */
	public List<TreatmentSearchModel> findByTreatmentName(String name);
}
