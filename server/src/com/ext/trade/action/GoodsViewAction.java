package com.ext.trade.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.trade.bo.GoodsViewBo;
import com.ext.trade.po.GoodsView;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class GoodsViewAction extends QssActionSupprot {

	private GoodsView goodsView;
	private GoodsViewBo goodsViewBo;
	private String msg;
	public GoodsView getGoodsView() {
		return goodsView;
	}
	public void setGoodsView(GoodsView goodsView) {
		this.goodsView = goodsView;
	}
	public GoodsViewBo getGoodsViewBo() {
		return goodsViewBo;
	}
	public void setGoodsViewBo(GoodsViewBo goodsViewBo) {
		this.goodsViewBo = goodsViewBo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 查询所有商品资讯
	 * 
	 * @return
	 */
	public String findAllGoodsView() {
		List<GoodsView> list = new ArrayList();
		try {
			list = getGoodsViewBo().getAllGoodsView();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("gVList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	
	/**
	 * 通过id获得物品详情
	 * 
	 * @return
	 */
	public String findById() {
		
		String id = getParam("id").toString();
		int gid = Integer.valueOf(id);
		try {
			goodsView = getGoodsViewBo().findById(gid);
		} catch (Exception e) {
		}
		JSONObject json = new JSONObject();
		json.put("goodsView", output4ajax(new Object[] { goodsView }));
		return ResponseUtil.returnJson(json.toString());

	}
}
