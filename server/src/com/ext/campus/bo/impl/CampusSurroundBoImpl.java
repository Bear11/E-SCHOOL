package com.ext.campus.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.bo.CampusSurroundBo;
import com.ext.campus.dao.CampusSurroundDao;
import com.ext.campus.po.CampusInformation;
import com.ext.campus.po.CampusSurround;



public class CampusSurroundBoImpl extends HibernateDaoSupport implements CampusSurroundBo{

	private CampusSurroundDao CampusSurroundDao;
	
	public CampusSurroundDao getCampusSurroundDao() {
		return CampusSurroundDao;
	}

	public void setCampusSurroundDao(CampusSurroundDao CampusSurroundDao) {
		this.CampusSurroundDao = CampusSurroundDao;
	}
	@Override
	public void saveCampusSurroundBo(CampusSurround scenery) throws Exception {
		// TODO Auto-generated method stub
		int aid = scenery.getId();
		if(aid<0){
			CampusSurroundDao.save(scenery);
		}else{
			CampusSurroundDao.update(scenery);
		}	
	}

	@Override
	public void deleteCampusSurroundnBo(int id) throws Exception {
		// TODO Auto-generated method stub
		getCampusSurroundDao().delete(id);
	}

	@Override
	public List<CampusSurround> findCampusSurround(String userAct)
	throws Exception {
		String hql = "from CampusSurround us";
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<CampusSurround> list = query.list();
		return list;
	}
}
