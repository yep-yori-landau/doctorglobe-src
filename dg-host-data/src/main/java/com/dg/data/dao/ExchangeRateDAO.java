/**
 * 
 */
package com.dg.data.dao;

import com.dg.data.model.db.ExchangeRate;

/**
 * This is a ExchangeRate DAO interface which includes the most fundamental DAO
 * operations (findByFromToCurrency, etc) for any ExchangeRate object It also
 * extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface ExchangeRateDAO extends GenericDAO<ExchangeRate> {

	/**
	 * Find the ExchangeRate detail based on from and to currency
	 * @param from the currenty code
	 * @param to the currenty code
	 * @return ExchangeRate object
	 */
	public ExchangeRate findByFromToCurrency(String from, String to);
}
