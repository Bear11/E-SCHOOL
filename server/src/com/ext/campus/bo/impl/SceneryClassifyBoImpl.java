package com.ext.campus.bo.impl;

import com.ext.campus.bo.SceneryClassifyBo;
import com.ext.campus.dao.SceneryClassifyDao;
import com.ext.campus.po.SceneryClassify;

public class SceneryClassifyBoImpl implements SceneryClassifyBo {

	private SceneryClassifyDao sceneryclassifydao;

	public SceneryClassifyDao getSceneryClassifyDao() {
		return sceneryclassifydao;
	}

	public void setSceneryClassifyDao(SceneryClassifyDao campusDao) {
		this.sceneryclassifydao = campusDao;
	}

	@Override
	public void saveSceneryClassify(SceneryClassify sceneryclassify)
			throws Exception {
		// TODO Auto-generated method stub
		int aid = sceneryclassify.getId();
		if (aid < 0) {
			sceneryclassifydao.save(sceneryclassify);
		} else {
			sceneryclassifydao.update(sceneryclassify);
		}
	}

	@Override
	public void deleteSceneryClassify(int id) throws Exception {
		// TODO Auto-generated method stub
		getSceneryClassifyDao().delete(id);
	}

}
