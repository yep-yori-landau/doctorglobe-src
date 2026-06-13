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
import com.dg.data.model.db.Associate;
import com.dg.data.service.AssociationService;
import com.dg.data.service.AssociateService;

/**
 * Handles all crud operations for Associate table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/associate")
public class AssociateController extends AbstractController<Associate> {

	private static final Logger logger = LoggerFactory
			.getLogger(AssociateController.class);

	@Autowired
	public AssociateService associateService;

	@Autowired
	public AssociationService associationService;

	@Autowired
	public AssociateController(AssociateService associateService) {
		super.setGenericService(associateService);
	}

	/**
	 * 
	 * handle associate edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Associate associate, Model model) {
		if (id != null) {
			model.addAttribute("associate", associateService.get(id));
		}
		model.addAttribute("associationList", associationService.getAll());
		return "associate/edit";
	}

	/**
	 * 
	 * handle associate edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Associate associate, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				logger.error("Got {} errors during save associate",
						bindingResult.getErrorCount());
				model.addAttribute("associationList",
						associationService.getAll());
				return "associate/edit";
			}
			if (associate.getId() != null) {
				Associate associateModel = associateService
						.get(associate.getId().intValue());
				if (!associateModel.getPassword()
						.equals(associate.getPassword())) {
					associate.setPassword(
							associateService.getSHA1(associate.getPassword()));
				}
				associateService.edit(associate);
			}
			else {
				associateService.edit(associate);
			}
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/associate/index";
	}
}