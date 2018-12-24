package com.ext.user.bo.impl;

import com.ext.user.bo.UserInformationBo;
import com.ext.user.dao.UserInformationDao;
import com.ext.user.po.UserInformation;

public class UserInformationBoImpl implements UserInformationBo {

	private UserInformationDao userInformationDao ;

	public UserInformationDao getUserInformationDao() {
		return userInformationDao;
	}

	public void setUserInformationDao(UserInformationDao userInformationDao) {
		this.userInformationDao = userInformationDao;
	}

	@Override
	public void saveUserInformation(UserInformation userInformation)
			throws Exception {
		// TODO Auto-generated method stub
		int aid = userInformation.getId();
		if(aid<0){
			getUserInformationDao().save(userInformation);
		}else{
			getUserInformationDao().update(userInformation);
		}	
	}

	@Override
	public void deleteUserInformation(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserInformation findUserInformation(String userAct, String userPwd)
			throws Exception {
		// TODO Auto-generated method stub
		String hql = "from UserInformation us where us.userAct =? and us.userPwd = ?";
//		UserInformation s = getUserInformationDao().findUnique(hql, userAct,userPwd);
		return getUserInformationDao().findUnique(hql, userAct,userPwd);			
	}
	@Override
	public UserInformation findPreson_Center(String username)
	throws Exception {
		int i=Integer.parseInt(username);
		String hql = "from UserInformation us where us.id=?";
		return  getUserInformationDao().findUnique(hql, i);
	}

	@Override
	public UserInformation findUserInformationById(int id) throws Exception {
		// TODO Auto-generated method stub
		return getUserInformationDao().get(id);
	}
	
	@Override
	public String updateInformation(int id, String name) throws Exception {
		// TODO Auto-generated method stub
		String msg = " ";
		String hql = "update UserInformation s set s.userName='"+name
				+ "'  where s.id =" + id;
		// getShareDao().save(share);
		getUserInformationDao().createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
	}
	
	@Override
	public String updateInformationPhone(int id, String phone) throws Exception
	{
		// TODO Auto-generated method stub
		String msg = " ";
		String hql = "update UserInformation s set s.phoneNo='"+phone
			+ "'  where s.id =" + id;
		// getShareDao().save(share);
		getUserInformationDao().createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
	}
	public String updateInformationWhere(int id, String phone) throws Exception
	{
		// TODO Auto-generated method stub
		String msg = " ";
		String hql = "update UserInformation s set s.phoneNo='"+phone
			+ "'  where s.id =" + id;
		// getShareDao().save(share);
		getUserInformationDao().createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
	}
	public String updateInformationEmail(int id, String emailAdd) throws Exception
	{
		// TODO Auto-generated method stub
		String msg = " ";
		String hql = "update UserInformation s set s.emailAdd='"+emailAdd
			+ "'  where s.id =" + id;
		// getShareDao().save(share);
		getUserInformationDao().createQuery(hql).executeUpdate();
		msg = "success";
		return msg;
	}
}
