package com.dg.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.hospital.form.HospitalSpecialtyForm;
import com.dg.hospital.form.HospitalSpecialtyTreatmentForm;
import com.dg.hospital.form.HospitalSpecialtyTreatmentMethodForm;
import com.dg.hospital.form.HospitalSpecialtyTreatmentMethodPractitionerForm;
import com.dg.hospital.model.HospitalSpecialtyModel;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodModel;
import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodPractitionerModel;
import com.dg.hospital.model.MethodModel;
import com.dg.hospital.model.PractitionerModel;
import com.dg.hospital.model.SpecialtyModel;
import com.dg.hospital.model.SpecialtyTreatmentModel;
import com.dg.hospital.model.TreatmentModel;

public class HospitalSpecialtyService extends RestService{
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalSpecialtyService.class);
	  
	private RestUrlService restUrlService;
	
	public RestUrlService getRestUrlService()
	{
	   return this.restUrlService;
	}
	  
	public void setRestUrlService(RestUrlService restUrlService)
	{
	   this.restUrlService = restUrlService;
	}
	
	public Boolean editHospitalSpecialty(HospitalSpecialtyForm hospitalSpecialtyForm){
		logger.info("hospital specialty list = {}",hospitalSpecialtyForm.getSpecialtyModel());
		Boolean result = false;
		Boolean found = false;		
		List<HospitalSpecialtyModel> hospitalSpecialtyModelList = super.getHospitalSpecialty(hospitalSpecialtyForm.getHealthcareprovider());
		HashMap<BigInteger,String> specialtyMap = new HashMap<BigInteger,String>();
		List<SpecialtyModel> specialtyModelList = super.getAllSpecialty();		
		for(SpecialtyModel specialtyModel : specialtyModelList){
			specialtyMap.put(specialtyModel.getId(), specialtyModel.getName());
		}
		if(hospitalSpecialtyForm.getSpecialtyModel() != null){
			logger.info("speciality list = {}",hospitalSpecialtyForm.getSpecialtyModel());
			for(BigInteger speciality : hospitalSpecialtyForm.getSpecialtyModel()){
				for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getSpecialty().equals(speciality)){
						super.deleteHospitalSpecialty(model.getId());
						result = true;
					}
				}
			}
		}
		if(hospitalSpecialtyForm.getHospitalSpecialty() != null){
		   logger.info("hospital specialty list = {}",hospitalSpecialtyForm.getHospitalSpecialty());
		   for(BigInteger specialty : hospitalSpecialtyForm.getHospitalSpecialty()){
			   found = false;
			   for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getSpecialty().equals(specialty)){
						found = true;
						result = true;
					}
				}
			   if(!found){
				   HospitalSpecialtyModel model = new HospitalSpecialtyModel();
				   model.setHealthcareprovider(hospitalSpecialtyForm.getHealthcareprovider());
				   model.setName(specialtyMap.get(specialty));
				   model.setSpecialty(specialty);
				   super.setHospitalSpecialty(model);
				   result = true;
			   }
		   }
		}
		return result;
	}
	
	public List<TreatmentModel> getSelectedTreatmentFormList(BigInteger healthcareproviderSpecialty){
		List<TreatmentModel> hospitalTreatmentFormList = new ArrayList<TreatmentModel>();
		List<TreatmentModel> hospitalTreatmentModelList = new ArrayList<TreatmentModel>();
		List<TreatmentModel> treatmentModelList = super.getAllTreatment();
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(healthcareproviderSpecialty);
		Set<BigInteger> result = new HashSet<BigInteger>();
		if(hospitalSpecialtyTreatmentMethodModelList != null){
			for(TreatmentModel tm : treatmentModelList){
				for(HospitalSpecialtyTreatmentMethodModel hstm: hospitalSpecialtyTreatmentMethodModelList){
					if(tm.getId().equals(hstm.getTreatment()) && hstm.getActive()){					
						hospitalTreatmentModelList.add(tm);
					}
				}
			}
			
			for(TreatmentModel model : hospitalTreatmentModelList){
				if(result.add(model.getId())){
					hospitalTreatmentFormList.add(model);
				}
			}
		}
		
		return hospitalTreatmentFormList;		
	}
	
	/*public List<SpecialityTreatmentModel> getSpecialityTreatmentFormList(BigInteger healthcareproviderSpeciality,BigInteger speciality){
		Boolean found =false;
		List<SpecialityTreatmentModel> specialityTreatmentFormList = new ArrayList<SpecialityTreatmentModel>();
		List<SpecialityTreatmentModel> specialityTreatmentModelList = super.getSpecialityTreatmentBySpeciality(speciality);		
		List<HospitalSpecialityTreatmentMethodModel> hospitalSpecialityTreatmentMethodModelList = super.getHospitalSpecialityTreatmentMethod(healthcareproviderSpeciality);
		
		if(hospitalSpecialityTreatmentMethodModelList != null){
			for(SpecialityTreatmentModel specialityTreatmentModel : specialityTreatmentModelList){
				found = false;
				for(HospitalSpecialityTreatmentMethodModel hsm: hospitalSpecialityTreatmentMethodModelList){
					if(specialityTreatmentModel.getTreatment().equals(hsm.getTreatment()) && hsm.getActive()){
						found = true;
					}
				}
				if(!found){
					specialityTreatmentFormList.add(specialityTreatmentModel);
				}
			}
		}else{
			specialityTreatmentFormList = super.getSpecialityTreatmentBySpeciality(speciality);
		}
		return specialityTreatmentFormList;
	}*/
	
	public List<TreatmentModel> getSpecialtyTreatmentFormList(BigInteger healthcareproviderSpecialty,BigInteger specialty){
		Boolean found =false;
		List<TreatmentModel> specialityTreatmentFormList = new ArrayList<TreatmentModel>();
		List<TreatmentModel> specialityTreatmentModelList = super.getAllTreatment();		
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialityTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(healthcareproviderSpecialty);
		
		if(hospitalSpecialityTreatmentMethodModelList != null){
			for(TreatmentModel specialityTreatmentModel : specialityTreatmentModelList){
				found = false;
				for(HospitalSpecialtyTreatmentMethodModel hsm: hospitalSpecialityTreatmentMethodModelList){
					if(specialityTreatmentModel.getId().equals(hsm.getTreatment()) && hsm.getActive()){
						found = true;
					}
				}
				if(!found){
					specialityTreatmentFormList.add(specialityTreatmentModel);
				}
			}
		}else{
			specialityTreatmentFormList = super.getAllTreatment();
		}
		return specialityTreatmentFormList;
	}
	
	public Boolean editHospitalSpecialtyTreatment(HospitalSpecialtyTreatmentForm form){		
		Boolean result = false;
		Boolean found = false;	
		Integer edited = super.setHospitalSpecialty(form.getHospitalSpecialtyModel());
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(form.getHospitalSpecialtyModel().getId());
		BigInteger method = null;
		List<MethodModel> methodList = super.getAllMethod();
		for(MethodModel methodModel : methodList){
			if(methodModel.getName().equalsIgnoreCase("general")){
				method = methodModel.getId();
			}
		}
		if(form.getSpecialtyTreatment() != null){
			logger.info("treatment list = {}",form.getSpecialtyTreatment());
			for(BigInteger treatment : form.getSpecialtyTreatment()){
				for(HospitalSpecialtyTreatmentMethodModel model : hospitalSpecialtyTreatmentMethodModelList){
					if(model.getTreatment().equals(treatment)){
						model.setActive(false);
						//super.deleteHospitalSpecialityTreatmentMethod(model.getId());
						super.setHospitalSpecialtyTreatmentMethod(model);
						result = true;
					}
				}
			}
		}
		if(form.getSelectedTreatment() != null){
		   logger.info("hospital speciality treatment list = {}",form.getSelectedTreatment());
		   for(BigInteger treatment : form.getSelectedTreatment()){
			   found = false;
			   for(HospitalSpecialtyTreatmentMethodModel model : hospitalSpecialtyTreatmentMethodModelList){
					if(model.getTreatment().equals(treatment)){
						model.setActive(true);
						super.setHospitalSpecialtyTreatmentMethod(model);
						found = true;
						result = true;
					}
				}
			   if(!found){
				   HospitalSpecialtyTreatmentMethodModel model = new HospitalSpecialtyTreatmentMethodModel();
				   model.setActive(true);
				   model.setHealthcareproviderSpecialty(form.getHospitalSpecialtyModel().getId());
				   model.setTreatment(treatment);
				   model.setMethod(method);
				   super.setHospitalSpecialtyTreatmentMethod(model);
				   result = true;
			   }
		   }
		}
		return result;
	}
	
	
	public List<MethodModel> getHospitalMethodFormList(BigInteger healthcareproviderSpecialty,BigInteger treatment){
		List<MethodModel> hospitalMethodFormList = new ArrayList<MethodModel>();
		List<MethodModel> methodModelList = super.getAllMethod();
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialityTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(healthcareproviderSpecialty);
		if(hospitalSpecialityTreatmentMethodModelList != null){
			for(MethodModel model : methodModelList){
				for(HospitalSpecialtyTreatmentMethodModel hstm: hospitalSpecialityTreatmentMethodModelList){
					if((model.getId().equals(hstm.getMethod()) && hstm.getTreatment().equals(treatment)) && hstm.getActive()){					
						hospitalMethodFormList.add(model);
					}
				}
			}
		}
		return hospitalMethodFormList;		
	}
	
	public List<MethodModel> getMethodFormList(BigInteger healthcareproviderSpecialty,BigInteger treatment){
		Boolean found =false;
		List<MethodModel> methodFormList = new ArrayList<MethodModel>();
		List<MethodModel> methodModelList = super.getAllMethod();
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialityTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(healthcareproviderSpecialty);
		
		if(hospitalSpecialityTreatmentMethodModelList != null){
			for(MethodModel methodModel : methodModelList){
				found = false;
				for(HospitalSpecialtyTreatmentMethodModel hsm: hospitalSpecialityTreatmentMethodModelList){
					if((methodModel.getId().equals(hsm.getMethod()) && hsm.getTreatment().equals(treatment)) && hsm.getActive()){
						found = true;
					}
				}
				if(!found){
					methodFormList.add(methodModel);
				}
			}
		}else{
			methodFormList = super.getAllMethod();
		}
		return methodFormList;
	}
	
	public Boolean editHospitalSpecialtyTreatmentMethod(HospitalSpecialtyTreatmentMethodForm form){		
		Boolean result = false;
		Boolean found = false;		
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(form.getHealthcareproviderSpecialty());		
			
		if(form.getMethod() != null){
			logger.info("method list = {}",form.getMethod());
			for(BigInteger method : form.getMethod()){
				for(HospitalSpecialtyTreatmentMethodModel model : hospitalSpecialtyTreatmentMethodModelList){
					if(model.getTreatment().equals(form.getTreatment()) && model.getMethod().equals(method)){
						model.setActive(false);
						super.setHospitalSpecialtyTreatmentMethod(model);
						logger.info("disable method false ={}",method);
						result = true;
					}
				}
			}
		}
		if(form.getTreatmentMethod() != null){
		   logger.info("hospital specialty treatment method list = {}",form.getTreatmentMethod());
		   for(BigInteger method : form.getTreatmentMethod()){
			   found = false;
			   for(HospitalSpecialtyTreatmentMethodModel model : hospitalSpecialtyTreatmentMethodModelList){
					if(model.getTreatment().equals(form.getTreatment()) && model.getMethod().equals(method)){
						model.setActive(true);
						super.setHospitalSpecialtyTreatmentMethod(model);
						found = true;
						result = true;
					}
				}
			   if(!found){
				   HospitalSpecialtyTreatmentMethodModel model = new HospitalSpecialtyTreatmentMethodModel();
				   model.setActive(true);
				   model.setHealthcareproviderSpecialty(form.getHealthcareproviderSpecialty());
				   model.setTreatment(form.getTreatment());
				   model.setMethod(method);
				   super.setHospitalSpecialtyTreatmentMethod(model);
				   result = true;
			   }
		   }
		}
		return result;
	}

	public List<PractitionerModel> getPractitionerList(BigInteger hstm) {
		Boolean found = false;
		List<PractitionerModel> practitionerFormList = new ArrayList<PractitionerModel>();
		List<PractitionerModel> practitionerModelList = super.getAllPractitioner();
		List<HospitalSpecialtyTreatmentMethodPractitionerModel> hstmpModelList = super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(hstm);
		if(hstmpModelList != null){
			for(PractitionerModel practitionerModel : practitionerModelList){
				found = false;
				for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmp: hstmpModelList){
					if(practitionerModel.getId().equals(hstmp.getPractitioner()) && hstmp.getActive()){
						found = true;
					}
				}
				if(!found){
					practitionerFormList.add(practitionerModel);
				}
			}
		}else{
			practitionerFormList = super.getAllPractitioner();
		}
		return practitionerFormList;		
	}
	
	public List<PractitionerModel> getSelectedPractitionerList(BigInteger hstm) {		
		List<PractitionerModel> practitionerFormList = new ArrayList<PractitionerModel>();
		List<PractitionerModel> practitionerModelList = super.getAllPractitioner();
		List<HospitalSpecialtyTreatmentMethodPractitionerModel> hstmpModelList = super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(hstm);
		if(hstmpModelList != null){
			for(PractitionerModel practitionerModel : practitionerModelList){				
				for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmp: hstmpModelList){
					if(practitionerModel.getId().equals(hstmp.getPractitioner()) && hstmp.getActive()){				
						practitionerFormList.add(practitionerModel);					}
				}				
			}
		}
		return practitionerFormList;		
	}
	
	public Boolean editHospitalSpecialtyTreatmentMethodPractitioner(HospitalSpecialtyTreatmentMethodPractitionerForm form){		
		Boolean result = false;
		Boolean found = false;		
		List<HospitalSpecialtyTreatmentMethodPractitionerModel> hstmpModelList = super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(form.getHealthcareproviderSpecialtyTreatmentMethod());		
			
		if(form.getPractitioner() != null){
			logger.info("practitioner list = {}",form.getPractitioner());
			for(BigInteger practitioner : form.getPractitioner()){
				for(HospitalSpecialtyTreatmentMethodPractitionerModel model : hstmpModelList){
					if(model.getPractitioner().equals(practitioner)){
						model.setActive(false);
						super.setHospitalSpecialtyTreatmentMethodPractitioner(model);
						logger.info("disable hstmp false ={}",practitioner);
						result = true;
					}
				}
			}
		}
		if(form.getSelectedPractitioner() != null){
		   logger.info("hospital specialty treatment method practitioner list = {}",form.getSelectedPractitioner());
		   for(BigInteger practitioner : form.getSelectedPractitioner()){
			   found = false;
			   for(HospitalSpecialtyTreatmentMethodPractitionerModel model : hstmpModelList){
					if(model.getPractitioner().equals(practitioner)){
						model.setActive(true);
						super.setHospitalSpecialtyTreatmentMethodPractitioner(model);
						found = true;
						result = true;
					}
				}
			   if(!found){
				   HospitalSpecialtyTreatmentMethodPractitionerModel model = new HospitalSpecialtyTreatmentMethodPractitionerModel();
				   model.setActive(true);
				   model.setHealthcareproviderSpecialtyTreatmentMethod(form.getHealthcareproviderSpecialtyTreatmentMethod());
				   model.setPractitioner(practitioner);
				   model.setCurrency("USD");
				   model.setAvailabilityDays(0);
				   model.setHealthcareproviderPrice(0);
				   model.setPractitionerPrice(0);				   
				   model.setMethodPrice(0);
				   super.setHospitalSpecialtyTreatmentMethodPractitioner(model);
				   result = true;
			   }
		   }
		}
		return result;
	}
}