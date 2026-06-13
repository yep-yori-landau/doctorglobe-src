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

import com.dg.data.model.db.HealthcareproviderInsurance;
import com.dg.data.service.HealthcareproviderInsuranceService;
import com.dg.data.model.db.Insurance;
import com.dg.data.service.InsuranceService;
import com.dg.data.model.db.Healthcareprovider;
import com.dg.data.service.HealthcareproviderService;

/**
 * Handles all crud operations for HealthcareproviderInsurance table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-insurance")
public class HealthcareproviderInsuranceController
		extends AbstractController<HealthcareproviderInsurance> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderInsuranceController.class);

	@Autowired
	public HealthcareproviderInsuranceService healthcareproviderinsuranceService;

	@Autowired
	public InsuranceService insuranceService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public HealthcareproviderInsuranceController(
			HealthcareproviderInsuranceService healthcareproviderInsuranceService) {
		super.setGenericService(healthcareproviderInsuranceService);
	}

	/**
	 * 
	 * handle healthcareprovider-insurance edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderInsurance healthcareproviderInsurance,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderInsurance",
					healthcareproviderinsuranceService.get(id));
		}
		model.addAttribute("insuranceList", insuranceService.getAll());
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());

		return "healthcareprovider-insurance/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-insurance edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderInsurance healthcareproviderInsurance,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-insurance",
					bindingResult.getErrorCount());
			model.addAttribute("insuranceList", insuranceService.getAll());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			return "healthcareprovider-insurance/edit";
		}
		healthcareproviderinsuranceService.edit(healthcareproviderInsurance);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-insurance/index";
	}

}