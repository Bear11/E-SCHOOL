package com.ext.trade.action;

import java.util.Date;

import net.sf.json.JSONObject;

import com.ext.trade.bo.GoodsBo;
import com.ext.trade.po.Goods;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class GoodsAction extends QssActionSupprot {
	
	private GoodsBo goodsBo; 
	private Goods goods;
	private String msg;
	public GoodsBo getGoodsBo() {
		return goodsBo;
	}
	public void setGoodsBo(GoodsBo goodsBo) {
		this.goodsBo = goodsBo;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 保存商品资讯
	 * 
	 * @return
	 */
	public String saveGoods() {
		msg = null;	
		String personId = getParam("personId").toString();
		String goodsname = getParam("goodsname").toString();	
		String goodsprice = getParam("goodsprice").toString();
		String goodsnumber = getParam("goodsnumber").toString();
		String phonenumber = getParam("phonenumber").toString();
		String goodsdescribe = getParam("goodsdescribe").toString();
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		goods.setPersonId(Integer.valueOf(personId));
		goods.setName(goodsname);		
		goods.setPrice(Double.valueOf(goodsprice));
		goods.setNumber(Integer.valueOf(goodsnumber));
		goods.setPhoneNumber(phonenumber);		
		goods.setDiscribe(goodsdescribe);
		goods.setPlayTime(curDate);
		goods.setState(1); //默认为1，表示有存货
		//goodsView.setlSchoolId(lSchoolId);
		try {
			getGoodsBo().saveGoods(goods);
			msg = "success";
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}

}
