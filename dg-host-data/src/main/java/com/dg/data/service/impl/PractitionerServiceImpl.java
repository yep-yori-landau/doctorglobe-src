
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PractitionerDAO;
import com.dg.data.model.db.City;
import com.dg.data.model.db.ExchangeRate;
import com.dg.data.model.db.Patient;
import com.dg.data.model.db.Practitioner;
import com.dg.data.model.db.TreatmentPrice;
import com.dg.data.model.domain.EmployeeCorporatecompanyDetail;
import com.dg.data.model.domain.HealthcareproviderPractitionerCountryModel;
import com.dg.data.model.domain.HealthcareproviderPractitionerModel;
import com.dg.data.model.domain.PractitionerDetail;
import com.dg.data.service.CityService;
import com.dg.data.service.EmployeeCorporatecompanyService;
import com.dg.data.service.ExchangeRateService;
import com.dg.data.service.PatientService;
import com.dg.data.service.PractitionerRatingWeightageService;
import com.dg.data.service.PractitionerService;
import com.dg.data.service.RankingCalculationService;
import com.dg.data.service.TreatmentPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DoctorGlobe practitionerService CountryService
 */

@Service("practitionerService")
public class PractitionerServiceImpl extends GenericServiceImpl<Practitioner>
		implements PractitionerService {

	private static final Logger logger = LoggerFactory
			.getLogger(PractitionerServiceImpl.class);

	private PractitionerDAO practitionerDAO;

	@Autowired
	public PractitionerServiceImpl(PractitionerDAO genericDAO) {
		super(genericDAO);
		this.practitionerDAO = (PractitionerDAO) genericDAO;
	}

	private PractitionerRatingWeightageService practitionerRatingWeightageService;

	private ExchangeRateService exchangerateService;

	private PatientService patientService;

	private EmployeeCorporatecompanyService employeeCorporatecompanyService;

	private CityService cityService;

	private TreatmentPriceService treatmentPriceService;

	private RankingCalculationService rankingCalculationService;

	/**
	 * @return the practitionerRatingWeightageService
	 */
	public PractitionerRatingWeightageService getPractitionerRatingWeightageService() {
		return this.practitionerRatingWeightageService;
	}

	/**
	 * 
	 * @param practitionerRatingWeightageService
	 */
	public void setPractitionerRatingWeightageService(
			PractitionerRatingWeightageService practitionerRatingWeightageService) {
		this.practitionerRatingWeightageService = practitionerRatingWeightageService;
	}

	/**
	 * @return the exchangerateService
	 */
	public ExchangeRateService getExchangerateService() {
		return this.exchangerateService;
	}

	/**
	 * 
	 * @param exchangerateService
	 */
	public void setExchangerateService(
			ExchangeRateService exchangerateService) {
		this.exchangerateService = exchangerateService;
	}

	/**
	 * 
	 * @return patientService
	 */
	public PatientService getPatientService() {
		return this.patientService;
	}

	/**
	 * 
	 * @param patientService
	 */
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	/**
	 * 
	 * @return employeeCorporatecompanyService
	 */
	public EmployeeCorporatecompanyService getEmployeeCorporatecompanyService() {
		return this.employeeCorporatecompanyService;
	}

	/**
	 * 
	 * @param employeeCorporatecompanyService
	 */
	public void setEmployeeCorporatecompanyService(
			EmployeeCorporatecompanyService employeeCorporatecompanyService) {
		this.employeeCorporatecompanyService = employeeCorporatecompanyService;
	}

	/**
	 * 
	 * @return cityService
	 */
	public CityService getCityService() {
		return this.cityService;
	}

	/**
	 * 
	 * @param patientService
	 */
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	/**
	 * 
	 * @return treatmentPriceService
	 */
	public TreatmentPriceService getTreatmentPriceService() {
		return this.treatmentPriceService;
	}

	/**
	 * 
	 * @param treatmentPriceService
	 */
	public void setTreatmentPriceService(
			TreatmentPriceService treatmentPriceService) {
		this.treatmentPriceService = treatmentPriceService;
	}

	/**
	 * 
	 * @param rankingCalculationService
	 */
	public void setRankingCalculationService(
			RankingCalculationService rankingCalculationService) {
		this.rankingCalculationService = rankingCalculationService;
	}

	/**
	 * 
	 * @return rankingCalculationService
	 */
	public RankingCalculationService getRankingCalculationService() {
		return this.rankingCalculationService;
	}

	@Override
	public List<PractitionerDetail> findByHealthcareproviderId(Integer id,
			Integer treatment) {
		return this.practitionerDAO.findByHealthcareproviderId(id, treatment);
	}

	@Override
	public List<PractitionerDetail> findCorporatecompanyInsurancePractitioner(
			Integer id, Integer treatment, BigInteger ccinsurance) {
		return this.practitionerDAO.findCorporatecompanyInsurancePractitioner(
				id, treatment, ccinsurance);
	}

	@Override
	public List<PractitionerDetail> setHealthcareproviderPractitionerRanking(
			List<PractitionerDetail> practitionerDetailList, String currency,
			Integer patient, Integer treatment) {
		HashMap<Integer, Double> ratingMap = new HashMap<Integer, Double>();
		HashMap<Integer, Integer> practitionerRatingMap = new HashMap<Integer, Integer>();
		TreatmentPrice patientCityTreatmentPriceModel = new TreatmentPrice();
		Patient patientModel = new Patient();
		City cityModel = new City();
		EmployeeCorporatecompanyDetail employeeCorporateCompanyModel = new EmployeeCorporatecompanyDetail();
		List<PractitionerDetail> uniquePractitionerDetailList = new ArrayList<PractitionerDetail>();
		Boolean patientLatLonFound = false;
		Double patientLat = 0.0, patientLon = 0.0;
		HashMap<Integer, Double> ratingValueMap = new HashMap<Integer, Double>();
		Set<Integer> result = new HashSet<Integer>();
		HashMap<Integer, Double> costMap = new HashMap<Integer, Double>();
		HashMap<Integer, Integer> numberPerformedLastYearMap = new HashMap<Integer, Integer>();
		try {
			patientModel = patientService.get(patient);
			if (patientModel.getId() != null
					&& patientModel.getCity() != null) {
				cityModel = cityService.get(patientModel.getCity().intValue());
				if (cityModel.getLat() != null && cityModel.getLon() != null) {
					patientLat = cityModel.getLat();
					patientLon = cityModel.getLon();
					patientLatLonFound = true;

				}
				patientCityTreatmentPriceModel = this.getTreatmentPriceService()
						.findByTreatmentCity(BigInteger.valueOf(treatment),
								patientModel.getCity());
			}
			if (!patientLatLonFound) {
				employeeCorporateCompanyModel = employeeCorporatecompanyService
						.findByPaytient(patient);
				if (employeeCorporateCompanyModel.getId() != null
						&& employeeCorporateCompanyModel.getCity() != null) {
					cityModel = cityService.get(
							employeeCorporateCompanyModel.getCity().intValue());
					if (cityModel.getLat() != null
							&& cityModel.getLon() != null) {
						patientLat = cityModel.getLat();
						patientLon = cityModel.getLon();
						patientLatLonFound = true;
					}
					patientCityTreatmentPriceModel = this
							.getTreatmentPriceService()
							.findByTreatmentCity(BigInteger.valueOf(treatment),
									cityModel.getId());
				}
			}
			for (PractitionerDetail model : practitionerDetailList) {
				if (model.getCurrency() != null
						&& !model.getCurrency().equalsIgnoreCase(currency)) {
					ExchangeRate exchangeRateModel = this
							.getExchangerateService()
							.getByFromToCurrency(currency, model.getCurrency());
					if (exchangeRateModel.getId() != null
							&& exchangeRateModel.getRate() != 0) {
						costMap.put(model.getId(), model.getEstimatedCost()
								/ exchangeRateModel.getRate());
						model.setEstimatedCost(model.getEstimatedCost()
								/ exchangeRateModel.getRate());
						model.setCurrency(currency);
					}
				}
				if (result.add(model.getId())) {
					uniquePractitionerDetailList.add(model);
				}
			}
			Double total = 0.0;
			Double distance = 0.0;
			for (PractitionerDetail model : uniquePractitionerDetailList) {
				total += distance;
				if (patientCityTreatmentPriceModel.getPrice() != null) {
					total += this.getRankingCalculationService().getBonusVal(
							model.getEstimatedCost(),
							patientCityTreatmentPriceModel.getPrice());
				}
				else {
					total += 0.0;
				}
				total += this.getRankingCalculationService()
						.getQualityVal(model.getNumberPerformedLastYear());
				ratingValueMap.put(model.getId(), total);
			}

			ratingMap = this.getRankingCalculationService()
					.getSortByValues(ratingValueMap);
			Integer topRank = ratingMap.size();
			for (Integer key : ratingMap.keySet()) {
				practitionerRatingMap.put(key, topRank--);
			}
			for (PractitionerDetail model : practitionerDetailList) {
				if (practitionerRatingMap.containsKey(model.getId())) {
					model.setRanking(practitionerRatingMap.get(model.getId()));
				}
			}
			Collections.sort(practitionerDetailList, this.practitionerRank);
		}
		catch (Exception ex) {
			logger.info("exception found ", ex.getMessage());
		}
		return practitionerDetailList;
	}

	@Override
	public Practitioner findByEmail(String email, Integer active) {
		return this.practitionerDAO.findByEmail(email, active);
	}

	@Override
	public Integer resetPassword(Integer id, String old_password,
			String new_password) {
		return this.practitionerDAO.resetPassword(id, old_password,
				new_password);
	}

	@Override
	public List<HealthcareproviderPractitionerModel> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.practitionerDAO
				.findByHealthcareprovider(healthcareprovider);
	}

	@Override
	public List<HealthcareproviderPractitionerCountryModel> findCountryByHstmp(
			BigInteger hstmp) {
		return this.practitionerDAO.findByHstmp(hstmp);
	}

	/* Comparator for sorting the list by ranking */
	public static Comparator<PractitionerDetail> practitionerRank = new Comparator<PractitionerDetail>() {
		public int compare(PractitionerDetail p1, PractitionerDetail p2) {
			Integer rank1 = p1.getRanking();
			Integer rank2 = p2.getRanking();
			return rank1 - rank2;
		}
	};

	/**
	 * 
	 * @param passwordString
	 * @return sha1
	 * @throws Exception
	 */
	public String getSHA1(String passwordString) throws Exception {
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		sha1.reset();
		sha1.update(passwordString.getBytes());
		byte[] digest = sha1.digest();
		StringBuffer password = new StringBuffer();
		for (byte b : digest) {
			password.append(String.format("%02x", b));
		}
		return password.toString();
	}

	@Override
	public Practitioner findByName(String name) {
		return this.practitionerDAO.findByName(name);
	}
}
