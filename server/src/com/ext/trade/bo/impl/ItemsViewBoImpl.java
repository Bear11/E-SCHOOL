package com.ext.trade.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.trade.bo.ItemsViewBo;
import com.ext.trade.dao.ItemsViewDao;
import com.ext.trade.po.ItemsView;

public class ItemsViewBoImpl extends HibernateDaoSupport implements ItemsViewBo {

	private ItemsViewDao itemsViewDao;

	public ItemsViewDao getItemsViewDao() {
		return itemsViewDao;
	}

	public void setItemsViewDao(ItemsViewDao itemsViewDao) {
		this.itemsViewDao = itemsViewDao;
	}

	
	@Override
	public List<ItemsView> getAllItemsView(int flag) throws Exception {
		// TODO Auto-generated method stub
		String hql = " from ItemsView sv";	
		if(flag == 0){
			hql = hql + " where sv.type ="+ 0;
		}
		if(flag == 1){
			hql = hql + " where sv.type ="+ 1;
		}
		hql = hql + " order by sv.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<ItemsView> list = query.list();
		return list;	
	}
}
