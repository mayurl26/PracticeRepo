package com.nt.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeekerData implements Serializable{
	
	private Integer jsid;
	private String jsname;
	private String jsadd;
	private MultipartFile resumePath;
	private MultipartFile photoPath;

}
