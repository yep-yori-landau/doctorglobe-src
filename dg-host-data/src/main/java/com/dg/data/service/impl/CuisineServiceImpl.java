
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.CuisineDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.Cuisine;
import com.dg.data.service.CuisineService;

/**
 * @author DoctorGlobe CuisineService CountryService
 */

@Service("cuisineService")
public class CuisineServiceImpl extends GenericServiceImpl<Cuisine>
		implements CuisineService {

	@Autowired
	public CuisineServiceImpl(CuisineDAO genericDAO) {
		super(genericDAO);
	}
}
