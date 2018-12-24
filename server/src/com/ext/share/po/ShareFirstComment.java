package com.ext.share.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class ShareFirstComment {

	private int id; // 主键id
	private int shareId; // 分享表id
	private int objpersonId; // 评论人id
	private Date commentTime; // 评论时间
	private String content; // 评论内容
	private int floor; // 评论楼层

	public ShareFirstComment() {
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.shareId = DatabaseUtils.INVALID_INT_ID;
		this.objpersonId = DatabaseUtils.INVALID_INT_ID;
	}

	// 创建getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShareId() {
		return shareId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public int getObjpersonId() {
		return objpersonId;
	}

	public void setObjpersonId(int objpersonId) {
		this.objpersonId = objpersonId;
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

	// 创建tostring()方法
	@Override
	public String toString() {
		return "ShareFirstComment [id=" + id + ", shareId=" + shareId
				+ ", objpersonId=" + objpersonId + ", commentTime="
				+ commentTime + ", content=" + content + ", floor=" + floor
				+ "]";
	}

}
