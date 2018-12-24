package com.ext.campus.po;

import com.ext.util.DatabaseUtils;

public class School {
	private int id; //主键
	private String schoolName; //校园名
	private String schoolDescribe; //学校描述

	// 设置自增长
	public School() {
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
		return "School [id=" + id + ", schoolName=" + schoolName
				+ ", schoolDescribe=" + schoolDescribe + "]";
	}
	
}
