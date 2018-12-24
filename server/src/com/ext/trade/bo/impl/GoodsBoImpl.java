package com.ext.trade.bo.impl;

import java.util.List;

import com.ext.trade.bo.GoodsBo;
import com.ext.trade.dao.GoodsDao;
import com.ext.trade.po.Goods;

public class GoodsBoImpl implements GoodsBo {

	private GoodsDao goodsDao;

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public void saveGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
        if(goods.getId()<0)
        {
        	getGoodsDao().save(goods);
        }else{
        	getGoodsDao().update(goods);
        }
	}

	@Override
	public void deleteGoods(int id) throws Exception {
		// TODO Auto-generated method stub
        getGoodsDao().delete(id);
	}

	@Override
	public List<Goods> getAllGoods() throws Exception {
		// TODO Auto-generated method stub	
		return getGoodsDao().getAll();
	}
}
