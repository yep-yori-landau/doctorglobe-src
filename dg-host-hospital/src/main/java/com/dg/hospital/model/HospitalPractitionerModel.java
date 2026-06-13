package com.dg.hospital.model;

import java.math.BigInteger;

public class HospitalPractitionerModel{

	private BigInteger id;
	
	private String title;
	
	private String name;
	
	private String email;
	
	private String degree;	
	
	private BigInteger specialty_id;
	
	private String specialty_name;
	
	private BigInteger treatment_id;
	
	private String treatment_name;
	
	private BigInteger method_id;
	
	private String method_name;
	
	private BigInteger hstmp;
	
	private BigInteger hstm;
	
	private Boolean active;
	
	private String specialty_class;
	
	private String treatment_class;	
	
	public BigInteger getId(){
		return id;
	}
	
	public void setId(BigInteger id){
		this.id = id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}	

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getDegree(){
		return degree;
	}
	
	public void setDegree(String degree){
		this.degree = degree;
	}	
	
	public BigInteger getSpecialtyId(){
		return specialty_id;
	}
	
	public void setSpecialtyId(BigInteger specialty_id){
		this.specialty_id = specialty_id;
	}
	
	public String getSpecialtyName(){
		return specialty_name;
	}
	
	public void setSpecialtyName(String specialty_name){
		this.specialty_name = specialty_name;
	}
	
	public BigInteger getTreatmentId(){
		return treatment_id;
	}
	
	public void setTreatmentId(BigInteger treatment_id){
		this.treatment_id = treatment_id;
	}
	
	public String getTreatmentName(){
		return treatment_name;
	}
	
	public void setTreatmentName(String treatment_name){
		this.treatment_name = treatment_name;
	}
	
	public BigInteger getMethodId(){
		return method_id;
	}
	
	public void setMethodId(BigInteger method_id){
		this.method_id = method_id;
	}
	
	public String getMethodName(){
		return method_name;
	}
	
	public void setMethodName(String method_name){
		this.method_name = method_name;
	}
	
	public BigInteger getHstmp(){
		return hstmp;
	}
	
	public void setHstmp(BigInteger hstmp){
		this.hstmp = hstmp;
	}
	
	public BigInteger getHstm(){
		return hstm;
	}
	
	public void setHstm(BigInteger hstm){
		this.hstm = hstm;
	}
	
	public Boolean getActive(){
		return active;
	}
	
	public void setActive(Boolean active){
		this.active = active;
	}
	
	public String getSpecialtyClass(){
		return specialty_class;
	}
	
	public void setSpecialtyClass(String specialty_class){
		this.specialty_class = specialty_class;
	}
	
	public String getTreatmentClass(){
		return treatment_class;
	}
	
	public void setTreatmentClass(String treatment_class){
		this.treatment_class = treatment_class;
	}	
}