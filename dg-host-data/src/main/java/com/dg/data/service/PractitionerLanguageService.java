/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.PractitionerLanguage;

/**
 * This is a PractitionerLanguageService service interface which includes the
 * most fundamental service operations for PractitionerLanguageService object It
 * also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PractitionerLanguageService
		extends GenericService<PractitionerLanguage> {
	/**
	 * find By Practitioner
	 * @param practitioner
	 * @return
	 */
	public List<PractitionerLanguage> findByPractitioner(
			BigInteger practitioner);

}
