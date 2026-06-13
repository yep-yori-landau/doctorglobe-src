
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.Patientcasemessages;
import com.dg.data.service.PatientcasemessagesService;

/**
 * @author doctorGlobe Handles all interactions with the Patientcasemessages
 * table.
 */
@Controller
@RequestMapping(value = "/rest/patientcasemessages")
public class PatientcasemessagesRestController
		extends AbstractRestController<Patientcasemessages> {
	@Autowired
	public PatientcasemessagesRestController(
			PatientcasemessagesService patientcasemessagesService) {
		super.setGenericService(patientcasemessagesService);
	}

	@Autowired
	public PatientcasemessagesService patientcasemessagesService;

	// Provides interface to edit Status by patientcase,receiver,receiver_type
	@RequestMapping(value = "/edit/patientcase/{patientcase}/receiver/{receiver}/receiver_type/{receiver_type}", method = RequestMethod.GET)
	public @ResponseBody Integer get(
			@PathVariable("patientcase") int patientcase,
			@PathVariable("receiver") int receiver,
			@PathVariable("receiver_type") String receiver_type) {
		return patientcasemessagesService.editStatus(patientcase, receiver,
				receiver_type);
	}

	// Provides interface to get TotalMessages by receiver,receiver_type
	@RequestMapping(value = "/get/receiver/{receiver}/receiver_type/{receiver_type}", method = RequestMethod.GET)
	public @ResponseBody Integer getTotalMessages(
			@PathVariable("receiver") int receiver,
			@PathVariable("receiver_type") String receiver_type) {
		return patientcasemessagesService.findTotalMessagesByReceiver(receiver,
				receiver_type);
	}

	// Provides interface to get TotalMessages by
	// sender,sender_type,receiver,receiver_type,patientcase
	@RequestMapping(value = "/get/sender/{sender}/sender_type/{sender_type}/receiver/{receiver}/receiver_type/{receiver_type}/patientcase/{patientcase}", method = RequestMethod.GET)
	public @ResponseBody Integer getTotalMessagesBySender(
			@PathVariable("sender") int sender,
			@PathVariable("sender_type") String sender_type,
			@PathVariable("receiver") int receiver,
			@PathVariable("receiver_type") String receiver_type,
			@PathVariable("patientcase") int patientcase) {
		return patientcasemessagesService.findTotalMessagesBySender(sender,
				sender_type, receiver, receiver_type, patientcase);
	}
}