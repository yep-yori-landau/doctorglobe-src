package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Questionnaire;
import com.dg.data.service.QuestionnaireService;

/**
 * Handles all crud operations for Questionnaire table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/questionnaire")
public class QuestionnaireController extends AbstractController<Questionnaire> {
	@Autowired
	public QuestionnaireController(QuestionnaireService questionnaireService) {
		super.setGenericService(questionnaireService);
	}
}