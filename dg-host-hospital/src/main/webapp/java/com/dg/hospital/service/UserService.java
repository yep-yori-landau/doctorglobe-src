package com.dg.hospital.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

import com.dg.hospital.model.HospitalUserModel;
import com.dg.hospital.model.UserModel;

public class UserService implements UserDetailsService{
	
private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private String loginUrl;	
	
	public String getLoginUrl(){
		return this.loginUrl;
	}
		
	public void setLoginUrl(String loginUrl){
		this.loginUrl = loginUrl;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String url = this.getLoginUrl()+"/get/email/"+username+"/active/1";
		logger.info("Login Url called {}",url);
		RestTemplate restTemplate = new RestTemplate();
	    try {
		      ResponseEntity<HospitalUserModel> responseEntity = restTemplate.getForEntity(url, HospitalUserModel.class);      
		      HospitalUserModel model = responseEntity.getBody();
		      if(model.getId() == null){
		    	  throw new UsernameNotFoundException("user name not found");
		      }
		      Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		      SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(
		                "ROLE_USER");
		      authorities.add(userAuthority);		     
		      UserDetails user = new UserModel(model.getEmail(),model.getPassword(),true,true,true,true,authorities,model.getId(),model.getFirstName()+" "+model.getLastName(),model.getHealthcareprovider());
		      Authentication authToken = new UsernamePasswordAuthenticationToken (user.getUsername(), user.getPassword(), user.getAuthorities());
		      SecurityContextHolder.getContext().setAuthentication(authToken);
		      return user;
		    }
		    catch(Exception e) {
		      logger.error(e.getMessage());
		    }    
		return null;
	}
	
	/**
	 * 
	 * @return current logged user id
	 */
	public BigInteger getCurrentUserId(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Object myuser = (auth != null) ? auth.getPrincipal() : null;
		 if(myuser instanceof UserModel){
			    UserModel user = (UserModel)myuser;
			    return user.getId();
		 }
		 return null;
	 }
	 
	 /**
	  * 
	  * @return current user email
	  */
	 public String getCurrentUserEmail(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Object myuser = (auth != null) ? auth.getPrincipal() : null;
		 if(myuser instanceof UserModel){
			    UserModel user = (UserModel)myuser;
			    return user.getUsername();
		 }
		 return null;
	 }	
	 
	 /**
	  * 
	  * @return current logged in healthcareprovider id
	  */
	 public BigInteger getCurrentHealthcareprovider(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Object myuser = (auth != null) ? auth.getPrincipal() : null;
		 if(myuser instanceof UserModel){
			    UserModel user = (UserModel)myuser;
			    return user.getHealthcareprovider();
		 }
		 return null;
	 }
	
	/**
	 * 
	 * @return boolean
	 */
	public Boolean isLoggedIn(){
		if(this.getCurrentUserId() != null){
			return true;
		}
		return false;
	}	
}