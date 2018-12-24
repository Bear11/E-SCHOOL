package com.ext.user.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.campus.po.CampusInformation;
import com.ext.user.bo.User_and_school_information_Bo;
import com.ext.user.dao.User_and_school_information_Dao;
import com.ext.user.po.User_and_school_information_;

public class User_and_school_information_BoImpl extends HibernateDaoSupport implements User_and_school_information_Bo{

	private User_and_school_information_Dao User_and_school_information_Dao ;

	public User_and_school_information_Dao getUser_and_school_information_Dao() {
		return User_and_school_information_Dao;
	}
	


	public void setUser_and_school_information_Dao(User_and_school_information_Dao userInformationDao) {
		this.User_and_school_information_Dao = userInformationDao;
	}



	@Override
	public void deleteUserInformation(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveUser_and_school_information_(User_and_school_information_ userInformation)
			throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int aid = userInformation.getID();
				if(aid<0){
					getUser_and_school_information_Dao().save(userInformation);
				}else{
					getUser_and_school_information_Dao().update(userInformation);
				}	
	}
	@Override
	public List<User_and_school_information_> getMyInformation(String username)
	throws Exception {
		String hql = "from User_and_school_information_ us where us.ID="+username;
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<User_and_school_information_> list = query.list();
		return list;
	}
}
