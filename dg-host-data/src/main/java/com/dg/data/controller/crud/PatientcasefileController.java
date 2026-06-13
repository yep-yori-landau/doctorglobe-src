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

import com.dg.data.model.db.Patientcasefile;
import com.dg.data.service.PatientcasefileService;
import com.dg.data.service.PatientcaseService;

/**
 * Handles all crud operations for Patientcasefile table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientcasefile")
public class PatientcasefileController
		extends AbstractCrudController<Patientcasefile> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientcasefileController.class);

	@Autowired
	public PatientcasefileService patientcasefileService;

	@Autowired
	public PatientcaseService patientcaseService;

	@Autowired
	public PatientcasefileController(
			PatientcasefileService patientcasefileService) {
		super.setGenericService(patientcasefileService);
	}

	/**
	 * 
	 * handle patientcasefile edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patientcasefile patientcasefile, Model model) {
		if (id != null) {
			model.addAttribute("patientcasefile",
					patientcasefileService.get(id));
		}
		model.addAttribute("patientcaseList", patientcaseService.getAll());
		return "patientcasefile/edit";
	}

	/**
	 * 
	 * handle patientcasefile edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patientcasefile patientcasefile,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save patientcasefile",
					bindingResult.getErrorCount());
			model.addAttribute("patientcaseList", patientcaseService.getAll());
			return "patientcasefile/edit";
		}
		patientcasefileService.edit(patientcasefile);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientcasefile/index";
	}

}