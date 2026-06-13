
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderUnitFeatureDAO;
import com.dg.data.model.db.HealthcareproviderUnitFeature;
import com.dg.data.service.HealthcareproviderUnitFeatureService;

/**
 * @author DoctorGlobe HealthcareproviderUnitFeatureService CountryService
 */

@Service("healthcareproviderUnitFeatureService")
public class HealthcareproviderUnitFeatureServiceImpl
		extends GenericServiceImpl<HealthcareproviderUnitFeature>
		implements HealthcareproviderUnitFeatureService {

	private HealthcareproviderUnitFeatureDAO healthcareproviderUnitFeatureDAO;

	@Autowired
	public HealthcareproviderUnitFeatureServiceImpl(
			HealthcareproviderUnitFeatureDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderUnitFeatureDAO = (HealthcareproviderUnitFeatureDAO) genericDAO;
	}

	/**
	 * find By Healthcare provider
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderUnitFeature> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderUnitFeatureDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
