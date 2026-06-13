/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.City;
import com.dg.data.model.domain.CityStateCountryModel;

/**
 * This is a city DAO interface which includes the most fundamental DAO
 * operations (findByCountry, etc) for any city object It also extends the
 * generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface CityDAO extends GenericDAO<City> {

	/**
	 * Find the list of cities based on country id
	 * @param country the unique id of country
	 * @return cities list
	 */
	public List<City> findByCountry(Integer country);

	/**
	 * Find the list of cities based on state id
	 * @param state the unique id of state
	 * @return cities list
	 */
	public List<City> findByState(Integer state);

	/**
	 * Find the CityStateCountryModel based on city id
	 * @param id the unique id of city
	 * @return CityStateCountryModel
	 */
	public CityStateCountryModel findStateCountryById(BigInteger id);
}
