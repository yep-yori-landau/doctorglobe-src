
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.StatsDAO;
import com.dg.data.model.db.Stats;
import com.dg.data.service.StatsService;

/**
 * @author DoctorGlobe StatsService CountryService
 */

@Service("statsService")
public class StatsServiceImpl extends GenericServiceImpl<Stats>
		implements StatsService {

	@Autowired
	public StatsServiceImpl(StatsDAO genericDAO) {
		super(genericDAO);
	}
}
