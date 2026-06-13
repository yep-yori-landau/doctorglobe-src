
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Document;
import com.dg.data.service.DocumentService;

/**
 * @author DoctorGlobe Handles all interactions with the Document table.
 */
@Controller
@RequestMapping(value = "/rest/document")
public class DocumentRestController extends AbstractRestController<Document> {
	@Autowired
	public DocumentRestController(DocumentService documentService) {
		super.setGenericService(documentService);
	}
}