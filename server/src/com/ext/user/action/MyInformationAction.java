package com.ext.user.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.campus.po.CampusSurroundCommentView;
import com.ext.user.bo.UserInformationBo;
import com.ext.user.bo.User_and_school_information_Bo;
import com.ext.user.po.UserInformation;
import com.ext.user.po.User_and_school_information_;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class MyInformationAction  extends QssActionSupprot {
	private String msg;
	private int flag;
	private String userid;
	private String userName;
	private String phoneNo;
	private String schoolName;
	private String emailAdd;
	private User_and_school_information_ user_and_school_information_;
	private User_and_school_information_Bo user_and_school_information_Bo;
	private UserInformationBo userInformationBo;
	private UserInformation userInformation;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getEmailAdd() {
		return emailAdd;
	}
	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}
	public User_and_school_information_ getUser_and_school_information_() {
		return user_and_school_information_;
	}
	public void setUser_and_school_information_(
			User_and_school_information_ user_and_school_information_) {
		this.user_and_school_information_ = user_and_school_information_;
	}
	public User_and_school_information_Bo getUser_and_school_information_Bo() {
		return user_and_school_information_Bo;
	}
	public void setUser_and_school_information_Bo(
			User_and_school_information_Bo user_and_school_information_Bo) {
		this.user_and_school_information_Bo = user_and_school_information_Bo;
	}
	public UserInformationBo getUserInformationBo() {
		return userInformationBo;
	}
	public void setUserInformationBo(UserInformationBo userInformationBo) {
		this.userInformationBo = userInformationBo;
	}
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	/**
	 * 个人资讯
	 */
	public String getMyInformation()
	{
		String id = getParam("id").toString();
		List<User_and_school_information_> list = new ArrayList<User_and_school_information_>();
		try {
			list = user_and_school_information_Bo.getMyInformation(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	/**
	 * 修改個人資料
	 */
	public String updateInformation() {
		msg = " ";
		int id= Integer.valueOf(getParam("id").toString());
		int x= Integer.valueOf(getParam("x").toString());
		String name = getParam("name").toString();
		String phone = getParam("phone").toString();

		String emild= getParam("emild").toString();
		
		try {
			if(x==1)
			{
				msg = getUserInformationBo().updateInformation(id,name);
			}
			else if(x==2)
			{
				msg = getUserInformationBo().updateInformationPhone(id,phone);
			}
			else if(x==3)
			{
				msg = getUserInformationBo().updateInformationPhone(id,phone);
			}
			else
			{
				msg = getUserInformationBo().updateInformationEmail(id,emild);
			}
			if (msg.equals("success")) {
				msg = "success";
			} else {
				msg = "error";
			}
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}
}
