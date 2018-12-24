package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class MyFollow {

	private int id;
	private int personId;
	private int objPersonId;
	
	private MyFollow()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;		
		this.personId = DatabaseUtils.INVALID_INT_ID;
		this.objPersonId = DatabaseUtils.INVALID_INT_ID;
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

	public int getObjPersonId() {
		return objPersonId;
	}

	public void setObjPersonId(int objPersonId) {
		this.objPersonId = objPersonId;
	}

	@Override
	public String toString() {
		return "MyFollow [id=" + id + ", personId=" + personId
				+ ", objPersonId=" + objPersonId + "]";
	}
}
