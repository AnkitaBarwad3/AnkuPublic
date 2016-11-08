package com.cybage.project.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cybage.project.model.Attachment;
import com.cybage.project.model.Requirement;
import com.cybage.project.model.RequirementDTO;
import com.cybage.project.model.RequirementElaboration;
import com.cybage.project.model.RequirementLink;

public class DtoToPojoConverter {
	
	
	
	public DtoToPojoConverter() {
		
	}
	public Requirement toRequirement(RequirementDTO dto)
	{
		return new Requirement(new Timestamp(new Date().getTime()),"n",dto.getDescription(),
				new Timestamp(new Date().getTime()),1,
				dto.getPrerequisite(),dto.getPriority(),dto.getShortTitle(),dto.getStatus(),dto.getTitle(),
				dto.getType(),dto.getVersion());
	}
	public Attachment toAttachment(RequirementDTO dto)
	{
		
		return new Attachment(new Timestamp(new Date().getTime()),dto.getAttachments());
		
	}
	
	public List<RequirementElaboration> toRequirementElaboration(RequirementDTO dto)
	{
		List<RequirementElaboration> requirementElaborations=new ArrayList<>();
		for (String requirementElaboration : dto.getElaborations()) {
			
	    requirementElaborations.add(new RequirementElaboration(new Timestamp(new Date().getTime()),requirementElaboration));
			
		}
		return requirementElaborations;
	}
	
	public List<RequirementLink> toRequirementLink(RequirementDTO dto)
	{
		List<RequirementLink> requirementLinks=new ArrayList<>();
		for (String requirementLink : dto.getLinks()) {
			
			requirementLinks.add(new RequirementLink(new Timestamp(new Date().getTime()),requirementLink));
					
				}
		
		return requirementLinks;
	}
}
