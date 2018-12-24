package com.ext.trade.bo;

import com.ext.trade.po.Items;

public interface ItemsBo {

	/**
	 * 
	 * @param Items
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存物品（包括更新）
	 */
	public abstract void saveItems(Items items) throws Exception;

	/**
	 * 
	 * @param Items
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteItems(int id) throws Exception;
	/**
	 * 
	 * @param Items
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
