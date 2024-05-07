package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;
@Component
public class EmployeeInfoItemProcessor implements ItemProcessor<Employee, Employee>{
	
	
	@Override
	public Employee process(Employee item) throws Exception {
	  if(item.getSalary()>=100000) {
		  item.setGrossSalary( (float) Math.round(item.getSalary()+item.getSalary()*0.4f));
		    item.setNetSalary( (float) Math.round(item.getGrossSalary()-item.getGrossSalary()*.2f));
		    return item;
	  }
	  else {
		  return null;
	  }
	}

}
