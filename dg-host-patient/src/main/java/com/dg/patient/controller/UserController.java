package com.dg.patient.controller;

import java.io.File;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.patient.form.ForgotForm;
import com.dg.patient.form.ResetPasswordForm;
import com.dg.patient.form.ResetPasswordFormValidator;
import com.dg.patient.model.CityModel;
import com.dg.patient.model.PatientCaseBookingModel;
import com.dg.patient.model.PatientModel;
import com.dg.patient.model.StateModel;
import com.dg.patient.model.PractitionerModel;
import com.dg.patient.service.SearchService;
import com.dg.patient.service.UserService;
import com.dg.patient.validator.ProfileValidator;

/**
 * Handles requests for the application user page.
 * @author DoctorGlobe
 */
@Controller
public class UserController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private SearchService searchService;

	@Autowired
	private ResetPasswordFormValidator validatorPassword;

	@Autowired
	private ProfileValidator profileValidator;

	/**
	 * handle user forgot password get action
	 * @param forgotform
	 * @param model
	 * @return string 
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String forgot(ForgotForm forgotform, Model model) {
		model.addAttribute("forgotform", forgotform);
		return "forgot";
	}

	/**
	 * handle user forgot password post action
	 * @param forgotform
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return string
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String forgothandler(@Valid ForgotForm forgotform,
			BindingResult bindingResult, Model model,
			HttpServletRequest request) {
		model.addAttribute("forgotform", forgotform);
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during patient forgot password",
					bindingResult.getErrorCount());
			logger.error("message {}", bindingResult.getAllErrors());
			return "forgot";
		}
		model.addAttribute("emailaddress", forgotform.getEmail());
		model.addAttribute("forgoterror", userService.checkForgotUserEmail(
				forgotform.getEmail(), userService.getCurrentUrl(request)));
		return "forgot";
	}

	/**
	 * handle user reset password get action
	 * @param id
	 * @param password
	 * @param type
	 * @param resetform
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset(@RequestParam(value = "r", required = false) Integer id,
			@RequestParam(value = "p", required = false) String password,
			@RequestParam(value = "type", required = false) String type,
			ResetPasswordForm resetform, Model model) {
		if (id != null && password != null && type != null) {
			resetform.setId(id);
			resetform.setOldPassword(password);
			resetform.setType(type);
		}
		else {
			model.asMap().clear();
			return "redirect:/";
		}
		model.addAttribute("resetform", resetform);
		return "user/resetpassword";
	}

	/**
	 * handle user reset password post action
	 * @param resetform
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String resethandler(
			@Valid @ModelAttribute("resetform") ResetPasswordForm resetform,
			BindingResult bindingResult, Model model,
			HttpServletRequest request) {
		model.addAttribute("resetform", resetform);
		model.addAttribute("passworderror", 0);
		String currentUrl = userService.getCurrentUrl(request);
		validatorPassword.validate(resetform, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during patient reset forgot password",
					bindingResult.getErrorCount());
			logger.error("message {}", bindingResult.getAllErrors());
			return "user/resetpassword";
		}
		model.addAttribute("error",
				userService.resetPassword(resetform, currentUrl));
		model.addAttribute("currentUrl", userService.getHostUrl(currentUrl));
		return "user/resetpassword";
	}

	/**
	 * handle user profile get action
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public String profile(Model model) {
		model.addAttribute("patientModel",
				userService.getPatientById(userService.getCurrentUserId()));
		model.addAttribute("countryList", userService.getCountry());
		return "user/profile";
	}

	/**
	 * handle user profile post action
	 * @param patientModel
	 * @param bindingResult
	 * @param redirectAttributes
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/profile", method = RequestMethod.POST)
	public String updateprofile(@Valid PatientModel patientModel,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			@RequestParam("file") MultipartFile file, Model model) {
		Boolean found = false;
		model.addAttribute("patientModel", patientModel);
		profileValidator.validate(patientModel, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during update profile",
					bindingResult.getAllErrors());
			model.addAttribute("errors", 1);
			model.addAttribute("countryList", userService.getCountry());
			model.addAttribute("cityList", userService.getCity());
			return "user/profile";
		}
		else if (file.getSize() >= 500000000) {
			logger.info(
					"File is too big for upload( max 500 MB files are supported");
			redirectAttributes.addFlashAttribute("sizeerror", "1");
			return "redirect:/user/profile";
		}
		else {
			if (!file.isEmpty()) {
				try {
					if (!userService.fileTypeValidate(file.getContentType())) {
						logger.info("file type ={}", file.getContentType());
						redirectAttributes.addFlashAttribute("typeerror", "1");
						logger.info("Unsupported File Type");
						return "redirect:/user/profile";
					}
					DateFormat dateFormat = new SimpleDateFormat(
							"yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					String now = dateFormat.format(date).toString();
					String filename = userService
							.getSHA1(FilenameUtils.removeExtension(
									file.getOriginalFilename()) + now)
							+ "." + FilenameUtils
									.getExtension(file.getOriginalFilename());
					File fileDir = new File(
							userService.getSearchUrlService().getUploadPath()
									+ "/patient/"
									+ userService.getCurrentUserId()
									+ "/photo");
					if (!fileDir.exists()) {
						if (fileDir.mkdirs()) {
							File f = new File(
									fileDir.getAbsolutePath() + "/" + filename);
							file.transferTo(f);
							found = true;
						}
						else {
							model.addAttribute("errors", 1);
							model.addAttribute("servererror", "1");
							logger.info("Directory not created successfully.");
						}
					}
					else {
						File f = new File(
								fileDir.getAbsolutePath() + "/" + filename);
						file.transferTo(f);
						found = true;
					}
					if (found) {
						userService.deleteFile(userService.getSearchUrlService()
								.getUploadPath() + "/patient/"
								+ userService.getCurrentUserId() + "/photo/"
								+ patientModel.getPhoto());
						patientModel.setPhoto(filename);
						Integer id = userService.registerPatient(patientModel);
						if (id > 0) {
							redirectAttributes.addFlashAttribute("success",
									"1");
						}
						return "redirect:/user/profile";
					}

				}
				catch (Exception ex) {
					logger.info(ex.getMessage());
				}
			}
			else {
				Integer id = userService.registerPatient(patientModel);
				logger.info("patient id {}", id);
				if (id > 0) {
					redirectAttributes.addFlashAttribute("success", "1");
					return "redirect:/user/profile";
				}
				else {
					model.addAttribute("error", 1);
				}
			}
		}
		model.addAttribute("countryList", userService.getCountry());
		model.addAttribute("cityList", userService.getCity());
		return "user/profile";
	}

    /**
     * handle user agreement get action
     * @param model
     * @return String 
     */
	@RequestMapping(value = "/user/useragreement", method = RequestMethod.GET)
	public String userAgreement(Model model) {
		return "user/useragreement";
	}

	/**
	 * handle user agreement post action
	 * @param model 
	 * @return String 
	 */
	@RequestMapping(value = "/user/useragreement", method = RequestMethod.POST)
	public String setUserAgreement(Model model) {
		model.addAttribute("message", userService.setUserAgreement());
		return "user/useragreement";
	}

	/**
	 * handle ajax state request bt country
	 * @param country the unique id of country
	 * @return list of stateModel
	 */
	@RequestMapping(value = "/state/country/{country}", method = RequestMethod.GET)
	public @ResponseBody List<StateModel> getStateByCountry(
			@PathVariable("country") int country) {
		return userService.getStateByCountryAsc(country);
	}

	/**
	 * handle ajax city request by country
	 * @param country the unique id of country
	 * @return list of cityModel
	 */
	@RequestMapping(value = "/city/country/{country}", method = RequestMethod.GET)
	public @ResponseBody List<CityModel> getCityByCountry(
			@PathVariable("country") int country) {
		return userService.getCityByCountryAsc(country);
	}

	/**
	 * handle ajax city request by state
	 * @param state the unique id of state
	 * @return list of cityModel
	 */
	@RequestMapping(value = "/city/state/{state}", method = RequestMethod.GET)
	public @ResponseBody List<CityModel> getCityByState(
			@PathVariable("state") int state) {
		return userService.getCityByStateAsc(state);
	}

	/**
	 * handle ajax city request by id
	 * @param id the unique id of city
	 * @return cityModel
	 */
	@RequestMapping(value = "/city/id/{id}", method = RequestMethod.GET)
	public @ResponseBody CityModel getCityById(@PathVariable("id") int id) {
		return userService.getCityById(id);
	}

	/**
	 * Provide interface to active the patient
	 * @param id the unique id of patient
	 * @param model the spring ui model
	 * @return String
	 */
	@RequestMapping(value = "/active/id/{id}", method = RequestMethod.GET)
	public String activeCustomer(@PathVariable("id") BigInteger id,
			Model model) {
		PatientModel patient = userService.getPatientById(id);
		if (patient.getActive()) {
			return "redirect:/";
		}
		else {
			patient.setActive(true);
			userService.registerPatient(patient);
		}
		return "user/active";
	}

	/**
	 * 
	 * handle patient hospital confirmation popup	 *
	 * @param islogged the boolean value
	 * @param model the spring ui model
	 * @return string
	 */
	@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
	public String confirmationMessage(
			@RequestParam(value = "islogged", required = false) Boolean islogged,
			Model model) {
		if (!islogged) {
			model.addAttribute("islogged", 1);
		}
		else {
			model.addAttribute("islogged", 10);
		}
		return "user/confirmation";
	}

	/**
	 * 
	 * handle patient hospital limitexceed popup
	 */
	@RequestMapping(value = "/limitexceed", method = RequestMethod.GET)
	public String limitexceedMessage(Model model) {
		return "user/limitexceed";
	}

	/**
	 * handle add new patient case get request	  
	 * @param practitioner the unique id of practitioner
	 * @param treatment the unique id of treatment
	 * @param hcpstmp
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @param lp the list price of treatment
	 * @param ylp the you pay list price 
	 * @param blp the bonus list price
	 * @param tn  the name of treatment
	 * @param model the spring ui model
	 * @return string
	 */
	@RequestMapping(value = "/user/patientcase", method = RequestMethod.GET)
	public String addpatientcase(
			@RequestParam(value = "practitioner", required = true) Integer practitioner,
			@RequestParam(value = "treatment", required = true) Integer treatment,
			@RequestParam(value = "hcpstmp", required = true) BigInteger hcpstmp,
			@RequestParam(value = "healthcareprovider", required = true) BigInteger healthcareprovider,
			@RequestParam(value = "lp", required = true) Double lp,
			@RequestParam(value = "ylp", required = true) Double ylp,
			@RequestParam(value = "blp", required = true) Double blp,
			@RequestParam(value = "tn", required = true) String tn,
			Model model) {
		PractitionerModel practitionerModel = new PractitionerModel();
		BigInteger patientcase = null;
		List<PatientCaseBookingModel> pcbList = userService
				.getPatientCaseBookingModelByPatientAndTreatment(
						userService.getCurrentUserId(), treatment);
		Integer totalTreatmentConference = userService
				.getTotalPatientTreatmentConference(
						userService.getCurrentUserId(), treatment);
		if (userService.getSearchUrlService()
				.getCaseConferenceLimit() <= totalTreatmentConference
				|| !pcbList.isEmpty()) {
			return "redirect:/search";
		}
		patientcase = userService.addPatientCase(userService.getCurrentUserId(),
				BigInteger.valueOf(treatment));
		logger.info("patientCase Id {}", patientcase);
		List<PractitionerModel> practitionersList = searchService.practitioners(
				healthcareprovider.intValue(), treatment,
				userService.getCurrentUserId());
		practitionerModel = userService
				.getSelectedPractitionerModel(practitionersList, practitioner);
		userService.addNewPatientCase(patientcase, hcpstmp, healthcareprovider,
				lp, ylp, blp, practitionerModel);
		model.addAttribute("healthcareprovider", healthcareprovider);
		model.addAttribute("treatment", treatment);
		model.addAttribute("pc", patientcase);
		model.addAttribute("treatmentName", tn);
		model.addAttribute("practitionerModel", practitionerModel);

		return "user/patientcase_new";
	}

}