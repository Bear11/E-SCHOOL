package com.ext.user.bo.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.user.bo.MyGoodsBo;
import com.ext.user.dao.MyGoodsDao;
import com.ext.user.po.MyGoods;

public class MyGoodsBoImpl extends HibernateDaoSupport implements MyGoodsBo{

	private  MyGoodsDao  MyGoodsDao; 
   
	public MyGoodsDao getMyGoodsDao() {
		return MyGoodsDao;
	}

	public void setMyGoodsDao(MyGoodsDao MyGoodsDao) {
		this.MyGoodsDao = MyGoodsDao;
	}

	@Override
	public void saveMyGoodsBo(MyGoods MyGoods) throws Exception {
		// TODO Auto-generated method stub
		int aid = MyGoods.getId();
		if(aid<0){
			MyGoodsDao.save(MyGoods);
		}else{
			MyGoodsDao.update(MyGoods);
		}	
		
	}

	@Override
	public void deleteMyGoodsBo(int id) throws Exception {
		// TODO Auto-generated method stub
		MyGoodsDao.delete(id);
	}

	@Override
	public String updateGoods(int x,String id) throws Exception {
		// TODO Auto-generated method stub
		String msg = " ";
		String hql;
		if(x!=0)
		{
			hql = "update MyGoods s set s.number='"+x
					+ "'  where s.id =" + id+"and s.state="+"1";
			
		}else
		{
			hql = "update MyGoods s set s.number='"+x
					+ "'  where s.id =" + id+"and s.state="+"0";
		}

		MyGoodsDao.createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
	}
	
}
