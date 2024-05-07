package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener{

	private long startTime, endTime;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.beforeJob()");
		 startTime=System.currentTimeMillis();
		System.out.println("job is about to start at :: "+new Date());
	} 
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.afterJob()");
		endTime=System.currentTimeMillis();
		System.out.println("Job Completion Time ::"+new Date());
		System.out.println("Total Time taken ::"+(endTime-startTime));
		System.out.println("job Completion Status ::"+jobExecution.getStatus());
	}
	

}
