
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.Patient;
import com.dg.data.model.domain.PatientCountryModel;
import com.dg.data.model.domain.PatientDetailModel;
import com.dg.data.model.domain.PatientLatLonModel;
import com.dg.data.service.PatientService;

/**
 * @author doctorGlobe Handles all interactions with the Patient table.
 */
@Controller
@RequestMapping(value = "/rest/patient")
public class PatientRestController {
	@Autowired
	public PatientService patientService;

	// Provides interface to get Patient
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Patient> getAll() {
		return this.patientService.getAll();
	}

	// Provides interface to get Patient by id
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Patient get(@PathVariable("id") int id) {
		return this.patientService.get(id);
	}

	// Provides interface to delete Patient by id
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Integer delete(@PathVariable("id") int id) {
		return this.patientService.delete(id);
	}

	// Provides interface to delete Patient by id,user,type
	@RequestMapping(value = "/delete/id/{id}/user/{user}/type/{type}", method = RequestMethod.GET)
	public @ResponseBody Integer delete(@PathVariable("id") int id,
			@PathVariable("user") BigInteger user,
			@PathVariable("type") String type) {
		return this.patientService.delete(id, user, type);
	}

	// Provides interface to create Patient
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Integer create(@RequestBody Patient patient) {
		return this.patientService.insert(patient);
	}

	// Provides interface to create Patient by user,type
	@RequestMapping(value = "/create/user/{user}/type/{type}", method = RequestMethod.POST)
	public @ResponseBody Integer create(@PathVariable("user") BigInteger user,
			@PathVariable("type") String type, @RequestBody Patient patient) {
		return this.patientService.insert(patient, user, type);
	}

	// Provides interface to get Patient by email,active
	@RequestMapping(value = "/get/email/{email}/active/{active}", method = RequestMethod.GET)
	public @ResponseBody Patient getByEmail(@PathVariable("email") String email,
			@PathVariable("active") Integer active) {
		return patientService.findByEmail(email, active);
	}

	// Provides interface to get Patient by practitioner
	@RequestMapping(value = "/get/practitioner/{practitioner}", method = RequestMethod.GET)
	public @ResponseBody List<PatientDetailModel> getByPractitionerId(
			@PathVariable("practitioner") Integer practitioner) {
		return patientService.findByPractiionerId(practitioner);
	}

	// Provides interface to get Patient by patientcase,practitioner
	@RequestMapping(value = "/get/patientcase/{patientcase}/practitioner/{practitioner}", method = RequestMethod.GET)
	public @ResponseBody List<PatientDetailModel> getByPatientcase(
			@PathVariable("patientcase") Integer patientcase,
			@PathVariable("practitioner") Integer practitioner) {
		return patientService.findByPatientcase(patientcase, practitioner);
	}

	// Provides interface to reset Patient password by old_password,new_password
	@RequestMapping(value = "/reset/id/{id}/old_password/{old_password}/new_password/{new_password}", method = RequestMethod.GET)
	public @ResponseBody Integer get(@PathVariable("id") int id,
			@PathVariable("old_password") String old_password,
			@PathVariable("new_password") String new_password) {
		return patientService.resetPassword(id, old_password, new_password);
	}

	// Provides interface to get Country by id
	@RequestMapping(value = "/get/country/id/{id}", method = RequestMethod.GET)
	public @ResponseBody PatientCountryModel getCountry(
			@PathVariable("id") int id) {
		return patientService.findCountryById(id);
	}

	// Provides interface to get LatLon by id
	@RequestMapping(value = "/getlatlon/{id}", method = RequestMethod.GET)
	public @ResponseBody PatientLatLonModel getLatLonModel(
			@PathVariable("id") Integer id) {
		return patientService.findLatLonById(id);
	}
	
	// Provides interface to get Patient by email,active
	@RequestMapping(value = "/get/{phone}/{active}", method = RequestMethod.GET)
	public @ResponseBody Patient getByPhone(@PathVariable("phone") String phone,
			@PathVariable("active") Integer active) {
		return patientService.findByPhone(phone, active);
	}
}