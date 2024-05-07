package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Employee;

public interface IEmployeeOperationRepo extends CrudRepository<Employee, Integer>{

}
