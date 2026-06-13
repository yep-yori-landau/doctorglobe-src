package com.dg.doctor.service;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;

import com.dg.doctor.model.PatientCaseBookingModel;
import com.dg.doctor.model.PatientCaseMessagesModel;
import com.dg.doctor.model.PatientConferenceModel;
import com.dg.doctor.model.PatientDetailModel;
import com.dg.doctor.model.PatientModel;
import com.dg.doctor.model.PractitionerCountryModel;
import com.dg.doctor.model.PractitionerModel;
import com.dg.doctor.model.PractitionertypeModel;
import com.dg.doctor.model.UserModel;
import com.dg.doctor.model.CityModel;
import com.dg.doctor.model.StateModel;
import com.dg.doctor.model.CountryModel;


public class RestService{
	
	private static final Logger logger = LoggerFactory.getLogger(RestService.class);
	  
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
	   * Search for patient detail
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<PatientDetailModel> getPatientDetail(BigInteger id) {	    
		String url = this.getSearchUrlService().getPatientBaseUrl() +"/get/practitioner/" +id;		
	    logger.info("Url Founed {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<PatientDetailModel[]> responseEntity = restTemplate.getForEntity(url, PatientDetailModel[].class);	      
	      return Arrays.asList(responseEntity.getBody());       
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	
	  
	  
	  /**
	   * Search for patient detail
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<PatientDetailModel> getPatientDetailByPatientcase(BigInteger patientcase,BigInteger practitioner) {	    
		String url = this.getSearchUrlService().getPatientBaseUrl() +"/get/patientcase/" +patientcase+"/practitioner/"+practitioner;		
	    logger.info("Url Founed {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<PatientDetailModel[]> responseEntity = restTemplate.getForEntity(url, PatientDetailModel[].class);
	      logger.info("pratientdetail {}",responseEntity.getBody());
	      return Arrays.asList(responseEntity.getBody());       
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }  
	 
	  /**
	   * Search for practitioner
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public PractitionerModel getPractitioner(BigInteger id) {	    
		String url = this.getSearchUrlService().getPractitionerBaseUrl() +"/get/id/" +id;		
	   // logger.info("Url Founed {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<PractitionerModel> responseEntity = restTemplate.getForEntity(url, PractitionerModel.class);      
	      return responseEntity.getBody();      
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  
	  /**
	   * Search for practitioner_type
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<PractitionertypeModel> getPractitionerType() {	    
		String url = this.getSearchUrlService().getPractitionertypeBaseUrl() +"/getAll" ;		
	    logger.info("Url Founed {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	    	ResponseEntity<PractitionertypeModel[]> responseEntity = restTemplate.getForEntity(url, PractitionertypeModel[].class);      
		      return Arrays.asList(responseEntity.getBody());            
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	  
	  /**
	   * 
	   * @param edit practitionerModel
	   * @return
	   */
	  public Integer editPractitioner(PractitionerModel practitionerModel){
		  String url = this.getSearchUrlService().getPractitionerBaseUrl() +"/create/user/"+practitionerModel.getId()+"/type/practitioner";
		  logger.info("url found {}",url);	  
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, practitionerModel, Integer.class);
	    	  return responseEntity.getBody();                 
	      }
	      catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;		  
	  }
	  
	  /**
	   * @action edit patient case messages
	   * @param model
	   * @return
	   */
	  public Integer editPatientCaseMessage(PatientCaseMessagesModel model) {		  
		  String url = this.getSearchUrlService().getPatientCaseMessagesBaseUrl() +"/create";
		  logger.info("url found",url);
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
	    	  return responseEntity.getBody();                 
	      }
	      catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;
	  }  
	  
	  /**
	   * @action edit patient case booking
	   * @param model
	   * @return
	   */
	  public Integer editPatientCaseBooking(PatientCaseBookingModel model) {	
		  
		  String url = this.getSearchUrlService().getPatientCaseBookingBaseUrl() +"/create/user/"+this.getCurrentUserId()+"/type/practitioner";
		  logger.info("url found",url);
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, model, Integer.class);
	    	  return responseEntity.getBody();                 
	      }
	      catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;
	  } 
	 
	
	 
	
	  
	  /**
	   * Modify patient conference 
	   * 
	   * @param patient conference 
	   * 
	   * @return
	   */
	  public Integer editPatientConferecne(PatientConferenceModel patientConference ) {
		
		String url = this.getSearchUrlService().getPatientConferenceBaseUrl() +"/create/user/"+this.getCurrentUserId()+"/type/practitioner";		
	    logger.info("Url Founed {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	    	ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, patientConference, Integer.class);
	    	return responseEntity.getBody();     
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return 0;
	  }
	  
	  /**
	   * @action update patient case messages status
	   * @param model
	   * @return
	   */
	  public Integer updatePatientCaseMessage(BigInteger patientcase,Integer receiver,String receiver_type) {		  
		  String url = this.getSearchUrlService().getPatientCaseMessagesBaseUrl() +"/edit/patientcase/"+patientcase+"/receiver/"+receiver+"/receiver_type/"+receiver_type;
		  logger.info("url found",url);
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url,Integer.class);
	    	  return responseEntity.getBody();
	      }catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;
	  } 
	  
	  /**
	   * @action update patient case status
	   * @param model
	   * @return
	   */
	  public Integer updatePatientCaseStatus(BigInteger patientcase,String status) {		  
		  String url = this.getSearchUrlService().getPatientCaseBaseUrl() +"/edit/id/"+patientcase+"/status/"+status;
		  logger.info("url found",url);
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url,Integer.class);
	    	  return responseEntity.getBody();
	      }catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;
	  } 
	  
	  /**
	   * Search for patient
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public PatientModel getPatient(BigInteger id) {	    
		String url = this.getSearchUrlService().getPatientBaseUrl() +"/get/id/" +id;		
	    logger.info("Url Founed {}",url);
	    RestTemplate restTemplate = new RestTemplate();   
	    try {
	      ResponseEntity<PatientModel> responseEntity = restTemplate.getForEntity(url, PatientModel.class);      
	      return responseEntity.getBody();      
	    }
	    catch(Exception e) {
	      logger.error(e.getMessage());
	    }    
	    return null;
	  }
	 
	  /**
	   * search for total new message
	   * @return integer
	   */
	  public Integer getTotalNewMessage(Integer receiver,String receiver_type){
		  String url = this.getSearchUrlService().getPatientCaseMessagesBaseUrl() +"/get/receiver/"+receiver+"/receiver_type/"+receiver_type;
		 // logger.info("total new message url found {}",url);
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url,Integer.class);
	    	  return responseEntity.getBody();                 
	      }
	      catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;
	  }
	  
	  /**
	   * Search for practitioner through email
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public PractitionerModel getPractitionerByEmail(String email){				
		    String url = this.getSearchUrlService().getPractitionerBaseUrl()+"/get/email/"+email+"/active/"+1;		
			logger.info("Url Founed {}",url);
		    RestTemplate restTemplate = new RestTemplate();
		    try {
			      ResponseEntity<PractitionerModel> responseEntity = restTemplate.getForEntity(url, PractitionerModel.class);      
			      PractitionerModel model = responseEntity.getBody();			      
			      return model;
			    }
			    catch(Exception e) {
			      logger.error(e.getMessage());
			    }    
			return null;
	}	
	  
	  /**
	   * @action reset practitioner password
	   * @param model
	   * @return
	   */
	  public Integer resetPassword(Integer id,String old_password,String new_password) {		  
		  String url = this.getSearchUrlService().getPractitionerBaseUrl() +"/reset/id/"+id+"/old_password/"+old_password+"/new_password/"+new_password;
		  logger.info("url found",url);
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url,Integer.class);
	    	  return responseEntity.getBody();
	      }catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;
	  }     
	  
	  /**
	   * 
	   * @return current user id
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
	   * @action update patient conference status
	   * @param model
	   * @return
	   */
	  public Integer updatePatientConferenceStatus(BigInteger patientcase,BigInteger hcpstmp,String status) {		  
		  String url = this.getSearchUrlService().getPatientConferenceBaseUrl() +"/editstatus/pc/"+patientcase+"/hcpstmp/"+hcpstmp+"/status/"+status;
		  logger.info("url found {}",url);
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url,Integer.class);
	    	  return responseEntity.getBody();
	      }catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;
	  }
	  
	  /**
	   * @action update patient case booking status
	   * @param model
	   * @return
	   */
	  public Integer updatePatientBookingStatus(BigInteger patientcase,BigInteger hcpstmp,String status) {		  
		  String url = this.getSearchUrlService().getPatientCaseBookingBaseUrl() +"/editstatus/pc/"+patientcase+"/hcpstmp/"+hcpstmp+"/status/"+status;
		  logger.info("url found {}",url);
	      RestTemplate restTemplate = new RestTemplate();
	      try {       
	    	  ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url,Integer.class);
	    	  return responseEntity.getBody();
	      }catch(Exception e) {
	        logger.error(e.getMessage());
	      }    
	    return 0;
	  }
	  
	  /**
	   * 
	   * @param languageTag
	   * @return
	   */
	  public String getTimeZoneByLocale(final String languageTag){
		    final Locale locale = Locale.forLanguageTag(languageTag);
		    final Calendar cal = Calendar.getInstance(locale);
		    final TimeZone timeZone = cal.getTimeZone();
		    return timeZone.getID();
	  }
	  
	  public Set<TimeZone> getTimeZoneByCountryOrCity(String countryCode,String city){		  
		  Set<TimeZone> cityTimeZones = new HashSet<TimeZone>();
		  Set<TimeZone> countryTimeZones = new HashSet<TimeZone>();		  
		  for(String id :com.ibm.icu.util.TimeZone.getAvailableIDs(countryCode)){
			  if(this.timeZoneIdMatch(id, city)){				  
				  cityTimeZones.add(TimeZone.getTimeZone(id));
			  }
			  countryTimeZones.add(TimeZone.getTimeZone(id));
		  }
		  if(cityTimeZones.isEmpty()){
			  return countryTimeZones;
		  }
		  return cityTimeZones;
	  }
	  
	  public boolean timeZoneIdMatch(String id,String city){
		  String idCity = id.substring(id.indexOf('/')+1);
		  return idCity.replace('_', ' ').equals(city);
	  }
	  
	  public String getGMTFormatTimeZone(TimeZone tz){
		  long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
		  long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) 
	                                  - TimeUnit.HOURS.toMinutes(hours);
		  minutes = Math.abs(minutes);
		  String result = "";
		  if (hours > 0) {
			//result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
			  result = String.format("GMT+%d:%02d", hours, minutes);
		  } else {
			//result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
			result = String.format("GMT%d:%02d", hours, minutes);
		  }
		  return result;
	  }
	  
	  public TimeZone getTimeZone(String countryCode,String city){
		  Set<TimeZone> tz=this.getTimeZoneByCountryOrCity(countryCode,city);		  
		  if(!tz.isEmpty()){
		    	TimeZone timeZone = tz.iterator().next();
		    	return timeZone;
		  }else{
		    	TimeZone timeZone = TimeZone.getTimeZone("GMT 00:00");
		    	return timeZone;
		  }		  
	  }
	  
	  /**
	   * Search for practitioner through email
	   * 
	   * @param query
	   * 
	   * @return
	   */
	  public List<PractitionerCountryModel> getPractitionerCountryModel(BigInteger hstmp){				
		    String url = this.getSearchUrlService().getPractitionerBaseUrl()+"/get/country/hstmp/"+hstmp;		
			logger.info("Url Founed {}",url);
		    RestTemplate restTemplate = new RestTemplate();
		    try {
			      ResponseEntity<PractitionerCountryModel[]> responseEntity = restTemplate.getForEntity(url, PractitionerCountryModel[].class);			      			      
			      return Arrays.asList(responseEntity.getBody());
			    }
			    catch(Exception e) {
			      logger.error(e.getMessage());
			    }    
			return null;
	}
	  
	  public String getPractitionerTimeZone(BigInteger hstmp){
			String practitionerTimeZone = "";
			List<PractitionerCountryModel> model = this.getPractitionerCountryModel(hstmp);
			if(!model.isEmpty()){
				for(PractitionerCountryModel pcm : model){
					if(pcm.getCountry() != null){
						TimeZone timeZone = this.getTimeZone(pcm.getCountryCode(), pcm.getCity());
						practitionerTimeZone = this.getGMTFormatTimeZone(timeZone);
						break;
					}
				}
			}else{
				practitionerTimeZone = "GMT 00:00";
			}
			return practitionerTimeZone;
		}
	  
	  public String getTimeZoneConvert(Date date, String fromTZ, String toTZ, String format) {
		  try {
		       TimeZone fromTimeZone = TimeZone.getTimeZone(fromTZ);
		       TimeZone toTimeZone = TimeZone.getTimeZone(toTZ);
		       Calendar calendar = Calendar.getInstance();
		       calendar.setTimeZone(fromTimeZone);
		       calendar.setTime(date);
		       calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
		        if (fromTimeZone.inDaylightTime(calendar.getTime())) {
		        calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);
		        }
		        calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
		        if (toTimeZone.inDaylightTime(calendar.getTime())) {
		        calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
		        }
		          DateFormat sdf = new SimpleDateFormat(format);
		          return sdf.format(calendar.getTime());
		        } catch (NullPointerException ne) {
		        return "";
		         }
		        catch (Exception e) {
		          System.out.println("Exception : " + e.getMessage());
		          return "";
		        }
		  }
	  
	  /**
		 * Search for country
		 * 
		 * @param query
		 * 
		 * @return
		 */
		public List<CountryModel> getCountry() {
			String url = this.getSearchUrlService().getCountryBaseUrl() + "/getAll";
			logger.info("country url found {}", url);
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<CountryModel[]> responseEntity = restTemplate
						.getForEntity(url, CountryModel[].class);
				return Arrays.asList(responseEntity.getBody());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return null;
		}
		
		/**
		 * Search for state
		 * 
		 * @param query
		 * 
		 * @return
		 */
		public List<StateModel> getState() {
			String url = this.getSearchUrlService().getStateBaseUrl() + "/getAll";
			logger.info("state url found {}", url);
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<StateModel[]> responseEntity = restTemplate
						.getForEntity(url, StateModel[].class);
				return Arrays.asList(responseEntity.getBody());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Search for city
		 * 
		 * @param query
		 * 
		 * @return
		 */
		public List<CityModel> getCityByState() {
			String url = this.getSearchUrlService().getCityBaseUrl() + "/getAll";
			logger.info("city url found {}", url);
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<CityModel[]> responseEntity = restTemplate
						.getForEntity(url, CityModel[].class);
				return Arrays.asList(responseEntity.getBody());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Search for state
		 * 
		 * @param query
		 * 
		 * @return
		 */
		public List<StateModel> getStateByCountry(Integer country) {
			String url = this.getSearchUrlService().getStateBaseUrl() + "/get/country/"
					+ country;
			logger.info("url found {}", url);
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<StateModel[]> responseEntity = restTemplate
						.getForEntity(url, StateModel[].class);
				return Arrays.asList(responseEntity.getBody());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Search for city
		 * 
		 * @param query
		 * 
		 * @return
		 */
		public List<CityModel> getCityByCountry(Integer country) {
			String url = this.getSearchUrlService().getCityBaseUrl() + "/get/country/"
					+ country;
			logger.info("url found {}", url);
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<CityModel[]> responseEntity = restTemplate
						.getForEntity(url, CityModel[].class);
				return Arrays.asList(responseEntity.getBody());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Search for city
		 * 
		 * @param query
		 * 
		 * @return
		 */
		public List<CityModel> getCityByState(Integer state) {
			String url = this.getSearchUrlService().getCityBaseUrl() + "/get/state/"
					+ state;
			logger.info("url found {}", url);
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<CityModel[]> responseEntity = restTemplate
						.getForEntity(url, CityModel[].class);
				return Arrays.asList(responseEntity.getBody());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Search for city
		 * 
		 * @param query
		 * 
		 * @return
		 */
		public CityModel getCityById(Integer id) {
			String url = this.getSearchUrlService().getCityBaseUrl() + "/get/id/" + id;
			logger.info("url found {}", url);
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<CityModel> responseEntity = restTemplate
						.getForEntity(url, CityModel.class);
				return responseEntity.getBody();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return null;
		}
		
		/**
		 * 
		 * @param patient
		 * @param treatment
		 * @return
		 */
		public List<PatientCaseBookingModel> getPatientCaseBookingModelByPatientAndTreatment(BigInteger patient,Integer treatment){
			  String url = this.getSearchUrlService().getPatientCaseBookingBaseUrl() +"/get/patient/" + patient + "/treatment/" + treatment;
			  logger.info("url is {}",url);
		      RestTemplate restTemplate = new RestTemplate();
		      try {
		        ResponseEntity<PatientCaseBookingModel[]> responseEntity = restTemplate.getForEntity(url, PatientCaseBookingModel[].class);        
		        return Arrays.asList(responseEntity.getBody());       
		      }
		      catch(Exception e) {
		        logger.error(e.getMessage());
		      }    
		    return null;
		 }
		
		public Boolean getIsProcedureExist(BigInteger patient,BigInteger treatment,BigInteger hstmp){
			Boolean found = false;
			List<PatientCaseBookingModel> pcbList = this.getPatientCaseBookingModelByPatientAndTreatment(patient, treatment.intValue());
			for(PatientCaseBookingModel model:pcbList){
				if(!model.getHealthcareproviderSpecialtyTreatmentMethodPractitioner().equals(hstmp)){
					found = true;
				}
			}
			return found;
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