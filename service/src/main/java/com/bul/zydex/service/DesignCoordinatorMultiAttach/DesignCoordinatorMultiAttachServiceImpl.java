/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DesignCoordinatorMultiAttach;

import com.bul.zydex.dao.DesignCoordinatorMultiAttach.DesignCoordinatorMultiAttachDao;
import com.bul.zydex.model.DesignCoordinatorMultiAttach;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DesignCoordinatorMultiAttachServiceImpl<T> extends GenericsServiceImpl<T> implements DesignCoordinatorMultiAttachService<T> {

    private DesignCoordinatorMultiAttachDao<T> designCoordinatorMultiAttachDao;

    public DesignCoordinatorMultiAttachDao<T> getDesignCoordinatorMultiAttachDao() {
	return designCoordinatorMultiAttachDao;
    }

    public void setDesignCoordinatorMultiAttachDao(DesignCoordinatorMultiAttachDao<T> designCoordinatorMultiAttachDao) {
	this.designCoordinatorMultiAttachDao = designCoordinatorMultiAttachDao;
	setGenericsDAO(designCoordinatorMultiAttachDao);

    }

    @Override
    public List readBydelmultiid(int oapformid) {
	return designCoordinatorMultiAttachDao.readBydelmultiid(oapformid);

    }

    @Override
    public List readBydelmultiid1(int aocformid) {
	return designCoordinatorMultiAttachDao.readBydelmultiid1(aocformid);
    }

    @Override
    public List readBydelimultiid(String id1) {
	return designCoordinatorMultiAttachDao.readBydelimultiid(id1);
    }

    @Override
    public DesignCoordinatorMultiAttach readBydelmultiids(int oapid) {
	return designCoordinatorMultiAttachDao.readBydelmultiids(oapid);

    }

    @Override
    public DesignCoordinatorMultiAttach readBydelmultiidsaoc(int aocid) {
	return designCoordinatorMultiAttachDao.readBydelmultiidsaoc(aocid);

    }
}
