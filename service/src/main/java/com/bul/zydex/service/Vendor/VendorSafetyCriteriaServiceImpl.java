/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorSafetyCriteriaDao;
import com.bul.zydex.model.VendorSafetyCriteria;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorSafetyCriteriaServiceImpl<T> extends GenericsServiceImpl<T> implements VendorSafetyCriteriaService<T> {

    private VendorSafetyCriteriaDao<T> vendorSafetyCriteriaDao;

    public VendorSafetyCriteriaDao<T> getVendorSafetyCriteriaDao() {
        return vendorSafetyCriteriaDao;
    }

    public void setVendorSafetyCriteriaDao(VendorSafetyCriteriaDao<T> vendorSafetyCriteriaDao) {
        this.vendorSafetyCriteriaDao = vendorSafetyCriteriaDao;
        setGenericsDAO(vendorSafetyCriteriaDao);
    }

    @Override
    public List readByAll() {
        return vendorSafetyCriteriaDao.readByAll();
    }

    @Override
    public List readByGroupName(int vendorInvtId) {
        return vendorSafetyCriteriaDao.readByGroupName(vendorInvtId);
    }

}
