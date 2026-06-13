package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Equipment;
import com.dg.data.service.EquipmentService;

/**
 * Handles all crud operations for Equipment table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController extends AbstractController<Equipment> {
	@Autowired
	public EquipmentController(EquipmentService equipmentService) {
		super.setGenericService(equipmentService);
	}
}