/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderLanguage;

/**
 * This is a HealthcareproviderLanguageService service interface which includes
 * the most fundamental service operations for HealthcareproviderLanguageService
 * object It also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderLanguageService
		extends GenericService<HealthcareproviderLanguage> {
	/**
	 * get list of health care provider Language by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderLanguage> findByHealthcareprovider(
			BigInteger healthcareprovider);

}
