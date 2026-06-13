package com.dg.patient.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dg.patient.model.PatientModel;

@Component("profileValidator")
public class ProfileValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return PatientModel.class.equals(obj);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PatientModel registrationform = (PatientModel) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
				"field.required");

		if (registrationform.getTitle().length() > 100) {
			errors.rejectValue("title", "field.maxsize");
		}
		if (registrationform.getFirstName().length() < 3) {
			errors.rejectValue("firstName", "field.minsize");
		}
		if (registrationform.getLastName().length() < 3) {
			errors.rejectValue("lastName", "field.minsize");
		}
		if (registrationform.getFirstName().length() > 100) {
			errors.rejectValue("firstName", "field.maxsize");
		}
		if (registrationform.getLastName().length() > 100) {
			errors.rejectValue("lastName", "field.maxsize");
		}
		if (registrationform.getAddress().length() > 100) {
			errors.rejectValue("address", "field.maxsize");
		}
		if (registrationform.getPhone().length() > 30) {
			errors.rejectValue("phone", "field.maxsize");
		}
		if (registrationform.getZipCode().length() > 100) {
			errors.rejectValue("zipCode", "field.maxsize");
		}
		if (registrationform.getPhoto().length() > 100) {
			errors.rejectValue("photo", "field.maxsize");
		}

	}

}