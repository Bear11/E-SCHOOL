package com.ext.share.bo.impl;

import com.ext.share.bo.ShareClassifyBo;
import com.ext.share.dao.ShareClassifyDao;
import com.ext.share.dao.ShareDao;
import com.ext.share.po.ShareClassify;

public class ShareClassifyBoImpl implements ShareClassifyBo {

	private ShareDao shareDao;
	private ShareClassifyDao shareClassifyDao;

	public ShareDao getShareDao() {
		return shareDao;
	}

	public void setShareDao(ShareDao shareDao) {
		this.shareDao = shareDao;
	}

	public ShareClassifyDao getShareClassifyDao() {
		return shareClassifyDao;
	}

	public void setShareClassifyDao(ShareClassifyDao shareClassifyDao) {
		this.shareClassifyDao = shareClassifyDao;
	}

	@Override
	public void saveShareClassify(ShareClassify shareClassify) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteShareClassify(int id) throws Exception {
		// TODO Auto-generated method stub

	}
}
