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
public class AclRolesModel {
          
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String role;

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
	* @return the role
	*/
	public String getRole() {
	 return role;
	}

	/**
   	* @param role the role to set
	*/
	public void setRole(String role ) {
	 this.role = role;
	}      
}
