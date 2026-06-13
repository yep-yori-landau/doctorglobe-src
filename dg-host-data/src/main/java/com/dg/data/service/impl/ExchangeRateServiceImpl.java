
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.ExchangeRateDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.ExchangeRate;
import com.dg.data.service.ExchangeRateService;

/**
 * @author DoctorGlobe ExchangeRateService CountryService
 */

@Service("exchangeRateService")
public class ExchangeRateServiceImpl extends GenericServiceImpl<ExchangeRate>
		implements ExchangeRateService {

	private ExchangeRateDAO exchangeRateDAO;

	@Autowired
	public ExchangeRateServiceImpl(ExchangeRateDAO genericDAO) {
		super(genericDAO);
		this.exchangeRateDAO = (ExchangeRateDAO) genericDAO;
	}

	/**
	 * get exchange rates for two currencies
	 * @param id
	 * @return exchangerate
	 */
	@Override
	public ExchangeRate getByFromToCurrency(String from, String to) {
		return this.exchangeRateDAO.findByFromToCurrency(from, to);
	}

}
