
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Insurance;
import com.dg.data.service.InsuranceService;

/**
 * @author doctorGlobe Handles all interactions with the Insurance table.
 */
@Controller
@RequestMapping(value = "/rest/insurance")
public class InsuranceRestController extends AbstractRestController<Insurance> {
	@Autowired
	public InsuranceRestController(InsuranceService insuranceService) {
		super.setGenericService(insuranceService);
	}
}