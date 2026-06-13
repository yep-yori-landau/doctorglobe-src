
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.TranslationsDAO;
import com.dg.data.model.db.Translations;
import com.dg.data.service.TranslationsService;

/**
 * @author DoctorGlobe TranslationsService CountryService
 */

@Service("translationsService")
public class TranslationsServiceImpl extends GenericServiceImpl<Translations>
		implements TranslationsService {

	@Autowired
	public TranslationsServiceImpl(TranslationsDAO genericDAO) {
		super(genericDAO);
	}
}
