package com.ext.user.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class CommentSecond {

	private int id; // 主键id
	private int firstId; //一级评论表id
	private Date commentTime; //评论时间
	private String content; // 评论内容
	private int floor; // 评论楼层	
	private int personId; // 用户id
	private int objPersonId; //评论对象id
	
	// 设置自增长
	public CommentSecond() {
		this.id = DatabaseUtils.INVALID_INT_ID;		
		this.personId = DatabaseUtils.INVALID_INT_ID;
		this.objPersonId = DatabaseUtils.INVALID_INT_ID;
		this.firstId = DatabaseUtils.INVALID_INT_ID;
	}
	
	// 取得get和set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFirstId() {
		return firstId;
	}

	public void setFirstId(int firstId) {
		this.firstId = firstId;
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

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getObjPersonId() {
		return objPersonId;
	}

	public void setObjPersonId(int objPersonId) {
		this.objPersonId = objPersonId;
	}
		
	// 重写toString()方法
	@Override
	public String toString() {
		return "CommentSecond [id=" + id + ", firstId=" + firstId
				+ ", commentTime=" + commentTime + ", content=" + content
				+ ", floor=" + floor + ", personId=" + personId
				+ ", objPersonId=" + objPersonId + "]";
	}  	
}
