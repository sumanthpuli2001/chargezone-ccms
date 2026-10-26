/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTechnicalBidAttachmentDao;
import com.bul.zydex.model.VendorTechnicalBidAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTechnicalBidAttachmentService<T> {

    private VendorTechnicalBidAttachmentDao<T> vendorTechnicalBidAttachmentDao;

    public VendorTechnicalBidAttachmentDao<T> getVendorTechnicalBidAttachmentDao() {
        return vendorTechnicalBidAttachmentDao;
    }

    public void setVendorTechnicalBidAttachmentDao(VendorTechnicalBidAttachmentDao<T> vendorTechnicalBidAttachmentDao) {
        this.vendorTechnicalBidAttachmentDao = vendorTechnicalBidAttachmentDao;
        setGenericsDAO(vendorTechnicalBidAttachmentDao);
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        return vendorTechnicalBidAttachmentDao.readByVendorRefNo(refNo, username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username, String attachment_desc) {
        return vendorTechnicalBidAttachmentDao.readVendorRefNo(refNo, username, attachment_desc);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String attachment_desc, String attachment_comp, String attachment) {
        vendorTechnicalBidAttachmentDao.updateVendorRefNo(refNo, username, attachment_desc, attachment_comp, attachment);
    }

    @Override
    public VendorTechnicalBidAttachment readByTechdoc(String refNo, String username, String tech_attachment_desc) {
        return vendorTechnicalBidAttachmentDao.readByTechdoc(refNo,username, tech_attachment_desc);
    }

    @Override
    public void readByDelete(String refNo, String username) {
         vendorTechnicalBidAttachmentDao.readByDelete(refNo,username);
    }
}
