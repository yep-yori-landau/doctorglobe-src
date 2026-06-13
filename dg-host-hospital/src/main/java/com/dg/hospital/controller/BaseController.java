package com.dg.hospital.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dg.hospital.model.HospitalModel;
import com.dg.hospital.model.HospitalPractitionerDetailModel;
import com.dg.hospital.model.HospitalPractitionerModel;
import com.dg.hospital.model.HospitalSpecialtyModel;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodModel;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodPractitionerModel;
import com.dg.hospital.model.MethodModel;
import com.dg.hospital.model.PractitionerModel;
import com.dg.hospital.model.SpecialtyModel;
import com.dg.hospital.model.TreatmentModel;
import com.dg.hospital.service.HospitalService;
import com.dg.hospital.service.UserService;

public class BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HospitalService hospitalService;	
	
	@ModelAttribute("hospitalName")
	public String getHospitalName(){		
		 if(userService.isLoggedIn()){
			 HospitalModel model = hospitalService.getHospital(userService.getCurrentHealthcareprovider());
			 return model.getName();
		 }
		 return null;
	}
	
	@ModelAttribute("userHospitalList")
	public List<HospitalModel> getUserHospitalList(){		
		 if(userService.isLoggedIn()){
			 List<HospitalModel> userHospitalList = hospitalService.getUserHospitalList(userService.getHealthcareproviderList());
			 return userHospitalList;
		 }
		 return null;
	}
	
	@ModelAttribute("hospitalSpecialties")
	public List<HospitalSpecialtyModel> getHospitalSpecialties(){
		List<HospitalSpecialtyModel> hospitalSpecialtyModel = null;
		if(userService.isLoggedIn()){
			 hospitalSpecialtyModel = hospitalService.getHospitalSpecialty(userService.getCurrentHealthcareprovider());			 
		 }
		return hospitalSpecialtyModel;
	}
	
	@ModelAttribute("isHospitalSpecialtyExist")
	public Boolean getIsHospitalSpecialtyExist(){
		Boolean isHospitalSpecialtyExist = false;
		if(userService.isLoggedIn()){			 
			 for(HospitalSpecialtyModel model:hospitalService.getHospitalSpecialty(userService.getCurrentHealthcareprovider())){
				 if(model.getActive()){
					 isHospitalSpecialtyExist = true;
				 }
			 }
		 }
		return isHospitalSpecialtyExist;
	}
	
	@ModelAttribute("hospitalSpecialtyTreatmentMethodList")
	public List<HospitalSpecialtyTreatmentMethodModel> getHospitalSpecialtyTreatmentsMethodList(){
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModel = null;
		if(userService.isLoggedIn()){
			hospitalSpecialtyTreatmentMethodModel = hospitalService.getHospitalSpecialtyTreatmentMethodByHealthcareprovider(userService.getCurrentHealthcareprovider());			
		 }
		return hospitalSpecialtyTreatmentMethodModel;
	}
	
	@ModelAttribute("hospitalSpecialtyTreatmentList")
	public HashMap<BigInteger,List<BigInteger>> getHospitalSpecialtyTreatmentList(){		
		HashMap<BigInteger,List<BigInteger>> hospitalSpecialtyTreatmentMethodModel = new HashMap<BigInteger,List<BigInteger>>();
		if(userService.isLoggedIn()){
			 List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialityTreatmentMethodModelList = hospitalService.getHospitalSpecialtyTreatmentMethodByHealthcareprovider(userService.getCurrentHealthcareprovider());			 			 
			 for(HospitalSpecialtyTreatmentMethodModel model: hospitalSpecialityTreatmentMethodModelList){				
				if(!hospitalSpecialtyTreatmentMethodModel.containsKey(model.getHealthcareproviderSpecialty())){
			    	   if(model.getTreatment() != null){
				    	   List<BigInteger> list = new ArrayList<BigInteger>();
				    	   list.add(model.getTreatment());
				    	   hospitalSpecialtyTreatmentMethodModel.put(model.getHealthcareproviderSpecialty(), list);
			    	   }
			       }else{
			    	   if(model.getTreatment() != null){
				    	   List<BigInteger> list = (List) hospitalSpecialtyTreatmentMethodModel.get(model.getHealthcareproviderSpecialty());
				    	   if(!list.contains(model.getTreatment())){
				    		   list.add(model.getTreatment());			
				    	   }
			    	   }
			    }
			}
		 }		
		return hospitalSpecialtyTreatmentMethodModel;
	}
	
	@ModelAttribute("hospitalSpecialtyTreatmentMethodPractitionerList")
	public List<HospitalSpecialtyTreatmentMethodPractitionerModel> getHospitalSpecialtyTreatmentsMethodPractitionerList(){		
		List<HospitalSpecialtyTreatmentMethodPractitionerModel> hstmpModelList = null;	
		if(userService.isLoggedIn()){
			 hstmpModelList = hospitalService.getHospitalSpecialtyTreatmentMethodPractitionerByHealthcareprovider(userService.getCurrentHealthcareprovider());			 
		 }
		return hstmpModelList;
	}
	
	@ModelAttribute("specialtyMap")
	public HashMap<BigInteger,String> getSpecialtyMap(){
		HashMap<BigInteger,String> specialtyMap = new HashMap<BigInteger,String>();
		if(userService.isLoggedIn()){
			List<SpecialtyModel> specialtyModelList = hospitalService.getAllSpecialty();		
			for(SpecialtyModel specialtyModel : specialtyModelList){
				specialtyMap.put(specialtyModel.getId(), specialtyModel.getName());
			}
		}
		return specialtyMap;
	}
	
	@ModelAttribute("treatmentMap")
	public HashMap<BigInteger,String> getTreatmentMap(){
		HashMap<BigInteger,String> treatmentMap = new HashMap<BigInteger,String>();
		if(userService.isLoggedIn()){
			List<TreatmentModel> treatmentModelList = hospitalService.getAllTreatment();	
			for(TreatmentModel treatmentModel : treatmentModelList){
				treatmentMap.put(treatmentModel.getId(), treatmentModel.getName());
			}
		}
		return treatmentMap;
	}
	
	@ModelAttribute("methodMap")
	public HashMap<BigInteger,String> getMethodMap(){
		HashMap<BigInteger,String> methodMap = new HashMap<BigInteger,String>();
		if(userService.isLoggedIn()){
			List<MethodModel> methodModelList = hospitalService.getAllMethod();	
			for(MethodModel methodModel : methodModelList){
				methodMap.put(methodModel.getId(), methodModel.getName());
			}
		}
		return methodMap;
	}	
	
	@ModelAttribute("practitionerMap")
	public HashMap<BigInteger,String> getPractitionerMap(){
		HashMap<BigInteger,String> practitionerMap = new HashMap<BigInteger,String>();		
		String title = "";
		String firstName = "";
		String lastName = "";
		if(userService.isLoggedIn()){
			List<HospitalPractitionerDetailModel> hospitalPractitionerModelList = hospitalService.getHospitalPractitionerDetail(userService.getCurrentHealthcareprovider());
			List<PractitionerModel> practitionerModelList = hospitalService.getAllPractitioner();		
			for(PractitionerModel practitionerModel : practitionerModelList){				
				title = practitionerModel.getTitle();				
				firstName = practitionerModel.getFirstName();
				lastName = practitionerModel.getLastName();
				for(HospitalPractitionerDetailModel model:hospitalPractitionerModelList){
					if(model.getPractitioner().equals(practitionerModel.getId())){
						if(model.getTitle() != "" || model.getTitle() != null){
							title = model.getTitle();
						}
						if(model.getFirstName() != "" || model.getFirstName() != null){
							firstName = model.getFirstName();
						}
						if(model.getLastName() != "" || model.getLastName() != null){
							lastName = model.getLastName();
						}
					}
				}			
				practitionerMap.put(practitionerModel.getId(), title+' '+firstName+' '+lastName);
			}
		}
		return practitionerMap;
	}
	
}