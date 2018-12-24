package com.ext.activities.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class Activities {

	private int id; // 主键id
	private Date actTime; // 活动时间
	private String topic; // 活动主题
	private String address; // 活动地点
	private String discribe; // 活动描述
	private String picture; // 图片路径
	private int personId; // 活动发起人
	private int state; // 活动状态
	private Date playTime; // 发表时间
	private Date deadLine; // 截止时间
	private int limitNumber; // 限制人数
	private int remainNumber; // 剩余票数
	private Double price; // 活动费用

	// 设置自增长
	public Activities() {
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.personId = DatabaseUtils.INVALID_INT_ID;
	}

	// 取得get和set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getActTime() {
		return actTime;
	}

	public void setActTime(Date actTime) {
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

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public int getLimitNumber() {
		return limitNumber;
	}

	public void setLimitNumber(int limitNumber) {
		this.limitNumber = limitNumber;
	}

	public int getRemainNumber() {
		return remainNumber;
	}

	public void setRemainNumber(int remainNumber) {
		this.remainNumber = remainNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// 重写toString()方法
	@Override
	public String toString() {
		return "Activities [id=" + id + ", actTime=" + actTime + ", topic="
				+ topic + ", address=" + address + ", discribe=" + discribe
				+ ", picture=" + picture + ", personId=" + personId
				+ ", state=" + state + ", playTime=" + playTime + ", deadLine="
				+ deadLine + ", limitNumber=" + limitNumber + ", remainNumber="
				+ remainNumber + ", price=" + price + "]";
	}
}
