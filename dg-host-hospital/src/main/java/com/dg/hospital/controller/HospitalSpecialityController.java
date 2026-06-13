package com.dg.hospital.controller;

import java.math.BigInteger;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.hospital.form.HospitalSpecialtyForm;
import com.dg.hospital.form.HospitalSpecialtyTreatmentForm;
import com.dg.hospital.form.HospitalSpecialtyTreatmentMethodForm;
import com.dg.hospital.form.HospitalSpecialtyTreatmentMethodPractitionerDetailForm;
import com.dg.hospital.form.HospitalSpecialtyTreatmentMethodPractitionerForm;
import com.dg.hospital.model.HospitalSpecialtyModel;
import com.dg.hospital.model.SpecialtyModel;
import com.dg.hospital.service.HospitalSpecialtyService;
import com.dg.hospital.service.UserService;

@Controller 
public class HospitalSpecialityController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalSpecialityController.class);
	
	@Autowired
	private HospitalSpecialtyService hospitalSpecialtyService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * index action
	*/
	@RequestMapping(value = "/home/specialty", method = RequestMethod.GET)
	public String indexAction(HospitalSpecialtyForm hospitalSpecialtyForm,Model model) {
		hospitalSpecialtyForm.setHealthcareprovider(userService.getCurrentHealthcareprovider());
		model.addAttribute("specialtyList", hospitalSpecialtyService.getSpecialtyFormList(userService.getCurrentHealthcareprovider()));		
		model.addAttribute("hospitalSpecialtyList", hospitalSpecialtyService.getHospitalSpecialtyFormList(userService.getCurrentHealthcareprovider()));
		return "specialty/index";
	}
	
	/**
	 * index post action
	*/
	@RequestMapping(value = "/home/specialty", method = RequestMethod.POST) 
	public String indexPostAction(@Valid HospitalSpecialtyForm hospitalSpecialtyForm,BindingResult results,RedirectAttributes redirectAttributes,Model model){
		logger.info("specialty list = {}",hospitalSpecialtyForm.getSpecialtyModel());
		logger.info("hospital specialty list = {}",hospitalSpecialtyForm.getHospitalSpecialty());
		if(results.hasErrors()){
			model.addAttribute("specialtyList", hospitalSpecialtyService.getSpecialtyFormList(userService.getCurrentHealthcareprovider()));		
			model.addAttribute("hospitalSpecialtyList", hospitalSpecialtyService.getHospitalSpecialtyFormList(userService.getCurrentHealthcareprovider()));
			logger.info("error found {}",results.getAllErrors());
		}else{			
			Boolean edited = hospitalSpecialtyService.editHospitalSpecialty(hospitalSpecialtyForm);			
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				return "redirect:/home/specialty";
			}
		}
		return "specialty/index";
	}
	
	/**
	 * specialty treatment action
	*/
	@RequestMapping(value = "/home/specialty-treatment", method = RequestMethod.GET)
	public String treatmentAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "sp", required = true) BigInteger specialty,HospitalSpecialtyTreatmentForm hospitalSpecialtyTreatmentForm,Model model) {
	    hospitalSpecialtyTreatmentForm.setHospitalSpecialtyModel(hospitalSpecialtyService.getHospitalSpecialtyById(id));
	    model.addAttribute("specialtyTreatmentList", hospitalSpecialtyService.getSpecialtyTreatmentFormList(id,specialty));
	    model.addAttribute("specialtyOtherTreatmentList", hospitalSpecialtyService.getSpecialtyOtherTreatmentFormList(id,specialty));
	    model.addAttribute("selectedTreatmentList", hospitalSpecialtyService.getSelectedTreatmentFormList(id));	    
		return "specialty/treatment";
	}
	
	/**
	 * specialty treatment post action
	*/
	@RequestMapping(value = "/home/specialty-treatment", method = RequestMethod.POST)
	public String treatmentPostAction(@Valid HospitalSpecialtyTreatmentForm hospitalSpecialtyTreatmentForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {
		model.addAttribute("specialtyTreatmentList", hospitalSpecialtyService.getSpecialtyTreatmentFormList(hospitalSpecialtyTreatmentForm.getHospitalSpecialtyModel().getId(),hospitalSpecialtyTreatmentForm.getHospitalSpecialtyModel().getSpecialty()));
	    model.addAttribute("selectedTreatmentList", hospitalSpecialtyService.getSelectedTreatmentFormList(hospitalSpecialtyTreatmentForm.getHospitalSpecialtyModel().getId()));
		if(results.hasErrors()){
			redirectAttributes.addFlashAttribute("error", "1");
			redirectAttributes.addAttribute("id", hospitalSpecialtyTreatmentForm.getHospitalSpecialtyModel().getId());
			redirectAttributes.addAttribute("sp", hospitalSpecialtyTreatmentForm.getHospitalSpecialtyModel().getSpecialty());
			logger.info("form submit error found {}",results.getAllErrors());
			return "redirect:/home/specialty-treatment";			
		}else{
			Boolean edited = hospitalSpecialtyService.editHospitalSpecialtyTreatment(hospitalSpecialtyTreatmentForm);
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");
				redirectAttributes.addAttribute("id", hospitalSpecialtyTreatmentForm.getHospitalSpecialtyModel().getId());
				redirectAttributes.addAttribute("sp", hospitalSpecialtyTreatmentForm.getHospitalSpecialtyModel().getSpecialty());				
				return "redirect:/home/specialty-treatment";
			}
		}		
		return "specialty/treatment";
	}
	
	/**
	 * specialty-treatment-method action
	*/
	@RequestMapping(value = "/home/specialty-treatment-method", method = RequestMethod.GET)
	public String methodAction(@RequestParam(value = "hs", required = true) BigInteger hs,@RequestParam(value = "t", required = true) BigInteger treatment,@RequestParam(value = "sp", required = true) BigInteger specialty,HospitalSpecialtyTreatmentMethodForm hospitalSpecialtyTreatmentMethodForm,Model model) {
		hospitalSpecialtyTreatmentMethodForm.setHealthcareproviderSpecialty(hs);
		hospitalSpecialtyTreatmentMethodForm.setTreatment(treatment);
		hospitalSpecialtyTreatmentMethodForm.setSpecialty(specialty);		
	    model.addAttribute("methodList", hospitalSpecialtyService.getMethodFormList(hs,treatment));
	    model.addAttribute("hospitalMethodList", hospitalSpecialtyService.getHospitalMethodFormList(hs,treatment));	    
		return "specialty/method";
	}
	
	/**
	 * specialty treatment post action
	*/
	@RequestMapping(value = "/home/specialty-treatment-method", method = RequestMethod.POST)
	public String methodPostAction(@Valid HospitalSpecialtyTreatmentMethodForm hospitalSpecialtyTreatmentMethodForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {
		model.addAttribute("methodList", hospitalSpecialtyService.getMethodFormList(hospitalSpecialtyTreatmentMethodForm.getHealthcareproviderSpecialty(),hospitalSpecialtyTreatmentMethodForm.getTreatment()));
	    model.addAttribute("hospitalMethodList", hospitalSpecialtyService.getHospitalMethodFormList(hospitalSpecialtyTreatmentMethodForm.getHealthcareproviderSpecialty(),hospitalSpecialtyTreatmentMethodForm.getTreatment()));	    
		if(results.hasErrors()){
			redirectAttributes.addFlashAttribute("error", "1");
			redirectAttributes.addAttribute("hs", hospitalSpecialtyTreatmentMethodForm.getHealthcareproviderSpecialty());				
			redirectAttributes.addAttribute("t", hospitalSpecialtyTreatmentMethodForm.getTreatment());
			redirectAttributes.addAttribute("sp", hospitalSpecialtyTreatmentMethodForm.getSpecialty());
			return "redirect:/home/specialty-treatment-method";
		}else{
			Boolean edited = hospitalSpecialtyService.editHospitalSpecialtyTreatmentMethod(hospitalSpecialtyTreatmentMethodForm);
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");				
				if(!hospitalSpecialtyService.getHospitalMethodFormList(hospitalSpecialtyTreatmentMethodForm.getHealthcareproviderSpecialty(),hospitalSpecialtyTreatmentMethodForm.getTreatment()).isEmpty()){					
					redirectAttributes.addAttribute("hs", hospitalSpecialtyTreatmentMethodForm.getHealthcareproviderSpecialty());				
					redirectAttributes.addAttribute("t", hospitalSpecialtyTreatmentMethodForm.getTreatment());
					redirectAttributes.addAttribute("sp", hospitalSpecialtyTreatmentMethodForm.getSpecialty());
					return "redirect:/home/specialty-treatment-method";
				}else{
					redirectAttributes.addAttribute("id", hospitalSpecialtyTreatmentMethodForm.getHealthcareproviderSpecialty());
					redirectAttributes.addAttribute("sp", hospitalSpecialtyTreatmentMethodForm.getSpecialty());
					return "redirect:/home/specialty-treatment";
				}
			}
		}	
		return "speciality/method";
	}
	
	/**
	 * specialty-treatment-method-practitioner action
	*/
	@RequestMapping(value = "/home/specialty-treatment-method-practitioner", method = RequestMethod.GET)
	public String practitionerAction(@RequestParam(value = "hstm", required = true) BigInteger hstm,@RequestParam(value = "hs", required = true) BigInteger hs,@RequestParam(value = "t", required = true) BigInteger treatment,@RequestParam(value = "m", required = true) BigInteger method,@RequestParam(value = "sp", required = true) BigInteger specialty,HospitalSpecialtyTreatmentMethodPractitionerForm hospitalSpecialtyTreatmentMethodPractitionerForm,Model model) {
		hospitalSpecialtyTreatmentMethodPractitionerForm.setSpecialty(specialty);
		hospitalSpecialtyTreatmentMethodPractitionerForm.setTreatment(treatment);
		hospitalSpecialtyTreatmentMethodPractitionerForm.setMethod(method);
		hospitalSpecialtyTreatmentMethodPractitionerForm.setHealthcareproviderSpecialty(hs);
		hospitalSpecialtyTreatmentMethodPractitionerForm.setHealthcareproviderSpecialtyTreatmentMethod(hstm);
		hospitalSpecialtyTreatmentMethodPractitionerForm.setHealthcareproviderPrice(hospitalSpecialtyService.getHospitalPriceByHstm(hstm));
		model.addAttribute("hospitalOtherSpecialtyPractitionerList", hospitalSpecialtyService.getHospitalOtherSpecialtyPractitionerList(specialty,hstm,userService.getCurrentHealthcareprovider()));		
		model.addAttribute("hospitalSpecialtyPractitionerList", hospitalSpecialtyService.getHospitalSpecialtyPractitionerList(specialty,hstm,userService.getCurrentHealthcareprovider()));
		model.addAttribute("selectedPractitionerList", hospitalSpecialtyService.getSelectedPractitionerList(hstm,userService.getCurrentHealthcareprovider()));		
		return "specialty/practitioner";
	}
	
	/**
	 * specialty-treatment-method-practitioner action
	*/
	@RequestMapping(value = "/home/specialty-treatment-method-practitioner", method = RequestMethod.POST)
	public String practitionerPostAction(@Valid HospitalSpecialtyTreatmentMethodPractitionerForm hospitalSpecialtyTreatmentMethodPractitionerForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {		
		model.addAttribute("hospitalOtherSpecialtyPractitionerList", hospitalSpecialtyService.getHospitalOtherSpecialtyPractitionerList(hospitalSpecialtyTreatmentMethodPractitionerForm.getSpecialty(), hospitalSpecialtyTreatmentMethodPractitionerForm.getHealthcareproviderSpecialtyTreatmentMethod(),userService.getCurrentHealthcareprovider()));
		model.addAttribute("hospitalSpecialtyPractitionerList", hospitalSpecialtyService.getHospitalSpecialtyPractitionerList(hospitalSpecialtyTreatmentMethodPractitionerForm.getSpecialty(), hospitalSpecialtyTreatmentMethodPractitionerForm.getHealthcareproviderSpecialtyTreatmentMethod(),userService.getCurrentHealthcareprovider()));
		model.addAttribute("selectedPractitionerList", hospitalSpecialtyService.getSelectedPractitionerList(hospitalSpecialtyTreatmentMethodPractitionerForm.getHealthcareproviderSpecialtyTreatmentMethod(),userService.getCurrentHealthcareprovider()));
		redirectAttributes.addAttribute("hstm", hospitalSpecialtyTreatmentMethodPractitionerForm.getHealthcareproviderSpecialtyTreatmentMethod());				
		redirectAttributes.addAttribute("hs", hospitalSpecialtyTreatmentMethodPractitionerForm.getHealthcareproviderSpecialty());
		redirectAttributes.addAttribute("t", hospitalSpecialtyTreatmentMethodPractitionerForm.getTreatment());
		redirectAttributes.addAttribute("m", hospitalSpecialtyTreatmentMethodPractitionerForm.getMethod());
		redirectAttributes.addAttribute("sp", hospitalSpecialtyTreatmentMethodPractitionerForm.getSpecialty());
		if(results.hasErrors() || hospitalSpecialtyService.getHospitalCurrency(userService.getCurrentHealthcareprovider()).isEmpty()){
			redirectAttributes.addFlashAttribute("currencyerror", "1");				
			return "redirect:/home/specialty-treatment-method-practitioner";
		}else{
			Boolean edited = hospitalSpecialtyService.editHospitalSpecialtyTreatmentMethodPractitioner(hospitalSpecialtyTreatmentMethodPractitionerForm,userService.getCurrentHealthcareprovider());			
			if(edited){
				redirectAttributes.addFlashAttribute("success", "1");				
				return "redirect:/home/specialty-treatment-method-practitioner";
			}else{
				redirectAttributes.addFlashAttribute("error", "1");				
				return "redirect:/home/specialty-treatment-method-practitioner";
			}
		}		
	}
	
	/**
	 * speciality-treatment-method-practitioner-detail action
	*/
	@RequestMapping(value = "/home/specialty-treatment-method-practitioner-detail", method = RequestMethod.GET)
	public String practitionerDetailAction(@RequestParam(value = "id", required = true) BigInteger id,@RequestParam(value = "t", required = true) BigInteger treatment,@RequestParam(value = "m", required = true) BigInteger method,@RequestParam(value = "sp", required = true) BigInteger speciality,HospitalSpecialtyTreatmentMethodPractitionerDetailForm hospitalSpecialtyTreatmentMethodPractitionerDetailForm,Model model) {
		hospitalSpecialtyTreatmentMethodPractitionerDetailForm.setMethod(method);
		hospitalSpecialtyTreatmentMethodPractitionerDetailForm.setTreatment(treatment);
		hospitalSpecialtyTreatmentMethodPractitionerDetailForm.setSpecialty(speciality);		
		hospitalSpecialtyTreatmentMethodPractitionerDetailForm.setHstmpModel(hospitalSpecialtyService.getHospitalSpecialtyTreatmentMethodPractitionerById(id));		
		model.addAttribute("yearsPracticedList", hospitalSpecialtyService.getYearsPracticedList());
		model.addAttribute("corporatecompanyInsuranceList", hospitalSpecialtyService.getAllCorporatecompanyInsurance());
		return "specialty/practitionerdetail";
	}
	
	/**
	 * specialty-treatment-method-practitioner-detail post action
	*/
	@RequestMapping(value = "/home/specialty-treatment-method-practitioner-detail", method = RequestMethod.POST)
	public String practitionerDetailPostAction(@Valid HospitalSpecialtyTreatmentMethodPractitionerDetailForm hospitalSpecialtyTreatmentMethodPractitionerDetailForm,BindingResult results,RedirectAttributes redirectAttributes,Model model) {
		redirectAttributes.addAttribute("id", hospitalSpecialtyTreatmentMethodPractitionerDetailForm.getHstmpModel().getId());		
		redirectAttributes.addAttribute("t", hospitalSpecialtyTreatmentMethodPractitionerDetailForm.getTreatment());
		redirectAttributes.addAttribute("m", hospitalSpecialtyTreatmentMethodPractitionerDetailForm.getMethod());
		redirectAttributes.addAttribute("sp", hospitalSpecialtyTreatmentMethodPractitionerDetailForm.getSpecialty());
		if(results.hasErrors()){
			model.addAttribute("error", 1);
			model.addAttribute("yearsPracticedList", hospitalSpecialtyService.getYearsPracticedList());
			model.addAttribute("corporatecompanyInsuranceList", hospitalSpecialtyService.getAllCorporatecompanyInsurance());
			logger.info("error found during pracitioner detail submit {}",results.getAllErrors());
			return "specialty/practitionerdetail";
		}else{
			Integer edited = hospitalSpecialtyService.setHospitalSpecialtyTreatmentMethodPractitioner(hospitalSpecialtyTreatmentMethodPractitionerDetailForm.getHstmpModel());
			if(edited > 0){
				redirectAttributes.addFlashAttribute("success", "1");				
				return "redirect:/home/specialty-treatment-method-practitioner-detail";
			}
		}		
		return "specialty/practitionerdetail";
	}
}