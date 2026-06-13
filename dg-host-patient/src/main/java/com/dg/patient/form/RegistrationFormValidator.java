package com.dg.patient.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("validatorUser")
public class RegistrationFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return RegistrationForm.class.equals(obj);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistrationForm registrationform = (RegistrationForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmEmail",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"field.required");
		if (registrationform.getFirstName().length() < 3) {
			errors.rejectValue("firstName", "field.minsize");
		}
		if (registrationform.getLastName().length() < 3) {
			errors.rejectValue("lastName", "field.minsize");
		}
		if (!registrationform.getEmail()
				.equals(registrationform.getConfirmEmail())) {
			errors.rejectValue("confirmEmail", "notmatch.email");
		}
		if (!registrationform.getPassword()
				.equals(registrationform.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "notmatch.password");
		}
		if (registrationform.getPassword().length() < 6) {
			errors.rejectValue("password", "password.minsize");
		}
		if (!registrationform.getPassword()
				.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")) {
			errors.rejectValue("password", "password.regexerror");
		}
		if (registrationform.getConfirmPassword().length() < 6) {
			errors.rejectValue("confirmPassword", "password.minsize");
		}

	}

}