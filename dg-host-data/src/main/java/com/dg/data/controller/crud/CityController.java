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

import com.dg.data.model.db.City;
import com.dg.data.service.CityService;
import com.dg.data.service.CountryService;
import com.dg.data.service.StateService;

/**
 * Handles all crud operations for City table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/city")
public class CityController extends AbstractController<City> {

	private static final Logger logger = LoggerFactory
			.getLogger(CityController.class);

	@Autowired
	public CityService cityService;

	@Autowired
	public CountryService countryService;

	@Autowired
	public StateService stateService;

	@Autowired
	public CityController(CityService cityService) {
		super.setGenericService(cityService);
	}

	/**
	 * 
	 * handle city edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			City city, Model model) {
		if (id != null) {
			model.addAttribute("city", cityService.get(id));
		}
		model.addAttribute("countryList", countryService.getAll());
		model.addAttribute("stateList", stateService.getAll());

		return "city/edit";
	}

	/**
	 * 
	 * handle city edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid City city, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save city",
					bindingResult.getErrorCount());
			model.addAttribute("countryList", countryService.getAll());
			model.addAttribute("stateList", stateService.getAll());
			return "city/edit";
		}
		cityService.edit(city);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/city/index";
	}

}