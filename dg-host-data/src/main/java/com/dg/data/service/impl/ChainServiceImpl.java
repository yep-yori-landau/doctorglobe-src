
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.ChainDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.Chain;
import com.dg.data.service.ChainService;

/**
 * @author DoctorGlobe ChainService Implementation
 */

@Service("chainService")
public class ChainServiceImpl extends GenericServiceImpl<Chain>
		implements ChainService {

	@Autowired
	public ChainServiceImpl(ChainDAO genericDAO) {
		super(genericDAO);
	}

}