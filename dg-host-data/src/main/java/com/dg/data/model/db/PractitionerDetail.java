package com.dg.data.model.db;

/**
 * PractitionerDetail DB Model
 * @author DoctorGlobe
 *
 */
public class PractitionerDetail {

	/**
	 * The id of PractitionerDetail
	 */
	private Integer id;

	/**
	 * The title of PractitionerDetail
	 */
	private String title;

	/**
	 * The name of PractitionerDetail
	 */
	private String name;

	/**
	 * The gender of PractitionerDetail
	 */
	private String gender;

	/**
	 * The description of PractitionerDetail
	 */
	private String description;

	/**
	 * The rating of PractitionerDetail
	 */
	private String rating;

	/**
	 * The method of PractitionerDetail
	 */
	private String method;

	/**
	 * The fstmp of PractitionerDetail
	 */
	private Integer fstmp;

	/**
	 * Get the id of PractitionerDetail
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id of PractitionerDetail
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the title of PractitionerDetail
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of PractitionerDetail
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the name of PractitionerDetail
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of PractitionerDetail
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the gender of PractitionerDetail
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set the gender of PractitionerDetail
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get the description of PractitionerDetail
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of PractitionerDetail
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the rating of PractitionerDetail
	 * @return String
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Set the rating of PractitionerDetail
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Get the method of PractitionerDetail
	 * @return String
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Set the method of PractitionerDetail
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * Get the fstmp of PractitionerDetail
	 * @return Integer
	 */
	public Integer getFstmp() {
		return fstmp;
	}

	/**
	 * Set the fstmp of PractitionerDetail
	 * @param fstmp the fstmp to set
	 */
	public void setFstmp(Integer fstmp) {
		this.fstmp = fstmp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PractitionerModel [id=" + id + ", title=" + title + ", name="
				+ name + ", gender=" + gender + ", description=" + description
				+ ", rating=" + rating + "]";
	}

}