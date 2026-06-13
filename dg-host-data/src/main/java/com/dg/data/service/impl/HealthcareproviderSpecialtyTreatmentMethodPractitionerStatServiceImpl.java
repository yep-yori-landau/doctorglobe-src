
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitionerStat;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService;

/**
 * @author DoctorGlobe
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService
 * CountryService
 */

@Service("healthcareproviderSpecialtyTreatmentMethodPractitionerStatService")
public class HealthcareproviderSpecialtyTreatmentMethodPractitionerStatServiceImpl
		extends
		GenericServiceImpl<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat>
		implements
		HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService {

	private HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO healthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerStatServiceImpl(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO = (HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO) genericDAO;
	}

	/**
	 * find By Hstmp
	 * @param hstmp
	 * @return list
	 */
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> findByHstmp(
			BigInteger hstmp) {
		return this.healthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO
				.findByHstmp(hstmp);
	}

}
