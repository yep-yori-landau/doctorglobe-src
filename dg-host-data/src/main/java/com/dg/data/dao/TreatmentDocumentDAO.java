package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.TreatmentDocument;
import com.dg.data.model.domain.TreatmentDocumentModel;

/**
 * This is a SpecialtyTreatment DAO interface which includes the most
 * fundamental DAO operations (findByTreatment, etc) for SpecialtyTreatment
 * object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */
public interface TreatmentDocumentDAO extends GenericDAO<TreatmentDocument> {

	/**
	 * Find the list of TreatmentDocumentModel object based on country id
	 * @param treatment the unique id of treatment
	 * @return the list of TreatmentDocumentModel object or null if it cannot be
	 * found
	 */
	List<TreatmentDocumentModel> findByTreatment(BigInteger treatment);

}