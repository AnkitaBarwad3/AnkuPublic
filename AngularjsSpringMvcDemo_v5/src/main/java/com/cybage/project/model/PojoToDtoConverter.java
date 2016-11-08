package com.cybage.project.model;


import java.util.ArrayList;


public class PojoToDtoConverter {

	public PojoToDtoConverter() {
		
	}
	
	public RequirementDTO toRequirementDTO(Requirement requirement)
	{
		
		
		byte[] attachments = null;
		ArrayList<String> elaborations=new ArrayList<>();
		ArrayList<String> links=new ArrayList<>();
		
		for (Attachment attachment : requirement.getAttachments()) {
			attachments=attachment.getAttachment();
			
		}
		for (RequirementElaboration requirementElaboration : requirement.getRequirementElaborations()) {
			elaborations.add(requirementElaboration.getElaboration());
			
		}
		for (RequirementLink requirementLink : requirement.getRequirementLinks()) {
			links.add(requirementLink.getLinks());
			
		}
		
		
		
		return new RequirementDTO(requirement.getRequirementId(), requirement.getDescription(),
				requirement.getPrerequisite(), requirement.getPriority(), requirement.getPriority(), requirement.getStatus(),
				requirement.getTitle(), requirement.getTitle(), requirement.getVersion(), attachments, elaborations, links);
	}

}
