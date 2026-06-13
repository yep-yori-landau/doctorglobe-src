package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Translations;
import com.dg.data.service.TranslationsService;

/**
 * Handles all crud operations for Translations table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/translations")
public class TranslationsController extends AbstractController<Translations> {

	@Autowired
	public TranslationsController(TranslationsService translationsService) {
		super.setGenericService(translationsService);
	}
}