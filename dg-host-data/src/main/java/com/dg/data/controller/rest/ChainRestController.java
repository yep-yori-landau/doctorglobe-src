
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Chain;
import com.dg.data.service.ChainService;

/**
 * @author DoctorGlobe Handles all interactions with the Chain table.
 */
@Controller
@RequestMapping(value = "/rest/chain")
public class ChainRestController extends AbstractRestController<Chain> {
	@Autowired
	public ChainRestController(ChainService chainService) {
		super.setGenericService(chainService);
	}
}