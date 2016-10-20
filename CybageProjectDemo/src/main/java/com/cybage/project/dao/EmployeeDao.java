package com.cybage.project.dao;
import java.util.List;

import com.cybage.project.model.Employee;
 
 
public interface EmployeeDao {
 
    Employee findById(int id);
          
    void save(Employee user);
     
    void deleteById(int id);
     
    List<Employee> findAllEmployees();
 
}