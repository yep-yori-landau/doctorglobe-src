
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.AmenityDAO;
import com.dg.data.model.db.Amenity;
import com.dg.data.service.AmenityService;

/**
 * @author DoctorGlobe AmenityService Implementation
 */
@Service("amenityService")
public class AmenityServiceImpl extends GenericServiceImpl<Amenity>
		implements AmenityService {

	/**
	 * @author DoctorGlobe Constructor.
	 * @param genericDAO (required) DAO object of the AmenityDAO set a
	 * AmenityDAO object in GenericServiceImpl class
	 */
	@Autowired
	public AmenityServiceImpl(AmenityDAO genericDAO) {
		super(genericDAO);
	}

}
