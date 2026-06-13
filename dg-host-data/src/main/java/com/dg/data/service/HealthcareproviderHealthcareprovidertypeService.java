/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderHealthcareprovidertype;

/**
 * This is a HealthcareproviderHealthcareprovidertypeService service interface
 * which includes the most fundamental service operations for
 * HealthcareproviderHealthcareprovidertypeService object It also extends the
 * generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderHealthcareprovidertypeService
		extends GenericService<HealthcareproviderHealthcareprovidertype> {
	/**
	 * get list of health care provider type by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderHealthcareprovidertype> findByHealthcareprovider(
			BigInteger healthcareprovider);

}
