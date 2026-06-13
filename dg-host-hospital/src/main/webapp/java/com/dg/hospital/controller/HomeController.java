package com.dg.hospital.controller;
import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.hospital.form.FacilityForm;
import com.dg.hospital.form.HospitalForm;
import com.dg.hospital.form.HospitalityForm;
import com.dg.hospital.form.InsuranceForm;
import com.dg.hospital.form.RatingForm;
import com.dg.hospital.form.TechnologyForm;
import com.dg.hospital.form.UploadFileForm;
import com.dg.hospital.model.CityModel;
import com.dg.hospital.model.EquipmentModel;
import com.dg.hospital.model.RatingcompaniesModel;
import com.dg.hospital.model.StateModel;
import com.dg.hospital.service.HospitalService;
import com.dg.hospital.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * index action
	 */
	@RequestMapping(value = "/home/index", method = RequestMethod.GET)
	public String indexAction(HospitalForm hospitalForm,Model model) {
		model.addAttribute("hospitalForm", hospitalService.getHospital(userService.getCurrentHealthcareprovider()));
		model.addAttribute("countryList", hospitalService.getCountry());
		model.addAttribute("branchList", hospitalService.getAllHospital());
		model.addAttribute("chainList", hospitalService.getAllChain());
		return "home/index";
	}
	
	/**
	 * index action
	 */
	@RequestMapping(value = "/home/index", method = RequestMethod.POST)
	public String indexPostAction(@Valid HospitalForm hospitalForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {
		if(results.hasErrors()){
			model.addAttribute("hospitalForm", hospitalService.getHospital(userService.getCurrentHealthcareprovider()));
			model.addAttribute("countryList", hospitalService.getCountry());
			logger.info("error found during submit hospitality form = {}",results.getErrorCount());
			model.addAttribute("error", 1);
			return "home/index";
		}else{
			boolean edited = hospitalService.editHospital(hospitalForm);
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				return "redirect:/home/index";
			}
		}
		
		return "home/index";
	}
	
	/**
	 * technology action
	 */
	@RequestMapping(value = "/home/technology", method = RequestMethod.GET)
	public String technologyAction(TechnologyForm technologyForm,Model model) {
		List<EquipmentModel> equipmentModelList = hospitalService.getAllEquipments();
		HashMap<BigInteger,String> equipmentsMap = new HashMap<BigInteger,String>();
		for(EquipmentModel equipmentModel : equipmentModelList){
			equipmentsMap.put(equipmentModel.getId(), equipmentModel.getName());
		}		
		model.addAttribute("equipmentsMap", equipmentsMap);		
		technologyForm.setHospitalEquipmentModel(hospitalService.getHospitalEquipments(userService.getCurrentHealthcareprovider()));		
		return "home/technology";
	}
	
	/**
	 * post technology action
	 */
	@RequestMapping(value = "/home/technology", method = RequestMethod.POST)
	public String technologyPostAction(TechnologyForm technologyForm,RedirectAttributes redirectAttributes,Model model) {		
		List<EquipmentModel> equipmentModelList = hospitalService.getAllEquipments();
		HashMap<BigInteger,String> equipmentsMap = new HashMap<BigInteger,String>();
		for(EquipmentModel equipmentModel : equipmentModelList){
			equipmentsMap.put(equipmentModel.getId(), equipmentModel.getName());
		}		
		model.addAttribute("equipmentsMap", equipmentsMap);
		boolean edited = hospitalService.editTechnology(technologyForm);
		if(edited){
			redirectAttributes.addFlashAttribute("success", "1");
			return "redirect:/home/technology";
		}
		technologyForm.setHospitalEquipmentModel(hospitalService.getHospitalEquipments(userService.getCurrentHealthcareprovider()));		
		return "home/technology";
	}
	
	/**
	 * facility action
	 */
	@RequestMapping(value = "/home/facility", method = RequestMethod.GET)
	public String facilityAction(FacilityForm facilityForm) {
		BigInteger healthcareprovider = userService.getCurrentHealthcareprovider();
		facilityForm.setHospitalAccreditationFormModel(hospitalService.getHospitalAccreditationFormModel(healthcareprovider));
		facilityForm.setHospitaltypeFormModel(hospitalService.getHospitaltypeFormModel(healthcareprovider));
		facilityForm.setHospitalUnitFeatureFormModel(hospitalService.getHospitalUnitFeatureFormModel(healthcareprovider));
		return "home/facility";
	}
	
	/**
	 * facility post action
	 */
	@RequestMapping(value = "/home/facility", method = RequestMethod.POST)
	public String facilityPostAction(@Valid FacilityForm facilityForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {		
		if(results.hasErrors()){			
			logger.info("error found during submit hospitality form = {}",results.getErrorCount());			
			facilityForm.setHospitalAccreditationFormModel(hospitalService.getHospitalAccreditationFormModel(userService.getCurrentHealthcareprovider()));
			facilityForm.setHospitaltypeFormModel(hospitalService.getHospitaltypeFormModel(userService.getCurrentHealthcareprovider()));
			facilityForm.setHospitalUnitFeatureFormModel(hospitalService.getHospitalUnitFeatureFormModel(userService.getCurrentHealthcareprovider()));
			return "home/facility";
		}else{
			boolean edited = hospitalService.editFacility(facilityForm);
			facilityForm.setHospitalAccreditationFormModel(hospitalService.getHospitalAccreditationFormModel(userService.getCurrentHealthcareprovider()));
			facilityForm.setHospitaltypeFormModel(hospitalService.getHospitaltypeFormModel(userService.getCurrentHealthcareprovider()));
			facilityForm.setHospitalUnitFeatureFormModel(hospitalService.getHospitalUnitFeatureFormModel(userService.getCurrentHealthcareprovider()));
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				return "redirect:/home/facility";
			}
		}				
		return "home/facility";
	}
	
	/**
	 * hospitality get action
	 */
	@RequestMapping(value = "/home/hospitality", method = RequestMethod.GET)
	public String hospitalityAction(HospitalityForm hospitalityForm,Model model) {
		hospitalityForm.setHospitalAmenityFormModel(hospitalService.getHospitalAmenityFormModel(userService.getCurrentHealthcareprovider()));
		hospitalityForm.setHospitalLanguageFormModel(hospitalService.getHospitalLanguageFormModel(userService.getCurrentHealthcareprovider()));
		hospitalityForm.setHospitalCuisineFormModel(hospitalService.getHospitalCuisineFormModel(userService.getCurrentHealthcareprovider()));
		model.addAttribute("currencyList", hospitalService.getAllCurrency());		
		return "home/hospitality";
	}
	
	/**
	 * hospitality post action
	 */
	@RequestMapping(value = "/home/hospitality", method = RequestMethod.POST)
	public String hospitalityPostAction(@Valid HospitalityForm hospitalityForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {
		if(results.hasErrors()){			
			logger.info("error found during submit hospitality form = {}",results.getErrorCount());
			hospitalityForm.setHospitalCuisineFormModel(hospitalService.getHospitalCuisineFormModel(userService.getCurrentHealthcareprovider()));
			return "home/hospitality";
		}else{
			boolean edited = hospitalService.editHospitality(hospitalityForm);
			hospitalityForm.setHospitalCuisineFormModel(hospitalService.getHospitalCuisineFormModel(userService.getCurrentHealthcareprovider()));
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				return "redirect:/home/hospitality";
			}
		}				
		return "home/hsopitalty";
	}
	
	/**
	 * insurance get action
	 */
	@RequestMapping(value = "/home/insurance", method = RequestMethod.GET)
	public String insuranceAction(InsuranceForm insuranceForm) {		
		insuranceForm.setHospitalInsuranceFormModel(hospitalService.getHospitalInsuranceFormModel(userService.getCurrentHealthcareprovider()));
		return "home/insurance";
	}
	
	/**
	 * insurance post action
	 */
	@RequestMapping(value = "/home/insurance", method = RequestMethod.POST)
	public String insurancePostAction(@Valid InsuranceForm insuranceForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {		
		if(results.hasErrors()){			
			logger.info("error found during post insurance form = {}",results.getErrorCount());
			insuranceForm.setHospitalInsuranceFormModel(hospitalService.getHospitalInsuranceFormModel(userService.getCurrentHealthcareprovider()));
			return "home/insurance";
		}else{
			boolean edited = hospitalService.editHospitalInsurance(insuranceForm);
			insuranceForm.setHospitalInsuranceFormModel(hospitalService.getHospitalInsuranceFormModel(userService.getCurrentHealthcareprovider()));
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				return "redirect:/home/insurance";
			}
		}				
		return "home/insurance";
	}
	
	/**
	 * rating action
	 */
	@RequestMapping(value = "/home/rating", method = RequestMethod.GET)
	public String ratingAction(RatingForm ratingForm,Model model) {
		List<RatingcompaniesModel> ratingcompaniesModelList = hospitalService.getAllRatingcompanies();
		HashMap<BigInteger,String> ratingcompaniesMap = new HashMap<BigInteger,String>();
		for(RatingcompaniesModel ratingcompaniesModel : ratingcompaniesModelList){
			ratingcompaniesMap.put(ratingcompaniesModel.getId(), ratingcompaniesModel.getName());
		}		
		model.addAttribute("ratingcompaniesMap", ratingcompaniesMap);		
		ratingForm.setHospitalRatingsModel(hospitalService.getHospitalFormRatings(userService.getCurrentHealthcareprovider()));
		return "home/rating";
	}
	
	/**
	 * insurance post action
	 */
	@RequestMapping(value = "/home/rating", method = RequestMethod.POST)
	public String ratingPostAction(@Valid RatingForm ratingForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {
		List<RatingcompaniesModel> ratingcompaniesModelList = hospitalService.getAllRatingcompanies();
		HashMap<BigInteger,String> ratingcompaniesMap = new HashMap<BigInteger,String>();
		for(RatingcompaniesModel ratingcompaniesModel : ratingcompaniesModelList){
			ratingcompaniesMap.put(ratingcompaniesModel.getId(), ratingcompaniesModel.getName());
		}		
		model.addAttribute("ratingcompaniesMap", ratingcompaniesMap);
		if(results.hasErrors()){			
			logger.info("error found during post rating form = {}",results.getErrorCount());
			ratingForm.setHospitalRatingsModel(hospitalService.getHospitalFormRatings(userService.getCurrentHealthcareprovider()));
			return "home/rating";
		}else{
			boolean edited = hospitalService.editHospitalRatings(ratingForm);
			ratingForm.setHospitalRatingsModel(hospitalService.getHospitalFormRatings(userService.getCurrentHealthcareprovider()));
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				return "redirect:/home/rating";
			}
		}				
		return "home/rating";
	}
	
	/**
	 * photos action
	 */
	@RequestMapping(value = "/home/photos", method = RequestMethod.GET)
	public String photosAction(Model model) {
		model.addAttribute("imagesList", hospitalService.getHospitalImages(userService.getCurrentHealthcareprovider()));
		return "home/photos";
	}
	
	/**
	 * upload photos action
	 */
	@RequestMapping(value = "/home/upload", method = RequestMethod.GET)
	public String uploadAction(@RequestParam(value = "id", required = false) BigInteger id,@RequestParam(value = "is_primary", required = false) Integer is_primary,@RequestParam(value = "type", required = false) String type,UploadFileForm uploadFileForm, Model model) {
		if(id != null){
			uploadFileForm = hospitalService.getUploadFileForm(id);			
			model.addAttribute("uploadFileForm", uploadFileForm);
		}else{
			uploadFileForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
			uploadFileForm.setIsPrimary(is_primary);
			uploadFileForm.setType(type);
		}
		model.addAttribute("success", 0);
		return "home/upload";
	}
	
	/**
	 * upload photos action
	 */
	@RequestMapping(value = "/home/upload", method = RequestMethod.POST)
	public String uploadPostAction(@Valid UploadFileForm uploadFileForm, BindingResult bindingResult,RedirectAttributes redirectAttributes,@RequestParam(value ="file",required = false) MultipartFile file,MultipartHttpServletRequest request,Model model) {
		if (bindingResult.hasErrors()) {    		  
  	      logger.error("Got {} errors during save healthcareproviderphoto", bindingResult.getErrorCount());  	    
  	      return "home/upload";
		} 
		if(uploadFileForm.getId() != null){
			  boolean result = hospitalService.editHospitalPhoto(uploadFileForm);
			  if(result){
				  model.addAttribute("success", 1);
				  model.addAttribute("path", uploadFileForm.getPath());
				  model.addAttribute("description", uploadFileForm.getDescription());				  
			  }
		}
		else if(!file.isEmpty()){
			  try{
				  String filename = file.getOriginalFilename();
				  File f = new File("/tmp/" +file.getOriginalFilename());
				  file.transferTo(f);			  	
				  uploadFileForm.setPath(filename);			  
				  boolean result = hospitalService.editHospitalPhoto(uploadFileForm);
				  if(result){
					  model.addAttribute("success", 1);
					  model.addAttribute("path", uploadFileForm.getPath());
					  model.addAttribute("description", uploadFileForm.getDescription());				  
				  }
			  }catch(Exception ex){
				logger.info(ex.getMessage());  
			  }  
	  	}	
		return "home/upload";
	}
	
	/**
	 * delete photos action
	 */
	@RequestMapping(value = "/home/deletephoto", method = RequestMethod.GET)
	public String deletePhotoAction(@RequestParam(value = "id", required = false) BigInteger id,UploadFileForm uploadFileForm, Model model) {
		if(id != null){
			uploadFileForm = hospitalService.getUploadFileForm(id);			
			model.addAttribute("uploadFileForm", uploadFileForm);
		}	
		return "home/deletephoto";
	}
	
	/**
	 * delete photos action
	 */
	@RequestMapping(value = "/home/deletephoto", method = RequestMethod.POST)
	public String deletePhotoPostAction(@Valid UploadFileForm uploadFileForm, Model model) {
		logger.info("delete hospital image id={}",uploadFileForm.getId());
		if(uploadFileForm.getId() != null){
			Integer edited = hospitalService.deleteHospitalPhoto(uploadFileForm.getId());
			if(edited > 0){
				model.addAttribute("success", 1);
			}
		}	
		return "home/deletephoto";
	}

	
	@RequestMapping(value = "/state/country/{country}", method = RequestMethod.GET)
	 public @ResponseBody List<StateModel> getStateByCountry(@PathVariable("country") int country){
	     return hospitalService.getStateByCountry(country);       
	 }    
	 
	 @RequestMapping(value = "/city/country/{country}", method = RequestMethod.GET)
	 public @ResponseBody List<CityModel> getCityByCountry(@PathVariable("country") int country){
	     return hospitalService.getCityByCountry(country);       
	 }    
	 
	 @RequestMapping(value = "/city/state/{state}", method = RequestMethod.GET)
	 public @ResponseBody List<CityModel> getCityByState(@PathVariable("state") int state){
	     return hospitalService.getCityByState(state);       
	 }    
	 
	 @RequestMapping(value = "/city/id/{id}", method = RequestMethod.GET)
	 public @ResponseBody CityModel getCityById(@PathVariable("id") int id){
	     return hospitalService.getCityById(id);       
	 } 
	
}
