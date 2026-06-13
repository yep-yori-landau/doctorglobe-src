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

import com.dg.data.model.db.Corporatecompany;
import com.dg.data.service.CorporatecompanyService;
import com.dg.data.service.CurrencyService;
import com.dg.data.service.AssociationService;
import com.dg.data.service.CityService;

/**
 * Handles all crud operations for Corporatecompany table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/corporatecompany")
public class CorporatecompanyController
		extends AbstractController<Corporatecompany> {

	private static final Logger logger = LoggerFactory
			.getLogger(CorporatecompanyController.class);

	@Autowired
	public CorporatecompanyService corporatecompanyService;

	@Autowired
	public CityService cityService;

	@Autowired
	public AssociationService associationService;

	@Autowired
	public CurrencyService currencyService;

	@Autowired
	public CorporatecompanyController(
			CorporatecompanyService corporatecompanyService) {
		super.setGenericService(corporatecompanyService);
	}

	/**
	 * 
	 * handle corporatecompany edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Corporatecompany corporatecompany, Model model) {
		if (id != null) {
			model.addAttribute("corporatecompany",
					corporatecompanyService.get(id));
		}
		model.addAttribute("cityList", cityService.getAll());
		model.addAttribute("associationList", associationService.getAll());
		model.addAttribute("currencyList", currencyService.getAllCurrency());
		return "corporatecompany/edit";
	}

	/**
	 * 
	 * handle corporatecompany edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Corporatecompany corporatecompany,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save corporate-company",
					bindingResult.getErrorCount());
			model.addAttribute("cityList", cityService.getAll());
			model.addAttribute("associationList", associationService.getAll());
			model.addAttribute("currencyList",
					currencyService.getAllCurrency());
			return "corporatecompany/edit";
		}
		corporatecompanyService.edit(corporatecompany);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/corporatecompany/index";
	}
}