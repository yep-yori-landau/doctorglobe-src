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

import com.dg.data.model.db.TreatmentPrice;
import com.dg.data.service.CityService;
import com.dg.data.service.CurrencyService;
import com.dg.data.service.TreatmentPriceService;
import com.dg.data.service.TreatmentService;

/**
 * Handles all crud operations for TreatmentPrice table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/treatment-price")
public class TreatmentPriceController
		extends AbstractCrudController<TreatmentPrice> {

	private static final Logger logger = LoggerFactory
			.getLogger(TreatmentPriceController.class);

	@Autowired
	public TreatmentPriceService treatmentPriceService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public CityService cityService;

	@Autowired
	public CurrencyService currencyService;

	@Autowired
	public TreatmentPriceController(
			TreatmentPriceService treatmentPriceService) {
		super.setGenericService(treatmentPriceService);
	}

	/**
	 * 
	 * handle TreatmentPrice edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			TreatmentPrice treatmentPrice, Model model) {
		if (id != null) {
			model.addAttribute("treatmentPrice", treatmentPriceService.get(id));
		}
		model.addAttribute("treatmentList", treatmentService.getAll());
		model.addAttribute("currencyList", currencyService.getAllCurrency());
		model.addAttribute("cityList", cityService.getAll());

		return "treatment-price/edit";
	}

	/**
	 * 
	 * handle TreatmentPrice edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid TreatmentPrice treatmentPrice,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save treatment-document",
					bindingResult.getErrorCount());
			model.addAttribute("treatmentList", treatmentService.getAll());
			model.addAttribute("cityList", cityService.getAll());
			model.addAttribute("currencyList",
					currencyService.getAllCurrency());
			return "treatment-price/edit";
		}
		treatmentPriceService.edit(treatmentPrice);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/treatment-price/index";
	}

}