
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientcasePriceDAO;
import com.dg.data.model.db.PatientcasePrice;
import com.dg.data.service.PatientcasePriceService;

/**
 * @author DoctorGlobe PatientcasePriceService CountryService
 */

@Service("patientcasePriceService")
public class PatientcasePriceServiceImpl extends
		GenericServiceImpl<PatientcasePrice>implements PatientcasePriceService {

	private PatientcasePriceDAO patientcasePriceDAO;

	@Autowired
	public PatientcasePriceServiceImpl(PatientcasePriceDAO genericDAO) {
		super(genericDAO);
		this.patientcasePriceDAO = (PatientcasePriceDAO) genericDAO;
	}

	/**
	 * find By Patient case And Hcpstmp
	 * @param patientcase
	 * @param hcpstmp
	 * @return
	 */
	@Override
	public PatientcasePrice findByPatientcaseAndHcpstmp(Integer patientcase,
			Integer hcpstmp) {
		return this.patientcasePriceDAO.findByPatientcaseAndHcpstmp(patientcase,
				hcpstmp);
	}

}
