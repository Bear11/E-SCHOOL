package com.ext.user.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.user.bo.MyShareViewBo;
import com.ext.user.bo.UserGoodsViewBo;
import com.ext.user.po.MyShareView;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class MyShareViewAction extends QssActionSupprot{

	private MyShareViewBo MyShareViewBo;
	private UserGoodsViewBo UserGoodsViewBo;
	
	
	
	public UserGoodsViewBo getUserGoodsViewBo() {
		return UserGoodsViewBo;
	}

	public void setUserGoodsViewBo(UserGoodsViewBo userGoodsViewBo) {
		UserGoodsViewBo = userGoodsViewBo;
	}

	public MyShareViewBo getMyShareViewBo() {
		return MyShareViewBo;
	}

	public void setMyShareViewBo(MyShareViewBo MyShareViewBo) {
		this.MyShareViewBo = MyShareViewBo;
	}

	
	public String getMyShareView()
	{
		String id = getParam("id").toString();
		List<MyShareView> list = new ArrayList<MyShareView>();
		try {
			list = getMyShareViewBo().getMyShareViewInformation(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
}
