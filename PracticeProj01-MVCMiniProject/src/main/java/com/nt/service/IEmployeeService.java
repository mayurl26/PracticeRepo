package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.model.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmployee();
	public String addEmpDetails(Employee emp);
	public String editEmployeeDetailsbyID(Employee emp);
	public Employee findEmpById(int no);
	
	public String deleteEmpRecord(int no);
	
}
