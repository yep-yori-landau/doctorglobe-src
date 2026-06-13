
package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.History;
import com.dg.data.service.HistoryService;

/**
 * Handles all crud operations for History table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/history")
public class HistoryController extends AbstractController<History> {
	@Autowired
	public HistoryController(HistoryService historyService) {
		super.setGenericService(historyService);
	}

}