package com.ext.share.bo;

import java.util.List;

import com.ext.share.po.Share;
import com.ext.share.po.ShareFirstComment;

public interface ShareFirstCommentBo {

	/**
	 * 
	 * @param ShareFirstComment
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存分享评论表（包括更新）
	 */
	public abstract void saveShareFirstComment(ShareFirstComment shareFirstComment) throws Exception;

	/**
	 * 
	 * @param ShareFirstComment
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteShareFirstComment(int id) throws Exception;

	/**
	 * 
	 * @param ShareFirstComment
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询所有
	 */
	//public abstract List<ShareFirstComment> listAllByShareId(int shareId)throws Exception;
	
	

}
