/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderVendorDocDao;
import com.bul.zydex.model.TenderVendorDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderVendorDocServiceImpl<T> extends GenericsServiceImpl<T> implements TenderVendorDocService<T> {

    private TenderVendorDocDao<T> tenderVendorDocDao;

    public TenderVendorDocDao<T> getTenderVendorDocDao() {
        return tenderVendorDocDao;
    }

    public void setTenderVendorDocDao(TenderVendorDocDao<T> tenderVendorDocDao) {
        this.tenderVendorDocDao = tenderVendorDocDao;
        setGenericsDAO(tenderVendorDocDao);
    }

    @Override
    public List readGeneralDoc(String refNo, String vendor_code, int i) {
        return tenderVendorDocDao.readGeneralDoc(refNo,vendor_code,i);
    }

    @Override
    public List readAdditionalDoc(String refNo, String vendor_code, int i) {
        return tenderVendorDocDao.readAdditionalDoc(refNo,vendor_code,i);
    }

    @Override
    public List readTechnicalDoc(String refNo, String vendor_code, int i) {
        return tenderVendorDocDao.readTechnicalDoc(refNo,vendor_code,i);
    }

    @Override
    public List readByRefNo(String refNo, String vendor_code) {
        return tenderVendorDocDao.readByRefNo(refNo,vendor_code);
    }

    @Override
    public List readByDocRefNo(String refNo, String vendor_code, String attachment) {
        return tenderVendorDocDao.readByDocRefNo(refNo,vendor_code, attachment);
    }

    @Override
    public void deleteByVendor(String refNo, String vendor_code) {
        tenderVendorDocDao.deleteByVendor(refNo, vendor_code);
    }
}
