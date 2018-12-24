package com.ext.user.bo.impl;

import com.ext.user.bo.CommentFirstBo;
import com.ext.user.dao.CommentFirstDao;
import com.ext.user.po.CommentFirst;

public class CommentFirstBoImpl implements CommentFirstBo {

	private CommentFirstDao commentFirstDao; 

	public CommentFirstDao getCommentFirstDao() {
		return commentFirstDao;
	}

	public void setCommentFirstDao(CommentFirstDao commentFirstDao) {
		this.commentFirstDao = commentFirstDao;
	}

	@Override
	public void saveCommentFirst(CommentFirst commentFirst) throws Exception {
		// TODO Auto-generated method stub
		int id = commentFirst.getId();
		if(id<0)
		{
			getCommentFirstDao().save(commentFirst);
		}
		else{
			getCommentFirstDao().update(commentFirst);
		}
	}

	@Override
	public void deleteCommentFirst(int id) throws Exception {
		// TODO Auto-generated method stub
		getCommentFirstDao().delete(id);
	}
	
	

}
