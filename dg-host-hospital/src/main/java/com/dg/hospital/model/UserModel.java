package com.dg.hospital.model;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

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
	
	private List<BigInteger> healthcareproviderList;
	
	
	
	
	public UserModel(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,BigInteger id,String name,BigInteger healthcareprovider,List<BigInteger> healthcareproviderList) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.id = id;
		this.name = name;
		this.healthcareprovider = healthcareprovider;
		this.healthcareproviderList = healthcareproviderList;		
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
	
	/**
	 * 
	 * @param healthcareprovider
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider){
		this.healthcareprovider = healthcareprovider;
	}
	
	/**
	 * 
	 * @return healthcareprovider List
	 */
	public List<BigInteger> getHealthcareproviderList(){
		return healthcareproviderList;
	}
	
}