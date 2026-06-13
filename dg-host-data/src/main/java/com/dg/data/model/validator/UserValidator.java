package com.dg.data.model.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dg.data.model.db.User;

/**
 *
 * This UserValidator validates User instances
 * @author DoctorGlobe
 *
 */
@Component("userValidator")
public class UserValidator implements Validator {

	/**
	 * Class(Instance of) this validator supports to
	 * @param obj return boolean
	 */
	@Override
	public boolean supports(Class<?> obj) {
		return User.class.equals(obj);
	}

	/**
	 * Validate the Object and reports the validation error via Error Object
	 */
	@Override
	public void validate(Object target, Errors errors) {
		User model = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "active",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role",
				"field.required");

		if (model.getPassword().length() < 6) {
			errors.rejectValue("password", "password.minsize");
		}
		if (!model.getPassword()
				.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")) {
			errors.rejectValue("password", "password.regexerror");
		}

	}
}