package com.ext.campus.po;

import com.ext.util.DatabaseUtils;

public class ConcernOther {

	private int id;
	private int PERSONID;
	private int objPersonId;
	
	public ConcernOther()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.PERSONID = DatabaseUtils.INVALID_INT_ID;
		this.objPersonId = DatabaseUtils.INVALID_INT_ID;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "ConcernOther [id=" + id + ", PERSONID=" + PERSONID
				+ ", objPersonId=" + objPersonId + "]";
	}

}
