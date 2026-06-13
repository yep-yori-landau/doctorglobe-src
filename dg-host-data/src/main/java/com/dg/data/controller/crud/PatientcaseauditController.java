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

import com.dg.data.model.db.Patientcaseaudit;
import com.dg.data.service.PatientcaseauditService;
import com.dg.data.service.PatientcaseService;

/**
 * Handles all crud operations for Patientcaseaudit table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientcaseaudit")
public class PatientcaseauditController
		extends AbstractController<Patientcaseaudit> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientcaseauditController.class);

	@Autowired
	public PatientcaseauditService patientcaseauditService;

	@Autowired
	public PatientcaseService patientcaseService;

	@Autowired
	public PatientcaseauditController(
			PatientcaseauditService patientcaseauditService) {
		super.setGenericService(patientcaseauditService);
	}

	/**
	 * 
	 * handle patientcaseaudit edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patientcaseaudit patientcaseaudit, Model model) {
		if (id != null) {
			model.addAttribute("patientcaseaudit",
					patientcaseauditService.get(id));
		}
		model.addAttribute("patientcaseList", patientcaseService.getAll());
		return "patientcaseaudit/edit";
	}

	/**
	 * 
	 * handle patientcaseaudit edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patientcaseaudit patientcaseaudit,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save patientcaseaudit",
					bindingResult.getErrorCount());
			model.addAttribute("patientcaseList", patientcaseService.getAll());

			return "patientcaseaudit/edit";
		}
		patientcaseauditService.edit(patientcaseaudit);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientcaseaudit/index";
	}
}