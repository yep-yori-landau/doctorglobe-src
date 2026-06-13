/**
 * 
 */
package com.dg.data.service;

import java.util.List;
import com.dg.data.model.db.State;

/**
 * This is a StateService service interface which includes the most fundamental
 * service operations for StateService object It also extends the generic
 * service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface StateService extends GenericService<State> {
	/**
	 * find By Country
	 * @param country
	 * @return
	 */
	public List<State> findByCountry(Integer country);
}
