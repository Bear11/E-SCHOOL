package com.ext.system.bo;

import com.ext.system.po.Feedback;

public interface FeedbackBo {

	/**
	 * 
	 * @param Feedback
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存反馈信息（包括更新）
	 */
	public abstract void saveFeedback(Feedback feedback) throws Exception;

	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteFeedback(int id) throws Exception;
	/**
	 * 
	 * @param Feedback
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
