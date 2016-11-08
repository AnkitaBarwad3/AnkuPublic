package com.cybage.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String password;
	private String role;
	private String userName;
	private List<Attachment> attachments;
	private List<Requirement> requirements1;
	private List<Requirement> requirements2;
	private List<Requirement> requirements3;
	private List<RequirementElaboration> requirementElaborations;
	private List<RequirementHistory> requirementHistories;
	private List<RequirementLink> requirementLinks;

	public User() {
	}


	public User(String password, String role, String userName) {
		super();
		this.password = password;
		this.role = role;
		this.userName = userName;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", userName=" + userName + "]";
	}

	 //Specifies the primary key of an entity
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	//bi-directional many-to-one association to Attachment
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Attachment addAttachment(Attachment attachment) {
		System.out.println("in user() addAttachment(Attachment attachment) "+getAttachments());
		getAttachments().add(attachment);
		attachment.setUser(this);

		return attachment;
	}

	public Attachment removeAttachment(Attachment attachment) {
		getAttachments().remove(attachment);
		attachment.setUser(null);

		return attachment;
	}


	//bi-directional many-to-one association to Requirement
	@OneToMany(mappedBy="user1", cascade={CascadeType.ALL})
	public List<Requirement> getRequirements1() {
		return this.requirements1;
	}

	public void setRequirements1(List<Requirement> requirements1) {
		this.requirements1 = requirements1;
	}

	public Requirement addRequirements1(Requirement requirements1) {
		System.out.println("in user() addRequirements1(Requirement requirements1) "+getRequirements1());
		getRequirements1().add(requirements1);
		requirements1.setUser1(this);

		return requirements1;
	}

	public Requirement removeRequirements1(Requirement requirements1) {
		getRequirements1().remove(requirements1);
		requirements1.setUser1(null);

		return requirements1;
	}


	//bi-directional many-to-one association to Requirement
	@OneToMany(mappedBy="user2", cascade={CascadeType.ALL})
	public List<Requirement> getRequirements2() {
		return this.requirements2;
	}

	public void setRequirements2(List<Requirement> requirements2) {
		this.requirements2 = requirements2;
	}

	public Requirement addRequirements2(Requirement requirements2) {
		getRequirements2().add(requirements2);
		requirements2.setUser2(this);

		return requirements2;
	}

	public Requirement removeRequirements2(Requirement requirements2) {
		getRequirements2().remove(requirements2);
		requirements2.setUser2(null);

		return requirements2;
	}


	//bi-directional many-to-one association to Requirement
	@OneToMany(mappedBy="user3", cascade={CascadeType.ALL})
	public List<Requirement> getRequirements3() {
		return this.requirements3;
	}

	public void setRequirements3(List<Requirement> requirements3) {
		this.requirements3 = requirements3;
	}

	public Requirement addRequirements3(Requirement requirements3) {
		getRequirements3().add(requirements3);
		requirements3.setUser3(this);

		return requirements3;
	}

	public Requirement removeRequirements3(Requirement requirements3) {
		getRequirements3().remove(requirements3);
		requirements3.setUser3(null);

		return requirements3;
	}


	//bi-directional many-to-one association to RequirementElaboration
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	public List<RequirementElaboration> getRequirementElaborations() {
		return this.requirementElaborations;
	}

	public void setRequirementElaborations(List<RequirementElaboration> requirementElaborations) {
		this.requirementElaborations = requirementElaborations;
	}

	public RequirementElaboration addRequirementElaboration(RequirementElaboration requirementElaboration) {
		getRequirementElaborations().add(requirementElaboration);
		requirementElaboration.setUser(this);

		return requirementElaboration;
	}

	public RequirementElaboration removeRequirementElaboration(RequirementElaboration requirementElaboration) {
		getRequirementElaborations().remove(requirementElaboration);
		requirementElaboration.setUser(null);

		return requirementElaboration;
	}


	//bi-directional many-to-one association to RequirementHistory
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	public List<RequirementHistory> getRequirementHistories() {
		return this.requirementHistories;
	}

	public void setRequirementHistories(List<RequirementHistory> requirementHistories) {
		this.requirementHistories = requirementHistories;
	}

	public RequirementHistory addRequirementHistory(RequirementHistory requirementHistory) {
		getRequirementHistories().add(requirementHistory);
		requirementHistory.setUser(this);

		return requirementHistory;
	}

	public RequirementHistory removeRequirementHistory(RequirementHistory requirementHistory) {
		getRequirementHistories().remove(requirementHistory);
		requirementHistory.setUser(null);

		return requirementHistory;
	}


	//bi-directional many-to-one association to RequirementLink
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	public List<RequirementLink> getRequirementLinks() {
		return this.requirementLinks;
	}

	public void setRequirementLinks(List<RequirementLink> requirementLinks) {
		this.requirementLinks = requirementLinks;
	}

	public RequirementLink addRequirementLink(RequirementLink requirementLink) {
		getRequirementLinks().add(requirementLink);
		requirementLink.setUser(this);

		return requirementLink;
	}

	public RequirementLink removeRequirementLink(RequirementLink requirementLink) {
		getRequirementLinks().remove(requirementLink);
		requirementLink.setUser(null);

		return requirementLink;
	}

}