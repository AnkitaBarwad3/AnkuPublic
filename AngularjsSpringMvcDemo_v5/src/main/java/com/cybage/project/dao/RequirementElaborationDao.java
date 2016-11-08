package com.cybage.project.dao;

import java.util.List;

import com.cybage.project.model.RequirementElaboration;

public interface RequirementElaborationDao {
	  int saveRequirementElaboration(RequirementElaboration requirementElaboration,int requirementId);
		List<RequirementElaboration> getAllRequirementElaborations();

}
