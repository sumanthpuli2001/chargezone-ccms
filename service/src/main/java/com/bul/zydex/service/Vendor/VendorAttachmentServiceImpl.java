/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorAttachmentDao;
import com.bul.zydex.model.VendorAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class VendorAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements VendorAttachmentService<T> {
 
    private VendorAttachmentDao<T> vendorAttachmentDao;

    public VendorAttachmentDao<T> getVendorAttachmentDao() {
        return vendorAttachmentDao;
    }

    public void setVendorAttachmentDao(VendorAttachmentDao<T> vendorAttachmentDao) {
        this.vendorAttachmentDao = vendorAttachmentDao;
        setGenericsDAO(vendorAttachmentDao);
    }

    @Override
    public List readAttachment(String refNo, String vendor_code, String attachment_type) {
        return vendorAttachmentDao.readAttachment(refNo, vendor_code, attachment_type);
    }
}
