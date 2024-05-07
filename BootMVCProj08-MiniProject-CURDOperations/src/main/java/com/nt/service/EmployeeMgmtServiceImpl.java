package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.EmployeeInfo;
import com.nt.repository.IEmployeeInfoRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeInfoRepository  empRepo;

	@Override
	public List<EmployeeInfo> getAllEmployees() {
		//use Repo
		List<EmployeeInfo>  list=empRepo.findAll();
		return list;
	}

	@Override
	public String addEmployee(EmployeeInfo emp) {
		//use repo
		  Integer idVal=empRepo.save(emp).getEmpno();
		return "Employee is registered with the IdValue::"+idVal;
	}

	@Override
	public EmployeeInfo findEmployeeByEno(int eno) {
		
		return  empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException("invalid id"));
	}

	@Override
	public String updateEmployee(EmployeeInfo emp) {
		Optional<EmployeeInfo> opt=empRepo.findById(emp.getEmpno());
		if(opt.isPresent()) {
			int idVal=empRepo.save(emp).getEmpno();
			return  idVal+" employee details are updated";
		}
		return emp.getEmpno()+"  employee is not found";
	}

	@Override
	public String deleteEmployee(int no) {
		Optional<EmployeeInfo> opt=empRepo.findById(no);
		if(opt.isPresent()) {
			empRepo.deleteById(no);
			return no+" Employee is deleted";
		}
		return  no+" Employee is not found for deletion";
	}

}
