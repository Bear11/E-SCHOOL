package com.ext.campus.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class CampusInformation {

	private int id;  //主键
	private String title;  //标题
	private String note;   //详情
	private String imageUrl;  //图片
	private Date playTime;  //发表的时间
	private String userAct;  //提供者的id
	private String schoolName;
	
	public CampusInformation()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public String getUserAct() {
		return userAct;
	}

	public void setUserAct(String userAct) {
		this.userAct = userAct;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
		return "CampusInformation [id=" + id + ", title=" + title + ", note="
				+ note + ", imageUrl=" + imageUrl + ", playTime=" + playTime
				+ ", userAct=" + userAct + ", schoolName=" + schoolName + "]";
	}




	
	
}
