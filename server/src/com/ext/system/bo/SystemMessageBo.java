package com.ext.system.bo;

import com.ext.system.po.SystemMessage;

public interface SystemMessageBo {

	/**
	 * 
	 * @param SystemMessage
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存系统消息（包括更新）
	 */
	public abstract void saveSystemMessage(SystemMessage systemMessage) throws Exception;

	/**
	 * 
	 * @param SystemMessage
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteSystemMessage(int id) throws Exception;
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
