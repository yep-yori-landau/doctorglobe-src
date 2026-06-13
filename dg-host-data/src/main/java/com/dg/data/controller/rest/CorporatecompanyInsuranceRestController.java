
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.CorporatecompanyInsurance;
import com.dg.data.service.CorporatecompanyInsuranceService;

/**
 * @author DoctorGlobe Handles all interactions with the
 * CorporatecompanyInsurance table.
 */
@Controller
@RequestMapping(value = "/rest/corporatecompany-insurance")
public class CorporatecompanyInsuranceRestController
		extends AbstractRestController<CorporatecompanyInsurance> {
	@Autowired
	public CorporatecompanyInsuranceRestController(
			CorporatecompanyInsuranceService corporatecompanyInsuranceService) {
		super.setGenericService(corporatecompanyInsuranceService);
	}

}