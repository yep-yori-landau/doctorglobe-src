
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.CountryDAO;
import com.dg.data.model.db.Country;
import com.dg.data.service.CountryService;

/**
 * @author DoctorGlobe CorporatecompanyService CountryService
 */

@Service("countryService")
public class CountryServiceImpl extends GenericServiceImpl<Country>
		implements CountryService {

	@Autowired
	public CountryServiceImpl(CountryDAO genericDAO) {
		super(genericDAO);
	}

}
