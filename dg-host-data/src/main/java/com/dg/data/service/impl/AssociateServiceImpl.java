
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AssociateDAO;
import com.dg.data.model.db.Associate;
import com.dg.data.model.db.Corporatecompany;
import com.dg.data.model.domain.CorporatecompanyPatientModel;
import com.dg.data.service.AssociateService;

/**
 * @author DoctorGlobe AssociateService Implementation
 */

@Service("associateService")
public class AssociateServiceImpl extends GenericServiceImpl<Associate>
		implements AssociateService {

	/**
	 * associateDao object
	 */
	private AssociateDAO associateDAO;

	/**
	 * Constructor.
	 * @param genericDAO (required) DAO object of the AssociateDAO set a
	 * AssociateDAO object in GenericServiceImpl class
	 */
	@Autowired
	public AssociateServiceImpl(AssociateDAO genericDAO) {
		super(genericDAO);
		this.associateDAO = (AssociateDAO) genericDAO;
	}

	/**
	 * Gets associate data based on email or active param
	 * @param email
	 * @param active
	 * @return Associate model
	 */
	@Override
	public Associate findByEmail(String email, Integer active) {
		return this.associateDAO.findByEmail(email, active);
	}

	/**
	 * Gets list of corporate company patient details based on patient id
	 * @param id
	 * @return CorporatecompanyPatientModel list
	 */
	@Override
	public List<CorporatecompanyPatientModel> findCorporateCompanyPatientById(
			BigInteger id) {
		return this.associateDAO.findCorporateCompanyPatientById(id);
	}

	/**
	 * Gets list of corporate company details based on id
	 * @param id
	 * @return Corporatecompany list
	 */
	@Override
	public List<Corporatecompany> findCorporetecompanyById(BigInteger id) {
		return this.associateDAO.findCorporatecompanyById(id);
	}

	/**
	 * Gets list of corporate company patient details based on below params
	 * @param id
	 * @param search
	 * @param cc
	 * @return CorporatecompanyPatientModel list
	 */
	@Override
	public List<CorporatecompanyPatientModel> findCorporateCompanyPatientById(
			BigInteger id, String search, BigInteger cc) {
		return this.associateDAO.findCorporateCompanyPatientById(id, search,
				cc);
	}

	/**
	 * Update password in database
	 * @param id
	 * @param old_password
	 * @param new_password
	 * @return Integer
	 */
	@Override
	public Integer resetPassword(int id, String old_password,
			String new_password) {
		return this.associateDAO.resetPassword(id, old_password, new_password);
	}

	/**
	 * Gets encrypted password string
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

}
