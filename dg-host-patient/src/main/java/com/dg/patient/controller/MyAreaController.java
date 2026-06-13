package com.dg.patient.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.patient.form.SelectDoctorForm;
import com.dg.patient.model.HospitalPractitionerModel;
import com.dg.patient.service.UserService;

/**
 * 
 * Handles all interactions with the patient myarea
 * @author DoctorGlobe
 *
 */
@Controller
public class MyAreaController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(MyAreaController.class);

	@Autowired
	private UserService userService;

	/**
	 * handle user myarea action get action
	 * 
	 */
	@RequestMapping(value = "/user/myarea", method = RequestMethod.GET)
	public String myareaAction(Model model) {
		model.addAttribute("patientcases",
				userService.getPatientcasesMap().descendingMap());
		model.addAttribute("pc",
				userService.getCurrentUserModel().getPatientcase());
		model.addAttribute("hospitalSelectedIcon",
				userService.getHospitalSelectedIcon());
		model.addAttribute("hospitalPractitionerSelectedIcon",
				userService.getHospitalPractitionerSelectedIcon());
		return "user/myarea";
	}

	/**
	 * handle user myarea select doc get action
	 * @param SelectDoctorForm
	 * @param model
	 * return String selecteddoc page
	 */
	@RequestMapping(value = "/user/select-doc", method = RequestMethod.GET)
	public String selectdocAction(SelectDoctorForm selectDoctorForm,
			Model model) {
		model.addAttribute("patientcases",
				userService.getPatientcasesMap().descendingMap());
		model.addAttribute("pc",
				userService.getCurrentUserModel().getPatientcase());
		model.addAttribute("hospitalSelectedIcon",
				userService.getHospitalSelectedIcon());
		model.addAttribute("hospitalPractitionerSelectedIcon",
				userService.getHospitalPractitionerSelectedIcon());
		model.addAttribute("hospitalMap",
				userService.getSelectedHospitalList(
						userService.getCurrentUserId(),
						userService.getCurrentUserModel().getPatientcase()));
		selectDoctorForm.setHstm(userService.getHstm());
		selectDoctorForm.setSelectedHstmp(
				userService.getSelectedHstmp(userService.getHstm()));
		model.addAttribute("treatmentName",
				userService.getPatientCaseTreatmentName());
		model.addAttribute("hstm", userService.getHstm());
		model.addAttribute("selectDoctorForm", selectDoctorForm);
		model.addAttribute("practitionerList", userService
				.getWithoutGenericHstmPractitionerList(userService.getHstm()));
		return "user/select-doctor";
	}

	/**
	 * handle user myarea select doc post action
	 * @param SelectDoctorForm
	 * @param model
	 * return String selecteddoc page
	 */
	@RequestMapping(value = "/user/select-doc", method = RequestMethod.POST)
	public String selectdocPostAction(SelectDoctorForm selectDoctorForm,
			Model model) {
		userService.setHosptialPracititoner(selectDoctorForm);
		model.addAttribute("patientcases",
				userService.getPatientcasesMap().descendingMap());
		model.addAttribute("pc",
				userService.getCurrentUserModel().getPatientcase());
		model.addAttribute("hospitalSelectedIcon",
				userService.getHospitalSelectedIcon());
		model.addAttribute("hospitalPractitionerSelectedIcon",
				userService.getHospitalPractitionerSelectedIcon());
		model.addAttribute("hospitalMap",
				userService.getSelectedHospitalList(
						userService.getCurrentUserId(),
						userService.getCurrentUserModel().getPatientcase()));
		model.addAttribute("hstm", selectDoctorForm.getHstm());
		model.addAttribute("selectDoctorForm", selectDoctorForm);
		model.addAttribute("practitionerList",
				userService.getWithoutGenericHstmPractitionerList(
						selectDoctorForm.getHstm()));
		model.addAttribute("treatmentName",
				userService.getPatientCaseTreatmentName());
		return "user/select-doctor";
	}

	/**
	 * 
	 * handle ajax patientcase set request
	 * @param pc the unique id of patientcase
	 * return true if user selected patientcase set
	 */
	@RequestMapping(value = "/user/select-patientcase/{pc}", method = RequestMethod.GET)
	public @ResponseBody Boolean setSelectedPatientcase(
			@PathVariable("pc") BigInteger patientcase) {
		userService.getCurrentUserModel().setPatientcase(patientcase);
		return true;
	}

	/**
	 * 
	 * handle ajax practitionerlist get request
	 * @param hstm the unique id of healthcareprovider_specialty_treatment_method table
	 * return list of hospital practitioner based on hstm
	 */
	@RequestMapping(value = "/user/practitioner-list/{hstm}", method = RequestMethod.GET)
	public @ResponseBody List<HospitalPractitionerModel> getHospitalPracitionerList(
			@PathVariable("hstm") BigInteger hstm) {
		return userService.getWithoutGenericHstmPractitionerList(hstm);
	}

	/**
	 * 
	 * handle ajax selected hcpstmp get request
	 * @param hstm the unique id of healthcareprovider_specialty_treatment_method table
	 * return BigInteger hstmp the unique id of selected healthcareprovider_specialty_treatment_method_practitioner 
	 */
	@RequestMapping(value = "/user/selected-hcpstmp/{hstm}", method = RequestMethod.GET)
	public @ResponseBody BigInteger getSelectedHcpstmp(
			@PathVariable("hstm") BigInteger hstm) {
		return userService.getHstmp(hstm);
	}
	
	/**
	 * 
	 * handle ajax booking date get request
	 * @param hstmp the unique id of healthcareprovider_specialty_treatment_method_practitioner table
	 * return String booking date  
	 */
	@RequestMapping(value = "/user/added-booking-date/{hstmp}", method = RequestMethod.GET)
	public @ResponseBody String getBookingDate(
			@PathVariable("hstmp") BigInteger hstmp) {
		return userService.getBookingDate(hstmp);
	}

}