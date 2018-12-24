package com.ext.campus.bo.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.bo.CampusSurroundCommentBo;
import com.ext.campus.po.CampusSurroundComment;
import com.ext.campus.dao.CampusSurroundCommentDao;

public class CampusSurroundCommentBoImpl extends HibernateDaoSupport implements CampusSurroundCommentBo
{
	
	private CampusSurroundCommentDao CampusSurroundCommentDao;
	
	public CampusSurroundCommentDao getCampusSurroundCommentDao() {
		return CampusSurroundCommentDao;
	}

	public void setCampusSurroundCommentDao(
			CampusSurroundCommentDao campusSurroundCommentDao) {
		CampusSurroundCommentDao = campusSurroundCommentDao;
	}

	@Override
	public void saveCampusSurroundCommentBo(CampusSurroundComment scenery)
			throws Exception {
		// TODO Auto-generated method stub
		
		int aid = scenery.getId();
		if(aid<0){
			CampusSurroundCommentDao.save(scenery);
		}else{
			CampusSurroundCommentDao.update(scenery);
		}	
		
	}

	@Override
	public void deleteCampusSurroundCommentBo(int id) throws Exception {
		// TODO Auto-generated method stub
		getCampusSurroundCommentDao().delete(id);
	}

}
