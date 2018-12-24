package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class UserFollow {
	private int ID;
	private String userName;
	private String signature;
	private int PERSONID;
	private int objPersonId;
	private String imageUrl;
	
	private UserFollow()
	{
		this.ID= DatabaseUtils.INVALID_INT_ID;		
	}

	

	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
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

	public int getPERSONID() {
		return PERSONID;
	}

	public void setPERSONID(int pERSONID) {
		PERSONID = pERSONID;
	}



	public int getObjPersonId() {
		return objPersonId;
	}

	public void setObjPersonId(int objPersonId) {
		this.objPersonId = objPersonId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "UserFollow [ID=" + ID + ", userName=" + userName
				+ ", signature=" + signature + ", PERSONID=" + PERSONID
				+ ", objPersonId=" + objPersonId + ", imageUrl=" + imageUrl
				+ "]";
	}
}
