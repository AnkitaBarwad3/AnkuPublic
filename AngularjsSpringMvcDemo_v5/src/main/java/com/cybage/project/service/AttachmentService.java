package com.cybage.project.service;

import java.util.List;

import com.cybage.project.model.Attachment;
import com.cybage.project.model.RequirementDTO;

public interface AttachmentService {

	Integer saveAttachment(RequirementDTO dto,int requirementId);
	List<Attachment> getAllAttachments();
}
