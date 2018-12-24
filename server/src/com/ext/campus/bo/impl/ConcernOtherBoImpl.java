package com.ext.campus.bo.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.bo.CampusSurroundBo;
import com.ext.campus.bo.ConcernOtherBo;
import com.ext.campus.po.CampusSurrounds;
import com.ext.campus.po.ConcernOther;
import com.ext.campus.dao.ConcernOtherDao;

public class ConcernOtherBoImpl extends HibernateDaoSupport implements ConcernOtherBo{

	private ConcernOtherDao ConcernOtherDao;
	
	public ConcernOtherDao getConcernOtherDao() {
		return ConcernOtherDao;
	}

	public void setConcernOtherDao(ConcernOtherDao concernOtherDao) {
		ConcernOtherDao = concernOtherDao;
	}

	@Override
	public void saveConcernOtherBo(ConcernOther scenery) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int aid = scenery.getId();
				if(aid<0){
					ConcernOtherDao.save(scenery);
				}else{
					ConcernOtherDao.update(scenery);
				}	
	}

	@Override
	public void deleteConcernOtherBo(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
