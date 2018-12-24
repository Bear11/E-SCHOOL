package com.ext.user.bo.impl;

import com.ext.user.bo.CourseBo;
import com.ext.user.dao.CourseDao;
import com.ext.user.po.Course;

public class CourseBoImpl implements CourseBo{

	private CourseDao CourseDao; 

	public CourseDao getCourseDao() {
		return CourseDao;
	}

	public void setCourseDao(CourseDao CourseDao) {
		this.CourseDao = CourseDao;
	}
	@Override
	public void saveCourseBo(Course course) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourseBo(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
