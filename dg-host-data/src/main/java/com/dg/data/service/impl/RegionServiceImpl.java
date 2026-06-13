
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.RegionDAO;
import com.dg.data.model.db.Region;
import com.dg.data.service.RegionService;

/**
 * @author DoctorGlobe RegionService CountryService
 */

@Service("regionService")
public class RegionServiceImpl extends GenericServiceImpl<Region>
		implements RegionService {

	@Autowired
	public RegionServiceImpl(RegionDAO genericDAO) {
		super(genericDAO);
	}

}
