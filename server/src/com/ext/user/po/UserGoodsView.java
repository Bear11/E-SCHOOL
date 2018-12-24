package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class UserGoodsView {
	private int ID;
	private String userAct;
	private String userAct1;
	private String imageUrl;
	private String name;
	private int number;
	private int price;
	private String discribe;
	private String image;
	private UserGoodsView()
	{
		this.ID = DatabaseUtils.INVALID_INT_ID;
		this.number = DatabaseUtils.INVALID_INT_ID;
		this.price = DatabaseUtils.INVALID_INT_ID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserAct() {
		return userAct;
	}
	public void setUserAct(String userAct) {
		this.userAct = userAct;
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
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getUserAct1() {
		return userAct1;
	}
	public void setUserAct1(String userAct1) {
		this.userAct1 = userAct1;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "UserGoodsView [ID=" + ID + ", userAct=" + userAct
				+ ", userAct1=" + userAct1 + ", imageUrl=" + imageUrl
				+ ", name=" + name + ", number=" + number + ", price=" + price
				+ ", discribe=" + discribe + ", image=" + image + "]";
	}
}
