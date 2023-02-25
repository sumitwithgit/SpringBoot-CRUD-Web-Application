package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.entities.Employee;
import com.crud.helper.Message;
import com.crud.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> allEmp = this.employeeService.getAllEmp();
		
		m.addAttribute("emp", allEmp);
		return "index";
	}
	
	
	@GetMapping("/addEmp")	
	public String addEmployee(Model m)
	{
		m.addAttribute("emp", new Employee());
		return "add_emp_form";
	}
	
	
	@PostMapping("/addRecord")
	public String addRecordHandler(@ModelAttribute Employee emp,Model m,HttpSession session)
	{
		this.employeeService.addEmployee(emp);
		session.setAttribute("message", new Message("Employee Added Successfully","alert-success"));
		System.out.println(emp);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable("id") int id,Model m)
	{
		Employee emp = this.employeeService.getEmp(id);
		m.addAttribute("emp", emp);
		return "editRecord";
	}
	
	@PostMapping("/editRecord")
	public String editRecord(@ModelAttribute Employee emp,Model m,HttpSession session)
	{
		this.employeeService.addEmployee(emp);
		session.setAttribute("message", new Message("Employee Updated Successfully","alert-success"));
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable("id") int id,HttpSession session)
	{
		this.employeeService.deleteEmp(id);
		session.setAttribute("message", new Message("Employee Deleted Successfully","alert-success"));
		return "redirect:/";
	}
	
}
