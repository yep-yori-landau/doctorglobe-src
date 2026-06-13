package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Attestations;
import com.dg.data.service.AttestationsService;

/**
 * Handles all crud operations for Attestations table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/attestations")
public class AttestationsController extends AbstractController<Attestations> {
	@Autowired
	public AttestationsController(AttestationsService attestationsService) {
		super.setGenericService(attestationsService);
	}
}