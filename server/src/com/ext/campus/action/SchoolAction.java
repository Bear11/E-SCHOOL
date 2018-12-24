package com.ext.campus.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.campus.bo.SchoolBo;
import com.ext.campus.po.Scenery;
import com.ext.campus.po.School;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class SchoolAction extends QssActionSupprot {
	
	private School school; 
	private SchoolBo schoolBo;
	private String msg;
	
	
	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}


	public SchoolBo getSchoolBo() {
		return schoolBo;
	}


	public void setSchoolBo(SchoolBo schoolBo) {
		this.schoolBo = schoolBo;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public String findAllSce() {
		List<School> list = new ArrayList();
		try {
			list = getSchoolBo().getAllSchool();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("schList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}

}