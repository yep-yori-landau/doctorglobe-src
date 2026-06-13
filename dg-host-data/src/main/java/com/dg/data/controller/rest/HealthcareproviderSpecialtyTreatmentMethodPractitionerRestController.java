
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitioner;
import com.dg.data.model.domain.HospitalPractitionerModel;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderSpecialtyTreatmentMethodPractitioner table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-specialty-treatment-method-practitioner")
public class HealthcareproviderSpecialtyTreatmentMethodPractitionerRestController
		extends
		AbstractRestController<HealthcareproviderSpecialtyTreatmentMethodPractitioner> {
	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerRestController(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerService healthcareproviderSpecialtyTreatmentMethodPractitionerService) {
		super.setGenericService(
				healthcareproviderSpecialtyTreatmentMethodPractitionerService);
	}

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerService healthcareproviderSpecialtyTreatmentMethodPractitionerService;

	// Provides interface to get
	// HealthcareproviderSpecialtyTreatmentMethodPractitioner by hstm
	@RequestMapping(value = "/get/hstm/{hstm}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> getByHstm(
			@PathVariable("hstm") BigInteger hstm) {
		return healthcareproviderSpecialtyTreatmentMethodPractitionerService
				.findByHstm(hstm);
	}

	// Provides interface to get
	// HealthcareproviderSpecialtyTreatmentMethodPractitioner by practitioner
	// and hstm
	@RequestMapping(value = "/get/hstm/{hstm}/practitioner/{practitioner}", method = RequestMethod.GET)
	public @ResponseBody HealthcareproviderSpecialtyTreatmentMethodPractitioner getByHstmPractitioner(
			@PathVariable("hstm") BigInteger hstm,
			@PathVariable("practitioner") BigInteger practitioner) {
		return healthcareproviderSpecialtyTreatmentMethodPractitionerService
				.findByHstmPractitioner(hstm, practitioner);
	}

	// Provides interface to get
	// HealthcareproviderSpecialtyTreatmentMethodPractitioner by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderSpecialtyTreatmentMethodPractitionerService
				.findByHealthcareprovider(healthcareprovider);
	}

	// Provides interface to get
	// HealthcareproviderSpecialtyTreatmentMethodPractitioner by specialty
	@RequestMapping(value = "/get/specialty/{specialty}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> getBySpecialty(
			@PathVariable("specialty") BigInteger specialty) {
		return healthcareproviderSpecialtyTreatmentMethodPractitionerService
				.findBySpecialty(specialty);
	}

	// Provides interface to get
	// HealthcareproviderSpecialtyTreatmentMethodPractitioner by hstmId
	@RequestMapping(value = "/get/hstmid/{hstm}", method = RequestMethod.GET)
	public @ResponseBody List<HospitalPractitionerModel> getByHstmId(
			@PathVariable("hstm") BigInteger hstm) {
		return healthcareproviderSpecialtyTreatmentMethodPractitionerService
				.findByHstmId(hstm);
	}
}