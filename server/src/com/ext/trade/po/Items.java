package com.ext.trade.po;

import java.util.Date;

import com.ext.util.DatabaseUtils;

public class Items {

	private int id; // 主键id
	private String name; // 物品名
	private String discribe; // 物品描述
	private int number; // 物品数量
	private int type; // 物品类型
	private int personId; // 联系人
	private Date playTime; // 发表时间
	private String phoneNumber; //联系方式
	private String imageUrl; //图片路径

	// 设置自增长
	public Items() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	// 重写toString()方法	
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", discribe=" + discribe
				+ ", number=" + number + ", type=" + type + ", personId="
				+ personId + ", playTime=" + playTime + ", phoneNumber="
				+ phoneNumber + ", imageUrl=" + imageUrl + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getDiscribe()="
				+ getDiscribe() + ", getNumber()=" + getNumber()
				+ ", getType()=" + getType() + ", getPersonId()="
				+ getPersonId() + ", getPlayTime()=" + getPlayTime()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getImageUrl()="
				+ getImageUrl() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
