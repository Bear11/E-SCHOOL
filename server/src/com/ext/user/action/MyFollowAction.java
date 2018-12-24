package com.ext.user.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.user.bo.UserFollowViewBo;
import com.ext.user.bo.MyFollowBo;
import com.ext.user.po.UserFollow;
import com.ext.user.po.User_and_school_information_;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class MyFollowAction extends QssActionSupprot{
	private String msg;
	private int flag;
	private int id;
	private String userName;
	private String signature;
	private String userId;
	private UserFollow userFollow;
	private MyFollowBo MyFollowBo; 
	private UserFollowViewBo userFollowViewBo;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public UserFollow getUserFollow() {
		return userFollow;
	}
	public void setUserFollow(UserFollow userFollow) {
		this.userFollow = userFollow;
	}
	public UserFollowViewBo getUserFollowViewBo() {
		return userFollowViewBo;
	}
	public void setUserFollowViewBo(UserFollowViewBo userFollowViewBo) {
		this.userFollowViewBo = userFollowViewBo;
	}
	
	public MyFollowBo getMyFollowBo() {
		return MyFollowBo;
	}
	public void setMyFollowBo(MyFollowBo myFollowBo) {
		MyFollowBo = myFollowBo;
	}
	public String getUserFollowView()
	{
		String id = getParam("id").toString();
		List<UserFollow> list = new ArrayList<UserFollow>();
		try {
			list = userFollowViewBo.getMyFollow(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
	public String getUserFollowViewSecond()
	{
		String id = getParam("id").toString();
		List<UserFollow> list = new ArrayList<UserFollow>();
		try {
			list = userFollowViewBo.getMyFollowSecond(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
	public String deleteUserFollow()
	{
		int id = Integer.valueOf(getParam("id").toString());
		List<UserFollow> list = new ArrayList<UserFollow>();
		try {
			getMyFollowBo().deleteMyFollowBo(id);
			flag=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		// 返回flag标识和用户id
		
		return ResponseUtil.returnJson(json.toString());
	}
	
}