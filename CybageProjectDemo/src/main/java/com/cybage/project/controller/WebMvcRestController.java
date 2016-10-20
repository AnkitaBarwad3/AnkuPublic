package com.cybage.project.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cybage.project.model.Employee;
import com.cybage.project.service.EmployeeService;
import com.cybage.project.model.EmployeeProfile;

@RestController
public class WebMvcRestController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/employees/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees();
	
		if(employees.isEmpty()){
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		System.out.println(employees);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	  @RequestMapping(value = "/employees/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + employee.getName());
	    	Set<EmployeeProfile> pro = new HashSet<>();
			EmployeeProfile eprof1 = new EmployeeProfile();
			eprof1.setType("ADMIN");
			pro.add(eprof1);
			employee.setEmployeeProfiles(pro);
	        employeeService.save(employee);
	        HttpHeaders headers = new HttpHeaders();
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	  

}
