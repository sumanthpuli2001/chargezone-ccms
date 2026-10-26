/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderVendorDao;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderVendorServiceImpl<T> extends GenericsServiceImpl<T> implements TenderVendorService<T> {
    
    private TenderVendorDao<T> tenderVendorDao;

    public TenderVendorDao<T> getTenderVendorDao() {
        return tenderVendorDao;
    }

    public void setTenderVendorDao(TenderVendorDao<T> tenderVendorDao) {
        this.tenderVendorDao = tenderVendorDao;
        setGenericsDAO(tenderVendorDao);
    }

    @Override
    public List readByVendor(String refNo, String vendor_code) {
        return tenderVendorDao.readByVendor(refNo, vendor_code);
    }

    @Override
    public List readByRefNo(String refNo) {
        return tenderVendorDao.readByRefNo(refNo);
    }

    @Override
    public void updateVendor(String refNo, String vendor_code, String email_id, String mobile_no, String checkVendorId) {
        tenderVendorDao.updateVendor(refNo, vendor_code, email_id, mobile_no, checkVendorId);
    }

    @Override
    public List vendorList(String refNo) {
        return tenderVendorDao.vendorList(refNo);
    }

    @Override
    public List readByRfqNo(String ref_no) {
        return tenderVendorDao.readByRfqNo(ref_no);
    }

    @Override
    public void updateRefNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, int checkVendorId1) {
        tenderVendorDao.updateRefNo(refNo1 ,refNo, vendor_code, email_id, mobile_no, checkVendorId1);
    }

    @Override
    public List readByRfqVendor(String ref_no, String vendor_code) {
        return tenderVendorDao.readByRfqVendor(ref_no, vendor_code);
    }

    @Override
    public void delete1(int id) {
        tenderVendorDao.delete1(id);
    }

    @Override
    public List readByRefVendor(String ref_no, String vendor_code) {
        return tenderVendorDao.readByRefVendor(ref_no, vendor_code);
    }

    @Override
    public void updateVendor1(String refNo, String vendor_code, String email_id, String mobile_no) {
        tenderVendorDao.updateVendor1(refNo, vendor_code, email_id, mobile_no);
    }

    @Override
    public TenderVendor readByRefVendor1(String refNo, String checkedValues) {
        return tenderVendorDao.readByRefVendor1(refNo, checkedValues);
    }

    @Override
    public List readVendor(String vendor_code) {
        return tenderVendorDao.readVendor(vendor_code);
    }

    @Override
    public TenderVendor readByRefNo1(String refNo) {
        return tenderVendorDao.readByRefNo1(refNo);
    }

    
    
}
