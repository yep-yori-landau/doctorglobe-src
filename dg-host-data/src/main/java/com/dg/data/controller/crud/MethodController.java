package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Method;
import com.dg.data.service.MethodService;

/**
 * Handles all crud operations for Method table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/method")
public class MethodController extends AbstractController<Method> {
	@Autowired
	public MethodController(MethodService methodService) {
		super.setGenericService(methodService);
	}

}