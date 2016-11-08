package com.cybage.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the requirement_elaboration database table.
 * 
 */
@Entity
@Table(name="requirement_elaboration")
@NamedQuery(name="RequirementElaboration.findAll", query="SELECT r FROM RequirementElaboration r")
public class RequirementElaboration implements Serializable {
	private static final long serialVersionUID = 1L;
	private int elaborationId;
	private Timestamp created;
	private String elaboration;
	private Requirement requirement;
	private User user;

	public RequirementElaboration() {
	}


	public RequirementElaboration(Timestamp created, String elaboration) {
		super();
		this.created = created;
		this.elaboration = elaboration;
	}


	


	@Override
	public String toString() {
		return "RequirementElaboration [elaborationId=" + elaborationId + ", created=" + created + ", elaboration="
				+ elaboration + "]";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getElaborationId() {
		return this.elaborationId;
	}

	public void setElaborationId(int elaborationId) {
		this.elaborationId = elaborationId;
	}


	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}


	public String getElaboration() {
		return this.elaboration;
	}

	public void setElaboration(String elaboration) {
		this.elaboration = elaboration;
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