/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderInsurance;

/**
 * This is a HealthcareproviderInsuranceService service interface which includes
 * the most fundamental service operations for
 * HealthcareproviderInsuranceService object It also extends the generic service
 * CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderInsuranceService
		extends GenericService<HealthcareproviderInsurance> {
	/**
	 * get list of health care provider Insurance by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderInsurance> findByHealthcareprovider(
			BigInteger healthcareprovider);

	/**
	 * delete health care provider by health care provider id
	 * @param healthcareprovider
	 * @return
	 */
	public Boolean deleteByHealthcareprovider(BigInteger healthcareprovider);
}
