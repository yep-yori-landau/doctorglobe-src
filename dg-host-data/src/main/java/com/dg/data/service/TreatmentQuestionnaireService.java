/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.TreatmentQuestionnaire;
import com.dg.data.model.domain.TreatmentQuestionnaireModel;

/**
 * This is a TreatmentQuestionnaireService service interface which includes the
 * most fundamental service operations for TreatmentQuestionnaireService object
 * It also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface TreatmentQuestionnaireService
		extends GenericService<TreatmentQuestionnaire> {

	/**
	 * find By Treatment
	 * @param treatment
	 * @return
	 */
	public List<TreatmentQuestionnaireModel> findByTreatment(
			BigInteger treatment);

}
