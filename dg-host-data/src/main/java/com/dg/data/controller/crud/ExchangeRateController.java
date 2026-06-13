package com.dg.data.controller.crud;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.data.model.db.ExchangeRate;
import com.dg.data.service.CurrencyService;
import com.dg.data.service.ExchangeRateService;

/**
 * Handles all crud operations for ExchangeRate table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/exchange-rate")
public class ExchangeRateController extends AbstractController<ExchangeRate> {
	private static final Logger logger = LoggerFactory
			.getLogger(ExchangeRateController.class);

	@Autowired
	ExchangeRateService exchangerateService;

	@Autowired
	public ExchangeRateController(ExchangeRateService exchangerateService) {
		super.setGenericService(exchangerateService);
	}

	@Autowired
	CurrencyService currencyService;

	/**
	 * 
	 * handle exchange-rate edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			ExchangeRate exchangeRate, Model model) {
		if (id != null) {
			model.addAttribute("exchangeRate", exchangerateService.get(id));
		}
		model.addAttribute("currencyList", currencyService.getAllCurrency());
		return "exchange-rate/edit";
	}

	/**
	 * 
	 * handle exchange-rate edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid ExchangeRate exchangerate,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save exchange-rate",
					bindingResult.getErrorCount());
			model.addAttribute("currencyList",
					currencyService.getAllCurrency());
			return "exchange-rate/edit";
		}
		exchangerateService.edit(exchangerate);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/exchange-rate/index";
	}
}