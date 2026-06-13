
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethod;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderSpecialtyTreatmentMethod table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-specialty-treatment-method")
public class HealthcareproviderSpecialtyTreatmentMethodRestController extends
		AbstractRestController<HealthcareproviderSpecialtyTreatmentMethod> {
	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodRestController(
			HealthcareproviderSpecialtyTreatmentMethodService healthcareproviderSpecialtyTreatmentMethodService) {
		super.setGenericService(
				healthcareproviderSpecialtyTreatmentMethodService);
	}

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodService healthcareproviderSpecialtyTreatmentMethodService;

	// Provides interface to get HealthcareproviderSpecialtyTreatmentMethod by
	// healthcareprovider_specialty
	@RequestMapping(value = "/get/healthcareprovider_specialty/{healthcareprovider_specialty}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialtyTreatmentMethod> getByHealthcareproviderSpecialty(
			@PathVariable("healthcareprovider_specialty") BigInteger healthcareprovider_specialty) {
		return healthcareproviderSpecialtyTreatmentMethodService
				.findByHealthcareproviderSpecialty(
						healthcareprovider_specialty);
	}

	// Provides interface to get HealthcareproviderSpecialtyTreatmentMethod by
	// healthcareprovider_specialty and treatment
	@RequestMapping(value = "/get/healthcareprovider_specialty/{healthcareprovider_specialty}/treatment/{treatment}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialtyTreatmentMethod> getByHealthcareproviderSpecialtyTreatment(
			@PathVariable("healthcareprovider_specialty") BigInteger healthcareprovider_specialty,
			@PathVariable("treatment") BigInteger treatment) {
		return healthcareproviderSpecialtyTreatmentMethodService
				.findByHealthcareproviderSpecialtyTreatment(
						healthcareprovider_specialty, treatment);
	}

	// Provides interface to get HealthcareproviderSpecialtyTreatmentMethod by
	// healthcareprovider_specialty and treatment and method
	@RequestMapping(value = "/get/healthcareprovider_specialty/{healthcareprovider_specialty}/treatment/{treatment}/method/{method}", method = RequestMethod.GET)
	public @ResponseBody HealthcareproviderSpecialtyTreatmentMethod getByHealthcareproviderSpecialtyTreatmentMethod(
			@PathVariable("healthcareprovider_specialty") BigInteger healthcareprovider_specialty,
			@PathVariable("treatment") BigInteger treatment,
			@PathVariable("method") BigInteger method) {
		return healthcareproviderSpecialtyTreatmentMethodService
				.findByHealthcareproviderSpecialtyTreatmentMethod(
						healthcareprovider_specialty, treatment, method);
	}

	// Provides interface to get HealthcareproviderSpecialtyTreatmentMethod by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialtyTreatmentMethod> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderSpecialtyTreatmentMethodService
				.findByHealthcareprovider(healthcareprovider);
	}

	// Provides interface to get HealthcareproviderSpecialtyTreatmentMethod by
	// specialty
	@RequestMapping(value = "/get/specialty/{specialty}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialtyTreatmentMethod> getBySpecialty(
			@PathVariable("specialty") BigInteger specialty) {
		return healthcareproviderSpecialtyTreatmentMethodService
				.findBySpecialty(specialty);
	}
}