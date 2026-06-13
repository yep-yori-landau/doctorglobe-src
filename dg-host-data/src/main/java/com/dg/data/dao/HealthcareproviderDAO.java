/**
 * 
 */
package com.dg.data.dao;

import java.util.List;

import com.dg.data.model.db.Healthcareprovider;
import com.dg.data.model.domain.HealthcareproviderDetail;

/**
 * This is a Healthcareprovider DAO interface which includes the most
 * fundamental DAO operations (findByTreatmentId, etc) for any
 * Healthcareprovider object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderDAO extends GenericDAO<Healthcareprovider> {

	/**
	 * Find the list of HealthcareproviderDetail object based on treatment id
	 * @param id the unique id of treatment
	 * @param currency unique currency code
	 * @return the list of HealthcareproviderDetail object or null if it cannot
	 * be found
	 */
	public List<HealthcareproviderDetail> findByTreatmentId(Integer id,
			String currency);
}
