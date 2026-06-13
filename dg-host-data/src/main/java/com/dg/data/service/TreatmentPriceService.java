package com.dg.data.service;

/**
 * 
 */
import java.math.BigInteger;
import com.dg.data.model.db.TreatmentPrice;

/**
 * This is a TreatmentPriceService service interface which includes the most
 * fundamental service operations for TreatmentPriceService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface TreatmentPriceService extends GenericService<TreatmentPrice> {
	/**
	 * find By Treatment City
	 * @param treatment
	 * @param city
	 * @return
	 */
	public TreatmentPrice findByTreatmentCity(BigInteger treatment,
			BigInteger city);

}
