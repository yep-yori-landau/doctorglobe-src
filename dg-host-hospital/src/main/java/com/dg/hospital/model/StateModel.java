/**
 * 
 */
package com.dg.hospital.model;
import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Size;


/**
 * @author kkowlgi
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateModel {
          
	private BigInteger id;

	@NotNull 
	@Size(min = 2, max = 3) 
	private String code;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String name;

	@NotNull  
	private BigInteger country;

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

	
      
}
