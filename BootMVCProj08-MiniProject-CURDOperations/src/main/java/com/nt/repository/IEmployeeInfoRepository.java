package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nt.Entity.EmployeeInfo;

public interface IEmployeeInfoRepository  extends JpaRepository<EmployeeInfo, Integer> {

}
