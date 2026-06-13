
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.dg.data.dao.PatientDAO;
import com.dg.data.model.db.Patient;
import com.dg.data.model.domain.CityStateCountryModel;
import com.dg.data.model.domain.PatientCountryModel;
import com.dg.data.model.domain.PatientDetailModel;
import com.dg.data.model.domain.PatientLatLonModel;
import com.dg.data.service.CityService;
import com.dg.data.service.PatientService;

/**
 * @author DoctorGlobe PatientService CountryService
 */

@Service("patientService")
public class PatientServiceImpl extends GenericServiceImpl<Patient>
		implements PatientService {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientService.class);

	private PatientDAO patientDAO;

	@Autowired
	public PatientServiceImpl(PatientDAO genericDAO) {
		super(genericDAO);
		this.patientDAO = (PatientDAO) genericDAO;
	}

	private CityService cityService;

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
	 * Insert a generic model in the database
	 * @param generic model
	 * @return int id
	 */
	@Override
	public Integer insert(Patient patient) {
		try {
			patient.setLat(0.0);
			patient.setLon(0.0);
			String address = "";
			if (patient.getAddress() != null) {
				address += patient.getAddress() + ",";
			}
			if (patient.getCity() != null) {
				CityStateCountryModel cityStateCountryModel = cityService
						.findStateCountryById(patient.getCity());
				if (cityStateCountryModel.getCity() != null) {
					address += cityStateCountryModel.getCity() + ",";
				}
				if (cityStateCountryModel.getState() != null) {
					address += cityStateCountryModel.getState() + ",";
				}
				if (patient.getZipCode() != null) {
					address += patient.getZipCode() + ",";
				}
				if (cityStateCountryModel.getCountry() != null) {
					address += cityStateCountryModel.getCountry() + ",";
				}
			}
			logger.info("Address {}", address);
			if (address != null) {
				String[] latLongs = this.getLatLngByAddress(address);
				if (latLongs[0] != null && latLongs[1] != null) {
					patient.setLat(Double.parseDouble(latLongs[0]));
					patient.setLon(Double.parseDouble(latLongs[1]));
				}
				logger.info("Latitude: " + latLongs[0] + " and Longitude: "
						+ latLongs[1]);
			}
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		return this.patientDAO.insert(patient);
	}

	/**
	 * Insert a generic model in the database
	 * @param generic model
	 * @param user id
	 * @param user_type
	 * @return boolean
	 */
	@Override
	public Integer insert(Patient patient, BigInteger user, String user_type) {
		try {
			patient.setLat(0.0);
			patient.setLon(0.0);
			String address = "";
			if (patient.getAddress() != null) {
				address += patient.getAddress() + ",";
			}
			if (patient.getCity() != null) {
				CityStateCountryModel cityStateCountryModel = cityService
						.findStateCountryById(patient.getCity());
				if (cityStateCountryModel.getCity() != null) {
					address += cityStateCountryModel.getCity() + ",";
				}
				if (cityStateCountryModel.getState() != null) {
					address += cityStateCountryModel.getState() + ",";
				}
				if (patient.getZipCode() != null) {
					address += patient.getZipCode() + ",";
				}
				if (cityStateCountryModel.getCountry() != null) {
					address += cityStateCountryModel.getCountry() + ",";
				}
			}
			logger.info("Address {}", address);
			if (address != null) {
				String[] latLongs = this.getLatLngByAddress(address);
				if (latLongs[0] != null && latLongs[1] != null) {
					patient.setLat(Double.parseDouble(latLongs[0]));
					patient.setLon(Double.parseDouble(latLongs[1]));
				}
				logger.info("Latitude: " + latLongs[0] + " and Longitude: "
						+ latLongs[1]);
			}
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		return this.patientDAO.insert(patient, user, user_type);
	}

	/**
	 * find By Practiioner Id
	 * @param practitioner
	 * @return
	 */
	@Override
	public List<PatientDetailModel> findByPractiionerId(Integer practitioner) {
		List<PatientDetailModel> patientDetailModelList = this.patientDAO
				.findByPractitionerId(practitioner);
		List<PatientDetailModel> modelList = new ArrayList<PatientDetailModel>();
		if (!patientDetailModelList.isEmpty()) {
			for (PatientDetailModel model : patientDetailModelList) {
				if (model.getPcmId() != null && model.getSender() != 0) {
					modelList.add(model);
				}
			}
		}
		return modelList;
	}

	/**
	 * get encrypted password
	 * @param passwordString
	 * @return sha1
	 * @throws Exception
	 */
	@Override
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

	/**
	 * get Lat Long By Address
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@Override
	public String[] getLatLngByAddress(String city) throws Exception {
		String[] latLon      = new String[2];
		int	  	 maxTries    = 5;
		int		 triesSoFar  = 0;
		int		 sleep       = 1; // In sec.
		boolean  latLonFound = false;
		
		while (! latLonFound ){
			try {
				latLon = getSingleTryLatLngByAddress(city);
				latLonFound = true;
			}
			catch (Exception e) {
				triesSoFar++;
				if (triesSoFar == maxTries)
					throw e;
				
				// Sleep between the next call (findme: Will be better to check the status and make sure that next call can recover due to the sleep)
				Thread.sleep(sleep * 1000);
			}
		}

		return latLon;
	}
	
	private String[] getSingleTryLatLngByAddress(String city) throws Exception {
		int responseCode = 0;
		String api = "http://maps.googleapis.com/maps/api/geocode/xml?address="
				+ URLEncoder.encode(city, "UTF-8") + "&sensor=true";
		logger.info("api url {}" + api);
		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection) url
				.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if (responseCode == 200) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			;
			Document document = builder.parse(httpConnection.getInputStream());
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/GeocodeResponse/status");
			String status = (String) expr.evaluate(document,
					XPathConstants.STRING);
			if (status.equals("OK")) {
				expr = xpath.compile("//geometry/location/lat");
				String latitude = (String) expr.evaluate(document,
						XPathConstants.STRING);
				expr = xpath.compile("//geometry/location/lng");
				String longitude = (String) expr.evaluate(document,
						XPathConstants.STRING);
				return new String[] { latitude, longitude };
			}
			else {
				throw new Exception(
						"Error from the API - response status: " + status);
			}
		}
		return null;
	}

	/**
	 * find By Patientcase
	 * @param patientcase
	 * @return
	 */
	@Override
	public List<PatientDetailModel> findByPatientcase(Integer patientcase,
			Integer practitioner) {
		return this.patientDAO.findByPatientcase(patientcase, practitioner);
	}

	/**
	 * reset Password
	 * @param id
	 * @param old_password
	 * @param new_password
	 * @return
	 */
	@Override
	public Integer resetPassword(int id, String old_password,
			String new_password) {
		return this.patientDAO.resetPassword(id, old_password, new_password);
	}

	/**
	 * find Country By Id
	 * @param id
	 * @return
	 */
	@Override
	public PatientCountryModel findCountryById(int id) {
		return this.patientDAO.findCountryById(id);
	}

	/**
	 * find Lat Lon By Id
	 * @param id
	 * @return
	 */
	@Override
	public PatientLatLonModel findLatLonById(Integer id) {
		return this.patientDAO.findLatLonById(id);
	}

	/**
	 * find By Email
	 * @param email
	 * @return
	 */
	@Override
	public Patient findByEmail(String email, Integer active) {
		return this.patientDAO.findByEmail(email, active);
	}
	
	/**
	 * find By Phone
	 * @param phone
	 * @return
	 */
	@Override
	public Patient findByPhone(String phone, Integer active) {
		return this.patientDAO.findByPhone(phone, active);
	}

}
