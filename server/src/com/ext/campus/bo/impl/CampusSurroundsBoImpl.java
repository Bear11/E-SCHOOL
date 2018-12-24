package com.ext.campus.bo.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.bo.CampusSurroundBo;
import com.ext.campus.bo.CampusSurroundsBo;
import com.ext.campus.dao.CampusSurroundsDao;
import com.ext.campus.po.CampusSurrounds;

public class CampusSurroundsBoImpl extends HibernateDaoSupport implements CampusSurroundsBo{

	private CampusSurroundsDao CampusSurroundsDao;
	
	public CampusSurroundsDao getCampusSurroundsDao() {
		return CampusSurroundsDao;
	}

	public void setCampusSurroundsDao(CampusSurroundsDao campusSurroundsDao) {
		CampusSurroundsDao = campusSurroundsDao;
	}

	@Override
	public void saveCampusSurroundsBo(CampusSurrounds scenery) throws Exception {
		// TODO Auto-generated method stub
		int aid = scenery.getId();
		if(aid<0){
			CampusSurroundsDao.save(scenery);
		}else{
			CampusSurroundsDao.update(scenery);
		}	
		
	}

	@Override
	public void deleteCampusSurroundsBo(int id) throws Exception {
		// TODO Auto-generated method stub
		getCampusSurroundsDao().delete(id);
		
	}

	@Override
	public String updateClick(int id, int new_cnum) throws Exception {
		// TODO Auto-generated method stub
		String msg = " ";
		String hql = " update CampusSurrounds s set s.clickNumber =" + new_cnum
				+ " where s.id =" + id;
		// getShareDao().save(share);
		getCampusSurroundsDao().createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
	}

}
