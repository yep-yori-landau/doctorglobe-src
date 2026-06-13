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

import com.dg.data.model.db.EmployeeCorporatecompany;
import com.dg.data.service.EmployeeCorporatecompanyService;
import com.dg.data.service.CorporatecompanyInsuranceService;
import com.dg.data.service.PatientService;

/**
 * Handles all crud operations for EmployeeCorporatecompany table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/employee-corporatecompany")
public class EmployeeCorporatecompanyController
		extends AbstractController<EmployeeCorporatecompany> {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeCorporatecompanyController.class);

	@Autowired
	public EmployeeCorporatecompanyService employeeCorporatecompanyService;

	@Autowired
	public CorporatecompanyInsuranceService corporatecompanyInsuranceService;

	@Autowired
	public PatientService patientService;

	@Autowired
	public EmployeeCorporatecompanyController(
			EmployeeCorporatecompanyService employeeCorporatecompanyService) {
		super.setGenericService(employeeCorporatecompanyService);
	}

	/**
	 * 
	 * handle employee-corporatecompany edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			EmployeeCorporatecompany employeeCorporatecompany, Model model) {
		if (id != null) {
			model.addAttribute("employeeCorporatecompany",
					employeeCorporatecompanyService.get(id));
		}
		logger.info("data {}", corporatecompanyInsuranceService.getAll());
		model.addAttribute("corporatecompanyInsuranceList",
				corporatecompanyInsuranceService.getAll());
		model.addAttribute("patientList", patientService.getAll());
		return "employee-corporatecompany/edit";
	}

	/**
	 * 
	 * handle employee-corporatecompany edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid EmployeeCorporatecompany employeeCorporatecompany,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save treatment-document",
					bindingResult.getErrorCount());
			model.addAttribute("corporatecompanyInsuranceList",
					corporatecompanyInsuranceService.getAll());
			model.addAttribute("patientList", patientService.getAll());
			return "employee-corporatecompany/edit";
		}
		employeeCorporatecompanyService.edit(employeeCorporatecompany);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/employee-corporatecompany/index";
	}
}