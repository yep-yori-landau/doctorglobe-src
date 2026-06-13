
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.dg.data.service.GenericService;

/**
 * 
 * @author DoctorGlobe
 *
 * @param <T>
 */
public abstract class AbstractRestController<T> {

	private GenericService<T> genericService;

	public void setGenericService(GenericService<T> genericService) {
		this.genericService = genericService;
	}

	public GenericService<T> getGenericService() {
		return this.genericService;
	}

	// 'Provides interface to updated the status of a specific Abstract'
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<T> getAll() {
		return this.getGenericService().getAll();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody T get(@PathVariable("id") int id) {
		return this.getGenericService().get(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Integer delete(@PathVariable("id") int id) {
		return this.getGenericService().delete(id);
	}

	@RequestMapping(value = "/delete/id/{id}/user/{user}/type/{type}", method = RequestMethod.GET)
	public @ResponseBody Integer delete(@PathVariable("id") int id,
			@PathVariable("user") BigInteger user,
			@PathVariable("type") String type) {
		return this.getGenericService().delete(id, user, type);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Integer create(@RequestBody T t) {
		return this.getGenericService().edit(t);
	}

	@RequestMapping(value = "/create/user/{user}/type/{type}", method = RequestMethod.POST)
	public @ResponseBody Integer create(@PathVariable("user") BigInteger user,
			@PathVariable("type") String type, @RequestBody T t) {
		return this.getGenericService().edit(t, user, type);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception e) {
		return e.getMessage();
	}

}
