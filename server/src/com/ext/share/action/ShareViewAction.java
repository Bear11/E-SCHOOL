package com.ext.share.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.share.bo.ShareViewBo;
import com.ext.share.po.ShareView;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class ShareViewAction extends QssActionSupprot {

	private ShareView shareView;
	private ShareViewBo shareViewBo;
	private String msg;
	private List<ShareView> list;
	public ShareView getShareView() {
		return shareView;
	}
	public void setShareView(ShareView shareView) {
		this.shareView = shareView;
	}
	public ShareViewBo getShareViewBo() {
		return shareViewBo;
	}
	public void setShareViewBo(ShareViewBo shareViewBo) {
		this.shareViewBo = shareViewBo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<ShareView> getList() {
		return list;
	}
	public void setList(List<ShareView> list) {
		this.list = list;
	}
	
	/**
	 * 查询所有分享内容
	 * 
	 * @return
	 */
	public String findAllShareView() {
		List<ShareView> list = new ArrayList();
		try {
			list = getShareViewBo().findAllShareView();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("sharList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}
	

}
