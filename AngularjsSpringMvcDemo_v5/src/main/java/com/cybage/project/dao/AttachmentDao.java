package com.cybage.project.dao;

import java.util.List;

import com.cybage.project.model.Attachment;

public interface AttachmentDao {
	  int saveAttachment(Attachment attachment,int requirementId);
	  List<Attachment> getAllAttachments();

}
