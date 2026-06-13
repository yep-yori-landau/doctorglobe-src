/**
 * 
 */
package com.dg.data.service;

import com.dg.data.model.db.Patientcasemessages;

/**
 * This is a PatientcasemessagesService service interface which includes the
 * most fundamental service operations for PatientcasemessagesService object It
 * also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PatientcasemessagesService
		extends GenericService<Patientcasemessages> {

	/**
	 * edit Status
	 * @param patientcase
	 * @param status
	 * @return
	 */
	public Integer editStatus(Integer patientcase, Integer receiver,
			String receiver_type);

	/**
	 * find Total Messages By Receiver
	 * @param reciever
	 * @return total new messages
	 */
	public Integer findTotalMessagesByReceiver(Integer receiver,
			String receiver_type);

	/**
	 * find Total Messages By Sender
	 * @param sender
	 * @param sender_type
	 * @param receiver
	 * @param receiver_type
	 * @param patientcase
	 * @return
	 */
	public Integer findTotalMessagesBySender(int sender, String sender_type,
			int receiver, String receiver_type, int patientcase);
}
