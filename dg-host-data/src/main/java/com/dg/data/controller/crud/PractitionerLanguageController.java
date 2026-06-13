package com.dg.data.controller.crud;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.data.model.db.PractitionerLanguage;
import com.dg.data.service.PractitionerLanguageService;
import com.dg.data.service.PractitionerService;

/**
 * Handles all crud operations for PractitionerLanguage table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/practitioner-language")
public class PractitionerLanguageController
		extends AbstractCrudController<PractitionerLanguage> {

	private static final Logger logger = LoggerFactory
			.getLogger(PractitionerLanguageController.class);

	@Autowired
	public PractitionerLanguageService practitionerlanguageService;

	@Autowired
	public PractitionerService practitionerService;

	@Autowired
	public PractitionerLanguageController(
			PractitionerLanguageService practitionerlanguageService) {
		super.setGenericService(practitionerlanguageService);
	}

	/**
	 * 
	 * handle practitioner-language edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			PractitionerLanguage practitionerLanguage, Model model) {
		if (id != null) {
			model.addAttribute("practitionerLanguage",
					practitionerlanguageService.get(id));
		}
		model.addAttribute("practitionerList", practitionerService.getAll());

		return "practitioner-language/edit";
	}

	/**
	 * 
	 * handle practitioner-language edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid PractitionerLanguage practitionerLanguage,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save practitioner-language",
					bindingResult.getErrorCount());
			model.addAttribute("practitionerList",
					practitionerService.getAll());
			return "practitioner-language/edit";
		}
		practitionerlanguageService.edit(practitionerLanguage);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/practitioner-language/index";
	}

}