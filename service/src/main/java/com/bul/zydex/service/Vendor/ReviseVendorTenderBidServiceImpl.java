/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.ReviseVendorTenderBidDao;
import com.bul.zydex.model.ReviseVendorTenderBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class ReviseVendorTenderBidServiceImpl<T> extends GenericsServiceImpl<T> implements ReviseVendorTenderBidService<T> {
    
    private ReviseVendorTenderBidDao<T> reviseVendorTenderBidDao;

    public ReviseVendorTenderBidDao<T> getReviseVendorTenderBidDao() {
        return reviseVendorTenderBidDao;
    }

    public void setReviseVendorTenderBidDao(ReviseVendorTenderBidDao<T> reviseVendorTenderBidDao) {
        this.reviseVendorTenderBidDao = reviseVendorTenderBidDao;
        setGenericsDAO(reviseVendorTenderBidDao);
    }

    @Override
    public ReviseVendorTenderBid readByVendorRefNo(String refNo, String username) {
        return reviseVendorTenderBidDao.readByVendorRefNo(refNo,username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        return reviseVendorTenderBidDao.readVendorRefNo(refNo, username);
    }

    @Override
    public void updateVendorItem(String refNo, String username, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total, String venodr_total_words) {
        reviseVendorTenderBidDao.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);
    }

    @Override
    public void updateVendorServiceItem(String refNo, String username, String discount_val, String discount, String igst, String total_amount, String grand_total) {
          reviseVendorTenderBidDao.updateVendorServiceItem(refNo, username,discount_val,discount,igst,total_amount,grand_total);
    }

    @Override
    public List vendorBidPrice(String refNo, String vendor_code) {
        return reviseVendorTenderBidDao.vendorBidPrice(refNo, vendor_code);
    }
}
