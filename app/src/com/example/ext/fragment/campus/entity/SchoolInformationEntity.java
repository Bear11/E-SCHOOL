package com.example.ext.fragment.campus.entity;

public class SchoolInformationEntity {
	private String name;
	private String note;
	private String createTime;
	private String address;
	private String schoolType;
	private String Officialwebsite;
	private String image;
	
	public SchoolInformationEntity(String name,String note,String image,
			String createTime,String address,String schoolType,String Officialwebsite)
	{
		this.name=name;
		this.note=note;
		this.createTime=createTime;
		this.address=address;
		this.schoolType=schoolType;
		this.Officialwebsite=Officialwebsite;
		this.image=image;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getOfficialwebsite() {
		return Officialwebsite;
	}

	public void setOfficialwebsite(String officialwebsite) {
		Officialwebsite = officialwebsite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
