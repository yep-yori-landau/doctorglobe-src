
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.CityDAO;
import com.dg.data.model.db.City;
import com.dg.data.model.domain.CityStateCountryModel;
import com.dg.data.service.CityService;

/**
 * @author DoctorGlobe CityService Implementation
 */

@Service("cityService")
public class CityServiceImpl extends GenericServiceImpl<City>
		implements CityService {

	private CityDAO cityDAO;

	@Autowired
	public CityServiceImpl(CityDAO genericDAO) {
		super(genericDAO);
		this.cityDAO = (CityDAO) genericDAO;
	}

	/**
	 * get city list by country id
	 * @param country the unique id of country
	 * @return the list of cities
	 * 
	 */
	@Override
	public List<City> findByCountry(Integer country) {
		return this.cityDAO.findByCountry(country);
	}

	/**
	 * get city list by state id
	 * @param state
	 * @return get city by state
	 */
	@Override
	public List<City> findByState(Integer state) {
		return this.cityDAO.findByState(state);
	}

	/**
	 * get state and country by id
	 * @param id the unique id of country
	 * @return CityStateCountryModel
	 */
	@Override
	public CityStateCountryModel findStateCountryById(BigInteger id) {
		return this.cityDAO.findStateCountryById(id);
	}

	@Override
	public Integer delete(Integer id, BigInteger user, String user_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer edit(City t, BigInteger user, String user_type) {
		// TODO Auto-generated method stub
		return null;
	}
}
