package com.example.ext.fragment.campus.entity;

public class CampusGroundEntity {
	
	private String image;
	private int id;
	private String userAct;
	private String note;
	private String time;
	private String schoolName;
	private String click;
	private String comment;
	private String forward;
	private String head;
	
	public CampusGroundEntity(int id,String image,String userAct,String note,String time,
			String schoolName,String click,String comment,String forward,String head)
	{
		this.id=id;
		this.image=image;
		this.userAct=userAct;
		this.note=note;
		this.time=time;
		this.schoolName=schoolName;
		this.click=click;
		this.comment=comment;
		this.forward=forward;
		this.head=head;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUserAct() {
		return userAct;
	}

	public void setUserAct(String userAct) {
		this.userAct = userAct;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
	

}
