/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.dao.Sap.SapTenderMasterDao;
import com.bul.zydex.model.SapTenderMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class SapTenderMasterServiceImpl<T> extends GenericsServiceImpl<T> implements SapTenderMasterService<T> {
    
    private SapTenderMasterDao<T> sapTenderMasterDao;

    public SapTenderMasterDao<T> getSapTenderMasterDao() {
        return sapTenderMasterDao;
    }

    public void setSapTenderMasterDao(SapTenderMasterDao<T> sapTenderMasterDao) {
        this.sapTenderMasterDao = sapTenderMasterDao;
        setGenericsDAO(sapTenderMasterDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return sapTenderMasterDao.readByRefNo(refNo);
    }

    @Override
    public void deleteRefNo(String refNo) {
        sapTenderMasterDao.deleteRefNo(refNo);
    }

    @Override
    public List readByTenderNo(String refNo) {
        return sapTenderMasterDao.readByTenderNo(refNo);
    }

    @Override
    public SapTenderMaster readByRefNo1(String refNo, String LIFNR) {
        return sapTenderMasterDao.readByRefNo1(refNo,LIFNR);
    }
}
