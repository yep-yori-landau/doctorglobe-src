package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.TreatmentQuestionnaire;
import com.dg.data.model.domain.TreatmentQuestionnaireModel;

/**
 * This is a TreatmentQuestionnaire DAO interface which includes the most
 * fundamental DAO operations (findByTreatment, etc) for TreatmentQuestionnaire
 * object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */
public interface TreatmentQuestionnaireDAO
		extends GenericDAO<TreatmentQuestionnaire> {

	/**
	 * Find the list of TreatmentQuestionnaireModel object based on treatment id
	 * @param treatment the unique id of treatment
	 * @return the list of TreatmentQuestionnaireModel object or null if it
	 * cannot be found
	 */
	List<TreatmentQuestionnaireModel> findByTreatment(BigInteger treatment);

}