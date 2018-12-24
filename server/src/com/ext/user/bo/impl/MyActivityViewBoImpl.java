package com.ext.user.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.user.bo.MyActivityViewBo;
import com.ext.user.po.CollectShare;
import com.ext.user.po.MyActivityView;
import com.ext.user.po.MyShareView;

public class MyActivityViewBoImpl extends HibernateDaoSupport implements MyActivityViewBo{

	@Override
	public void saveMyCollectBo(MyActivityView MyActivityView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMyCollectBo(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MyActivityView> getMyActivityViewInformation(String id) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from MyActivityView us where us.PERSONID="+id;
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<MyActivityView> list = query.list();
		return list;
	}

	@Override
	public List<CollectShare> getShareCollectInformation(String id) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from CollectShare us where us.PERSONID="+id;
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<CollectShare> list = query.list();
		return list;
	}
	
}
