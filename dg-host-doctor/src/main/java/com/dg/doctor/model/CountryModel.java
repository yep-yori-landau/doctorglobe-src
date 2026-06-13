/**
 * 
 */
package com.dg.doctor.model;
import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author kkowlgi
 * 
 */
public class CountryModel {
          
	private BigInteger id;

	@NotNull 
	@Size(min = 2, max = 2) 
	private String code;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String name;

	@NotNull  
	private BigInteger region;

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
	* @return the code
	*/
	public String getCode() {
	 return code;
	}

	/**
   	* @param code the code to set
	*/
	public void setCode(String code ) {
	 this.code = code;
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
	* @return the region
	*/
	public BigInteger getRegion() {
	 return region;
	}

	/**
   	* @param region the region to set
	*/
	public void setRegion(BigInteger region ) {
	 this.region = region;
	}
      
}
