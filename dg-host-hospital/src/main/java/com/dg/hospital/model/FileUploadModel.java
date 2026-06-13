package com.dg.hospital.model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileUploadModel{
	
	private MultipartFile file;
	
	public MultipartFile getFile(){
		return file;
	}
	
	public void setFile(MultipartFile file){
		this.file = file;
	}
}