package com.cybage.project.dao;

import java.util.List;

import com.cybage.project.model.EmployeeProfile;

public interface EmployeeProfileDao {
 
    List<EmployeeProfile> findAll();
     
    EmployeeProfile findByType(String type);
     
    EmployeeProfile findById(int id);
}