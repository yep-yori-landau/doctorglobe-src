package com.dg.data.model.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dg.data.model.db.ApiUser;
import com.dg.data.service.ApiUserService;

/**
 *
 * This ApiUserValidator validates ApiUser instances
 * @author DoctorGlobe
 *
 */
@Component("apiUserValidator")
public class ApiUserValidator implements Validator {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ApiUserValidator.class);
	
	@Autowired
	public ApiUserService apiUserService;	

	/**
	 * Class(Instance of) this validator supports to
	 * @param obj return boolean
	 */
	@Override
	public boolean supports(Class<?> obj) {
		return ApiUser.class.equals(obj);
	}

	/**
	 * Validate the Object and reports the validation error via Error Object
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ApiUser model = (ApiUser) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"field.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "active",
				"field.required");
		
		if(model.getId() != null){
			ApiUser apiUserModel = apiUserService.get(model.getId().intValue());
			logger.info("api user model user {}",apiUserModel.getUserName());
			if(!apiUserModel.getUserName().equalsIgnoreCase(model.getUserName())){
				ApiUser apiUser = apiUserService.findByUserName(model.getUserName());
				if(apiUser.getId() != null){
					errors.rejectValue("userName","username.already.exist");
				}
			}
		}else{
			ApiUser apiUser = apiUserService.findByUserName(model.getUserName());
			logger.info("api user model user {}",apiUser.getUserName());
			if(apiUser.getId() != null){
				errors.rejectValue("userName","username.already.exist");
			}
		}

		if (model.getPassword().length() < 6) {
			errors.rejectValue("password", "password.minsize");
		}
		if (!model.getPassword()
				.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")) {
			errors.rejectValue("password", "password.regexerror");
		}

	}
}