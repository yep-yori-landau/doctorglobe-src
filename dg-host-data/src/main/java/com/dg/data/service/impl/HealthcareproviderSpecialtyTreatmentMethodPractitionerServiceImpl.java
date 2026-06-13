
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderSpecialtyTreatmentMethodPractitionerDAO;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitioner;
import com.dg.data.model.domain.HospitalPractitionerModel;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerService;

/**
 * @author DoctorGlobe
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerService CountryService
 */

@Service("healthcareproviderSpecialtyTreatmentMethodPractitionerService")
public class HealthcareproviderSpecialtyTreatmentMethodPractitionerServiceImpl
		extends
		GenericServiceImpl<HealthcareproviderSpecialtyTreatmentMethodPractitioner>
		implements
		HealthcareproviderSpecialtyTreatmentMethodPractitionerService {

	private HealthcareproviderSpecialtyTreatmentMethodPractitionerDAO healthcareproviderSpecialtyTreatmentMethodPractitionerDAO;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerServiceImpl(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderSpecialtyTreatmentMethodPractitionerDAO = (HealthcareproviderSpecialtyTreatmentMethodPractitionerDAO) genericDAO;
	}

	/**
	 * find By Hstm
	 * @param hstm
	 * @return
	 */
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findByHstm(
			BigInteger hstm) {
		return this.healthcareproviderSpecialtyTreatmentMethodPractitionerDAO
				.findByHstm(hstm);
	}

	/**
	 * find By Healthcare provider
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderSpecialtyTreatmentMethodPractitionerDAO
				.findByHealthcareprovider(healthcareprovider);
	}

	/**
	 * find By Hstm Practitioner
	 * @param hstm
	 * @param practitioner
	 * @return
	 */
	@Override
	public HealthcareproviderSpecialtyTreatmentMethodPractitioner findByHstmPractitioner(
			BigInteger hstm, BigInteger practitioner) {
		return this.healthcareproviderSpecialtyTreatmentMethodPractitionerDAO
				.findByHstmPractitioner(hstm, practitioner);
	}

	/**
	 * find By Specialty
	 * @param specialty
	 * @return
	 */
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findBySpecialty(
			BigInteger specialty) {
		return this.healthcareproviderSpecialtyTreatmentMethodPractitionerDAO
				.findBySpecialty(specialty);
	}

	/**
	 * find By Hstm Id
	 * @param hstm
	 * @return
	 */
	@Override
	public List<HospitalPractitionerModel> findByHstmId(BigInteger hstm) {
		return this.healthcareproviderSpecialtyTreatmentMethodPractitionerDAO
				.findByHstmId(hstm);
	}

}
