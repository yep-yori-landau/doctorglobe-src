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

import com.dg.data.model.db.HealthcareproviderEquipment;
import com.dg.data.service.HealthcareproviderEquipmentService;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.EquipmentService;

/**
 * Handles all crud operations for HealthcareproviderEquipment table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-equipment")
public class HealthcareproviderEquipmentController
		extends AbstractController<HealthcareproviderEquipment> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderEquipmentController.class);

	@Autowired
	public HealthcareproviderEquipmentService healthcareproviderequipmentService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public EquipmentService equipmentService;

	@Autowired
	public HealthcareproviderEquipmentController(
			HealthcareproviderEquipmentService healthcareproviderEquipmentService) {
		super.setGenericService(healthcareproviderEquipmentService);
	}

	/**
	 * 
	 * handle healthcareprovider-equipment edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderEquipment healthcareproviderEquipment,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderEquipment",
					healthcareproviderequipmentService.get(id));
		}
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		model.addAttribute("equipmentList", equipmentService.getAll());
		return "healthcareprovider-equipment/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-equipment edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderEquipment healthcareproviderEquipment,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-equipment",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			model.addAttribute("equipmentList", equipmentService.getAll());
			return "healthcareprovider-equipment/edit";
		}
		healthcareproviderequipmentService.edit(healthcareproviderEquipment);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-equipment/index";
	}

}