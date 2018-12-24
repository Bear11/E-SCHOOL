package com.ext.campus.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class CampusSurroundCommentView {
	
	private int id;
	private int CampusID;
	private String userAct;
	private String imageUrl;
	private Date commentTime;		//发表的时间
	private String content;
	
	public CampusSurroundCommentView()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.CampusID = DatabaseUtils.INVALID_INT_ID;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserAct() {
		return userAct;
	}
	public void setUserAct(String userAct) {
		this.userAct = userAct;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getCampusID() {
		return CampusID;
	}

	public void setCampusID(int campusID) {
		CampusID = campusID;
	}

	@Override
	public String toString() {
		return "CampusSurroundCommentView [id=" + id + ", CampusID=" + CampusID
				+ ", userAct=" + userAct + ", imageUrl=" + imageUrl
				+ ", commentTime=" + commentTime + ", content=" + content + "]";
	}

	
	
}
