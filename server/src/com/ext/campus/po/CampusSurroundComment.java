package com.ext.campus.po;



import java.util.Date;

import com.ext.util.DatabaseUtils;



public class CampusSurroundComment {
	
	private int id;
	private int c_sid; //分項表c_sid
	private String commentTime;
	private String content;
	private int floor;
	private int PERSONID;
	
	public CampusSurroundComment()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.c_sid = DatabaseUtils.INVALID_INT_ID;
		this.floor = DatabaseUtils.INVALID_INT_ID;
		this.PERSONID = DatabaseUtils.INVALID_INT_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getC_sid() {
		return c_sid;
	}

	public void setC_sid(int c_sid) {
		this.c_sid = c_sid;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getPERSONID() {
		return PERSONID;
	}

	public void setPERSONID(int pERSONID) {
		PERSONID = pERSONID;
	}

	@Override
	public String toString() {
		return "CampusSurroundComment [id=" + id + ", c_sid=" + c_sid
				+ ", commentTime=" + commentTime + ", content=" + content
				+ ", floor=" + floor + ", PERSONID=" + PERSONID + "]";
	}

}
