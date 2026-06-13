package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderPractitioner;

/**
 * This is a HealthcareproviderPractitionerService service interface which
 * includes the most fundamental service operations for
 * HealthcareproviderPractitionerService object It also extends the generic
 * service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderPractitionerService
		extends GenericService<HealthcareproviderPractitioner> {
	/**
	 * get list of health care provider Practitioner by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderPractitioner> findByHealthcareprovider(
			BigInteger healthcareprovider);

}