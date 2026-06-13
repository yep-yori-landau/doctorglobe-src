
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.QuestionnaireDAO;
import com.dg.data.model.db.Questionnaire;
import com.dg.data.service.QuestionnaireService;

/**
 * @author DoctorGlobe QuestionnaireService CountryService
 */

@Service("questionnaireService")
public class QuestionnaireServiceImpl extends GenericServiceImpl<Questionnaire>
		implements QuestionnaireService {

	@Autowired
	public QuestionnaireServiceImpl(QuestionnaireDAO genericDAO) {
		super(genericDAO);
	}

}
