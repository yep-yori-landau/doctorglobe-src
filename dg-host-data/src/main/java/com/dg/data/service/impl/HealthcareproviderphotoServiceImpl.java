
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderphotoDAO;
import com.dg.data.model.db.Healthcareproviderphoto;
import com.dg.data.service.HealthcareproviderphotoService;

/**
 * @author DoctorGlobe HealthcareproviderphotoService CountryService
 */

@Service("healthcareproviderphotoService")
public class HealthcareproviderphotoServiceImpl
		extends GenericServiceImpl<Healthcareproviderphoto>
		implements HealthcareproviderphotoService {

	private HealthcareproviderphotoDAO healthcareproviderphotoDAO;

	@Autowired
	public HealthcareproviderphotoServiceImpl(
			HealthcareproviderphotoDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderphotoDAO = (HealthcareproviderphotoDAO) genericDAO;
	}

	/**
	 * find By Healthcarer povider
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<Healthcareproviderphoto> findByHealthcarerpovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderphotoDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
