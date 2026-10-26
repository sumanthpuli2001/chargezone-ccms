/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.ReviseVendorTechnicalBidDao;
import com.bul.zydex.model.ReviseVendorTechnicalBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public class ReviseVendorTechnicalBidServiceImpl<T> extends GenericsServiceImpl<T> implements ReviseVendorTechnicalBidService<T> {
 
    private ReviseVendorTechnicalBidDao<T> reviseVendorTechnicalBidDao;

    public ReviseVendorTechnicalBidDao<T> getReviseVendorTechnicalBidDao() {
        return reviseVendorTechnicalBidDao;
    }

    public void setReviseVendorTechnicalBidDao(ReviseVendorTechnicalBidDao<T> reviseVendorTechnicalBidDao) {
        this.reviseVendorTechnicalBidDao = reviseVendorTechnicalBidDao;
        setGenericsDAO(reviseVendorTechnicalBidDao);
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        return reviseVendorTechnicalBidDao.readByVendorRefNo(refNo, username);
    }
}
