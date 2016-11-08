package com.cybage.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.project.dao.AttachmentDao;
import com.cybage.project.model.Attachment;
import com.cybage.project.model.DtoToPojoConverter;
import com.cybage.project.model.RequirementDTO;

/*
 * Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003) as 
 * "an operation offered as an interface that stands alone in the model, with no encapsulated state."
 * Describes transaction attributes on a method or class.
 * @see     org.springframework.stereotype.Service
 * @see     org.springframework.transaction.annotation.Transactional
 */
@Service
@Transactional 
public class AttachmentServiceImpl implements AttachmentService {
	
	/*
     * Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
     * @see      org.springframework.beans.factory.annotation.Autowired  
     */
	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private DtoToPojoConverter dtoToPojoConverter;
	
	@Override
	public Integer saveAttachment(RequirementDTO dto,int requirementId) {
		return null;
		//return attachmentDao.saveAttachment(dtoToPojoConverter.toAttachment(dto),requirementId);
	}

	@Override
	public List<Attachment> getAllAttachments() {
		
		return attachmentDao.getAllAttachments();
	}

}
