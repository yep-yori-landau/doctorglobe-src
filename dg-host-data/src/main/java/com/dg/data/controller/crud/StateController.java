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

import com.dg.data.model.db.State;
import com.dg.data.service.StateService;
import com.dg.data.service.CountryService;

/**
 * Handles all crud operations for State table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/state")
public class StateController extends AbstractCrudController<State> {

	private static final Logger logger = LoggerFactory
			.getLogger(StateController.class);

	@Autowired
	public StateService stateService;

	@Autowired
	public CountryService countryService;

	@Autowired
	public StateController(StateService stateService) {
		super.setGenericService(stateService);
	}

	/**
	 * 
	 * handle state edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			State state, Model model) {
		if (id != null) {
			model.addAttribute("state", stateService.get(id));
		}
		model.addAttribute("countryList", countryService.getAll());
		return "state/edit";
	}

	/**
	 * 
	 * handle state edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid State state, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save state",
					bindingResult.getErrorCount());
			model.addAttribute("countryList", countryService.getAll());
			return "state/edit";
		}
		stateService.edit(state);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/state/index";
	}

}