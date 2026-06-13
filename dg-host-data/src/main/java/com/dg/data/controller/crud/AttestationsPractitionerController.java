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

import com.dg.data.model.db.AttestationsPractitioner;
import com.dg.data.service.AttestationsPractitionerService;
import com.dg.data.service.AttestationsService;
import com.dg.data.service.PractitionerService;

/**
 * Handles all crud operations for AttestationsPractitioner table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/attestations-practitioner")
public class AttestationsPractitionerController
		extends AbstractController<AttestationsPractitioner> {

	private static final Logger logger = LoggerFactory
			.getLogger(AttestationsPractitionerController.class);

	@Autowired
	public AttestationsPractitionerService attestationspractitionerService;

	@Autowired
	public AttestationsService attestationsService;

	@Autowired
	public PractitionerService practitionerService;

	@Autowired
	public AttestationsPractitionerController(
			AttestationsPractitionerService attestationsPractitionerService) {
		super.setGenericService(attestationsPractitionerService);
	}

	/**
	 * 
	 * handle attestations-practitioner edit get request
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			AttestationsPractitioner attestationsPractitioner, Model model) {
		if (id != null) {
			model.addAttribute("attestationsPractitioner",
					attestationspractitionerService.get(id));
		}
		model.addAttribute("attestationsList", attestationsService.getAll());
		model.addAttribute("practitionerList", practitionerService.getAll());

		return "attestations-practitioner/edit";
	}

	/**
	 * 
	 * handle attestations-practitioner edit post request
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid AttestationsPractitioner attestationsPractitioner,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save attestations-practitioner",
					bindingResult.getErrorCount());
			model.addAttribute("attestationsList",
					attestationsService.getAll());
			model.addAttribute("practitionerList",
					practitionerService.getAll());
			return "attestations-practitioner/edit";
		}
		attestationspractitionerService.edit(attestationsPractitioner);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/attestations-practitioner/index";
	}

}