package com.dg.doctor.service;

import java.io.File;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PractitionerService extends RestService
{
	private static final Logger logger = LoggerFactory.getLogger(PractitionerService.class);
	  
	  private SearchUrlService searchUrlService;		
	  
	  public SearchUrlService getSearchUrlService()
	  {
		  return this.searchUrlService;
	  }
	  
	  public void setSearchUrlService(SearchUrlService searchUrlService)
	  {
		  this.searchUrlService = searchUrlService;
	  }	  
	  
	  /**
		 * 
		 * @param passwordString
		 * @return
		 * @throws Exception
		 */
		public String getMD5(String passwordString) throws Exception{
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
		
		/**
		 * 
		 * @param filePath
		 * @return
		 */
		public Boolean deleteFile(String filePath){
			boolean result = false;
			File file = new File(filePath);
			result = file.delete();
			return result;
		}	
	  	  
}