/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTechnicalBidTechAttachmentDao;
import com.bul.zydex.model.VendorTechnicalBidTechAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidTechAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTechnicalBidTechAttachmentService<T> {
 
    private VendorTechnicalBidTechAttachmentDao<T> vendorTechnicalBidTechAttachmentDao;

    public VendorTechnicalBidTechAttachmentDao<T> getVendorTechnicalBidTechAttachmentDao() {
        return vendorTechnicalBidTechAttachmentDao;
    }

    public void setVendorTechnicalBidTechAttachmentDao(VendorTechnicalBidTechAttachmentDao<T> vendorTechnicalBidTechAttachmentDao) {
        this.vendorTechnicalBidTechAttachmentDao = vendorTechnicalBidTechAttachmentDao;
        setGenericsDAO(vendorTechnicalBidTechAttachmentDao);
    }

    @Override
    public List readAttachment(String refNo, String username, String desc) {
        return vendorTechnicalBidTechAttachmentDao.readAttachment(refNo, username, desc);
    }

    @Override
    public List readByVendorRefNo(String refNo, String vendorCode) {
        return vendorTechnicalBidTechAttachmentDao.readVendorRefNo(refNo,vendorCode);
    }
}
