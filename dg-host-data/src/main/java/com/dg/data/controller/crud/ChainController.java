package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Chain;
import com.dg.data.service.ChainService;

/**
 * Handles all crud operations for Chain table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/chain")
public class ChainController extends AbstractController<Chain> {
	@Autowired
	public ChainController(ChainService chainService) {
		super.setGenericService(chainService);
	}
}