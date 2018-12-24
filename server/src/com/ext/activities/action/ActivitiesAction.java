package com.ext.activities.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.activities.bo.ActivitiesBo;
import com.ext.activities.po.Activities;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class ActivitiesAction extends QssActionSupprot {

	private Activities activities;
	private ActivitiesBo activitiesBo;
	private String msg ;
	public Activities getActivities() {
		return activities;
	}
	public void setActivities(Activities activities) {
		this.activities = activities;
	}
	public ActivitiesBo getActivitiesBo() {
		return activitiesBo;
	}
	public void setActivitiesBo(ActivitiesBo activitiesBo) {
		this.activitiesBo = activitiesBo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 保存活动
	 * 
	 * @return
	 */
    public String saveAct()
    {
    	msg = null;
    	String acti_theme = getParam("acti_theme").toString();
		String timeup = getParam("timeup").toString();
		String acti_time = getParam("acti_time").toString();
		String address = getParam("address").toString();
		int number = Integer.valueOf(getParam("number").toString());
		Double money = Double.valueOf(getParam("money").toString());
		String describe_details = getParam("describe_details").toString();
		
		activities.setTopic(acti_theme);
		activities.setActTime(new java.util.Date());
		activities.setDeadLine(new java.util.Date());
		activities.setAddress(address);
		activities.setLimitNumber(number);
		activities.setPlayTime(new java.util.Date());
		activities.setDiscribe(describe_details);
		activities.setPersonId(5);
		activities.setPrice(0.00);
		activities.setRemainNumber(0);
		activities.setState(0);	

		try {
			getActivitiesBo().saveActivities(activities);			
			msg = "success";
		} catch (Exception e){
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
    }
    
    /**
	 * 查询所有活动内容
	 * 
	 * @return
	 */
	public String findAllAct() {
		List<Activities> list = new ArrayList();
		try {
			list = getActivitiesBo().listActivities();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("actList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	/**
	 * 通过活动id导出详情
	 * 
	 */
	public String findByActivitiesId() {

		String id = getParam("id").toString();
		int aid = Integer.valueOf(id);
		try {
			activities = getActivitiesBo().findById(aid);
		} catch (Exception e) {
		}
		JSONObject json = new JSONObject();
		json.put("activities", output4ajax(new Object[] { activities }));
		return ResponseUtil.returnJson(json.toString());

	}
	
}
