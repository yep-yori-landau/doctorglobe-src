/**
 * 
 */
package com.dg.data.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.HealthcareproviderDAO;
import com.dg.data.model.db.Healthcareprovider;
import com.dg.data.model.domain.HealthcareproviderDetail;
import com.dg.data.model.domain.mapper.HealthcareproviderDetailMapper;

/**
 * This class represent Implementation of HealthcareproviderDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderDAOImpl extends
		GenericDAOImpl<Healthcareprovider>implements HealthcareproviderDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderDAOImpl.class);

	@Override
	public List<HealthcareproviderDetail> findByTreatmentId(Integer id,
			String currency) {
		List<HealthcareproviderDetail> healthcareproviderDetail = null;
		String query = "SELECT hcp.id as id,hcp.aha_id,hcp.website as website,hcp.name as name,hcp.description as description,c.id as city, c.name as location,c.lat as city_lat,c.lon as city_lon,"
				+ " hcp.address_1 as address_1,hcp.address_2 as address_2,hcp.zip_code as zip_code,c.country as country,co.name as country_name ,s.name as state,hcpr.score as rating,hcpstmp.practitioner as experts,t.name as treatment_name,er.rate as rate,"
				+ " hcpstmp.availability_days as available_days,(hcpstmp.healthcareprovider_price + hcpstmp.practitioner_price + hcpstmp.anesthesia_price) as estimated_cost,"
				+ " r.name as region_name,hcpstmp.currency as currency,a.name as amenity,ac.name as accreditation,hcpu.name as unit,hcpp.path as healthcareprovider_image,"
				+ " a.is_display as is_display,e.name as equipment,e.is_display as is_equipment_display,f.name as feature,hcpuf.description as unit_description,s.code as state_code,"
				+ " hcpp.is_primary,hcpp.type as image_type,hcp.lat,hcp.lon,hcp.mortality_rate,hcp.per_case_insurance_cap,hcp.affiliation,hcpstmp.corporatecompany_insurance,"
				+ " hcpstmp.number_performed_last_year,hcpstmp.id as hcpstmp_id,sp.usnews_doctor_link, t.usnews_name, p.id as practitioner,"
				+ "	td.before_days,td.after_days,td.treatment_days,de.amount as daily_expense FROM healthcareprovider hcp "
				+ " left outer join healthcareprovider_amenity hcpa on hcp.id = hcpa.healthcareprovider"
				+ " left outer join amenity a on hcpa.amenity = a.id"
				+ " left outer join healthcareprovider_accreditation hcpac on hcp.id = hcpac.healthcareprovider"
				+ " left outer join accreditation ac on hcpac.accreditation = ac.id"
				+ " left outer join healthcareprovider_equipment he on hcp.id = he.healthcareprovider"
				+ " left outer join equipment e on he.equipment = e.id"
				+ " left outer join city c on hcp.city = c.id"
				+ " left outer join country co on c.country = co.id"
				+ " left outer join state s on c.state = s.id"
				+ " left outer join region r on co.region = r.id"
				+ " left outer join healthcareprovider_specialty hcps on hcp.id = hcps.healthcareprovider"
				+ " left outer join specialty sp on sp.id = hcps.specialty"
				+ " left outer join healthcareprovider_specialty_treatment_method hcpstm on hcps.id = hcpstm.healthcareprovider_specialty"
				+ " left outer join treatment t on t.id = hcpstm.treatment"
				+ " left outer join healthcareprovider_specialty_treatment_method_practitioner hcpstmp on hcpstm.id = hcpstmp.healthcareprovider_specialty_treatment_method"
				+ " left outer join practitioner p on p.id = hcpstmp.practitioner"
				+ " left outer join healthcareprovider_ratings hcpr on hcp.id = hcpr.healthcareprovider"
				+ " left outer join healthcareprovider_unit_feature hcpuf on hcp.id = hcpuf.healthcareprovider"
				+ " left outer join healthcareproviderunit hcpu on hcpuf.healthcareproviderunit = hcpu.id"
				+ " left outer join feature f on hcpuf.feature = f.id"
				+ " left outer join healthcareproviderphoto hcpp on hcp.id = hcpp.healthcareprovider"
				+ " left outer join exchange_rate er on er.from_cur = hcp.currency"
				+ " left outer join treatmentdays td on td.country = c.country and td.treatment = t.id"
				+ " left outer join daily_expense de on de.country = c.country"
				+ " WHERE t.ID = ? and hcpstmp.active = 1 and t.name !='standard' and er.to_cur = ?";
		logger.info("query {}", query);
		healthcareproviderDetail = this.getJdbcTemplate().query(query,
				new Object[] { id, currency },
				new HealthcareproviderDetailMapper());
		return healthcareproviderDetail;
	}
}
