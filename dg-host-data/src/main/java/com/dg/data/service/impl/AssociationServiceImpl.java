
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AssociationDAO;
import com.dg.data.model.db.Association;
import com.dg.data.service.AssociationService;

/**
 * @author DoctorGlobe AssociationService Implementation
 */
@Service("associationService")
public class AssociationServiceImpl extends GenericServiceImpl<Association>
		implements AssociationService {

	/**
	 * associationDAO object
	 */
	private AssociationDAO associationDAO;

	/**
	 * Constructor.
	 * @param genericDAO (required) DAO object of the AssociationDAO set a
	 * AssociationDAO object in GenericServiceImpl class
	 */
	@Autowired
	public AssociationServiceImpl(AssociationDAO genericDAO) {
		super(genericDAO);
		this.associationDAO = (AssociationDAO) genericDAO;
	}

	/**
	 * 
	 */
	@Override
	public Association findWhitelableUrl(String url) {
		return this.associationDAO.findByWhitelableUrl(url);
	}

}
