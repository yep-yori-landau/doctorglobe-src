package com.dg.data.controller.crud;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.data.service.GenericService;

/**
 * Generic Controller handles all controller crud operations.
 * @author DoctorGlobe
 */

public abstract class AbstractCrudController<T> {

	private static final Logger logger = LoggerFactory
			.getLogger(AbstractController.class);

	private GenericService<T> genericService;

	private Class<T> clazz;

	private String view;

	@SuppressWarnings("unchecked")
	public AbstractCrudController() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public void setGenericService(GenericService<T> genericService) {
		this.genericService = genericService;
	}

	public GenericService<T> getGenericService() {
		return this.genericService;
	}

	public String getView() {
		if (view != null) {
			return view;
		}
		else {
			return this.splitCamelCase(clazz.getSimpleName()).toLowerCase();
		}
	}

	public void setView(String view) {
		this.view = this.splitCamelCase(clazz.getSimpleName()).toLowerCase();
		if (view != null) {
			this.view = view;
		}
	}

	public String getModel() {
		return clazz.getSimpleName().toLowerCase();
	}

	private String splitCamelCase(String s) {
		return s.replaceAll(
				String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])",
						"(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"),
				"-");
	}

	/**
	 * Generic index action handles all controller index get request.
	 * 
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("models", this.getGenericService().getAll());
		return this.getView() + "/index";
	}

	/**
	 * Generic delete action handles all controller delete get request.
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "id", required = false) Integer id,
			RedirectAttributes redirectAttributes) {
		this.getGenericService().delete(id);
		redirectAttributes.addFlashAttribute("message", "Successfully Deleted");
		return "redirect:/" + this.getView() + "/index";
	}
}