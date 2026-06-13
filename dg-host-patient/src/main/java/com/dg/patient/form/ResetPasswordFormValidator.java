package com.dg.patient.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 * @author DoctorGlobe
 * 
 */
@Component("validatorPassword")
public class ResetPasswordFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return ResetPasswordForm.class.equals(obj);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ResetPasswordForm resetPasswordForm = (ResetPasswordForm) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"field.required");

		if (!resetPasswordForm.getNewPassword()
				.equals(resetPasswordForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "notmatch.password");
		}
		if (resetPasswordForm.getNewPassword().length() < 6) {
			errors.rejectValue("newPassword", "password.minsize");
		}
		if (!resetPasswordForm.getNewPassword()
				.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")) {
			errors.rejectValue("newPassword", "password.regexerror");
		}
		if (resetPasswordForm.getConfirmPassword().length() < 6) {
			errors.rejectValue("confirmPassword", "password.minsize");
		}
		if (!resetPasswordForm.getType().equalsIgnoreCase("a")
				&& !resetPasswordForm.getType().equalsIgnoreCase("p")) {
			errors.rejectValue("type", "user.undefined");
		}

	}

}