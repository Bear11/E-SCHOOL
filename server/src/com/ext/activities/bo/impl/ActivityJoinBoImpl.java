package com.ext.activities.bo.impl;

import com.ext.activities.bo.ActivityJoinBo;
import com.ext.activities.dao.ActivitiesDao;
import com.ext.activities.dao.ActivityJoinDao;
import com.ext.activities.po.ActivityJoin;

public class ActivityJoinBoImpl implements ActivityJoinBo {

	private ActivitiesDao activitiesDao;
	private ActivityJoinDao activityJoinDao;

	public ActivitiesDao getActivitiesDao() {
		return activitiesDao;
	}

	public void setActivitiesDao(ActivitiesDao activitiesDao) {
		this.activitiesDao = activitiesDao;
	}

	public ActivityJoinDao getActivityJoinDao() {
		return activityJoinDao;
	}

	public void setActivityJoinDao(ActivityJoinDao activityJoinDao) {
		this.activityJoinDao = activityJoinDao;
	}

	@Override
	public void saveActivityJoin(ActivityJoin activityjoin) throws Exception {
		// TODO Auto-generated method stub
		if(activityjoin.getId()<0)
		{ 
			getActivityJoinDao().save(activityjoin);
		}else{
			getActivityJoinDao().update(activityjoin);
		}        
	}

	@Override
	public void deleteActivityJoin(int id) throws Exception {
		// TODO Auto-generated method stub

	}

}
