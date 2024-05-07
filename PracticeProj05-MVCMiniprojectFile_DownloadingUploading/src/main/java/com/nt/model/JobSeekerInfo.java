package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "JobSeekers")
public class JobSeekerInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jsid;
	@Column
	private String jsname;
	@Column
	private String jsadd;
	@Column
	private String resumePath;
	@Column
	private String photoPath;
	

}
