/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.AssociateDAO;
import com.dg.data.model.db.Associate;
import com.dg.data.model.db.Corporatecompany;
import com.dg.data.model.db.mapper.AssociateMapper;
import com.dg.data.model.db.mapper.CorporatecompanyMapper;
import com.dg.data.model.domain.CorporatecompanyPatientModel;
import com.dg.data.model.domain.mapper.CorporatecompanyPatientMapper;

/**
 * This class represent Implementation of AssociateDAO which can be extended to
 * add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class AssociateDAOImpl extends GenericDAOImpl<Associate>
		implements AssociateDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AssociateDAOImpl.class);

	/**
	 * @param associate
	 * @return integer
	 */
	public Integer insert(Associate associate) {
		Integer result = 0;
		try {
			int row = super.insert(associate);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from associate where email = ?",
						new Object[] { associate.getEmail() }, Integer.class);
			}
		}
		catch (Exception ex) {
			logger.info("Error found {}", ex.getMessage());
		}
		return result;
	}

	/**
	 * @param associate
	 * @return integer
	 */
	public Integer insert(Associate associate, BigInteger user,
			String user_type) {
		Integer result = 0;
		try {
			int row = super.insert(associate, user, user_type);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from associate where email = ?",
						new Object[] { associate.getEmail() }, Integer.class);
			}
		}
		catch (Exception ex) {
			logger.info("Error found {}", ex.getMessage());
		}
		return result;
	}

	/**
	 * @param email
	 * @return associate model
	 */
	public Associate findByEmail(String email, Integer active) {
		Associate associate = new Associate();
		if (email != null) {
			try {
				String query = "SELECT *FROM associate WHERE email = ? and active = ?";
				System.out.print(query);
				associate = this.getJdbcTemplate().queryForObject(query,
						new Object[] { email, active }, new AssociateMapper());
			}
			catch (Exception ex) {
				logger.info("Error found {}", ex.getMessage());
			}
		}
		return associate;
	}

	@Override
	public List<CorporatecompanyPatientModel> findCorporateCompanyPatientById(
			BigInteger id) {
		List<CorporatecompanyPatientModel> corporatecompanyPatientModelList = new ArrayList<CorporatecompanyPatientModel>();
		try {
			String query = "select cc.name as cc_name,concat(p.first_name,' ',p.last_name) as patient_name,p.id as patient_id,cc.id as id from associate a "
					+ " left join corporatecompany cc on cc.association = a.association "
					+ " left join corporatecompany_insurance cci on cc.id = cci.corporate_company "
					+ " left join employee_corporatecompany ec on ec.corporatecompany_insurance = cci.id"
					+ " left join patient p on ec.patient = p.id where a.id =?";
			corporatecompanyPatientModelList = this.getJdbcTemplate().query(
					query, new Object[] { id },
					new CorporatecompanyPatientMapper());
		}
		catch (Exception ex) {
			logger.info("Exception found {}", ex.getMessage());
		}
		return corporatecompanyPatientModelList;
	}

	@Override
	public List<CorporatecompanyPatientModel> findCorporateCompanyPatientById(
			BigInteger id, String search, BigInteger cc) {
		List<CorporatecompanyPatientModel> corporatecompanyPatientModelList = new ArrayList<CorporatecompanyPatientModel>();
		try {
			String andQuery = "";
			if (cc.intValue() != 0) {
				andQuery = " and cc.id = ?)";
			}
			else {
				andQuery = " and cc.id != ?)";
			}
			logger.info("search {}", search);
			if (!search.equalsIgnoreCase("null")) {
				andQuery += " and (p.first_name like '%" + search + "%'"
						+ " or p.last_name like '%" + search + "%'"
						+ " or ec.employee_id like '%" + search + "%')";
			}

			String query = "select cc.name as cc_name,ec.employee_id as employee_id,p.first_name as first_name,p.last_name as last_name,p.id as patient_id,cc.id as id,p.email,c.name as city,s.name as state,co.name as country from associate a "
					+ " left join corporatecompany cc on cc.association = a.association "
					+ " left join corporatecompany_insurance cci on cc.id = cci.corporate_company "
					+ " left join employee_corporatecompany ec on ec.corporatecompany_insurance = cci.id"
					+ " left join patient p on ec.patient = p.id or ec.patient = p.dependent"
					+ " left join city c on p.city = c.id "
					+ " left join state s on c.state = s.id "
					+ " left join country co on c.country = co.id"
					+ " where (a.id =?" + andQuery;
			logger.info("sql query {}", query);
			corporatecompanyPatientModelList = this.getJdbcTemplate().query(
					query, new Object[] { id, cc },
					new CorporatecompanyPatientMapper());
		}
		catch (Exception ex) {
			logger.info("Exception found {}", ex.getMessage());
		}
		return corporatecompanyPatientModelList;
	}

	@Override
	public List<Corporatecompany> findCorporatecompanyById(BigInteger id) {
		List<Corporatecompany> corporatecompanyList = new ArrayList<Corporatecompany>();
		try {
			String query = "select cc.* from associate a "
					+ " left join corporatecompany cc on cc.association = a.association "
					+ " left join corporatecompany_insurance cci on cc.id = cci.corporate_company "
					+ " left join employee_corporatecompany ec on ec.corporatecompany_insurance = cci.id"
					+ " left join patient p on ec.patient = p.id where a.id =? group by cc.id";
			corporatecompanyList = this.getJdbcTemplate().query(query,
					new Object[] { id }, new CorporatecompanyMapper());
		}
		catch (Exception ex) {
			logger.info("Exception found {}", ex.getMessage());
		}
		return corporatecompanyList;
	}

	@Override
	public Integer resetPassword(Integer id, String old_password,
			String new_password) {
		Integer result = 0;
		if (id != null && old_password != null && new_password != null) {
			try {
				String query = "UPDATE associate set password =sha1(?) WHERE id = ? and password = ?";
				result = this.getJdbcTemplate().update(query,
						new Object[] { new_password, id, old_password });
			}
			catch (Exception ex) {
				logger.info("Error found {}", ex.getMessage());
			}
		}
		return result;
	}

}
