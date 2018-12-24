package com.ext.share.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.share.bo.ShareFirstCommentViewBo;
import com.ext.share.dao.ShareFirstCommentViewDao;
import com.ext.share.po.ShareFirstCommentView;

public class ShareFirstCommentViewBoImpl extends HibernateDaoSupport implements
		ShareFirstCommentViewBo {

	ShareFirstCommentViewDao shareFirstCommentViewDao;

	ShareFirstCommentViewDao getShareFirstCommentViewDao() {
		return shareFirstCommentViewDao;
	}

	void setShareFirstCommentViewDao(
			ShareFirstCommentViewDao shareFirstCommentViewDao) {
		this.shareFirstCommentViewDao = shareFirstCommentViewDao;
	}

	@Override
	public void saveShareFirstCommentView(
			ShareFirstCommentView shareFirstCommentView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShareFirstCommentView(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShareFirstCommentView> listAllById(int shareId)
			throws Exception {
		// TODO Auto-generated method stub
		String sid = String.valueOf(shareId);
		String hql = " from ShareFirstCommentView sfc where sfc.shareId='"+sid+"'";
		hql = hql + " order by sfc.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<ShareFirstCommentView> list = query.list();
		System.out.println(list);
		return list;
	}

	
	
}
