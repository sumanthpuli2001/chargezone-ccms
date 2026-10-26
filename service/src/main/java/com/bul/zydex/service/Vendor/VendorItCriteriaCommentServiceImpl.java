/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorItCriteriaCommentDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorItCriteriaCommentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorItCriteriaCommentService<T> {

    private VendorItCriteriaCommentDao<T> vendorItCriteriaCommentDao;

    public VendorItCriteriaCommentDao<T> getVendorItCriteriaCommentDao() {
        return vendorItCriteriaCommentDao;
    }

    public void setVendorItCriteriaCommentDao(VendorItCriteriaCommentDao<T> vendorItCriteriaCommentDao) {
        this.vendorItCriteriaCommentDao = vendorItCriteriaCommentDao;
        setGenericsDAO(vendorItCriteriaCommentDao);
    }

    @Override
    public List readByVendorInformationId(String VInformationId) {
        return vendorItCriteriaCommentDao.readByVendorInformationId(VInformationId);
    }

}
