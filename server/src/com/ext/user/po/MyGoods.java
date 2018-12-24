package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class MyGoods {

	private int id;
	private String name;
	private int number;
	private int price; 
	private String discribe;
	private String playTime;
	private int PERSONID;
	private String image;
	private int state;
	
	private MyGoods(){
		this.id = DatabaseUtils.INVALID_INT_ID;		
		this.PERSONID = DatabaseUtils.INVALID_INT_ID;
		this.number = DatabaseUtils.INVALID_INT_ID;		
		this.price = DatabaseUtils.INVALID_INT_ID;
	}

	

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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public int getPERSONID() {
		return PERSONID;
	}

	public void setPERSONID(int pERSONID) {
		PERSONID = pERSONID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "MyGoods [id=" + id + ", name=" + name + ", number=" + number
				+ ", price=" + price + ", discribe=" + discribe + ", playTime="
				+ playTime + ", PERSONID=" + PERSONID + ", image=" + image
				+ ", state=" + state + "]";
	}

	

}
