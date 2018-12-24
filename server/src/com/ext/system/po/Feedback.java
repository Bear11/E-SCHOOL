package com.ext.system.po;

import com.ext.util.DatabaseUtils;

public class Feedback {

	private int id; // 主键id
	private String fdmsg; // 反馈内容 
	private int personId; // 用户id

	// 设置自增长
	public Feedback() {
		this.id = DatabaseUtils.INVALID_INT_ID;		
		this.personId = DatabaseUtils.INVALID_INT_ID;
	}

	// 取得get和set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFdmsg() {
		return fdmsg;
	}

	public void setFdmsg(String fdmsg) {
		this.fdmsg = fdmsg;
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
		return "Feedback [id=" + id + ", fdmsg=" + fdmsg + ", personId="
				+ personId + "]";
	}	
	
}
