package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Insurance;
import com.dg.data.service.InsuranceService;

/**
 * Handles all crud operations for Insurance table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/insurance")
public class InsuranceController extends AbstractController<Insurance> {
	@Autowired
	public InsuranceController(InsuranceService insuranceService) {

	}

}