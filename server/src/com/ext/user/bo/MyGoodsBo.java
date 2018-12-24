package com.ext.user.bo;

import com.ext.user.po.MyGoods;

public interface MyGoodsBo {
	/**
	 * 
	 * @param MyGoods
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存我的商品（包括更新）
	 */
	
	public abstract void saveMyGoodsBo(MyGoods MyGoods) throws Exception;
	/**
	 * 
	 * @param MyGoods
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteMyGoodsBo(int id) throws Exception;
	/**
	 * 
	 * @param Course
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
	
	public String updateGoods(int x,String id) throws Exception;
	
}
