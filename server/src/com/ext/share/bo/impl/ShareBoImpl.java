 package com.ext.share.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.share.bo.ShareBo;
import com.ext.share.dao.ShareDao;
import com.ext.share.po.Share;

public class ShareBoImpl extends HibernateDaoSupport implements ShareBo {

	private ShareDao shareDao;

	public ShareDao getShareDao() {
		return shareDao;
	}

	public void setShareDao(ShareDao shareDao) {
		this.shareDao = shareDao;
	}

	@Override
	public void saveShare(Share share) throws Exception {
		// TODO Auto-generated method stub
		int aid = share.getId();
		if (aid < 0) {
			getShareDao().save(share);
		} else {
			getShareDao().update(share);
		}

	}

	@Override
	public void deleteShare(int id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Share> getAllShare() throws Exception {
		// TODO Auto-generated method stub
		String hql = " from Share s";
		hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<Share> list = query.list();
		return list;
	}

	@Override
	public String updateGaL(int id, int new_cnum) throws Exception {
		// TODO Auto-generated method stub
		String msg = " ";
		String hql = " update Share s set s.clickNumber =" + new_cnum
				+ " where s.id =" + id;
		// getShareDao().save(share);
		getShareDao().createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
		// }

		// Transaction tx = session.beginTransaction();
		// String
		// hql="updata Share a set a.clickNumber = a.clickNumber + 1 where a.id = id";
		// Query query =
		// getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);

		// Query query = session.createQuery(hql);
		// query.setInteger("clickNumber", share.getClickNumber());
		// query.setInteger("id", share.getId());

		// query.executeUpdate();

		// tx.commit();
		// session.close();

	}

	@Override
	public Share findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return getShareDao().get(id);
	}

	@Override
	public String updatePls(int id, int new_cnum) throws Exception {
		// TODO Auto-generated method stub
		String msg = " ";
		String hql = " update Share s set s.commentNumber =" + new_cnum
				+ " where s.id =" + id;
		// getShareDao().save(share);
		getShareDao().createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
	}

	@Override
	public String updateZfl(int id, int new_cnum) throws Exception {
		// TODO Auto-generated method stub
		String msg = " ";
		String hql = " update Share s set s.forwardNumber =" + new_cnum
				+ " where s.id =" + id;
		// getShareDao().save(share);
		getShareDao().createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
	}

}
