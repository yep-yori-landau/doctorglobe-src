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

import com.dg.data.model.db.Patientcasemessages;
import com.dg.data.service.PatientcasemessagesService;
import com.dg.data.service.PatientcaseService;

/**
 * Handles all crud operations for Patientcasemessages table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientcasemessages")
public class PatientcasemessagesController
		extends AbstractCrudController<Patientcasemessages> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientcasemessagesController.class);

	@Autowired
	public PatientcasemessagesService patientcasemessagesService;

	@Autowired
	public PatientcaseService patientcaseService;

	@Autowired
	public PatientcasemessagesController(
			PatientcasemessagesService patientcasemessagesService) {
		super.setGenericService(patientcasemessagesService);
	}

	/**
	 * 
	 * handle patientcasemessages edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patientcasemessages patientcasemessages, Model model) {
		if (id != null) {
			model.addAttribute("patientcasemessages",
					patientcasemessagesService.get(id));
		}
		model.addAttribute("patientcaseList", patientcaseService.getAll());
		return "patientcasemessages/edit";
	}

	/**
	 * 
	 * handle patientcasemessages edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patientcasemessages patientcasemessages,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save patientcasemessages",
					bindingResult.getErrorCount());
			model.addAttribute("patientcaseList", patientcaseService.getAll());
			return "patientcasemessages/edit";
		}
		patientcasemessagesService.edit(patientcasemessages);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientcasemessages/index";
	}

}