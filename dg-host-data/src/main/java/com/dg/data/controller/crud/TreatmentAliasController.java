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

import com.dg.data.model.db.TreatmentAlias;
import com.dg.data.service.TreatmentAliasService;
import com.dg.data.service.TreatmentService;

/**
 * Handles all crud operations for TreatmentAlias table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/treatment-alias")
public class TreatmentAliasController
		extends AbstractCrudController<TreatmentAlias> {

	private static final Logger logger = LoggerFactory
			.getLogger(TreatmentAliasController.class);

	@Autowired
	public TreatmentAliasService treatmentaliasService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public TreatmentAliasController(
			TreatmentAliasService treatmentaliasService) {
		super.setGenericService(treatmentaliasService);
	}

	/**
	 * 
	 * handle treatment-alias edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			TreatmentAlias treatmentAlias, Model model) {
		if (id != null) {
			model.addAttribute("treatmentAlias", treatmentaliasService.get(id));
		}
		model.addAttribute("treatmentList", treatmentService.getAll());
		return "treatment-alias/edit";
	}

	/**
	 * 
	 * handle treatment-alias edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid TreatmentAlias treatmentAlias,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save treatment-alias",
					bindingResult.getErrorCount());
			model.addAttribute("treatmentList", treatmentService.getAll());
			return "treatment-alias/edit";
		}
		treatmentaliasService.edit(treatmentAlias);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/treatment-alias/index";
	}

}