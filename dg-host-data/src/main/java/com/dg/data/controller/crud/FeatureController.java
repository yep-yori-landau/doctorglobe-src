package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Feature;
import com.dg.data.service.FeatureService;

/**
 * Handles all crud operations for Feature table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/feature")
public class FeatureController extends AbstractController<Feature> {
	@Autowired
	public FeatureController(FeatureService featureService) {
		super.setGenericService(featureService);
	}
}