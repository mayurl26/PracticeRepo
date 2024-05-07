package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "dept")
@Entity
public class Dept {
	@Id
	private String dept;
	
	private String dname;
	private String loc;

}
