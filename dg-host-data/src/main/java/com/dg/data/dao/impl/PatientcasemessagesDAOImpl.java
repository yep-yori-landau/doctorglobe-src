/**
 * 
 */
package com.dg.data.dao.impl;

import com.dg.data.dao.PatientcasemessagesDAO;
import com.dg.data.model.db.Patientcasemessages;

/**
 * This class represent Implementation of PatientcasemessagesDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class PatientcasemessagesDAOImpl extends
		GenericDAOImpl<Patientcasemessages>implements PatientcasemessagesDAO {

	@Override
	public Integer editStatus(Integer patientcase, Integer receiver,
			String receiver_type) {
		Integer result = 0;
		if (patientcase != null && receiver != null) {
			try {
				String query = "UPDATE patientcasemessages set status = 'Read' WHERE (patient_case = ? and receiver = ? and receiver_type = ?) or (patient_case = ? and receiver = ? and sender = 0)";
				result = this.getJdbcTemplate().update(query,
						new Object[] { patientcase, receiver, receiver_type,
								patientcase, receiver });
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Integer findTotalNewMessageByReceiver(Integer receiver,
			String receiver_type) {
		Integer result = 0;
		if (receiver != null) {
			try {
				String query = "select count(*) from patientcasemessages WHERE receiver = ? and status = 'open' and (receiver_type = ? or sender_type='System')";
				result = this.getJdbcTemplate().queryForObject(query,
						new Object[] { receiver, receiver_type },
						Integer.class);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Integer findTotalSendMessageBySender(Integer sender,
			String sender_type, Integer receiver, String receiver_type,
			Integer patientcase) {
		Integer result = 0;
		if (receiver != null) {
			try {
				String query = "select count(*) from patientcasemessages WHERE (sender = ? and sender_type = ?) and (receiver = ? and receiver_type = ?) and patient_case = ?";
				result = this.getJdbcTemplate()
						.queryForObject(query,
								new Object[] { sender, sender_type, receiver,
										receiver_type, patientcase },
								Integer.class);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
