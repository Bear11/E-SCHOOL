package com.ext.campus.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.campus.bo.SceneryViewBo;
import com.ext.campus.po.SceneryView;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class SceneryViewAction extends QssActionSupprot {
	
	private SceneryView sceneryView; 
	private SceneryViewBo sceneryViewBo;
	private String msg;
	
	public SceneryView getSceneryView() {
		return sceneryView;
	}
	public void setSceneryView(SceneryView sceneryView) {
		this.sceneryView = sceneryView;
	}
	public SceneryViewBo getSceneryViewBo() {
		return sceneryViewBo;
	}
	public void setSceneryViewBo(SceneryViewBo sceneryViewBo) {
		this.sceneryViewBo = sceneryViewBo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 查询所有风景图片
	 * 
	 * @return
	 */
	public String findAllSceView() {
		List<SceneryView> list = new ArrayList();
		try {
			list = getSceneryViewBo().getAllSceneryView();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("sceViList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}

}