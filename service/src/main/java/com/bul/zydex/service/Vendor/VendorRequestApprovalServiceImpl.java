/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorQualityCertificateDao;
import com.bul.zydex.dao.Vendor.VendorRequestApprovalDao;
import com.bul.zydex.model.VendorRequestApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements VendorRequestApprovalService<T> {

    private VendorRequestApprovalDao<T> vendorRequestApprovalDao;

    public VendorRequestApprovalDao<T> getVendorRequestApprovalDao() {
        return vendorRequestApprovalDao;
    }

    public void setVendorRequestApprovalDao(VendorRequestApprovalDao<T> vendorRequestApprovalDao) {
        this.vendorRequestApprovalDao = vendorRequestApprovalDao;
        setGenericsDAO(vendorRequestApprovalDao);
    }

    @Override
    public List readByUserName(String username) {
        return vendorRequestApprovalDao.readByUserName(username);
    }

    @Override
    public VendorRequestApproval readByDeltecodes(String id) {
        return vendorRequestApprovalDao.readByDeltecodes(id);
    }

}
