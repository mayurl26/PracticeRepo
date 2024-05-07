package com.nt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.Model.Employee;
import com.nt.repo.IEmployeePageRepository;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	public IEmployeePageRepository repo;
	
	@Override
	public Page<Employee> getAllEmpDetails(Pageable page) {
		return repo.findAll(page);
		
	}

}
