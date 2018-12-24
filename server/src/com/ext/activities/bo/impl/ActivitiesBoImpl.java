package com.ext.activities.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.activities.bo.ActivitiesBo;
import com.ext.activities.dao.ActivitiesDao;
import com.ext.activities.po.Activities;
import com.ext.share.po.Share;


public class ActivitiesBoImpl extends HibernateDaoSupport implements ActivitiesBo{

	private  ActivitiesDao activitiesDao;
	
	public ActivitiesDao getActivitiesDao() {
		return activitiesDao;
	}

	public void setActivitiesDao(ActivitiesDao activitiesDao) {
		this.activitiesDao = activitiesDao;
	}

	@Override
	public void saveActivities(Activities activities) throws Exception {
		// TODO Auto-generated method stub
		int aid = activities.getId();
		if(aid<0){
			activitiesDao.save(activities);
		}else{
			activitiesDao.update(activities);
		}	
	}

	
	@Override
	public void deleteActivities(int id) throws Exception {
		// TODO Auto-generated method stub
		getActivitiesDao().delete(id);	
	}

	@Override
	public List<Activities> listActivities() throws Exception {
		// TODO Auto-generated method stub
		String hql = " from Activities a";
		hql = hql + " order by a.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<Activities> list = query.list();
		return list;
	}

	@Override
	public Activities findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return getActivitiesDao().get(id);
	
	}
	
	
}
