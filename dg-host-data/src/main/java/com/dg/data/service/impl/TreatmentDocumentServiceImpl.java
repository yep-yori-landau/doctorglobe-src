
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.TreatmentDocumentDAO;
import com.dg.data.model.db.TreatmentDocument;
import com.dg.data.model.domain.TreatmentDocumentModel;
import com.dg.data.service.TreatmentDocumentService;

/**
 * @author DoctorGlobe TreatmentDocumentService CountryService
 */

@Service("treatmentDocumentService")
public class TreatmentDocumentServiceImpl
		extends GenericServiceImpl<TreatmentDocument>
		implements TreatmentDocumentService {

	private TreatmentDocumentDAO treatmentDocumentDAO;

	@Autowired
	public TreatmentDocumentServiceImpl(TreatmentDocumentDAO genericDAO) {
		super(genericDAO);
		this.treatmentDocumentDAO = (TreatmentDocumentDAO) genericDAO;
	}

	/**
	 * find By Treatment
	 * @param treatment
	 * @return
	 */
	@Override
	public List<TreatmentDocumentModel> findByTreatment(BigInteger treatment) {
		return this.treatmentDocumentDAO.findByTreatment(treatment);
	}

}
