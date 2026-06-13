/**
 * SearchForm Service
 */
package com.dg.patient.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.patient.model.HealthcareproviderModel;
import com.dg.patient.model.PractitionerModel;
import com.dg.patient.model.TreatmentModel;
import com.dg.patient.model.TreatmentSearchModel;

/**
 * @author DoctorGlobe
 * 
 */
public class SearchService {

	private static final Logger logger = LoggerFactory
			.getLogger(SearchService.class);

	private SearchUrlService searchUrlService;

	public SearchUrlService getSearchUrlService() {
		return this.searchUrlService;
	}

	public void setSearchUrlService(SearchUrlService searchUrlService) {
		this.searchUrlService = searchUrlService;
	}

	/**
	 * Search for facilities
	 * 
	 * @param query
	 * 
	 * @return
	 */
	public List<HealthcareproviderModel> healthcareproviders(Integer treatment,
			BigInteger patient) {

		String url = this.getSearchUrlService().getBaseUrl()
				+ this.getSearchUrlService().getHealthcareproviderUrl() + "id/"
				+ treatment + "/currency/"
				+ this.getSearchUrlService().getCurrency() + "/patient/"
				+ patient;
		logger.info("Url Founed {}", url);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<HealthcareproviderModel[]> responseEntity = restTemplate
					.getForEntity(url, HealthcareproviderModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Search for practitioners
	 * 
	 * @param facility
	 * 
	 * @return
	 */
	public List<PractitionerModel> practitioners(Integer facility,
			Integer treatment, BigInteger patient) {
		String url = this.getSearchUrlService().getBaseUrl()
				+ this.getSearchUrlService().getPractitionerUrl() + "id/"
				+ facility + "/treatment/" + treatment + "/currency/"
				+ this.getSearchUrlService().getCurrency() + "/patient/"
				+ patient;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PractitionerModel[]> responseEntity = restTemplate
					.getForEntity(url, PractitionerModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Search for practitioners
	 * 
	 * @param facility
	 * 
	 * @return
	 */
	public List<PractitionerModel> getCorporatecompanyInsurancePractitioners(
			Integer facility, Integer treatment, BigInteger ccinsurance,
			BigInteger patient) {
		String url = this.getSearchUrlService().getBaseUrl()
				+ this.getSearchUrlService().getPractitionerUrl() + "id/"
				+ facility + "/treatment/" + treatment + "/currency/"
				+ this.getSearchUrlService().getCurrency() + "/ccinsurance/"
				+ ccinsurance + "/patient/" + patient;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<PractitionerModel[]> responseEntity = restTemplate
					.getForEntity(url, PractitionerModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Search for treatments
	 * 
	 * @param name
	 * 
	 * @return
	 */
	public List<TreatmentModel> treatments(String name) {
		String url = this.getSearchUrlService().getBaseUrl()
				+ this.getSearchUrlService().getTreatmentUrl() + "name/" + name;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<TreatmentModel[]> responseEntity = restTemplate
					.getForEntity(url, TreatmentModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Search for treatments
	 * 
	 * @param name
	 * 
	 * @return
	 */
	public List<TreatmentSearchModel> getTreatments(String name) {
		String url = this.getSearchUrlService().getBaseUrl()
				+ this.getSearchUrlService().getTreatmentUrl() + "name/" + name;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<TreatmentSearchModel[]> responseEntity = restTemplate
					.getForEntity(url, TreatmentSearchModel[].class);
			return Arrays.asList(responseEntity.getBody());
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @param treatmentList
	 * @return without general treamtent list
	 */
	public List<TreatmentModel> getWithoutGeneralTreatmentList(
			List<TreatmentSearchModel> treatmentList) {
		List<TreatmentModel> withoutGeneralTreatmentList = new ArrayList<TreatmentModel>();
		for (TreatmentSearchModel model : treatmentList) {
			if (!model.getName().equalsIgnoreCase("standard")) {
				TreatmentModel treatmentModel = new TreatmentModel();
				treatmentModel.setId(model.getId());
				treatmentModel.setName(model.getName());
				withoutGeneralTreatmentList.add(treatmentModel);
				if (model.getAliasName() != null) {
					TreatmentModel treatmentAliasModel = new TreatmentModel();
					treatmentAliasModel.setId(model.getId());
					treatmentAliasModel.setName(model.getAliasName());
					withoutGeneralTreatmentList.add(treatmentAliasModel);
				}
			}
		}
		return withoutGeneralTreatmentList;
	}

	public Integer getResultLimit() {
		return this.getSearchUrlService().getResultLimit();
	}

	public String getRatingUrl() {
		return this.getSearchUrlService().getRatingUrl();
	}

}
