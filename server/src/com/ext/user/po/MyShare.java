package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class MyShare {

	private int id; //id主键
	private int personId;  //用户id
	private int shareId;   //分享表id
	
	private MyShare()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;		
		this.personId = DatabaseUtils.INVALID_INT_ID;
		this.shareId = DatabaseUtils.INVALID_INT_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getShareId() {
		return shareId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	@Override
	public String toString() {
		return "MyShare [id=" + id + ", personId=" + personId + ", shareId="
				+ shareId + "]";
	}
	
}
