package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class MyCollect {

	private int id;
	private int personId;
	private int shareId;
	private int activityId;
	
	private MyCollect()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;		
		this.personId = DatabaseUtils.INVALID_INT_ID;
		this.shareId = DatabaseUtils.INVALID_INT_ID;
		this.activityId = DatabaseUtils.INVALID_INT_ID;
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

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	@Override
	public String toString() {
		return "MyCollect [id=" + id + ", personId=" + personId + ", shareId="
				+ shareId + ", activityId=" + activityId + "]";
	}
	
}
