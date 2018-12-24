package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class UserInformation {

	private int id; // 主键id
	private String userAct; // 用户账号
	private String userPwd; // 用户密码
	private String userName; // 用户昵称
	private String imageUrl; // 用户头像
	private int sex; // 用户性别
	private String phoneNo; // 用户手机号码
	private int lSchoolId; // 所在学校id
	private int gSchoolId; // 所去学校id
	private String emailAdd; // 用户邮箱
	private int nkey; // 身份标识
	private String signature; // 个性签名

	// 设置自增长
	public UserInformation() {
		this.id = DatabaseUtils.INVALID_INT_ID;
		this.lSchoolId = DatabaseUtils.INVALID_INT_ID;
		this.gSchoolId = DatabaseUtils.INVALID_INT_ID;
	}

	// 取得get和set方法

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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}


	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getlSchoolId() {
		return lSchoolId;
	}

	public void setlSchoolId(int lSchoolId) {
		this.lSchoolId = lSchoolId;
	}

	public int getgSchoolId() {
		return gSchoolId;
	}

	public void setgSchoolId(int gSchoolId) {
		this.gSchoolId = gSchoolId;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public int getNkey() {
		return nkey;
	}

	public void setNkey(int nkey) {
		this.nkey = nkey;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	// 重写toString()方法
	@Override
	public String toString() {
		return "UserInformation [id=" + id + ", userAct=" + userAct
				+ ", userPwd=" + userPwd + ", userName=" + userName
				+ ", imageUrl=" + imageUrl + ", sex=" + sex + ", phoneNo="
				+ phoneNo + ", lSchoolId=" + lSchoolId + ", gSchoolId="
				+ gSchoolId + ", emailAdd=" + emailAdd + ", nkey=" + nkey
				+ ", signature=" + signature + "]";
	}
}
