
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.TreatmentAliasDAO;
import com.dg.data.model.db.TreatmentAlias;
import com.dg.data.service.TreatmentAliasService;

/**
 * @author DoctorGlobe TreatmentAliasService CountryService
 */

@Service("treatmentAliasService")
public class TreatmentAliasServiceImpl extends
		GenericServiceImpl<TreatmentAlias>implements TreatmentAliasService {

	@Autowired
	public TreatmentAliasServiceImpl(TreatmentAliasDAO genericDAO) {
		super(genericDAO);
	}
}
