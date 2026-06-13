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

import com.dg.data.model.db.DailyExpense;
import com.dg.data.service.CountryService;
import com.dg.data.service.CurrencyService;
import com.dg.data.service.DailyExpenseService;

/**
 * Handles all crud operations for DailyExpense table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/daily-expense")
public class DailyExpenseController extends AbstractController<DailyExpense> {

	private static final Logger logger = LoggerFactory
			.getLogger(DailyExpenseController.class);

	@Autowired
	public DailyExpenseService dailyExpenseService;

	@Autowired
	public CountryService countryService;

	@Autowired
	public CurrencyService currencyService;

	@Autowired
	public DailyExpenseController(DailyExpenseService dailyExpenseService) {
		super.setGenericService(dailyExpenseService);
	}

	/**
	 * 
	 * handle daily-expense edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			DailyExpense dailyExpense, Model model) {
		if (id != null) {
			model.addAttribute("dailyExpense", dailyExpenseService.get(id));
		}
		model.addAttribute("currencyList", currencyService.getAllCurrency());
		model.addAttribute("countryList", countryService.getAll());

		return "daily-expense/edit";
	}

	/**
	 * 
	 * handle daily-expense edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid DailyExpense dailyExpense,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save country daily expense",
					bindingResult.getErrorCount());
			model.addAttribute("countryList", countryService.getAll());
			model.addAttribute("currencyList",
					currencyService.getAllCurrency());
			return "daily-expense/edit";
		}
		dailyExpenseService.edit(dailyExpense);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/daily-expense/index";
	}

}