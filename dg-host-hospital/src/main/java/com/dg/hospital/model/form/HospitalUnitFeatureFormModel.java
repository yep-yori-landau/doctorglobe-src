/**
 * 
 */
package com.dg.hospital.model.form;
import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author kkowlgi
 * 
 */
public class HospitalUnitFeatureFormModel {
          
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String description;

	@NotNull  
	private BigInteger feature;

	@NotNull  
	private BigInteger healthcareproviderunit;
  
	private BigInteger healthcareprovider;
	
	private String feature_name;
	
	private String unit_name;	

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
	* @return the description
	*/
	public String getDescription() {
	 return description;
	}

	/**
   	* @param description the description to set
	*/
	public void setDescription(String description ) {
	 this.description = description;
	}

	/**
	* @return the feature
	*/
	public BigInteger getFeature() {
	 return feature;
	}

	/**
   	* @param feature the feature to set
	*/
	public void setFeature(BigInteger feature ) {
	 this.feature = feature;
	}

	/**
	* @return the healthcareproviderunit
	*/
	public BigInteger getHealthcareproviderunit() {
	 return healthcareproviderunit;
	}

	/**
   	* @param healthcareproviderunit the healthcareproviderunit to set
	*/
	public void setHealthcareproviderunit(BigInteger healthcareproviderunit ) {
	 this.healthcareproviderunit = healthcareproviderunit;
	}

	/**
	* @return the healthcareprovider
	*/
	public BigInteger getHealthcareprovider() {
	 return healthcareprovider;
	}

	/**
   	* @param healthcareprovider the healthcareprovider to set
	*/
	public void setHealthcareprovider(BigInteger healthcareprovider ) {
	 this.healthcareprovider = healthcareprovider;
	}      
	
	/**
	* @return the feature_name
	*/
	public String getFeatureName() {
	 return feature_name;
	}

	/**
   	* @param feature_name the feature_name to set
	*/
	public void setFeatureName(String feature_name ) {
	 this.feature_name = feature_name;
	}
	
	/**
	* @return the unit_name
	*/
	public String getUnitName() {
	 return unit_name;
	}

	/**
   	* @param unit_name the unit_name to set
	*/
	public void setUnitName(String unit_name ) {
	 this.unit_name = unit_name;
	}	
}
