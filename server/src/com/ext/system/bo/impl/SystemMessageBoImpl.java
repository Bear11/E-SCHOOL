package com.ext.system.bo.impl;

import com.ext.system.bo.SystemMessageBo;
import com.ext.system.dao.SystemMessageDao;
import com.ext.system.po.SystemMessage;

public class SystemMessageBoImpl implements SystemMessageBo {

	private SystemMessageDao systemMessageDao;

	public SystemMessageDao getSystemMessageDao() {
		return systemMessageDao;
	}

	public void setSystemMessageDao(SystemMessageDao systemMessageDao) {
		this.systemMessageDao = systemMessageDao;
	}

	@Override
	public void saveSystemMessage(SystemMessage systemMessage) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSystemMessage(int id) throws Exception {
		// TODO Auto-generated method stub

	}

}
