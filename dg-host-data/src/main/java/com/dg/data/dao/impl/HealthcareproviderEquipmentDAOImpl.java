/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderEquipmentDAO;
import com.dg.data.model.db.HealthcareproviderEquipment;
import com.dg.data.model.db.mapper.HealthcareproviderEquipmentMapper;

/**
 * This class represent Implementation of HealthcareproviderEquipmentDAO which
 * can be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderEquipmentDAOImpl
		extends GenericDAOImpl<HealthcareproviderEquipment>
		implements HealthcareproviderEquipmentDAO {

	@Override
	public List<HealthcareproviderEquipment> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderEquipment> healthcareproviderequipmentList = null;
		if (healthcareprovider != null) {
			try {
				String query = "SELECT *FROM healthcareprovider_equipment WHERE healthcareprovider = ?";
				healthcareproviderequipmentList = this.getJdbcTemplate().query(
						query, new Object[] { healthcareprovider },
						new HealthcareproviderEquipmentMapper());
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return healthcareproviderequipmentList;
	}
}
