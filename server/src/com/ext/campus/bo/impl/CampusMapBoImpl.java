package com.ext.campus.bo.impl;

import com.ext.campus.bo.CampusMapBo;
import com.ext.campus.dao.CampusMapDao;
import com.ext.campus.po.CampusInformation;
import com.ext.campus.po.CampusMap;

public class CampusMapBoImpl implements CampusMapBo{

	
	private  CampusMapDao CampusMapDao;
	
	public CampusMapDao getCampusMapDao() {
		return CampusMapDao;
	}

	public void setCampusDao(CampusMapDao campusDao) {
		this.CampusMapDao = campusDao;
	}
	@Override
	public void saveCampusMapBo(CampusMap scenery) throws Exception {
		// TODO Auto-generated method stub
		int aid = scenery.getId();
		if(aid<0){
			CampusMapDao.save(scenery);
		}else{
			CampusMapDao.update(scenery);
		}	
		
	}

	@Override
	public void deleteCampusMapBo(int id) throws Exception {
		// TODO Auto-generated method stub
		getCampusMapDao().delete(id);
	}

}
