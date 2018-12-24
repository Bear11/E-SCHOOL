package com.ext.user.bo;

import java.util.List;

import com.ext.user.po.UserFollow;
import com.ext.user.po.User_and_school_information_;

public interface UserFollowViewBo {
	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存用户信息（包括更新）
	 */
	
	public abstract void saveUserFollowView(UserFollow userInformation) throws Exception;

	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteUserFollowView(int id) throws Exception;
	
	
	/**
	 * 
	 * @param UserInformation
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存用户信息（包括更新）
	 */
	public List<UserFollow> getMyFollow(String username)
			throws Exception ;
	
	public List<UserFollow> getMyFollowSecond(String username) throws Exception;
}
