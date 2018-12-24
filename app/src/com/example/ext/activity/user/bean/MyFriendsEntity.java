package com.example.ext.activity.user.bean;

public class MyFriendsEntity {

	private String headImage;
	private String name;
	private String signature;
	private String objPersonId;
	
	public MyFriendsEntity(String headImage,String name,String signature,String objPersonId)
	{
		this.headImage = headImage;
		this.name=name;
		this.signature=signature;
		this.objPersonId=objPersonId;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getObjPersonId() {
		return objPersonId;
	}

	public void setObjPersonId(String objPersonId) {
		this.objPersonId = objPersonId;
	}
	
}
