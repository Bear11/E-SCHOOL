package com.ext.activities.action;

import net.sf.json.JSONObject;

import com.ext.activities.bo.ActivityJoinBo;
import com.ext.activities.po.ActivityJoin;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class ActivityJoinAction extends QssActionSupprot {
    
	private ActivityJoin activityJoin;
	private ActivityJoinBo activityJoinBo;
	private String msg = "";
	public ActivityJoin getActivityJoin() {
		return activityJoin;
	}
	public void setActivityJoin(ActivityJoin activityJoin) {
		this.activityJoin = activityJoin;
	}
	public ActivityJoinBo getActivityJoinBo() {
		return activityJoinBo;
	}
	public void setActivityJoinBo(ActivityJoinBo activityJoinBo) {
		this.activityJoinBo = activityJoinBo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 保存活动参与记录
	 * 
	 * @return
	 */
    public String saveActJoin()
    {
    	msg = "";    	
		String pId = getParam("pId").toString();
		String actId = getParam("actId").toString();
		activityJoin.setActivityId(Integer.valueOf(actId));
		activityJoin.setPersonId(Integer.valueOf(pId));
		try {
			getActivityJoinBo().saveActivityJoin(activityJoin);		
			msg = "success";
		} catch (Exception e){
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
    }
    
	
}
