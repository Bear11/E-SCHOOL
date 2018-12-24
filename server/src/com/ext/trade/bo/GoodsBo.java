package com.ext.trade.bo;

import java.util.List;

import com.ext.share.po.Share;
import com.ext.trade.po.Goods;

public interface GoodsBo {

	/**
	 * 
	 * @param Goods
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存商品（包括更新）
	 */
	public abstract void saveGoods(Goods goods) throws Exception;

	/**
	 * 
	 * @param Goods
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteGoods(int id) throws Exception;
	/**
	 * 
	 * @param Goods
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询，建立视图
	 */
	// public abstract PubMedView getPubmedView(String id)throws Exception;
	/**
	 * 
	 * @param Goods
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询所有
	 */
	public abstract List<Goods> getAllGoods()throws Exception;
}
