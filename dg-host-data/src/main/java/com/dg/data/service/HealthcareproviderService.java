/**
 * 
 */
package com.dg.data.service;

import java.util.List;

import com.dg.data.model.db.Healthcareprovider;
import com.dg.data.model.domain.HealthcareproviderDetail;

/**
 * This is a HealthcareproviderService service interface which includes the most
 * fundamental service operations for HealthcareproviderService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderService
		extends GenericService<Healthcareprovider> {

	/**
	 * find By Treatment Id
	 * @param id
	 * @return
	 */
	public List<HealthcareproviderDetail> findByTreatmentId(Integer id,
			String currency);

	/**
	 * set Healthcare provider Information (distance, volume string)
	 * @param id
	 * @param patient
	 * @return
	 */
	public List<HealthcareproviderDetail> setHealthcareproviderDetails(
			List<HealthcareproviderDetail> healthcareproviderDetail,
			Integer treatment, Integer patient, String currency);

}