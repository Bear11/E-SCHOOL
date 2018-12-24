package com.ext.campus.bo;

import com.ext.campus.po.SchoolInformationView;
import com.ext.campus.po.SetCampusSurround;

public interface SetCampusSurroundBo {
	/**
	 * 
	 * @param CampusInformationBo
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存校园活动（包括更新）
	 */
	public abstract void saveSetCampusSurroundBo(SetCampusSurround scenery) throws Exception;

	/**
	 * 
	 * @param CampusInformationBo
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteSetCampusSurroundBo(int id) throws Exception;
	/**
	 * 
	 * @param Activities
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询，建立视图
	 */
}
