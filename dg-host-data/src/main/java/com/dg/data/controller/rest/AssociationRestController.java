
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.Association;
import com.dg.data.service.AssociationService;

/**
 * @author DoctorGlobe Handles all interactions with the Association table.
 */
@Controller
@RequestMapping(value = "/rest/association")
public class AssociationRestController
		extends AbstractRestController<Association> {
	@Autowired
	AssociationService associationService;

	@Autowired
	public AssociationRestController(AssociationService associationService) {
		super.setGenericService(associationService);
	}

	// Find white lable Url by hostProto and hostUrl
	@RequestMapping(value = "/get/{hostProto}/{hostUrl:.+}/", method = RequestMethod.GET)
	public @ResponseBody Association get(
			@PathVariable("hostProto") String hostProto,
			@PathVariable("hostUrl") String hostUrl) {
		String url = hostProto + "://" + hostUrl;
		return associationService.findWhitelableUrl(url);
	}
}