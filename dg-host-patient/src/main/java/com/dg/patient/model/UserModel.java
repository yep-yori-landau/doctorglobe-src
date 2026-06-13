package com.dg.patient.model;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
 * @author DoctorGlobe
 * 
 */
public class UserModel extends User {
	
	/**
	 * The serialVersionUID of UserModel
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The id of UserModel
	 */
	private final BigInteger id;

	/**
	 * The photo of UserModel
	 */
	private String photo;

	/**
	 * The name of UserModel
	 */
	private String name;

	/**
	 * The user_agreement of UserModel
	 */
	private Boolean user_agreement;

	/**
	 * The associate_user of UserModel
	 */
	private Boolean associate_user;

	/**
	 * The user_theme of UserModel
	 */
	private String user_theme;

	/**
	 * The user_url of UserModel
	 */
	private String user_url;

	/**
	 * The associate_id of UserModel
	 */
	private BigInteger associate_id;

	/**
	 * The dependent of UserModel
	 */
	private BigInteger dependent;

	/**
	 * The patientcase of UserModel
	 */
	private BigInteger patientcase;

	public UserModel(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, BigInteger id,
			String photo, String name, Boolean user_agreement,
			Boolean associate_user, String user_theme, String user_url,
			BigInteger associate_id, BigInteger dependent) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
		this.photo = photo;
		this.name = name;
		this.user_agreement = user_agreement;
		this.associate_user = associate_user;
		this.user_theme = user_theme;
		this.user_url = user_url;
		this.associate_id = associate_id;
		this.dependent = dependent;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * 
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @set name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return user_agreement
	 */
	public Boolean getUserAgreement() {
		return user_agreement;
	}

	/**
	 * 
	 * @set user_agreement
	 */
	public void setUserAgreement(Boolean user_agreement) {
		this.user_agreement = user_agreement;
	}

	/**
	 * 
	 * @return associate_user
	 */
	public Boolean getAssociateUser() {
		return associate_user;
	}

	/**
	 * 
	 * @return associate_user
	 */
	public void setAssociateUser(Boolean associate_user) {
		this.associate_user = associate_user;
	}

	/**
	 * 
	 * @return theme
	 */
	public String getUserTheme() {
		return user_theme;
	}

	/**
	 * 
	 * @set user_theme
	 */
	public void setUserTheme(String user_theme) {
		this.user_theme = user_theme;
	}

	/**
	 * 
	 * @return user_url
	 */
	public String getUserUrl() {
		return user_url;
	}

	/**
	 * 
	 * @set user_url
	 */
	public void setUserUrl(String user_url) {
		this.user_url = user_url;
	}

	/**
	 * 
	 * @return associate_id
	 */
	public BigInteger getAssociateId() {
		return associate_id;
	}

	/**
	 * 
	 * @return dependent
	 */
	public BigInteger getDependent() {
		return dependent;
	}

	/**
	 * 
	 * @param patientcase
	 */
	public void setPatientcase(BigInteger patientcase) {
		this.patientcase = patientcase;
	}

	/**
	 * 
	 * @return patientcase
	 */
	public BigInteger getPatientcase() {
		return patientcase;
	}

}