
package com.dg.data.service.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.CorporatecompanyDAO;
import com.dg.data.model.db.Corporatecompany;
import com.dg.data.service.CorporatecompanyService;

/**
 * @author DoctorGlobe CorporatecompanyService Implementation
 */

@Service("corporatecompanyService")
public class CorporatecompanyServiceImpl extends
		GenericServiceImpl<Corporatecompany>implements CorporatecompanyService {

	private CorporatecompanyDAO corporatecompanyDAO;

	@Autowired
	public CorporatecompanyServiceImpl(CorporatecompanyDAO genericDAO) {
		super(genericDAO);
		this.corporatecompanyDAO = (CorporatecompanyDAO) genericDAO;
	}

	/**
	 * find By Patient Id
	 * @param id the unique id of patient
	 * @return Corporatecompany model
	 */
	@Override
	public Corporatecompany findByPatientId(BigInteger id) {
		return this.corporatecompanyDAO.findByPatientId(id);
	}

	/**
	 * find By White label Url
	 * @param url
	 * @return corporatecompany model if whitelabel url match
	 */
	@Override
	public Corporatecompany findByWhitelabelUrl(String url) {
		return this.corporatecompanyDAO.findByWhitelabelUrl(url);
	}

}
