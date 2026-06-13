
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.HealthcareproviderEquipment;
import com.dg.data.service.HealthcareproviderEquipmentService;

/**
 * @author DoctorGlobe Handles all interactions with the
 * HealthcareproviderEquipment table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-equipment")
public class HealthcareproviderEquipmentRestController
		extends AbstractRestController<HealthcareproviderEquipment> {
	@Autowired
	public HealthcareproviderEquipmentRestController(
			HealthcareproviderEquipmentService healthcareproviderEquipmentService) {
		super.setGenericService(healthcareproviderEquipmentService);
	}

	@Autowired
	public HealthcareproviderEquipmentService healthcareproviderequipmentService;

	/**
	 * Provides interface to get list of healthcareproviderequipment by
	 * healthcareprovider
	 * 
	 */
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderEquipment> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderequipmentService
				.findByHealthcareprovider(healthcareprovider);
	}
}