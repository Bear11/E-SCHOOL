package com.ext.user.bo.impl;

import com.ext.user.bo.MyCourseBo;
import com.ext.user.dao.MyCourseDao;
import com.ext.user.po.MyCourse;

public class MyCourseBoImpl implements MyCourseBo{

	private  MyCourseDao  MyCourse; 

	
	public MyCourseDao getMyCourse() {
		return MyCourse;
	}

	public void setMyCourse(MyCourseDao myCourse) {
		MyCourse = myCourse;
	}

	@Override
	public void saveMyCourseBo(MyCourse myCourse) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMyCourseBo(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
