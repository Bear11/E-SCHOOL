package com.ext.trade.bo;

import java.util.List;

import com.ext.trade.po.ItemsView;

public interface ItemsViewBo {

	
	
	/**
	 * 
	 * @param ItemsView
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @description 描述:通过传入的状态值来判断是失物还是商品，然后取得所有
	 */
	public abstract List<ItemsView> getAllItemsView(int flag)throws Exception;
	/**
	 * 
	 * @param ItemsView
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
