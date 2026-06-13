
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.ExchangeRate;
import com.dg.data.service.ExchangeRateService;

/**
 * @author DoctorGlobe Handles all interactions with the ExchangeRate table.
 */
@Controller
@RequestMapping(value = "/rest/exchange-rate")
public class ExchangeRateRestController
		extends AbstractRestController<ExchangeRate> {
	@Autowired
	public ExchangeRateRestController(ExchangeRateService exchangeRateService) {
		super.setGenericService(exchangeRateService);
	}
}