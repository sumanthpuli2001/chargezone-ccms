/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;


import com.bul.zydex.dao.Vendor.VendorHrCriteriaCommentDao;
import com.bul.zydex.model.VendorHrCriteriaComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorHrCriteriaCommentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorHrCriteriaCommentService<T> {
    
  private VendorHrCriteriaCommentDao<T> vendorHrCriteriaCommentDao;

    public VendorHrCriteriaCommentDao<T> getVendorHrCriteriaCommentDao() {
        return vendorHrCriteriaCommentDao;
    }

    public void setVendorHrCriteriaCommentDao(VendorHrCriteriaCommentDao<T> vendorHrCriteriaCommentDao) {
        this.vendorHrCriteriaCommentDao = vendorHrCriteriaCommentDao;
         setGenericsDAO(vendorHrCriteriaCommentDao);
    }

    @Override
    public List readByVendorInformationId(String VInformationId) {
        return vendorHrCriteriaCommentDao.readByVendorInformationId(VInformationId);
    }

 
    }

   