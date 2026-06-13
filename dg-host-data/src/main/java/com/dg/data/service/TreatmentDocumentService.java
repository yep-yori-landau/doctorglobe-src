/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.TreatmentDocument;
import com.dg.data.model.domain.TreatmentDocumentModel;

/**
 * This is a TreatmentDocumentService service interface which includes the most
 * fundamental service operations for TreatmentDocumentService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface TreatmentDocumentService
		extends GenericService<TreatmentDocument> {
	/**
	 * find By Treatment
	 * @param treatment
	 * @return
	 */
	public List<TreatmentDocumentModel> findByTreatment(BigInteger treatment);

}
