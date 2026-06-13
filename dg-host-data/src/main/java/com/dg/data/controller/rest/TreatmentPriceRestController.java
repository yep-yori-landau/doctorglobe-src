
package com.dg.data.controller.rest;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.TreatmentPrice;
import com.dg.data.service.TreatmentPriceService;

/**
 * @author doctorGlobe Handles all interactions with the TreatmentPrice table.
 */
@Controller
@RequestMapping(value = "/rest/treatment-price")
public class TreatmentPriceRestController
		extends AbstractRestController<TreatmentPrice> {
	@Autowired
	public TreatmentPriceRestController(
			TreatmentPriceService treatmentPriceService) {
		super.setGenericService(treatmentPriceService);
	}

	@Autowired
	public TreatmentPriceService treatmentPriceService;

	// Provides interface to get TreatmentPrice by treatment, city
	@RequestMapping(value = "/get/treatment/{treatment}/city/{city}", method = RequestMethod.GET)
	public @ResponseBody TreatmentPrice get(
			@PathVariable("treatment") BigInteger treatment,
			@PathVariable("city") BigInteger city) {
		return treatmentPriceService.findByTreatmentCity(treatment, city);
	}
}