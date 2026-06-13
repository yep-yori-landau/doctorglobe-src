/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.Associate;
import com.dg.data.model.db.Corporatecompany;
import com.dg.data.model.domain.CorporatecompanyPatientModel;

/**
 * This is a AssociateService service interface which includes the most
 * fundamental service operations for AssociateService object It also extends
 * the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface AssociateService extends GenericService<Associate> {
	/**
	 * Gets Associate detail based on email and active param
	 * @param email the unique email address of associate user
	 * @param active true
	 * @return Associate Model
	 */
	public Associate findByEmail(String email, Integer active);

	/**
	 * Gets encrypted password string
	 * @param passwordString
	 * @return sha1
	 * @throws Exception
	 */
	public String getSHA1(String passwordString) throws Exception;

	/**
	 * Gets CorporateCompanyPatient detail based on id
	 * @param id
	 * @return list of corportatecompany patient model list
	 */
	public List<CorporatecompanyPatientModel> findCorporateCompanyPatientById(
			BigInteger id);

	/**
	 * Gets corporatecompany by id
	 * @param id
	 * @return list of corporatecompanny model list
	 */
	public List<Corporatecompany> findCorporetecompanyById(BigInteger id);

	/**
	 * find Corporate Company Patient By Id
	 * @param id
	 * @param search
	 * @param cc
	 * @return the list of CorporatecompanyPatientModel
	 */
	public List<CorporatecompanyPatientModel> findCorporateCompanyPatientById(
			BigInteger id, String search, BigInteger cc);

	/**
	 * Resets password
	 * @param id
	 * @param old_password
	 * @param new_password
	 * @return
	 */
	public Integer resetPassword(int id, String old_password,
			String new_password);
}
