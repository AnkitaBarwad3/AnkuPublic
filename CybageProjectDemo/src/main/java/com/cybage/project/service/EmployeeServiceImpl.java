package com.cybage.project.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.project.dao.EmployeeDao;
import com.cybage.project.model.Employee;
 
 
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
 
    @Autowired
    private EmployeeDao dao;
 
     
	@Override
	public Employee findById(int id) {
		 return dao.findById(id);
	}

	@Override
	public void save(Employee user) {
	        dao.save(user);		
	}

	@Override
	public void deleteById(int id) {
	dao.deleteById(id);		
	}

	@Override
	public List<Employee> findAllEmployees() {
	     return dao.findAllEmployees();
	}
     
}