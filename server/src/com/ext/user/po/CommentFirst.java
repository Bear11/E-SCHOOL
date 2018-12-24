package com.ext.user.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class CommentFirst {

	private int id; // 主键id
	private int objkey; // 评论实体标识
	private Date commentTime; // 评论时间
	private String content; // 评论内容
	private int floor; // 评论楼层
	private int personId; // 评论人id
	

	// 设置自增长
	public CommentFirst() {
		this.id = DatabaseUtils.INVALID_INT_ID;		
		this.personId = DatabaseUtils.INVALID_INT_ID;	
	}	 
    	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getObjkey() {
		return objkey;
	}



	public void setObjkey(int objkey) {
		this.objkey = objkey;
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

	// 重写toString()方法
	@Override
	public String toString() {
		return "CommentFirst [id=" + id + ", objkey=" + objkey
				+ ", commentTime=" + commentTime + ", content=" + content
				+ ", floor=" + floor + ", personId=" + personId + "]";
	}	
}
