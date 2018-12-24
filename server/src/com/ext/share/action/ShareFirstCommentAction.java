package com.ext.share.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.ext.share.bo.ShareFirstCommentBo;
import com.ext.share.dao.ShareFirstCommentDao;
import com.ext.share.po.Share;
import com.ext.share.po.ShareFirstComment;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;


public class ShareFirstCommentAction extends QssActionSupprot {

	private ShareFirstComment shareFirstComment;
	private ShareFirstCommentDao shareFirstCommentDao;
	private ShareFirstCommentBo shareFirstCommentBo;
	private String msg;
	public ShareFirstComment getShareFirstComment() {
		return shareFirstComment;
	}
	public void setShareFirstComment(ShareFirstComment shareFirstComment) {
		this.shareFirstComment = shareFirstComment;
	}
	public ShareFirstCommentDao getShareFirstCommentDao() {
		return shareFirstCommentDao;
	}
	public void setShareFirstCommentDao(ShareFirstCommentDao shareFirstCommentDao) {
		this.shareFirstCommentDao = shareFirstCommentDao;
	}
	public ShareFirstCommentBo getShareFirstCommentBo() {
		return shareFirstCommentBo;
	}
	public void setShareFirstCommentBo(ShareFirstCommentBo shareFirstCommentBo) {
		this.shareFirstCommentBo = shareFirstCommentBo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 保存分享的一級评论内容
	 * 
	 */
	public String savaShareFirstCommnet(){
		
		String objpid = getParam("pid").toString();
		String sid = getParam("sid").toString();
		String content = getParam("describe").toString();
		
		shareFirstComment.setCommentTime(new Date());
		shareFirstComment.setFloor(1);
		shareFirstComment.setObjpersonId(Integer.valueOf(objpid));
		shareFirstComment.setShareId(Integer.valueOf(sid)); 
		shareFirstComment.setContent(content);
		 
		try {
			 getShareFirstCommentBo().saveShareFirstComment(shareFirstComment);
			 msg = "success";
		} catch (Exception e){		
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
		
	}
	
	/**
	 * 计算以及评论表长度
	 * 
	 */
	public String getSFCLength(){
	 
		try {
			 getShareFirstCommentBo().saveShareFirstComment(shareFirstComment);
			 msg = "success";
		} catch (Exception e){		
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
		
	}
	/**
	 * 通过分项表id获得全部评论内容
	 * 
	 * @return
	 */
	/*public String listAllByShareId() {
		String sid = getParam("sid").toString();	
		List<ShareFirstComment> list = new ArrayList();
		try {
			list = getShareFirstCommentBo().listAllByShareId(Integer.valueOf(sid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("sharefcList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}*/
	
	 
}
