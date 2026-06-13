
package com.dg.data.service.impl;

import java.math.BigInteger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderSpecialtyTreatmentMethodDAO;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethod;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodService;

/**
 * @author DoctorGlobe HealthcareproviderSpecialtyTreatmentMethodService
 * CountryService
 */

@Service("healthcareproviderSpecialtyTreatmentMethodService")
public class HealthcareproviderSpecialtyTreatmentMethodServiceImpl
		extends GenericServiceImpl<HealthcareproviderSpecialtyTreatmentMethod>
		implements HealthcareproviderSpecialtyTreatmentMethodService {

	private HealthcareproviderSpecialtyTreatmentMethodDAO healthcareproviderSpecialtyTreatmentMethodDAO;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodServiceImpl(
			HealthcareproviderSpecialtyTreatmentMethodDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderSpecialtyTreatmentMethodDAO = (HealthcareproviderSpecialtyTreatmentMethodDAO) genericDAO;
	}

	/**
	 * find By Healthcareprovider Specialty
	 * @param healthcareproviderSpecialty
	 * @return
	 */
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareproviderSpecialty(
			BigInteger healthcareproviderSpecialty) {
		return this.healthcareproviderSpecialtyTreatmentMethodDAO
				.findByHealthcareproviderSpecialty(healthcareproviderSpecialty);
	}

	/**
	 * find By Healthcare provider
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderSpecialtyTreatmentMethodDAO
				.findByHealthcareprovider(healthcareprovider);
	}

	/**
	 * find By Healthcareprovider Specialty Treatment
	 * @param healthcareprovider_specialty
	 * @param treatment
	 * @return
	 */
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareproviderSpecialtyTreatment(
			BigInteger healthcareprovider_specialty, BigInteger treatment) {
		return this.healthcareproviderSpecialtyTreatmentMethodDAO
				.findByHealthcareproviderSpecialtyTreatment(
						healthcareprovider_specialty, treatment);
	}

	/**
	 * find By Healthcareprovider Specialty Treatment Method
	 * @param healthcareprovider_specialty
	 * @param treatment
	 * @param method
	 * @return
	 */
	@Override
	public HealthcareproviderSpecialtyTreatmentMethod findByHealthcareproviderSpecialtyTreatmentMethod(
			BigInteger healthcareprovider_specialty, BigInteger treatment,
			BigInteger method) {
		return this.healthcareproviderSpecialtyTreatmentMethodDAO
				.findByHealthcareproviderSpecialtyTreatmentMethod(
						healthcareprovider_specialty, treatment, method);
	}

	/**
	 * find By Specialty
	 * @param specialty
	 * @return
	 */
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethod> findBySpecialty(
			BigInteger specialty) {
		return this.healthcareproviderSpecialtyTreatmentMethodDAO
				.findBySpecialty(specialty);
	}

}
