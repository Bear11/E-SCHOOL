package com.example.ext.activity.activities.bean;

public class ActivitiesBean {

	private String id; // 主键id
	private String actTime; // 活动时间
	private String topic; // 活动主题
	private String address; // 活动地点
	private String discribe; // 活动描述
	private String picture; // 图片路径
	private String personId; // 活动发起人
	private String state; // 活动状态
	private String playTime; // 发表时间
	private String deadLine; // 截止时间
	private String limitNumber; // 限制人数
	private String remainNumber; // 剩余票数
	private String price; // 活动费用

	public ActivitiesBean(String id, String actTime, String topic,
			String address, String discribe, String picture, String personId,
			String state, String playTime, String deadLine, String limitNumber,
			String remainNumber, String price) {

		this.id = id;
		this.actTime = actTime;
		this.topic = topic;
		this.address = address;
		this.discribe = discribe;
		this.picture = picture;
		this.personId = personId;
		this.state = state;
		this.playTime = playTime;
		this.deadLine = deadLine;
		this.limitNumber = limitNumber;
		this.remainNumber = remainNumber;
		this.price = price;

	}

	// 重写toString()方法
	@Override
	public String toString() {
		return "ActivitiesBean [id=" + id + ", actTime=" + actTime + ", topic="
				+ topic + ", address=" + address + ", discribe=" + discribe
				+ ", picture=" + picture + ", personId=" + personId
				+ ", state=" + state + ", playTime=" + playTime + ", deadLine="
				+ deadLine + ", limitNumber=" + limitNumber + ", remainNumber="
				+ remainNumber + ", price=" + price + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActTime() {
		return actTime;
	}

	public void setActTime(String actTime) {
		this.actTime = actTime;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

	public String getLimitNumber() {
		return limitNumber;
	}

	public void setLimitNumber(String limitNumber) {
		this.limitNumber = limitNumber;
	}

	public String getRemainNumber() {
		return remainNumber;
	}

	public void setRemainNumber(String remainNumber) {
		this.remainNumber = remainNumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	// 取得get和set方法

}
