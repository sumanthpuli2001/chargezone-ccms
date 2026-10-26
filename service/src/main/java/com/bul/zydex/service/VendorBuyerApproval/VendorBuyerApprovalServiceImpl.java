/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorBuyerApproval;

import com.bul.zydex.dao.VendorBuyerApproval.VendorBuyerApprovalDao;
import com.bul.zydex.model.VendorBuyerApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VendorBuyerApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements VendorBuyerApprovalService<T> {

    private VendorBuyerApprovalDao<T> vendorBuyerApprovalDao;

    public VendorBuyerApprovalDao<T> getVendorBuyerApprovalDao() {
        return vendorBuyerApprovalDao;
    }

    public void setVendorBuyerApprovalDao(VendorBuyerApprovalDao<T> vendorBuyerApprovalDao) {
        this.vendorBuyerApprovalDao = vendorBuyerApprovalDao;
        setGenericsDAO(vendorBuyerApprovalDao);
    }
    
    @Override
    public VendorBuyerApproval readByVendorInvtId(int vendorInvtId) {
        return vendorBuyerApprovalDao.readByVendorInvtId(vendorInvtId);

    }
    
    @Override
    public List readByVendorInvtIdList(int vendorInvtId) {
        return vendorBuyerApprovalDao.readByVendorInvtIdList(vendorInvtId);

    }
}
