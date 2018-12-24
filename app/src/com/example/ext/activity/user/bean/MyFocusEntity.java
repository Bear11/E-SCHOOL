package com.example.ext.activity.user.bean;

public class MyFocusEntity {
	private String ID;
	private String userName;
	private String signature;
	private String imageUrl;
	private String objPersonId;
	public MyFocusEntity(String ID,String objPersonId,String userName,String signature,String imageUrl)
	{
		this.ID=ID;
		this.objPersonId=objPersonId;
		this.userName=userName;
		this.signature=signature;
		this.imageUrl=imageUrl;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getObjPersonId() {
		return objPersonId;
	}
	public void setObjPersonId(String objPersonId) {
		this.objPersonId = objPersonId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
