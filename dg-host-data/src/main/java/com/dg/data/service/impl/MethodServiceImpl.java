
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.MethodDAO;
import com.dg.data.model.db.Method;
import com.dg.data.service.MethodService;

/**
 * @author DoctorGlobe MethodService CountryService
 */

@Service("methodService")
public class MethodServiceImpl extends GenericServiceImpl<Method>
		implements MethodService {

	@Autowired
	public MethodServiceImpl(MethodDAO genericDAO) {
		super(genericDAO);
	}

}
