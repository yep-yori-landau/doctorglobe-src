
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.TreatmentdaysDAO;
import com.dg.data.model.db.Treatmentdays;
import com.dg.data.service.TreatmentdaysService;

/**
 * @author DoctorGlobe TreatmentdaysService CountryService
 */

@Service("treatmentdaysService")
public class TreatmentdaysServiceImpl extends GenericServiceImpl<Treatmentdays>
		implements TreatmentdaysService {

	@Autowired
	public TreatmentdaysServiceImpl(TreatmentdaysDAO genericDAO) {
		super(genericDAO);
	}
}
