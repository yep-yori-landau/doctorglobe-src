
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderSpecialtyDAO;
import com.dg.data.model.db.HealthcareproviderSpecialty;
import com.dg.data.service.HealthcareproviderSpecialtyService;

/**
 * @author DoctorGlobe HealthcareproviderSpecialtyService CountryService
 */

@Service("healthcareproviderSpecialtyService")
public class HealthcareproviderSpecialtyServiceImpl
		extends GenericServiceImpl<HealthcareproviderSpecialty>
		implements HealthcareproviderSpecialtyService {

	private HealthcareproviderSpecialtyDAO healthcareproviderSpecialtyDAO;

	@Autowired
	public HealthcareproviderSpecialtyServiceImpl(
			HealthcareproviderSpecialtyDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderSpecialtyDAO = (HealthcareproviderSpecialtyDAO) genericDAO;
	}

	/**
	 * find By Healthcare provider
	 * @param healthcareprovider
	 * @return list of helathcareprovider specialty
	 */
	@Override
	public List<HealthcareproviderSpecialty> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderSpecialtyDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
