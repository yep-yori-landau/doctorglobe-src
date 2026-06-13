package com.dg.patient.exception;

public class ApiException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	private Integer code;
	
	public ApiException(String message,Integer code){
		super(message);
		this.message = message;
		this.code = code;
	}
	
	public String getMessage(){
		return message;
	}
	
	public Integer getCode(){
		return code;
	}
}