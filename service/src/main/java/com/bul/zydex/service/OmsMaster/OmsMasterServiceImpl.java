/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OmsMaster;

import com.bul.zydex.dao.OmsMaster.OmsMasterDao;
import com.bul.zydex.model.OmsMaster;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author bulwarks-2
 */
public class OmsMasterServiceImpl<T> extends GenericsServiceImpl<T> implements OmsMasterService<T> {

    private OmsMasterDao<T> omsMasterDao;

    public OmsMasterDao<T> getOmsMasterDao() {
        return omsMasterDao;
    }

    public void setOmsMasterDao(OmsMasterDao<T> omsMasterDao) {
        this.omsMasterDao = omsMasterDao;
        setGenericsDAO(omsMasterDao);
    }

    @Override
    public OmsMaster readByTickitNoAndPrId(String tickitId, String omsPrId) {
        return omsMasterDao.readByTickitNoAndPrId(tickitId, omsPrId);
    }

    @Override
    public OmsMaster readByTickitNo(String tickitId) {
        return omsMasterDao.readByTickitNo(tickitId);
    }

    @Override
    public OmsMaster readByPrNo(String prNo, int omsPrFlag) {
        return omsMasterDao.readByPrNo(prNo, omsPrFlag);
    }

}
