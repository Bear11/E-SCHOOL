package com.ext.user.bo;


import java.util.List;

import com.ext.user.po.UserInformation;
import com.ext.user.po.User_and_school_information_;

public interface User_and_school_information_Bo {
	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存用户信息（包括更新）
	 */
	
	public abstract void saveUser_and_school_information_(User_and_school_information_ userInformation) throws Exception;

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
	public List<User_and_school_information_> getMyInformation(String username)
			throws Exception;
}
