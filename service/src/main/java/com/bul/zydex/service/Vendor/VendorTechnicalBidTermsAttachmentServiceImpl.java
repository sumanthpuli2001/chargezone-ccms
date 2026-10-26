/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTechnicalBidTermsAttachmentDao;
import com.bul.zydex.model.VendorTechnicalBidTermsAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidTermsAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTechnicalBidTermsAttachmentService<T> {

    private VendorTechnicalBidTermsAttachmentDao<T> vendorTechnicalBidTermsAttachmentDao;

    public VendorTechnicalBidTermsAttachmentDao<T> getVendorTechnicalBidTermsAttachmentDao() {
        return vendorTechnicalBidTermsAttachmentDao;
    }

    public void setVendorTechnicalBidTermsAttachmentDao(VendorTechnicalBidTermsAttachmentDao<T> vendorTechnicalBidTermsAttachmentDao) {
        this.vendorTechnicalBidTermsAttachmentDao = vendorTechnicalBidTermsAttachmentDao;
        setGenericsDAO(vendorTechnicalBidTermsAttachmentDao);
    }

    @Override
    public List readAttachment(String refNo, String username, String desc) {
        return vendorTechnicalBidTermsAttachmentDao.readAttachment(refNo, username, desc);
    }

    @Override
    public List readByVendorRefNo(String refNo, String vendorCode) {
        return vendorTechnicalBidTermsAttachmentDao.readVendorRefNo(refNo,vendorCode);
    }
}
