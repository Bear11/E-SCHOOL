package com.ext.share.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class Share {

	private int id; // 主键id
	private String discribe; // 内容描述
	private int typeId; // 类别id
	private String picture; // 图片路径 
	private int personId; // 分享人
	private Date playTime; // 发表时间
	private int state; // 贴上状态
	private int clickNumber; //点赞数
	private int commentNumber; //评论量
	private int forwardNumber; //转发量
	
	// 设置自增长
	public Share() {
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.typeId = DatabaseUtils.INVALID_INT_ID;
		this.personId = DatabaseUtils.INVALID_INT_ID;
	}

	// 取得get和set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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
	
	// 重写toString()方法
	@Override
	public String toString() {
		return "Share [id=" + id + ", discribe=" + discribe + ", typeId="
				+ typeId + ", picture=" + picture + ", personId=" + personId
				+ ", playTime=" + playTime + ", state=" + state
				+ ", clickNumber=" + clickNumber + ", commentNumber="
				+ commentNumber + ", forwardNumber=" + forwardNumber + "]";
	}		
}
