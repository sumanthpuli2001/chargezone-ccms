/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;


import com.bul.zydex.dao.Vendor.VendorSafetyCriteriaCommentDao;
import com.bul.zydex.model.VendorSafetyCriteriaComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorSafetyCriteriaCommentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorSafetyCriteriaCommentService<T> {
    
  private VendorSafetyCriteriaCommentDao<T> vendorSafetyCriteriaCommentDao;

    public VendorSafetyCriteriaCommentDao<T> getVendorSafetyCriteriaCommentDao() {
        return vendorSafetyCriteriaCommentDao;
    }

    public void setVendorSafetyCriteriaCommentDao(VendorSafetyCriteriaCommentDao<T> vendorSafetyCriteriaCommentDao) {
        this.vendorSafetyCriteriaCommentDao = vendorSafetyCriteriaCommentDao;
        setGenericsDAO(vendorSafetyCriteriaCommentDao);
        
    }

    @Override
    public List readByVendorInformationId(String VInformationId) {
          return vendorSafetyCriteriaCommentDao.readByVendorInformationId(VInformationId);
    }

   

}