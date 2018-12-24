package com.ext.campus.bo;

import java.util.List;

import com.ext.campus.po.CampusSurroundComment;

public interface CampusSurroundCommentBo {
	/**
	 * 
	 * @param CampusInformationBo
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存校园活动（包括更新）
	 */
	public abstract void saveCampusSurroundCommentBo(CampusSurroundComment scenery) throws Exception;

	/**
	 * 
	 * @param CampusInformationBo
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteCampusSurroundCommentBo(int id) throws Exception;
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