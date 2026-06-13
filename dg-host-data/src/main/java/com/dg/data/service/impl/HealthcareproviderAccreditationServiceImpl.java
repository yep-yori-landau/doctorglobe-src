
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.HealthcareproviderAccreditationDAO;
import com.dg.data.model.db.HealthcareproviderAccreditation;
import com.dg.data.service.HealthcareproviderAccreditationService;

/**
 * @author DoctorGlobe HealthcareproviderAccreditationService CountryService
 */

@Service("healthcareproviderAccreditationService")
public class HealthcareproviderAccreditationServiceImpl
		extends GenericServiceImpl<HealthcareproviderAccreditation>
		implements HealthcareproviderAccreditationService {

	private HealthcareproviderAccreditationDAO healthcareproviderAccreditationDAO;

	@Autowired
	public HealthcareproviderAccreditationServiceImpl(
			HealthcareproviderAccreditationDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderAccreditationDAO = (HealthcareproviderAccreditationDAO) genericDAO;
	}

	/**
	 * get list of health care provider Accreditation by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderAccreditation> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderAccreditationDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
