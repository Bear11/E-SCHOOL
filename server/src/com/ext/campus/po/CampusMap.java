package com.ext.campus.po;

import com.ext.util.DatabaseUtils;

public class CampusMap {

	private int id;		//主键
	private String imageUrl;	//校园的图片
	private String address;		//地点
	private String discribe;	//地点的描述
	private int schoolId;		//学校的外键id
	
	private CampusMap(){
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.schoolId = DatabaseUtils.INVALID_INT_ID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDiscribe() {
		return discribe;
	}
	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	@Override
	public String toString() {
		return "CampusMap [id=" + id + ", imageUrl=" + imageUrl + ", address="
				+ address + ", discribe=" + discribe + ", schoolId=" + schoolId
				+ "]";
	}
	
}
