package com.dg.doctor.controller;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

import com.dg.doctor.form.CancelForm;
import com.dg.doctor.form.ForgotForm;
import com.dg.doctor.form.LoginForm;
import com.dg.doctor.form.PatientBookingForm;
import com.dg.doctor.form.PatientConferenceForm;
import com.dg.doctor.form.PostMessageForm;
import com.dg.doctor.model.PatientCaseBookingModel;
import com.dg.doctor.model.PatientConferenceModel;
import com.dg.doctor.model.PatientDetailModel;
import com.dg.doctor.model.PatientModel;
import com.dg.doctor.model.PractitionerModel;
import com.dg.doctor.service.MailService;
import com.dg.doctor.service.PractitionerService;
import com.dg.doctor.service.UserService;
import com.dg.doctor.model.CityModel;
import com.dg.doctor.model.StateModel;
import com.dg.doctor.model.UserModel;
import com.dg.doctor.model.PatientCaseMessagesModel;
import com.dg.doctor.form.ResetPasswordForm;
import com.dg.doctor.form.ResetPasswordFormValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PractitionerController {

	private static final Logger logger = LoggerFactory
			.getLogger(PractitionerController.class);

	@Autowired
	private PractitionerService practitionerService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ResourceLoader resource;
	
	@Autowired
	private ResetPasswordFormValidator validatorPassword;
	
	@ModelAttribute("userImage")
	public String getUserImage(){		
		 if(userService.isLoggedIn()){
			 PractitionerModel model = practitionerService.getPractitioner(userService.getCurrentUserId());
			 return practitionerService.getSearchUrlService().getUploadPath()+"/practitioner/"+model.getId()+"/photo/"+model.getPhoto();
		 }
		 return null;
	}	
	
	@ModelAttribute("userName")
	public String getUserName(){		
		 if(userService.isLoggedIn()){
			 PractitionerModel model = practitionerService.getPractitioner(userService.getCurrentUserId());
			 return model.getFirstName()+" "+model.getLastName();
		 }
		 return null;
	}	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home/profile", method = RequestMethod.GET)
	public String profile(Model model) {		 		 
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Object myuser = (auth != null) ? auth.getPrincipal() : null;		 
		 if(myuser instanceof UserModel){
		    	UserModel user = (UserModel)myuser;		    	
		    	model.addAttribute("practitioner",practitionerService.getPractitioner(user.getId()));
		    	model.addAttribute("countryList",practitionerService.getCountry());
		    	model.addAttribute("practitionertypeList",practitionerService.getPractitionerType());
		 }		 
		return "practitioner/profile"; 
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home/profile", method = RequestMethod.POST)
	public String updateProfile(@Valid PractitionerModel practitioner,BindingResult bindingResult,RedirectAttributes redirectAttributes,@RequestParam("file") MultipartFile file,Model model) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Object myuser = (auth != null) ? auth.getPrincipal() : null;
		 if(myuser instanceof UserModel){
		    	UserModel user = (UserModel)myuser;
		    	model.addAttribute("practitioner",practitionerService.getPractitioner(user.getId()));
			    model.addAttribute("practitionertypeList",practitionerService.getPractitionerType());
		    	if (bindingResult.hasErrors()) {    		  
		    	      logger.error("Got {} errors during save practitioner", bindingResult.getAllErrors());		    	      
		    	      return "practitioner/profile";
		    	} 	
		    	if(!file.isEmpty()){
		    		  try{
		    			  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					 	  Date date = new Date();
					 	  String now = dateFormat.format(date).toString();
					 	  String filename = practitionerService.getSHA1(FilenameUtils.removeExtension(file.getOriginalFilename())+now)+"."+FilenameUtils.getExtension(file.getOriginalFilename());
		    			  File fileDir = new File(practitionerService.getSearchUrlService().getUploadPath()+"/practitioner/"+user.getId()+"/photo/");
		    			  logger.info(fileDir.getAbsolutePath());
		    			  if(!fileDir.exists()){
		    				  if(fileDir.mkdirs()){
		    					  logger.info("Directory created");
		    					  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
		    					  file.transferTo(f);
		    				  }else{
		    					  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
		    					  file.transferTo(f);
		    				  }
		    			  }else{
		    				  File f = new File(fileDir.getAbsolutePath()+"/"+filename);
		    				  file.transferTo(f);
		    			  }		    			  
		    			  practitionerService.deleteFile(practitionerService.getSearchUrlService().getUploadPath()+"/practitioner/"+user.getId()+"/photo/"+practitioner.getPhoto());
		    			  practitioner.setPhoto(filename);		    			  
		    		  }catch(Exception ex){
		    			  logger.info(ex.getMessage());
		    		  }
		    	}
		    	Integer edited=practitionerService.editPractitioner(practitioner);
		    	if(edited > 0){
		    		redirectAttributes.addFlashAttribute("message", "1");				
		    		redirectAttributes.addFlashAttribute("success", "1");
		    		return "redirect:/home/profile";
		    	}						
		 }
		 return "practitioner/profile";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home/changepassword", method = RequestMethod.GET)
	public String changePassword(ResetPasswordForm resetPasswordForm,Model model) {		 		 
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Object myuser = (auth != null) ? auth.getPrincipal() : null;		 
		 if(myuser instanceof UserModel){
		    	UserModel user = (UserModel)myuser;
		    	model.addAttribute("practitioner",practitionerService.getPractitioner(user.getId()));
		    	PractitionerModel practitionerModel = practitionerService.getPractitioner(user.getId());
		    	resetPasswordForm.setId(practitionerModel.getId().intValue());
		    	resetPasswordForm.setOldPassword(practitionerModel.getPassword());
		 }		 
		return "practitioner/changepassword"; 
	}
	
	@RequestMapping(value = "/home/changepassword", method = RequestMethod.POST)
	public String changePasswordHandler(@Valid @ModelAttribute("resetPasswordForm") ResetPasswordForm resetPasswordForm,BindingResult bindingResult,Model model) {
		model.addAttribute("passworderror", 0);
		model.addAttribute("practitioner",practitionerService.getPractitioner(BigInteger.valueOf(resetPasswordForm.getId())));
		validatorPassword.validate(resetPasswordForm, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during practitioner change password",
			bindingResult.getErrorCount());
			logger.error("message {}",bindingResult.getAllErrors());
			return "practitioner/changepassword";
		}		
		if(resetPasswordForm.getId() != null && resetPasswordForm.getOldPassword() !=null){
			Integer id = practitionerService.resetPassword(resetPasswordForm.getId(),resetPasswordForm.getOldPassword(),resetPasswordForm.getNewPassword());
			if(id != 0){
				model.addAttribute("success", 1);
			}else{
				model.addAttribute("error", 1);
			}
		}
		return "practitioner/changepassword";
	}

	
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String index(@RequestParam(value = "error", required = false) Integer error,ForgotForm forgotForm, Model model) {
		model.addAttribute("error",error);
		return "practitioner/forgot";
	}
	
	/**
	 * Forgot Password Handler
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String forgothandler(@Valid ForgotForm forgotform,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,LoginForm loginform,Model model) {
		logger.info("authentication action called");
		model.addAttribute("loginerror", 1);
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during forgot password practitioner",
					bindingResult.getErrorCount());
			model.addAttribute("error", 1);
			return "practitioner/forgot";
		}
		
		PractitionerModel practitioner = practitionerService.getPractitionerByEmail(forgotform.getEmail());
		if(practitioner.getId() != null){		
			mailService.sendResetMail(forgotform.getEmail(), "Reset Password", "Please click below url to change your password.","reset.html",practitioner.getId().intValue(),practitioner.getFirstName(),practitioner.getPassword());
			model.addAttribute("emailaddress", forgotform.getEmail());
			model.addAttribute("error", 0);
		}else{
			model.addAttribute("error", 1);
		}
		return "practitioner/forgot";		
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	 public String reset(@RequestParam(value = "r", required = false) Integer id,@RequestParam(value = "p", required = false) String password,ResetPasswordForm resetform,Model model) {
		if(id != null){
			resetform.setId(id);
		}
		if(password != null){
			resetform.setOldPassword(password);
		}		
		model.addAttribute("resetform", resetform);
		return "practitioner/resetpassword";
	 }
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String resethandler(@Valid @ModelAttribute("resetform") ResetPasswordForm resetform,BindingResult bindingResult,Model model) {			
		model.addAttribute("resetform", resetform);
		model.addAttribute("passworderror", 0);
		validatorPassword.validate(resetform, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during patient reset forgot password",
			bindingResult.getErrorCount());
			logger.error("message {}",bindingResult.getAllErrors());
			return "practitioner/resetpassword";
		}		
		if(resetform.getId() != null && resetform.getOldPassword() !=null){
			Integer id = practitionerService.resetPassword(resetform.getId(),resetform.getOldPassword(),resetform.getNewPassword());
			if(id != 0){
				model.addAttribute("error", 0);
			}else{
				model.addAttribute("error", 1);
			}
		}
		return "practitioner/resetpassword";
	}
	
	@RequestMapping(value = "/totalnewmessage", method = RequestMethod.GET)
	public @ResponseBody Integer getTotalNewMessage(){
		Integer totalMessage = 0;
		if(practitionerService.isLoggedIn()){
			totalMessage = practitionerService.getTotalNewMessage(practitionerService.getCurrentUserId().intValue(),"Practitioner");
		}
		return totalMessage;
	}
	
	@RequestMapping(value = "/state/country/{country}", method = RequestMethod.GET)
	 public @ResponseBody List<StateModel> getStateByCountry(@PathVariable("country") int country){
	     return practitionerService.getStateByCountry(country);       
	 }    
	 
	 @RequestMapping(value = "/city/country/{country}", method = RequestMethod.GET)
	 public @ResponseBody List<CityModel> getCityByCountry(@PathVariable("country") int country){
	     return practitionerService.getCityByCountry(country);       
	 }    
	 
	 @RequestMapping(value = "/city/state/{state}", method = RequestMethod.GET)
	 public @ResponseBody List<CityModel> getCityByState(@PathVariable("state") int state){
	     return practitionerService.getCityByState(state);       
	 }    
	 
	 @RequestMapping(value = "/city/id/{id}", method = RequestMethod.GET)
	 public @ResponseBody CityModel getCityById(@PathVariable("id") int id){
	     return practitionerService.getCityById(id);       
	 }
}

