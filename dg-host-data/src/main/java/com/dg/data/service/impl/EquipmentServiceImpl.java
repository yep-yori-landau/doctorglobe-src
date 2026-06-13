
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.EquipmentDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.Equipment;
import com.dg.data.service.EquipmentService;

/**
 * @author DoctorGlobe EquipmentService CountryService
 */

@Service("equipmentService")
public class EquipmentServiceImpl extends GenericServiceImpl<Equipment>
		implements EquipmentService {

	@Autowired
	public EquipmentServiceImpl(EquipmentDAO genericDAO) {
		super(genericDAO);
	}
}
