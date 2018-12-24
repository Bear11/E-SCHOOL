package com.ext.share.bo.impl;

import com.ext.share.bo.ShareSecondCommentBo;
import com.ext.share.dao.ShareSecondCommentDao;
import com.ext.share.po.ShareSecondComment;

public class ShareSecondCommentBoImpl implements ShareSecondCommentBo {

	ShareSecondCommentDao shareSecondCommentDao;
	
	public ShareSecondCommentDao getShareSecondCommentDao() {
		return shareSecondCommentDao;
	}

	public void setShareSecondCommentDao(ShareSecondCommentDao shareSecondCommentDao) {
		this.shareSecondCommentDao = shareSecondCommentDao;
	}

	@Override
	public void saveShareSecondComment(ShareSecondComment shareSecondComment)
			throws Exception {
		// TODO Auto-generated method stub
        int id = shareSecondComment.getId();
        if(id<0)
        {
        	getShareSecondCommentDao().save(shareSecondComment);
        }
        else{
        	getShareSecondCommentDao().update(shareSecondComment);
        }
	}

	@Override
	public void deleteShareSecondComment(int id) throws Exception {
		// TODO Auto-generated method stub
        getShareSecondCommentDao().delete(id);
	}

}
