/**
 * 
 */
package com.dg.data.dao;

import java.util.List;

import com.dg.data.model.db.State;

/**
 * This is a State DAO interface which includes the most fundamental DAO
 * operations (findByCountry, etc) for State object It also extends the generic
 * DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface StateDAO extends GenericDAO<State> {

	/**
	 * Find the list of State object based on country id
	 * @param country the unique id of country
	 * @return the list of State object or null if it cannot be found
	 */
	public List<State> findByCountry(Integer country);
}
