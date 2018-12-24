package com.ext.campus.po;

import com.ext.util.DatabaseUtils;

public class SchoolInformationView {

	private int id;
	private String schoolName;
	private String schoolDescribe;
	
	public SchoolInformationView()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolDescribe() {
		return schoolDescribe;
	}

	public void setSchoolDescribe(String schoolDescribe) {
		this.schoolDescribe = schoolDescribe;
	}

	@Override
	public String toString() {
		return "SchoolInformationView [id=" + id + ", schoolName=" + schoolName
				+ ", schoolDescribe=" + schoolDescribe + "]";
	}

	
	
}
