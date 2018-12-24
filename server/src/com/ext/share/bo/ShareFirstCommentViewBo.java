package com.ext.share.bo;

import java.util.List;

import com.ext.share.po.ShareFirstCommentView;

public interface ShareFirstCommentViewBo {

	/**
	 * 
	 * @param ShareFirstCommentView
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存分享一级评论表（包括更新）
	 */
	public abstract void saveShareFirstCommentView(ShareFirstCommentView shareFirstCommentView) throws Exception;

	/**
	 * 
	 * @param ShareFirstCommentView
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteShareFirstCommentView(int id) throws Exception;

	/**
	 * 
	 * @param ShareFirstCommentView
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询所有
	 */
	public abstract List<ShareFirstCommentView> listAllById(int shareId)throws Exception;
	
	

}
