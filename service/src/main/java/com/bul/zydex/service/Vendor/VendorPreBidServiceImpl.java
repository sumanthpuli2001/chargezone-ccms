/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorPreBidDao;
import com.bul.zydex.model.VendorPreBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class VendorPreBidServiceImpl<T> extends GenericsServiceImpl<T> implements VendorPreBidService<T> {
    private VendorPreBidDao<T> vendorPreBidDao;

    public VendorPreBidDao<T> getVendorPreBidDao() {
        return vendorPreBidDao;
    }

    public void setVendorPreBidDao(VendorPreBidDao<T> vendorPreBidDao) {
        this.vendorPreBidDao = vendorPreBidDao;
        setGenericsDAO(vendorPreBidDao);
    }

    @Override
    public VendorPreBid readByVendorRefNo(String refNo, String username) {
        return vendorPreBidDao.readByVendorRefNo(refNo,username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        return vendorPreBidDao.readVendorRefNo(refNo,username);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String preBidDeviation, String preBidRemark) {
        vendorPreBidDao.updateVendorRefNo(refNo, username, preBidDeviation, preBidRemark);
    }

    @Override
    public List vendorList(String refNo) {
        return vendorPreBidDao.vendorList(refNo);
    }

    @Override
    public List preBidList(String refNo) {
        return vendorPreBidDao.preBidList(refNo);
    }

    @Override
    public List preBidOpenList(String refNo) {
        return vendorPreBidDao.preBidOpenList(refNo);
    }

    @Override
    public void openPreBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate) {
        vendorPreBidDao.openPreBid(refNo, vendor_list, user_by, user_by_id, formattedDate);
    }

    @Override
    public void approvePreBid(String refNo, String checkedValues, String employee_name, String username, String formattedDate) {
        vendorPreBidDao.approvePreBid(refNo, checkedValues, employee_name, username, formattedDate);
    }
}
