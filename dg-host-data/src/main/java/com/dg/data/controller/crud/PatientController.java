package com.dg.data.controller.crud;

import java.io.File;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.data.model.db.Patient;
import com.dg.data.service.CityService;
import com.dg.data.service.PatientService;

/**
 * Handles all crud operations for Patient table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patient")
public class PatientController extends AbstractCrudController<Patient> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientController.class);

	@Autowired
	public PatientService patientService;

	@Autowired
	public CityService cityService;

	@Autowired
	public PatientController(PatientService patientService) {
		super.setGenericService(patientService);
	}

	/**
	 * 
	 * handle patient edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patient patient, Model model) {
		if (id != null) {
			model.addAttribute("patient", patientService.get(id));
		}
		model.addAttribute("cityList", cityService.getAll());
		model.addAttribute("dependentList", patientService.getAll());
		return "patient/edit";
	}

	/**
	 * 
	 * handle patient edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patient patient, BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			@RequestParam("file") MultipartFile file, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				logger.error("Got {} errors during save patient",
						bindingResult.getErrorCount());
				model.addAttribute("dependentList", patientService.getAll());
				model.addAttribute("cityList", cityService.getAll());
				return "patient/edit";
			}
			if (patient.getId() != null) {
				Patient patientModel = patientService
						.get(patient.getId().intValue());
				if (!patientModel.getPassword().equals(patient.getPassword())) {
					patient.setPassword(
							patientService.getSHA1(patient.getPassword()));
				}
			}
			if (!file.isEmpty()) {
				try {
					String filename = file.getOriginalFilename();
					File f = new File("/tmp/" + file.getOriginalFilename());
					file.transferTo(f);
					patient.setPhoto(filename);
				}
				catch (Exception ex) {
					logger.info(ex.getMessage());
				}
			}
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		patientService.insert(patient);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patient/index";
	}
}