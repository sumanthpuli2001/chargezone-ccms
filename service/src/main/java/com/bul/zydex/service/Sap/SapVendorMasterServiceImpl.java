/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.dao.Sap.SapVendorMasterDao;
import com.bul.zydex.model.SapVendorMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class SapVendorMasterServiceImpl<T> extends GenericsServiceImpl<T> implements SapVendorMasterService<T> {
    
    private SapVendorMasterDao<T> sapVendorMasterDao;

    public SapVendorMasterDao<T> getSapVendorMasterDao() {
        return sapVendorMasterDao;
    }

    public void setSapVendorMasterDao(SapVendorMasterDao<T> sapVendorMasterDao) {
        this.sapVendorMasterDao = sapVendorMasterDao;
        setGenericsDAO(sapVendorMasterDao);
    }

    @Override
    public void truncate() {
        sapVendorMasterDao.truncate();
    }

    @Override
    public List readAll() {
        return sapVendorMasterDao.readAll();
    }
}
