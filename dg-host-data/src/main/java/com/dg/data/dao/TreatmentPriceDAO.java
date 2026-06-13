package com.dg.data.dao;

import java.math.BigInteger;

import com.dg.data.model.db.TreatmentPrice;

/**
 * This is a TreatmentPrice DAO interface which includes the most fundamental
 * DAO operations (findByTreatmentCity, etc) for TreatmentPrice object It also
 * extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */
public interface TreatmentPriceDAO extends GenericDAO<TreatmentPrice> {

	/**
	 * Find TreatmentPrice object based on treatment id and city id
	 * @param treatment the unique id of treatment
	 * @param city the unique id of city
	 * @return the TreatmentPrice object
	 */
	TreatmentPrice findByTreatmentCity(BigInteger treatment, BigInteger city);

}