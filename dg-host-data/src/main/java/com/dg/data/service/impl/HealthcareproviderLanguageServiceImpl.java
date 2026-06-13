
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderLanguageDAO;
import com.dg.data.model.db.HealthcareproviderLanguage;
import com.dg.data.service.HealthcareproviderLanguageService;

/**
 * @author DoctorGlobe HealthcareproviderLanguageService CountryService
 */

@Service("healthcareproviderLanguageService")
public class HealthcareproviderLanguageServiceImpl
		extends GenericServiceImpl<HealthcareproviderLanguage>
		implements HealthcareproviderLanguageService {

	private HealthcareproviderLanguageDAO healthcareproviderLanguageDAO;

	@Autowired
	public HealthcareproviderLanguageServiceImpl(
			HealthcareproviderLanguageDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderLanguageDAO = (HealthcareproviderLanguageDAO) genericDAO;
	}

	/**
	 * get list of health care provider Language by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderLanguage> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderLanguageDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
