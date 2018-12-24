package com.ext.campus.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.bo.SchoolInformationViewBo;
import com.ext.campus.dao.SchoolInformationViewDao;
import com.ext.campus.po.CampusSurroundCommentView;
import com.ext.campus.po.SchoolInformationView;

public class SchoolInformationViewBoImpl extends HibernateDaoSupport implements SchoolInformationViewBo{

	private SchoolInformationViewDao SchoolInformationViewDao;
	
	
	@Override
	public void saveSchoolInformationViewBo(SchoolInformationView scenery)
			throws Exception {
		// TODO Auto-generated method stub
				int aid = scenery.getId();
				if(aid<0){
					SchoolInformationViewDao.save(scenery);
				}else{
					SchoolInformationViewDao.update(scenery);
				}	
	}

	@Override
	public void deleteSchoolInformationViewBo(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SchoolInformationView> findSchoolInformation(String ID)
			throws Exception {
		// TODO Auto-generated method stub
		String hql = "from School us where us.id="+ID;
		//hql = hql + " order by us.id desc";
		List<SchoolInformationView> list= new ArrayList<SchoolInformationView>();
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		list = query.list();
		return list;
	}

}
