package com.dg.hospital.model;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserModel extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigInteger id;
	
	private String name;
	
	private BigInteger healthcareprovider;
	
	
	
	
	public UserModel(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,BigInteger id,String name,BigInteger healthcareprovider) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.id = id;
		this.name = name;
		this.healthcareprovider = healthcareprovider;		
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
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return healthcareprovider
	 */
	public BigInteger getHealthcareprovider(){
		return healthcareprovider;
	}
	
}