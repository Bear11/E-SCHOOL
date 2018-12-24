package com.ext.campus.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.campus.bo.CampusInformationBo;
import com.ext.campus.bo.SchoolInformationViewBo;
import com.ext.campus.po.CampusInformation;
import com.ext.campus.po.SchoolInformationView;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class CampusInformationAction extends QssActionSupprot {
	private CampusInformationBo campusInformationBo;
	private CampusInformation campusInformation;
	private SchoolInformationViewBo SchoolInformationViewBo;
	private String msg;
	private int flag;
	private String userId;
	private String title;  //标题
	private String note;   //详情
	private String playTime;  //发表的时间
	private String userAct;  //提供者的id
	private String schoolName;
	
	
	public CampusInformationBo getCampusInformationBo() {
		return campusInformationBo;
	}

	public void setCampusInformationBo(CampusInformationBo campusInformationBo) {
		this.campusInformationBo = campusInformationBo;
	}

	public CampusInformation getCampusInformation() {
		return campusInformation;
	}

	public void setCampusInformation(CampusInformation campusInformation) {
		this.campusInformation = campusInformation;
	}
	
	public SchoolInformationViewBo getSchoolInformationViewBo() {
		return SchoolInformationViewBo;
	}

	public void setSchoolInformationViewBo(
			SchoolInformationViewBo schoolInformationViewBo) {
		SchoolInformationViewBo = schoolInformationViewBo;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String user) {
		this.userId = user;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getUserAct() {
		return userAct;
	}

	public void setUserAct(String userAct) {
		this.userAct = userAct;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String login() {
		String id = getParam("userAct").toString();
		List<CampusInformation> list = new ArrayList();
		try {
			list = getCampusInformationBo().findCampusInformation(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
	public String schoolInformation() {
		List<SchoolInformationView> list = new ArrayList();
		try {
			list = getSchoolInformationViewBo().findSchoolInformation("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
}
