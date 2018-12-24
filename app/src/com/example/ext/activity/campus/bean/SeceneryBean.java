package com.example.ext.activity.campus.bean;

public class SeceneryBean {

	private String id; //主键id
	private String schoolName; //学校名
	private String schoolId;
	private String innerSchool; //学校内部图片
	private String outSchool; //学校周边图片
	private String byCasual; //随手拍的图片
	
	//构造方法
	public SeceneryBean(String id, String schoolId,String schoolName, String innerSchool, String outSchool, String byCasual) {
		super();
		this.id = id;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.innerSchool = innerSchool;
		this.outSchool = outSchool;
		this.byCasual = byCasual;
	}
	//get and set
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
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
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	//toString 方法
	@Override
	public String toString() {
		return "SeceneryBean [id=" + id + ", schoolName=" + schoolName
				+ ", schoolId=" + schoolId + ", innerSchool=" + innerSchool
				+ ", outSchool=" + outSchool + ", byCasual=" + byCasual + "]";
	}
	
}
