package com.ext.campus.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class CampusSurround {
	private int id;  //主键的id
	private String userAct;  
	private String head;
	private String address;  //周边详情的地点
	private String note;		//周边的详情
	private String imageUrl;	//图片
	private Date playTime;		//发表的时间
	private int clickNumber;	//点赞数
	private int commentNumber;	//评论数
	private int forwardNumber;	//转发量
	private String schoolName;
	
	public CampusSurround()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.clickNumber = DatabaseUtils.INVALID_INT_ID;
		this.commentNumber = DatabaseUtils.INVALID_INT_ID;
		this.forwardNumber = DatabaseUtils.INVALID_INT_ID;
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
	public Date getPlayTime() {
		return playTime;
	}
	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
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
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	@Override
	public String toString() {
		return "CampusSurround [id=" + id + ", userAct=" + userAct + ", head="
				+ head + ", address=" + address + ", note=" + note
				+ ", imageUrl=" + imageUrl + ", playTime=" + playTime
				+ ", clickNumber=" + clickNumber + ", commentNumber="
				+ commentNumber + ", forwardNumber=" + forwardNumber
				+ ", schoolName=" + schoolName + "]";
	}
	
}
