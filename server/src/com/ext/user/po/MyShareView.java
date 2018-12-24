package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class MyShareView {

	private int id;
	private String userAct;
	private String imageUrl;
	private String DISCRIBE;
	private int TYPEID;
	private String PICTURE;
	private int PERSONID;
	private int STATE;
	private String PLAYTIME;
	private int clickNumber;
	private int commentNumber;
	private int forwardNumber;
	
	public MyShareView()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.TYPEID = DatabaseUtils.INVALID_INT_ID;
		this.PERSONID = DatabaseUtils.INVALID_INT_ID;
		this.STATE = DatabaseUtils.INVALID_INT_ID;
		this.clickNumber = DatabaseUtils.INVALID_INT_ID;
		this.commentNumber = DatabaseUtils.INVALID_INT_ID;
		this.forwardNumber = DatabaseUtils.INVALID_INT_ID;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserAct() {
		return userAct;
	}

	public void setUserAct(String userAct) {
		this.userAct = userAct;
	}

	public String getDISCRIBE() {
		return DISCRIBE;
	}

	public void setDISCRIBE(String dISCRIBE) {
		DISCRIBE = dISCRIBE;
	}

	public int getTYPEID() {
		return TYPEID;
	}

	public void setTYPEID(int tYPEID) {
		TYPEID = tYPEID;
	}

	public String getPICTURE() {
		return PICTURE;
	}

	public void setPICTURE(String pICTURE) {
		PICTURE = pICTURE;
	}

	public int getPERSONID() {
		return PERSONID;
	}

	public void setPERSONID(int pERSONID) {
		PERSONID = pERSONID;
	}

	public int getSTATE() {
		return STATE;
	}

	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}

	public int getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(int clickNumber) {
		this.clickNumber = clickNumber;
	}

	public int getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

	public int getForwardNumber() {
		return forwardNumber;
	}

	public void setForwardNumber(int forwardNumber) {
		this.forwardNumber = forwardNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getPLAYTIME() {
		return PLAYTIME;
	}


	public void setPLAYTIME(String pLAYTIME) {
		PLAYTIME = pLAYTIME;
	}


	@Override
	public String toString() {
		return "MyShareView [id=" + id + ", userAct=" + userAct + ", imageUrl="
				+ imageUrl + ", DISCRIBE=" + DISCRIBE + ", TYPEID=" + TYPEID
				+ ", PICTURE=" + PICTURE + ", PERSONID=" + PERSONID
				+ ", STATE=" + STATE + ", PLAYTIME=" + PLAYTIME
				+ ", clickNumber=" + clickNumber + ", commentNumber="
				+ commentNumber + ", forwardNumber=" + forwardNumber + "]";
	}

}
