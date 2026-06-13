
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.TreatmentDocument;
import com.dg.data.model.domain.TreatmentDocumentModel;
import com.dg.data.service.TreatmentDocumentService;

/**
 * @author doctorGlobe Handles all interactions with the TreatmentDocument
 * table.
 */
@Controller
@RequestMapping(value = "/rest/treatment-document")
public class TreatmentDocumentRestController
		extends AbstractRestController<TreatmentDocument> {
	@Autowired
	public TreatmentDocumentRestController(
			TreatmentDocumentService treatmentDocumentService) {
		super.setGenericService(treatmentDocumentService);
	}

	@Autowired
	public TreatmentDocumentService treatmentDocumentService;

	// Provides interface to get TreatmentDocument by treatment
	@RequestMapping(value = "/get/treatment/{treatment}", method = RequestMethod.GET)
	public @ResponseBody List<TreatmentDocumentModel> getByTreatment(
			@PathVariable("treatment") BigInteger treatment) {
		return treatmentDocumentService.findByTreatment(treatment);
	}
}