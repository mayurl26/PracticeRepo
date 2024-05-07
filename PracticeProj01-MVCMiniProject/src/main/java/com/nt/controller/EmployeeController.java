package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.annotation.PostConstruct;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String getHomePage() {
		System.out.println("EmployeeController.getHomePage()");
		return "welcome";
	}
	@GetMapping("/show_emp")
	public String getAllEmp(Map<String,Object> map) {
		System.out.println("EmployeeController.getAllEmp()");	
		
	List<Employee> empList1=  service.getAllEmployee();
		
		map.put("empList", empList1);
		return "show_employee_info";
		
	}
	@GetMapping("/add_emp")
	public String getAddEmpPage(@ModelAttribute("emp") Employee emp) {
		return "add_emp_details";
	}
	
	@PostMapping("/add_emp")
	public String AddEmpDetails(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.AddEmpDetails()");
		String msg=service.addEmpDetails(emp);
		List<Employee> list=service.getAllEmployee();
		map.put("resultmsg", msg);
		map.put("resultList", list);
		return "redirect:show_emp";
	}
	
	@GetMapping("/edit")
	public String ediEmployee(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.ediEmployee()");
		Employee emp1= service.findEmpById(no);
		
		BeanUtils.copyProperties(emp1, emp);
		
		return "Show_editPage";
				
	}
	@PostMapping("/edit")
	public String editEmployeeDetails(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
		System.out.println("EmployeeController.editEmployeeDetails()");
		String msg= service.editEmployeeDetailsbyID(emp);
		
		attrs.addFlashAttribute("msges", msg);
		return "redirect:show_emp";
	}
	
	@GetMapping("/delete")
	public String deleteRecord(@RequestParam("no") int no,  RedirectAttributes attrs) {
		System.out.println("EmployeeController.deleteRecord()");
		
		String msg=service.deleteEmpRecord(no);
		attrs.addFlashAttribute("msges", msg);
		return "redirect:show_emp";
	}

}
