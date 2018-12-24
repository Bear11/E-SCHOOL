package com.ext.user.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.user.bo.MyActivityViewBo;
import com.ext.user.bo.CollectShareBo;
import com.ext.user.po.CollectShare;
import com.ext.user.po.MyActivityView;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class MyCollectAction extends QssActionSupprot{

	
	private MyActivityViewBo MyActivityViewBo;
	
	private CollectShareBo CollectShareBo;
	
	public MyActivityViewBo getMyActivityViewBo() {
		return MyActivityViewBo;
	}



	public void setMyActivityViewBo(MyActivityViewBo myActivityViewBo) {
		MyActivityViewBo = myActivityViewBo;
	}


	public CollectShareBo getCollectShareBo() {
		return CollectShareBo;
	}



	public void setCollectShareBo(CollectShareBo collectShareBo) {
		CollectShareBo = collectShareBo;
	}



	public String getMyActivityView()
	{
		String id = getParam("id").toString();
		List<MyActivityView> list = new ArrayList<MyActivityView>();
		try {
			list = getMyActivityViewBo().getMyActivityViewInformation(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
	public String getMyShareCollect()
	{
		String id = getParam("id").toString();
		List<CollectShare> list = new ArrayList<CollectShare>();
		try {
			list = getMyActivityViewBo().getShareCollectInformation(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
}