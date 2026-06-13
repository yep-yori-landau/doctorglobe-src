
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientcasemessagesDAO;
import com.dg.data.model.db.Patientcasemessages;
import com.dg.data.service.PatientcasemessagesService;

/**
 * @author DoctorGlobe PatientcasemessagesService CountryService
 */

@Service("patientcasemessagesService")
public class PatientcasemessagesServiceImpl
		extends GenericServiceImpl<Patientcasemessages>
		implements PatientcasemessagesService {

	private PatientcasemessagesDAO patientcasemessagesDAO;

	@Autowired
	public PatientcasemessagesServiceImpl(PatientcasemessagesDAO genericDAO) {
		super(genericDAO);
		this.patientcasemessagesDAO = (PatientcasemessagesDAO) genericDAO;
	}

	/**
	 * edit Status
	 * @param patientcase
	 * @param status
	 * @return
	 */
	@Override
	public Integer editStatus(Integer patientcase, Integer receiver,
			String receiver_type) {
		return this.patientcasemessagesDAO.editStatus(patientcase, receiver,
				receiver_type);
	}

	/**
	 * find Total Messages By Receiver
	 * @param reciever
	 * @return total new messages
	 */
	@Override
	public Integer findTotalMessagesByReceiver(Integer receiver,
			String receiver_type) {
		return this.patientcasemessagesDAO
				.findTotalNewMessageByReceiver(receiver, receiver_type);
	}

	/**
	 * find Total Messages By Sender
	 * @param sender
	 * @param sender_type
	 * @param receiver
	 * @param receiver_type
	 * @param patientcase
	 * @return
	 */
	@Override
	public Integer findTotalMessagesBySender(int sender, String sender_type,
			int receiver, String receiver_type, int patientcase) {
		return this.patientcasemessagesDAO.findTotalSendMessageBySender(sender,
				sender_type, receiver, receiver_type, patientcase);
	}

}