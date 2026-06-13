package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.TreatmentQuestionnaireDAO;
import com.dg.data.model.db.TreatmentQuestionnaire;
import com.dg.data.model.domain.TreatmentQuestionnaireModel;
import com.dg.data.model.domain.mapper.TreatmentQuestionnaireModelMapper;

public class TreatmentQuestionnaireDAOImpl
		extends GenericDAOImpl<TreatmentQuestionnaire>
		implements TreatmentQuestionnaireDAO {

	@Override
	public List<TreatmentQuestionnaireModel> findByTreatment(
			BigInteger treatment) {
		List<TreatmentQuestionnaireModel> treatmentQuestionnaireModel = null;
		String query = "Select tq.*,q.name,q.type,q.value from treatment_questionnaire tq left join questionnaire q on tq.questionnaire = q.id where tq.treatment = ?";
		treatmentQuestionnaireModel = this.getJdbcTemplate().query(query,
				new Object[] { treatment },
				new TreatmentQuestionnaireModelMapper());
		return treatmentQuestionnaireModel;
	}

}