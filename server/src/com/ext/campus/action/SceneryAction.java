package com.ext.campus.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.campus.bo.SceneryBo;
import com.ext.campus.po.Scenery;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class SceneryAction extends QssActionSupprot {
	
	private Scenery scenery; 
	private SceneryBo sceneryBo;
	private String msg;
	public Scenery getScenery() {
		return scenery;
	}
	public void setScenery(Scenery scenery) {
		this.scenery = scenery;
	}
	public SceneryBo getSceneryBo() {
		return sceneryBo;
	}
	public void setSceneryBo(SceneryBo sceneryBo) {
		this.sceneryBo = sceneryBo;
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
	public String findAllSce() {
		List<Scenery> list = new ArrayList();
		try {
			list = getSceneryBo().getAllScenery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("sceList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}

}