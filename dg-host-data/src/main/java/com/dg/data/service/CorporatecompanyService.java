/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import com.dg.data.model.db.Corporatecompany;

/**
 * This is a CorporatecompanyService service interface which includes the most
 * fundamental service operations for CorporatecompanyService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface CorporatecompanyService
		extends GenericService<Corporatecompany> {
	/**
	 * find By Patient Id
	 * @param id
	 * @return Corporatecompany model
	 */
	public Corporatecompany findByPatientId(BigInteger id);

	/**
	 * find By White label Url
	 * @param url
	 * @return corporatecompany model if whitelabel url match
	 */
	public Corporatecompany findByWhitelabelUrl(String url);

}
