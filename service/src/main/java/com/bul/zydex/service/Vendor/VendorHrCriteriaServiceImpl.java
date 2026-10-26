/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorHrCriteriaDao;
import com.bul.zydex.model.VendorHrCriteria;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorHrCriteriaServiceImpl<T> extends GenericsServiceImpl<T> implements VendorHrCriteriaService<T> {

    private VendorHrCriteriaDao<T> vendorHrCriteriaDao;

    public VendorHrCriteriaDao<T> getVendorHrCriteriaDao() {
        return vendorHrCriteriaDao;
    }

    public void setVendorHrCriteriaDao(VendorHrCriteriaDao<T> vendorHrCriteriaDao) {
        this.vendorHrCriteriaDao = vendorHrCriteriaDao;
        setGenericsDAO(vendorHrCriteriaDao);
    }

    @Override
    public List readByAll() {
        return vendorHrCriteriaDao.readByAll();
    }

    @Override
    public List readByGroupName(String vendorInvtId) {
        return vendorHrCriteriaDao.readByGroupName(vendorInvtId);
    }
}
