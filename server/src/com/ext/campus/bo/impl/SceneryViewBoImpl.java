package com.ext.campus.bo.impl;

import java.util.List;

import com.ext.campus.bo.SceneryViewBo;
import com.ext.campus.dao.SceneryViewDao;
import com.ext.campus.po.SceneryView;



public class SceneryViewBoImpl implements SceneryViewBo{

	private  SceneryViewDao SceneryViewDao;

	public SceneryViewDao getSceneryViewDao() {
		return SceneryViewDao;
	}

	public void setSceneryViewDao(SceneryViewDao sceneryViewDao) {
		SceneryViewDao = sceneryViewDao;
	}

	@Override
	public List<SceneryView> getAllSceneryView() throws Exception {
		// TODO Auto-generated method stub
		return getSceneryViewDao().getAll();
	}
	
	
	


	
	
}
