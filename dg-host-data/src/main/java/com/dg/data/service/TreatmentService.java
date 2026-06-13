/**
 * 
 */
package com.dg.data.service;

import java.util.List;
import com.dg.data.model.db.Treatment;
import com.dg.data.model.domain.TreatmentSearchModel;

/**
 * This is a TreatmentService service interface which includes the most
 * fundamental service operations for TreatmentService object It also extends
 * the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface TreatmentService extends GenericService<Treatment> {

	/**
	 * find By Name
	 * @param id
	 * @return treatment
	 */
	public List<Treatment> findByName(String name);

	/**
	 * find By Treatment
	 * @param id
	 * @return treatment
	 */
	public List<TreatmentSearchModel> findByTreatment(String name);

}
