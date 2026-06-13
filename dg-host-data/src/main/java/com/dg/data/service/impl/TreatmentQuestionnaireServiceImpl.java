
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.TreatmentQuestionnaireDAO;
import com.dg.data.model.db.TreatmentQuestionnaire;
import com.dg.data.model.domain.TreatmentQuestionnaireModel;
import com.dg.data.service.TreatmentQuestionnaireService;

/**
 * @author DoctorGlobe TreatmentQuestionnaireService CountryService
 */

@Service("treatmentQuestionnaireService")
public class TreatmentQuestionnaireServiceImpl
		extends GenericServiceImpl<TreatmentQuestionnaire>
		implements TreatmentQuestionnaireService {

	private TreatmentQuestionnaireDAO treatmentQuestionnaireDAO;

	@Autowired
	public TreatmentQuestionnaireServiceImpl(
			TreatmentQuestionnaireDAO genericDAO) {
		super(genericDAO);
		this.treatmentQuestionnaireDAO = (TreatmentQuestionnaireDAO) genericDAO;
	}

	/**
	 * find By Treatment
	 * @param treatment
	 * @return the lis of TreatmentQuestionnaireModel
	 */
	@Override
	public List<TreatmentQuestionnaireModel> findByTreatment(
			BigInteger treatment) {
		return this.treatmentQuestionnaireDAO.findByTreatment(treatment);
	}
}
