package com.dg.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dg.data.dao.EmployeeCorporatecompanyDAO;
import com.dg.data.model.db.EmployeeCorporatecompany;
import com.dg.data.model.domain.EmployeeCorporatecompanyDetail;
import com.dg.data.model.domain.mapper.EmployeeCorporatecompanyDetailMapper;

/**
 * This class represent Implementation of EmployeeCorporatecompanyDAO which can
 * be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */
public class EmployeeCorporatecompanyDAOImpl
		extends GenericDAOImpl<EmployeeCorporatecompany>
		implements EmployeeCorporatecompanyDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeCorporatecompanyDAOImpl.class);

	@Override
	public EmployeeCorporatecompanyDetail findByPatient(Integer patient) {
		EmployeeCorporatecompanyDetail model = new EmployeeCorporatecompanyDetail();
		try {
			String query = "select empcc.id,cci.annual_oop,cci.deductible,p.ytd_oop,cc.worker_incentive,empcc.corporatecompany_insurance,empcc.patient,cc.city,empcc.email as email,"
					+ " cci.program_name,cci.annual_oop as corporatecompany_annual_oop,cci.deductible as corporatecompany_deductible,cci.co_insurance as corporatecompany_co_insurance,cc.minimum_amount_spread,"
					+ " cc.minimum_percentage_spread,cc.currency,cc.dg_commission,cci.corporate_company,co.id as country,c.lat as city_lat,c.lon as city_lon from employee_corporatecompany empcc "
					+ "	left outer join corporatecompany_insurance cci on empcc.corporatecompany_insurance = cci.id"
					+ "	left outer join corporatecompany cc on cci.corporate_company = cc.id"
					+ " left outer join city c on cc.city = c.id"
					+ " left outer join country co on co.id = c.country"
					+ " left outer join patient p on p.id = empcc.patient"
					+ " where patient = ? limit 1";
			model = this.getJdbcTemplate().queryForObject(query,
					new Object[] { patient },
					new EmployeeCorporatecompanyDetailMapper());
		}
		catch (Exception ex) {
			logger.info("sql error found {}", ex.getMessage());
		}
		return model;
	}

}