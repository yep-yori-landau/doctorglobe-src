
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.FeatureDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.Feature;
import com.dg.data.service.FeatureService;

/**
 * @author DoctorGlobe FeatureService CountryService
 */

@Service("featureService")
public class FeatureServiceImpl extends GenericServiceImpl<Feature>
		implements FeatureService {

	@Autowired
	public FeatureServiceImpl(FeatureDAO genericDAO) {
		super(genericDAO);
	}

}
