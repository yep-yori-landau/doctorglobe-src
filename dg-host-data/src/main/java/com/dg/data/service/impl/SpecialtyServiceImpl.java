
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.SpecialtyDAO;
import com.dg.data.model.db.Specialty;
import com.dg.data.service.SpecialtyService;

/**
 * @author DoctorGlobe SpecialtyService CountryService
 */

@Service("specialtyService")
public class SpecialtyServiceImpl extends GenericServiceImpl<Specialty>
		implements SpecialtyService {

	@Autowired
	public SpecialtyServiceImpl(SpecialtyDAO genericDAO) {
		super(genericDAO);
	}
}
