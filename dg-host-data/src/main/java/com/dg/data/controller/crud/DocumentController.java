package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Document;
import com.dg.data.service.DocumentService;

/**
 * Handles all crud operations for Document table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/document")
public class DocumentController extends AbstractController<Document> {
	@Autowired
	public DocumentController(DocumentService documentService) {
		super.setGenericService(documentService);
	}
}