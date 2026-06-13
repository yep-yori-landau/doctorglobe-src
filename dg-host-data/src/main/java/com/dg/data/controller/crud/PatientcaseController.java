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

import com.dg.data.model.db.Patientcase;
import com.dg.data.service.PatientcaseService;
import com.dg.data.service.PatientService;
import com.dg.data.service.TreatmentService;

/**
 * Handles all crud operations for Patientcase table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientcase")
public class PatientcaseController extends AbstractController<Patientcase> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientcaseController.class);

	@Autowired
	public PatientcaseService patientcaseService;

	@Autowired
	public PatientService patientService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public PatientcaseController(PatientcaseService patientcaseService) {
		super.setGenericService(patientcaseService);
	}

	/**
	 * 
	 * handle patientcase edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patientcase patientcase, Model model) {
		if (id != null) {
			model.addAttribute("patientcase", patientcaseService.get(id));
		}
		model.addAttribute("patientList", patientService.getAll());
		model.addAttribute("treatmentList", treatmentService.getAll());
		return "patientcase/edit";
	}

	/**
	 * 
	 * handle patientcase edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patientcase patientcase,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save patientcase",
					bindingResult.getErrorCount());
			model.addAttribute("patientList", patientService.getAll());
			model.addAttribute("treatmentList", treatmentService.getAll());
			return "patientcase/edit";
		}
		patientcaseService.edit(patientcase);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientcase/index";
	}
}