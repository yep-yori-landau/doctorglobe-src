
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Audit;
import com.dg.data.service.AuditService;

/**
 * @author DoctorGlobe Handles all interactions with the Audit table.
 */
@Controller
@RequestMapping(value = "/rest/audit")
public class AuditRestController extends AbstractRestController<Audit> {
	@Autowired
	public AuditRestController(AuditService auditService) {
		super.setGenericService(auditService);
	}

}