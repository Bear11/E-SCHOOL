package com.ext.trade.bo;

import java.util.List;

import com.ext.share.po.Share;
import com.ext.trade.po.GoodsView;

public interface GoodsViewBo {

	
	/**
	 * 
	 * @param GoodsView
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询，建立视图
	 */
	// public abstract PubMedView getPubmedView(String id)throws Exception;
	/**
	 * 
	 * @param GoodsView
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询所有
	 */
	public abstract List<GoodsView> getAllGoodsView()throws Exception;
	/**
	 * 
	 * @param GoodsView
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:通过id导出其他详情
	 */
	public abstract GoodsView findById(int id)throws Exception;
}
