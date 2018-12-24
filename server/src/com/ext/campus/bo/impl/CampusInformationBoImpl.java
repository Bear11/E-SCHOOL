package com.ext.campus.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.bo.CampusInformationBo;
import com.ext.campus.dao.CampusInformationDao;
import com.ext.campus.po.CampusInformation;

public class CampusInformationBoImpl extends HibernateDaoSupport implements CampusInformationBo{

	private  CampusInformationDao CampusInformationDao;
	
	
	public CampusInformationDao getCampusInformationDao() {
		return CampusInformationDao;
	}

	public void setCampusInformationDao(CampusInformationDao campusInformationDao) {
		CampusInformationDao = campusInformationDao;
	}

	@Override
	public void saveCampusInformationDao(CampusInformation scenery) throws Exception {
		// TODO Auto-generated method stub
		int aid = scenery.getId();
		if(aid<0){
			CampusInformationDao.save(scenery);
		}else{
			CampusInformationDao.update(scenery);
		}	
	}

	@Override
	public void deleteCampusInformationDao(int id) throws Exception {
		// TODO Auto-generated method stub
		getCampusInformationDao().delete(id);
	}

//	@Override
//	public CampusInformation findCampusInformation(String userAct)
//			throws Exception {
//		// TODO Auto-generated method stub
//				String hql = "from CampusInformation us where us.id =? ";
////				UserInformation s = getUserInformationDao().findUnique(hql, userAct,userPwd);
//				return getCampusInformationDao().findUnique(hql, userAct);		
//	}
	@Override
	public List<CampusInformation> findCampusInformation(String userAct)
	throws Exception {
		String hql = "from CampusInformation us";
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<CampusInformation> list = query.list();
		return list;
	}

}
