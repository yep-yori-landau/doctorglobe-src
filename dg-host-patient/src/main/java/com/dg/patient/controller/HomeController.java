package com.dg.patient.controller;

import java.util.Collections;
import java.util.List;
import java.math.BigInteger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.patient.form.BrokerUserForm;
import com.dg.patient.form.LoginForm;
import com.dg.patient.form.SearchForm;
import com.dg.patient.service.HealthcareproviderResultService;
import com.dg.patient.service.OriginPriceCalculationService;
import com.dg.patient.service.RankingCalculationService;
import com.dg.patient.service.SearchService;
import com.dg.patient.service.UserService;
import com.dg.patient.model.HealthcareproviderModel;
import com.dg.patient.model.HospitalFilterModel;
import com.dg.patient.model.TreatmentModel;
import com.dg.patient.model.TreatmentSearchModel;

/**
 * Handles requests for the application home page.
 * 
 * @author DoctorGlobe
 */
@Controller
public class HomeController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private SearchService searchService;

	@Autowired
	private HealthcareproviderResultService healthcareproviderResultService;

	@Autowired
	private RankingCalculationService rankingService;

	@Autowired
	private UserService userService;

	@Autowired
	private OriginPriceCalculationService orignPriceService;

	/**
	 * Handle home action
	 * @param error
	 * @param loginform
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(
			@RequestParam(value = "error", required = false) Integer error,
			LoginForm loginform, Model model) {
		if (userService.isLoggedIn()) {
			model.asMap().clear();
			return "redirect:/search";
		}
		model.addAttribute("loginform", loginform);
		model.addAttribute("loginerror", error);
		
		return "index";
	}

	/**
	 * Handle user login post action
	 * @param loginform
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String authentication(@Valid LoginForm loginform,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during user authentication", bindingResult.getErrorCount());
			return "index";
		}
		return "null";
	}

	/**
	 * handle logout action
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
		logger.info("user logout controller called");
	}

	/**
	 * handle search page action
	 * @param searchForm
	 * @param model
	 * @return string 
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(SearchForm searchForm, Model model) {
		return "search_new";
	}

	/**
	 * handle search post action
	 * @param searchForm the search form
	 * @param bindingResult the spring framework validation binding result
	 * @param redirectAttributes
	 * @param model
	 * @return string redirect to healthcareproviders result page
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String validateSearch(@Valid SearchForm searchForm,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during search", bindingResult.getErrorCount());
			model.addAttribute("error", 1);
			return "search_new";
		}
		redirectAttributes.addAttribute("treatment", searchForm.getId());
		
		return "redirect:/healthcareproviders";
	}

	/**
	 * hospital results page action
	 * @param treatment the unique id of treatement
	 * @param customer the unique id of customer
	 * @param model the spring ui model
	 * @param searchForm the search form
	 * @return string hospital result page
	 */
	@RequestMapping(value = "/healthcareproviders", method = RequestMethod.GET)
	public String results(
				@RequestParam(value = "treatment", required = true) Integer treatment,
				@RequestParam(value = "customer", required = false) Integer customer,
				Model model, SearchForm searchForm) {
		logger.info("Searching for treatment with id {}", treatment);
		
		List<HealthcareproviderModel> limitedHospitalResult;
		HospitalFilterModel 		  filterModel;
		List<HealthcareproviderModel> healthcareproviders = searchService.healthcareproviders(treatment, userService.getCurrentUserId());
		Double 						  originPrice		  = orignPriceService.getOrginPrice(healthcareproviders, null, null);

		healthcareproviders   = healthcareproviderResultService.getUniqueHealthcareprovider(healthcareproviders, originPrice);
		healthcareproviders   = rankingService.setRanking(healthcareproviders, originPrice);
		limitedHospitalResult = healthcareproviderResultService.getLimitedHospitalResults(healthcareproviders, searchService.getResultLimit(), treatment);
		filterModel 		  = healthcareproviderResultService.getHospitalFilterModel(limitedHospitalResult);
		
		model.addAttribute("treatment", treatment);
		model.addAttribute("healthcareproviders", limitedHospitalResult);
		model.addAttribute("totalhealthcareproviders", healthcareproviders.size());
		model.addAttribute("limitExceed", healthcareproviderResultService.getLimitExceed(treatment));
		model.addAttribute("sortingVal", "rankings");
		model.addAttribute("limit", 1);
		model.addAttribute("forcorporate", userService.getIsCorporatePatient());
		model.addAttribute("filterModel", filterModel);
		model.addAttribute("volumeMap", healthcareproviderResultService.getVolumeMap());
		model.addAttribute("viewmore", healthcareproviderResultService.getViewMore(healthcareproviders.size(), 1));
		
		Double distanceMin 	 = filterModel.getDistanceList() != null ? Collections.min(filterModel.getDistanceList()) : 0.0;
		Double distanceMax 	 = filterModel.getDistanceList() != null ? Collections.max(filterModel.getDistanceList()) : 0.0;

		Double estimatedCostMin = filterModel.getEstimatedCostSet() != null ? Collections.min(filterModel.getEstimatedCostSet()) : 0.0;
		Double estimatedCostMax = filterModel.getEstimatedCostSet() != null ? Collections.max(filterModel.getEstimatedCostSet()) : 0.0;
		Double bonusMin		 = filterModel.getBonusSet() != null ? Collections.min(filterModel.getBonusSet()) : 0.0;
		Double bonusMax		 = filterModel.getBonusSet() != null ? Collections.max(filterModel.getBonusSet()) : 0.0;
		String currency	     = filterModel.getCurrency() != null ? filterModel.getCurrency() : "USD";
		Double flightHourMin = filterModel.getFlighthourList() != null ? Collections.min(filterModel.getFlighthourList()) : 0.0;
		Double flightHourMax = filterModel.getFlighthourList() != null ? Math.ceil(Collections.max(filterModel.getFlighthourList())) : 0.0;
		
		model.addAttribute("distancemin", distanceMin);
		model.addAttribute("distancemax", distanceMax);
		model.addAttribute("estimatedcostmin", estimatedCostMin);
		model.addAttribute("estimatedcostmax", estimatedCostMax);
		model.addAttribute("bonusmax", bonusMax);
		model.addAttribute("bonusmin", bonusMin);
		model.addAttribute("currency", currency);
		model.addAttribute("flighthourmin", flightHourMin);
		model.addAttribute("flighthourmax", flightHourMax);
		model.addAttribute("originPrice", originPrice);
		
		return "healthcareproviders_new";
	}

	/**
	 * autocomplete treatment search action
	 */
	@RequestMapping(value = "/autocomplete/search", method = RequestMethod.GET)
	public @ResponseBody List<TreatmentModel> getTreatmentModel(
			@RequestParam(value = "name", required = true) String name) {
		List<TreatmentSearchModel> treatmentList = searchService.getTreatments(name);
		List<TreatmentModel> withoutGeneralTreatmentList = searchService.getWithoutGeneralTreatmentList(treatmentList);
		
		return withoutGeneralTreatmentList;
	}

	/**
	 * 
	 * handle ajax list of healthcareproviders action	 
	 * @param treatment the unique id of treatment
	 * @param regionFilter the list of selected region filter
	 * @param amenityFilter the list of selected amenity filter
	 * @param equipmentFilter the list of selected equipment filter
	 * @param volumeFilter the list of selected volume filter
	 * @param distanceFilter the double value of selected distance filter
	 * @param priceFilter the double value of selected price filter
	 * @param sortingFilter the string value of selected sorting filter
	 * @param textFilter the string value of selected text filter
	 * @param filterSelected the boolean value of selected filter
	 * @param sliderChange the boolean value of slider change filter
	 * @param limit the integer value of limit
	 * @param reset the boolean value of reset
	 * @param flighthourFilter the double value of selected flight hour
	 * @param model
	 * @return string 
	 */
	@RequestMapping(value = "/refreshItem", method = RequestMethod.POST)
	public String getHealthcareproviderModel(
			@RequestParam(value = "treatment", required = true) Integer treatment,
			@RequestParam(value = "regionFilter[]", required = false) List<String> regionFilter,
			@RequestParam(value = "amenityFilter[]", required = false) List<String> amenityFilter,
			@RequestParam(value = "equipmentFilter[]", required = false) List<String> equipmentFilter,
			@RequestParam(value = "volumeFilter[]", required = false) List<String> volumeFilter,
			@RequestParam(value = "distanceFilter", required = true) Double distanceFilter,
			@RequestParam(value = "priceFilter", required = false) Double priceFilter,
			@RequestParam(value = "sortingFilter", required = false) String sortingFilter,
			@RequestParam(value = "textFilter", required = false) String textFilter,
			@RequestParam(value = "filterSelected", required = false) Boolean filterSelected,
			@RequestParam(value = "sliderChange", required = false) Boolean sliderChange,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "reset", required = false) Boolean reset,
			@RequestParam(value = "flighthourFilter", required = true) Double flighthourFilter,
			Model model) {
		
		logger.info("Searching for treatment with id {}", treatment);
		
		List<HealthcareproviderModel> limitedHospitalResult;
		HospitalFilterModel 		  filterModel;
		List<HealthcareproviderModel> healthcareproviders = searchService.healthcareproviders(treatment, userService.getCurrentUserId());
		Double 						  originPrice 		  = orignPriceService.getOrginPrice(healthcareproviders, null, null);
		
		healthcareproviders   = healthcareproviderResultService.getFilteredHealthcareprovider(healthcareproviders, regionFilter, amenityFilter, volumeFilter, 
										distanceFilter, priceFilter, sortingFilter, textFilter, filterSelected, sliderChange, limit, reset, flighthourFilter,
										originPrice);
		healthcareproviders   = rankingService.setRanking(healthcareproviders, originPrice);
		healthcareproviders   = healthcareproviderResultService.getSortBy(healthcareproviders, sortingFilter);
		limitedHospitalResult = healthcareproviderResultService.getLimitedHospitalResults(healthcareproviders, limit * searchService.getResultLimit(), treatment);
		filterModel 		  = healthcareproviderResultService.getHospitalFilterModel(limitedHospitalResult);
		
		model.addAttribute("healthcareproviders", limitedHospitalResult);
		model.addAttribute("totalhealthcareproviders", healthcareproviders.size());
		model.addAttribute("filterModel", filterModel);
		model.addAttribute("volumeMap", healthcareproviderResultService.getVolumeMap());
		model.addAttribute("sortingVal", sortingFilter);
		model.addAttribute("sliderChange", sliderChange);
		model.addAttribute("forcorporate", userService.getIsCorporatePatient());
		model.addAttribute("limit", limit);
		model.addAttribute("treatment", treatment);
		model.addAttribute("limitExceed", healthcareproviderResultService.getLimitExceed(treatment));
		model.addAttribute("viewmore", healthcareproviderResultService.getViewMore(healthcareproviders.size(), limit));
		model.addAttribute("originPrice", originPrice);
		
		return "fragments/result_new :: result";
	}

	/**
	 * handle healthcareprovider location map action
	 * @param id the unique id of healthcareprovider
	 * @param location the address of healthcareprovider
	 * @param lat the latitude of healthcareprovider
	 * @param lon the longitude of healthcareprovider 
	 * @param model the spring ui model
	 * @return string map page
	 */
	@RequestMapping(value = "/healthcareprovider-map", method = RequestMethod.GET)
	public String getHealthcareproviderMap(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "location", required = true) String location,
			@RequestParam(value = "lat", required = true) String lat,
			@RequestParam(value = "lon", required = true) String lon,
			Model model) {
		model.addAttribute("id", id);
		model.addAttribute("location", location);
		model.addAttribute("lat", lat);
		model.addAttribute("lon", lon);
		
		return "map";
	}

	/**
	 * handle associate get action
	 * @param id
	 * @param request
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/associate", method = RequestMethod.GET)
	public String setAssociate(
			@RequestParam(value = "id", required = true) BigInteger id,
			HttpServletRequest request, Model model) {
		model.asMap().clear();
		if (userService.getAssociateUser() && id != null) {
			userService.loadUserById(id, userService.getCurrentUrl(request));
			return "redirect:/search";
		}
		return "redirect:/";
	}

	/**
	 * handle admin-area get action
	 * @param brokerUserForm
	 * @param model
	 * @param request
	 * @return admin-area page
	 */
	@RequestMapping(value = "/admin-area", method = RequestMethod.GET)
	public String getAdminArea(BrokerUserForm brokerUserForm, Model model,
			HttpServletRequest request) {
		logger.info("associate id = {}", userService.getAssociateId());
		if (userService.getAssociateId() != null) {
			userService.loadAssociationUserById(userService.getAssociateId(), userService.getCurrentUrl(request));
		}
		if (!userService.getAssociateUser()) {
			model.asMap().clear();
			return "redirect:/";
		}
		model.addAttribute("paginationLimit", userService.getAdminUserPaginationLimit());
		model.addAttribute("companyList", userService.getCorporatecompanyList(userService.getCurrentUserId()));
		model.addAttribute("brokerUserform", brokerUserForm);
		
		return "admin-area";
	}

	/**
	 * handle admin-area post action
	 * @param brokerUserForm
	 * @param model
	 * @return String admin-area page
	 */
	@RequestMapping(value = "/admin-area", method = RequestMethod.POST)
	public String getAdminAreaData(BrokerUserForm brokerUserForm, Model model) {
		if (!userService.getAssociateUser()) {
			model.asMap().clear();
			return "redirect:/";
		}
		model.addAttribute("paginationLimit", userService.getAdminUserPaginationLimit());
		model.addAttribute("patientList", userService.getCorporateCompanyPatientList(brokerUserForm.getSearch(), brokerUserForm.getCorporatecompany()));
		model.addAttribute("companyList", userService.getCorporatecompanyList(userService.getCurrentUserId()));
		model.addAttribute("brokerUserform", brokerUserForm);
		
		return "admin-area";
	}

}