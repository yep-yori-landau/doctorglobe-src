package com.dg.hospital.controller;
import java.io.File;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.hospital.form.ChangePasswordForm;
import com.dg.hospital.form.ChangePasswordFormValidator;
import com.dg.hospital.form.FacilityForm;
import com.dg.hospital.form.HospitalForm;
import com.dg.hospital.form.HospitalTechnologyForm;
import com.dg.hospital.form.HospitalityForm;
import com.dg.hospital.form.InsuranceForm;
import com.dg.hospital.form.ProfileForm;
import com.dg.hospital.form.RatingForm;
import com.dg.hospital.form.TechnologyForm;
import com.dg.hospital.form.UploadFileForm;
import com.dg.hospital.model.CityModel;
import com.dg.hospital.model.EquipmentModel;
import com.dg.hospital.model.RatingcompaniesModel;
import com.dg.hospital.model.StateModel;
import com.dg.hospital.model.User;
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
	
	@Autowired
	private ChangePasswordFormValidator changePasswordFormValidator;
	
	/**
	 * index action
	 */
	@RequestMapping(value = "/home/index", method = RequestMethod.GET)
	public String indexAction(HospitalForm hospitalForm,Model model) {
		model.addAttribute("hospitalForm", hospitalService.getHospital(userService.getCurrentHealthcareprovider()));
		model.addAttribute("countryList", hospitalService.getCountryByAsc());
		model.addAttribute("branchList", hospitalService.getAllHospital());
		model.addAttribute("chainList", hospitalService.getAllChain());
		model.addAttribute("currencyList", hospitalService.getAllCurrency());
		return "home/index";
	}
	
	/**
	 * index action
	 */
	@RequestMapping(value = "/home/index", method = RequestMethod.POST)
	public String indexPostAction(@Valid HospitalForm hospitalForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {
		model.addAttribute("countryList", hospitalService.getCountry());
		model.addAttribute("branchList", hospitalService.getAllHospital());
		model.addAttribute("chainList", hospitalService.getAllChain());
		model.addAttribute("currencyList", hospitalService.getAllCurrency());
		if(results.hasErrors()){	
			logger.info("error found during submit hospitality form = {}",results.getAllErrors());
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
		model.addAttribute("healthcareprovider", userService.getCurrentHealthcareprovider());
		model.addAttribute("equipmentsMap", equipmentsMap);		
		model.addAttribute("equipmentList", equipmentModelList);
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
		model.addAttribute("healthcareprovider", userService.getCurrentHealthcareprovider());
		model.addAttribute("equipmentsMap", equipmentsMap);		
		model.addAttribute("equipmentList", equipmentModelList);
		boolean edited = hospitalService.editTechnology(technologyForm);
		if(edited){
			redirectAttributes.addFlashAttribute("success", "1");
			return "redirect:/home/technology";
		}
		technologyForm.setHospitalEquipmentModel(hospitalService.getHospitalEquipments(userService.getCurrentHealthcareprovider()));		
		return "home/technology";
	}
	
	/**
	 * delete technology action
	 */
	@RequestMapping(value = "/home/delete-technology", method = RequestMethod.GET)
	public String deleteTechnologyAction(@RequestParam(value = "id", required = true) BigInteger id,RedirectAttributes redirectAttributes) {
		if(id != null){
			if(hospitalService.deleteHospitalTechnology(id)){
				redirectAttributes.addFlashAttribute("success", "1");			
				return "redirect:/home/technology";
			}else{
				redirectAttributes.addFlashAttribute("error", "1");
				return "redirect:/home/technology";
			}
		}else{
			redirectAttributes.addFlashAttribute("error", "1");
			return "redirect:/home/technology";
		}		
	}
	
	/**
	 * facility action
	 */
	@RequestMapping(value = "/home/facility", method = RequestMethod.GET)
	public String facilityAction(FacilityForm facilityForm,Model model) {
		BigInteger healthcareprovider = userService.getCurrentHealthcareprovider();
		facilityForm.setHospitalModel(hospitalService.getHospital(healthcareprovider));
		facilityForm.setHospitalAccreditationFormModel(hospitalService.getHospitalAccreditationFormModel(healthcareprovider));
		facilityForm.setHospitaltypeFormModel(hospitalService.getHospitaltypeFormModel(healthcareprovider));
		facilityForm.setHospitalUnitFeatureFormModel(hospitalService.getHospitalUnitFeatureFormModel(healthcareprovider));
		model.addAttribute("branchList", hospitalService.getAllHospital());
		model.addAttribute("chainList", hospitalService.getAllChain());
		return "home/facility";
	}
	
	/**
	 * facility post action
	 */
	@RequestMapping(value = "/home/facility", method = RequestMethod.POST)
	public String facilityPostAction(@Valid FacilityForm facilityForm,BindingResult results,RedirectAttributes redirectAttributes,@RequestParam(value ="file",required = false) MultipartFile file,MultipartHttpServletRequest request,Model model) {
		Boolean found = false;		
		model.addAttribute("branchList", hospitalService.getAllHospital());
		model.addAttribute("chainList", hospitalService.getAllChain());
		if(results.hasErrors()){			
			model.addAttribute("error", 1);
			facilityForm.setHospitalModel(hospitalService.getHospital(userService.getCurrentHealthcareprovider()));
			facilityForm.setHospitalAccreditationFormModel(hospitalService.getHospitalAccreditationFormModel(userService.getCurrentHealthcareprovider()));
			facilityForm.setHospitaltypeFormModel(hospitalService.getHospitaltypeFormModel(userService.getCurrentHealthcareprovider()));
			facilityForm.setHospitalUnitFeatureFormModel(hospitalService.getHospitalUnitFeatureFormModel(userService.getCurrentHealthcareprovider()));
			logger.info("error found during submit facility form = {}",results.getErrorCount());			
			return "home/facility";
		}else{			
				try{
					if(!file.isEmpty()){
						if(file.getSize() >= 500000000){							
							  model.addAttribute("sizeerror", "1");
							  logger.info("File is too big for upload( max 500 MB files are supported");
						  }else if(!hospitalService.policyFileTypeValidate(file.getContentType())){
							  logger.info("file type ={}",file.getContentType());							  
							  model.addAttribute("typeerror", "1");
							  logger.info("Unsupported File Type");
						 }else{	
								  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
								  Date date = new Date();
								  String now = dateFormat.format(date).toString();
								  String filename = hospitalService.getSHA1(FilenameUtils.removeExtension(file.getOriginalFilename())+now)+'.'+FilenameUtils.getExtension(file.getOriginalFilename());
								  File fileDir = new File(hospitalService.getRestUrlService().getUploadPath()+"/hospital/"+userService.getCurrentHealthcareprovider()+"/policy");
								  if(!fileDir.exists()){
				    				  if(fileDir.mkdirs()){	    					  
				    					  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
				    					  file.transferTo(f);
				    					  found = true;
				    				  }else{				    					 
				    					  model.addAttribute("servererror", "1");
				    					  logger.info("Directory not created successfully.");
				    				  }
				    			  }else{
				    				  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
				    				  file.transferTo(f);
				    				  found = true;
				    			  }	
								  if(found){
									  facilityForm.getHospitalModel().setPolicyFile(filename);
								  }
						 }
						
						if(found){
							boolean edited = hospitalService.editFacility(facilityForm);
							facilityForm.setHospitalAccreditationFormModel(hospitalService.getHospitalAccreditationFormModel(userService.getCurrentHealthcareprovider()));
							facilityForm.setHospitaltypeFormModel(hospitalService.getHospitaltypeFormModel(userService.getCurrentHealthcareprovider()));
							facilityForm.setHospitalUnitFeatureFormModel(hospitalService.getHospitalUnitFeatureFormModel(userService.getCurrentHealthcareprovider()));
							if(edited){
								redirectAttributes.addFlashAttribute("success", "1");
								return "redirect:/home/facility";
							}
						}
					}else{					
						logger.info("hospital insurance cap ={}",facilityForm.getHospitalModel().getInsuranceCap());
						logger.info("hospital insurance cap ={}",facilityForm.getHospitalModel().getPolicyFile());
						boolean edited = hospitalService.editFacility(facilityForm);
						facilityForm.setHospitalAccreditationFormModel(hospitalService.getHospitalAccreditationFormModel(userService.getCurrentHealthcareprovider()));
						facilityForm.setHospitaltypeFormModel(hospitalService.getHospitaltypeFormModel(userService.getCurrentHealthcareprovider()));
						facilityForm.setHospitalUnitFeatureFormModel(hospitalService.getHospitalUnitFeatureFormModel(userService.getCurrentHealthcareprovider()));
						if(edited){
							redirectAttributes.addFlashAttribute("success", "1");
							return "redirect:/home/facility";
						}
					}
					
				  }catch(Exception ex){
						logger.info(ex.getMessage());  
				  }  
			}				
		facilityForm.setHospitalModel(hospitalService.getHospital(userService.getCurrentHealthcareprovider()));
		facilityForm.setHospitalAccreditationFormModel(hospitalService.getHospitalAccreditationFormModel(userService.getCurrentHealthcareprovider()));
		facilityForm.setHospitaltypeFormModel(hospitalService.getHospitaltypeFormModel(userService.getCurrentHealthcareprovider()));
		facilityForm.setHospitalUnitFeatureFormModel(hospitalService.getHospitalUnitFeatureFormModel(userService.getCurrentHealthcareprovider()));
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
		return "home/hospitality";
	}
	
	/**
	 * hospitality post action
	 */
	@RequestMapping(value = "/home/hospitality", method = RequestMethod.POST)
	public String hospitalityPostAction(@Valid HospitalityForm hospitalityForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {
		if(results.hasErrors()){			
			logger.info("error found during submit hospitality form = {}",results.getErrorCount());
			logger.info("form error = {}",results.getAllErrors());
			model.addAttribute("error", "1");
			hospitalityForm.setHospitalAmenityFormModel(hospitalService.getHospitalAmenityFormModel(userService.getCurrentHealthcareprovider()));
			hospitalityForm.setHospitalLanguageFormModel(hospitalService.getHospitalLanguageFormModel(userService.getCurrentHealthcareprovider()));
			hospitalityForm.setHospitalCuisineFormModel(hospitalService.getHospitalCuisineFormModel(userService.getCurrentHealthcareprovider()));
			return "home/hospitality";
		}else{
			boolean edited = hospitalService.editHospitality(hospitalityForm,userService.getCurrentHealthcareprovider());
			hospitalityForm.setHospitalCuisineFormModel(hospitalService.getHospitalCuisineFormModel(userService.getCurrentHealthcareprovider()));
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				return "redirect:/home/hospitality";
			}else{
				redirectAttributes.addFlashAttribute("error", "1");
				return "redirect:/home/hospitality";
			}
		}		
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
		ratingForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		ratingForm.setReadmissionRate(hospitalService.getHospitalIntegerColumn(userService.getCurrentHealthcareprovider(),"readmission_rate"));
		ratingForm.setMortalityRate(hospitalService.getHospitalIntegerColumn(userService.getCurrentHealthcareprovider(),"mortality_rate"));
		ratingForm.setInfectionRate(hospitalService.getHospitalIntegerColumn(userService.getCurrentHealthcareprovider(),"infection_rate"));
		ratingForm.setMedicalLawsuit(hospitalService.getHospitalMedicalLawsuit(userService.getCurrentHealthcareprovider()));
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
			logger.info("all error during post rating form = {}",results.getAllErrors());
			ratingForm.setHospitalRatingsModel(hospitalService.getHospitalFormRatings(userService.getCurrentHealthcareprovider()));
			return "home/rating";
		}else{
			boolean edited = hospitalService.editHospitalRatings(ratingForm);
			ratingForm.setHospitalRatingsModel(hospitalService.getHospitalFormRatings(userService.getCurrentHealthcareprovider()));
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				return "redirect:/home/rating";
			}else{
				redirectAttributes.addFlashAttribute("error", "1");
				return "redirect:/home/rating";
			}
		}		
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
	public String uploadAction(@RequestParam(value = "id", required = false) BigInteger id,@RequestParam(value = "is_primary", required = false) Integer is_primary,UploadFileForm uploadFileForm, Model model) {
		if(id != null){
			uploadFileForm = hospitalService.getUploadFileForm(id);			
			model.addAttribute("uploadFileForm", uploadFileForm);
		}else{
			uploadFileForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
			uploadFileForm.setIsPrimary(is_primary);
			uploadFileForm.setType("photo");
		}
		model.addAttribute("success", 0);
		return "home/upload";
	}
	
	/**
	 * upload photos action
	 */
	@RequestMapping(value = "/home/upload", method = RequestMethod.POST)
	public String uploadPostAction(@Valid UploadFileForm uploadFileForm, BindingResult bindingResult,RedirectAttributes redirectAttributes,@RequestParam(value ="file",required = false) MultipartFile file,MultipartHttpServletRequest request,Model model) {
		Boolean found = false;
		String path = null;
		model.addAttribute("success", 0);		
		if (bindingResult.hasErrors()) {    		  
  	      logger.error("Got {} errors during save healthcareproviderphoto", bindingResult.getErrorCount());  	    
  	      return "home/upload";
		} 
		if(uploadFileForm.getId() != null){
			  boolean result = hospitalService.editHospitalPhoto(uploadFileForm);
			  if(result){
				  path = "/doctorglobe-hospital/hospital/"+userService.getCurrentHealthcareprovider()+"/photo/"+uploadFileForm.getPath();
				  model.addAttribute("success", 1);
				  model.addAttribute("name", uploadFileForm.getName());				  
				  model.addAttribute("path", path);
				  model.addAttribute("description", uploadFileForm.getDescription());				  
			  }
		}
		else if(!file.isEmpty()){
			  try{
				  if(file.getSize() >= 500000000){
					  model.addAttribute("errors", 1);
					  model.addAttribute("sizeerror", "1");
					  logger.info("File is too big for upload( max 500 MB files are supported");
				  }else if(!hospitalService.fileTypeValidate(file.getContentType())){
					  logger.info("file type ={}",file.getContentType());
					  model.addAttribute("errors", 1);
					  model.addAttribute("typeerror", "1");
					  logger.info("Unsupported File Type");
				  }else{
					  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					  Date date = new Date();
					  String now = dateFormat.format(date).toString();
					  String filename = hospitalService.getSHA1(FilenameUtils.removeExtension(file.getOriginalFilename())+now)+'.'+FilenameUtils.getExtension(file.getOriginalFilename());
					  File fileDir = new File(hospitalService.getRestUrlService().getUploadPath()+"/hospital/"+userService.getCurrentHealthcareprovider()+"/photo");
					  if(!fileDir.exists()){
	    				  if(fileDir.mkdirs()){	    					  
	    					  
	    					  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
	    					  file.transferTo(f);
	    					  found = true;
	    				  }else{
	    					  model.addAttribute("errors", 1);
	    					  model.addAttribute("servererror", "1");
	    					  logger.info("Directory not created successfully.");
	    				  }
	    			  }else{
	    				  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
	    				  file.transferTo(f);
	    				  found = true;
	    			  }			
					  if(found){
						  uploadFileForm.setPath(filename);			  
						  boolean result = hospitalService.editHospitalPhoto(uploadFileForm);
						  if(result){
							  path = "/doctorglobe-hospital/hospital/"+userService.getCurrentHealthcareprovider()+"/photo/"+uploadFileForm.getPath();
							  model.addAttribute("success", 1);
							  model.addAttribute("name", uploadFileForm.getName());
							  model.addAttribute("path", path);
							  model.addAttribute("description", uploadFileForm.getDescription());				  
						  }
					  }else{
						  model.addAttribute("errors", 1);
    					  model.addAttribute("servererror", "1");
    					  logger.info("Internal server error.");  
					  }
				  }
			  }catch(Exception ex){
				logger.info(ex.getMessage());  
			  }  
	  	}	
		return "home/upload";
	}	
	
	/**
	 * upload photos action
	 */
	@RequestMapping(value = "/home/uploadvideo", method = RequestMethod.GET)
	public String uploadVideoAction(@RequestParam(value = "id", required = false) BigInteger id,UploadFileForm uploadFileForm, Model model) {
		if(id != null){
			uploadFileForm = hospitalService.getUploadFileForm(id);			
			model.addAttribute("uploadFileForm", uploadFileForm);
		}else{
			uploadFileForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
			uploadFileForm.setIsPrimary(0);
			uploadFileForm.setType("video");
		}
		model.addAttribute("success", 0);
		return "home/uploadvideo";
	}
	
	/**
	 * upload photos action
	 */
	@RequestMapping(value = "/home/uploadvideo", method = RequestMethod.POST)
	public String uploadVideoPostAction(@Valid UploadFileForm uploadFileForm, BindingResult bindingResult,RedirectAttributes redirectAttributes,@RequestParam(value ="file",required = false) MultipartFile file,MultipartHttpServletRequest request,Model model) {
		Boolean found = false;
		String path = null;
		model.addAttribute("success", 0);
		if (bindingResult.hasErrors()) {    		  
  	      logger.error("Got {} errors during save healthcareproviderphoto", bindingResult.getErrorCount());  	    
  	      return "home/upload";
		} 
		if(uploadFileForm.getId() != null){
			  boolean result = hospitalService.editHospitalPhoto(uploadFileForm);
			  if(result){
				  path = "/doctorglobe-hospital/hospital/"+userService.getCurrentHealthcareprovider()+"/video/"+uploadFileForm.getPath();
				  model.addAttribute("success", 1);
				  model.addAttribute("path", path);
				  model.addAttribute("name", uploadFileForm.getName());
				  model.addAttribute("description", uploadFileForm.getDescription());				  
			  }
		}
		else if(!file.isEmpty()){
			  try{				  
				  if(file.getSize() >= 500000000){
					  model.addAttribute("errors", 1);
					  model.addAttribute("sizeerror", "1");
					  logger.info("File is too big for upload( max 500 MB files are supported");
				  }else{
					  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					  Date date = new Date();
					  String now = dateFormat.format(date).toString();
					  String filename = hospitalService.getSHA1(FilenameUtils.removeExtension(file.getOriginalFilename())+now)+'.'+FilenameUtils.getExtension(file.getOriginalFilename());					  
					  File fileDir = new File(hospitalService.getRestUrlService().getUploadPath()+"/hospital/"+userService.getCurrentHealthcareprovider()+"/video");
					  if(!fileDir.exists()){
	    				  if(fileDir.mkdirs()){	    					  
	    					  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
	    					  file.transferTo(f);
	    					  found = true;
	    				  }else{
	    					  model.addAttribute("errors", 1);
	    					  model.addAttribute("servererror", "1");
	    					  logger.info("Directory not created successfully.");
	    				  }
	    			  }else{
	    				  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
	    				  file.transferTo(f);
	    				  found = true;
	    			  }	
					  if(found){
						  uploadFileForm.setPath(filename);			  
						  boolean result = hospitalService.editHospitalPhoto(uploadFileForm);
						  if(result){
							  path = "/doctorglobe-hospital/hospital/"+userService.getCurrentHealthcareprovider()+"/video/"+uploadFileForm.getPath();
							  model.addAttribute("success", 1);
							  model.addAttribute("path", path);
							  model.addAttribute("name", uploadFileForm.getName());
							  model.addAttribute("description", uploadFileForm.getDescription());				  
						  }
					  }else{
						  model.addAttribute("errors", 1);
    					  model.addAttribute("servererror", "1");
    					  logger.info("Internal server error.");
					  }
				  }
			  }catch(Exception ex){
				logger.info(ex.getMessage());  
			  }  
	  	}	
		return "home/uploadvideo";
	}
	
	/**
	 * delete photos action
	 */
	@RequestMapping(value = "/home/deletephoto", method = RequestMethod.GET)
	public String deletePhotoAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "v", required = true) Integer video,UploadFileForm uploadFileForm, Model model) {
		if(id != null){
			uploadFileForm = hospitalService.getUploadFileForm(id);
			model.addAttribute("video", video);
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
				if(uploadFileForm.getType().equalsIgnoreCase("video")){
					String filePath = hospitalService.getRestUrlService().getUploadPath()+"/hospital/"+userService.getCurrentHealthcareprovider()+"/video/"+uploadFileForm.getPath();
					hospitalService.deleteFile(filePath);
				}else{
					String filePath = hospitalService.getRestUrlService().getUploadPath()+"/hospital/"+userService.getCurrentHealthcareprovider()+"/photo/"+uploadFileForm.getPath();
					hospitalService.deleteFile(filePath);
				}
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
	 
	 @RequestMapping(value = "/equipment", method = RequestMethod.GET)
	 public @ResponseBody List<EquipmentModel> getAllEquipments(){
	     return hospitalService.getAllEquipments();       
	 }    
	 
	 @RequestMapping(value = "/home/healthcareprovider", method = RequestMethod.GET)
	 public String setCurrenctUserHealthcareprovider(@RequestParam(value = "id", required = false) BigInteger id,RedirectAttributes redirectAttributes){
		 if(userService.setCurrentHealthcareprovider(id)){
			 return "redirect:/home/index"; 
		 }
		 return "redirect:/home/index";
	 } 
	 
	@RequestMapping(value = "/home/profile",method = RequestMethod.GET)
	public String profileAction(ProfileForm profileForm,Model model){
		User userModel  = hospitalService.getUserModel(userService.getCurrentUserId());
		profileForm.setId(userService.getCurrentUserId());
		profileForm.setFirstName(userModel.getFirstName());
		profileForm.setLastName(userModel.getLastName());
		profileForm.setMobile(userModel.getMobile());
		return "home/profile";
	}
	
	@RequestMapping(value = "/home/profile",method = RequestMethod.POST)
	public String profilePostAction(@Valid ProfileForm profileForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
		if (bindingResult.hasErrors()) {
		      logger.error("Got {} errors during profile edited", bindingResult.getErrorCount());		  
		      return "home/profile";
		}
		Boolean edited = hospitalService.editUserDetail(profileForm);
		if(edited){
			redirectAttributes.addFlashAttribute("success", "1");
			return "redirect:/home/profile";	
		}
		return "home/profile";
	}
	
	@RequestMapping(value = "/home/changepassword",method = RequestMethod.GET)
	public String changePasswordAction(ChangePasswordForm changePasswordForm,Model model){		
		changePasswordForm.setId(userService.getCurrentUserId());				
		return "home/changepassword";
	}
	
	@RequestMapping(value = "/home/changepassword",method = RequestMethod.POST)
	public String changePasswordPostAction(@ModelAttribute ChangePasswordForm changePasswordForm,BindingResult bindingResult,Model model){		
		changePasswordFormValidator.validate(changePasswordForm, bindingResult);	
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during hospital user change password",
			bindingResult.getErrorCount());
			logger.error("message {}",bindingResult.getAllErrors());
			return "home/changepassword";
		}else{
			Boolean edited = hospitalService.changePassword(changePasswordForm);
			if(edited){				
				model.addAttribute("success", 1);					
			}else{
				model.addAttribute("error", 1);
			}
		}
		return "home/changepassword";
	}	
}
