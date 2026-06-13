package com.dg.hospital.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
import com.dg.hospital.model.User;
import com.dg.hospital.model.UserModel;

public class UserService implements UserDetailsService {
	
private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private String loginUrl;	
	
	private String userUrl;
	
	public String getLoginUrl(){
		return this.loginUrl;
	}
		
	public void setLoginUrl(String loginUrl){
		this.loginUrl = loginUrl;
	}
	
	public String getUserUrl(){
		return this.userUrl;
	}
		
	public void setUserUrl(String userUrl){
		this.userUrl = userUrl;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String url = this.getLoginUrl()+"/get/email/"+username+"/active/1";
		logger.info("Login Url called {}",url);
		RestTemplate restTemplate = new RestTemplate();
	    try {
		      ResponseEntity<HospitalUserModel[]> responseEntity = restTemplate.getForEntity(url, HospitalUserModel[].class);
		      List<HospitalUserModel> hospitalUserModelList = Arrays.asList(responseEntity.getBody());
		      HospitalUserModel model = new HospitalUserModel();
		      Boolean found = false;
		      List<BigInteger> healthcareproviders = new ArrayList<BigInteger>();
		      for(HospitalUserModel hospitalUserModel : hospitalUserModelList){
		    	  if(hospitalUserModel.getId() != null && !found){
		    		  found = true;
		    		  model = hospitalUserModel;
		    	  }
		    	  healthcareproviders.add(hospitalUserModel.getHealthcareprovider());
		      }
		      if(model.getId() == null){
		    	  throw new UsernameNotFoundException("user name not found");
		      }
		      Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		      SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(
		                "ROLE_USER");
		      authorities.add(userAuthority);		     
		      UserDetails user = new UserModel(model.getEmail(),model.getPassword(),true,true,true,true,authorities,model.getId(),model.getFirstName()+" "+model.getLastName(),model.getHealthcareprovider(),healthcareproviders);
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
	  * set current logged in healthcareprovider id
	  * @return boolean
	  */
	 public Boolean setCurrentHealthcareprovider(BigInteger healthcareprovider){
		 Boolean result = false;
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Object myuser = (auth != null) ? auth.getPrincipal() : null;
		 if(myuser instanceof UserModel){
			    UserModel user = (UserModel)myuser;
			    user.setHealthcareprovider(healthcareprovider);
			    if(user.getHealthcareprovider().equals(healthcareprovider)){
			    	result = true;
			    }
		 }
		 return result;
	 }
	 
	 /**
	  * 
	  * @return current logged in healthcareprovider List
	  */
	 public List<BigInteger> getHealthcareproviderList(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Object myuser = (auth != null) ? auth.getPrincipal() : null;
		 if(myuser instanceof UserModel){
			    UserModel user = (UserModel)myuser;
			    return user.getHealthcareproviderList();
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
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public HospitalUserModel getHospitalUserModelByEmail(String email){
		String url = this.getLoginUrl()+"/get/email/"+email+"/active/1";	
		RestTemplate restTemplate = new RestTemplate();
	    try {
	    	  logger.info("url found {}",url);
		      ResponseEntity<HospitalUserModel[]> responseEntity = restTemplate.getForEntity(url, HospitalUserModel[].class);
		      List<HospitalUserModel> hospitalUserModelList = Arrays.asList(responseEntity.getBody());
		      HospitalUserModel model = new HospitalUserModel();
		      Boolean found = false;		      
		      for(HospitalUserModel hospitalUserModel : hospitalUserModelList){
		    	  if(hospitalUserModel.getId() != null && !found){
		    		  found = true;
		    		  model = hospitalUserModel;
		    	  }		    	  
		      }		     
		      return model;
		    }
		    catch(Exception e) {
		      logger.error(e.getMessage());
		    }    
		return null;
	}
	/**
	 * 
	 * @param id
	 * @param old_password
	 * @param new_password
	 * @return
	 */
	public Boolean resetPassword(BigInteger id,String old_password,String new_password){
		Boolean result = false;
		 try{				
			User model = this.getUserById(id);
			if(model.getId() != null && model.getPassword().equals(old_password)){
				model.setPassword(this.getSHA1(new_password));
				Integer edited = this.setUser(model);
				if(edited > 0){
					result = true;
				}
			}
		 }catch(Exception ex){
			 logger.info("Error found :",ex.getMessage());
		 }
		return result;
	}
	
	/**
	   * Search for user
	   * 
	   * @param query
	   * 
	   * @return user
	   */
	  public User getUserById(BigInteger id) {    
	    String url = this.getUserUrl() + "/get/id/"+id;		
	    logger.info("url found {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);      
	      return responseEntity.getBody();            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  /**
		 * @param user
		 * @return integer
		 */
		public Integer setUser(User model){
			String url = this.getUserUrl()+"/create";
			logger.info("User create url found ={}",url);
			RestTemplate restTemplate = new RestTemplate();
			try{
				ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
				return responseEntity.getBody();		
			}catch(Exception ex){
				logger.error(ex.getMessage());
			}
			return null;
		}
	
	public String MD5(String passwordString) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(passwordString.getBytes());
		byte[] digest = md.digest();
		StringBuffer password = new StringBuffer();
		for (byte b : digest) {
			password.append(String.format("%02x", b & 0xff));
		}
		return password.toString();
	}	
	
	/**
	 * 
	 * @param passwordString
	 * @return sha1 
	 * @throws Exception
	 */
	public String getSHA1(String passwordString) throws Exception{
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		sha1.reset();
		sha1.update(passwordString.getBytes());
		byte[] digest = sha1.digest();
		StringBuffer password = new StringBuffer();
		for (byte b : digest) {
			password.append(String.format("%02x", b));
		}
		return password.toString();
	}
	
}