/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorApprovalDao;
import com.bul.zydex.model.VendorApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements VendorApprovalService<T> {
    
    private VendorApprovalDao<T> vendorApprovalDao;

    public VendorApprovalDao<T> getVendorApprovalDao() {
        return vendorApprovalDao;
    }

    public void setVendorApprovalDao(VendorApprovalDao<T> vendorApprovalDao) {
        this.vendorApprovalDao = vendorApprovalDao;
        setGenericsDAO(vendorApprovalDao);
    }
    
    @Override
    public List readId(int id) {
        return vendorApprovalDao.readId(id);
    }

    @Override
    public List readForVendorRecycled(int id) {
        return vendorApprovalDao.readForVendorRecycled(id);
    }
}
