package com.dg.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.hospital.form.HospitalPractitionerForm;
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
		List<HospitalPractitionerModel> hospitalPractitionerModelList = null;
		List<HospitalPractitionerModel> hospitalPractitionerModelActiveList = new ArrayList<HospitalPractitionerModel>();
		hospitalPractitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		Set<BigInteger> result = new HashSet<BigInteger>();
		HashMap<BigInteger,List<String>> practitionerSpecialty = new HashMap<BigInteger,List<String>>();
		HashMap<BigInteger,List<String>> practitionerTreatment = new HashMap<BigInteger,List<String>>();
		if(!hospitalPractitionerModelList.isEmpty()){
			for(HospitalPractitionerModel model : hospitalPractitionerModelList){
				if(model.getActive() && result.add(model.getId())){					
					hospitalPractitionerModelActiveList.add(model);
				}
				if(!practitionerSpecialty.containsKey(model.getId())){
					List<String> list = new ArrayList<String>();
					if(model.getActive()){
						list.add("s"+model.getSpecialtyId());
						practitionerSpecialty.put(model.getId(), list);
					}
				}else{
					if(model.getActive()){
						List<String> list = practitionerSpecialty.get(model.getId());
						if(!list.contains(model.getSpecialtyId())){
							list.add("s"+model.getSpecialtyId());
						}
					}
				}
				if(!practitionerTreatment.containsKey(model.getId())){
					List<String> list = new ArrayList<String>();
					if(model.getActive()){
						list.add("t"+model.getTreatmentId());
						practitionerTreatment.put(model.getId(), list);
					}
				}else{
					if(model.getActive()){
						List<String> list = practitionerTreatment.get(model.getId());
						if(!list.contains(model.getTreatmentId())){
							list.add("t"+model.getTreatmentId());
						}
					}
				}
				
			}
			ArrayList<String> list;
			for(HospitalPractitionerModel model : hospitalPractitionerModelActiveList){
				if(practitionerSpecialty.containsKey(model.getId())){
					String specialtyClass = "";
					Set<String> set = new HashSet<String>(practitionerSpecialty.get(model.getId()));
					list = new ArrayList<String>(set);
					for(int i=0;i<list.size();i++){
		    			if(list.get(i) != null){
		    				specialtyClass += list.get(i).toString() + " ";
		    			}
		    		}
					model.setSpecialtyClass(specialtyClass);
				}
				
				if(practitionerTreatment.containsKey(model.getId())){
					String treatmentClass = "";
					Set<String> set = new HashSet<String>(practitionerTreatment.get(model.getId()));
					list = new ArrayList<String>(set);
					for(int i=0;i<list.size();i++){
		    			if(list.get(i) != null){
		    				treatmentClass += list.get(i).toString() + " ";
		    			}
		    		}
					model.setTreatmentClass(treatmentClass);
				}
			}
		}
		return hospitalPractitionerModelActiveList;
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
		String currency = super.getHospitalCurrency(form.getHealthcareprovider());
		if(currency.isEmpty()){
			return false;
		}
		Boolean result = false;
		Boolean found = false;		
		BigInteger practitioner,hstmId;
		Boolean specialtyEdited;
		PractitionerModel practitionerModel = new PractitionerModel();
		if(form.getPractitionerSpecialty() != null){
			logger.info("selected practitioner specialty list = {}",form.getPractitionerSpecialty());
			practitionerModel = this.getPractitionerByEmail(form.getPractitionerModel().getEmail());
			if(practitionerModel.getId() != null){
				//this.editHospitalPractitioner(form,currency,practitionerModel.getId());
				PractitionerModel model = form.getPractitionerModel();
				model.setId(practitionerModel.getId());
				model.setTitle(practitionerModel.getTitle());
				model.setFirstName(practitionerModel.getFirstName());
				model.setLastName(practitionerModel.getLastName());
				model.setMobile(practitionerModel.getMobile());
				model.setDescription(practitionerModel.getDescription());
				this.editPractitioner(model);
				practitioner = practitionerModel.getId();
				logger.info("practitioner name ={}",form.getPractitionerModel().getFirstName());
				
			}else{
				practitioner = this.editPractitioner(form.getPractitionerModel());
				//this.editHospitalPractitioner(form,currency,practitioner);
			}
			
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
									hstmpModel.setCurrency(currency);
									logger.info("currency = {}",currency);
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
								hstmpModel.setCurrency(currency);
								hstmpModel.setAvailabilityDays(0);
								hstmpModel.setHealthcareproviderPrice(0.0);
								hstmpModel.setPractitionerPrice(0.0);				   
								hstmpModel.setAnesthesiaPrice(0.0);
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
						hstmpModel.setCurrency(currency);
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
		logger.info("password ={}",model.getPassword());
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
						model.setActive(true);
						super.setHospitalSpecialty(model);
						found = true;						
						result = true;					
					}
				}
				if(!found){
					HospitalSpecialtyModel model = new HospitalSpecialtyModel();
					 model.setHealthcareprovider(healthcareprovider);
					 model.setName(specialtyMap.get(specialty));
					 model.setSpecialty(specialty);
					 model.setActive(true);
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
			   model.setHealthcareproviderPrice(0.0);
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
	
	public HospitalSpecialtyTreatmentMethodModel getHospitalSpecialtyTreatmentMethodByHospitalSpecialtyId(BigInteger id){		
		HospitalSpecialtyTreatmentMethodModel hstmModel = new HospitalSpecialtyTreatmentMethodModel();
		List<HospitalSpecialtyTreatmentMethodModel> hospitalSpecialtyTreatmentMethodModelList = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialty(id);
		for(HospitalSpecialtyTreatmentMethodModel model: hospitalSpecialtyTreatmentMethodModelList){
			if(model.getTreatment().equals(this.getTreatmentGeneralId()) && model.getMethod().equals(this.getMethodGeneralId())){				
				hstmModel = model;
				break;
			}
		}
		return hstmModel;
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
			if(model.getId().equals(practitioner) && model.getActive()){
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
				if(!treatmentList.contains(model.getTreatmentId()) && model.getActive()){
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
				if(!methodList.contains(model.getMethodId()) && model.getActive()){
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
		List<TreatmentModel> treatmentModelList = new ArrayList<TreatmentModel>();
		List<HospitalSpecialtyTreatmentMethodModel> specialtyTreatmentModelList = super.getHospitalSpecialtyTreatmentMethodBySpecialty(specialty);
		for(TreatmentModel model: this.getAllTreatment()){
			found = false;
			for(TreatmentModel practitionerTreatmentModel: this.getPractitionerTreatmentFormList(practitioner, healthcareprovider,specialty)){
				if(model.getId().equals(practitionerTreatmentModel.getId())){
					found = true;
				}
			}
			if(!found){
				treatmentModelList.add(model);
			}
		}
		for(TreatmentModel model: treatmentModelList){
			found = false;
			for(HospitalSpecialtyTreatmentMethodModel hstm : specialtyTreatmentModelList){
				if(hstm.getTreatment().equals(model.getId())){
					found = true;
				}
			}
			if(found){
				treatmentFormList.add(model);
			}
		}
		return treatmentFormList;
	}
	
	/**
	 * 
	 * @param practitioner
	 * @param healthcareprovider
	 * @return unselected treatmentlist
	 */
	public List<TreatmentModel> getOtherTreatmentFormList(BigInteger practitioner,BigInteger healthcareprovider,BigInteger specialty){
		Boolean found = false;		
		List<TreatmentModel> treatmentFormList = new ArrayList<TreatmentModel>();
		List<TreatmentModel> treatmentModelList = new ArrayList<TreatmentModel>();
		List<HospitalSpecialtyTreatmentMethodModel> specialtyTreatmentModelList = super.getHospitalSpecialtyTreatmentMethodBySpecialty(specialty);
		for(TreatmentModel model: this.getAllTreatment()){
			found = false;
			for(TreatmentModel practitionerTreatmentModel: this.getPractitionerTreatmentFormList(practitioner, healthcareprovider,specialty)){
				if(model.getId().equals(practitionerTreatmentModel.getId())){
					found = true;
				}
			}
			if(!found){
				treatmentModelList.add(model);
			}
		}
		for(TreatmentModel model: treatmentModelList){
			found = false;
			for(HospitalSpecialtyTreatmentMethodModel hstm : specialtyTreatmentModelList){
				if(hstm.getTreatment().equals(model.getId())){
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
		String currency = super.getHospitalCurrency(form.getHealthcareprovider());
		if(currency == null || currency.isEmpty()){
			return false;
		}
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
							hstmpModel.setCurrency(currency);
							hstmpModel.setAvailabilityDays(0);
							hstmpModel.setHealthcareproviderPrice(0.0);
							hstmpModel.setPractitionerPrice(0.0);				   
							hstmpModel.setAnesthesiaPrice(0.0);
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
							result = true;
						}else{
							HospitalSpecialtyTreatmentMethodModel hstmModel = new HospitalSpecialtyTreatmentMethodModel();
							hstmModel.setActive(true);
							hstmModel.setHealthcareproviderSpecialty(healthcareproviderSpecialty);
							hstmModel.setTreatment(treatment);
							hstmModel.setMethod(super.getMethodGeneralId());
							hstmModel.setHealthcareproviderPrice(0.0);
							int edited = super.setHospitalSpecialtyTreatmentMethod(hstmModel);
							if(edited > 0){
								HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
								hstmpModel.setActive(true);
								hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(BigInteger.valueOf(edited));
								hstmpModel.setPractitioner(form.getPractitioner());
								hstmpModel.setCurrency(currency);
								hstmpModel.setAvailabilityDays(0);
								hstmpModel.setHealthcareproviderPrice(0.0);
								hstmpModel.setPractitionerPrice(0.0);				   
								hstmpModel.setAnesthesiaPrice(0.0);
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
					hstmModel.setHealthcareproviderPrice(0.0);
					int edited = super.setHospitalSpecialtyTreatmentMethod(hstmModel);
					if(edited > 0){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
						hstmpModel.setActive(true);
						hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(BigInteger.valueOf(edited));
						hstmpModel.setPractitioner(form.getPractitioner());
						hstmpModel.setCurrency(currency);
						hstmpModel.setAvailabilityDays(0);
						hstmpModel.setHealthcareproviderPrice(0.0);
						hstmpModel.setPractitionerPrice(0.0);				   
						hstmpModel.setAnesthesiaPrice(0.0);
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
						pracitionerMethodFormModel.setAnesthesiaPrice(hstmpModel.getAnesthesiaPrice());
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
					//PractitionerMethodFormModel pracitionerMethodFormModel = new PractitionerMethodFormModel();					
					//pracitionerMethodFormModel.setCurrency("USD");														
					practitionerMethodFormModelList.add(this.getPractitionerMethodFormModel(healthcareprovider));
				}
			}
		}else{
			for(MethodModel model:this.getAllMethod()){				
				//PractitionerMethodFormModel pracitionerMethodFormModel = new PractitionerMethodFormModel();
				//pracitionerMethodFormModel.setCurrency("USD");					
				practitionerMethodFormModelList.add(this.getPractitionerMethodFormModel(healthcareprovider));				
			}
		}
		return practitionerMethodFormModelList;
	}
	
	public PractitionerMethodFormModel getPractitionerMethodFormModel(BigInteger healthcareprovider){
		String currency = super.getHospitalCurrency(healthcareprovider);
		if(currency == null || currency.isEmpty()){			
			currency = "USD";
		}
		PractitionerMethodFormModel pracitionerMethodFormModel = new PractitionerMethodFormModel();
		pracitionerMethodFormModel.setHstmId(BigInteger.valueOf(0));
		pracitionerMethodFormModel.setHstmpId(BigInteger.valueOf(0));
		pracitionerMethodFormModel.setAvailabilityDays(0);
		pracitionerMethodFormModel.setCorrectionsLastYear(0);
		pracitionerMethodFormModel.setCurrency(currency);
		pracitionerMethodFormModel.setHealthcareproviderPrice(Double.valueOf(0));
		pracitionerMethodFormModel.setAnesthesiaPrice(Double.valueOf(0));
		pracitionerMethodFormModel.setPractitionerPrice(Double.valueOf(0));
		pracitionerMethodFormModel.setNumberPerformedLastYear(0);
		pracitionerMethodFormModel.setNumberPerformedOverall(0);
		pracitionerMethodFormModel.setYearsPracticed(0);
		return pracitionerMethodFormModel;
	}
	
	/**
	 * 
	 * @param form
	 * @return boolean
	 */
	public Boolean editPractitionerMethod(PractitionerMethodForm form){
		String currency = super.getHospitalCurrency(form.getHealthcareprovider());
		if(currency == null || currency.isEmpty()){
			logger.info("Error :hospital currency not found ");
			return false;
		}		
		Boolean result = false;
		BigInteger healthcareproviderSpecialty = null;
		for(HospitalSpecialtyModel model : super.getHospitalSpecialty(form.getHealthcareprovider())){
			if(model.getId() != null && model.getSpecialty().equals(form.getSpecialty())){		
				healthcareproviderSpecialty = model.getId();				
			}
		}	
		
		
		for(PractitionerMethodFormModel model : form.getPractitionerMethodFormModel()){						
			if(model.getMethod() != null){				
				if(!model.getHstmId().equals(BigInteger.valueOf(0))){
					HospitalSpecialtyTreatmentMethodModel hstmModel = super.getHospitalSpecialtyTreatmentMethodById(model.getHstmId());
					if(hstmModel.getMethod().equals(model.getMethod())){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModels  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstmModel.getId(),form.getPractitioner());					
						if(hstmpModels.getId() != null){							
							result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModels,model,null,form.getPractitioner());						
						}
					}else{
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModels  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstmModel.getId(),form.getPractitioner());
						logger.info("hstm id {}",hstmpModels.getId());
						if(hstmpModels.getId() != null){							
							hstmpModels.setActive(false);	
							super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModels);
							result = true;
						}								
						HospitalSpecialtyTreatmentMethodModel hstm = super.getHospitalSpecialtyTreatmentMethodByHealthcareproviderSpecialtyTreatmentMethod(healthcareproviderSpecialty, form.getTreatment(), model.getMethod());
						logger.info("hstm id {}",hstm.getId());
						if(hstm.getId() != null){
							HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel  =super.getHospitalSpecialtyTreatmentMethodPractitionerByHstmPractitioner(hstm.getId(),form.getPractitioner());					
							if(hstmpModel.getId() != null){						
								result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel,model,null,form.getPractitioner());						
							}else{
								result = this.editHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel,model,hstm.getId(),form.getPractitioner());
							}
						}else{
							BigInteger hstmId = this.editHospitalSpecialtyTreatMentMetod(form.getTreatment(), model.getMethod(),healthcareproviderSpecialty);
							logger.info("new hstm id {}",hstmId);
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
				if(!model.getHstmId().equals(BigInteger.valueOf(0))){		
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
		hstmpModel.setAnesthesiaPrice(model.getAnesthesiaPrice());
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
		model.setHealthcareproviderPrice(0.0);
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
				practitionerStatsFormModel.setId(BigInteger.valueOf(0));
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
			logger.info("description = {}",practitionerStatsFormModel.getDescription());
			logger.info("id = {}",practitionerStatsFormModel.getId());
			if(practitionerStatsFormModel.getDescription() != null){
				HospitalSpecialtyTreatmentMethodPractitionerStatModel model = new HospitalSpecialtyTreatmentMethodPractitionerStatModel();
				model.setId(null);
				if(!practitionerStatsFormModel.getId().equals(0)){
					model.setId(practitionerStatsFormModel.getId());
				}
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
			if(!specialtyList.contains(model.getSpecialtyId()) && model.getActive()){
				SpecialtyModel specialtyModel = new SpecialtyModel();
				specialtyModel.setId(model.getSpecialtyId());
			    specialtyModel.setName(model.getSpecialtyName());
			    specialtyModelList.add(specialtyModel);
			    specialtyList.add(model.getSpecialtyId());
			}
		}
		return specialtyModelList;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return list
	 */
	public List<TreatmentModel> getHospitalPractitionerTreatment(BigInteger healthcareprovider){
		List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
		List<TreatmentModel> treatmentModelList = new ArrayList<TreatmentModel>();
		hospitalPracitionerModelList = super.getHospitalPractitioner(healthcareprovider);
		List<BigInteger> treatmentList = new ArrayList<BigInteger>();
		for(HospitalPractitionerModel model:hospitalPracitionerModelList){			
			if(!treatmentList.contains(model.getTreatmentId()) && model.getActive()){
				logger.info("active ={}",model.getActive());
				logger.info("doctor ={}",model.getId());
				TreatmentModel treatmentModel = new TreatmentModel();
				treatmentModel.setId(model.getTreatmentId());
				treatmentModel.setName(model.getTreatmentName());
				treatmentModelList.add(treatmentModel);
			    treatmentList.add(model.getTreatmentId());
			}
		}
		return treatmentModelList;
	}
	
	public PractitionerModel getPractitionerByEmail(String email){
		PractitionerModel practitionerModel = new PractitionerModel();
		for(PractitionerModel model:super.getAllPractitioner()){
			if(model.getEmail().equalsIgnoreCase(email)){
				practitionerModel = model;
			}
		}
		return practitionerModel;
	}
	
	public Boolean editHospitalPractitioner(HospitalPractitionerForm form)
	{
		Boolean result = false;
		HospitalPractitionerDetailModel hpModel = new HospitalPractitionerDetailModel();
		if(form.getId() == null){
			hpModel.setId(this.getHospitalPractitionerDetailIdByEmail(form.getEmail(), form.getHealthcareprovider()));			
		}else{
			hpModel.setId(form.getId());
		}	
		
		hpModel.setTitle(form.getTitle());		
		hpModel.setFirstName(form.getFirstName());
		hpModel.setLastName(form.getLastName());
		hpModel.setMobile(form.getMobile());
		hpModel.setEmail(form.getEmail());
		hpModel.setDescription(form.getDescription());
		hpModel.setInsuranceCap(form.getInsuranceCap());
		hpModel.setCurrency(form.getCurrency());	
		hpModel.setHealthcareprovider(form.getHealthcareprovider());
		hpModel.setPractitioner(form.getPractitioner());
		hpModel.setPolicyFile(form.getPolicyFile());
		hpModel.setType(form.getType());
		Integer edited = super.setHospitalPractitioner(hpModel);
		if(edited > 0){
			result = true;
		}
		return result;
	}
	
	public Boolean isPractitionerAvailable(String email,BigInteger healthcareprovider){
		Boolean result = true;
		for(HospitalPractitionerDetailModel model: super.getAllHospitalPractitioner()){
			if(model.getEmail().equalsIgnoreCase(email) && model.getHealthcareprovider().equals(healthcareprovider)){
				result = false;
			}
		}
		return result;
	}
	
	public BigInteger getHospitalPractitionerDetailIdByEmail(String email,BigInteger healthcareprovider){
		BigInteger id = null;
		for(HospitalPractitionerDetailModel model: super.getAllHospitalPractitioner()){
			if(model.getEmail().equalsIgnoreCase(email) && model.getHealthcareprovider().equals(healthcareprovider)){
				id = model.getId();
			}
		}
		return id;
	}
	
	public HospitalPractitionerDetailModel getHospitalPractitionerDetailIdByHospitalPractitioner(BigInteger practitioner,BigInteger healthcareprovider){
		HospitalPractitionerDetailModel hospitalPractitionerModel = new HospitalPractitionerDetailModel();
		for(HospitalPractitionerDetailModel model: super.getAllHospitalPractitioner()){
			if(model.getPractitioner().equals(practitioner) && model.getHealthcareprovider().equals(healthcareprovider)){
				hospitalPractitionerModel = model;
			}
		}
		return hospitalPractitionerModel;
	}
	
	public PractitionerModel getPractitionerFormModelById(BigInteger id,BigInteger healthcareprovider){
		PractitionerModel model = super.getPractitionerById(id);
		HospitalPractitionerDetailModel hpModel = this.getHospitalPractitionerDetailIdByHospitalPractitioner(id, healthcareprovider);
		
		if(hpModel.getId() != null){
			model.setTitle(hpModel.getTitle());
			if(hpModel.getFirstName() != null && hpModel.getFirstName().length() > 0 ){
				model.setFirstName(hpModel.getFirstName());
			}
			if(hpModel.getLastName() !=null && hpModel.getLastName().length() > 0){
				model.setLastName(hpModel.getLastName());
			}
			if(hpModel.getEmail() != null && hpModel.getEmail().length() > 0){
				model.setEmail(hpModel.getEmail());
			}			
			if(hpModel.getDescription() != null && hpModel.getDescription().length() > 0){
				model.setDescription(hpModel.getDescription());
			}
			if(hpModel.getMobile() != null && hpModel.getMobile().length() > 0){
				model.setMobile(hpModel.getMobile());
			}			
			model.setType(hpModel.getType());
			
		}
		return model;
	}
	
	/**
	 * add new practitioner
	 * @param form
	 * @param edited
	 * @return boolean
	 */
	public Boolean addHospitalPractitioner(HospitalPractitionerForm form){		
		Boolean result = false;
		Boolean found = false;		
		BigInteger practitioner;
		Boolean specialtyEdited;
		Double healthcareproviderPrice = 0.0;
		PractitionerModel practitionerModel = new PractitionerModel();
		if(form.getPractitionerSpecialty() != null){
			logger.info("selected practitioner specialty list = {}",form.getPractitionerSpecialty());
				practitionerModel = this.getPractitionerByEmail(form.getEmail());
				practitionerModel.setDob(form.getDob());
				practitionerModel.setMobile(form.getMobile());
				practitionerModel.setPhone(form.getPhone());
				practitionerModel.setAddress_1(form.getAddress_1());
				practitionerModel.setAddress_2(form.getAddress_2());
				practitionerModel.setZipCode(form.getZipCode());
				practitionerModel.setCity(form.getCity());
				practitionerModel.setGender(form.getGender());
				practitionerModel.setUsaCertification(form.getUsaCertification());
				practitionerModel.setUsaTraining(form.getUsaTraining());
				practitionerModel.setGraduationDt(form.getGraduationDt());
				practitionerModel.setGraduationInstitution(form.getGraduationInstitution());
				practitionerModel.setSpecialtyDt(form.getSpecialtyDt());
				practitionerModel.setSpecialtyInstitution(form.getSpecialtyInstitution());
				practitionerModel.setDegree(form.getDegree());
				practitionerModel.setMedicalLicense(form.getMedicalLicense());
				practitionerModel.setDescription(form.getDescription());				
			if(practitionerModel.getId() != null){
				form.setPractitioner(practitionerModel.getId());								
				this.editPractitioner(practitionerModel);				
				this.editHospitalPractitioner(form);				
			}else{
				practitionerModel.setTitle(form.getTitle());
				practitionerModel.setFirstName(form.getFirstName());
				practitionerModel.setLastName(form.getLastName());				
				practitionerModel.setEmail(form.getEmail());			
				practitionerModel.setType(form.getType());
				practitioner = this.editPractitioner(practitionerModel);
				form.setPractitioner(practitioner);
				this.editHospitalPractitioner(form);
			}
			
			specialtyEdited = this.addHospitalSpecialty(form.getPractitionerSpecialty(),form.getHealthcareprovider());
			if(form.getPractitioner() != null && specialtyEdited){				
				logger.info("practitioner added successfully with id = {}",form.getPractitioner());				
				List<HospitalSpecialtyModel> hospitalSpecialtyModelList = super.getHospitalSpecialty(form.getHealthcareprovider());
				for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getId() != null && form.getPractitionerSpecialty().contains(model.getSpecialty())){					
						this.editHospitalSpecialtyTreatmentMethod(model.getId());
					}
				}	
				for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getId() != null && form.getPractitionerSpecialty().contains(model.getSpecialty())){					
						HospitalSpecialtyTreatmentMethodModel hstmModel = this.getHospitalSpecialtyTreatmentMethodByHospitalSpecialtyId(model.getId());
						if(hstmModel.getId() != null){
							if(hstmModel.getHealthcareproviderPrice() != 0.0){
								healthcareproviderPrice = hstmModel.getHealthcareproviderPrice();
							}
							List<HospitalSpecialtyTreatmentMethodPractitionerModel> hstmpModelList = super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(hstmModel.getId());
							found = false;
							logger.info("hstm id ={}",hstmModel.getId());
							for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel : hstmpModelList){						
								if(hstmpModel.getPractitioner().equals(form.getPractitioner())){
									hstmpModel.setActive(true);
									hstmpModel.setCurrency(form.getCurrency());
									hstmpModel.setHealthcareproviderPrice(healthcareproviderPrice);									
									logger.info("currency = {}",form.getCurrency());
									super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
									found = true;
									result = true;								
								}
							}					
							if(!found){
								HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
								hstmpModel.setActive(true);
								hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(hstmModel.getId());
								hstmpModel.setPractitioner(form.getPractitioner());
								hstmpModel.setCurrency(form.getCurrency());
								hstmpModel.setAvailabilityDays(0);
								hstmpModel.setHealthcareproviderPrice(healthcareproviderPrice);
								hstmpModel.setPractitionerPrice(0.0);				   
								hstmpModel.setAnesthesiaPrice(0.0);
								super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
								result = true;
							}
						}
					}
				}
			}
		}
		if(result){
			List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
			hospitalPracitionerModelList = super.getHospitalPractitioner(form.getHealthcareprovider());			
			for(BigInteger unSelectSpecialty: form.getSpecialtyModel()){
				found = false;			
				for(HospitalPractitionerModel model : hospitalPracitionerModelList){
					if(model.getId().equals(form.getPractitioner()) && model.getSpecialtyId().equals(unSelectSpecialty)){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
						hstmpModel = this.getHospitalSpecialtyTreatmentMethodPractitionerById(model.getHstmp());
						hstmpModel.setActive(false);
						hstmpModel.setCurrency(form.getCurrency());
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
	 * add new practitioner
	 * @param form
	 * @param edited
	 * @return boolean
	 */
	public Boolean editHospitalPractitionerSpecialty(HospitalPractitionerForm form){		
		Boolean result = false;
		Boolean found = false;		
		Boolean specialtyEdited;
		Double healthcareproviderPrice = 0.0;
		PractitionerModel practitionerModel = new PractitionerModel();
		if(form.getPractitionerSpecialty() != null){
			logger.info("selected practitioner specialty list = {}",form.getPractitionerSpecialty());
				practitionerModel = this.getPractitionerById(form.getPractitioner());										
			if(practitionerModel.getId() != null){
				practitionerModel.setDob(form.getDob());
				practitionerModel.setGender(form.getGender());
				practitionerModel.setPhone(form.getPhone());				
				practitionerModel.setAddress_1(form.getAddress_1());
				practitionerModel.setAddress_2(form.getAddress_2());
				practitionerModel.setZipCode(form.getZipCode());
				practitionerModel.setCity(form.getCity());
				this.editPractitioner(practitionerModel);
				this.editHospitalPractitioner(form);
			}			
			specialtyEdited = this.addHospitalSpecialty(form.getPractitionerSpecialty(),form.getHealthcareprovider());
			if(form.getPractitioner() != null && specialtyEdited){				
				logger.info("practitioner added successfully with id = {}",form.getPractitioner());				
				List<HospitalSpecialtyModel> hospitalSpecialtyModelList = super.getHospitalSpecialty(form.getHealthcareprovider());
				for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getId() != null && form.getPractitionerSpecialty().contains(model.getSpecialty())){					
						this.editHospitalSpecialtyTreatmentMethod(model.getId());
					}
				}	
				for(HospitalSpecialtyModel model : hospitalSpecialtyModelList){
					if(model.getId() != null && form.getPractitionerSpecialty().contains(model.getSpecialty())){					
						HospitalSpecialtyTreatmentMethodModel hstmModel = this.getHospitalSpecialtyTreatmentMethodByHospitalSpecialtyId(model.getId());
						if(hstmModel.getId() != null){
							List<HospitalSpecialtyTreatmentMethodPractitionerModel> hstmpModelList = super.getHospitalSpecialtyTreatmentMethodPractitionerByHstm(hstmModel.getId());
							found = false;
							if(hstmModel.getHealthcareproviderPrice() != 0.0){
								healthcareproviderPrice = hstmModel.getHealthcareproviderPrice();
							}
							logger.info("hstm id ={}",hstmModel.getId());
							for(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel : hstmpModelList){						
								if(hstmpModel.getPractitioner().equals(form.getPractitioner())){
									hstmpModel.setActive(true);
									hstmpModel.setHealthcareproviderPrice(healthcareproviderPrice);
									hstmpModel.setCurrency(form.getCurrency());
									logger.info("currency = {}",form.getCurrency());
									super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
									found = true;
									result = true;								
								}
							}					
							if(!found){
								HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
								hstmpModel.setActive(true);
								hstmpModel.setHealthcareproviderSpecialtyTreatmentMethod(hstmModel.getId());
								hstmpModel.setPractitioner(form.getPractitioner());
								hstmpModel.setCurrency(form.getCurrency());
								hstmpModel.setAvailabilityDays(0);
								hstmpModel.setHealthcareproviderPrice(healthcareproviderPrice);
								hstmpModel.setPractitionerPrice(0.0);				   
								hstmpModel.setAnesthesiaPrice(0.0);
								super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
								result = true;
							}
						}
					}
				}
			}
		}
		if(result){
			List<HospitalPractitionerModel> hospitalPracitionerModelList = null;
			hospitalPracitionerModelList = super.getHospitalPractitioner(form.getHealthcareprovider());			
			for(BigInteger unSelectSpecialty: form.getSpecialtyModel()){
				found = false;			
				for(HospitalPractitionerModel model : hospitalPracitionerModelList){
					if(model.getId().equals(form.getPractitioner()) && model.getSpecialtyId().equals(unSelectSpecialty)){
						HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel = new HospitalSpecialtyTreatmentMethodPractitionerModel();
						hstmpModel = this.getHospitalSpecialtyTreatmentMethodPractitionerById(model.getHstmp());
						hstmpModel.setActive(false);
						hstmpModel.setCurrency(form.getCurrency());
						super.setHospitalSpecialtyTreatmentMethodPractitioner(hstmpModel);
						logger.info("deactive hstmp id ={}",hstmpModel.getId());
						result = true;
					}
				}								
			}	
		}
		return result;
	}
	
	public boolean removeHospitalPractitioner(BigInteger practitioner,BigInteger healthcareprovider){
		Boolean result = false;
		List<HospitalPractitionerModel> hpModelList = this.getHospitalPractitioner(healthcareprovider);
		for(HospitalPractitionerModel hpModel:hpModelList){
			if(hpModel.getId().equals(practitioner)){
				HospitalSpecialtyTreatmentMethodPractitionerModel model = this.getHospitalSpecialtyTreatmentMethodPractitionerById(hpModel.getHstmp());
				if(model.getId() != null){
					model.setActive(false);
					this.setHospitalSpecialtyTreatmentMethodPractitioner(model);
					result = true;
				}
			}
		}
		return result;
	}
}