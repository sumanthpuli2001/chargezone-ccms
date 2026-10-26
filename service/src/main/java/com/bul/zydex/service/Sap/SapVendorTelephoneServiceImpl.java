/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.dao.Sap.SapVendorTelephoneDao;
import com.bul.zydex.model.SapVendorTelephone;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class SapVendorTelephoneServiceImpl<T> extends GenericsServiceImpl<T> implements SapVendorTelephoneService<T> {
    
    private SapVendorTelephoneDao<T> sapVendorTelephoneDao;

    public SapVendorTelephoneDao<T> getSapVendorTelephoneDao() {
        return sapVendorTelephoneDao;
    }

    public void setSapVendorTelephoneDao(SapVendorTelephoneDao<T> sapVendorTelephoneDao) {
        this.sapVendorTelephoneDao = sapVendorTelephoneDao;
        setGenericsDAO(sapVendorTelephoneDao);
    }

    @Override
    public List readByAddrNum(String ADRNR) {
        return sapVendorTelephoneDao.readByAddrNum(ADRNR);
    }

    @Override
    public void truncate() {
        sapVendorTelephoneDao.truncate();
    }
}
