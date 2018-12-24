package com.ext.campus.po;

import com.ext.util.DatabaseUtils;

public class SetCampusSurround {

	private int id;
	private String address;
	private String note;
	private String imageUrl;
	private String playTime;
	private int PERSONID;
	private int clickNumber;
	private int commentNumber;
	private int forwardNumber;
	private int schoolId;
	
	public SetCampusSurround() {
		// TODO Auto-generated constructor stub
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.PERSONID = DatabaseUtils.INVALID_INT_ID;
		this.clickNumber = DatabaseUtils.INVALID_INT_ID;
		this.commentNumber = DatabaseUtils.INVALID_INT_ID;
		this.forwardNumber = DatabaseUtils.INVALID_INT_ID;
		this.schoolId = DatabaseUtils.INVALID_INT_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public int getPERSONID() {
		return PERSONID;
	}

	public void setPERSONID(int pERSONID) {
		PERSONID = pERSONID;
	}

	public int getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(int clickNumber) {
		this.clickNumber = clickNumber;
	}

	public int getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

	public int getForwardNumber() {
		return forwardNumber;
	}

	public void setForwardNumber(int forwardNumber) {
		this.forwardNumber = forwardNumber;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public String toString() {
		return "SetCampusSurround [id=" + id + ", address=" + address
				+ ", note=" + note + ", imageUrl=" + imageUrl + ", playTime="
				+ playTime + ", PERSONID=" + PERSONID + ", clickNumber="
				+ clickNumber + ", commentNumber=" + commentNumber
				+ ", forwardNumber=" + forwardNumber + ", schoolId=" + schoolId
				+ "]";
	}
}
