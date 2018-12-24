package com.ext.campus.po;

import com.ext.util.DatabaseUtils;

public class SceneryClassify {
	
	private int id;  //主键的id
	private String name;  //风景的类别名
	private String note;  //备注
	
	private SceneryClassify()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "SceneryClassify [id=" + id + ", name=" + name + ", note="
				+ note + "]";
	}

}
