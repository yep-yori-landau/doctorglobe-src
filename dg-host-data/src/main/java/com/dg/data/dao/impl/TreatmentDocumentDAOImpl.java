package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.dao.TreatmentDocumentDAO;
import com.dg.data.model.db.TreatmentDocument;
import com.dg.data.model.domain.TreatmentDocumentModel;
import com.dg.data.model.domain.mapper.TreatmentDocumentModelMapper;

public class TreatmentDocumentDAOImpl extends GenericDAOImpl<TreatmentDocument>
		implements TreatmentDocumentDAO {

	@Override
	public List<TreatmentDocumentModel> findByTreatment(BigInteger treatment) {
		List<TreatmentDocumentModel> treatmentDocumentModel = null;
		String query = "Select td.*,d.name from treatment_document td left join document d on td.document = d.id where td.treatment = ?";
		treatmentDocumentModel = this.getJdbcTemplate().query(query,
				new Object[] { treatment }, new TreatmentDocumentModelMapper());
		return treatmentDocumentModel;
	}

}