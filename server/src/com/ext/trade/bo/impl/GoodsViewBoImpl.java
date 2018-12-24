package com.ext.trade.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.share.po.ShareView;
import com.ext.trade.bo.GoodsViewBo;
import com.ext.trade.dao.GoodsViewDao;
import com.ext.trade.po.GoodsView;

public class GoodsViewBoImpl extends HibernateDaoSupport implements GoodsViewBo {

	private GoodsViewDao goodsViewDao;

	public GoodsViewDao getGoodsViewDao() {
		return goodsViewDao;
	}

	public void setGoodsViewDao(GoodsViewDao goodsViewDao) {
		this.goodsViewDao = goodsViewDao;
	}



	@Override
	public List<GoodsView> getAllGoodsView() throws Exception {
		// TODO Auto-generated method stub
		//return getGoodsViewDao().getAll();
		String hql = " from GoodsView gv";
		hql = hql + " where gv.state ="+1;
		hql = hql + " order by gv.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<GoodsView> list = query.list();
		return list;
	}

	@Override
	public GoodsView findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return getGoodsViewDao().get(id);
	}
	
	
 
	
}
