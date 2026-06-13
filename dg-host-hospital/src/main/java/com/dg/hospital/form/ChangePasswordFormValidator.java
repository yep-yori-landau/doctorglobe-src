package com.dg.hospital.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("changePasswordFormValidator")
public class ChangePasswordFormValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> obj) {		
		return ChangePasswordForm.class.equals(obj);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ChangePasswordForm changePasswordForm = (ChangePasswordForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "field.required");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "field.required");
		if(!changePasswordForm.getNewPassword().equals(changePasswordForm.getConfirmPassword())){
			errors.rejectValue("confirmPassword", "notmatch.password");
		}
		if(changePasswordForm.getNewPassword().length() < 6){
			errors.rejectValue("newPassword", "password.minsize");
		}
		if(!changePasswordForm.getNewPassword().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")){
			errors.rejectValue("newPassword", "password.regexerror");
		}	
	}

}