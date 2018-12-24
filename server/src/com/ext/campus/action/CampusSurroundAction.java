package com.ext.campus.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.campus.bo.CampusSurroundBo;
import com.ext.campus.po.CampusSurround;
import com.ext.campus.po.SetCampusSurround;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;
import com.ext.campus.bo.SetCampusSurroundBo;

public class CampusSurroundAction extends QssActionSupprot {

	private CampusSurroundBo campusSurroundBo;
	private String msg;
	private SetCampusSurround SetCampusSurround;
	private SetCampusSurroundBo SetCampusSurroundBo;
	private int userId;


	public CampusSurroundBo getCampusSurroundBo() {
		return campusSurroundBo;
	}

	public void setCampusSurroundBo(CampusSurroundBo campusSurroundBo) {
		this.campusSurroundBo = campusSurroundBo;
	}
	
	public SetCampusSurround getSetCampusSurround() {
		return SetCampusSurround;
	}

	public void setSetCampusSurround(SetCampusSurround setCampusSurround) {
		SetCampusSurround = setCampusSurround;
	}

	
	
	public SetCampusSurroundBo getSetCampusSurroundBo() {
		return SetCampusSurroundBo;
	}

	public void setSetCampusSurroundBo(SetCampusSurroundBo setCampusSurroundBo) {
		SetCampusSurroundBo = setCampusSurroundBo;
	}

	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String login() {
		List<CampusSurround> list = new ArrayList();
		try {
			list = getCampusSurroundBo().findCampusSurround("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}

	public String reportCampus()
	{
		msg = null;
		String id = getParam("id").toString();// 用户账号
		String note = getParam("note").toString();// 用户密码
		String address= getParam("address").toString();

		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String commentTime=format.format(date);
		SetCampusSurround.setAddress(address);
		SetCampusSurround.setNote(note);
		SetCampusSurround.setImageUrl("");
		SetCampusSurround.setPlayTime(commentTime);
		SetCampusSurround.setPERSONID(Integer.valueOf(id));
		SetCampusSurround.setClickNumber(0);
		SetCampusSurround.setCommentNumber(0);
		SetCampusSurround.setForwardNumber(0);
		SetCampusSurround.setSchoolId(1);
		
		try {
			SetCampusSurroundBo.saveSetCampusSurroundBo(SetCampusSurround);
			userId = getSetCampusSurround().getId();
			msg = "success";
		} catch (Exception e){
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}

}
