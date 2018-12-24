package com.ext.user.action;

import net.sf.json.JSONObject;

import com.ext.user.bo.UserInformationBo;
import com.ext.user.po.UserInformation;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class UserAction extends QssActionSupprot {

	private UserInformationBo userInformationBo;
	private UserInformation userInformation;
	private String msg;
	private String userid;
	private int flag;
	private String nowtime;
	private String uid;
	private String userName;
	private String signature;
	private String LSchoolId;
	private String head;

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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getNowtime() {
		return nowtime;
	}

	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getLSchoolId() {
		return LSchoolId;
	}

	public void setLSchoolId(String lSchoolId) {
		LSchoolId = lSchoolId;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		msg = null;
		String userAct = getParam("userAct").toString();
		String userPwd = getParam("userPwd").toString();
		// String userName = getParam("userName").toString();
		try {
			userInformation = getUserInformationBo().findUserInformation(
					userAct, userPwd);
			if (userInformation.getId() > 0) {
				userid = String.valueOf(userInformation.getId());
				flag = 1;
			} else {
				flag = 0;
			}
		} catch (Exception e) {
			flag = 0;
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		// 返回flag标识和用户id
		if (flag == 1) {
			json.put("userid", userid);
		}
		return ResponseUtil.returnJson(json.toString());
	}

	/**
	 * 注册
	 * 
	 * @return
	 */
	public String regist() {
		msg = null;
		String userAct = getParam("userAct").toString();// 用户账号
		String userPwd = getParam("userPwd").toString();// 用户密码
		//int lSchoolId = Integer.valueOf(getParam("loSchool").toString());// 所在学校编号
		//int gSchoolId = Integer.valueOf(getParam("goSchool").toString());// 所去学校编号
		// String userName = getParam("userName").toString();// 用户昵称
		// String imageUrl = getParam("imageUrl").toString();// 用户头像
		// int sex = Integer.valueOf(getParam("sex").toString());// 用户性别
		userInformation.setUserAct(userAct);
		userInformation.setUserPwd(userPwd);
		userInformation.setlSchoolId(1);
		userInformation.setgSchoolId(2);
		// userInformation.setSex(sex);
		try {
			getUserInformationBo().saveUserInformation(userInformation);
			userid = String.valueOf(getUserInformation().getId());
			msg = "success";
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		json.put("userid", userid);
		return ResponseUtil.returnJson(json.toString());
	}
	/**
	 * 个人中心
	 */
	public String getPersonCenter()
	{
		msg=null;
		String usernum = getParam("username").toString(); //用户的账号
		try {
			userInformation = getUserInformationBo().findPreson_Center(
					usernum);
			if (userInformation.getId() > 0) {
				userid = String.valueOf(userInformation.getId());
				userName= userInformation.getUserName();
				signature = userInformation.getSignature();
				LSchoolId= String.valueOf(userInformation.getlSchoolId());
				head=userInformation.getImageUrl();
				flag = 1; 
			} else {
				flag = 0;
			}
		} catch (Exception e) {
			flag = 0;
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		// 返回flag标识和用户id
		if (flag==1) {
			json.put("userid", userid);
			json.put("username", userName);
			json.put("signature", signature);
			json.put("LSchoolId",LSchoolId);
			json.put("head",head);
		}
		return ResponseUtil.returnJson(json.toString());
		
	}
	/**
	 * 通过用户id导出详情
	 * 
	 */
	public String findByUserId() {

		String id = getParam("id").toString();
		int uid = Integer.valueOf(id);
		try {
		    userInformation = getUserInformationBo().findUserInformationById(uid);
		} catch (Exception e) {
		}
		JSONObject json = new JSONObject();
		json.put("userInformation", output4ajax(new Object[] { userInformation }));
		return ResponseUtil.returnJson(json.toString());
	}
}
