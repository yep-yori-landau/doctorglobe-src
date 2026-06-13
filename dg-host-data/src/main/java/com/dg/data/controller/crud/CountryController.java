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

import com.dg.data.model.db.Country;
import com.dg.data.service.CountryService;
import com.dg.data.service.RegionService;

/**
 * Handles all crud operations for Country table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping("/country")
public class CountryController extends AbstractController<Country> {

	private static final Logger logger = LoggerFactory
			.getLogger(CountryController.class);

	public final CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		super.setGenericService(countryService);
		this.countryService = countryService;
	}

	@Autowired
	public RegionService regionService;

	/**
	 * 
	 * handle country edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Country country, Model model) {
		if (id != null) {
			model.addAttribute("country", countryService.get(id));
		}
		model.addAttribute("regionList", regionService.getAll());
		return "country/edit";
	}

	/**
	 * 
	 * handle country edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Country country, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save country",
					bindingResult.getErrorCount());
			model.addAttribute("regionList", regionService.getAll());
			return "country/edit";
		}
		countryService.edit(country);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/country/index";
	}

}