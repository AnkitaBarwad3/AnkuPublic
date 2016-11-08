package com.cybage.project.service;

import java.util.List;

import com.cybage.project.model.Requirement;
import com.cybage.project.model.RequirementDTO;

public interface RequirementService {
	Integer saveRequirement(RequirementDTO dto) ;
	List<Requirement> getAllRequirements();

}
