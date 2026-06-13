/**
 * 
 */
package com.dg.data.service;

import com.dg.data.model.db.ExchangeRate;

/**
 * This is a ExchangeRateService service interface which includes the most
 * fundamental service operations for ExchangeRateService object It also extends
 * the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface ExchangeRateService extends GenericService<ExchangeRate> {

	/**
	 * get exchange rates for two currencies
	 * @param id
	 * @return exchangerate
	 */
	public ExchangeRate getByFromToCurrency(String from, String to);
}
