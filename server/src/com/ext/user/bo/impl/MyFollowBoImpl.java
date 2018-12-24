package com.ext.user.bo.impl;

import com.ext.user.bo.MyFollowBo;
import com.ext.user.dao.MyFollowDao;
import com.ext.user.po.MyFollow;

public class MyFollowBoImpl implements MyFollowBo{

	private  MyFollowDao  MyFollowDao; 
	
	public MyFollowDao getMyFollowDao() {
		return MyFollowDao;
	}

	public void setMyFollowDao(MyFollowDao myFollowDao) {
		MyFollowDao = myFollowDao;
	}


	@Override
	public void saveMyFollowBo(MyFollow myFollow) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMyFollowBo(int id) throws Exception {
		// TODO Auto-generated method stub
		getMyFollowDao().delete(id);
	}

}
