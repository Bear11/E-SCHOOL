package com.ext.trade.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.trade.bo.ItemsViewBo;
import com.ext.trade.po.GoodsView;
import com.ext.trade.po.ItemsView;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class ItemsViewAction extends QssActionSupprot {
	
	private ItemsView itemsView;
	private ItemsViewBo itemsViewBo;
	private String msg ;
	public ItemsView getItemsView() {
		return itemsView;
	}
	public void setItemsView(ItemsView itemsView) {
		this.itemsView = itemsView;
	}
	public ItemsViewBo getItemsViewBo() {
		return itemsViewBo;
	}
	public void setItemsViewBo(ItemsViewBo itemsViewBo) {
		this.itemsViewBo = itemsViewBo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 查询所有物品、赠品资讯
	 * 
	 * @return
	 */
	public String findAllItemsView() {
		List<ItemsView> list = new ArrayList();
		//获得一个状态值，方便判断是为失物还是商品
		int flag = Integer.valueOf(getParam("flag").toString());		
		try {
			list = getItemsViewBo().getAllItemsView(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("iVList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}

}