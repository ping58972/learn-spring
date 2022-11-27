package com.ping.spingboot.thymleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ping.spingboot.thymleafdemo.entity.Employee;
import com.ping.spingboot.thymleafdemo.service.EmployeeService;

//import com.ping.spingboot.thymleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	
	
	//load employee data
	//private List<Employee> thEmployees;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}



	//@PostConstruct
//	private void loadData() {
//		//create employees
//		Employee emp1 = new Employee(1, "Ping", "Wang", "ping@wang.com");
//		Employee emp2 = new Employee(2, "Pink", "Danddank", "dd@wang.com");
//		Employee emp3 = new Employee(3, "Ming", "King", "ming@wang.com");
//		//create the list
//		thEmployees = new ArrayList<>();
//		
//		//add to the list
//		thEmployees.add(emp1);
//		thEmployees.add(emp2);
//		thEmployees.add(emp3);
//	}
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		//get employees from database
		List<Employee> thEmployees = employeeService.findAll();
		//add to the spring model
		theModel.addAttribute("employees", thEmployees);
		return "/employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create model attribute to bind form data
		Employee thEmployee = new Employee();
		theModel.addAttribute("employee", thEmployee);
		return "/employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee thEmployee) {
		// save the employee
		employeeService.save(thEmployee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
}
