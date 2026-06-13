
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderInsuranceDAO;
import com.dg.data.model.db.HealthcareproviderInsurance;
import com.dg.data.service.HealthcareproviderInsuranceService;

/**
 * @author DoctorGlobe HealthcareproviderInsuranceService CountryService
 */

@Service("healthcareproviderInsuranceService")
public class HealthcareproviderInsuranceServiceImpl
		extends GenericServiceImpl<HealthcareproviderInsurance>
		implements HealthcareproviderInsuranceService {

	private HealthcareproviderInsuranceDAO healthcareproviderInsuranceDAO;

	@Autowired
	public HealthcareproviderInsuranceServiceImpl(
			HealthcareproviderInsuranceDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderInsuranceDAO = (HealthcareproviderInsuranceDAO) genericDAO;
	}

	/**
	 * get list of health care provider Insurance by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderInsurance> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderInsuranceDAO
				.findByHealthcareprovider(healthcareprovider);
	}

	/**
	 * delete health care provider by health care provider id
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public Boolean deleteByHealthcareprovider(BigInteger healthcareprovider) {
		return this.healthcareproviderInsuranceDAO
				.deleteByHealthcareprovider(healthcareprovider);
	}

}
