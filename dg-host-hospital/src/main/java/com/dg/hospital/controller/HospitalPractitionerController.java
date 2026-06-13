package com.dg.hospital.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigInteger;

import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.hospital.form.HospitalPractitionerForm;
import com.dg.hospital.form.PractitionerAttestationsForm;
import com.dg.hospital.form.PractitionerLanguageForm;
import com.dg.hospital.form.PractitionerMethodForm;
import com.dg.hospital.form.PractitionerPhotoForm;
import com.dg.hospital.form.PractitionerStatsForm;
import com.dg.hospital.form.PractitionerTreatmentForm;
import com.dg.hospital.form.RemovePractitionerForm;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodPractitionerModel;
import com.dg.hospital.model.PractitionerModel;
import com.dg.hospital.service.HospitalPractitionerService;
import com.dg.hospital.service.UserService;
import com.dg.hospital.model.*;
import com.dg.hospital.model.form.PractitionerMethodFormModel;
import com.dg.hospital.model.form.PractitionerStatsFormModel;

@Controller
public class HospitalPractitionerController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalPractitionerController.class);
	
	@Autowired
	private HospitalPractitionerService hospitalPractitionerService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * index action
	*/
	@RequestMapping(value = "/home/practitioner", method = RequestMethod.GET)
	public String indexAction(Model model) {
		model.addAttribute("hospitalPractitionerList", hospitalPractitionerService.getHospitalPractitionerModel(userService.getCurrentHealthcareprovider()));
		model.addAttribute("specialtyList", hospitalPractitionerService.getHospitalPractitionerSpecialty(userService.getCurrentHealthcareprovider()));
		model.addAttribute("treatmentList", hospitalPractitionerService.getHospitalPractitionerTreatment(userService.getCurrentHealthcareprovider()));
		return "practitioner/index";
	}
	
	/**
	 * add action
	*/
	@RequestMapping(value = "/home/practitioner/add", method = RequestMethod.GET)
	public String addAction(HospitalPractitionerForm hospitalPractitionerForm,Model model) {		
		hospitalPractitionerForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		if(!hospitalPractitionerService.getHospitalCurrency(userService.getCurrentHealthcareprovider()).isEmpty()){
			hospitalPractitionerForm.setCurrency(hospitalPractitionerService.getHospitalCurrency(userService.getCurrentHealthcareprovider()));
		}		
		model.addAttribute("countryList", hospitalPractitionerService.getCountry());
		model.addAttribute("specialtyList", hospitalPractitionerService.getAllSpecialty());
		model.addAttribute("practitionertypeList", hospitalPractitionerService.getAllPractitionertype());
		return "practitioner/add";
	}
	
	/**
	 * add post action
	*/
	@RequestMapping(value = "/home/practitioner/add", method = RequestMethod.POST)	
	public String addPostAction(@Valid HospitalPractitionerForm hospitalPractitionerForm,BindingResult results,RedirectAttributes redirectAttributes,@RequestParam(value ="file",required = false) MultipartFile file,Model model) {
		Boolean found = false;
		model.addAttribute("countryList", hospitalPractitionerService.getCountry());
		model.addAttribute("specialtyList", hospitalPractitionerService.getAllSpecialty());
		model.addAttribute("practitionertypeList", hospitalPractitionerService.getAllPractitionertype());
		if(results.hasErrors()){			
			logger.info("error {}",results.getFieldErrors());
			model.addAttribute("error", "1");			
			return "practitioner/add";	
		}else{
			if(hospitalPractitionerService.isPractitionerAvailable(hospitalPractitionerForm.getEmail(),hospitalPractitionerForm.getHealthcareprovider())){
				try{
				if(!file.isEmpty()){
					if(file.getSize() >= 500000000){							
						  model.addAttribute("sizeerror", "1");
						  logger.info("File is too big for upload( max 500 MB files are supported");
					  }else if(!hospitalPractitionerService.policyFileTypeValidate(file.getContentType())){
						  logger.info("file type ={}",file.getContentType());							  
						  model.addAttribute("typeerror", "1");
						  logger.info("Unsupported File Type");
					 }else{							 		
						 	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						 	  Date date = new Date();
						 	  String now = dateFormat.format(date).toString();
						 	  String filename = hospitalPractitionerService.getSHA1(FilenameUtils.removeExtension(file.getOriginalFilename())+now)+'.'+FilenameUtils.getExtension(file.getOriginalFilename());
							  File fileDir = new File(hospitalPractitionerService.getRestUrlService().getUploadPath()+"/practitioner/"+hospitalPractitionerForm.getPractitioner()+"/policy");
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
								  hospitalPractitionerForm.setPolicyFile(filename);
								  Boolean edited = hospitalPractitionerService.addHospitalPractitioner(hospitalPractitionerForm);
								  if(edited){				
										redirectAttributes.addFlashAttribute("success", "1");										
										return "redirect:/home/practitioner";
								  }
							  }
					}
				}else{
					Boolean edited = hospitalPractitionerService.addHospitalPractitioner(hospitalPractitionerForm);
					if(!edited){
						model.addAttribute("error", "0");
					}else{
						redirectAttributes.addFlashAttribute("success", "1");
						return "redirect:/home/practitioner";
					}
				}
				}catch(Exception ex){
					logger.info("exception found ={}",ex.getMessage());
				}
			}else{
				model.addAttribute("error", "1");
				model.addAttribute("practitionererror", "1");
			}
		}		
		return "practitioner/add";
	}
	
	/**
	 * edit action
	*/
	@RequestMapping(value = "/home/practitioner/edit", method = RequestMethod.GET)
	public String editAction(@RequestParam(value = "id", required = true) BigInteger id,HospitalPractitionerForm hospitalPractitionerForm,Model model) {
		if(!hospitalPractitionerService.getHospitalCurrency(userService.getCurrentHealthcareprovider()).isEmpty()){
			hospitalPractitionerForm.setCurrency(hospitalPractitionerService.getHospitalCurrency(userService.getCurrentHealthcareprovider()));
		}else{
			hospitalPractitionerForm.setCurrency("USD");
		}
		hospitalPractitionerForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		HospitalPractitionerDetailModel hospitalPractitionerModel = hospitalPractitionerService.getHospitalPractitionerDetailIdByHospitalPractitioner(id, userService.getCurrentHealthcareprovider());
		PractitionerModel practitionerModel = hospitalPractitionerService.getPractitionerFormModelById(id, userService.getCurrentHealthcareprovider());
		
		hospitalPractitionerForm.setFormPopulate(hospitalPractitionerModel,practitionerModel);
		model.addAttribute("specialtyList", hospitalPractitionerService.getSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));		
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));
		model.addAttribute("practitionertypeList", hospitalPractitionerService.getAllPractitionertype());
		model.addAttribute("countryList", hospitalPractitionerService.getCountry());
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(id, userService.getCurrentHealthcareprovider()));
		return "practitioner/edit";
	}
	
	/**
	 * edit post action
	*/
	@RequestMapping(value = "/home/practitioner/edit", method = RequestMethod.POST)	
	public String editPostAction(@Valid HospitalPractitionerForm hospitalPractitionerForm,BindingResult results,RedirectAttributes redirectAttributes,@RequestParam(value ="file",required = false) MultipartFile file,Model model) {
		Boolean found = false;
		model.addAttribute("specialtyList", hospitalPractitionerService.getSpecialtyFormList(hospitalPractitionerForm.getPractitioner(),userService.getCurrentHealthcareprovider()));		
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(hospitalPractitionerForm.getPractitioner(),userService.getCurrentHealthcareprovider()));
		model.addAttribute("practitionertypeList", hospitalPractitionerService.getAllPractitionertype());
		model.addAttribute("id",hospitalPractitionerForm.getPractitioner());
		model.addAttribute("countryList", hospitalPractitionerService.getCountry());
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(hospitalPractitionerForm.getPractitioner(), userService.getCurrentHealthcareprovider()));
		if(results.hasErrors()){
			logger.info("error found = {}",results.getAllErrors());
			model.addAttribute("error", "0");
			return "practitioner/edit";
		}else{
			try{
				if(!file.isEmpty()){
					if(file.getSize() >= 500000000){							
						  model.addAttribute("sizeerror", "1");
						  logger.info("File is too big for upload( max 500 MB files are supported");
					  }else if(!hospitalPractitionerService.policyFileTypeValidate(file.getContentType())){
						  logger.info("file type ={}",file.getContentType());							  
						  model.addAttribute("typeerror", "1");
						  logger.info("Unsupported File Type");
					 }else{	
							  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							  Date date = new Date();
							  String now = dateFormat.format(date).toString();
						 	  String filename = hospitalPractitionerService.getSHA1(FilenameUtils.removeExtension(file.getOriginalFilename())+now)+'.'+FilenameUtils.getExtension(file.getOriginalFilename());
							  File fileDir = new File(hospitalPractitionerService.getRestUrlService().getUploadPath()+"/practitioner/"+hospitalPractitionerForm.getPractitioner()+"/policy");
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
			    				  logger.info("file paht {}",fileDir.getAbsolutePath());
			    				  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
			    				  file.transferTo(f);
			    				  found = true;
			    			  }	
							  if(found){
								  hospitalPractitionerForm.setPolicyFile(filename);
								  Boolean edited = hospitalPractitionerService.editHospitalPractitionerSpecialty(hospitalPractitionerForm);
								  if(edited){				
										redirectAttributes.addFlashAttribute("success", "1");
										redirectAttributes.addAttribute("id", hospitalPractitionerForm.getPractitioner());
										return "redirect:/home/practitioner/edit";
								  }
							  }
					}
				}else{
					Boolean edited = hospitalPractitionerService.editHospitalPractitionerSpecialty(hospitalPractitionerForm);
					if(edited){				
						redirectAttributes.addFlashAttribute("success", "1");
						redirectAttributes.addAttribute("id", hospitalPractitionerForm.getPractitioner());
						return "redirect:/home/practitioner/edit";
					}
				}
			}catch(Exception ex){
				logger.info("error found = {}",ex.getMessage());
			}
	    }			
		return "practitioner/edit";
	}
	
	/**
	 * medical action
	*/
	@RequestMapping(value = "/home/practitioner/medical", method = RequestMethod.GET)
	public String medicalAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerModel practitionerModel,Model model){
		model.addAttribute("practitionerModel", hospitalPractitionerService.getPractitionerById(id));
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(id, userService.getCurrentHealthcareprovider()));
		return "practitioner/medical";
	}
	
	/**
	 * medical action
	*/
	@RequestMapping(value = "/home/practitioner/medical", method = RequestMethod.POST)
	public String medicalPostAction(@Valid PractitionerModel practitionerModel,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(practitionerModel.getId(), userService.getCurrentHealthcareprovider()));
		model.addAttribute("id", practitionerModel.getId());
		if(bindingResult.hasErrors()){
			logger.info("error found during medical detail submit {}",bindingResult.getErrorCount());
			logger.info("error found during medical detail submit {}",bindingResult.getFieldError());
			redirectAttributes.addFlashAttribute("error", "1");
			redirectAttributes.addAttribute("id", practitionerModel.getId());
			return "redirect:/home/practitioner/medical";	
		}else{		
			Integer edited = hospitalPractitionerService.setPractitioner(practitionerModel);
			if(edited > 0){
				redirectAttributes.addFlashAttribute("success", "1");
				redirectAttributes.addAttribute("id", practitionerModel.getId());
				return "redirect:/home/practitioner/medical";
			}else{
				redirectAttributes.addFlashAttribute("error", "1");
				redirectAttributes.addAttribute("id", practitionerModel.getId());
				return "redirect:/home/practitioner/medical";
			}
		}
		//model.addAttribute("id", practitionerModel.getId());
	   // model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(practitionerModel.getId(), userService.getCurrentHealthcareprovider()));
		//return "practitioner/medical";
	}
	
	/**
	 * treatment action
	*/
	@RequestMapping(value = "/home/practitioner/treatment", method = RequestMethod.GET)
	public String treatmentAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "sp", required = false) BigInteger specialty,PractitionerTreatmentForm practitionerTreatmentForm,Model model){
		practitionerTreatmentForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		practitionerTreatmentForm.setPractitioner(id);
		if(specialty != null){
			practitionerTreatmentForm.setPractitionerSpecialty(specialty);
		}
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));
		model.addAttribute("id", id);		
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(id, userService.getCurrentHealthcareprovider()));
		return "practitioner/treatment";
	}
	
	/**
	 * treatment action
	*/
	@RequestMapping(value = "/home/practitioner/treatment", method = RequestMethod.POST)
	public String treatmentPostAction(@Valid PractitionerTreatmentForm practitionerTreatmentForm,RedirectAttributes redirectAttributes,Model model){
		Boolean result = hospitalPractitionerService.editPractitionerTreatment(practitionerTreatmentForm);
		if(result){
			redirectAttributes.addFlashAttribute("success", "1");
			redirectAttributes.addAttribute("id", practitionerTreatmentForm.getPractitioner());
			redirectAttributes.addAttribute("sp", practitionerTreatmentForm.getPractitionerSpecialty());
			return "redirect:/home/practitioner/treatment";
		}else{
			redirectAttributes.addFlashAttribute("error", "1");
			redirectAttributes.addAttribute("id", practitionerTreatmentForm.getPractitioner());
			redirectAttributes.addAttribute("sp", practitionerTreatmentForm.getPractitionerSpecialty());
			return "redirect:/home/practitioner/treatment";		
		}		
	}
	
	/**
	 * method action
	*/
	@RequestMapping(value = "/home/practitioner/method", method = RequestMethod.GET)
	public String methodAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "sp", required = false) BigInteger specialty,@RequestParam(value = "t", required = false) BigInteger treatment,PractitionerMethodForm practitionerMethodForm,Model model){
		practitionerMethodForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		practitionerMethodForm.setPractitioner(id);
		practitionerMethodForm.setPractitionerMethodFormModel(hospitalPractitionerService.getPractitionerMethodFormModel(null,null,userService.getCurrentHealthcareprovider(),id));
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));		
		if(specialty != null){					
			practitionerMethodForm.setSpecialty(specialty);
		}
		if(treatment != null){
			practitionerMethodForm.setTreatment(treatment);
		}
		model.addAttribute("methodList", hospitalPractitionerService.getAllMethod());		
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(id, userService.getCurrentHealthcareprovider()));		
		model.addAttribute("yearsList", hospitalPractitionerService.getYearsPracticedList());
		return "practitioner/method";
	}
	
	/**
	 * method action
	*/
	@RequestMapping(value = "/home/practitioner/method", method = RequestMethod.POST)
	public String methodPostAction(@Valid PractitionerMethodForm practitionerMethodForm,BindingResult results,RedirectAttributes redirectAttributes,Model model){
		redirectAttributes.addAttribute("id", practitionerMethodForm.getPractitioner());			
		redirectAttributes.addAttribute("sp", practitionerMethodForm.getSpecialty());
		redirectAttributes.addAttribute("t", practitionerMethodForm.getTreatment());
		if(results.hasErrors()){			
			logger.info("error found during submit practitioner method form = {}",results.getErrorCount());
			logger.info("error {}",results.getFieldErrors());
			redirectAttributes.addFlashAttribute("error", "1");			
			return "redirect:/home/practitioner/method";		
		}else{
			Boolean result = hospitalPractitionerService.editPractitionerMethod(practitionerMethodForm);
			if(result){
				redirectAttributes.addFlashAttribute("success", "1");								
				return "redirect:/home/practitioner/method";
			}else{
				redirectAttributes.addFlashAttribute("error", "1");								
				return "redirect:/home/practitioner/method";		
			}		
		}
	}
	
	/**
	 * language action
	*/
	@RequestMapping(value = "/home/practitioner/language", method = RequestMethod.GET)
	public String languageAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerLanguageForm practitionerLanguageForm,Model model) {
		practitionerLanguageForm.setPractitioner(id);
		practitionerLanguageForm.setPractitionerLanguageFormModel(hospitalPractitionerService.getPractitionerLanguageFormModel(id));
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(id, userService.getCurrentHealthcareprovider()));
		return "practitioner/language";
	}
	
	/**
	 * language post action
	*/
	@RequestMapping(value = "/home/practitioner/language", method = RequestMethod.POST)
	public String languagePostAction(@Valid PractitionerLanguageForm practitionerLanguageForm,RedirectAttributes redirectAttributes,Model model) {		
		Boolean edited = hospitalPractitionerService.editPractitionerLanguage(practitionerLanguageForm);		
		if(edited){			
				redirectAttributes.addFlashAttribute("success", "1");
				redirectAttributes.addAttribute("id", practitionerLanguageForm.getPractitioner());
				return "redirect:/home/practitioner/language";
		}		
		practitionerLanguageForm.setPractitionerLanguageFormModel(hospitalPractitionerService.getPractitionerLanguageFormModel(practitionerLanguageForm.getPractitioner()));
		model.addAttribute("id", practitionerLanguageForm.getPractitioner());		
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(practitionerLanguageForm.getPractitioner(), userService.getCurrentHealthcareprovider()));
		return "practitioner/language";
	}
	
	/**
	 * attestation action
	*/
	@RequestMapping(value = "/home/practitioner/attestation", method = RequestMethod.GET)
	public String attestationAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerAttestationsForm practitionerAttestationsForm,Model model) {
		practitionerAttestationsForm.setPractitioner(id);
		practitionerAttestationsForm.setPractitionerAttestationsFormModel(hospitalPractitionerService.getPractitionerAttestationsFormModel(id));
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(id, userService.getCurrentHealthcareprovider()));
		return "practitioner/attestation";
	}
	
	/**
	 * attestation post action
	*/
	@RequestMapping(value = "/home/practitioner/attestation", method = RequestMethod.POST)
	public String attestationPostAction(@Valid PractitionerAttestationsForm practitionerAttestationsForm,RedirectAttributes redirectAttributes,Model model) {		
		Boolean edited = hospitalPractitionerService.editPractitionerAttestations(practitionerAttestationsForm);		
		if(edited){			
				redirectAttributes.addFlashAttribute("success", "1");
				redirectAttributes.addAttribute("id", practitionerAttestationsForm.getPractitioner());
				return "redirect:/home/practitioner/attestation";
		}		
		practitionerAttestationsForm.setPractitionerAttestationsFormModel(hospitalPractitionerService.getPractitionerAttestationsFormModel(practitionerAttestationsForm.getPractitioner()));
		model.addAttribute("id", practitionerAttestationsForm.getPractitioner());
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(practitionerAttestationsForm.getPractitioner(), userService.getCurrentHealthcareprovider()));		
		return "practitioner/attestation";
	}
	
	/**
	 * stats action
	*/
	@RequestMapping(value = "/home/practitioner/stats", method = RequestMethod.GET)
	public String statsAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "sp", required = false) BigInteger specialty,@RequestParam(value = "t", required = false) BigInteger treatment,@RequestParam(value = "m", required = false) BigInteger method,PractitionerStatsForm practitionerStatsForm,Model model) {
		practitionerStatsForm.setPractitioner(id);
		practitionerStatsForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		if(specialty != null){
			practitionerStatsForm.setSpecialty(specialty);
		}
		if(treatment != null){
			practitionerStatsForm.setTreatment(treatment);
		}
		if(method != null){
			practitionerStatsForm.setMethod(method);
		}
		model.addAttribute("practitionerSpecialtyList", hospitalPractitionerService.getPractitionerSpecialtyFormList(id,userService.getCurrentHealthcareprovider()));	
		model.addAttribute("id", id);
		model.addAttribute("practitionerDetail", hospitalPractitionerService.getPractitionerFormModelById(id, userService.getCurrentHealthcareprovider()));
		return "practitioner/stats";
	}
	
	/**
	 * stats action
	*/
	@RequestMapping(value = "/home/practitioner/stats", method = RequestMethod.POST)
	public String statsPostAction(@Valid PractitionerStatsForm practitionerStatsForm,RedirectAttributes redirectAttributes,Model model) {		
		Boolean edited = hospitalPractitionerService.editHospitalSpecialtyTreatmentMethodPractitionerStat(practitionerStatsForm);
		redirectAttributes.addAttribute("id", practitionerStatsForm.getPractitioner());		
		redirectAttributes.addAttribute("sp", practitionerStatsForm.getSpecialty());
		redirectAttributes.addAttribute("t", practitionerStatsForm.getTreatment());
		redirectAttributes.addAttribute("m", practitionerStatsForm.getMethod());
		if(edited){
			redirectAttributes.addFlashAttribute("success", "1");			
			return "redirect:/home/practitioner/stats";
		}else{
			redirectAttributes.addFlashAttribute("error", "1");
			return "redirect:/home/practitioner/stats";
		}
	}
	
	@RequestMapping(value = "/home/practitioner/photo", method = RequestMethod.GET)
	public String photoAction(@RequestParam(value = "id", required = true) BigInteger id,PractitionerPhotoForm practitionerPhotoForm,Model model) {
		practitionerPhotoForm.setId(id);
		model.addAttribute("success", 0);
		return "practitioner/photo";
	}
	
	@RequestMapping(value = "/home/practitioner/photo", method = RequestMethod.POST)
	public String photoAction(@Valid PractitionerPhotoForm practitionerPhotoForm,BindingResult bindingResult,RedirectAttributes redirectAttributes,@RequestParam(value ="file",required = false) MultipartFile file,MultipartHttpServletRequest request,Model model) {
		model.addAttribute("success", 0);
		Boolean found =false;
		if (bindingResult.hasErrors()) {    		  
	  	      logger.error("Got {} errors during save practitioner photo", bindingResult.getErrorCount());  	    
	  	      return "practitioner/photo";
		}		
		if(!file.isEmpty() && practitionerPhotoForm.getId() != null){
			  try{
				  if(file.getSize() >= 500000000){							
					  model.addAttribute("sizeerror", "1");
					  model.addAttribute("errors", "1");
					  logger.info("File is too big for upload( max 500 MB files are supported");
				  }else if(!hospitalPractitionerService.fileTypeValidate(file.getContentType())){
					  logger.info("file type ={}",file.getContentType());						
					  model.addAttribute("errors", "1");
					  model.addAttribute("typeerror", "1");
					  logger.info("Unsupported File Type");
				 }else{
					  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				 	  Date date = new Date();
				 	  String now = dateFormat.format(date).toString();
				 	  String filename = hospitalPractitionerService.getSHA1(FilenameUtils.removeExtension(file.getOriginalFilename())+now)+'.'+FilenameUtils.getExtension(file.getOriginalFilename());
					  File fileDir = new File(hospitalPractitionerService.getRestUrlService().getUploadPath()+"/practitioner/"+practitionerPhotoForm.getId()+"/photo");
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
						  PractitionerModel practitionerModel = hospitalPractitionerService.getPractitionerById(practitionerPhotoForm.getId());
						  hospitalPractitionerService.deleteFile(hospitalPractitionerService.getRestUrlService().getUploadPath()+"/practitioner/"+practitionerModel.getId()+"/photo/"+practitionerModel.getPhoto());
						  practitionerModel.setPhoto(filename);
						  BigInteger edited = hospitalPractitionerService.editPractitioner(practitionerModel);
						  logger.info("practitioner id {}",edited);
						  if(practitionerPhotoForm.getId().equals(edited)){
							  model.addAttribute("success", 1);
							  model.addAttribute("name", practitionerModel.getPhoto());
							  model.addAttribute("path", "/doctorglobe-doctor/practitioner/"+practitionerPhotoForm.getId()+"/photo/"+practitionerModel.getPhoto());					  				  
						  }
					  }
				 }
			  }catch(Exception ex){
				logger.info(ex.getMessage());  
			  }  
	  	}	
		return "practitioner/photo";
	}
	
	@RequestMapping(value = "/home/practitioner/delete", method = RequestMethod.GET)
	public String deleteAction(@RequestParam(value = "id", required = true) BigInteger id,RemovePractitionerForm removePractitionerForm,RedirectAttributes redirectAttributes) {
		if(id != null){
			removePractitionerForm.setId(id);
			removePractitionerForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());			
		}
		return "practitioner/delete";
	} 
	
	@RequestMapping(value = "/home/practitioner/delete", method = RequestMethod.POST)
	public String deleteAction(@Valid RemovePractitionerForm removePractitionerForm,RedirectAttributes redirectAttributes) {
		if(removePractitionerForm.getId() != null){					
			Boolean result = hospitalPractitionerService.removeHospitalPractitioner(removePractitionerForm.getId(),removePractitionerForm.getHealthcareprovider());
			if(result){
				redirectAttributes.addAttribute("id", removePractitionerForm.getId());
				redirectAttributes.addFlashAttribute("message", "1");
				return "redirect:/home/practitioner/delete";
			}
		}
		return "practitioner/delete";
	} 
	
	@RequestMapping(value = "/home/practitioner/active", method = RequestMethod.GET)
	public String activeAction(@RequestParam(value = "id", required = true) BigInteger id,RedirectAttributes redirectAttributes) {
		if(id != null){
			HospitalSpecialtyTreatmentMethodPractitionerModel model = hospitalPractitionerService.getHospitalSpecialtyTreatmentMethodPractitionerById(id);
			if(model.getId() != null){
				model.setActive(true);
				hospitalPractitionerService.setHospitalSpecialtyTreatmentMethodPractitioner(model);
				redirectAttributes.addFlashAttribute("active", "1");
				return "redirect:/home/practitioner";
			}
		}
		return "practitioner/index";
	} 
	
	@RequestMapping(value = "/home/practitioner/specialty-treatment", method = RequestMethod.GET)
	public @ResponseBody List<TreatmentModel> getTreatmentBySpecialty(@RequestParam(value = "practitioner", required = true) BigInteger practitioner,@RequestParam(value = "healthcareprovider", required = true) BigInteger healthcareprovider,@RequestParam(value = "specialty", required = true) BigInteger specialty){
		return hospitalPractitionerService.getTreatmentFormList(practitioner, healthcareprovider, specialty);
	}
	
	@RequestMapping(value = "/home/practitioner/specialty-other-treatment", method = RequestMethod.GET)
	public @ResponseBody List<TreatmentModel> getOtherTreatmentBySpecialty(@RequestParam(value = "practitioner", required = true) BigInteger practitioner,@RequestParam(value = "healthcareprovider", required = true) BigInteger healthcareprovider,@RequestParam(value = "specialty", required = true) BigInteger specialty){
		return hospitalPractitionerService.getOtherTreatmentFormList(practitioner, healthcareprovider, specialty);
	}
	
	@RequestMapping(value = "/home/practitioner/specialty-treatment-selected", method = RequestMethod.GET)
	public @ResponseBody List<TreatmentModel> getSelectedTreatmentBySpecialty(@RequestParam(value = "practitioner", required = true) BigInteger practitioner,@RequestParam(value = "healthcareprovider", required = true) BigInteger healthcareprovider,@RequestParam(value = "specialty", required = true) BigInteger specialty){
		return hospitalPractitionerService.getPractitionerTreatmentFormList(practitioner, healthcareprovider, specialty);
	}
	
	@RequestMapping(value = "/home/practitioner/specialty-treatment-method-selected", method = RequestMethod.GET)
	public @ResponseBody List<MethodModel> getSelectedMethodBySpecialtyTreatment(@RequestParam(value = "practitioner", required = true) BigInteger practitioner,@RequestParam(value = "healthcareprovider", required = true) BigInteger healthcareprovider,@RequestParam(value = "specialty", required = true) BigInteger specialty,@RequestParam(value = "treatment", required = true) BigInteger treatment){
		return hospitalPractitionerService.getPractitionerMethodFormList(practitioner, healthcareprovider, specialty, treatment);
	}
	
	@RequestMapping(value = "/home/practitioner/specialty-treatment-method", method = RequestMethod.GET)
	public @ResponseBody List<PractitionerMethodFormModel> getMethodBySpecialtyTreatment(@RequestParam(value = "practitioner", required = true) BigInteger practitioner,@RequestParam(value = "healthcareprovider", required = true) BigInteger healthcareprovider,@RequestParam(value = "specialty", required = true) BigInteger specialty,@RequestParam(value = "treatment", required = true) BigInteger treatment){
		return hospitalPractitionerService.getPractitionerMethodFormModel(specialty, treatment, healthcareprovider, practitioner);
	}
	
	@RequestMapping(value = "/home/practitioner/specialty-treatment-method-stats", method = RequestMethod.GET)
	public @ResponseBody List<PractitionerStatsFormModel> getStatsByHospitalPractitionerSpecialtyTreatmentMethod(@RequestParam(value = "practitioner", required = true) BigInteger practitioner,@RequestParam(value = "healthcareprovider", required = true) BigInteger healthcareprovider,@RequestParam(value = "specialty", required = true) BigInteger specialty,@RequestParam(value = "treatment", required = true) BigInteger treatment,@RequestParam(value = "method", required = true) BigInteger method){
		return hospitalPractitionerService.getPractitionerStatsFormModelList(specialty, treatment, method, practitioner, healthcareprovider);
	}	
}