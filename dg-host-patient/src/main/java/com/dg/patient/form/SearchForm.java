/**
 * 
 */
package com.dg.patient.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author DoctorGlobe
 * 
 */
public class SearchForm {

	/**
	 * The query of SearchForm
	 */
	@NotNull
	@Size(min = 3, max = 255)
	private String query;

	/**
	 * The id of SearchForm
	 */
	@NotNull
	private Integer id;

	/**
	 * Get the query of SearchForm
	 * @return String
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * Set the query of SearchForm
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * Get the id of SearchForm
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id of SearchForm
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
