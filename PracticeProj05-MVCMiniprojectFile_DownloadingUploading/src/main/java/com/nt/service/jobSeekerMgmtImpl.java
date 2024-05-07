package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.JobSeekerInfo;
import com.nt.repo.IFileRepoService;

@Service
public class jobSeekerMgmtImpl implements IJobSeekerMgmtService{
	
	@Autowired
	private IFileRepoService repo;
	
	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		return "Job seeker Data saved:: "+repo.save(info).getJsid();
	}
	
	@Override
	public List<JobSeekerInfo> getAllData() {
		
		return repo.findAll();
	}

}
