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

import com.dg.data.model.db.Treatmentdays;
import com.dg.data.service.TreatmentdaysService;
import com.dg.data.service.TreatmentService;
import com.dg.data.service.CountryService;

/**
 * Handles all crud operations for Treatmentdays table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/treatmentdays")
public class TreatmentdaysController
		extends AbstractCrudController<Treatmentdays> {

	private static final Logger logger = LoggerFactory
			.getLogger(TreatmentdaysController.class);

	@Autowired
	public TreatmentdaysService treatmentdaysService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public CountryService countryService;

	@Autowired
	public TreatmentdaysController(TreatmentdaysService treatmentdaysService) {
		super.setGenericService(treatmentdaysService);
	}

	/**
	 * 
	 * handle Treatmentdays edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Treatmentdays treatmentdays, Model model) {
		if (id != null) {
			model.addAttribute("treatmentdays", treatmentdaysService.get(id));
		}
		model.addAttribute("countryList", countryService.getAll());
		model.addAttribute("treatmentList", treatmentService.getAll());
		return "treatmentdays/edit";
	}

	/**
	 * 
	 * handle Treatmentdays edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Treatmentdays treatmentdays,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save treatment-days",
					bindingResult.getErrorCount());
			model.addAttribute("countryList", countryService.getAll());
			model.addAttribute("treatmentList", treatmentService.getAll());
			return "treatmentdays/edit";
		}
		treatmentdaysService.edit(treatmentdays);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/treatmentdays/index";
	}
}