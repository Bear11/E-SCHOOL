package com.ext.trade.action;

import java.util.Date;

import net.sf.json.JSONObject;

import com.ext.trade.bo.ItemsBo;
import com.ext.trade.po.Items;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class ItemsAction extends QssActionSupprot {
	
	private Items items;
	private ItemsBo itemsBo;
	private String msg;
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsBo getItemsBo() {
		return itemsBo;
	}
	public void setItemsBo(ItemsBo itemsBo) {
		this.itemsBo = itemsBo;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 保存、更新物品信息
	 * 
	 * @return
	 */
	public String saveItems() {
		msg = "";
		int flag = Integer.valueOf(getParam("flag").toString());
		String personId = getParam("personId").toString();
		String goodsname = getParam("goodsname").toString();
		String phonenumber = getParam("phonenumber").toString();
		String goodsdescribe = getParam("goodsdescribe").toString();
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		items.setPersonId(Integer.valueOf(personId));
		items.setName(goodsname);
		items.setDiscribe(goodsdescribe);
		items.setNumber(1); //默认为1
		items.setPhoneNumber(phonenumber);
		items.setPlayTime(curDate); //get current time
		items.setType(flag); //0表示是失物,1标识赠品
		try {
			getItemsBo().saveItems(items);
			msg = "success";
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}

}