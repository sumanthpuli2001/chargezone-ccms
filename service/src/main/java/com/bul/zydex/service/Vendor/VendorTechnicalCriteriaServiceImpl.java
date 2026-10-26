/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTechnicalCriteriaDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorTechnicalCriteriaServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTechnicalCriteriaService<T> {

    private VendorTechnicalCriteriaDao<T> vendorTechnicalCriteriaDao;

    public VendorTechnicalCriteriaDao<T> getVendorTechnicalCriteriaDao() {
        return vendorTechnicalCriteriaDao;
    }

    public void setVendorTechnicalCriteriaDao(VendorTechnicalCriteriaDao<T> vendorTechnicalCriteriaDao) {
        this.vendorTechnicalCriteriaDao = vendorTechnicalCriteriaDao;
        setGenericsDAO(vendorTechnicalCriteriaDao);
    }

    @Override
    public List readAll() {
        return vendorTechnicalCriteriaDao.readAll();
    }

    @Override
    public List readAllVendorTechnicalCriteria(int groupSubCategoryId, int groupMasterId, int groupCategoryId) {
        return vendorTechnicalCriteriaDao.readAllVendorTechnicalCriteria(groupSubCategoryId, groupMasterId, groupCategoryId);
    }
}
