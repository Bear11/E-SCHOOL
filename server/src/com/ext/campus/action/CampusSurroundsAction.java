package com.ext.campus.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.campus.bo.CampusSurroundBo;
import com.ext.campus.bo.CampusSurroundsBo;
import com.ext.campus.bo.CampusSurroundCommentViewBo;
import com.ext.campus.bo.CampusSurroundCommentBo;
import com.ext.campus.bo.ConcernOtherBo;
import com.ext.campus.po.CampusSurround;
import com.ext.campus.po.CampusSurroundCommentView;
import com.ext.campus.po.ConcernOther;
import com.ext.campus.po.CampusSurroundComment;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class CampusSurroundsAction extends QssActionSupprot {

	private CampusSurroundsBo campusSurroundsBo;
	private CampusSurroundCommentViewBo CampusSurroundCommentViewBo;
	private ConcernOtherBo ConcernOtherBo;
	private ConcernOther ConcernOther;
	private CampusSurroundComment CampusSurroundComment;
	private CampusSurroundCommentBo CampusSurroundCommentBo;
	
	private String msg;
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ConcernOtherBo getConcernOtherBo() {
		return ConcernOtherBo;
	}

	public void setConcernOtherBo(ConcernOtherBo concernOtherBo) {
		ConcernOtherBo = concernOtherBo;
	}

	public ConcernOther getConcernOther() {
		return ConcernOther;
	}

	public void setConcernOther(ConcernOther concernOther) {
		ConcernOther = concernOther;
	}

	public CampusSurroundsBo getCampusSurroundsBo() {
		return campusSurroundsBo;
	}

	public void setCampusSurroundsBo(CampusSurroundsBo campusSurroundsBo) {
		this.campusSurroundsBo = campusSurroundsBo;
	}
	
	public CampusSurroundCommentViewBo getCampusSurroundCommentViewBo() {
		return CampusSurroundCommentViewBo;
	}

	public void setCampusSurroundCommentViewBo(
			CampusSurroundCommentViewBo campusSurroundCommentViewBo) {
		CampusSurroundCommentViewBo = campusSurroundCommentViewBo;
	}

	
	
	public CampusSurroundComment getCampusSurroundComment() {
		return CampusSurroundComment;
	}

	public void setCampusSurroundComment(CampusSurroundComment campusSurroundComment) {
		CampusSurroundComment = campusSurroundComment;
	}

	public CampusSurroundCommentBo getCampusSurroundCommentBo() {
		return CampusSurroundCommentBo;
	}

	public void setCampusSurroundCommentBo(
			CampusSurroundCommentBo campusSurroundCommentBo) {
		CampusSurroundCommentBo = campusSurroundCommentBo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String addClick() {
		msg = " ";
		int id = Integer.valueOf(getParam("id").toString());
		int clicknum = Integer.valueOf(getParam("clicknum").toString());
		int cnum = Integer.valueOf(clicknum)+1;
		// share.setId(Integer.valueOf(aid));
		// share.setPersonId(Integer.valueOf(pid));
		// share.setClickNumber(cnum);
		try {
			msg = getCampusSurroundsBo().updateClick(id,cnum);
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
	
	public String firstComment() {
		String id = getParam("id").toString();
		List<CampusSurroundCommentView> list = new ArrayList<CampusSurroundCommentView>();
		try {
			list = getCampusSurroundCommentViewBo().findCampusSurroundComment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
	public String focus()
	{
		msg = null;
		int userid_1 = Integer.valueOf(getParam("id").toString());// 用户账号
		int userid_2 = Integer.valueOf(getParam("username").toString());// 用户密码
		//String userName = getParam("userName").toString();// 用户昵称
		//String imageUrl = getParam("imageUrl").toString();// 用户头像
		//int sex = Integer.valueOf(getParam("sex").toString());// 用户性别
		ConcernOther.setPERSONID(userid_2);
		ConcernOther.setObjPersonId(userid_1);
		//userInformation.setSex(sex);
		try {
			getConcernOtherBo().saveConcernOtherBo(ConcernOther);
			userId = String.valueOf(getConcernOther().getId());
			msg = "success";
		} catch (Exception e){
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		json.put("userid", userId);
		return ResponseUtil.returnJson(json.toString());
	}
	
	public String comment()
	{
		msg = null;
		int userid_1 = Integer.valueOf(getParam("id").toString());// 用户账号
		int userid_2 = Integer.valueOf(getParam("username").toString());// 用户密码
		String content = getParam("describe").toString();
		//String userName = getParam("userName").toString();// 用户昵称
		//String imageUrl = getParam("imageUrl").toString();// 用户头像
		//int sex = Integer.valueOf(getParam("sex").toString());// 用户性别
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String commentTime=format.format(date);
		CampusSurroundComment.setPERSONID(userid_2);
		CampusSurroundComment.setCommentTime(commentTime);
		CampusSurroundComment.setContent(content);
		CampusSurroundComment.setC_sid(userid_1);
		CampusSurroundComment.setFloor(2);
		//userInformation.setSex(sex);
		try {
			getCampusSurroundCommentBo().saveCampusSurroundCommentBo(CampusSurroundComment);
			userId = String.valueOf(getConcernOther().getId());
			msg = "success";
		} catch (Exception e){
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		json.put("userid", userId);
		return ResponseUtil.returnJson(json.toString());
	}

}
