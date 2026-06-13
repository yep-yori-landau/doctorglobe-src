
package com.dg.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.StateDAO;
import com.dg.data.model.db.State;
import com.dg.data.service.StateService;

/**
 * @author DoctorGlobe StateService CountryService
 */

@Service("stateService")
public class StateServiceImpl extends GenericServiceImpl<State>
		implements StateService {

	private StateDAO stateDAO;

	@Autowired
	public StateServiceImpl(StateDAO genericDAO) {
		super(genericDAO);
		this.stateDAO = (StateDAO) genericDAO;
	}

	/**
	 * find By Country
	 * @param country
	 * @return
	 */
	@Override
	public List<State> findByCountry(Integer country) {
		return this.stateDAO.findByCountry(country);
	}

}
