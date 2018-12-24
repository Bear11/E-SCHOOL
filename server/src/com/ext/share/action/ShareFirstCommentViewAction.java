package com.ext.share.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.share.bo.ShareFirstCommentViewBo;
import com.ext.share.po.ShareFirstCommentView;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;


public class ShareFirstCommentViewAction extends QssActionSupprot {

	ShareFirstCommentViewBo shareFirstCommentViewBo;
	ShareFirstCommentView shareFirstCommentView;
	private String msg;
	
	
	
	public ShareFirstCommentViewBo getShareFirstCommentViewBo() {
		return shareFirstCommentViewBo;
	}



	public void setShareFirstCommentViewBo(
			ShareFirstCommentViewBo shareFirstCommentViewBo) {
		this.shareFirstCommentViewBo = shareFirstCommentViewBo;
	}



	public ShareFirstCommentView getShareFirstCommentView() {
		return shareFirstCommentView;
	}



	public void setShareFirstCommentView(ShareFirstCommentView shareFirstCommentView) {
		this.shareFirstCommentView = shareFirstCommentView;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	/**
	 * 通过分项表id获得全部评论内容
	 * 
	 * @return
	 */
	public String findAllFCView() {
		String sid = getParam("sid").toString();
		int id = Integer.valueOf(sid);
		List<ShareFirstCommentView> list = new ArrayList();
		try {
			list = shareFirstCommentViewBo.listAllById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("sharefcList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}		 
}
