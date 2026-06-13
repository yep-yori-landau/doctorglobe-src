package com.dg.data.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.History;

/**
 * Spring JDBC based implementation of GenericDao which can be extended to add
 * more specialized DAO methods.
 * 
 * @author DoctorGlobe
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	private static final Logger logger = LoggerFactory
			.getLogger(GenericDAOImpl.class);

	private Class<T> clazz;

	private JdbcTemplate jdbcTemplate;

	/**
	 * @return the jdbcTemplate that is currently in use,
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * set the jdbcTemplate
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * By defining this class as abstract, we prevent Spring from creating
	 * instance of this class If not defined abstract
	 * getClass().getGenericSuperClass() would return Object. There would be
	 * exception because Object class does not hava constructor with parameters.
	 */
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	/**
	 * GenericDao insert operation implementation
	 */
	@Override
	public Integer insert(T model) {
		Integer result = 0;
		try {
			BigInteger id = (BigInteger) this.getId(model);
			if (id == null) {
				String tableName = this.splitCamelCase(clazz.getSimpleName())
						.toLowerCase();
				String queryString = "insert into " + tableName + "("
						+ this.getFieldNames() + ") values ("
						+ this.getFieldParams() + ")";
				result = this.getJdbcTemplate().update(queryString,
						this.getFieldObject(model));
				if (result > 0) {
					this.saveHistory(tableName, null, this.getString(model),
							"data", BigInteger.valueOf(0));
				}
			}
			else {
				result = this.update(model, BigInteger.valueOf(0), "data");
				if (result > 0) {
					result = ((BigInteger) this.getId(model)).intValue();
				}
			}
		}
		catch (Exception ex) {
			logger.info("sql error found during insert = {}", ex.getMessage());
		}
		return result;
	}

	/**
	 * GenericDao insert operations implementation Also store data history with
	 * user name or user type
	 */
	@Override
	public Integer insert(T model, BigInteger user, String user_type) {
		Integer result = 0;
		try {
			BigInteger id = (BigInteger) this.getId(model);
			logger.info("id {}", user);
			logger.info("type {}", user_type);
			if (id == null) {
				String tableName = this.splitCamelCase(clazz.getSimpleName())
						.toLowerCase();
				String queryString = "insert into " + tableName + "("
						+ this.getFieldNames() + ") values ("
						+ this.getFieldParams() + ")";
				result = this.getJdbcTemplate().update(queryString,
						this.getFieldObject(model));
				logger.info("query {}", queryString);
				logger.info("type {}", result);
				if (result > 0) {
					this.saveHistory(tableName, null, this.getString(model),
							user_type, user);
				}
			}
			else {
				result = this.update(model, user, user_type);
				if (result > 0) {
					result = ((BigInteger) this.getId(model)).intValue();
				}
			}
		}
		catch (Exception ex) {
			logger.info("sql error found during insert = {}", ex.getMessage());
		}
		return result;
	}

	/**
	 * GenericDao update operations implementation dependent Also store data
	 * history with user name or user type
	 */
	private Integer update(T model, BigInteger user, String user_type) {
		Integer result = 0;
		try {
			BigInteger id = (BigInteger) this.getId(model);
			T updateModel = this.findById(id.intValue());
			String originalData = this.getString(updateModel);
			String tableName = this.splitCamelCase(clazz.getSimpleName())
					.toLowerCase();
			String queryString = "update " + tableName + " set "
					+ this.getUpdateFieldNames() + " where id = ?";
			result = this.getJdbcTemplate().update(queryString,
					this.getUpdateFieldObject(model));
			if (result > 0) {
				this.saveHistory(tableName, originalData, this.getString(model),
						user_type, user);
			}
		}
		catch (Exception ex) {
			logger.info("sql error found during update = {}", ex.getMessage());
		}
		return result;
	}

	/**
	 * Store all Add/Edit data history in database
	 * @param name
	 * @param original_data
	 * @param modify_data
	 * @param user_type
	 * @param user
	 * @return Integer
	 */
	private Integer saveHistory(String name, String original_data,
			String modify_data, String user_type, BigInteger user) {
		Integer res = 0;
		try {
			History model = new History();
			model.setName(name);
			model.setOriginalData(original_data);
			model.setModifyData(modify_data);
			model.setUserType(user_type);
			model.setUser(user);
			String queryString = "INSERT INTO history (id,name,original_data,modify_data,modify_date,user_type,user) VALUES (? ,? ,? ,?,now(),?,?)";
			res = this.getJdbcTemplate().update(queryString,
					new Object[] { model.getId(), model.getName(),
							model.getOriginalData(), model.getModifyData(),
							model.getUserType(), model.getUser() });

		}
		catch (Exception ex) {
			logger.info("sql error found during insert history = {}",
					ex.getMessage());
		}
		return res;
	}

	/**
	 * GenericDao fetchAll method implementation
	 */
	@Override
	public List<T> fetchAll() {
		try {
			String tableName = this.splitCamelCase(clazz.getSimpleName())
					.toLowerCase();
			String queryString = "select *from " + tableName;
			return this.getJdbcTemplate().query(queryString.toString(),
					new BeanPropertyRowMapper<T>(clazz));
		}
		catch (Exception ex) {
			logger.info("sql error found fetch all = {}", ex.getMessage());
		}
		return null;
	}

	/**
	 * GenericDao findById method implementation
	 */
	@Override
	public T findById(Integer id) {
		try {
			if (id > 0) {
				String tableName = this.splitCamelCase(clazz.getSimpleName())
						.toLowerCase();
				String queryString = "select *from " + tableName
						+ " where id = ?";
				return this.getJdbcTemplate().queryForObject(
						queryString.toString(), new Object[] { id },
						new BeanPropertyRowMapper<T>(clazz));
			}
		}
		catch (Exception ex) {
			logger.info("sql error found during find by id = {}",
					ex.getMessage());
		}
		return null;
	}

	/**
	 * GenericDao delete operation implementation dependent with specific id
	 * Also store data history with user name or user type
	 */
	@Override
	public Integer delete(Integer id, BigInteger user, String user_type) {
		Integer result = 0;
		try {
			if (id > 0) {
				T model = this.findById(id);
				String tableName = this.splitCamelCase(clazz.getSimpleName())
						.toLowerCase();
				String queryString = "delete from " + tableName
						+ " where id = ?";
				result = this.getJdbcTemplate().update(queryString,
						new Object[] { id });
				if (result > 0) {
					this.saveHistory(tableName, this.getString(model), null,
							user_type, user);
				}
			}
		}
		catch (Exception ex) {
			logger.info("sql error found during delete = {}", ex.getMessage());
		}
		return result;
	}

	/**
	 * GenericDao delete operations implementation dependent with specific id
	 */
	@Override
	public Integer delete(Integer id) {
		Integer result = 0;
		try {
			if (id > 0) {
				T model = this.findById(id);
				String tableName = this.splitCamelCase(clazz.getSimpleName())
						.toLowerCase();
				String queryString = "delete from " + tableName
						+ " where id = ?";
				result = this.getJdbcTemplate().update(queryString,
						new Object[] { id });
				if (result > 0) {
					this.saveHistory(tableName, this.getString(model), null,
							"data", BigInteger.valueOf(0));
				}
			}
		}
		catch (Exception ex) {
			logger.info("sql error found during delete = {}", ex.getMessage());
		}
		return result;
	}

	/**
	 * Check class method is getter of not
	 * @param method
	 * @return true
	 */
	public boolean isGetter(Method method) {
		if (!method.getName().startsWith("get"))
			return false;
		if (method.getParameterTypes().length != 0)
			return false;
		return true;
	}

	/**
	 * Convert camelcase string into table name eg TreatmentPrice =
	 * treatment_price
	 * @param s
	 * @return string
	 */
	private String splitCamelCase(String s) {
		return s.replaceAll(
				String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])",
						"(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"),
				"_");
	}

	/**
	 * Gets model attributes name
	 * @return string
	 */
	private String getFieldNames() {
		Field[] fields = clazz.getDeclaredFields();
		String fieldName = "";
		for (int i = 0; i < fields.length; i++) {
			fieldName += fields[i].getName().toString();
			if (i != fields.length - 1) {
				fieldName += ",";
			}
		}
		return fieldName;
	}

	/**
	 * Gets model attributes values
	 * @return string
	 */
	private String getFieldParams() {
		Field[] fields = clazz.getDeclaredFields();
		String fieldName = "";
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equalsIgnoreCase("password")) {
				fieldName += "sha1(?)";
			}
			else {
				fieldName += "?";
			}
			if (i != fields.length - 1) {
				fieldName += ",";
			}
		}
		return fieldName;
	}

	/**
	 * Gets field object
	 * @param model
	 * @return Object
	 */
	private Object[] getFieldObject(T model) {
		Field[] fields = model.getClass().getDeclaredFields();
		Object[] object = new Object[fields.length];
		int i = 0;
		try {
			for (Field f : fields) {
				f.setAccessible(true);
				object[i] = f.get(model);
				i++;
			}
		}
		catch (Exception ex) {
			logger.info("Exception found {}", ex.getMessage());
		}
		return object;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	private Object getId(T model) {
		Object object = null;
		try {
			Method[] methods = model.getClass().getMethods();
			for (Method m : methods) {
				if (m.getName().indexOf("get") == 0
						&& m.getName().equals("getId")) {
					object = m.invoke(model);
				}
			}
		}
		catch (Exception ex) {
			logger.info("Exception found {}", ex.getMessage());
		}
		return object;
	}

	/**
	 * Gets field names for update query
	 * @return string
	 */
	private String getUpdateFieldNames() {
		Field[] fields = clazz.getDeclaredFields();
		String fieldName = "";
		for (int i = 0; i < fields.length; i++) {
			fieldName += fields[i].getName().toString();
			if (i != fields.length - 1) {
				fieldName += "= ?,";
			}
			if (i == fields.length - 1) {
				fieldName += "= ?";
			}
		}
		return fieldName;
	}

	/**
	 * Gets field names object for update query
	 * @param model
	 * @return Object
	 */
	private Object[] getUpdateFieldObject(T model) {
		Field[] fields = model.getClass().getDeclaredFields();
		Object[] object = new Object[fields.length + 1];
		int i = 0;
		try {
			for (Field f : fields) {
				f.setAccessible(true);
				object[i] = f.get(model);
				i++;
			}
			object[fields.length] = this.getId(model);
		}
		catch (Exception ex) {
			logger.info("Exception found {}", ex.getMessage());
		}
		return object;
	}

	/**
	 * 
	 * @param model
	 * @return String
	 */
	public String getString(T model) {
		StringBuilder sb = new StringBuilder();
		try {
			Field[] aClassFields = model.getClass().getDeclaredFields();
			sb.append(model.getClass().getSimpleName() + " [ ");
			for (Field f : aClassFields) {
				String fName = f.getName();
				f.setAccessible(true);
				sb.append(fName + " = " + f.get(model) + ", ");
			}
			sb.append("]");
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}

		return sb.toString();
	}
}