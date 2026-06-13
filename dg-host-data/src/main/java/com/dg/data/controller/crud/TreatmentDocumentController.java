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

import com.dg.data.model.db.TreatmentDocument;
import com.dg.data.service.TreatmentDocumentService;
import com.dg.data.service.TreatmentService;
import com.dg.data.service.DocumentService;

/**
 * Handles all crud operations for TreatmentDocument table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/treatment-document")
public class TreatmentDocumentController
		extends AbstractCrudController<TreatmentDocument> {

	private static final Logger logger = LoggerFactory
			.getLogger(TreatmentDocumentController.class);

	@Autowired
	public TreatmentDocumentService treatmentDocumentService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public DocumentService documentService;

	@Autowired
	public TreatmentDocumentController(
			TreatmentDocumentService treatmentDocumentService) {
		super.setGenericService(treatmentDocumentService);
	}

	/**
	 * 
	 * handle TreatmentDocument edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			TreatmentDocument treatmentDocument, Model model) {
		if (id != null) {
			model.addAttribute("treatmentDocument",
					treatmentDocumentService.get(id));
		}
		model.addAttribute("treatmentList", treatmentService.getAll());
		model.addAttribute("documentList", documentService.getAll());

		return "treatment-document/edit";
	}

	/**
	 * 
	 * handle TreatmentDocument edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid TreatmentDocument treatmentDocument,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save treatment-document",
					bindingResult.getErrorCount());
			model.addAttribute("treatmentList", treatmentService.getAll());
			model.addAttribute("documentList", documentService.getAll());
			return "treatment-document/edit";
		}
		treatmentDocumentService.edit(treatmentDocument);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/treatment-document/index";
	}

}