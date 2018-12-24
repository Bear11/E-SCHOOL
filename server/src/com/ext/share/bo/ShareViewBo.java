package com.ext.share.bo;

import java.util.List;

import com.ext.share.po.ShareView;

public interface ShareViewBo {

	/**
	 * 
	 * @param ShareView
	 * @throws Exception
	 * @date 日期: 2016-8-14下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存分享（包括更新）
	 */
	public abstract void saveShareView(ShareView shareView) throws Exception;

	/**
	 * 
	 * @param ShareView
	 * @throws Exception
	 * @date 日期: 2016-8-14 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteShareView(int id) throws Exception;
	/**
	 * 
	 * @param ShareView
	 * @throws Exception
	 * @date 日期: 2016-8-14 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract List<ShareView> findAllShareView() throws Exception;
	
}
