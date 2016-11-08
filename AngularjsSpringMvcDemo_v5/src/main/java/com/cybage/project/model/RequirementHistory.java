package com.cybage.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the requirement_history database table.
 * 
 */
@Entity
@Table(name="requirement_history")
@NamedQuery(name="RequirementHistory.findAll", query="SELECT r FROM RequirementHistory r")
public class RequirementHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int historyId;
	private int contributorId;
	private Timestamp created;
	private int createdBy;
	private String deleted;
	private String description;
	private Timestamp modified_On;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int parentRequirement;
	private String prerequisite;
	private String priority;
	private String shortTitle;
	private String status;
	private String title;
	private String type;
	private String version;
	private User user;
	private Requirement requirement;

	public RequirementHistory() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}


	public int getContributorId() {
		return this.contributorId;
	}

	public void setContributorId(int contributorId) {
		this.contributorId = contributorId;
	}


	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}


	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public String getDeleted() {
		return this.deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Timestamp getModified_On() {
		return this.modified_On;
	}

	public void setModified_On(Timestamp modified_On) {
		this.modified_On = modified_On;
	}


	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Timestamp getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public int getParentRequirement() {
		return this.parentRequirement;
	}

	public void setParentRequirement(int parentRequirement) {
		this.parentRequirement = parentRequirement;
	}


	public String getPrerequisite() {
		return this.prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}


	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getShortTitle() {
		return this.shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modified_By")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

}