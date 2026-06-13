
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.DailyExpenseDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.DailyExpense;
import com.dg.data.service.DailyExpenseService;

/**
 * @author DoctorGlobe DailyExpenseService CountryService
 */

@Service("dailyExpenseService")
public class DailyExpenseServiceImpl extends GenericServiceImpl<DailyExpense>
		implements DailyExpenseService {

	@Autowired
	public DailyExpenseServiceImpl(DailyExpenseDAO genericDAO) {
		super(genericDAO);
	}
}
