package com.cybage.project.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cybage.project.model.Requirement;
import com.cybage.project.model.RequirementElaboration;
import com.cybage.project.model.User;

/*
 * Indicates that an annotated class is a "Repository", originally defined by Domain-Driven Design (Evans, 2003) as
 * "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects".
 * @see     org.springframework.stereotype.Repository
 */
@Repository
public class RequirementElaborationDaoImpl implements RequirementElaborationDao {
	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private RequirementDaoImpl r;
	
	@Override
	public int saveRequirementElaboration(RequirementElaboration requirementElaboration,int requirementId) {
		User u=r.getUser("abhi");
		Requirement requirement= r.getRequirement(requirementId);
		u.addRequirementElaboration(requirementElaboration);
		requirement.addRequirementElaboration(requirementElaboration);
		return (int) sf.getCurrentSession().save( requirementElaboration);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequirementElaboration> getAllRequirementElaborations() {
		return (List<RequirementElaboration>) sf.getCurrentSession()
				.createQuery("SELECT r FROM RequirementElaboration r" ).list();
	}
}
