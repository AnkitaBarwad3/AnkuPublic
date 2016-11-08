package com.cybage.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.project.dao.AttachmentDao;
import com.cybage.project.dao.RequirementElaborationDao;
import com.cybage.project.model.DtoToPojoConverter;
import com.cybage.project.model.Requirement;
import com.cybage.project.model.RequirementDTO;
import com.cybage.project.model.RequirementElaboration;

/*
 * Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003) as 
 * "an operation offered as an interface that stands alone in the model, with no encapsulated state."
 * Describes transaction attributes on a method or class.
 * @see     org.springframework.stereotype.Service
 * @see     org.springframework.transaction.annotation.Transactional
 */
@Service
@Transactional 
public class RequirementElaborationServiceImpl implements RequirementElaborationService {
	
	/*
     * Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
     * @see      org.springframework.beans.factory.annotation.Autowired  
     */
	@Autowired
	private RequirementElaborationDao requirementElaborationDao;
	
	@Autowired
	private DtoToPojoConverter dtoToPojoConverter;
	
	@Override
	public Integer  saveRequirementElaboration(RequirementDTO dto,int requirementId){
		return null;

		//return requirementElaborationDao.saveRequirementElaboration(dtoToPojoConverter.toRequirementElaboration(dto),requirementId);
	}

	@Override
	public List<RequirementElaboration> getAllRequirementElaborations() {
		
		return requirementElaborationDao.getAllRequirementElaborations();
	}

	

}
