
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HistoryDAO;
import com.dg.data.model.db.History;
import com.dg.data.service.HistoryService;

/**
 * @author DoctorGlobe HistoryService CountryService
 */

@Service("historyService")
public class HistoryServiceImpl extends GenericServiceImpl<History>
		implements HistoryService {

	@Autowired
	public HistoryServiceImpl(HistoryDAO genericDAO) {
		super(genericDAO);
	}

}
