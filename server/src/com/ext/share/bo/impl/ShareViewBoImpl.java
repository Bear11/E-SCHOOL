package com.ext.share.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.share.bo.ShareViewBo;
import com.ext.share.dao.ShareViewDao;
import com.ext.share.po.Share;
import com.ext.share.po.ShareView;


public class ShareViewBoImpl extends HibernateDaoSupport implements ShareViewBo {

	ShareViewDao shareViewDao ;
		
	public ShareViewDao getShareViewDao() {
		return shareViewDao;
	}

	public void setShareViewDao(ShareViewDao shareViewDao) {
		this.shareViewDao = shareViewDao;
	}

	@Override
	public void saveShareView(ShareView shareView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShareView(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShareView> findAllShareView() throws Exception {
		// TODO Auto-generated method stub
		String hql = " from ShareView sv";
		hql = hql + " order by sv.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<ShareView> list = query.list();
		return list;
	}

	
}
