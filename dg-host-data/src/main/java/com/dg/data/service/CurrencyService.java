package com.dg.data.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service("currencyService")
public class CurrencyService {

	/**
	 * get all the currencies
	 * 
	 * @return list of currency
	 */
	public List<String> getAllCurrency() {
		ArrayList<String> currencys = new ArrayList<String>();
		Locale[] locs = Locale.getAvailableLocales();

		for (Locale loc : locs) {
			try {
				String val = Currency.getInstance(loc).getCurrencyCode();
				if (!currencys.contains(val))
					currencys.add(val);
			}
			catch (Exception exc) {
				// logger.info("locale not found");
			}
			Collections.sort(currencys);
		}
		return currencys;
	}
}