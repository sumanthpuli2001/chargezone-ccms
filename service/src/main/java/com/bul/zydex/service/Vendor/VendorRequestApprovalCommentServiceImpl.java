/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorRequestApprovalCommentDao;
import com.bul.zydex.model.VendorRequestApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorRequestApprovalCommentService<T> {

    private VendorRequestApprovalCommentDao<T> vendorRequestApprovalCommentDao;

    public VendorRequestApprovalCommentDao<T> getVendorRequestApprovalCommentDao() {
        return vendorRequestApprovalCommentDao;
    }

    public void setVendorRequestApprovalCommentDao(VendorRequestApprovalCommentDao<T> vendorRequestApprovalCommentDao) {
        this.vendorRequestApprovalCommentDao = vendorRequestApprovalCommentDao;
        setGenericsDAO(vendorRequestApprovalCommentDao);
    }

    @Override
    public VendorRequestApprovalComment readByApproveId(int approvalid) {
        return vendorRequestApprovalCommentDao.readByApproveId(approvalid);
    }

}
