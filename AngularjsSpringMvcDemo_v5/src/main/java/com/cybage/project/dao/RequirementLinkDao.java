package com.cybage.project.dao;

import java.util.List;

import com.cybage.project.model.RequirementLink;

public interface RequirementLinkDao {
	  int saveRequirementLink(RequirementLink requirementLink,int requirementId);
	  List<RequirementLink> getAllRequirementLinks();
}
