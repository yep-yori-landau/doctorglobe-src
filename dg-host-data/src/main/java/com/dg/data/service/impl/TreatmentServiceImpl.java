
package com.dg.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.TreatmentDAO;
import com.dg.data.model.db.Treatment;
import com.dg.data.model.domain.TreatmentSearchModel;
import com.dg.data.service.TreatmentService;

/**
 * @author DoctorGlobe TreatmentService CountryService
 */

@Service("treatmentService")
public class TreatmentServiceImpl extends GenericServiceImpl<Treatment>
		implements TreatmentService {

	private TreatmentDAO treatmentDAO;

	@Autowired
	public TreatmentServiceImpl(TreatmentDAO genericDAO) {
		super(genericDAO);
		this.treatmentDAO = (TreatmentDAO) genericDAO;
	}

	/**
	 * find By Name
	 * @param name
	 * @return the list of treatment
	 */
	@Override
	public List<Treatment> findByName(String name) {
		return this.treatmentDAO.findByName(name);
	}

	/**
	 * find By Treatment
	 * @param name
	 * @return the list TreatmentSearchModel
	 */
	@Override
	public List<TreatmentSearchModel> findByTreatment(String name) {
		return this.treatmentDAO.findByTreatmentName(name);
	}

}
