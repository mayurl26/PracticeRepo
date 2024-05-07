package com.nt.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EMPINFO")
@SQLDelete(sql = "update EMPINFO set status='deleted' where empid=?")
@Where(clause = "status <>   'deleted'")
public class Employee {
	
	@Id
	@GeneratedValue(generator = "gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "EMPLOYEE_INFO_SEQUENCE", initialValue = 1, allocationSize = 1)
	private Integer empid;
	
	@Column(name = "ename", length = 20)
	private String ename;
	
	@Column(name = "salary", length = 20)
	private String salary;
	
	@Column(name = "job", length = 20)
	private String job;
	
	@Column(name = "dept", length = 20)
	private String dept;
	
	@Column(name = "status", length = 20)
	private String status="active";
	

}
