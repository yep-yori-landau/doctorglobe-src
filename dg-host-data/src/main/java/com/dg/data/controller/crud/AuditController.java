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

import com.dg.data.model.db.Audit;
import com.dg.data.service.AuditService;
import com.dg.data.service.UserService;

/**
 * Handles all crud operations for Audit table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/audit")
public class AuditController extends AbstractController<Audit> {

	private static final Logger logger = LoggerFactory
			.getLogger(AuditController.class);

	@Autowired
	public AuditService auditService;

	@Autowired
	public UserService userService;

	@Autowired
	public AuditController(AuditService auditService) {
		super.setGenericService(auditService);
	}

	/**
	 * 
	 * handle audit edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Audit audit, Model model) {
		if (id != null) {
			model.addAttribute("audit", auditService.get(id));
		}
		model.addAttribute("userList", userService.getAll());

		return "audit/edit";
	}

	/**
	 * 
	 * handle audit edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Audit audit, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save audit",
					bindingResult.getErrorCount());
			model.addAttribute("userList", userService.getAll());
			return "audit/edit";
		}
		auditService.edit(audit);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/audit/index";
	}
}