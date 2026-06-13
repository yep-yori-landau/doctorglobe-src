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

import com.dg.data.model.db.CorporatecompanyInsurance;
import com.dg.data.service.CorporatecompanyInsuranceService;
import com.dg.data.service.CorporatecompanyService;

/**
 * Handles all crud operations for CorporatecompanyInsurance table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/corporatecompany-insurance")
public class CorporatecompanyInsuranceController
		extends AbstractController<CorporatecompanyInsurance> {

	private static final Logger logger = LoggerFactory
			.getLogger(CorporatecompanyInsuranceController.class);

	@Autowired
	public CorporatecompanyInsuranceService corporatecompanyInsuranceService;

	@Autowired
	public CorporatecompanyService corporatecompanyService;

	@Autowired
	public CorporatecompanyInsuranceController(
			CorporatecompanyInsuranceService corporatecompanyInsuranceService) {
		super.setGenericService(corporatecompanyInsuranceService);
	}

	/**
	 * 
	 * handle corporatecompany-insurance edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			CorporatecompanyInsurance corporatecompanyInsurance, Model model) {
		if (id != null) {
			model.addAttribute("corporatecompanyInsurance",
					corporatecompanyInsuranceService.get(id));
		}
		model.addAttribute("corporatecompanyList",
				corporatecompanyService.getAll());
		return "corporatecompany-insurance/edit";
	}

	/**
	 * 
	 * handle corporatecompany-insurance edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid CorporatecompanyInsurance corporatecompanyInsurance,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save treatment-document",
					bindingResult.getErrorCount());
			model.addAttribute("corporatecompanyList",
					corporatecompanyService.getAll());
			return "corporatecompany-insurance/edit";
		}
		corporatecompanyInsuranceService.edit(corporatecompanyInsurance);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/corporatecompany-insurance/index";
	}
}