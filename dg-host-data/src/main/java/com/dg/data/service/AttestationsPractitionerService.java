/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.AttestationsPractitioner;

/**
 * This is a AttestationsPractitionerService service interface which includes
 * the most fundamental service operations for AttestationsPractitionerService
 * object It also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface AttestationsPractitionerService
		extends GenericService<AttestationsPractitioner> {
	/**
	 * find By Practitioner
	 * @param practitioner
	 * @return
	 */
	public List<AttestationsPractitioner> findByPractitioner(
			BigInteger practitioner);

}
