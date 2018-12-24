package com.ext.campus.bo.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.bo.SchoolInformationViewBo;
import com.ext.campus.bo.SetCampusSurroundBo;
import com.ext.campus.po.SetCampusSurround;
import com.ext.campus.dao.SetCampusSurroundDao;

public class SetCampusSurroundBoImpl extends HibernateDaoSupport implements SetCampusSurroundBo
{
	
	private SetCampusSurroundDao SetCampusSurroundDao;
	
	public SetCampusSurroundDao getSetCampusSurroundDao() {
		return SetCampusSurroundDao;
	}

	public void setSetCampusSurroundDao(SetCampusSurroundDao setCampusSurroundDao) {
		SetCampusSurroundDao = setCampusSurroundDao;
	}

	@Override
	public void saveSetCampusSurroundBo(SetCampusSurround scenery)
			throws Exception {
		// TODO Auto-generated method stub
		int aid = scenery.getId();
		if(aid<0){
			SetCampusSurroundDao.save(scenery);
		}else{
			SetCampusSurroundDao.update(scenery);
		}	
		
	}

	@Override
	public void deleteSetCampusSurroundBo(int id) throws Exception {
		// TODO Auto-generated method stub
		getSetCampusSurroundDao().delete(id);
	}

}
