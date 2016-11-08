package com.cybage.project.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cybage.project.model.Attachment;
import com.cybage.project.model.Requirement;
import com.cybage.project.model.User;


/*
 * Indicates that an annotated class is a "Repository", originally defined by Domain-Driven Design (Evans, 2003) as
 * "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects". 
 * @see     org.springframework.stereotype.Repository
 */
@Repository
public class AttachmentDaoImpl implements AttachmentDao {
	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private RequirementDaoImpl r;
		
	@Override
	public int saveAttachment(Attachment attachment,int requirementId) {
		User u=r.getUser("abhi");
		Requirement requirement= r.getRequirement(requirementId);
		u.addAttachment(attachment);
		requirement.addAttachment(attachment);
		return (int) sf.getCurrentSession().save( attachment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attachment> getAllAttachments() {
		return (List<Attachment>) sf.getCurrentSession()
				.createQuery("SELECT a FROM Attachment a ").list();
	}
}
