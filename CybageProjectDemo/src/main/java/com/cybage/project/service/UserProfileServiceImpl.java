package com.cybage.project.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.project.dao.EmployeeProfileDao;
import com.cybage.project.model.EmployeeProfile;
 
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements EmployeeProfileService{
     
    @Autowired
    EmployeeProfileDao dao;
     
    public EmployeeProfile findById(int id) {
        return dao.findById(id);
    }
 
    public EmployeeProfile findByType(String type){
        return dao.findByType(type);
    }
 
    public List<EmployeeProfile> findAll() {
        return dao.findAll();
    }
}