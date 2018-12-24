package com.ext.system.bo.impl;

import com.ext.system.bo.FeedbackBo;
import com.ext.system.dao.FeedbackDao;
import com.ext.system.po.Feedback;

public class FeedbackBoImpl implements FeedbackBo {

	private FeedbackDao feedbackDao;

	public FeedbackDao getFeedbackDao() {
		return feedbackDao;
	}

	public void setFeedbackDao(FeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

	@Override
	public void saveFeedback(Feedback feedback) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFeedback(int id) throws Exception {
		// TODO Auto-generated method stub

	}

}
