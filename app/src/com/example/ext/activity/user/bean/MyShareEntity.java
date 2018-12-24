package com.example.ext.activity.user.bean;

public class MyShareEntity {

	private String id;
	private String PERSONID;
	private String name;
	private String time;
	private String note;
	private String headImage;
	private String image;
	private String click;
	private String comment;
	private String forward;
	
	
	
	@Override
	public String toString() {
		return "MyShareEntity [id=" + id + ", PERSONID=" + PERSONID + ", name="
				+ name + ", time=" + time + ", note=" + note + ", headImage="
				+ headImage + ", image=" + image + ", click=" + click
				+ ", comment=" + comment + ", forward=" + forward + "]";
	}

	public MyShareEntity(String id,String PERSONID,String name,String time,String note,String headImage,
			String image,String click,String comment,String forward)
	{
		this.id=id;
		this.PERSONID=PERSONID;
		this.name=name;
		this.time=time;
		this.note=note;
		this.headImage=headImage;
		this.image=image;
		this.click=click;
		this.comment=comment;
		this.forward=forward;
	}
	
	public String getId() {
		return id;
	}

	public String getPERSONID() {
		return PERSONID;
	}

	public void setPERSONID(String pERSONID) {
		PERSONID = pERSONID;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}
}
