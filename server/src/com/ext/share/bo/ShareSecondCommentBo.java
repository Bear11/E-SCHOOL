package com.ext.share.bo;

import com.ext.share.po.ShareSecondComment;

public interface ShareSecondCommentBo {

	/**
	 * 
	 * @param ShareSecondComment
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存二级评论（包括更新）
	 */
	
	public abstract void saveShareSecondComment(ShareSecondComment shareSecondComment) throws Exception;
	/**
	 * 
	 * @param ShareSecondComment
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteShareSecondComment(int id) throws Exception;
	/**
	 * 
	 * @param ShareSecondComment
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询，建立视图
	 */
	// public abstract PubMedView getPubmedView(String id)throws Exception;
	/**
	 * 
	 * @param ActivitiesClassify
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:保存方法（包括更新）
	 */

}
