
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.TreatmentAlias;
import com.dg.data.service.TreatmentAliasService;

/**
 * @author doctorGlobe Handles all interactions with the TreatmentAlias table.
 */
@Controller
@RequestMapping(value = "/rest/treatment-alias")
public class TreatmentAliasRestController
		extends AbstractRestController<TreatmentAlias> {
	@Autowired
	public TreatmentAliasRestController(
			TreatmentAliasService treatmentAliasService) {
		super.setGenericService(treatmentAliasService);
	}
}