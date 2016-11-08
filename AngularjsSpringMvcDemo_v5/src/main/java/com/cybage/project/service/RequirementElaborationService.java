package com.cybage.project.service;



import java.util.List;

import com.cybage.project.model.RequirementDTO;
import com.cybage.project.model.RequirementElaboration;

public interface RequirementElaborationService {
	
	Integer  saveRequirementElaboration(RequirementDTO dto,int requirementId);
	List<RequirementElaboration> getAllRequirementElaborations();

}
