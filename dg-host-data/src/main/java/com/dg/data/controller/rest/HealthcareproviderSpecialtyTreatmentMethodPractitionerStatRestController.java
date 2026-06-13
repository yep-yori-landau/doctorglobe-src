
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitionerStat;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-specialty-treatment-method-practitioner-stat")
public class HealthcareproviderSpecialtyTreatmentMethodPractitionerStatRestController
		extends
		AbstractRestController<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> {
	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerStatRestController(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService healthcareproviderSpecialtyTreatmentMethodPractitionerStatService) {
		super.setGenericService(
				healthcareproviderSpecialtyTreatmentMethodPractitionerStatService);
	}

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService healthcareproviderSpecialtyTreatmentMethodPractitionerStatService;

	// Provides interface to get
	// HealthcareproviderSpecialtyTreatmentMethodPractitionerStat by hstmp
	@RequestMapping(value = "/get/hstmp/{hstmp}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> getByHstmp(
			@PathVariable("hstmp") BigInteger hstmp) {
		return healthcareproviderSpecialtyTreatmentMethodPractitionerStatService
				.findByHstmp(hstmp);
	}
}