package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.web.OffsetScrollPositionArgumentResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.nt.model.JobSeekerData;
import com.nt.model.JobSeekerInfo;
import com.nt.service.IJobSeekerMgmtService;

@Controller
public class JobSeekerOperationController {

	@Autowired
	private IJobSeekerMgmtService service;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("JobSeekerOperationController.showHomePage()");
		return "welcome";
	}
	
	
	
	@GetMapping("/register")
	public String  registerJS(@ModelAttribute("info") JobSeekerData info) {
		 System.out.println("JobSeekerOperationController.registerJS()");
		 return "/register_Js";
	}
	
	@PostMapping("/register")
	public String registerJsByUploadId(@ModelAttribute("info") JobSeekerData info, Map<String,Object> map) throws IOException {
		System.out.println("JobSeekerOperationController.registerJsByUploadId()");
		
		String storeLocation=env.getRequiredProperty("upload.store");
		File file= new File(storeLocation);
		
		if(!file.exists())
			file.mkdir();
				
		MultipartFile resumeFile= info.getResumePath();
		MultipartFile photoFile= info.getPhotoPath();
		InputStream isResume=resumeFile.getInputStream();
		InputStream isPhoto=photoFile.getInputStream();
		
		String resumeFileName=resumeFile.getOriginalFilename();
		String photoFileName=photoFile.getOriginalFilename();
		
		OutputStream osRsume=new FileOutputStream(file.getAbsolutePath()+"\\"+resumeFileName);
		OutputStream osPhoto= new FileOutputStream(file.getAbsolutePath()+"\\"+photoFileName);
		
		IOUtils.copy(isPhoto, osPhoto);
		IOUtils.copy(isResume, osRsume);
		
		isResume.close();
	    osRsume.close();
	    isPhoto.close();
	    osPhoto.close();
	    
	    JobSeekerInfo jsInfo= new JobSeekerInfo();
	    jsInfo.setJsadd(info.getJsadd());
	    jsInfo.setJsname(info.getJsname());
	    jsInfo.setPhotoPath(file.getAbsolutePath()+"/"+photoFileName );
	    jsInfo.setResumePath(file.getAbsolutePath()+"/"+resumeFileName);
	    
	    String msg=service.registerJobSeeker(jsInfo);
	    
	    map.put("file1", photoFileName);
	    map.put("file2", resumeFileName);
	    map.put("jsmsg", msg);
		
	    return "show_result";
	}
	
	@GetMapping("/show")
	public String getJobSeekerData(Map<String,Object> map ) {
		System.out.println("JobSeekerOperationController.getJobSeekerData()");
	     List<JobSeekerInfo> data= service.getAllData();
	     
	     map.put("allData", data);
	     return "download_job";
		
	}
	
}
