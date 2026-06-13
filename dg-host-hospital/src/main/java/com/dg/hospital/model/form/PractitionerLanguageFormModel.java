package com.dg.hospital.model.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PractitionerLanguageFormModel{
	
	private BigInteger id;

	@NotNull 
	@Size(min = 2, max = 2) 
	private String language;
	
	private String language_name;
  
	private BigInteger practitioner;
	
	private Boolean is_checked;
	
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
	* @return the language
	*/
	public String getLanguage() {
	 return language;
	}

	/**
   	* @param language the language to set
	*/
	public void setLanguage(String language ) {
	 this.language = language;
	}
	
	/**
	* @return the language_name
	*/
	public String getLanguageName() {
	 return language_name;
	}
	
	/**
   	* @param language_name the language_name to set
	*/
	public void setLanguageName(String language_name ) {
	 this.language_name = language_name;
	}
	
	/**
	 * 
	 * @return the practitioner
	 */
	public BigInteger getPractitioner(){
		return practitioner;
	}
	
	/**
	 * 
	 * @param practitioner
	 */
	public void setPractitioner(BigInteger practitioner){
		this.practitioner = practitioner;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public Boolean getIsChecked(){
		return is_checked;
	}
	
	/**
	 * 
	 * @param is_checked the is_chekced to set
	 */
	public void setIsChecked(Boolean is_checked){
		this.is_checked = is_checked;
	}
}