/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorRequestedInvitationCategoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestedInvitationCategoryServiceImpl<T> extends GenericsServiceImpl<T> implements VendorRequestedInvitationCategoryService<T> {

    private VendorRequestedInvitationCategoryDao<T> vendorRequestedInvitationCategoryDao;

    public VendorRequestedInvitationCategoryDao<T> getVendorRequestedInvitationCategoryDao() {
        return vendorRequestedInvitationCategoryDao;
    }

    public void setVendorRequestedInvitationCategoryDao(VendorRequestedInvitationCategoryDao<T> vendorRequestedInvitationCategoryDao) {
        this.vendorRequestedInvitationCategoryDao = vendorRequestedInvitationCategoryDao;
        setGenericsDAO(vendorRequestedInvitationCategoryDao);
    }

    @Override
    public List readByVendorRequestId(String id) {
        return vendorRequestedInvitationCategoryDao.readByVendorRequestId(id);
    }

}
