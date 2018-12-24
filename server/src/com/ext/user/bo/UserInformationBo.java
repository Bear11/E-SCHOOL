package com.ext.user.bo;

import com.ext.user.po.UserInformation;

public interface UserInformationBo {

	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存用户信息（包括更新）
	 */
	
	public abstract void saveUserInformation(UserInformation userInformation) throws Exception;

	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteUserInformation(int id) throws Exception;
	
	
	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存用户信息（包括更新）
	 */
	
	public abstract UserInformation findUserInformation(String  userAct,String userPwd) throws Exception;
	public abstract UserInformation findPreson_Center(String username) throws Exception;
	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询，建立视图
	 */
	// public abstract PubMedView getPubmedView(String id)throws Exception;
	
	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-9-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:通过id获得用户详情
	 */
	public abstract UserInformation findUserInformationById(int id) throws Exception;
	
	public String updateInformation(int id, String name) throws Exception;
	
	public String updateInformationPhone(int id, String phone) throws Exception;
	
	public String updateInformationWhere(int id, String phone) throws Exception;
	
	public String updateInformationEmail(int id, String emailAdd) throws Exception;
}
