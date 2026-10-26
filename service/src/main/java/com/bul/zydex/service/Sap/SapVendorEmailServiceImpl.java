/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.dao.Sap.SapVendorEmailDao;
import com.bul.zydex.model.SapVendorEmail;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class SapVendorEmailServiceImpl<T> extends GenericsServiceImpl<T> implements SapVendorEmailService<T> {
    
    private SapVendorEmailDao<T> sapVendorEmailDao;

    public SapVendorEmailDao<T> getSapVendorEmailDao() {
        return sapVendorEmailDao;
    }

    public void setSapVendorEmailDao(SapVendorEmailDao<T> sapVendorEmailDao) {
        this.sapVendorEmailDao = sapVendorEmailDao;
        setGenericsDAO(sapVendorEmailDao);
    }

    @Override
    public List readByAddrNum(String ADRNR) {
        return sapVendorEmailDao.readByAddrNum(ADRNR);
    }

    @Override
    public void truncate() {
        sapVendorEmailDao.truncate();
    }
}
