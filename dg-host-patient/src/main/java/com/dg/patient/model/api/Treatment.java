package com.dg.patient.model.api;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Treatment{
	
	/**
	 * The id of Treatment
	 */
	private BigInteger id;

	/**
	 * The name of Treatment
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;
	
	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}	
}