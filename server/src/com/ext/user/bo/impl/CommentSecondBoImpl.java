package com.ext.user.bo.impl;

import com.ext.user.bo.CommentSecondBo;
import com.ext.user.dao.CommentFirstDao;
import com.ext.user.dao.CommentSecondDao;
import com.ext.user.po.CommentSecond;

public class CommentSecondBoImpl implements CommentSecondBo {

	private CommentFirstDao commentFirstDao;
	private CommentSecondDao commentSecondDao;

	public CommentFirstDao getCommentFirstDao() {
		return commentFirstDao;
	}

	public void setCommentFirstDao(CommentFirstDao commentFirstDao) {
		this.commentFirstDao = commentFirstDao;
	}

	public CommentSecondDao getCommentSecondDao() {
		return commentSecondDao;
	}

	public void setCommentSecondDao(CommentSecondDao commentSecondDao) {
		this.commentSecondDao = commentSecondDao;
	}

	@Override
	public void saveCommentSecond(CommentSecond commentSecond) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCommentSecond(int id) throws Exception {
		// TODO Auto-generated method stub

	}

}
