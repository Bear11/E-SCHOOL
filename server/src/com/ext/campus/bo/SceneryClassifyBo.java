package com.ext.campus.bo;

import com.ext.campus.po.SceneryClassify;

public interface SceneryClassifyBo {
	/**
	 * 
	 * @param SceneryClassify
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存风景分类表（包括更新）
	 */
	public abstract void saveSceneryClassify(SceneryClassify sceneryclassify) throws Exception;

	/**
	 * 
	 * @param SceneryClassify
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteSceneryClassify(int id) throws Exception;
	/**
	 * 
	 * @param Activities
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
