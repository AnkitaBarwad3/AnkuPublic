package com.cybage.project.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the attachments database table.
 * 
 */
@Entity
@Table(name="attachments")
@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int attachmentId;
	private Timestamp addingTime;
	private byte[] attachment;
	private Requirement requirement;
	private User user;

	public Attachment() {
	}


	public Attachment(Timestamp addingTime, byte[] attachment) {
		super();
		this.addingTime = addingTime;
		this.attachment = attachment;
	}


	



	@Override
	public String toString() {
		return "Attachment [attachmentId=" + attachmentId + ", addingTime=" + addingTime + ", attachment="
				+ Arrays.toString(attachment) + "]";
	}

    //Specifies the primary key of an entity
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}


	public Timestamp getAddingTime() {
		return this.addingTime;
	}

	public void setAddingTime(Timestamp addingTime) {
		this.addingTime = addingTime;
	}

	//Specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.
	@Lob
	public byte[] getAttachment() {
		return this.attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
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
	@JoinColumn(name="userid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}