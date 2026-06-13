package com.dg.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.hospital.form.HospitalSpecialtyForm;
import com.dg.hospital.form.PractitionerAttestationsForm;
import com.dg.hospital.form.PractitionerLanguageForm;
import com.dg.hospital.form.PractitionerMethodForm;
import com.dg.hospital.form.PractitionerSpecialtyForm;
import com.dg.hospital.form.PractitionerStatsForm;
import com.dg.hospital.form.PractitionerTreatmentForm;
import com.dg.hospital.model.*;
import com.dg.hospital.model.form.PractitionerAttestationsFormModel;
import com.dg.hospital.model.form.PractitionerLanguageFormModel;
import com.dg.hospital.model.form.PractitionerMethodFormModel;
import com.dg.hospital.model.form.PractitionerStatsFormModel;

public class HospitalPractitionerService extends RestService{
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalPractitionerService.class);
	  
	private RestUrlService restUrlService;
	
	public RestUrlService getRestUrlService()
	{
	   return this.restUrlService;
	}
	  
	public void setRestUrlService(RestUrlService restUrlService)
	{
	   this.restUrlService = restUrlService;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return list
	 */
	public List<HospitalPractitionerModel> getHospitalPractitionerModel(BigInteger healthcareprovider){
		List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
		hospitalPracitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		return hospitalPracitionerModelList;
	}
	
	/**
	 * 
	 * @param practitioner
	 * @return list
	 */
	public List<PractitionerLanguageFormModel> getPractitionerLanguageFormModel(BigInteger practitioner){
	    List<PractitionerLanguageModel> practitionerLanguageModelList = super.getPractitionerLanguage(practitioner);
	    List<PractitionerLanguageFormModel> practitionerLanguageFormModelList = new ArrayList<PractitionerLanguageFormModel>();
	    Locale []availableLocale = Locale.getAvailableLocales();
		HashMap<String,String> language = new HashMap<String,String>();
		for(Locale locale : availableLocale){
			if(!locale.getLanguage().isEmpty()){
				language.put(locale.getLanguage(), locale.getDisplayLanguage());
			}
		}
		for(Map.Entry m:language.entrySet()){
			PractitionerLanguageFormModel model = new PractitionerLanguageFormModel();
			model.setPractitioner(practitioner);
			model.setLanguage(m.getKey().toString());
			model.setLanguageName(m.getValue().toString());
			model.setIsChecked(false);
		    practitionerLanguageFormModelList.add(model);
		}
		if(practitionerLanguageModelList != null){
		   for(PractitionerLanguageFormModel model:practitionerLanguageFormModelList){	
			   for(PractitionerLanguageModel practitionerLanguageModel : practitionerLanguageModelList){
				   if(model.getLanguage().equalsIgnoreCase(practitionerLanguageModel.getLanguage())){
					   model.setId(practitionerLanguageModel.getId());
					   model.setIsChecked(true);
				   }
			   }
		   }
		}
	    return practitionerLanguageFormModelList;
	}
	
	/**
	 * 
	 * @param form
	 * @return boolean
	 */
	public Boolean editPractitionerLanguage(PractitionerLanguageForm form){
		Boolean result = false;
		Integer edited = null;
		for(PractitionerLanguageFormModel practitionerLanguageFormModel:form.getPractitionerLanguageFormModel()){
			if(practitionerLanguageFormModel.getIsChecked().equals(true)){
				PractitionerLanguageModel model = new PractitionerLanguageModel();
				model.setId(practitionerLanguageFormModel.getId());
				model.setLanguage(practitionerLanguageFormModel.getLanguage());
				model.setPractitioner(practitionerLanguageFormModel.getPractitioner());
				edited = super.setPractitionerLanguage(model);
				if(edited > 0){
					result = true;
				}
			}else{
				if(practitionerLanguageFormModel.getId() != null){
					edited =super.deletePractitionerLanguage(practitionerLanguageFormModel.getId());
					if(edited > 0){
						result = true;
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param practitioner
	 * @return list
	 */
	public List<PractitionerAttestationsFormModel> getPractitionerAttestationsFormModel(BigInteger practitioner){
		List<PractitionerAttestationsFormModel> practitionerAttestationsFormModelList = new ArrayList<PractitionerAttestationsFormModel>();
		List<AttestationsModel> attestationsModelList = super.getAllAttestations();
		List<PractitionerAttestationsModel> practitionerAttestationsModelList = super.getPractitionerAttestations(practitioner);
		for(AttestationsModel attestationModel : attestationsModelList){
			PractitionerAttestationsFormModel model = new PractitionerAttestationsFormModel();
			model.setAttestation(attestationModel.getId());
			model.setAttestationName(attestationModel.getName());
			model.setPractitioner(practitioner);				
			practitionerAttestationsFormModelList.add(model);
		}
		if(practitionerAttestationsModelList != null){
			for(PractitionerAttestationsFormModel model:practitionerAttestationsFormModelList){
				for(PractitionerAttestationsModel practitionerAttestationsModel: practitionerAttestationsModelList){
					if(model.getAttestation().equals(practitionerAttestationsModel.getAttestation())){
						model.setId(practitionerAttestationsModel.getId());
						model.setValue(practitionerAttestationsModel.getValue());
					}
				}
			}
		}
		return practitionerAttestationsFormModelList;
	}
	
	/**
	 * 
	 * @param form
	 * @return boolean
	 */
	public Boolean editPractitionerAttestations(PractitionerAttestationsForm form){
		Boolean result = false;
		Integer edited = null;
		for(PractitionerAttestationsFormModel practitionerAttestationsFormModel:form.getPractitionerAttestationsFormModel()){
			if(practitionerAttestationsFormModel.getValue() != null){
				PractitionerAttestationsModel model = new PractitionerAttestationsModel();
				model.setId(practitionerAttestationsFormModel.getId());
				model.setValue(practitionerAttestationsFormModel.getValue());
				model.setAttestation(practitionerAttestationsFormModel.getAttestation());
				model.setPractitioner(practitionerAttestationsFormModel.getPractitioner());
				edited = super.setPractitionerAttestations(model);
				if(edited > 0){
					result = true;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * add new practitioner
	 * @param form
	 * @param edited
	 * @return boolean
	 */
	public Boolean addPractitionerSpecialty(PractitionerSpecialtyForm form,Boolean edited){
		Boolean result = false;
		Boolean found = false;		
		BigInteger practitioner,hstmId;
		Boolean specialtyEdited;		
		if(form.getPractitionerSpecialty() != null){
			logger.info("selected practitioner specialty list = {}",form.getPractitionerSpecialty());			
			practitioner = this.editPractitioner(form.getPractitionerModel());
			specialtyEdited = this.addHospitalSpecialty(form.getPractitionerSpecialty(),form.getHealthcareprovider());
			if(practitioner != null && specialtyEdited){				
				logger.info("practitioner added successfully with id = {}",practitioner);
				form.getPractitionerModel().setId(practitioner);
				List<HospitalSpecialtyModel> hospitalSpecialtyModelList = super.getHospitalSpecialty(form.getHealthcareprovider());
				for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getId() != null && form.getPractitionerSpecialty().contains(model.getSpecialty())){					
						this.editHospitalSpecialtyTreatmentMethod(model.getId());
					}
				}	
				for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getId() != null && form.getPractitionerSpecialty().contains(model.getSpecialty())){					
						hstmId = this.getHospitalSpecialtyTreatmentMethodByHospitalSpecialty(model.getId());
						if(hstmId != null){
							List<HospitalSpecialtyTreatmentMethodPractitionerModel> hstmpModelList = super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(hstmId);
							found = false;
							logger.info("hstm id ={}",hstmId);
							for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel : hstmpModelList){						
								if(hstmpModel.getPractitioner().equals(practitioner)){
									hstmpModel.setActive(true);
									super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
									found = true;
									result = true;								
								}
							}					
							if(!found){
								HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
								hstmpModel.setActive(true);
								hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(hstmId);
								hstmpModel.setPractitioner(practitioner);
								hstmpModel.setCurrency("USD");
								hstmpModel.setAvailabilityDays(0);
								hstmpModel.setHealthcareproviderPrice(0);
								hstmpModel.setPractitionerPrice(0);				   
								hstmpModel.setMethodPrice(0);
								super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
								result = true;
							}
						}
					}
				}
			}
		}
		if(edited && result){
			List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
			hospitalPracitionerModelList = super.getHospitalPractitioner(form.getHealthcareprovider());			
			for(BigInteger unSelectSpecialty: form.getSpecialtyModel()){
				found = false;			
				for(HospitalPractitionerModel model : hospitalPracitionerModelList){
					if(model.getId().equals(form.getPractitionerModel().getId()) && model.getSpecialtyId().equals(unSelectSpecialty)){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
						hstmpModel = this.getHospitalSpecialtyTreatmentMethodPractitionerById(model.getHstmp());
						hstmpModel.setActive(false);
						super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
						logger.info("deactive hstmp id ={}",hstmpModel.getId());
						result = true;
					}
				}								
			}	
		}
		return result;
	}
	
	/**
	 * 
	 * @param model
	 * @return id
	 */
	public BigInteger editPractitioner(PractitionerModel model){
		BigInteger id = null;
		Integer edited;	
		model.setRole(this.getPractitionerRole());	
		if(model.getPassword() == null){
			model.setPassword(String.valueOf(this.getRandomNumber(100000,1000000)));
		}
		if(model.getPhoto() == null){
			model.setPhoto("demo_user.gif");	
		}		
		edited = super.setPractitioner(model);
		logger.info("practitioner added successfully with id = {}",edited);
		if(edited > 0){
			id = BigInteger.valueOf(edited);
		}
		return id;
	}
	
	 public int getRandomNumber(int min,int max){
		  Random rand = new Random();
		  int random = rand.nextInt(max - min) + min;	 
		  return random;
	  }
	
	public Boolean addHospitalSpecialty(List<BigInteger> specialtyList,BigInteger healthcareprovider){
		Boolean result = false;
		Boolean found = false;
		int edited;
		List<HospitalSpecialtyModel> hospitalSpecialtyModelList = super.getHospitalSpecialty(healthcareprovider);
		HashMap<BigInteger,String> specialtyMap = new HashMap<BigInteger,String>();
		List<SpecialtyModel> specialtyModelList = super.getAllSpecialty();		
		for(SpecialtyModel specialtyModel : specialtyModelList){
			specialtyMap.put(specialtyModel.getId(), specialtyModel.getName());
		}
		if(!specialtyList.isEmpty()){
			for(BigInteger specialty : specialtyList){
				found = false;
				for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getSpecialty().equals(specialty)){
						found = true;						
						result = true;					
					}
				}
				if(!found){
					HospitalSpecialtyModel model = new HospitalSpecialtyModel();
					 model.setHealthcareprovider(healthcareprovider);
					 model.setName(specialtyMap.get(specialty));
					 model.setSpecialty(specialty);
					 edited = super.setHospitalSpecialty(model);
					 if(edited > 0){
						   result = true;
					 }
				}
			}
		}		
		logger.info("specialty added {}",result);
		return result;
	}
	
	/**
	 * edit hospitalSpecialtyTreatmentMethod
	 * @param id
	 * @return
	 */
	public Boolean editHospitalSpecialtyTreatmentMethod(BigInteger healthcareproviderSpecialty){
		Boolean result = false;
		Boolean found = false;
		Integer edited = null;
		BigInteger treatmentId = this.getTreatmentGeneralId();
		BigInteger methodId = this.getMethodGeneralId();
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(healthcareproviderSpecialty);
		for(HospitalSpecialtyTreatmentMethodModel model: hospitalSpecialtyTreatmentMethodModelList){
			if(model.getTreatment().equals(treatmentId) && model.getMethod().equals(methodId)){
				found = true;
				model.setActive(true);
				edited = super.setHospitalSpecialtyTreatmentMethod(model);
				if(edited > 0){
					result = true;
				}
			}
		}
		if(!found){
			   HospitalSpecialtyTreatmentMethodModel model = new HospitalSpecialtyTreatmentMethodModel();
			   model.setActive(true);
			   model.setHealthcareproviderSpecialty(healthcareproviderSpecialty);
			   model.setTreatment(treatmentId);
			   model.setMethod(methodId);
			   edited = super.setHospitalSpecialtyTreatmentMethod(model);
			   if(edited > 0){
					result = true;
			   }
		}
		return result;
	}
	
	public BigInteger getHospitalSpecialtyTreatmentMethodByHospitalSpecialty(BigInteger id){		
		BigInteger hstmId = null;
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(id);
		for(HospitalSpecialtyTreatmentMethodModel model: hospitalSpecialtyTreatmentMethodModelList){
			if(model.getTreatment().equals(this.getTreatmentGeneralId()) && model.getMethod().equals(this.getMethodGeneralId())){				
				hstmId = model.getId();			
			}
		}
		return hstmId;
	}	
	
	/**
	 * 
	 * @param practitioner
	 * @param healthcareprovider
	 * @return selected specialtylist
	 */
	public List<SpecialtyModel> getPractitionerSpecialtyFormList(BigInteger practitioner,BigInteger healthcareprovider){
		List<SpecialtyModel> practitionerSpecialtyModelList = new ArrayList<SpecialtyModel>();
		List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
		hospitalPracitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		List<BigInteger> specialty = new ArrayList<BigInteger>();
		for(HospitalPractitionerModel model : hospitalPracitionerModelList){
			if(model.getId().equals(practitioner)){
				if(!specialty.contains(model.getSpecialtyId())){
					SpecialtyModel specialtyModel = new SpecialtyModel();
					specialtyModel.setId(model.getSpecialtyId());
					specialtyModel.setName(model.getSpecialtyName());
					practitionerSpecialtyModelList.add(specialtyModel);
					specialty.add(model.getSpecialtyId());
				}
			}
		}
		return practitionerSpecialtyModelList;
	}
	
	/**
	 * 
	 * @param practitioner
	 * @param healthcareprovider
	 * @return unselected specialtylist
	 */
	public List<SpecialtyModel> getSpecialtyFormList(BigInteger practitioner,BigInteger healthcareprovider){
		Boolean found = false;		
		List<SpecialtyModel> specialtyFormList = new ArrayList<SpecialtyModel>();
		for(SpecialtyModel model: this.getAllSpecialty()){
			found = false;
			for(SpecialtyModel practitionerSpecialtyModel: this.getPractitionerSpecialtyFormList(practitioner, healthcareprovider)){
				if(model.getId().equals(practitionerSpecialtyModel.getId())){
					found = true;
				}
			}
			if(!found){
				specialtyFormList.add(model);
			}
		}		
		return specialtyFormList;
	}
	
	/**
	 * 
	 * @param practitioner
	 * @param healthcareprovider
	 * @return selected treatmentlist
	 */
	public List<TreatmentModel> getPractitionerTreatmentFormList(BigInteger practitioner,BigInteger healthcareprovider,BigInteger specialty){
		List<TreatmentModel> practitionerTreatmentModelList = new ArrayList<TreatmentModel>();
		List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
		hospitalPracitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		List<BigInteger> treatmentList = new ArrayList<BigInteger>();
		for(HospitalPractitionerModel model : hospitalPracitionerModelList){
			if(model.getId().equals(practitioner) && model.getSpecialtyId().equals(specialty)){
				if(!treatmentList.contains(model.getTreatmentId())){
					TreatmentModel treatmentModel = new TreatmentModel();
					treatmentModel.setId(model.getTreatmentId());
					treatmentModel.setName(model.getTreatmentName());
					practitionerTreatmentModelList.add(treatmentModel);
					treatmentList.add(model.getTreatmentId());
				}
			}
		}
		return practitionerTreatmentModelList;
	}
	
	/**
	 * 
	 * @param practitioner
	 * @param healthcareprovider
	 * @param specialty
	 * @param treatment
	 * @return selected methodlist
	 */
	public List<MethodModel> getPractitionerMethodFormList(BigInteger practitioner,BigInteger healthcareprovider,BigInteger specialty,BigInteger treatment){
		List<MethodModel> practitionerMethodModelList = new ArrayList<MethodModel>();
		List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
		hospitalPracitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		List<BigInteger> methodList = new ArrayList<BigInteger>();
		for(HospitalPractitionerModel model : hospitalPracitionerModelList){
			if(model.getId().equals(practitioner) && model.getSpecialtyId().equals(specialty) && model.getTreatmentId().equals(treatment)){
				if(!methodList.contains(model.getMethodId())){
					MethodModel methodModel = new MethodModel();
					methodModel.setId(model.getMethodId());
					methodModel.setName(model.getMethodName());
					practitionerMethodModelList.add(methodModel);
					methodList.add(model.getMethodId());
				}
			}
		}
		return practitionerMethodModelList;
	}
	
	/**
	 * 
	 * @param practitioner
	 * @param healthcareprovider
	 * @return unselected treatmentlist
	 */
	public List<TreatmentModel> getTreatmentFormList(BigInteger practitioner,BigInteger healthcareprovider,BigInteger specialty){
		Boolean found = false;		
		List<TreatmentModel> treatmentFormList = new ArrayList<TreatmentModel>();
		for(TreatmentModel model: this.getAllTreatment()){
			found = false;
			for(TreatmentModel practitionerTreatmentModel: this.getPractitionerTreatmentFormList(practitioner, healthcareprovider,specialty)){
				if(model.getId().equals(practitionerTreatmentModel.getId())){
					found = true;
				}
			}
			if(!found){
				treatmentFormList.add(model);
			}
		}		
		return treatmentFormList;
	}
	
	public Boolean editPractitionerTreatment(PractitionerTreatmentForm form){
		Boolean result = false;
		Boolean found = false;	
		Boolean hstmpFound = false;
		BigInteger healthcareproviderSpecialty = null;
		List<HospitalSpecialtyModel> hospitalSpecialtyModelList = super.getHospitalSpecialty(form.getHealthcareprovider());
		for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
			if(model.getId() != null && model.getSpecialty().equals(form.getPractitionerSpecialty())){					
				found = true;
				healthcareproviderSpecialty = model.getId();
			}
		}	
		if(found){
			for(BigInteger treatment: form.getSelectedTreatment()){
				List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatment(healthcareproviderSpecialty,treatment);
				if(!hospitalSpecialtyTreatmentMethodModelList.isEmpty()){
					for(HospitalSpecialtyTreatmentMethodModel model: hospitalSpecialtyTreatmentMethodModelList){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(model.getId(),form.getPractitioner());
						hstmpFound = false;
						if(hstmpModel.getId() != null){
							hstmpModel.setActive(true);
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
							hstmpFound = true;
							result = true;
						}
					}
					if(!hstmpFound){
						HospitalSpecialtyTreatmentMethodModel hospitalSpecialtyTreatmentMethodModel = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatmentMethod(healthcareproviderSpecialty,treatment,super.getMethodGeneralId());
						if(hospitalSpecialtyTreatmentMethodModel.getId() != null){
							HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
							hstmpModel.setActive(true);
							hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(hospitalSpecialtyTreatmentMethodModel.getId());
							hstmpModel.setPractitioner(form.getPractitioner());
							hstmpModel.setCurrency("USD");
							hstmpModel.setAvailabilityDays(0);
							hstmpModel.setHealthcareproviderPrice(0);
							hstmpModel.setPractitionerPrice(0);				   
							hstmpModel.setMethodPrice(0);
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
							result = true;
						}else{
							HospitalSpecialtyTreatmentMethodModel hstmModel = new HospitalSpecialtyTreatmentMethodModel();
							hstmModel.setActive(true);
							hstmModel.setHealthcareproviderSpecialty(healthcareproviderSpecialty);
							hstmModel.setTreatment(treatment);
							hstmModel.setMethod(super.getMethodGeneralId());
							int edited = super.setHospitalSpecialtyTreatmentMethod(hstmModel);
							if(edited > 0){
								HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
								hstmpModel.setActive(true);
								hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(BigInteger.valueOf(edited));
								hstmpModel.setPractitioner(form.getPractitioner());
								hstmpModel.setCurrency("USD");
								hstmpModel.setAvailabilityDays(0);
								hstmpModel.setHealthcareproviderPrice(0);
								hstmpModel.setPractitionerPrice(0);				   
								hstmpModel.setMethodPrice(0);
								super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
								result = true;
							}
						}
					}
				}else{
					HospitalSpecialtyTreatmentMethodModel hstmModel = new HospitalSpecialtyTreatmentMethodModel();
					hstmModel.setActive(true);
					hstmModel.setHealthcareproviderSpecialty(healthcareproviderSpecialty);
					hstmModel.setTreatment(treatment);
					hstmModel.setMethod(super.getMethodGeneralId());
					int edited = super.setHospitalSpecialtyTreatmentMethod(hstmModel);
					if(edited > 0){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
						hstmpModel.setActive(true);
						hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(BigInteger.valueOf(edited));
						hstmpModel.setPractitioner(form.getPractitioner());
						hstmpModel.setCurrency("USD");
						hstmpModel.setAvailabilityDays(0);
						hstmpModel.setHealthcareproviderPrice(0);
						hstmpModel.setPractitionerPrice(0);				   
						hstmpModel.setMethodPrice(0);
						super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
						result = true;
					}
				}
			}
		}
		if(!form.getTreatments().isEmpty() && found){
			for(BigInteger removeTreatment : form.getTreatments()){
				List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatment(healthcareproviderSpecialty,removeTreatment);
				if(!hospitalSpecialtyTreatmentMethodModelList.isEmpty()){
					for(HospitalSpecialtyTreatmentMethodModel model: hospitalSpecialtyTreatmentMethodModelList){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(model.getId(),form.getPractitioner());						
						if(hstmpModel.getId() != null){
							hstmpModel.setActive(false);
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
							result = true;
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param specialty
	 * @param treatment
	 * @param healthcareprovider
	 * @param practitioner
	 * @return
	 */
	public List<PractitionerMethodFormModel> getPractitionerMethodFormModel(BigInteger specialty,BigInteger treatment,BigInteger healthcareprovider,BigInteger practitioner){
		List<PractitionerMethodFormModel> practitionerMethodFormModelList = new ArrayList<PractitionerMethodFormModel>();		
		BigInteger healthcareproviderSpecialty = null;
		Boolean found = false;
		List<HospitalSpecialtyModel> hospitalSpecialtyModelList = super.getHospitalSpecialty(healthcareprovider);
		for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
			if(model.getId() != null && model.getSpecialty().equals(specialty)){		
				healthcareproviderSpecialty = model.getId();
				found = true;
			}
		}	
		if(found){
			List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatment(healthcareproviderSpecialty,treatment);
			if(!hospitalSpecialtyTreatmentMethodModelList.isEmpty()){
				for(HospitalSpecialtyTreatmentMethodModel model: hospitalSpecialtyTreatmentMethodModelList){
					HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(model.getId(),practitioner);					
					if(hstmpModel.getId() != null && hstmpModel.getActive()){						
						PractitionerMethodFormModel pracitionerMethodFormModel = new PractitionerMethodFormModel();
						pracitionerMethodFormModel.setMethod(model.getMethod());
						pracitionerMethodFormModel.setHstmId(model.getId());
						pracitionerMethodFormModel.setHstmpId(hstmpModel.getId());
						pracitionerMethodFormModel.setAvailabilityDays(hstmpModel.getAvailabilityDays());
						pracitionerMethodFormModel.setCorrectionsLastYear(hstmpModel.getCorrectionsLastYear());
						pracitionerMethodFormModel.setCurrency(hstmpModel.getCurrency());
						pracitionerMethodFormModel.setHealthcareproviderPrice(hstmpModel.getHealthcareproviderPrice());
						pracitionerMethodFormModel.setMethodPrice(hstmpModel.getMethodPrice());
						pracitionerMethodFormModel.setPractitionerPrice(hstmpModel.getPractitionerPrice());
						pracitionerMethodFormModel.setNumberPerformedLastYear(hstmpModel.getNumberPerformedLastYear());
						pracitionerMethodFormModel.setNumberPerformedOverall(hstmpModel.getNumberPerformedOverall());
						pracitionerMethodFormModel.setYearsPracticed(hstmpModel.getYearsPracticed());
						practitionerMethodFormModelList.add(pracitionerMethodFormModel);
					}
				}
			}
		}
		if(!practitionerMethodFormModelList.isEmpty())
		{
			for(MethodModel model:this.getAllMethod()){
				found = false;
				for(PractitionerMethodFormModel pmfModel:practitionerMethodFormModelList){
					if(model.getId().equals(pmfModel.getMethod())){
						found = true;
					}
				}
				if(!found){					
					PractitionerMethodFormModel pracitionerMethodFormModel = new PractitionerMethodFormModel();					
					pracitionerMethodFormModel.setCurrency("USD");														
					practitionerMethodFormModelList.add(pracitionerMethodFormModel);
				}
			}
		}else{
			for(MethodModel model:this.getAllMethod()){				
				PractitionerMethodFormModel pracitionerMethodFormModel = new PractitionerMethodFormModel();
				pracitionerMethodFormModel.setCurrency("USD");					
				practitionerMethodFormModelList.add(pracitionerMethodFormModel);				
			}
		}
		return practitionerMethodFormModelList;
	}
	
	/**
	 * 
	 * @param form
	 * @return boolean
	 */
	public Boolean editPractitionerMethod(PractitionerMethodForm form){
		Boolean result = false;
		BigInteger healthcareproviderSpecialty = null;
		for(HospitalSpecialtyModel model : super.getHospitalSpecialty(form.getHealthcareprovider())){
			if(model.getId() != null && model.getSpecialty().equals(form.getSpecialty())){		
				healthcareproviderSpecialty = model.getId();				
			}
		}	
		for(PractitionerMethodFormModel model : form.getPractitionerMethodFormModel()){			
			if(model.getMethod() != null){				
				if(model.getHstmId() != null){
					HospitalSpecialtyTreatmentMethodModel hstmModel = super.getHospitalSpecialtyTreatmentMethodById(model.getHstmId());
					if(hstmModel.getMethod().equals(model.getMethod())){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModels  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstmModel.getId(),form.getPractitioner());					
						if(hstmpModels.getId() != null){						
							result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModels,model,null,form.getPractitioner());						
						}
					}else{
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModels  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstmModel.getId(),form.getPractitioner());
						if(hstmpModels.getId() != null){							
							hstmpModels.setActive(false);	
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModels);
							result = true;
						}								
						HospitalSpecialtyTreatmentMethodModel hstm = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatmentMethod(healthcareproviderSpecialty, form.getTreatment(), model.getMethod());
						if(hstm.getId() != null){
							HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstm.getId(),form.getPractitioner());					
							if(hstmpModel.getId() != null){						
								result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel,model,null,form.getPractitioner());						
							}else{
								result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel,model,hstm.getId(),form.getPractitioner());
							}
						}else{
							BigInteger hstmId = this.editHospitalSpecialtyTreatMentMetod(form.getTreatment(), model.getMethod(),healthcareproviderSpecialty);
							HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel(); 
							result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel,model,hstmId,form.getPractitioner());
						}
					}
				}else{
					HospitalSpecialtyTreatmentMethodModel hstm = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatmentMethod(healthcareproviderSpecialty, form.getTreatment(), model.getMethod());
					if(hstm.getId() != null){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstm.getId(),form.getPractitioner());					
						if(hstmpModel.getId() != null){						
							result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel,model,null,form.getPractitioner());						
						}else{
							result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel,model,hstm.getId(),form.getPractitioner());
						}
					}else{
						BigInteger hstmId = this.editHospitalSpecialtyTreatMentMetod(form.getTreatment(), model.getMethod(),healthcareproviderSpecialty);
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
						result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel,model,hstmId,form.getPractitioner());
					}
				}
			}else{				
				if(model.getHstmId() != null){					
					HospitalSpecialtyTreatmentMethodModel hstmModel = super.getHospitalSpecialtyTreatmentMethodById(model.getHstmId());
					HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModels  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstmModel.getId(),form.getPractitioner());
					if(hstmpModels.getId() != null){						
						hstmpModels.setActive(false);	
						super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModels);
						result = true;					
					}					
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param hstmpModel
	 * @param model
	 * @param hstm
	 * @param practitioner
	 * @return boolean
	 */
	public Boolean editHospitalSpecialtyTreatmentMethodPractitioner(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel,PractitionerMethodFormModel model,BigInteger hstm,BigInteger practitioner){
		Boolean result = false;		
		hstmpModel.setActive(true);														
		hstmpModel.setCurrency(model.getCurrency());							
		hstmpModel.setHealthcareproviderPrice(model.getHealthcareproviderPrice());
		hstmpModel.setPractitionerPrice(model.getPractitionerPrice());				   
		hstmpModel.setMethodPrice(model.getMethodPrice());
		hstmpModel.setAvailabilityDays(model.getAvailabilityDays());		
		hstmpModel.setYearsPracticed(model.getYearsPracticed());
		hstmpModel.setNumberPerformedOverall(model.getNumberPerformedOverall());
		hstmpModel.setNumberPerformedLastYear(model.getNumberPerformedLastYear());
		hstmpModel.setCorrectionsLastYear(model.getCorrectionsLastYear());
		if(hstm != null){
			hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(hstm);
		}
		if(hstmpModel.getPractitioner() == null){
			hstmpModel.setPractitioner(practitioner);
		}
		super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
		result = true;		
		return result;
	}
	
	/**
	 * 
	 * @param treatment
	 * @param method
	 * @param healthcareprovider_specialty
	 * @return id
	 */
	public BigInteger editHospitalSpecialtyTreatMentMetod(BigInteger treatment,BigInteger method,BigInteger healthcareprovider_specialty){
		HospitalSpecialtyTreatmentMethodModel model = new HospitalSpecialtyTreatmentMethodModel();
		model.setActive(true);
		model.setTreatment(treatment);
		model.setMethod(method);
		model.setHealthcareproviderSpecialty(healthcareprovider_specialty);
		BigInteger edited = BigInteger.valueOf(super.setHospitalSpecialtyTreatmentMethod(model));
		return edited;
	}
	
	/**
	 * 
	 * @param specialty
	 * @param treatment
	 * @param method
	 * @param practitioner
	 * @param healthcareprovider
	 * @return PractitionerStatsFormModel List
	 */
	public List<PractitionerStatsFormModel> getPractitionerStatsFormModelList(BigInteger specialty,BigInteger treatment,BigInteger method,BigInteger practitioner,BigInteger healthcareprovider){
		List<PractitionerStatsFormModel> practitionerStatsFormModelList = new ArrayList<PractitionerStatsFormModel>();
		BigInteger healthcareproviderSpecialty = null;
		BigInteger hstmpId = null;
		for(HospitalSpecialtyModel model : super.getHospitalSpecialty(healthcareprovider)){
			if(model.getId() != null && model.getSpecialty().equals(specialty)){		
				healthcareproviderSpecialty = model.getId();				
			}
		}	
		if(healthcareproviderSpecialty != null){
			HospitalSpecialtyTreatmentMethodModel hstmModel = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatmentMethod(healthcareproviderSpecialty, treatment, method);
			if(hstmModel.getId() != null){
				HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstmModel.getId(), practitioner);
				if(hstmpModel.getId() != null){
					hstmpId = hstmpModel.getId();
				}
			}
		}
		if(hstmpId != null){
			List<StatsModel> statsModelList = super.getStats();
			for(StatsModel statsModel : statsModelList){
				PractitionerStatsFormModel practitionerStatsFormModel = new PractitionerStatsFormModel();
				practitionerStatsFormModel.setStat(statsModel.getId());
				practitionerStatsFormModel.setStatName(statsModel.getName());
				practitionerStatsFormModel.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(hstmpId);
				practitionerStatsFormModelList.add(practitionerStatsFormModel);
			}
			List<HospitalSpecialtyTreatmentMethodPractitionerStatModel> hstmpsModelList = super.getHospitalSpecialtyTreatmentMethodPractitionerStatByHstmp(hstmpId);
			for(PractitionerStatsFormModel practitionerStatsFormModel : practitionerStatsFormModelList){
				for(HospitalSpecialtyTreatmentMethodPractitionerStatModel hstmpsModel: hstmpsModelList){
					if(practitionerStatsFormModel.getStat().equals(hstmpsModel.getStat())){
						practitionerStatsFormModel.setId(hstmpsModel.getId());
						practitionerStatsFormModel.setDescription(hstmpsModel.getDescription());
					}
				}			
			}
		}
		return practitionerStatsFormModelList;
	}
	
	public Boolean editHospitalSpecialtyTreatmentMethodPractitionerStat(PractitionerStatsForm form){
		Boolean result = false;
		Integer edited = null;
		for(PractitionerStatsFormModel practitionerStatsFormModel:form.getPractitionerStatsFormModel()){
			if(practitionerStatsFormModel.getDescription() != null){
				HospitalSpecialtyTreatmentMethodPractitionerStatModel model = new HospitalSpecialtyTreatmentMethodPractitionerStatModel();
				model.setId(practitionerStatsFormModel.getId());
				model.setDescription(practitionerStatsFormModel.getDescription());
				model.setStat(practitionerStatsFormModel.getStat());
				model.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(practitionerStatsFormModel.getHealthcareproviderSpecialtyTreatmentMethodPractitioner());
				edited = super.setHospitalSpecialtyTreatmentMethodPractitionerStat(model);
				if(edited > 0){
					result = true;
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return list
	 */
	public List<SpecialtyModel> getHospitalPractitionerSpecialty(BigInteger healthcareprovider){
		List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
		List<SpecialtyModel> specialtyModelList = new ArrayList<SpecialtyModel>();
		hospitalPracitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		List<BigInteger> specialtyList = new ArrayList<BigInteger>();
		for(HospitalPractitionerModel model:hospitalPracitionerModelList){
			if(!specialtyList.contains(model.getSpecialtyId())){
				SpecialtyModel specialtyModel = new SpecialtyModel();
				specialtyModel.setId(model.getSpecialtyId());
			    specialtyModel.setName(model.getSpecialtyName());
			    specialtyModelList.add(specialtyModel);
			    specialtyList.add(model.getSpecialtyId());
			}
		}
		return specialtyModelList;
	}
}