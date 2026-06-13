/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.Healthcareproviderphoto;

/**
 * This is a HealthcareproviderphotoService service interface which includes the
 * most fundamental service operations for HealthcareproviderphotoService object
 * It also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderphotoService
		extends GenericService<Healthcareproviderphoto> {
	/**
	 * find By Healthcarer povider
	 * @param healthcareprovider
	 * @return
	 */
	public List<Healthcareproviderphoto> findByHealthcarerpovider(
			BigInteger healthcareprovider);

}
