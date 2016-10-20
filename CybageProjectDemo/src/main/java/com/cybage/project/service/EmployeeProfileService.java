package com.cybage.project.service;
 
import java.util.List;

import com.cybage.project.model.EmployeeProfile;
 
 
public interface EmployeeProfileService {
    List<EmployeeProfile> findAll();
    
    EmployeeProfile findByType(String type);
     
    EmployeeProfile findById(int id);
     
}