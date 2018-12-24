package com.ext.user.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.user.bo.UserFollowViewBo;
import com.ext.user.dao.UserFollowViewDao;
import com.ext.user.po.UserFollow;
import com.ext.user.po.User_and_school_information_;

public class UserFollowViewBoImpl extends HibernateDaoSupport implements UserFollowViewBo{
	
	private UserFollowViewDao userFollowViewDao;
	
	public UserFollowViewDao getUserFollowViewDao() {
		return userFollowViewDao;
	}

	public void setUserFollowViewDao(UserFollowViewDao userFollowViewDao) {
		this.userFollowViewDao = userFollowViewDao;
	}

	@Override
	public void saveUserFollowView(UserFollow userInformation) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int aid = userInformation.getID();
		if(aid<0){
			getUserFollowViewDao().save(userInformation);
		}else{
			getUserFollowViewDao().update(userInformation);
		}	
	}

	@Override
	public void deleteUserFollowView(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserFollow> getMyFollow(String username) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from UserFollow us where us.PERSONID="+username;
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<UserFollow> list = query.list();
		return list;
	}
	
	@Override
	public List<UserFollow> getMyFollowSecond(String username) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from UserFocusView us where us.objPersonId="+username;
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<UserFollow> list = query.list();
		return list;
	}

}
