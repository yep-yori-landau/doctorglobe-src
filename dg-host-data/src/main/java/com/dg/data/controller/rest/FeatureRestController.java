
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Feature;
import com.dg.data.service.FeatureService;

/**
 * @author DoctorGlobe Handles all interactions with the Feature table.
 */
@Controller
@RequestMapping(value = "/rest/feature")
public class FeatureRestController extends AbstractRestController<Feature> {
	@Autowired
	public FeatureRestController(FeatureService featureService) {
		super.setGenericService(featureService);
	}
}