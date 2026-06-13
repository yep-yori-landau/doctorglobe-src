
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.RatingcompaniesDAO;
import com.dg.data.model.db.Ratingcompanies;
import com.dg.data.service.RatingcompaniesService;

/**
 * @author DoctorGlobe RatingcompaniesService CountryService
 */

@Service("ratingcompaniesService")
public class RatingcompaniesServiceImpl extends
		GenericServiceImpl<Ratingcompanies>implements RatingcompaniesService {

	@Autowired
	public RatingcompaniesServiceImpl(RatingcompaniesDAO genericDAO) {
		super(genericDAO);
	}
}