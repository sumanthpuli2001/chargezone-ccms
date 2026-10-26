/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorInvitationCategoryDao;
import com.bul.zydex.model.VendorInvitationCategory;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorInvitationCategoryServiceImpl<T> extends GenericsServiceImpl<T> implements VendorInvitationCategoryService<T> {

    private VendorInvitationCategoryDao<T> vendorInvitationCategoryDao;

    public VendorInvitationCategoryDao<T> getVendorInvitationCategoryDao() {
        return vendorInvitationCategoryDao;
    }

    public void setVendorInvitationCategoryDao(VendorInvitationCategoryDao<T> vendorInvitationCategoryDao) {
        this.vendorInvitationCategoryDao = vendorInvitationCategoryDao;
        setGenericsDAO(vendorInvitationCategoryDao);
    }

//    @Override
//    public VendorInvitationCategory readIds(int i) {
//         return vendorInvitationCategoryDao.readIds(i);
//}
    @Override
    public List readIds(int i) {
        return vendorInvitationCategoryDao.readIds(i);
    }

    @Override
    public List readByAll(int vendorInvtId) {
        return vendorInvitationCategoryDao.readByAll(vendorInvtId);
    }

    @Override
    public List readByVendorInvtlistId(int vendorInvtId) {
        return vendorInvitationCategoryDao.readByVendorInvtlistId(vendorInvtId);

    }

    @Override
    public VendorInvitationCategory readByVendorInvtId(int vendorInvtId) {
        return vendorInvitationCategoryDao.readByVendorInvtId(vendorInvtId);

    }
}
