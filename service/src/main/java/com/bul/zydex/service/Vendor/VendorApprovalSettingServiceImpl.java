/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorApprovalDao;
import com.bul.zydex.dao.Vendor.VendorApprovalSettingDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorApprovalSettingServiceImpl<T> extends GenericsServiceImpl<T> implements VendorApprovalSettingService<T> {
   private VendorApprovalSettingDao<T> vendorApprovalSettingDao; 

    public VendorApprovalSettingDao<T> getVendorApprovalSettingDao() {
        return vendorApprovalSettingDao;
    }

    public void setVendorApprovalSettingDao(VendorApprovalSettingDao<T> vendorApprovalSettingDao) {
        this.vendorApprovalSettingDao = vendorApprovalSettingDao;
        setGenericsDAO(vendorApprovalSettingDao);
    }

    @Override
    public List getVendorPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return vendorApprovalSettingDao.getVendorPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalVendorCount() {
        return vendorApprovalSettingDao.getTotalVendorCount();
    }

    @Override
    public int getFilteredVendorCount(String search) {
        return vendorApprovalSettingDao.getFilteredVendorCount(search);
    }
   
}
