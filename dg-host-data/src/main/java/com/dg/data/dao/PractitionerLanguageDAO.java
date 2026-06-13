/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.PractitionerLanguage;

/**
 * This is a PractitionerLanguage DAO interface which includes the most
 * fundamental DAO operations (findByPractitioner, etc) for PractitionerLanguage
 * object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PractitionerLanguageDAO
		extends GenericDAO<PractitionerLanguage> {

	/**
	 * Find the list of PractitionerLanguage object based on practitioner id
	 * @param practitioner the unique id of practitioner
	 * @return the list of PractitionerLanguage object or null if it cannot be
	 * found
	 */
	public List<PractitionerLanguage> findByPractitioner(
			BigInteger practitioner);
}
