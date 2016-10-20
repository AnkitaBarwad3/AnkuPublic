package com.cybage.project.service;
 
import java.util.List;

import com.cybage.project.model.Employee;
 
 
public interface EmployeeService {
     
    Employee findById(int id);
    
    void save(Employee user);
     
    void deleteById(int id);
     
    List<Employee> findAllEmployees();
 
}