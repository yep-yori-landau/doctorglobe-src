/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.dg.data.model.db.Practitioner;
import com.dg.data.model.db.mapper.PractitionerMapper;
import com.dg.data.model.domain.HealthcareproviderPractitionerCountryModel;
import com.dg.data.model.domain.HealthcareproviderPractitionerModel;
import com.dg.data.model.domain.PractitionerDetail;
import com.dg.data.model.domain.mapper.HealthcareproviderPractitionerCountryModelMapper;
import com.dg.data.model.domain.mapper.HealthcareproviderPractitionerMapper;
import com.dg.data.model.domain.mapper.PractitionerDetailMapper;
import com.dg.data.dao.PractitionerDAO;

/**
 * @author DoctorGlobe
 * 
 */

public class PractitionerDAOImpl extends GenericDAOImpl<Practitioner>
		implements PractitionerDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(PractitionerDAOImpl.class);

	/**
	 * @param region
	 * @return integer
	 */
	public Integer insert(Practitioner practitioner) {
		Integer result = 0;
		try {
			int row = super.insert(practitioner);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from practitioner where email = ?",
						new Object[] { practitioner.getEmail() },
						Integer.class);
			}
		}
		catch (Exception ex) {
			logger.info(ex.getMessage());
		}
		return result;
	}

	/**
	 * @param region
	 * @return integer
	 */
	public Integer insert(Practitioner practitioner, BigInteger user,
			String type) {
		Integer result = 0;
		try {
			int row = super.insert(practitioner, user, type);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from practitioner where email = ?",
						new Object[] { practitioner.getEmail() },
						Integer.class);
			}
		}
		catch (Exception ex) {
			logger.info(ex.getMessage());
		}
		return result;
	}

	/**
	 * @param id return practitioner list
	 */
	public List<PractitionerDetail> findByHealthcareproviderId(Integer id,
			Integer treatment) {
		List<PractitionerDetail> practitionerDetail = null;
		try {
			String query = "SELECT p.email as email,p.id as id,p.title as title, concat(p.first_name,' ',p.last_name) as name,p.degree,"
					+ " p.gender as gender,p.description as description,p.usa_certification as usa_certification,p.usa_training as usa_training,"
					+ " m.name as method,prr.rating as rating,hcpstmp.id as hcpstmp,pl.language as language,hcpstmp.availability_days as available_days,"
					+ " (hcpstmp.healthcareprovider_price + hcpstmp.practitioner_price + hcpstmp.anesthesia_price) as estimated_cost,hcpstmp.currency as currency,"
					+ " hcp.name as healthcareprovider_name,hcp.description as healthcareprovider_description, concat(hcp.address_1,',',c.name) as healthcareprovider_location,"
					+ " t.name as treatment_name,hcpu.name as unit,p.photo as practitioner_image,hcpp.path as healthcareprovider_image,f.name as feature,"
					+ " hcpuf.description as unit_description,hcp.id as healthcareprovider_id,c.name as healthcareprovider_city,s.name as healthcareprovider_state,"
					+ " co.name as healthcareprovider_country,a.name as amenity,a.is_display as is_display,e.name as equipment,e.is_display as is_equipment_display,hcp.lat,"
					+ " hcp.lon,hcpp.is_primary,hcpstmp.years_practiced,hcppr.insurance_cap,"
					+ " hcpstmp.number_performed_overall,hcpstmp.number_performed_last_year,hcpstmp.corrections_last_year,concat(hcppr.first_name,' ',hcppr.last_name) as healthcareprovider_practitioner_name,"
					+ " hcppr.description as healthcareprovider_practitioner_description,hcppr.title as healthcareprovider_practitioner_title FROM practitioner p"
					+ " left outer join practitioner_language pl on p.id = pl.practitioner"
					+ " left outer join healthcareprovider_specialty_treatment_method_practitioner hcpstmp on p.id = hcpstmp.practitioner"
					+ " left outer join patientreview pr on hcpstmp.id = pr.healthcareprovider_specialty_treatment_method_practitioner"
					+ " left outer join patientreviewratings prr on pr.id = prr.patient_review"
					+ " left outer join healthcareprovider_specialty_treatment_method hcpstm on hcpstmp.healthcareprovider_specialty_treatment_method = hcpstm.id"
					+ " left outer join treatment t on hcpstm.treatment = t.id"
					+ " left outer join method m on hcpstm.method = m.id"
					+ " left outer join healthcareprovider_specialty hcps on hcps.id = hcpstm.healthcareprovider_specialty"
					+ " left outer join healthcareprovider hcp on hcp.id = hcps.healthcareprovider"
					+ " left outer join healthcareprovider_amenity hcpa on hcp.id = hcpa.healthcareprovider"
					+ " left outer join amenity a on hcpa.amenity = a.id"
					+ " left outer join healthcareprovider_equipment he on hcp.id = he.healthcareprovider"
					+ " left outer join equipment e on he.equipment = e.id"
					+ " left outer join healthcareprovider_unit_feature hcpuf on hcp.id = hcpuf.healthcareprovider"
					+ " left outer join healthcareproviderunit hcpu on hcpuf.healthcareproviderunit = hcpu.id"
					+ " left outer join feature f on hcpuf.feature = f.id"
					+ " left outer join healthcareproviderphoto hcpp on hcpp.healthcareprovider = hcp.id"
					+ " left outer join city c on hcp.city = c.id"
					+ " left outer join country co on c.country = co.id"
					+ " left outer join state s on c.state = s.id"
					+ " left outer join healthcareprovider_practitioner hcppr on hcppr.healthcareprovider = hcp.id and hcppr.practitioner = p.id"
					+ " where hcp.id = ? and t.id = ? and hcpstmp.active = 1 and t.name !='general'";
			practitionerDetail = this.getJdbcTemplate().query(query,
					new Object[] { id, treatment },
					new PractitionerDetailMapper());
		}
		catch (Exception ex) {
			logger.info("sql error found {}", ex.getMessage());
			ex.printStackTrace();
		}
		return practitionerDetail;
	}

	/**
	 * @param email
	 * @return patient model
	 */
	public Practitioner findByEmail(String email, Integer active) {
		Practitioner practitioner = new Practitioner();
		if (email != null) {
			try {
				String query = "SELECT *FROM practitioner WHERE email = ?";
				logger.info("query {} {}", query, email);
				practitioner = (Practitioner)this.getJdbcTemplate().queryForObject(query,
						new Object[] { email },
						new BeanPropertyRowMapper(Practitioner.class));
			}
			catch (Exception ex) {
				logger.info("exception found {}", ex.getMessage());
				ex.printStackTrace();
			}
		}
		return practitioner;
	}

	/**
	 * 
	 * @param id
	 * @param old_password
	 * @param new_password
	 * @return
	 */

	public Integer resetPassword(Integer id, String old_password,
			String new_password) {
		Integer result = 0;
		if (id != null && old_password != null && new_password != null) {
			try {
				String query = "UPDATE practitioner set password =sha1(?) WHERE id = ? and password = ?";
				result = this.getJdbcTemplate().update(query,
						new Object[] { new_password, id, old_password });
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param healthcareprovider return practitioner list
	 */
	public List<HealthcareproviderPractitionerModel> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderPractitionerModel> healthcareproviderPractitioner = null;
		try {
			String query = "SELECT hcpp.email as email,p.id as id,hcpp.title as title, concat(hcpp.first_name,' ',hcpp.last_name) as name,p.degree,t.id as treatment_id,t.name as treatment_name,m.id as method_id,m.name as method_name,s.id as specialty_id,s.name as specialty_name,hcpstmp.id as hstmp,hcpstm.id as hstm,hcpstmp.active as active,hcpp.practitioner as practitioner FROM practitioner p"
					+ " left outer join healthcareprovider_specialty_treatment_method_practitioner hcpstmp on p.id = hcpstmp.practitioner"
					+ " left outer join healthcareprovider_specialty_treatment_method hcpstm on hcpstmp.healthcareprovider_specialty_treatment_method = hcpstm.id"
					+ " left outer join treatment t on hcpstm.treatment = t.id"
					+ " left outer join method m on hcpstm.method = m.id"
					+ " left outer join healthcareprovider_specialty hcps on hcps.id = hcpstm.healthcareprovider_specialty"
					+ " left outer join specialty s on hcps.specialty = s.id"
					+ " left outer join healthcareprovider hcp on hcp.id = hcps.healthcareprovider"
					+ " left outer join healthcareprovider_practitioner hcpp on hcpp.healthcareprovider = hcp.id and hcpp.practitioner = p.id"
					+ " where hcp.id = ?";
			healthcareproviderPractitioner = this.getJdbcTemplate().query(query,
					new Object[] { healthcareprovider },
					new HealthcareproviderPractitionerMapper());
		}
		catch (Exception ex) {
			logger.info("sql error found ={}", ex.getMessage());
		}
		return healthcareproviderPractitioner;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<HealthcareproviderPractitionerCountryModel> findByHstmp(
			BigInteger hstmp) {
		List<HealthcareproviderPractitionerCountryModel> countryDetail = null;
		String query = "SELECT c.name as city,co.name as country ,co.code as country_code,s.name as state FROM healthcareprovider hcp "
				+ " left outer join city c on hcp.city = c.id"
				+ " left outer join country co on c.country = co.id"
				+ " left outer join state s on c.state = s.id"
				+ " left outer join region r on co.region = r.id"
				+ " left outer join healthcareprovider_specialty hcps on hcp.id = hcps.healthcareprovider"
				+ " left outer join healthcareprovider_specialty_treatment_method hcpstm on hcps.id = hcpstm.healthcareprovider_specialty"
				+ " left outer join healthcareprovider_specialty_treatment_method_practitioner hcpstmp on hcpstm.id = hcpstmp.healthcareprovider_specialty_treatment_method"
				+ " WHERE hcpstmp.id = ?";
		countryDetail = this.getJdbcTemplate().query(query,
				new Object[] { hstmp },
				new HealthcareproviderPractitionerCountryModelMapper());
		return countryDetail;
	}

	@Override
	public List<PractitionerDetail> findCorporatecompanyInsurancePractitioner(
			Integer id, Integer treatment, BigInteger ccinsurance) {
		List<PractitionerDetail> practitionerDetail = null;
		try {
			String query = "SELECT p.email as email,p.id as id,p.title as title, concat(p.first_name,' ',p.last_name) as name,p.degree,"
					+ " p.gender as gender,p.description as description,p.usa_certification as usa_certification,p.usa_training as usa_training,"
					+ " m.name as method,prr.rating as rating,hcpstmp.id as hcpstmp,pl.language as language,hcpstmp.availability_days as available_days,"
					+ " (hcpstmp.healthcareprovider_price + hcpstmp.practitioner_price + hcpstmp.anesthesia_price) as estimated_cost,hcpstmp.currency as currency,"
					+ " hcp.name as healthcareprovider_name,hcp.description as healthcareprovider_description, concat(hcp.address_1,',',c.name) as healthcareprovider_location,"
					+ " t.name as treatment_name,hcpu.name as unit,p.photo as practitioner_image,hcpp.path as healthcareprovider_image,f.name as feature,"
					+ " hcpuf.description as unit_description,hcp.id as healthcareprovider_id,c.name as healthcareprovider_city,s.name as healthcareprovider_state,"
					+ " co.name as healthcareprovider_country,a.name as amenity,a.is_display as is_display,e.name as equipment,e.is_display as is_equipment_display,hcp.lat,"
					+ " hcp.lon,hcpp.is_primary,hcpstmp.years_practiced,hcppr.insurance_cap,"
					+ " hcpstmp.number_performed_overall,hcpstmp.number_performed_last_year,hcpstmp.corrections_last_year,concat(hcppr.first_name,' ',hcppr.last_name) as healthcareprovider_practitioner_name,"
					+ " hcppr.description as healthcareprovider_practitioner_description,hcppr.title as healthcareprovider_practitioner_title FROM practitioner p"
					+ " left outer join practitioner_language pl on p.id = pl.practitioner"
					+ " left outer join healthcareprovider_specialty_treatment_method_practitioner hcpstmp on p.id = hcpstmp.practitioner"
					+ " left outer join patientreview pr on hcpstmp.id = pr.healthcareprovider_specialty_treatment_method_practitioner"
					+ " left outer join patientreviewratings prr on pr.id = prr.patient_review"
					+ " left outer join healthcareprovider_specialty_treatment_method hcpstm on hcpstmp.healthcareprovider_specialty_treatment_method = hcpstm.id"
					+ " left outer join treatment t on hcpstm.treatment = t.id"
					+ " left outer join method m on hcpstm.method = m.id"
					+ " left outer join healthcareprovider_specialty hcps on hcps.id = hcpstm.healthcareprovider_specialty"
					+ " left outer join healthcareprovider hcp on hcp.id = hcps.healthcareprovider"
					+ " left outer join healthcareprovider_amenity hcpa on hcp.id = hcpa.healthcareprovider"
					+ " left outer join amenity a on hcpa.amenity = a.id"
					+ " left outer join healthcareprovider_equipment he on hcp.id = he.healthcareprovider"
					+ " left outer join equipment e on he.equipment = e.id"
					+ " left outer join healthcareprovider_unit_feature hcpuf on hcp.id = hcpuf.healthcareprovider"
					+ " left outer join healthcareproviderunit hcpu on hcpuf.healthcareproviderunit = hcpu.id"
					+ " left outer join feature f on hcpuf.feature = f.id"
					+ " left outer join healthcareproviderphoto hcpp on hcpp.healthcareprovider = hcp.id"
					+ " left outer join city c on hcp.city = c.id"
					+ " left outer join country co on c.country = co.id"
					+ " left outer join state s on c.state = s.id"
					+ " left outer join healthcareprovider_practitioner hcppr on hcppr.healthcareprovider = hcp.id and hcppr.practitioner = p.id"
					+ " where hcp.id = ? and t.id = ? and hcpstmp.active = 1 and t.name !='general' and (hcpstmp.corporatecompany_insurance = ? or hcpstmp.corporatecompany_insurance is NULL)";
			practitionerDetail = this.getJdbcTemplate().query(query,
					new Object[] { id, treatment, ccinsurance },
					new PractitionerDetailMapper());
		}
		catch (Exception ex) {
			logger.info("sql error found {}", ex.getMessage());
			ex.printStackTrace();
		}
		return practitionerDetail;
	}

	@Override
	public Practitioner findByName(String name) {
		Practitioner practitionerModel = new Practitioner();
		if (name != null) {
			try {
				String query = "SELECT *FROM practitioner WHERE concat(first_name,' ',last_name) like '%"
						+ name + "%' limit 1";
				logger.info("query {} {}", query, name);
				practitionerModel = (Practitioner)this.getJdbcTemplate().queryForObject(query, new BeanPropertyRowMapper(Practitioner.class));
			}
			catch (Exception ex) {
				logger.info("exception found {}", ex.getMessage());
			}
		}
		return practitionerModel;
	}
}
