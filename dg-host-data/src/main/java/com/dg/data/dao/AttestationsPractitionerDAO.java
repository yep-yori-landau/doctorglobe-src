/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.AttestationsPractitioner;

/**
 * This is a AttestationsPractitioner DAO interface which includes the most
 * fundamental DAO operations (findByPractitioner, etc) for any
 * AttestationsPractitioner object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface AttestationsPractitionerDAO
		extends GenericDAO<AttestationsPractitioner> {

	/**
	 * Find the list of AttestationsPractitioner objects based on practitioner
	 * id
	 * @param practitioner the unique id of the practitioner
	 * @return AttestationsPractitioner list
	 */
	public List<AttestationsPractitioner> findByPractitioner(
			BigInteger practitioner);
}
