package com.dg.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.dg.hospital.model.HospitalPractitionerModel;
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
						model.setActive(false);
						super.setHospitalSpecialty(model);
						this.updateHospitalSpecialtyTreatmentMethod(model.getId(),false);
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
						model.setActive(true);
						super.setHospitalSpecialty(model);
						this.updateHospitalSpecialtyTreatmentMethod(model.getId(),true);
						found = true;
						result = true;
					}
				}
			   if(!found){
				   HospitalSpecialtyModel model = new HospitalSpecialtyModel();
				   model.setHealthcareprovider(hospitalSpecialtyForm.getHealthcareprovider());
				   model.setName(specialtyMap.get(specialty));
				   model.setSpecialty(specialty);
				   model.setActive(true);
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
	
	/**
	 * 
	 * @param healthcareproviderSpecialty
	 * @param specialty
	 * @return
	 */
	public List<TreatmentModel> getSpecialtyTreatmentFormList(BigInteger healthcareproviderSpecialty,BigInteger specialty){
		Boolean found =false;
		List<TreatmentModel> specialityTreatmentFormList = new ArrayList<TreatmentModel>();
		List<TreatmentModel> specialityTreatmentList = new ArrayList<TreatmentModel>();
		List<TreatmentModel> specialityTreatmentModelList = super.getAllTreatment();		
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialityTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(healthcareproviderSpecialty);
		List<HospitalSpecialtyTreatmentMethodModel> specialtyTreatmentModelList = super.getHospitalSpecialtyTreatmentMethodBySpecialty(specialty);
		
		if(hospitalSpecialityTreatmentMethodModelList != null){
			for(TreatmentModel specialityTreatmentModel : specialityTreatmentModelList){
				found = false;
				for(HospitalSpecialtyTreatmentMethodModel hsm: hospitalSpecialityTreatmentMethodModelList){
					if(specialityTreatmentModel.getId().equals(hsm.getTreatment()) && hsm.getActive()){
						found = true;
					}
				}
				if(!found){
					specialityTreatmentList.add(specialityTreatmentModel);
				}
			}
			
			for(TreatmentModel model: specialityTreatmentList){
				found = false;
				for(HospitalSpecialtyTreatmentMethodModel hstm : specialtyTreatmentModelList){
					if(!hstm.getHealthcareproviderSpecialty().equals(healthcareproviderSpecialty) && hstm.getTreatment().equals(model.getId())){
						found = true;
					}
				}
				if(found){
					specialityTreatmentFormList.add(model);
				}
			}
		}else{
			for(TreatmentModel model: super.getAllTreatment()){
				for(HospitalSpecialtyTreatmentMethodModel hstm : specialtyTreatmentModelList){
					if(!hstm.getHealthcareproviderSpecialty().equals(healthcareproviderSpecialty) && hstm.getTreatment().equals(model.getId())){
						found = true;
					}
				}
				if(found){
					specialityTreatmentFormList.add(model);
				}
			}			
		}
		return specialityTreatmentFormList;
	}
	
	/**
	 * 
	 * @param healthcareproviderSpecialty
	 * @param specialty
	 * @return
	 */
	public List<TreatmentModel> getSpecialtyOtherTreatmentFormList(BigInteger healthcareproviderSpecialty,BigInteger specialty){
		Boolean found =false;
		List<TreatmentModel> specialityTreatmentFormList = new ArrayList<TreatmentModel>();
		List<TreatmentModel> specialityTreatmentList = new ArrayList<TreatmentModel>();
		List<TreatmentModel> specialityTreatmentModelList = super.getAllTreatment();		
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialityTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(healthcareproviderSpecialty);
		List<HospitalSpecialtyTreatmentMethodModel> specialtyTreatmentModelList = super.getHospitalSpecialtyTreatmentMethodBySpecialty(specialty);
		
		if(hospitalSpecialityTreatmentMethodModelList != null){
			for(TreatmentModel specialityTreatmentModel : specialityTreatmentModelList){
				found = false;
				for(HospitalSpecialtyTreatmentMethodModel hsm: hospitalSpecialityTreatmentMethodModelList){
					if(specialityTreatmentModel.getId().equals(hsm.getTreatment()) && hsm.getActive()){
						found = true;
					}
				}
				if(!found){
					specialityTreatmentList.add(specialityTreatmentModel);
				}
			}
			
			for(TreatmentModel model: specialityTreatmentList){
				found = false;
				for(HospitalSpecialtyTreatmentMethodModel hstm : specialtyTreatmentModelList){
					if(!hstm.getHealthcareproviderSpecialty().equals(healthcareproviderSpecialty) && hstm.getTreatment().equals(model.getId())){
						found = true;
					}
				}
				if(!found){
					specialityTreatmentFormList.add(model);
				}
			}
		}else{
			for(TreatmentModel model: super.getAllTreatment()){
				for(HospitalSpecialtyTreatmentMethodModel hstm : specialtyTreatmentModelList){
					if(!hstm.getHealthcareproviderSpecialty().equals(healthcareproviderSpecialty) && hstm.getTreatment().equals(model.getId())){
						found = true;
					}
				}
				if(!found){
					specialityTreatmentFormList.add(model);
				}
			}			
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
						super.setHospitalSpecialtyTreatmentMethod(model);
						for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel:super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(model.getId())){
							hstmpModel.setActive(false);
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
						}
						found = true;
						result = true;
					}
				}				
			}
			if(!found){
				result = true;
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
						for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel:super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(model.getId())){
							hstmpModel.setActive(true);
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
						}
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
				   model.setHealthcareproviderPrice(0.0);
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
						for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel:super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(model.getId())){
							hstmpModel.setActive(false);							
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
						}
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
						//model.setHealthcareproviderPrice(form.getHealthcareproviderPrice());
						super.setHospitalSpecialtyTreatmentMethod(model);
						for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel:super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(model.getId())){
							hstmpModel.setActive(true);
							//hstmpModel.setHealthcareproviderPrice(form.getHealthcareproviderPrice());
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
						}
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
				   model.setHealthcareproviderPrice(0.0);
				   super.setHospitalSpecialtyTreatmentMethod(model);
				   result = true;
			   }
		   }
		}
		return result;
	}

	public List<PractitionerModel> getPractitonerList(BigInteger hstm) {
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
	
	/**
	 * 
	 * @param specialty
	 * @param hstm
	 * @param healthcareprovider
	 * @return
	 */
	public List<PractitionerModel> getHospitalOtherSpecialtyPractitionerList(BigInteger specialty,BigInteger hstm,BigInteger healthcareprovider) {		
		Boolean found = false;
		List<PractitionerModel> practitionerFormList = new ArrayList<PractitionerModel>();
		List<PractitionerModel> otherPractitionerList = new ArrayList<PractitionerModel>();
		List<PractitionerModel> practitionerModelList = super.getAllPractitioner();
		List<PractitionerModel> selectedPractitionerList = this.getSelectedPractitionerList(hstm, healthcareprovider);
		List<PractitionerModel> specialtyPractitionerList = this.getHospitalSpecialtyPractitionerList(specialty, hstm, healthcareprovider);
		List<HospitalPractitionerModel> hospitalPractitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		List<BigInteger> practitionerId = new ArrayList<BigInteger>();
		if(!hospitalPractitionerModelList.isEmpty()){
			for(PractitionerModel practitionerModel : practitionerModelList){				
				for(HospitalPractitionerModel model: hospitalPractitionerModelList){
					if(model.getId().equals(practitionerModel.getId()) && !model.getSpecialtyId().equals(specialty) && model.getActive()){
						if(!practitionerId.contains(practitionerModel.getId())){	
							practitionerModel.setTitle(model.getTitle());
							practitionerModel.setFirstName(model.getName());
							otherPractitionerList.add(practitionerModel);
							practitionerId.add(practitionerModel.getId());
						}
					}
				}				
			}
		}	
		Boolean found1 = false;
		if(!selectedPractitionerList.isEmpty()){
			for(PractitionerModel practitionerModel:otherPractitionerList){
				found = false;
				found1 = false;
				for(PractitionerModel spml: selectedPractitionerList){
					if(practitionerModel.getId().equals(spml.getId())){
						found = true;
					}
				}
				if(!found){
					if(!specialtyPractitionerList.isEmpty()){
						for(PractitionerModel model: specialtyPractitionerList){
							if(practitionerModel.getId().equals(model.getId())){
								found1 = true;
							}
						}
						if(!found1){							
							practitionerFormList.add(practitionerModel);
						}
					}else{
						practitionerFormList.add(practitionerModel);
					}					
				}
			}
		}else{
			if(!specialtyPractitionerList.isEmpty()){
				for(PractitionerModel practitionerModel:otherPractitionerList){
					found = false;
					for(PractitionerModel model: specialtyPractitionerList){
						if(practitionerModel.getId().equals(model.getId())){						
							found = true;
						}
					}
					if(!found){
						practitionerFormList.add(practitionerModel);
					}
				}
			}else{
				practitionerFormList = otherPractitionerList;
			}				
		}
		return practitionerFormList;			
	}
	
	/**
	 * 
	 * @param specialty
	 * @param hstm
	 * @param healthcareprovider
	 * @return
	 */
	public List<PractitionerModel> getHospitalSpecialtyPractitionerList(BigInteger specialty,BigInteger hstm,BigInteger healthcareprovider) {		
		Boolean found = false;
		List<PractitionerModel> practitionerFormList = new ArrayList<PractitionerModel>();
		List<PractitionerModel> specialtyPractitionerList = new ArrayList<PractitionerModel>();
		List<PractitionerModel> practitionerModelList = super.getAllPractitioner();
		List<PractitionerModel> selectedPractitionerList = this.getSelectedPractitionerList(hstm, healthcareprovider);
		List<HospitalPractitionerModel> hospitalPractitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		List<BigInteger> practitionerId = new ArrayList<BigInteger>();
		if(!hospitalPractitionerModelList.isEmpty()){
			for(PractitionerModel practitionerModel : practitionerModelList){				
				for(HospitalPractitionerModel model: hospitalPractitionerModelList){
					if(model.getId().equals(practitionerModel.getId()) && model.getSpecialtyId().equals(specialty) && model.getActive()){
						if(!practitionerId.contains(practitionerModel.getId())){
							practitionerModel.setTitle(model.getTitle());
							practitionerModel.setFirstName(model.getName());
							specialtyPractitionerList.add(practitionerModel);
							practitionerId.add(practitionerModel.getId());
						}
					}
				}				
			}
		}		
		if(!selectedPractitionerList.isEmpty()){
			for(PractitionerModel practitionerModel:specialtyPractitionerList){
				found = false;
				for(PractitionerModel spml: selectedPractitionerList){
					if(practitionerModel.getId().equals(spml.getId())){
						found = true;
					}
				}
				if(!found){
					practitionerFormList.add(practitionerModel);
				}
			}
		}else{
			practitionerFormList = specialtyPractitionerList;
		}
		return practitionerFormList;			
	}
	
	/**
	 * 
	 * @param hstm
	 * @param healthcareprovider
	 * @return
	 */
	public List<PractitionerModel> getSelectedPractitionerList(BigInteger hstm,BigInteger healthcareprovider) {		
		List<PractitionerModel> practitionerFormList = new ArrayList<PractitionerModel>();
		List<PractitionerModel> practitionerModelList = super.getAllPractitioner();		
		List<HospitalPractitionerModel> hospitalPractitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		List<BigInteger> practitionerId = new ArrayList<BigInteger>();
		if(!hospitalPractitionerModelList.isEmpty()){
			for(PractitionerModel practitionerModel : practitionerModelList){				
				for(HospitalPractitionerModel model: hospitalPractitionerModelList){
					if(model.getId().equals(practitionerModel.getId()) && model.getHstm().equals(hstm) && model.getActive()){
						if(!practitionerId.contains(practitionerModel.getId())){
							practitionerModel.setTitle(model.getTitle());
							practitionerModel.setFirstName(model.getName());
							practitionerFormList.add(practitionerModel);
							practitionerId.add(practitionerModel.getId());
						}
					}
				}				
			}
		}
		return practitionerFormList;		
	}
	
	public Boolean editHospitalSpecialtyTreatmentMethodPractitioner(HospitalSpecialtyTreatmentMethodPractitionerForm form,BigInteger healthcareprovider){		
		Boolean result = false;
		Boolean found = false;
		Double healthcareproviderPrice = 0.0;
		List<HospitalSpecialtyTreatmentMethodPractitionerModel> hstmpModelList = super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(form.getHealthcareproviderSpecialtyTreatmentMethod());		
		if(super.getHospitalCurrency(healthcareprovider).isEmpty()){
			logger.info("Error found : Hospital currency not set");			
			return false;
		}
		
		if(form.getHealthcareproviderPrice() >= 0.0){
			healthcareproviderPrice = form.getHealthcareproviderPrice();
		}
		HospitalSpecialtyTreatmentMethodModel hstmModel = super.getHospitalSpecialtyTreatmentMethodById(form.getHealthcareproviderSpecialtyTreatmentMethod());
		hstmModel.setHealthcareproviderPrice(healthcareproviderPrice);
		super.setHospitalSpecialtyTreatmentMethod(hstmModel);
		if(form.getPractitioner() != null){
			logger.info("practitioner list = {}",form.getPractitioner());
			for(BigInteger practitioner : form.getPractitioner()){
				for(HospitalSpecialtyTreatmentMethodPractitionerModel model : hstmpModelList){
					if(model.getPractitioner().equals(practitioner)){
						model.setActive(false);
						model.setHealthcareproviderPrice(healthcareproviderPrice);						
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
						model.setHealthcareproviderPrice(healthcareproviderPrice);			
						if(model.getPractitionerPrice() == null){
							model.setPractitionerPrice(0.0);
						}
						if(model.getAnesthesiaPrice() == null){
							model.setAnesthesiaPrice(0.0);
						}
						model.setCurrency(super.getHospitalCurrency(healthcareprovider));
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
				   model.setCurrency(super.getHospitalCurrency(healthcareprovider));				  
				   model.setAvailabilityDays(0);
				   model.setHealthcareproviderPrice(healthcareproviderPrice);
				   model.setPractitionerPrice(0.0);				   
				   model.setAnesthesiaPrice(0.0);
				   super.setHospitalSpecialtyTreatmentMethodPractitioner(model);
				   result = true;
			   }
		   }
		}
		return result;
	}
	
	public Boolean updateHospitalSpecialtyTreatmentMethod(BigInteger hospitalSpecialty,Boolean active){
		Boolean result = false;
		List<HospitalSpecialtyTreatmentMethodModel> hstmModel = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(hospitalSpecialty);
		for(HospitalSpecialtyTreatmentMethodModel model:hstmModel){
			model.setActive(active);
			super.setHospitalSpecialtyTreatmentMethod(model);			
			for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel:super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(model.getId())){
				hstmpModel.setActive(active);
				super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
			}
		}
		return result; 
	}
	
}