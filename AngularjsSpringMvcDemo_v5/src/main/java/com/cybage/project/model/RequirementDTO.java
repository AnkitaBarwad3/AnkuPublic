package com.cybage.project.model;

import java.util.ArrayList;
import java.util.Arrays;

public class RequirementDTO {
	private String userName;
	private int requirementId;
	private String description;
	private String prerequisite;
	private String priority;
	private String shortTitle;
	private String status;
	private String title;
	private String type;
	private String version;
	private byte[] attachments;
	private ArrayList<String> elaborations;
	private ArrayList<String> links;
	
	
	
	public RequirementDTO() {
		
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getRequirementId() {
		return requirementId;
	}



	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getPrerequisite() {
		return prerequisite;
	}



	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}



	public String getShortTitle() {
		return shortTitle;
	}



	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public byte[] getAttachments() {
		return attachments;
	}



	public void setAttachments(byte[] attachments) {
		this.attachments = attachments;
	}



	public ArrayList<String> getElaborations() {
		return elaborations;
	}



	public void setElaborations(ArrayList<String> elaborations) {
		this.elaborations = elaborations;
	}



	public ArrayList<String> getLinks() {
		return links;
	}



	public void setLinks(ArrayList<String> links) {
		this.links = links;
	}



	public RequirementDTO(int requirementId, String description, String prerequisite, String priority,
			String shortTitle, String status, String title, String type, String version, byte[] attachments,
			ArrayList<String> elaborations, ArrayList<String> links) {
		super();
		this.requirementId = requirementId;
		this.description = description;
		this.prerequisite = prerequisite;
		this.priority = priority;
		this.shortTitle = shortTitle;
		this.status = status;
		this.title = title;
		this.type = type;
		this.version = version;
		this.attachments = attachments;
		this.elaborations = elaborations;
		this.links = links;
	}



	@Override
	public String toString() {
		return "RequirementDTO [requirementId=" + requirementId + ", description=" + description + ", prerequisite="
				+ prerequisite + ", priority=" + priority + ", shortTitle=" + shortTitle + ", status=" + status
				+ ", title=" + title + ", type=" + type + ", version=" + version + ", attachments="
				+ Arrays.toString(attachments) + ", elaborations=" + elaborations + ", links=" + links + "]";
	}

	
	



	

}
