package com.cybage.project.dao;

import java.util.List;

import com.cybage.project.model.Attachment;
import com.cybage.project.model.Requirement;
import com.cybage.project.model.RequirementDTO;
import com.cybage.project.model.RequirementElaboration;
import com.cybage.project.model.RequirementLink;
import com.cybage.project.model.User;

public interface RequirementDao {
 
  Requirement cancelRequirement(String name);
  Requirement getRequirement(int id);
  User getUser(String name);
  int saveRequirement(RequirementDTO dto);
  List<Requirement> getAllRequirements();

}
