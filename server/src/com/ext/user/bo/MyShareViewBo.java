package com.ext.user.bo;

import java.util.List;

import com.ext.user.po.MyShareView;

public interface MyShareViewBo {
	/**
	 * 
	 * @param MyShare
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存我的分享（包括更新）
	 */
	
	public abstract void saveMyShareViewBo(MyShareView MyShareView) throws Exception;
	/**
	 * 
	 * @param MyShare
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteMyShareViewBo(int id) throws Exception;
	
	public List<MyShareView> getMyShareViewInformation(String id) throws Exception;
	
}
