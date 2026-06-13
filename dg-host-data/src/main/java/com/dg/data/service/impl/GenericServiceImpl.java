package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;
import com.dg.data.dao.GenericDAO;
import com.dg.data.service.GenericService;

/**
 * Generic Service @author DoctorGlobe
 */
@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	private GenericDAO<T> genericDAO;

	/**
	 * Constructor
	 * @param genericDAO (required)
	 */
	public GenericServiceImpl(GenericDAO<T> genericDAO) {
		this.genericDAO = genericDAO;
	}

	/**
	 * @return genericDAO passed to the constructor
	 */
	public GenericDAO<T> getGenericDAO() {
		return this.genericDAO;
	}

	/**
	 * set genericDAO
	 * @param genericDAO
	 */
	public void setGenericDAO(GenericDAO<T> genericDAO) {
		this.genericDAO = genericDAO;
	}

	/**
	 * Fetches a list of model from the database generic get all function
	 * @return list of generic model
	 */
	public List<T> getAll() {
		return this.getGenericDAO().fetchAll();
	}

	/**
	 * Fetches a model from the database generic get function
	 * @return generic model
	 */
	public T get(Integer id) {
		return this.getGenericDAO().findById(id);
	}

	/**
	 * Deletes a generic model in the database
	 * @param int id
	 * @return boolean
	 */
	public Integer delete(Integer id) {
		return this.getGenericDAO().delete(id);
	}

	/**
	 * Insert a generic model in the database
	 * @param generic model
	 * @return int id
	 */
	public Integer edit(T t) {
		return this.getGenericDAO().insert(t);
	}

	/**
	 * Deletes a generic model in the database
	 * @param int id
	 * @return boolean
	 */
	public Integer delete(Integer id, BigInteger user, String user_type) {
		return this.getGenericDAO().delete(id, user, user_type);
	}

	/**
	 * Insert a generic model in the database
	 * @param generic model
	 * @param user id
	 * @param user_type
	 * @return int id
	 */
	public Integer edit(T t, BigInteger user, String user_type) {
		return this.getGenericDAO().insert(t, user, user_type);
	}

}