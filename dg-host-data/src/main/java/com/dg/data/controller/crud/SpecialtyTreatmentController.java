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

import com.dg.data.model.db.SpecialtyTreatment;
import com.dg.data.service.SpecialtyTreatmentService;
import com.dg.data.service.TreatmentService;
import com.dg.data.service.SpecialtyService;

/**
 * Handles all crud operations for SpecialtyTreatment table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/specialty-treatment")
public class SpecialtyTreatmentController
		extends AbstractCrudController<SpecialtyTreatment> {

	private static final Logger logger = LoggerFactory
			.getLogger(SpecialtyTreatmentController.class);

	@Autowired
	public SpecialtyTreatmentService specialtytreatmentService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public SpecialtyService specialtyService;

	@Autowired
	public SpecialtyTreatmentController(
			SpecialtyTreatmentService specialtytreatmentService) {
		super.setGenericService(specialtytreatmentService);
	}

	/**
	 * 
	 * handle specialty-treatment edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			SpecialtyTreatment specialtyTreatment, Model model) {
		if (id != null) {
			model.addAttribute("specialtyTreatment",
					specialtytreatmentService.get(id));
		}
		model.addAttribute("treatmentList", treatmentService.getAll());
		model.addAttribute("specialtyList", specialtyService.getAll());

		return "specialty-treatment/edit";
	}

	/**
	 * 
	 * handle specialty-treatment edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid SpecialtyTreatment specialtyTreatment,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save specialty-treatment",
					bindingResult.getErrorCount());
			model.addAttribute("treatmentList", treatmentService.getAll());
			model.addAttribute("specialtyList", specialtyService.getAll());
			return "specialty-treatment/edit";
		}
		specialtytreatmentService.edit(specialtyTreatment);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/specialty-treatment/index";
	}

}