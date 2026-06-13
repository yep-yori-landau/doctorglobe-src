package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import com.dg.hospital.model.form.*;

public class PractitionerAttestationsForm{
	
	private BigInteger practitioner;
	
	private List<PractitionerAttestationsFormModel> practitionerAttestationsFormModel;
	
	public BigInteger getPractitioner(){
		return practitioner;
	}
	
	public void setPractitioner(BigInteger practitioner){
		this.practitioner = practitioner;
	}
	
	public List<PractitionerAttestationsFormModel> getPractitionerAttestationsFormModel(){
		return practitionerAttestationsFormModel;
	}
	
	public void setPractitionerAttestationsFormModel(List<PractitionerAttestationsFormModel> practitionerAttestationsFormModel){
		this.practitionerAttestationsFormModel = practitionerAttestationsFormModel;
	}
}