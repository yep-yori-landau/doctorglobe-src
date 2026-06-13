/**
 * 
 */
package com.dg.hospital.model;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author kkowlgi
 * 
 */
public class CityModel {
          
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String name;
  
	private BigInteger state;

	@NotNull  
	private BigInteger country;
	
	private Double lat;
	  
	private Double lon;

        /**
	* @return the id
	*/
	public BigInteger getId() {
	 return id;
	}

	/**
   	* @param id the id to set
	*/
	public void setId(BigInteger id ) {
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
	public void setName(String name ) {
	 this.name = name;
	}

	/**
	* @return the state
	*/
	public BigInteger getState() {
	 return state;
	}

	/**
   	* @param state the state to set
	*/
	public void setState(BigInteger state ) {
	 this.state = state;
	}

	/**
	* @return the country
	*/
	public BigInteger getCountry() {
	 return country;
	}

	/**
   	* @param country the country to set
	*/
	public void setCountry(BigInteger country ) {
	 this.country = country;
	}

	/**
	* @return the lat
	*/
	public Double getLat() {
	 return lat;
	}

	/**
   	* @param lat the lat to set
	*/
	public void setLat(Double lat ) {
	 this.lat = lat;
	}

	/**
	* @return the lon
	*/
	public Double getLon() {
	 return lon;
	}

	/**
   	* @param lon the lon to set
	*/
	public void setLon(Double lon ) {
	 this.lon = lon;
	}
      
}
