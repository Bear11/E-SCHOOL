package com.example.ext.activity.share.bean;

public class ShareBean {

	private String id; // 主键id
	private String discribe; // 内容描述
	private String typeId; // 类别id
	private String picture; // 图片路径
	private String personId; // 分享人
	private String name; // 分享人用户名
	private String imageUrl; //图用户头像路径
	private String playTime; // 发表时间
	private String state; // 贴上状态
	private String clickNumber; // 点赞数
	private String commentNumber; // 评论量
	private String forwardNumber; // 转发量

	public ShareBean(String id, String discribe, String typeId, String picture,
			String personId, String name, String imageUrl, String playTime,
			String state, String clickNumber, String commentNumber,
			String forwardNumber) {
		super();
		this.id = id;
		this.discribe = discribe;
		this.typeId = typeId;
		this.picture = picture;
		this.personId = personId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.playTime = playTime;
		this.state = state;
		this.clickNumber = clickNumber;
		this.commentNumber = commentNumber;
		this.forwardNumber = forwardNumber;
	}

	@Override
	public String toString() {
		return "ShareBean [id=" + id + ", discribe=" + discribe + ", typeId="
				+ typeId + ", picture=" + picture + ", personId=" + personId
				+ ", name=" + name + ", imageUrl=" + imageUrl + ", playTime="
				+ playTime + ", state=" + state + ", clickNumber="
				+ clickNumber + ", commentNumber=" + commentNumber
				+ ", forwardNumber=" + forwardNumber + "]";
	}

	// 取得get和set方法

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(String clickNumber) {
		this.clickNumber = clickNumber;
	}

	public String getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(String commentNumber) {
		this.commentNumber = commentNumber;
	}

	public String getForwardNumber() {
		return forwardNumber;
	}

	public void setForwardNumber(String forwardNumber) {
		this.forwardNumber = forwardNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
