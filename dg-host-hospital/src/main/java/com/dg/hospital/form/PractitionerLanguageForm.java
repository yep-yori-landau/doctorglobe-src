package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import com.dg.hospital.model.form.PractitionerLanguageFormModel;

public class PractitionerLanguageForm{
	
	private BigInteger practitioner;
	
	private List<PractitionerLanguageFormModel> practitionerLanguageFormModel;
	
	public BigInteger getPractitioner(){
		return practitioner;
	}
	
	public void setPractitioner(BigInteger practitioner){
		this.practitioner = practitioner;
	}
	
	public List<PractitionerLanguageFormModel> getPractitionerLanguageFormModel(){
		return practitionerLanguageFormModel;
	}
	
	public void setPractitionerLanguageFormModel(List<PractitionerLanguageFormModel> practitionerLanguageFormModel){
		this.practitionerLanguageFormModel = practitionerLanguageFormModel;
	}	
	
}