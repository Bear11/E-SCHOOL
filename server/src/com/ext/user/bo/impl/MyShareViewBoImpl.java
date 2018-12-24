package com.ext.user.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.user.bo.MyShareViewBo;
import com.ext.user.po.MyShareView;
import com.ext.user.dao.MyShareViewDao;

public class MyShareViewBoImpl extends HibernateDaoSupport implements MyShareViewBo{

	private MyShareViewDao MyShareViewDao;

	public MyShareViewDao getMyShareViewDao() {
		return MyShareViewDao;
	}

	public void setMyShareViewDao(MyShareViewDao myShareViewDao) {
		MyShareViewDao = myShareViewDao;
	}

	@Override
	public void saveMyShareViewBo(MyShareView MyShareView) throws Exception {
		// TODO Auto-generated method stub
		int aid = MyShareView.getId();
		if(aid<0){
			MyShareViewDao.save(MyShareView);
		}else{
			MyShareViewDao.update(MyShareView);
		}	
	}

	@Override
	public void deleteMyShareViewBo(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<MyShareView> getMyShareViewInformation(String id) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from MyShareView us where us.PERSONID="+id;
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<MyShareView> list = query.list();
		return list;
	}
	
}

