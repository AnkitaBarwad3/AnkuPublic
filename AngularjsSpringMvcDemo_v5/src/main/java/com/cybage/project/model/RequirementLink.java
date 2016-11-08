package com.cybage.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the requirement_links database table.
 * 
 */
@Entity
@Table(name="requirement_links")
@NamedQuery(name="RequirementLink.findAll", query="SELECT r FROM RequirementLink r")
public class RequirementLink implements Serializable {
	private static final long serialVersionUID = 1L;
	private int linkId;
	private Timestamp addingTime;
	private String links;
	private Requirement requirement;
	private User user;

	public RequirementLink() {
	}


	public RequirementLink(Timestamp addingTime, String links) {
		super();
		this.addingTime = addingTime;
		this.links = links;
	}





	@Override
	public String toString() {
		return "RequirementLink [linkId=" + linkId + ", addingTime=" + addingTime + ", links=" + links + "]";
	}

	 //Specifies the primary key of an entity
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLinkId() {
		return this.linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}


	public Timestamp getAddingTime() {
		return this.addingTime;
	}

	public void setAddingTime(Timestamp addingTime) {
		this.addingTime = addingTime;
	}


	public String getLinks() {
		return this.links;
	}

	public void setLinks(String links) {
		this.links = links;
	}


	//bi-directional many-to-one association to Requirement
	@ManyToOne
	@JoinColumn(name="requirementId")
	public Requirement getRequirement() {
		return this.requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}