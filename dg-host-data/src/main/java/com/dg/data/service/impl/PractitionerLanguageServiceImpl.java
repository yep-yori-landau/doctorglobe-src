
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PractitionerLanguageDAO;
import com.dg.data.model.db.PractitionerLanguage;
import com.dg.data.service.PractitionerLanguageService;

/**
 * @author DoctorGlobe PractitionerLanguageService CountryService
 */

@Service("practitionerLanguageService")
public class PractitionerLanguageServiceImpl
		extends GenericServiceImpl<PractitionerLanguage>
		implements PractitionerLanguageService {

	private PractitionerLanguageDAO practitionerLanguageDAO;

	@Autowired
	public PractitionerLanguageServiceImpl(PractitionerLanguageDAO genericDAO) {
		super(genericDAO);
		this.practitionerLanguageDAO = (PractitionerLanguageDAO) genericDAO;
	}

	/**
	 * find By Practitioner
	 * @param practitioner
	 * @return
	 */
	@Override
	public List<PractitionerLanguage> findByPractitioner(
			BigInteger practitioner) {
		return this.practitionerLanguageDAO.findByPractitioner(practitioner);
	}

}
