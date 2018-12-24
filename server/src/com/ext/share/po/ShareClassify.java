package com.ext.share.po;

import com.ext.util.DatabaseUtils;

public class ShareClassify {

	private int id; // 主键id
	private String typeName; // 类别名
	private String notes; // 类别备注

	// 设置自增长
	public ShareClassify() {
		this.id = DatabaseUtils.INVALID_INT_ID;
	}

	// 取得get和set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	// 重写toString()方法
	@Override
	public String toString() {
		return "ShareClassify [id=" + id + ", typeName=" + typeName
				+ ", notes=" + notes + "]";
	}
}
