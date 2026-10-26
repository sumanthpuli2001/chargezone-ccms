/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTechnicalBidTermsDao;
import com.bul.zydex.model.VendorTechnicalBidTerms;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidTermsServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTechnicalBidTermsService<T> {
    
    private VendorTechnicalBidTermsDao<T> vendorTechnicalBidTermsDao;

    public VendorTechnicalBidTermsDao<T> getVendorTechnicalBidTermsDao() {
        return vendorTechnicalBidTermsDao;
    }

    public void setVendorTechnicalBidTermsDao(VendorTechnicalBidTermsDao<T> vendorTechnicalBidTermsDao) {
        this.vendorTechnicalBidTermsDao = vendorTechnicalBidTermsDao;
        setGenericsDAO(vendorTechnicalBidTermsDao);
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        return vendorTechnicalBidTermsDao.readByVendorRefNo(refNo, username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username, String description) {
        return vendorTechnicalBidTermsDao.readVendorRefNo(refNo, username, description);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String description, int vendor_response, String remark) {
        vendorTechnicalBidTermsDao.updateVendorRefNo(refNo, username, description, vendor_response, remark);
    }

    @Override
    public List readByReviseVendorBid(String refNo, String username, int revise_technical_bid_id) {
        return vendorTechnicalBidTermsDao.readByReviseVendorBid(refNo, username, revise_technical_bid_id);
    }

    @Override
    public void updateAdminVendorRefNo(String refNo, String username, String vendor_terms_desc, int parseInt, String terms_vendor_remark, int revise_id) {
        vendorTechnicalBidTermsDao.updateAdminVendorRefNo(refNo, username, vendor_terms_desc, parseInt, terms_vendor_remark, revise_id);
    }

    @Override
    public void readByDelete(String refNo, String username) {
         vendorTechnicalBidTermsDao.readByDelete(refNo, username);
    }
}
