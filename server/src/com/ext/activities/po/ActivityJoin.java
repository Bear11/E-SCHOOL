package com.ext.activities.po;

import com.ext.util.DatabaseUtils;

public class ActivityJoin {

	private int id; // 主键id
	private int activityId; // 活动id
	private int personId; // 参与人id

	// 设置自增长
	public ActivityJoin() {
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.personId = DatabaseUtils.INVALID_INT_ID;
		this.activityId = DatabaseUtils.INVALID_INT_ID;
	}

	// 取得get和set方法

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	// 重写toString()方法
	@Override
	public String toString() {
		return "ActivityJoin [id=" + id + ", activityId=" + activityId
				+ ", personId=" + personId + "]";
	}
}
