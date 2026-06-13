/**
 * 
 */
package com.dg.data.service;

import com.dg.data.model.db.Association;

/**
 * This is a AssociationService service interface which includes the most
 * fundamental service operations for AssociationService object It also extends
 * the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface AssociationService extends GenericService<Association> {
	/**
	 * find White lable Url
	 * @param url
	 * @return Association Model
	 */
	public Association findWhitelableUrl(String url);
}
