package com.ext.user.bo.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ext.user.bo.UserGoodsViewBo;
import com.ext.user.dao.UserGoodsViewDao;
import com.ext.user.po.UserFollow;
import com.ext.user.po.UserGoodsView;
import com.ext.user.po.User_and_school_information_;

public class UserGoodsViewBoImpl extends HibernateDaoSupport implements UserGoodsViewBo{
	private UserGoodsViewDao Usergoodsviewdao;
	private UserGoodsView Usergoodsview;
	
	public UserGoodsViewDao getUsergoodsviewdao() {
		return Usergoodsviewdao;
	}

	public void setUsergoodsviewdao(UserGoodsViewDao usergoodsviewdao) {
		Usergoodsviewdao = usergoodsviewdao;
	}

	public UserGoodsView getUsergoodsview() {
		return Usergoodsview;
	}

	public void setUsergoodsview(UserGoodsView usergoodsview) {
		Usergoodsview = usergoodsview;
	}

	@Override
	public void saveUserGoodsView(UserGoodsView userInformation)
			throws Exception {
		// TODO Auto-generated method stub
				int aid = userInformation.getID();
				if(aid<0){
					getUsergoodsviewdao().save(userInformation);
				}else{
					getUsergoodsviewdao().update(userInformation);
				}	
		
	}

	@Override
	public void deleteUserGoodsView(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserGoodsView> getUserGoodsView(String username) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from UserGoodsView us where us.userAct="+username;
		//hql = hql + " order by s.id desc";
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		List<UserGoodsView> list = query.list();
		return list;
	}

}
