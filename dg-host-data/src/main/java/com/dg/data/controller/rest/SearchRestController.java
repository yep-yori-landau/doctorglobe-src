
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.ExchangeRate;
import com.dg.data.model.db.Treatment;
import com.dg.data.model.domain.HealthcareproviderDetail;
import com.dg.data.model.domain.PractitionerDetail;
import com.dg.data.model.domain.TreatmentSearchModel;
import com.dg.data.service.ExchangeRateService;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.PractitionerService;
import com.dg.data.service.TreatmentService;

/**
 * @author doctorGlobe
 * 
 * Handles all interactions with the Search.
 *
 */
@Controller
public class SearchRestController {
	private static final Logger logger = LoggerFactory
			.getLogger(SearchRestController.class);

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public PractitionerService practitionerService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public ExchangeRateService exchangeRateService;

	/**
	 * Provides interface to get list of HealthcareproviderDetail by treatment
	 * id ,currency,patient id
	 */
	@RequestMapping(value = "/rest/search/healthcareprovider/id/{id}/currency/{currency}/patient/{patient}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderDetail> getHealthcareproviderByTreatmentId(
			@PathVariable("id") Integer id,
			@PathVariable("currency") String currency,
			@PathVariable("patient") Integer patient) {
		logger.info("hospital search");
		List<HealthcareproviderDetail> healthcareprovidersDetail = healthcareproviderService.findByTreatmentId(id, currency);
		List<HealthcareproviderDetail> healthcareproviderDetail = healthcareproviderService.setHealthcareproviderDetails(healthcareprovidersDetail, id, patient, currency);
		return healthcareproviderDetail;
	}

	/**
	 * Provides interface to get list of PractitionerDetail by hospital
	 * id,currency and patient id
	 */
	@RequestMapping(value = "/rest/search/practitioner/id/{id}/treatment/{treatment}/currency/{currency}/patient/{patient}", method = RequestMethod.GET)
	public @ResponseBody List<PractitionerDetail> getPractitionerByHealthcareproviderId(
			@PathVariable("id") int id,
			@PathVariable("treatment") int treatment,
			@PathVariable("currency") String currency,
			@PathVariable("patient") Integer patient) {
		List<PractitionerDetail> practitionerDetailList = practitionerService
				.findByHealthcareproviderId(id, treatment);
		List<PractitionerDetail> practitionerDetail = practitionerService
				.setHealthcareproviderPractitionerRanking(
						practitionerDetailList, currency, patient, treatment);
		ExchangeRate exchangeRateModel = new ExchangeRate();
		if (currency != null) {
			for (PractitionerDetail model : practitionerDetail) {
				if (model.getCurrency() != null
						&& !model.getCurrency().equalsIgnoreCase(currency)) {
					exchangeRateModel = exchangeRateService
							.getByFromToCurrency(currency, model.getCurrency());
					if (exchangeRateModel.getId() != null
							&& exchangeRateModel.getRate() != 0) {
						model.setEstimatedCost(model.getEstimatedCost()
								/ exchangeRateModel.getRate());
						model.setCurrency(currency);
					}
				}
			}
		}
		return practitionerDetail;
	}

	/**
	 * Provides interface to get Treatment Search Model by treatment name
	 */
	@RequestMapping(value = "/rest/search/practitioner/id/{id}/treatment/{treatment}/currency/{currency}/ccinsurance/{ccinsurance}/patient/{patient}", method = RequestMethod.GET)
	public @ResponseBody List<PractitionerDetail> getCorporatecompanyInsurancePractitioner(
			@PathVariable("id") int id,
			@PathVariable("treatment") int treatment,
			@PathVariable("currency") String currency,
			@PathVariable("ccinsurance") BigInteger ccinsurance,
			@PathVariable("patient") Integer patient) {
		List<PractitionerDetail> practitionerDetailList = practitionerService
				.findCorporatecompanyInsurancePractitioner(id, treatment,
						ccinsurance);
		List<PractitionerDetail> practitionerDetail = practitionerService
				.setHealthcareproviderPractitionerRanking(
						practitionerDetailList, currency, patient, treatment);
		ExchangeRate exchangeRateModel = new ExchangeRate();
		if (currency != null) {
			for (PractitionerDetail model : practitionerDetail) {
				if (model.getCurrency() != null
						&& !model.getCurrency().equalsIgnoreCase(currency)) {
					exchangeRateModel = exchangeRateService
							.getByFromToCurrency(currency, model.getCurrency());
					if (exchangeRateModel.getId() != null
							&& exchangeRateModel.getRate() != 0) {
						model.setEstimatedCost(model.getEstimatedCost()
								/ exchangeRateModel.getRate());
						model.setCurrency(currency);
					}
				}
			}
		}
		return practitionerDetail;
	}

	/**
	 * Provides interface to get Treatment Search Model by treatment name
	 */
	@RequestMapping(value = "/rest/search/treatment/name/{name}", method = RequestMethod.GET)
	public @ResponseBody List<TreatmentSearchModel> getTreatmentByName(
			@PathVariable("name") String name) {
		return treatmentService.findByTreatment(name);
	}
	
}