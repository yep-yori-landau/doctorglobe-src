package com.dg.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.hospital.form.FacilityForm;
import com.dg.hospital.form.HospitalForm;
import com.dg.hospital.form.HospitalityForm;
import com.dg.hospital.form.InsuranceForm;
import com.dg.hospital.form.RatingForm;
import com.dg.hospital.form.TechnologyForm;
import com.dg.hospital.form.UploadFileForm;
import com.dg.hospital.model.AccreditationModel;
import com.dg.hospital.model.AmenityModel;
import com.dg.hospital.model.CuisineModel;
import com.dg.hospital.model.EquipmentModel;
import com.dg.hospital.model.FeatureModel;
import com.dg.hospital.model.HospitalAccreditationModel;
import com.dg.hospital.model.HospitalAmenityModel;
import com.dg.hospital.model.HospitalCuisineModel;
import com.dg.hospital.model.HospitalEquipmentModel;
import com.dg.hospital.model.HospitalHospitaltypeModel;
import com.dg.hospital.model.HospitalInsuranceModel;
import com.dg.hospital.model.HospitalLanguageModel;
import com.dg.hospital.model.HospitalPhotoModel;
import com.dg.hospital.model.HospitalRatingsModel;
import com.dg.hospital.model.HospitalUnitFeatureModel;
import com.dg.hospital.model.HospitaltypeModel;
import com.dg.hospital.model.HospitalunitModel;
import com.dg.hospital.model.InsuranceModel;
import com.dg.hospital.model.RatingcompaniesModel;
import com.dg.hospital.model.form.HospitalAccreditationFormModel;
import com.dg.hospital.model.form.HospitalAmenityFormModel;
import com.dg.hospital.model.form.HospitalCuisineFormModel;
import com.dg.hospital.model.form.HospitalInsuranceFormModel;
import com.dg.hospital.model.form.HospitalLanguageFormModel;
import com.dg.hospital.model.form.HospitalUnitFeatureFormModel;
import com.dg.hospital.model.form.HospitaltypeFormModel;

public class HospitalService extends RestService{
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalService.class);
	  
	private RestUrlService restUrlService;
	
	public RestUrlService getRestUrlService()
	{
	   return this.restUrlService;
	}
	  
	public void setRestUrlService(RestUrlService restUrlService)
	{
	   this.restUrlService = restUrlService;
	}
	
	public boolean editHospital(HospitalForm model) {
		Integer edited = this.setHospital(model);
		if(edited > 0){
			return true;
		}
		return false;
	}	
	
	public List<HospitalEquipmentModel> getHospitalEquipments(BigInteger healthcareprovider){
		List<HospitalEquipmentModel> hospitalEquipmentList= super.getHospitalEquipments(healthcareprovider);
		List<EquipmentModel> equipmentModelList = this.getAllEquipments();
		List<HospitalEquipmentModel> technologyList = new ArrayList<HospitalEquipmentModel>();		
		for(EquipmentModel equipmentModel : equipmentModelList){
			HospitalEquipmentModel model = new HospitalEquipmentModel();
			model.setEquipment(equipmentModel.getId());
			model.setHealthcareprovider(healthcareprovider);			
			technologyList.add(model);			
		}
		if(!hospitalEquipmentList.isEmpty()){			
			for(HospitalEquipmentModel technologyModel : technologyList){
				for(HospitalEquipmentModel hospitalEquipmentModel : hospitalEquipmentList){
					if(technologyModel.getEquipment().equals(hospitalEquipmentModel.getEquipment())){
						technologyModel.setId(hospitalEquipmentModel.getId());
						technologyModel.setHoursUsed(hospitalEquipmentModel.getHoursUsed());
						technologyModel.setPurchaseDt(hospitalEquipmentModel.getPurchaseDt());
					}
				}
			}
		}
		return technologyList;
	}
	/**
	 * 
	 * @param healthcareprovider
	 * @return HospitalAccreditationFormModel
	 */
	public List<HospitalAccreditationFormModel> getHospitalAccreditationFormModel(BigInteger healthcareprovider){
		List<HospitalAccreditationModel> hospitalAccreditationModelList = super.getHospitalAccreditation(healthcareprovider);
		List<HospitalAccreditationFormModel> hospitalAccreditationFormList = new ArrayList<HospitalAccreditationFormModel>();
		List<AccreditationModel> accreditationModelList = super.getAllAccreditation();
		for(AccreditationModel accreditationModel : accreditationModelList){
			HospitalAccreditationFormModel model = new HospitalAccreditationFormModel();
			model.setHealthcareprovider(healthcareprovider);
			model.setAccreditation(accreditationModel.getId());
			model.setName(accreditationModel.getName());
			model.setIsChecked(false);
			hospitalAccreditationFormList.add(model);
		}
		if(!hospitalAccreditationFormList.isEmpty()){
			for(HospitalAccreditationFormModel hospitalAccreditationFormModel : hospitalAccreditationFormList){
				for(HospitalAccreditationModel hospitalAccreditationModel : hospitalAccreditationModelList){
					if(hospitalAccreditationFormModel.getAccreditation().equals(hospitalAccreditationModel.getAccreditation())){
						hospitalAccreditationFormModel.setId(hospitalAccreditationModel.getId());
						hospitalAccreditationFormModel.setAccreditationDt(hospitalAccreditationModel.getAccreditationDt());
						hospitalAccreditationFormModel.setIsChecked(true);						
					}
				}
			}
		}
		return hospitalAccreditationFormList;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return HospitaltypeFormModel
	 */
	public List<HospitaltypeFormModel> getHospitaltypeFormModel(BigInteger healthcareprovider){
		List<HospitalHospitaltypeModel> hospitalHospitaltypeModelList = super.getHospitalHospitaltype(healthcareprovider);
		List<HospitaltypeFormModel> hospitaltypeFormList = new ArrayList<HospitaltypeFormModel>();
		List<HospitaltypeModel> hospitaltypeModelList = super.getAllHospitaltype();
		for(HospitaltypeModel hospitaltypeModel : hospitaltypeModelList){
			HospitaltypeFormModel model = new HospitaltypeFormModel();
			model.setHealthcareprovider(healthcareprovider);
			model.setHealthcareprovidertype(hospitaltypeModel.getId());
			model.setName(hospitaltypeModel.getName());
			model.setIsChecked(false);
			hospitaltypeFormList.add(model);
		}
		if(hospitaltypeFormList != null){
			for(HospitaltypeFormModel hospitaltypeFormModel : hospitaltypeFormList){
				for(HospitalHospitaltypeModel hospitalHospitaltypeModel : hospitalHospitaltypeModelList){
					if(hospitaltypeFormModel.getHealthcareprovidertype().equals(hospitalHospitaltypeModel.getHealthcareprovidertype())){
						hospitaltypeFormModel.setId(hospitalHospitaltypeModel.getId());						
						hospitaltypeFormModel.setIsChecked(true);						
					}
				}
			}
		}
		return hospitaltypeFormList;
	}
	
	public List<HospitalUnitFeatureFormModel> getHospitalUnitFeatureFormModel(BigInteger healthcareprovider){
		List<HospitalUnitFeatureModel> hospitalUnitFeatureModelList = super.getHospitalUnitFeature(healthcareprovider);
		List<HospitalUnitFeatureFormModel> hospitalUnitFeatureFormList = new ArrayList<HospitalUnitFeatureFormModel>();
		List<FeatureModel> featureModelList = super.getAllFeature();
		List<HospitalunitModel> hospitalunitModelList = super.getAllHospitalunit();
		for(HospitalunitModel hospitalunit : hospitalunitModelList){
			for(FeatureModel feature : featureModelList){
				HospitalUnitFeatureFormModel model = new HospitalUnitFeatureFormModel();
				model.setHealthcareproviderunit(hospitalunit.getId());
				model.setHealthcareprovider(healthcareprovider);
				model.setFeature(feature.getId());
				model.setFeatureName(feature.getName());
				model.setUnitName(hospitalunit.getName());
				hospitalUnitFeatureFormList.add(model);
			}
		}
		
		if(!hospitalUnitFeatureFormList.isEmpty()){
			for(HospitalUnitFeatureFormModel hospitalUnitFeatureFormModel : hospitalUnitFeatureFormList){
				for(HospitalUnitFeatureModel hospitalUnitFeatureModel : hospitalUnitFeatureModelList){
					if(hospitalUnitFeatureFormModel.getFeature().equals(hospitalUnitFeatureModel.getFeature()) && hospitalUnitFeatureFormModel.getHealthcareproviderunit().equals(hospitalUnitFeatureModel.getHealthcareproviderunit())){
						hospitalUnitFeatureFormModel.setId(hospitalUnitFeatureModel.getId());
						hospitalUnitFeatureFormModel.setDescription(hospitalUnitFeatureModel.getDescription());
					}
				}
			}
		}
		return hospitalUnitFeatureFormList;
	}
	
	public List<HospitalAmenityFormModel> getHospitalAmenityFormModel(BigInteger healthcareprovider){
		List<HospitalAmenityModel> hospitalAmenityModelList = super.getHospitalAmenity(healthcareprovider);
		List<HospitalAmenityFormModel> hospitalAmenityFormList = new ArrayList<HospitalAmenityFormModel>();
		List<AmenityModel> amenityModelList = super.getAllAmenity();
		for(AmenityModel amenityModel : amenityModelList){
			HospitalAmenityFormModel model = new HospitalAmenityFormModel();
			model.setHealthcareprovider(healthcareprovider);
			model.setAmenity(amenityModel.getId());
			model.setAmenityName(amenityModel.getName());
			model.setIsChecked(false);
			hospitalAmenityFormList.add(model);
		}
		if(!hospitalAmenityFormList.isEmpty()){
			for(HospitalAmenityFormModel hospitalAmenityFormModel : hospitalAmenityFormList){
				for(HospitalAmenityModel hospitalAmenityModel : hospitalAmenityModelList){
					if(hospitalAmenityFormModel.getAmenity().equals(hospitalAmenityModel.getAmenity())){
						hospitalAmenityFormModel.setId(hospitalAmenityModel.getId());
						hospitalAmenityFormModel.setIsChecked(true);
						hospitalAmenityFormModel.setCurrency(hospitalAmenityModel.getCurrency());
						hospitalAmenityFormModel.setPrice(hospitalAmenityModel.getPrice());
					}
				}
			}
		}
		return hospitalAmenityFormList;
	}
	
	/**
	 * 
	 * @param healthcareprovider
	 * @return
	 */
	public List<HospitalLanguageFormModel> getHospitalLanguageFormModel(BigInteger healthcareprovider) {
		List<HospitalLanguageModel> hospitalLanguageModelList = super.getHospitalLanguage(healthcareprovider);
		List<HospitalLanguageFormModel> hospitalLanguageFormModelList = new ArrayList<HospitalLanguageFormModel>();
		Locale []availableLocale = Locale.getAvailableLocales();
		HashMap<String,String> language = new HashMap<String,String>();
		for(Locale locale : availableLocale){
			if(!locale.getLanguage().isEmpty()){
				language.put(locale.getLanguage(), locale.getDisplayLanguage());
			}
		}
		for(Map.Entry m:language.entrySet()){
			HospitalLanguageFormModel model = new HospitalLanguageFormModel();			
			model.setHealthcareprovider(healthcareprovider);
			model.setLanguage(m.getKey().toString());
			model.setLanguageName(m.getValue().toString());
			model.setIsChecked(false);
			hospitalLanguageFormModelList.add(model);
		}
		if(!hospitalLanguageModelList.isEmpty()){
			for(HospitalLanguageFormModel hospitalLanguageFormModel: hospitalLanguageFormModelList){
				for(HospitalLanguageModel hospitalLanguageModel : hospitalLanguageModelList){
					if(hospitalLanguageFormModel.getLanguage().equalsIgnoreCase(hospitalLanguageModel.getLanguage())){
						hospitalLanguageFormModel.setId(hospitalLanguageModel.getId());
						hospitalLanguageFormModel.setIsChecked(true);
					}
				}
			}
		}
		return hospitalLanguageFormModelList;
	}	
	
	public List<HospitalCuisineFormModel> getHospitalCuisineFormModel(BigInteger healthcareprovider){
		List<HospitalCuisineModel> hospitalCuisineModelList = super.getHospitalCuisine(healthcareprovider);
		List<HospitalCuisineFormModel> hospitalCuisineFormList = new ArrayList<HospitalCuisineFormModel>();
		List<CuisineModel> cuisineModelList = super.getAllCuisine();
		for(CuisineModel cuisineModel : cuisineModelList){
			HospitalCuisineFormModel model = new HospitalCuisineFormModel();
			model.setHealthcareprovider(healthcareprovider);
			model.setCuisine(cuisineModel.getId());
			model.setCuisineName(cuisineModel.getName());
			model.setIsChecked(false);
			hospitalCuisineFormList.add(model);
		}
		if(!hospitalCuisineFormList.isEmpty()){
			for(HospitalCuisineFormModel hospitalCuisineFormModel : hospitalCuisineFormList){
				for(HospitalCuisineModel hospitalCuisineModel : hospitalCuisineModelList){
					if(hospitalCuisineFormModel.getCuisine().equals(hospitalCuisineModel.getCuisine())){
						hospitalCuisineFormModel.setId(hospitalCuisineModel.getId());
						hospitalCuisineFormModel.setIsChecked(true);
					}
				}
			}
		}
		return hospitalCuisineFormList;
	}
	
	public List<HospitalInsuranceFormModel> getHospitalInsuranceFormModel(BigInteger healthcareprovider){
		List<HospitalInsuranceModel> hospitalInsuranceModelList = super.getHospitalInsurance(healthcareprovider);
		List<HospitalInsuranceFormModel> hospitalInsuranceFormList = new ArrayList<HospitalInsuranceFormModel>();
		List<InsuranceModel> insuranceModelList = this.getAllInsurance();
		for(InsuranceModel insuranceModel : insuranceModelList){
			HospitalInsuranceFormModel model = new HospitalInsuranceFormModel();
			model.setHealthcareprovider(healthcareprovider);
			model.setInsurance(insuranceModel.getId());
			model.setInsuranceName(insuranceModel.getName());
			model.setIsChecked(false);
			hospitalInsuranceFormList.add(model);
		}
		if(hospitalInsuranceFormList != null){
			for(HospitalInsuranceFormModel hospitalInsuranceFormModel : hospitalInsuranceFormList){
				for(HospitalInsuranceModel hospitalInsuranceModel : hospitalInsuranceModelList){
					if(hospitalInsuranceFormModel.getInsurance().equals(hospitalInsuranceModel.getInsurance())){
						hospitalInsuranceFormModel.setId(hospitalInsuranceModel.getId());
						hospitalInsuranceFormModel.setIsChecked(true);
					}
				}
			}
		}
		return hospitalInsuranceFormList;
	}
	
	public List<HospitalRatingsModel> getHospitalFormRatings(BigInteger healthcareprovider){
		List<HospitalRatingsModel> hospitalRatingsList= this.getHospitalRatings(healthcareprovider);
		List<RatingcompaniesModel> ratingcompaniesModelList = this.getAllRatingcompanies();
		List<HospitalRatingsModel> hospitalRatingsFormList = new ArrayList<HospitalRatingsModel>();		
		for(RatingcompaniesModel ratingcompaniesModel : ratingcompaniesModelList){
			HospitalRatingsModel model = new HospitalRatingsModel();
			model.setRatingcompany(ratingcompaniesModel.getId());
			model.setHealthcareprovider(healthcareprovider);			
			hospitalRatingsFormList.add(model);			
		}
		if(hospitalRatingsList != null){			
			for(HospitalRatingsModel hospitalRatingsFormModel : hospitalRatingsFormList){
				for(HospitalRatingsModel hospitalRatingsModel : hospitalRatingsList){
					if(hospitalRatingsFormModel.getRatingcompany().equals(hospitalRatingsModel.getRatingcompany())){
						hospitalRatingsFormModel.setId(hospitalRatingsModel.getId());
						hospitalRatingsFormModel.setScore(hospitalRatingsModel.getScore());
					}
				}
			}
		}
		return hospitalRatingsFormList;
	}
	
	public Boolean editTechnology(TechnologyForm technologyForm){
		Boolean result = false;
		Integer edited = null;
		for(HospitalEquipmentModel model: technologyForm.getHospitalEquipmentModel()){			
			edited = this.setHospitalEquipment(model);
			if(edited > 0){
				result = true;
			}
		}
		return result;
	}
	
	public Boolean editHospitality(HospitalityForm hospitalityForm){
		Boolean result = false;
		Boolean result1,result2,result3;
		result1 = this.editHospitalAmenity(hospitalityForm);
		result2 = this.editHospitalLanguage(hospitalityForm);
		result3 = this.editHospitalCuisine(hospitalityForm);
		if(result1 || result2 || result3){
			result = true;
		}
		return result;
	}
	
	public Boolean editHospitalAmenity(HospitalityForm hospitalityForm){
		Boolean result = false;
		Integer edited = null;
		for(HospitalAmenityFormModel hospitalAmenityFormModel : hospitalityForm.getHospitalAmenityFormModel()){
			if(hospitalAmenityFormModel.getIsChecked().equals(true)){				
				HospitalAmenityModel model = new HospitalAmenityModel();
				model.setId(hospitalAmenityFormModel.getId());
				model.setHealthcareprovider(hospitalAmenityFormModel.getHealthcareprovider());
				model.setAmenity(hospitalAmenityFormModel.getAmenity());
				model.setPrice(hospitalAmenityFormModel.getPrice());
				model.setCurrency(hospitalAmenityFormModel.getCurrency());
				edited = super.setHospitalAmenity(model);
				if(edited > 0){
					result = true;
				}
			}else{
				if(hospitalAmenityFormModel.getId() != null){
					logger.info("delete hospital amenity id ={}",hospitalAmenityFormModel.getId());
					edited = super.deleteHospitalAmenity(hospitalAmenityFormModel.getId());
					if(edited > 0){
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	public Boolean editHospitalLanguage(HospitalityForm hospitalityForm){
		Boolean result = false;
		Integer edited = null;
		for(HospitalLanguageFormModel hospitalLanguageFormModel : hospitalityForm.getHospitalLanguageFormModel()){
			if(hospitalLanguageFormModel.getIsChecked().equals(true)){				
				HospitalLanguageModel model = new HospitalLanguageModel();
				model.setId(hospitalLanguageFormModel.getId());
				model.setHealthcareprovider(hospitalLanguageFormModel.getHealthcareprovider());
				model.setLanguage(hospitalLanguageFormModel.getLanguage());
				edited = super.setHospitalLanguage(model);
				if(edited > 0){
					result = true;
				}
			}else{
				if(hospitalLanguageFormModel.getId() != null){
					logger.info("delete hospital language id ={}",hospitalLanguageFormModel.getId());
					edited = super.deleteHospitalLanguage(hospitalLanguageFormModel.getId().intValue());
					if(edited > 0){
						result = true;
					}
				}
			}
		}
		return result;
	}	

	public Boolean editHospitalCuisine(HospitalityForm hospitalityForm){
		Boolean result = false;
		Integer edited = null;
		for(HospitalCuisineFormModel hospitalCuisineFormModel : hospitalityForm.getHospitalCuisineFormModel()){
			if(hospitalCuisineFormModel.getIsChecked().equals(true)){				
				HospitalCuisineModel model = new HospitalCuisineModel();
				model.setId(hospitalCuisineFormModel.getId());
				model.setHealthcareprovider(hospitalCuisineFormModel.getHealthcareprovider());
				model.setCuisine(hospitalCuisineFormModel.getCuisine());
				edited = super.setHospitalCuisine(model);
				if(edited > 0){
					result = true;
				}
			}else{
				if(hospitalCuisineFormModel.getId() != null){
					logger.info("delete hospital cuisine id ={}",hospitalCuisineFormModel.getId());
					edited = this.deleteHospitalCuisine(hospitalCuisineFormModel.getId());
					if(edited > 0){
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	public Boolean editHospitalInsurance(InsuranceForm insuranceForm){
		Boolean result = false;
		Integer edited = null;	
		for(HospitalInsuranceFormModel hospitalInsuranceFormModel : insuranceForm.getHospitalInsuranceFormModel()){
			if(hospitalInsuranceFormModel.getIsChecked().equals(true)){				
				HospitalInsuranceModel model = new HospitalInsuranceModel();
				model.setId(hospitalInsuranceFormModel.getId());
				model.setHealthcareprovider(hospitalInsuranceFormModel.getHealthcareprovider());
				model.setInsurance(hospitalInsuranceFormModel.getInsurance());
				edited = this.setHospitalInsurance(model);
				if(edited > 0){
					result = true;
				}
			}else{
				if(hospitalInsuranceFormModel.getId() != null){
					logger.info("delete hospital insurance id ={}",hospitalInsuranceFormModel.getId());
					edited = this.deleteHospitalInsurance(hospitalInsuranceFormModel.getId());
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
	 * @param ratingForm
	 * @return boolean
	 */
	public boolean editHospitalRatings(RatingForm ratingForm) {
		Boolean result = false;
	    Integer edited = null;
		for(HospitalRatingsModel model : ratingForm.getHospitalRatingsModel()){
			edited = this.setHospitalRatings(model);
			if(edited > 0){
				result = true;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param facilityForm
	 * @return boolean
	 */
	public boolean editFacility(FacilityForm facilityForm) {
		Boolean result = false;
		Boolean result1,result2,result3;
		result1 = this.editHospitalAccreditation(facilityForm);
		result2 = this.editHospitaltype(facilityForm);
		result3 = this.editHospitalUnitFeature(facilityForm);
		if(result1 || result2 || result3){
			result = true;
		}
		return result;
	}	
	
	public Boolean editHospitalAccreditation(FacilityForm facilityForm){
		Boolean result = false;
		Integer edited = null;
		for(HospitalAccreditationFormModel hospitalAccreditationFormModel : facilityForm.getHospitalAccreditationFormModel()){
			if(hospitalAccreditationFormModel.getIsChecked().equals(true) && !hospitalAccreditationFormModel.getAccreditationDt().isEmpty()){				
				HospitalAccreditationModel model = new HospitalAccreditationModel();
				model.setId(hospitalAccreditationFormModel.getId());
				model.setHealthcareprovider(hospitalAccreditationFormModel.getHealthcareprovider());
				model.setAccreditation(hospitalAccreditationFormModel.getAccreditation());
				model.setAccreditationDt(hospitalAccreditationFormModel.getAccreditationDt());
				edited = super.setHospitalAccreditation(model);
				if(edited > 0){
					result = true;
				}
			}else{
				if(hospitalAccreditationFormModel.getId() != null){
					logger.info("delete hospital accreditation id ={}",hospitalAccreditationFormModel.getId());
					edited = super.deleteHospitalAccreditation(hospitalAccreditationFormModel.getId());
					if(edited > 0){
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	public Boolean editHospitaltype(FacilityForm facilityForm){
		Boolean result = false;
		Integer edited = null;
		if(facilityForm.getHospitaltypeFormModel() == null){
			return false;
		}
		for(HospitaltypeFormModel hospitaltypeFormModel : facilityForm.getHospitaltypeFormModel()){
			if(hospitaltypeFormModel.getIsChecked().equals(true)){				
				HospitalHospitaltypeModel model = new HospitalHospitaltypeModel();
				model.setId(hospitaltypeFormModel.getId());
				model.setHealthcareprovider(hospitaltypeFormModel.getHealthcareprovider());
				model.setHealthcareprovidertype(hospitaltypeFormModel.getHealthcareprovidertype());			
				edited = super.setHospitalHospitaltype(model);
				if(edited > 0){
					result = true;
				}
			}else{
				if(hospitaltypeFormModel.getId() != null){
					logger.info("delete hospital type id ={}",hospitaltypeFormModel.getId());
					edited = super.deleteHospitalHospitaltype(hospitaltypeFormModel.getId());
					if(edited > 0){
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	public Boolean editHospitalUnitFeature(FacilityForm facilityForm){
		Boolean result = false;
		Integer edited = null;
		if(facilityForm.getHospitalUnitFeatureFormModel() == null){
			return false;
		}
		for(HospitalUnitFeatureFormModel hospitalUnitFeatureFormModel : facilityForm.getHospitalUnitFeatureFormModel()){
			if(!hospitalUnitFeatureFormModel.getDescription().isEmpty()){				
				HospitalUnitFeatureModel model = new HospitalUnitFeatureModel();
				model.setId(hospitalUnitFeatureFormModel.getId());
				model.setHealthcareprovider(hospitalUnitFeatureFormModel.getHealthcareprovider());
				model.setFeature(hospitalUnitFeatureFormModel.getFeature());
				model.setHealthcareproviderunit(hospitalUnitFeatureFormModel.getHealthcareproviderunit());
				model.setDescription(hospitalUnitFeatureFormModel.getDescription());
				edited = super.setHospitalUnitFeature(model);
				if(edited > 0){
					result = true;
				}
			}else{
				if(hospitalUnitFeatureFormModel.getId() != null){
					logger.info("delete hospital unit feature id ={}",hospitalUnitFeatureFormModel.getId());
					edited = super.deleteHospitalUnitFeature(hospitalUnitFeatureFormModel.getId());
					if(edited > 0){
						result = true;
					}
				}
			}
		}
		return result;
	}

	public Boolean editHospitalPhoto(UploadFileForm uploadFileForm) {
		Boolean result = false;
		Integer edited = null;
		HospitalPhotoModel model = new HospitalPhotoModel();
		model.setId(uploadFileForm.getId());
		model.setHealthcareprovider(uploadFileForm.getHealthcareprovider());
		model.setDescription(uploadFileForm.getDescription());
		model.setPath(uploadFileForm.getPath());
		model.setType(uploadFileForm.getType());
		model.setIsPrimary(uploadFileForm.getIsPrimary());
		edited = this.setHospitalPhoto(model);
		if(edited > 0){
			result = true;
		}
		return result;	
	}
	
	public UploadFileForm getUploadFileForm(BigInteger id){
		UploadFileForm uploadFileForm = new UploadFileForm();
		HospitalPhotoModel model = super.getHospitalPhotoById(id);
		uploadFileForm.setId(model.getId());
		uploadFileForm.setDescription(model.getDescription());
		uploadFileForm.setHealthcareprovider(model.getHealthcareprovider());
		uploadFileForm.setIsPrimary(model.getIsPrimary());
		uploadFileForm.setPath(model.getPath());
		uploadFileForm.setType(model.getType());
		return uploadFileForm;
	}
}
	