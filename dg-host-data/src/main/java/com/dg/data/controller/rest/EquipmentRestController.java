
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Equipment;
import com.dg.data.service.EquipmentService;

/**
 * @author DoctorGlobe Handles all interactions with the Equipment table.
 */
@Controller
@RequestMapping(value = "/rest/equipment")
public class EquipmentRestController extends AbstractRestController<Equipment> {
	@Autowired
	public EquipmentRestController(EquipmentService equipmentService) {
		super.setGenericService(equipmentService);
	}
}