package com.cybage.project.service;

import java.util.List;

import com.cybage.project.model.RequirementDTO;
import com.cybage.project.model.RequirementLink;

public interface RequirementLinkService {
	Integer  saveRequirementLink(RequirementDTO dto,int requirementId);
	  List<RequirementLink> getAllRequirementLinks();

}
