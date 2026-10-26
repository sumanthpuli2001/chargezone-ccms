/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTechnicalBidDao;
import com.bul.zydex.model.VendorTechnicalBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTechnicalBidService<T> {

    private VendorTechnicalBidDao<T> vendorTechnicalBidDao;

    public VendorTechnicalBidDao<T> getVendorTechnicalBidDao() {
        return vendorTechnicalBidDao;
    }

    public void setVendorTechnicalBidDao(VendorTechnicalBidDao<T> vendorTechnicalBidDao) {
        this.vendorTechnicalBidDao = vendorTechnicalBidDao;
        setGenericsDAO(vendorTechnicalBidDao);
    }

    @Override
    public VendorTechnicalBid readByVendorRefNo(String refNo, String username) {
        return vendorTechnicalBidDao.readByVendorRefNo(refNo, username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        return vendorTechnicalBidDao.readVendorRefNo(refNo, username);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String technicalBidDeviation, String technicalBidRemark) {
        vendorTechnicalBidDao.updateVendorRefNo(refNo, username, technicalBidDeviation, technicalBidRemark);
    }

    @Override
    public List vendorList(String refNo) {
        return vendorTechnicalBidDao.vendorList(refNo);
    }

    @Override
    public List techBidList(String refNo) {
        return vendorTechnicalBidDao.techBidList(refNo);
    }

    @Override
    public List techBidOpenList(String refNo) {
        return vendorTechnicalBidDao.techBidOpenList(refNo);
    }

    @Override
    public void openTechBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate) {
        vendorTechnicalBidDao.openTechBid(refNo, vendor_list, user_by, user_by_id, formattedDate);
    }

    @Override
    public void approveTechBid(String refNo, String checkedValues, String employee_name, String username, String formattedDate) {
        vendorTechnicalBidDao.approveTechBid(refNo, checkedValues, employee_name, username, formattedDate);
    }

    @Override
    public List techBidOpenList1(String refNo) {
        return vendorTechnicalBidDao.techBidOpenList1(refNo);
    }

    @Override
    public List checkBidOpen(String refNo) {
        return vendorTechnicalBidDao.checkBidOpen(refNo);
    }

    @Override
    public List readByVendorRefNo1(String refNo) {
        return vendorTechnicalBidDao.readByVendorRefNo1(refNo);
    }

    @Override
    public void readByDelete(String refNo, String username) {
        vendorTechnicalBidDao.readByDelete(refNo, username);
    }

    @Override
    public boolean readByRefNO(String refNo) {
        return vendorTechnicalBidDao.readByRefNO(refNo);
    }

    @Override
    public List techBidOpenListPrSummary(String refNo) {
        return vendorTechnicalBidDao.techBidOpenListPrSummary(refNo);
    }

}
