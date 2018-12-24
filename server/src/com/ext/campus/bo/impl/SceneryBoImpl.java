package com.ext.campus.bo.impl;

import java.util.List;

import com.ext.campus.bo.SceneryBo;
import com.ext.campus.dao.SceneryDao;
import com.ext.campus.po.Scenery;



public class SceneryBoImpl implements SceneryBo{

	private  SceneryDao SceneryDao;
	
	
	public SceneryDao getSceneryDao() {
		return SceneryDao;
	}


	public void setSceneryDao(SceneryDao sceneryDao) {
		SceneryDao = sceneryDao;
	}


	@Override
	public void saveScenery(Scenery campus) throws Exception {
		// TODO Auto-generated method stub
		int aid = campus.getId();
		if(aid<0){
			getSceneryDao().save(campus);
		}else{
			getSceneryDao().update(campus);
		}	
	}

	
	@Override
	public void deleteScenery(int id) throws Exception {
		// TODO Auto-generated method stub
		getSceneryDao().delete(id);		
	}

	@Override
	public List<Scenery> getAllScenery() throws Exception {
		// TODO Auto-generated method stub
		List<Scenery> list = getSceneryDao().getAll();
		return list;
	}
	
}
