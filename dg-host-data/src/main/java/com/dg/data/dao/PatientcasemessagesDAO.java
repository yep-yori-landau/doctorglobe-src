/**
 * 
 */
package com.dg.data.dao;

import com.dg.data.model.db.Patientcasemessages;

/**
 * This is a Patientcasemessages DAO interface which includes the most
 * fundamental DAO operations (findTotalNewMessageByReceiver, etc) for
 * Patientcasemessages object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PatientcasemessagesDAO
		extends GenericDAO<Patientcasemessages> {

	/**
	 * Change the status of patient case messages
	 * @param patientcase the unique id of patientcase
	 * @param reciever the unique receiver id
	 * @param reciever_type the unique receiver type
	 * @return Integer 1 or 0 if status cannot be updated
	 */
	public Integer editStatus(Integer patientcase, Integer receiver,
			String receiver_type);

	/**
	 * Find the count of total number of messages received by receiver
	 * @param reciever the unique receiver id
	 * @param reciever_type the unique receiver type
	 * @return Integer the total number of messages received by receiver
	 */
	public Integer findTotalNewMessageByReceiver(Integer receiver,
			String receiver_type);

	/**
	 * Find the count of the total number of messages send by sender
	 * @param sender the unique sender id
	 * @param sender_type the unique sender type
	 * @param receiver the unique receiver id
	 * @param receiver_type the unique receiver type
	 * @return Integer the total number of messages send by sender
	 */
	public Integer findTotalSendMessageBySender(Integer sender,
			String sender_type, Integer receiver, String receiver_type,
			Integer patientcase);
}
