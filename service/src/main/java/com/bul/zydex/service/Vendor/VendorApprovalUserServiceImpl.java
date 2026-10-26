/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorApprovalSettingDao;
import com.bul.zydex.dao.Vendor.VendorApprovalUserDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements VendorApprovalUserService<T> {

    private VendorApprovalUserDao<T> vendorApprovalUserDao;

    public VendorApprovalUserDao<T> getVendorApprovalUserDao() {
        return vendorApprovalUserDao;
    }

    public void setVendorApprovalUserDao(VendorApprovalUserDao<T> vendorApprovalUserDao) {
        this.vendorApprovalUserDao = vendorApprovalUserDao;
        setGenericsDAO(vendorApprovalUserDao);
    }

    @Override
    public List<?> readByIdToList(String id) {
        return vendorApprovalUserDao.readByIdToList(id);
    }

    @Override
    public List readByIdToList1(String approval) {
        return vendorApprovalUserDao.readByIdToList1(approval);
    }

}
