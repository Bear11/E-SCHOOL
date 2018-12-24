package com.ext.trade.bo.impl;

import com.ext.trade.bo.ItemsBo;
import com.ext.trade.dao.ItemsDao;
import com.ext.trade.po.Items;

public class ItemsBoImpl implements ItemsBo {

	private ItemsDao itemsDao;

	public ItemsDao getItemsDao() {
		return itemsDao;
	}

	public void setItemsDao(ItemsDao itemsDao) {
		this.itemsDao = itemsDao;
	}

	@Override
	public void saveItems(Items items) throws Exception {
		// TODO Auto-generated method stub
        if(items.getId()<0)
        {
        	getItemsDao().save(items);
       
        }else{
        	
        	getItemsDao().update(items);
        }
	}

	@Override
	public void deleteItems(int id) throws Exception {
		// TODO Auto-generated method stub

	}

}
