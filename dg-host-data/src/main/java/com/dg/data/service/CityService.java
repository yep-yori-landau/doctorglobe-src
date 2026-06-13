/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.City;
import com.dg.data.model.domain.CityStateCountryModel;

/**
 * This is a CityService service interface which includes the most fundamental
 * service operations for CityService object It also extends the generic service
 * CRUD methods
 *
 * @author DoctorGlobe
 */
public interface CityService extends GenericService<City> {

	/**
	 * get city list by country id
	 * @param country
	 * @return the list of cities
	 * 
	 */
	public List<City> findByCountry(Integer country);

	/**
	 * get city list by state id
	 * @param state
	 * @return get city by state
	 */
	public List<City> findByState(Integer state);

	/**
	 * get state and country by id
	 * @param id
	 * @return get city , state,country by country
	 */
	public CityStateCountryModel findStateCountryById(BigInteger id);

}
