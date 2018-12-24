package com.ext.user.bo.impl;

import com.ext.user.bo.MyCollectBo;
import com.ext.user.dao.MyCollectDao;
import com.ext.user.po.MyCollect;

public class MyCollectBoImpl implements MyCollectBo{

	private  MyCollectDao  MyCollect; 


	public MyCollectDao getMyCollect() {
		return MyCollect;
	}

	public void setMyCollect(MyCollectDao myCollect) {
		MyCollect = myCollect;
	}

	@Override
	public void saveMyCollectBo(MyCollect myCollect) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMyCollectBo(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
