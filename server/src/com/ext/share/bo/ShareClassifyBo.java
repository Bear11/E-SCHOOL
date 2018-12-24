package com.ext.share.bo;

import com.ext.share.po.ShareClassify;

public interface ShareClassifyBo {

	/**
	 * 
	 * @param ShareClassify
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存分享分类表（包括更新）
	 */
	public abstract void saveShareClassify(ShareClassify shareClassify) throws Exception;

	/**
	 * 
	 * @param ShareClassify
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteShareClassify(int id) throws Exception;
	/**
	 * 
	 * @param ShareClassify
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
