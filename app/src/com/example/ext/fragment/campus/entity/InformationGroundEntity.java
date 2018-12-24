package com.example.ext.fragment.campus.entity;

public class InformationGroundEntity {
	private String headimage;
	private String image;
	private String name;
	private String text;
	private String school;
	private String title;
	private String time;
	public InformationGroundEntity(String headimage,String image,String name,String text,String school,String title,String time)
	{
		this.headimage=headimage;
		this.image=image;
		this.name=name;
		this.text=text;
		this.school=school;
		this.title=title;
		this.time=time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHeadimage() {
		return headimage;
	}
	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
