
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PractitionertypeDAO;
import com.dg.data.model.db.Practitionertype;
import com.dg.data.service.PractitionertypeService;

/**
 * @author DoctorGlobe PractitionertypeService CountryService
 */

@Service("practitionertypeService")
public class PractitionertypeServiceImpl extends
		GenericServiceImpl<Practitionertype>implements PractitionertypeService {

	@Autowired
	public PractitionertypeServiceImpl(PractitionertypeDAO genericDAO) {
		super(genericDAO);
	}
}