/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorPreBidAttachmentDao;
import com.bul.zydex.model.VendorPreBidAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorPreBidAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorPreBidAttachmentService<T> {

    private VendorPreBidAttachmentDao<T> vendorPreBidAttachmentDao;

    public VendorPreBidAttachmentDao<T> getVendorPreBidAttachmentDao() {
        return vendorPreBidAttachmentDao;
    }

    public void setVendorPreBidAttachmentDao(VendorPreBidAttachmentDao<T> vendorPreBidAttachmentDao) {
        this.vendorPreBidAttachmentDao = vendorPreBidAttachmentDao;
        setGenericsDAO(vendorPreBidAttachmentDao);
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        return vendorPreBidAttachmentDao.readByVendorRefNo(refNo, username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username, String pre_attachment_desc) {
        return vendorPreBidAttachmentDao.readVendorRefNo(refNo, username, pre_attachment_desc);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String pre_attachment_desc, String pre_attachment_comp, String pre_attachment) {
        vendorPreBidAttachmentDao.updateVendorRefNo(refNo, username, pre_attachment_desc, pre_attachment_comp, pre_attachment);
    }
}
