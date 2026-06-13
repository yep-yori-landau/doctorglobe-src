
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.DocumentDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.Document;
import com.dg.data.service.DocumentService;

/**
 * @author DoctorGlobe DocumentService CountryService
 */

@Service("documentService")
public class DocumentServiceImpl extends GenericServiceImpl<Document>
		implements DocumentService {

	@Autowired
	public DocumentServiceImpl(DocumentDAO genericDAO) {
		super(genericDAO);
	}
}
