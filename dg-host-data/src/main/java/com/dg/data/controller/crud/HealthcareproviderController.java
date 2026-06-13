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

import com.dg.data.model.db.Healthcareprovider;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.CityService;
import com.dg.data.service.CurrencyService;
import com.dg.data.service.ChainService;

/**
 * Handles all crud operations for Healthcareprovider table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider")
public class HealthcareproviderController
		extends AbstractController<Healthcareprovider> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderController.class);

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public CityService cityService;

	@Autowired
	public CurrencyService currencyService;

	@Autowired
	public ChainService chainService;

	@Autowired
	public HealthcareproviderController(
			HealthcareproviderService healthcareproviderService) {
		super.setGenericService(healthcareproviderService);
	}

	/**
	 * 
	 * handle healthcareprovider edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Healthcareprovider healthcareprovider, Model model) {
		if (id != null) {
			model.addAttribute("healthcareprovider",
					healthcareproviderService.get(id));
		}
		model.addAttribute("cityList", cityService.getAll());
		model.addAttribute("chainList", chainService.getAll());
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		model.addAttribute("currencyList", currencyService.getAllCurrency());

		return "healthcareprovider/edit";
	}

	/**
	 * 
	 * handle healthcareprovider edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Healthcareprovider healthcareprovider,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save healthcareprovider",
					bindingResult.getErrorCount());
			model.addAttribute("cityList", cityService.getAll());
			model.addAttribute("chainList", chainService.getAll());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			model.addAttribute("currencyList",
					currencyService.getAllCurrency());
			return "healthcareprovider/edit";
		}
		healthcareproviderService.edit(healthcareprovider);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider/index";
	}

}