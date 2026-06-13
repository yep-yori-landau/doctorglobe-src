/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.dao.AttestationsPractitionerDAO;
import com.dg.data.model.db.AttestationsPractitioner;
import com.dg.data.model.db.mapper.AttestationsPractitionerMapper;

/**
 * This class represent Implementation of AttestationsPractitioner which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class AttestationsPractitionerDAOImpl
		extends GenericDAOImpl<AttestationsPractitioner>
		implements AttestationsPractitionerDAO {
	@Override
	public List<AttestationsPractitioner> findByPractitioner(
			BigInteger practitioner) {
		List<AttestationsPractitioner> attestationspractitionerList = null;
		try {
			String query = "SELECT *FROM attestations_practitioner where practitioner = ?";
			attestationspractitionerList = this.getJdbcTemplate().query(query,
					new Object[] { practitioner },
					new AttestationsPractitionerMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return attestationspractitionerList;
	}
}
