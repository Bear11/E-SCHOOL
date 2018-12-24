package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class MyCourse {

	private int id;
	private int personId;
	private int courseId;
	
	private MyCourse()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;		
		this.personId = DatabaseUtils.INVALID_INT_ID;
		this.courseId = DatabaseUtils.INVALID_INT_ID;
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

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "MyCouse [id=" + id + ", personId=" + personId + ", courseId="
				+ courseId + "]";
	}
	
}
