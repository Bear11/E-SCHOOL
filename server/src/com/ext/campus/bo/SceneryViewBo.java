package com.ext.campus.bo;


import java.util.List;

import com.ext.campus.po.SceneryView;

public interface SceneryViewBo {
	
	/**
	 * 
	 * @param SceneryView
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:获取所有信息（包括更新）
	 */
	public abstract List<SceneryView> getAllSceneryView()throws Exception;

}
