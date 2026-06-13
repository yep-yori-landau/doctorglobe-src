/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderAccreditation;

/**
 * This is a HealthcareproviderAccreditationService service interface which
 * includes the most fundamental service operations for
 * HealthcareproviderAccreditationService object It also extends the generic
 * service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderAccreditationService
		extends GenericService<HealthcareproviderAccreditation> {

	/**
	 * get list of health care provider Accreditation by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderAccreditation> findByHealthcareprovider(
			BigInteger healthcareprovider);

}
