package com.ext.user.bo.impl;

import com.ext.user.bo.MyShareBo;
import com.ext.user.dao.MyShareDao;
import com.ext.user.po.MyShare;

public class MyShareBoImpl  implements MyShareBo{

	private  MyShareDao  MyShareDao; 

	public MyShareDao getCourseDao() {
		return  MyShareDao;
	}

	public void setCourseDao(MyShareDao MyShareDao) {
		this.MyShareDao = MyShareDao;
	}
	@Override
	public void saveMyShareBo(MyShare myShare) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMyShareBo(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
