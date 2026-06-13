
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Method;
import com.dg.data.service.MethodService;

/**
 * @author doctorGlobe Handles all interactions with the Method table.
 */
@Controller
@RequestMapping(value = "/rest/method")
public class MethodRestController extends AbstractRestController<Method> {
	@Autowired
	public MethodRestController(MethodService methodService) {
		super.setGenericService(methodService);
	}
}