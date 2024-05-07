package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeOperationRepo;

@Service
public class EmployeeManagementService implements IEmployeeService{
	
	@Autowired
	private IEmployeeOperationRepo repo;
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> listemp= (List<Employee>) repo.findAll();
		return listemp;
	}

	public Employee findEmpById(int no) {
		return repo.findById(no).orElseThrow(()-> new IllegalArgumentException("Invalid input type"));
		
	}
	
	@Override
	public String editEmployeeDetailsbyID(Employee emp) {
		Optional<Employee> opt=repo.findById(emp.getEmpid());
		if(opt.isPresent()) {
			int idVal=repo.save(emp).getEmpid();
			return  idVal+" employee details are updated";
		}
		return emp.getEmpid()+"  employee is not found";
		
		
	}
	
	@Override
	public String addEmpDetails(Employee emp) {
		repo.save(emp);
		return "Employee registered with EmpId :: "+emp.getEmpid();
	}
	
	@Override
	public String deleteEmpRecord(int no) {
		Optional<Employee> opt=repo.findById(no);
		if(opt.isPresent()) {
			repo.deleteById(no);
			return no+" Employee is deleted";
		}
		return  no+" Employee is not found for deletion";
	}
}
