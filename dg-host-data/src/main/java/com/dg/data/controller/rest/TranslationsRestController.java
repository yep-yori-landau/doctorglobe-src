
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Translations;
import com.dg.data.service.TranslationsService;

/**
 * @author doctorGlobe Handles all interactions with the Translations table.
 */
@Controller
@RequestMapping(value = "/rest/translations")
public class TranslationsRestController
		extends AbstractRestController<Translations> {
	@Autowired
	public TranslationsRestController(TranslationsService translationsService) {
		super.setGenericService(translationsService);
	}
}