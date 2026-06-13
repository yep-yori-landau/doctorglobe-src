/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.Associate;
import com.dg.data.model.db.Corporatecompany;
import com.dg.data.model.domain.CorporatecompanyPatientModel;

/**
 * This is a associate DAO interface which includes the most fundamental DAO
 * operations (findByEmail, etc) for any associate object It also extends the
 * generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface AssociateDAO extends GenericDAO<Associate> {

	/**
	 * Gets associate data based on email or active param
	 * @param email
	 * @param active
	 * @return Associate model
	 */
	public Associate findByEmail(String email, Integer active);

	/**
	 * Gets list of corporate company patient details based on patient id
	 * @param id
	 * @return CorporatecompanyPatientModel list
	 */
	public List<CorporatecompanyPatientModel> findCorporateCompanyPatientById(
			BigInteger id);

	/**
	 * Gets list of corporate company details based on id
	 * @param id
	 * @return Corporatecompany list
	 */
	public List<Corporatecompany> findCorporatecompanyById(BigInteger id);

	/**
	 * Gets list of corporate company patient details based on below params
	 * @param id
	 * @param search
	 * @param cc
	 * @return CorporatecompanyPatientModel list
	 */
	public List<CorporatecompanyPatientModel> findCorporateCompanyPatientById(
			BigInteger id, String search, BigInteger cc);

	/**
	 * Update password in database
	 * @param id
	 * @param old_password
	 * @param new_password
	 * @return Integer
	 */
	public Integer resetPassword(Integer id, String old_password,
			String new_password);

}
