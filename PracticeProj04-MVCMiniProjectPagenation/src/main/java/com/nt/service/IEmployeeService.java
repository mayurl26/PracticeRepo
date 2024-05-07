package com.nt.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.Model.Employee;


public interface IEmployeeService {

	public Page<Employee> getAllEmpDetails(Pageable page);
}
