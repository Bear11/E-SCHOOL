package com.ext.campus.bo.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.bo.CampusSurroundBo;
import com.ext.campus.bo.CampusSurroundCommentViewBo;
import com.ext.campus.po.CampusSurround;
import com.ext.campus.dao.CampusSurroundCommentViewDao;
import com.ext.campus.po.CampusSurroundCommentView;
import com.ext.util.ResponseUtil;

public class CampusSurroundCommentViewBoImpl extends HibernateDaoSupport implements CampusSurroundCommentViewBo{

	CampusSurroundCommentViewDao CampusSurroundCommentViewDao;
	
	public CampusSurroundCommentViewDao getCampusSurroundCommentViewDao() {
		return CampusSurroundCommentViewDao;
	}

	public void setCampusSurroundCommentViewDao(
			CampusSurroundCommentViewDao campusSurroundCommentViewDao) {
		CampusSurroundCommentViewDao = campusSurroundCommentViewDao;
	}

	public void saveCampusSurroundCommentViewBo(
			CampusSurroundCommentView scenery) throws Exception {
		// TODO Auto-generated method stub
		int aid = scenery.getId();
		if(aid<0){
			CampusSurroundCommentViewDao.save(scenery);
		}else{
			CampusSurroundCommentViewDao.update(scenery);
		}	
		
	}

	@Override
	public void deleteCampusSurroundCommentViewBo(int id) throws Exception {
		// TODO Auto-generated method stub
		getCampusSurroundCommentViewDao().delete(id);
	}

	@Override
	public List<CampusSurroundCommentView> findCampusSurroundComment(String id)
	throws Exception {
		String hql = "from CampusSurroundCommentView us where us.CampusID="+id;
		//hql = hql + " order by us.id desc";
		List<CampusSurroundCommentView> list= new ArrayList<CampusSurroundCommentView>();
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		list = query.list();
		return list;
	}
	

}
