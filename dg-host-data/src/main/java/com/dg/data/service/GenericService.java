package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;

/**
 * This is a generic service interface which includes the most fundamental
 * service operations CRUD (create, read, update, delete) for any persistent
 * object
 * 
 * @author DoctorGlobe
 */
public interface GenericService<T> {

	/**
	 * Find an list of objects
	 * @return the list of object or null if it cannot be found
	 */
	public List<T> getAll();

	/**
	 * Find an object based on an id and return object of it
	 * @param id the unique id of the object
	 * @return the object or null if it cannot be found
	 */
	public T get(Integer id);

	/**
	 * Delete records based on object based id
	 * @param int id
	 * @return boolean
	 */
	public Integer delete(Integer id);

	/**
	 * Delete records based on object based id Also store user data who perform
	 * delete action
	 * @param id the unique id of the object
	 * @param user the unique id of the user object
	 * @param user_type the type of the user
	 * @return Integer
	 */
	public Integer delete(Integer id, BigInteger user, String user_type);

	/**
	 * Add/Edit object based records on database
	 * @param t (required) persistent object
	 * @return Integer
	 */
	public Integer edit(T t);

	/**
	 * Add/Edit object based records on database Also store user data who
	 * perform this action
	 * @param t (required) persistent object
	 * @param user
	 * @param user_type
	 * @return Integer
	 */
	public Integer edit(T t, BigInteger user, String user_type);

}