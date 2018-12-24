package com.example.ext.activity.share.bean;

public class ShareFirstCommentBean {

	private String id; // 主键id
	private String shareId; // 分享表id
	private String objpersonId; // 评论人id
	private String name; // 评论人姓名
	private String commentTime; // 评论时间
	private String content; // 评论内容
	private String floor; // 评论楼层

	public ShareFirstCommentBean(String id, String shareId, String objpersonId,
			String name, String commentTime, String content, String floor) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.shareId = shareId;
		this.objpersonId = objpersonId;
		this.name = name;
		this.commentTime = commentTime;
		this.content = content;
		this.floor = floor;
	}

	// 创建tostring()方法
	@Override
	public String toString() {
		return "ShareFirstCommentBean [id=" + id + ", shareId=" + shareId
				+ ", objpersonId=" + objpersonId + ", name=" + name
				+ ", commentTime=" + commentTime + ", content=" + content
				+ ", floor=" + floor + "]";
	}

	// 创建getters and setters
	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	String getShareId() {
		return shareId;
	}

	void setShareId(String shareId) {
		this.shareId = shareId;
	}

	String getObjpersonId() {
		return objpersonId;
	}

	void setObjpersonId(String objpersonId) {
		this.objpersonId = objpersonId;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getCommentTime() {
		return commentTime;
	}

	void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	String getContent() {
		return content;
	}

	void setContent(String content) {
		this.content = content;
	}

	String getFloor() {
		return floor;
	}

	void setFloor(String floor) {
		this.floor = floor;
	}
}
