/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTechnicalBidTechDao;
import com.bul.zydex.model.VendorTechnicalBidTech;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidTechServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTechnicalBidTechService<T> {
    
    private VendorTechnicalBidTechDao<T> vendorTechnicalBidTechDao;

    public VendorTechnicalBidTechDao<T> getVendorTechnicalBidTechDao() {
        return vendorTechnicalBidTechDao;
    }

    public void setVendorTechnicalBidTechDao(VendorTechnicalBidTechDao<T> vendorTechnicalBidTechDao) {
        this.vendorTechnicalBidTechDao = vendorTechnicalBidTechDao;
        setGenericsDAO(vendorTechnicalBidTechDao);
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        return vendorTechnicalBidTechDao.readByVendorRefNo(refNo, username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username, String description) {
        return vendorTechnicalBidTechDao.readVendorRefNo(refNo, username, description);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String description, int vendor_response, String remark) {
        vendorTechnicalBidTechDao.updateVendorRefNo(refNo, username, description, vendor_response, remark);
    }

    @Override
    public List readByReviseVendorBid(String refNo, String username, int revise_technical_bid_id) {
        return vendorTechnicalBidTechDao.readByReviseVendorBid(refNo, username, revise_technical_bid_id);
    }

    @Override
    public void updateAdminVendorRefNo(String refNo, String username, String vendor_tech_desc, int parseInt, String tech_vendor_remark, int revise_id) {
        vendorTechnicalBidTechDao.updateAdminVendorRefNo(refNo, username, vendor_tech_desc, parseInt, tech_vendor_remark, revise_id);
    }

    @Override
    public void readByDelete(String refNo, String username) {
         vendorTechnicalBidTechDao.readByDelete(refNo, username);
    }
}
