package com.dg.data.dao.impl;

import java.math.BigInteger;

import com.dg.data.dao.TreatmentPriceDAO;
import com.dg.data.model.db.TreatmentPrice;
import com.dg.data.model.db.mapper.TreatmentPriceMapper;

public class TreatmentPriceDAOImpl extends GenericDAOImpl<TreatmentPrice>
		implements TreatmentPriceDAO {
	@Override
	public TreatmentPrice findByTreatmentCity(BigInteger treatment,
			BigInteger city) {
		TreatmentPrice treatmentPrice = new TreatmentPrice();
		try {
			String query = "SELECT * FROM treatment_price WHERE treatment = ? and city = ?";
			treatmentPrice = this.getJdbcTemplate().queryForObject(query,
					new Object[] { treatment, city },
					new TreatmentPriceMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return treatmentPrice;
	}

}