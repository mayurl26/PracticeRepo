package com.nt.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMP")

public class Employee {
	
	@Column(length = 10)
	@Id
	private Integer empno;
	
	@Column(length = 20)
	private String ename;
	
	@Column(length = 20)
	private String job;
	
	@Column(length = 10)
	private Integer mgr;
	
	@Column
	private Float sal;
	
	@Column(length = 10)
	private Integer comm;
	
	@Column(length = 10)
	private Integer deptno;
	
	@Column
	private LocalDate hiredate;
	


}
