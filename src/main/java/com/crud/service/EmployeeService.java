package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entities.Employee;
import com.crud.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee e)
	{
		Employee save = this.employeeRepository.save(e);
		return save;
	}
	
	public List<Employee> getAllEmp()
	{
		List<Employee> findAll = this.employeeRepository.findAll();
		return findAll;
	}
	
	
	public Employee getEmp(int id)
	{
		Employee employee = this.employeeRepository.findById(id).get();
		return employee;
	}
	
	public void deleteEmp(int id)
	{
		this.employeeRepository.deleteById(id);
	}
	
	
	
}
