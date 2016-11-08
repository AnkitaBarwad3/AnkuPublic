package com.cybage.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the requirement database table.
 * 
 */
@Entity
@NamedQuery(name="Requirement.findAll", query="SELECT r FROM Requirement r")
public class Requirement implements Serializable {
	private static final long serialVersionUID = 1L;
	private int requirementId;
	private Timestamp created;
	private String deleted;
	private String description;
	private Timestamp modifiedOn;
	private int parentRequirement;
	private String prerequisite;
	private String priority;
	private String shortTitle;
	private String status;
	private String title;
	private String type;
	private String version;
	private List<Attachment> attachments;
	private User user1;
	private User user2;
	private User user3;
	private List<RequirementElaboration> requirementElaborations;
	private List<RequirementHistory> requirementHistories;
	private List<RequirementLink> requirementLinks;

	public Requirement() {
	}


	public Requirement(Timestamp created, String deleted, String description, Timestamp modifiedOn,
			int parentRequirement, String prerequisite, String priority, String shortTitle, String status, String title,
			String type, String version) {
		super();
		this.created = created;
		this.deleted = deleted;
		this.description = description;
		this.modifiedOn = modifiedOn;
		this.parentRequirement = parentRequirement;
		this.prerequisite = prerequisite;
		this.priority = priority;
		this.shortTitle = shortTitle;
		this.status = status;
		this.title = title;
		this.type = type;
		this.version = version;
	}




	@Override
	public String toString() {
		return "Requirement [requirementId=" + requirementId + ", created=" + created + ", deleted=" + deleted
				+ ", description=" + description + ", modifiedOn=" + modifiedOn + ", parentRequirement="
				+ parentRequirement + ", prerequisite=" + prerequisite + ", priority=" + priority + ", shortTitle="
				+ shortTitle + ", status=" + status + ", title=" + title + ", type=" + type + ", version=" + version
				+ ", attachments=" + attachments + ", user1=" + user1 + ", user2=" + user2 + ", user3=" + user3
				+ ", requirementElaborations=" + requirementElaborations + ", requirementHistories="
				+ requirementHistories + ", requirementLinks=" + requirementLinks + "]";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRequirementId() {
		return this.requirementId;
	}

	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}


	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
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


	//bi-directional many-to-one association to Attachment
	@OneToMany(fetch = FetchType.EAGER,mappedBy="requirement", cascade={CascadeType.ALL})
	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Attachment addAttachment(Attachment attachment) {
		System.out.println("in Requirement() addAttachment(Attachment attachment)"+getAttachments());
		getAttachments().add(attachment);
		attachment.setRequirement(this);

		return attachment;
	}

	public Attachment removeAttachment(Attachment attachment) {
		getAttachments().remove(attachment);
		attachment.setRequirement(null);

		return attachment;
	}


	//bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="contributorId")
	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}


	//bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="createdBy")
	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}


	//bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="modifiedBy")
	public User getUser3() {
		return this.user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}


	//bi-directional many-to-one association to RequirementElaboration
	@OneToMany(fetch = FetchType.EAGER,mappedBy="requirement", cascade={CascadeType.ALL})
	public List<RequirementElaboration> getRequirementElaborations() {
		return this.requirementElaborations;
	}

	public void setRequirementElaborations(List<RequirementElaboration> requirementElaborations) {
		this.requirementElaborations = requirementElaborations;
	}

	public RequirementElaboration addRequirementElaboration(RequirementElaboration requirementElaboration) {
		getRequirementElaborations().add(requirementElaboration);
		requirementElaboration.setRequirement(this);

		return requirementElaboration;
	}

	public RequirementElaboration removeRequirementElaboration(RequirementElaboration requirementElaboration) {
		getRequirementElaborations().remove(requirementElaboration);
		requirementElaboration.setRequirement(null);

		return requirementElaboration;
	}


	//bi-directional many-to-one association to RequirementHistory
	@OneToMany(fetch = FetchType.EAGER,mappedBy="requirement", cascade={CascadeType.ALL})
	public List<RequirementHistory> getRequirementHistories() {
		return this.requirementHistories;
	}

	public void setRequirementHistories(List<RequirementHistory> requirementHistories) {
		this.requirementHistories = requirementHistories;
	}

	public RequirementHistory addRequirementHistory(RequirementHistory requirementHistory) {
		getRequirementHistories().add(requirementHistory);
		requirementHistory.setRequirement(this);

		return requirementHistory;
	}

	public RequirementHistory removeRequirementHistory(RequirementHistory requirementHistory) {
		getRequirementHistories().remove(requirementHistory);
		requirementHistory.setRequirement(null);

		return requirementHistory;
	}


	//bi-directional many-to-one association to RequirementLink
	@OneToMany(fetch = FetchType.EAGER,mappedBy="requirement", cascade={CascadeType.ALL})
	public List<RequirementLink> getRequirementLinks() {
		return this.requirementLinks;
	}

	public void setRequirementLinks(List<RequirementLink> requirementLinks) {
		this.requirementLinks = requirementLinks;
	}

	public RequirementLink addRequirementLink(RequirementLink requirementLink) {
		getRequirementLinks().add(requirementLink);
		requirementLink.setRequirement(this);

		return requirementLink;
	}

	public RequirementLink removeRequirementLink(RequirementLink requirementLink) {
		getRequirementLinks().remove(requirementLink);
		requirementLink.setRequirement(null);

		return requirementLink;
	}

}