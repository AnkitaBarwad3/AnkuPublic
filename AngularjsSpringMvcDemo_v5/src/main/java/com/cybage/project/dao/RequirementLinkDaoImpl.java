package com.cybage.project.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cybage.project.model.Requirement;
import com.cybage.project.model.RequirementLink;
import com.cybage.project.model.User;

/*
 * convenience annotation that adds the @Controller and @ResponseBody annotations.
 * @see     org.springframework.web.bind.annotation.RestController
 */
@Repository
public class RequirementLinkDaoImpl implements RequirementLinkDao {
	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private RequirementDaoImpl r;
	
	@Override
	public int saveRequirementLink(RequirementLink requirementLink,int requirementId) {
		User u=r.getUser("abhi");
		Requirement requirement= r.getRequirement(requirementId);
		u.addRequirementLink(requirementLink);
		requirement.addRequirementLink(requirementLink);
		return (int) sf.getCurrentSession().save( requirementLink);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequirementLink> getAllRequirementLinks() {
		return (List<RequirementLink>) sf.getCurrentSession()
				.createQuery("SELECT r FROM Requirement r").list();
	}
}
