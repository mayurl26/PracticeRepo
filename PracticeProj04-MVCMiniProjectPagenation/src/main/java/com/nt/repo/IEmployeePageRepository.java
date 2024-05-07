package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nt.Model.Employee;

@Repository
public interface IEmployeePageRepository extends PagingAndSortingRepository<Employee, Integer>{
    
}
