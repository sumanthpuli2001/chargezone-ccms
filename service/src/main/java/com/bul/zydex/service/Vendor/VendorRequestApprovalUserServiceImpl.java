/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorRequestApprovalDao;
import com.bul.zydex.dao.Vendor.VendorRequestApprovalUserDao;
import com.bul.zydex.model.VendorRequestApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements VendorRequestApprovalUserService<T> {

    private VendorRequestApprovalUserDao<T> vendorRequestApprovalUserDao;

    public VendorRequestApprovalUserDao<T> getVendorRequestApprovalUserDao() {
        return vendorRequestApprovalUserDao;
    }

    public void setVendorRequestApprovalUserDao(VendorRequestApprovalUserDao<T> vendorRequestApprovalUserDao) {
        this.vendorRequestApprovalUserDao = vendorRequestApprovalUserDao;
        setGenericsDAO(vendorRequestApprovalUserDao);
    }

    @Override
    public VendorRequestApprovalUser appval(String username) {
        return vendorRequestApprovalUserDao.appval(username);
    }

    @Override
    public List readByDleteCode(int formid) {
        return vendorRequestApprovalUserDao.appval(formid);
    }

}
