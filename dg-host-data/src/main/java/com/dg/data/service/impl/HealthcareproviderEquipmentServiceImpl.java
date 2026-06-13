
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderEquipmentDAO;
import com.dg.data.model.db.HealthcareproviderEquipment;
import com.dg.data.service.HealthcareproviderEquipmentService;

/**
 * @author DoctorGlobe HealthcareproviderEquipmentService CountryService
 */

@Service("healthcareproviderEquipmentService")
public class HealthcareproviderEquipmentServiceImpl
		extends GenericServiceImpl<HealthcareproviderEquipment>
		implements HealthcareproviderEquipmentService {

	private HealthcareproviderEquipmentDAO healthcareproviderEquipmentDAO;

	@Autowired
	public HealthcareproviderEquipmentServiceImpl(
			HealthcareproviderEquipmentDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderEquipmentDAO = (HealthcareproviderEquipmentDAO) genericDAO;
	}

	/**
	 * get list of health care provider Equipments by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	@Override
	public List<HealthcareproviderEquipment> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		return this.healthcareproviderEquipmentDAO
				.findByHealthcareprovider(healthcareprovider);
	}

}
