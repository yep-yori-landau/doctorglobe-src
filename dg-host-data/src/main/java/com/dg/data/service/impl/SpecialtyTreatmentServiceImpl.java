
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.SpecialtyTreatmentDAO;
import com.dg.data.model.db.SpecialtyTreatment;
import com.dg.data.service.SpecialtyTreatmentService;

/**
 * @author DoctorGlobe SpecialtyTreatmentService CountryService
 */

@Service("specialtyTreatmentService")
public class SpecialtyTreatmentServiceImpl
		extends GenericServiceImpl<SpecialtyTreatment>
		implements SpecialtyTreatmentService {

	private SpecialtyTreatmentDAO specialtyTreatmentDAO;

	@Autowired
	public SpecialtyTreatmentServiceImpl(SpecialtyTreatmentDAO genericDAO) {
		super(genericDAO);
		this.specialtyTreatmentDAO = (SpecialtyTreatmentDAO) genericDAO;
	}

	/**
	 * find By Specialty
	 * @param specialty
	 * @return
	 */
	@Override
	public List<SpecialtyTreatment> findBySpecialty(BigInteger specialty) {
		return this.specialtyTreatmentDAO.findBySpecialty(specialty);
	}
}
