
package com.dg.data.service.impl;

import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.TreatmentPriceDAO;
import com.dg.data.model.db.TreatmentPrice;
import com.dg.data.service.TreatmentPriceService;

/**
 * @author DoctorGlobe TreatmentPriceService CountryService
 */

@Service("treatmentPriceService")
public class TreatmentPriceServiceImpl extends
		GenericServiceImpl<TreatmentPrice>implements TreatmentPriceService {

	private TreatmentPriceDAO treatmentPriceDAO;

	@Autowired
	public TreatmentPriceServiceImpl(TreatmentPriceDAO genericDAO) {
		super(genericDAO);
		this.treatmentPriceDAO = (TreatmentPriceDAO) genericDAO;
	}

	/**
	 * find Treatment Price By Treatment id and City id
	 * @param treatment
	 * @param city
	 * @return TreatmentPrice Model
	 */
	@Override
	public TreatmentPrice findByTreatmentCity(BigInteger treatment,
			BigInteger city) {
		return this.treatmentPriceDAO.findByTreatmentCity(treatment, city);
	}

}
