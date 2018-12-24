package com.ext.share.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.share.bo.ShareFirstCommentBo;
import com.ext.share.dao.ShareFirstCommentDao;
import com.ext.share.po.ShareFirstComment;

public class ShareFirstCommentBoImpl extends HibernateDaoSupport implements
		ShareFirstCommentBo {

	ShareFirstCommentDao shareFirstCommentDao;

	public ShareFirstCommentDao getShareFirstCommentDao() {
		return shareFirstCommentDao;
	}

	public void setShareFirstCommentDao(
			ShareFirstCommentDao shareFirstCommentDao) {
		this.shareFirstCommentDao = shareFirstCommentDao;
	}

	@Override
	public void saveShareFirstComment(ShareFirstComment shareFirstComment)
			throws Exception {
		// TODO Auto-generated method stub
		int id = shareFirstComment.getId();
		if (id < 0) {
			getShareFirstCommentDao().save(shareFirstComment);
		} else {
			getShareFirstCommentDao().update(shareFirstComment);
		}
	}

	@Override
	public void deleteShareFirstComment(int id) throws Exception {
		// TODO Auto-generated method stub
		getShareFirstCommentDao().delete(id);
	}

/*	@Override
	public List<ShareFirstComment> listAllByShareId(int shareId)
			throws Exception {
		// TODO Auto-generated method stub
		String sid = String.valueOf(shareId);
		String hql = " from ShareFirstComment sfc where sfc.shareId =" + sid;
		hql = hql + " order by sfc.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<ShareFirstComment> list = query.list();
		System.out.println(list);
	 	return list;
	}*/

}
