/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorQualityCertificateDao;
import com.bul.zydex.dao.Vendor.VendorRequestDetailsDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements VendorRequestDetailsService<T> {

    private VendorRequestDetailsDao<T> vendorRequestDetailsDao;

    public VendorRequestDetailsDao<T> getVendorRequestDetailsDao() {
        return vendorRequestDetailsDao;
    }

    public void setVendorRequestDetailsDao(VendorRequestDetailsDao<T> vendorRequestDetailsDao) {
        this.vendorRequestDetailsDao = vendorRequestDetailsDao;
        setGenericsDAO(vendorRequestDetailsDao);
    }

    @Override
    public List readByUserName(String username) {
        return vendorRequestDetailsDao.readByUserName(username);
    }

    @Override
    public List readByAprrove1() {
        return vendorRequestDetailsDao.readByAprrove1();
    }

}
