package com.ext.campus.bo.impl;

import java.util.List;

import com.ext.campus.bo.SchoolBo;
import com.ext.campus.dao.SchoolDao;
import com.ext.campus.po.School;



public class SchoolBoImpl implements SchoolBo{

	private  SchoolDao schoolDao;
	

	public SchoolDao getSchoolDao() {
		return schoolDao;
	}


	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}


	@Override
	public List<School> getAllSchool() throws Exception {
		// TODO Auto-generated method stub
		return getSchoolDao().getAll();
	}
	

	
}
