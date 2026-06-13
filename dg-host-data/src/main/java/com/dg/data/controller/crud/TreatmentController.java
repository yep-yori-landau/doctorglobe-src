package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Treatment;
import com.dg.data.service.TreatmentService;

/**
 * Handles all crud operations for Treatment table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/treatment")
public class TreatmentController extends AbstractController<Treatment> {
	@Autowired
	public TreatmentController(TreatmentService treatmentService) {
		super.setGenericService(treatmentService);
	}
}