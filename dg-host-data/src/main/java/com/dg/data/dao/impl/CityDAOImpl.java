/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.CityDAO;
import com.dg.data.model.db.City;
import com.dg.data.model.db.mapper.CityMapper;
import com.dg.data.model.db.mapper.CityStateCountryMapper;
import com.dg.data.model.domain.CityStateCountryModel;

/**
 * This class represent Implementation of CityDAO which can be extended to add
 * more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class CityDAOImpl extends GenericDAOImpl<City>implements CityDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(CityDAOImpl.class);

	/**
	 * Find the list of cities based on country id
	 * @param country the unique id of country
	 * @return cities list
	 */
	public List<City> findByCountry(Integer country) {
		List<City> cityList = null;
		if (country != null) {
			try {
				String query = "SELECT *FROM city WHERE city.country = ?";
				cityList = this.getJdbcTemplate().query(query,
						new Object[] { country }, new CityMapper());
			}
			catch (Exception ex) {
				logger.info("Exception found {}", ex.getMessage());
			}
		}
		return cityList;
	}

	/**
	 * Find the list of cities based on state id
	 * @param state the unique id of state
	 * @return cities list
	 */
	public List<City> findByState(Integer state) {
		List<City> cityList = null;
		if (state != null) {
			try {
				String query = "SELECT *FROM city WHERE city.state = ?";
				cityList = this.getJdbcTemplate().query(query,
						new Object[] { state }, new CityMapper());
			}
			catch (Exception ex) {
				logger.info("Exception found {}", ex.getMessage());
			}
		}
		return cityList;
	}

	/**
	 * Find the CityStateCountryModel based on city id
	 * @param id the unique id of city
	 * @return CityStateCountryModel
	 */
	public CityStateCountryModel findStateCountryById(BigInteger city) {
		CityStateCountryModel cityStateCountryModel = null;
		if (city != null) {
			try {
				String query = "SELECT c.id as id,c.name as city,s.name as state,co.name as country FROM city c left join state s on s.id = c.state left join country co on co.id = c.country WHERE c.id = ?";
				cityStateCountryModel = this.getJdbcTemplate().queryForObject(
						query, new Object[] { city },
						new CityStateCountryMapper());
			}
			catch (Exception ex) {
				logger.info("Exception found {}", ex.getMessage());
			}
		}
		return cityStateCountryModel;
	}
}
