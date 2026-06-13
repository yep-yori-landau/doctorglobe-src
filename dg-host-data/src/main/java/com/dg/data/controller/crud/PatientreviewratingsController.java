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

import com.dg.data.model.db.Patientreviewratings;
import com.dg.data.service.PatientreviewratingsService;
import com.dg.data.service.PatientreviewService;

/**
 * Handles all crud operations for Patientreviewratings table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientreviewratings")
public class PatientreviewratingsController
		extends AbstractCrudController<Patientreviewratings> {
	private static final Logger logger = LoggerFactory
			.getLogger(PatientreviewratingsController.class);

	@Autowired
	public PatientreviewratingsService patientreviewratingsService;

	@Autowired
	public PatientreviewService patientreviewService;

	@Autowired
	public PatientreviewratingsController(
			PatientreviewratingsService patientreviewratingsService) {
		super.setGenericService(patientreviewratingsService);
	}

	/**
	 * 
	 * handle patientreviewratings edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patientreviewratings patientreviewratings, Model model) {
		if (id != null) {
			model.addAttribute("patientreviewratings",
					patientreviewratingsService.get(id));
		}
		model.addAttribute("patientreviewList", patientreviewService.getAll());
		return "patientreviewratings/edit";
	}

	/**
	 * 
	 * handle patientreviewratings edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patientreviewratings patientreviewratings,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save patientreviewratings",
					bindingResult.getErrorCount());
			model.addAttribute("patientreviewList",
					patientreviewService.getAll());
			return "patientreviewratings/edit";
		}
		patientreviewratingsService.edit(patientreviewratings);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientreviewratings/index";
	}
}