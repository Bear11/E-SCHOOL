package com.ext.share.bo;

import java.util.List;

import com.ext.share.po.Share;

public interface ShareBo {

	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： ZhangChengcheng
	 * @description 描述:保存分享（包括更新）
	 */
	public abstract void saveShare(Share share) throws Exception;

	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者： zcc
	 * @description 描述:根据主键删除
	 */
	public abstract void deleteShare(int id) throws Exception;
	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:查询所有
	 */
	public abstract List<Share> getAllShare()throws Exception;
	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:实现点赞加一
	 */
	public abstract String updateGaL(int id,int new_cnum)throws Exception;
	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:实现评论数加一
	 */
	public abstract String updatePls(int id,int new_cnum)throws Exception;
	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:实现转发量加一
	 */
	public abstract String updateZfl(int id,int new_cnum)throws Exception;
	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:通过id导出其他详情
	 */
	public abstract Share findById(int id)throws Exception;
	/**
	 * 
	 * @param Share
	 * @throws Exception
	 * @date 日期: 2016-5-9 下午 13:45
	 * @author 作者：zcc
	 * @description 描述:保存分享的评论
	 */
	
	

}
