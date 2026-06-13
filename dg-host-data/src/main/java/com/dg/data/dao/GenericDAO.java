package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

/**
 * This is a generic DAO interface which includes the most fundamental DAO
 * operations CRUD (create, read, update, delete) for any persistent object This
 * will meet very simple DAO needs and only includes operations which can be
 * expected to run efficiently.
 * 
 * @author DoctorGlobe
 */
public interface GenericDAO<T> {

	/**
	 * Add/Edit object based records on database Also store user data who can
	 * add or edit the records in database
	 * @param t (required) persistent object
	 * @param user
	 * @param user_type
	 * @return Integer
	 */
	public Integer insert(T t, BigInteger user, String user_type);

	/**
	 * Add/Edit object based records on database
	 * @param t (required) persistent object
	 * @return Integer
	 */
	public Integer insert(T t);

	/**
	 * Find an object based on an id and return object of it
	 * @param id the unique id of the object
	 * @return the object or null if it cannot be found
	 */
	public T findById(Integer id);

	/**
	 * Find an list of objects
	 * @return the list of object or null if it cannot be found
	 */
	public List<T> fetchAll();

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
	 * Delete records based on object based id
	 * @param id the unique id of the object
	 * @return Integer
	 */
	public Integer delete(Integer id);

}