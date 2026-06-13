
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AttestationsPractitionerDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.AttestationsPractitioner;
import com.dg.data.service.AttestationsPractitionerService;

/**
 * @author DoctorGlobe AttestationsPractitioner Implementation
 */

@Service("attestationsPractitionerService")
public class AttestationsPractitionerServiceImpl
		extends GenericServiceImpl<AttestationsPractitioner>
		implements AttestationsPractitionerService {

	private AttestationsPractitionerDAO attestationsPractitionerDAO;

	@Autowired
	public AttestationsPractitionerServiceImpl(
			AttestationsPractitionerDAO genericDAO) {
		super(genericDAO);
		this.attestationsPractitionerDAO = (AttestationsPractitionerDAO) genericDAO;
	}

	/**
	 * find By Practitioner
	 * @param practitioner
	 * @return
	 */
	@Override
	public List<AttestationsPractitioner> findByPractitioner(
			BigInteger practitioner) {
		return this.attestationsPractitionerDAO
				.findByPractitioner(practitioner);
	}
}
