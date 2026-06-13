package com.dg.doctor.model;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class UserModel extends User
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private final BigInteger id;
	
	private final String photo;
	
	public UserModel(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,BigInteger id,String photo) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.id = id;
		this.photo = photo;
		// TODO Auto-generated constructor stub
	}	
	
	/**
	 * 
	 * @return id
	 */
	public BigInteger getId(){
		return id;
	}
	
	/**
	 * 
	 * @return photo
	 */
	public String getPhoto(){
		return photo;
	}
}