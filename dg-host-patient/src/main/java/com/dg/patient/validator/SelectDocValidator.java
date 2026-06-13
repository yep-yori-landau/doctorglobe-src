package com.dg.patient.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.dg.patient.form.SelectDoctorForm;

@Component("selectdocValidator")
public class SelectDocValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return SelectDoctorForm.class.equals(obj);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SelectDoctorForm selectDoctorForm = (SelectDoctorForm) target;
		
	}

}