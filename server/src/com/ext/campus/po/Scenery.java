package com.ext.campus.po;

import com.ext.util.DatabaseUtils;

public class Scenery {
	private int id; //风景表的主键
	private String innerSchool; //风景路劲
	private String outSchool; //学校周边图片
	private String byCasual; //随手拍的图片
	private int schoolId; //学校的id
	// 设置自增长
	public Scenery() {
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.schoolId = DatabaseUtils.INVALID_INT_ID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	
	public String getInnerSchool() {
		return innerSchool;
	}
	public void setInnerSchool(String innerSchool) {
		this.innerSchool = innerSchool;
	}
	public String getOutSchool() {
		return outSchool;
	}
	public void setOutSchool(String outSchool) {
		this.outSchool = outSchool;
	}
	public String getByCasual() {
		return byCasual;
	}
	public void setByCasual(String byCasual) {
		this.byCasual = byCasual;
	}
	@Override
	public String toString() {
		return "Scenery [id=" + id + ", innerSchool=" + innerSchool
				+ ", outSchool=" + outSchool + ", byCasual=" + byCasual
				+ ", schoolId=" + schoolId + "]";
	}
}
