package com.cybage.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cybage.project.dao.RequirementDao;
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
public class RequirementServiceImpl implements RequirementService {

	/*
     * Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
     * @see      org.springframework.beans.factory.annotation.Autowired  
     */
	@Autowired
	private RequirementDao requirementDao;

	@Autowired
	private DtoToPojoConverter dtoToPojoConverter;


	@Override
	public Integer saveRequirement(RequirementDTO dto) {

		int requirementId=requirementDao.saveRequirement(dto);

		return requirementId;
	}


	@Override
	public List<Requirement> getAllRequirements() {
		List<Requirement> requirements= requirementDao.getAllRequirements();
		/*for (Requirement requirement : requirements) {
			System.out.println(requirement);
		}*/
		return requirements;
	}


}
