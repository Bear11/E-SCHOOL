package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class User_and_school_information_ {
	private int ID;
	private String userAct; // 用户账号
	private String phoneNo; // 用户手机号码
	private String userName;
	private String imageUrl;
	private String SchoolName; //学校名
	private String emailAdd; //电子邮箱
	
	public User_and_school_information_()
	{
		this.ID = DatabaseUtils.INVALID_INT_ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserAct() {
		return userAct;
	}

	public void setUserAct(String userAct) {
		this.userAct = userAct;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getSchoolName() {
		return SchoolName;
	}

	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "User_and_school_information_ [ID=" + ID + ", userAct="
				+ userAct + ", phoneNo=" + phoneNo + ", userName=" + userName
				+ ", imageUrl=" + imageUrl + ", SchoolName=" + SchoolName
				+ ", emailAdd=" + emailAdd + "]";
	}

}
