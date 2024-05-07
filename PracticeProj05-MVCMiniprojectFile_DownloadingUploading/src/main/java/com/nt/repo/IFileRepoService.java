package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.JobSeekerInfo;

@Repository
public interface IFileRepoService extends JpaRepository<JobSeekerInfo, Integer>{

}
