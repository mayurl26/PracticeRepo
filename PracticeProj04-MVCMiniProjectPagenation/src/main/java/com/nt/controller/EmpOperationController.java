package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.Model.Employee;
import com.nt.service.IEmployeeService;

@Controller
public class EmpOperationController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String showWelcome() {
		System.out.println("EmpOperationController.showWelcome()");
		return "welcome";
		
	}
	
	@GetMapping("/All_page")
	public String showEmployeeReport(@PageableDefault(page = 0,size = 3, direction = Sort.Direction.ASC, sort = "job") Pageable pageable, Map<String,Object> map) {
		System.out.println("EmpOperationController.showEmployeeReport()");
		
		Page<Employee> page=service.getAllEmpDetails(pageable);
		map.put("EmpData", page);
		return "show_employee_info";
		
	}
	   
}
