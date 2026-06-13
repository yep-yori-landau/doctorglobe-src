/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderEquipment;

/**
 * This is a HealthcareproviderEquipment DAO interface which includes the most
 * fundamental DAO operations (findByHealthcareprovider, etc) for any
 * HealthcareproviderEquipment object It also extends the generic DAO CRUD
 * methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderEquipmentDAO
		extends GenericDAO<HealthcareproviderEquipment> {

	/**
	 * Find the list of HealthcareproviderEquipment object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderEquipment object or null if it
	 * cannot be found
	 */
	public List<HealthcareproviderEquipment> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
