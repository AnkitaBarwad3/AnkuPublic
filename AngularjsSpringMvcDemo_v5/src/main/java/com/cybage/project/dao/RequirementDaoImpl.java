package com.cybage.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cybage.project.model.Attachment;
import com.cybage.project.model.DtoToPojoConverter;
import com.cybage.project.model.Requirement;
import com.cybage.project.model.RequirementDTO;
import com.cybage.project.model.RequirementElaboration;
import com.cybage.project.model.RequirementLink;
import com.cybage.project.model.User;


/*
 * Indicates that an annotated class is a "Repository", originally defined by Domain-Driven Design (Evans, 2003) as
 * "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects".
 * @see     org.springframework.stereotype.Repository
 */
@Repository
public class RequirementDaoImpl implements RequirementDao {
	@Autowired
	private SessionFactory sf;
	@Autowired
	private DtoToPojoConverter dtoToPojoConverter;
		
		@Override
		public Requirement cancelRequirement(String name) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Requirement getRequirement(int id) {
			
			return (Requirement) sf.getCurrentSession()
			.createQuery("SELECT r FROM Requirement r where r.requirementId=:id")
			.setParameter("id", id).uniqueResult();
		}
		@Override
		public User getUser(String name) {
			
			return (User) sf.getCurrentSession()
					.createQuery("SELECT u FROM User u where u.userName=:nm")
					.setParameter("nm", name).uniqueResult();
		}
		@Override
		public int saveRequirement(RequirementDTO dto) {
			User u=getUser(dto.getUserName());
			/*u.addRequirements1(requirement);
			u.addRequirements2(requirement);
			u.addRequirements3(requirement);*/
			
			Requirement requirement=dtoToPojoConverter.toRequirement(dto);
			Attachment attachment=dtoToPojoConverter.toAttachment(dto);
			//RequirementElaboration requirementElaboration=dtoToPojoConverter.toRequirementElaboration(dto);
			//RequirementLink requirementLink=dtoToPojoConverter.toRequirementLink(dto);
			
			
			requirement.setUser1(u);
			requirement.setUser2(u);
			requirement.setUser3(u);
			
			List<Attachment> attachments=new ArrayList<>();
			attachments.add(attachment);
			requirement.setAttachments(attachments);
			attachment.setRequirement(requirement);
			attachment.setUser(u);
			
			
			List<RequirementElaboration> requirementElaborations=dtoToPojoConverter.toRequirementElaboration(dto);
			
			requirement.setRequirementElaborations(requirementElaborations);
			for (RequirementElaboration requirementElaboration : requirementElaborations) {
				requirementElaboration.setRequirement(requirement);
				requirementElaboration.setUser(u);

			}
			
			List<RequirementLink> requirementLinks=dtoToPojoConverter.toRequirementLink(dto);
			requirement.setRequirementLinks(requirementLinks);
			for (RequirementLink requirementLink : requirementLinks) {
				requirementLink.setRequirement(requirement);
				requirementLink.setUser(u);

			}
			
			
			
			
			System.out.println("in launchRequirement(RequirementDTO dto) "+requirement);
			
			return (int) sf.getCurrentSession().save( requirement);
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<Requirement> getAllRequirements() {
			
			return (List<Requirement>) sf.getCurrentSession()
					.createQuery("SELECT r FROM Requirement r where r.deleted=:status")
					.setParameter("status", "n").list();
		}
		
		
		
		
	


}
