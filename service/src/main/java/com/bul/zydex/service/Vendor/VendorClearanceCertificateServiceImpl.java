/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorClearanceCertificateDao;
import com.bul.zydex.model.VendorClearanceCertificate;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorClearanceCertificateServiceImpl<T> extends GenericsServiceImpl<T> implements VendorClearanceCertificateService<T> {
    
    private VendorClearanceCertificateDao<T> vendorClearanceCertificateDao;

    public VendorClearanceCertificateDao<T> getVendorClearanceCertificateDao() {
        return vendorClearanceCertificateDao;
    }

    public void setVendorClearanceCertificateDao(VendorClearanceCertificateDao<T> vendorClearanceCertificateDao) {
        this.vendorClearanceCertificateDao = vendorClearanceCertificateDao;
        setGenericsDAO(vendorClearanceCertificateDao);
    }
    
    @Override
    public List readId(int id) {
        return vendorClearanceCertificateDao.readId(id);
    }
    
    @Override
    public void deleteById(String checkedValues) {
        vendorClearanceCertificateDao.deleteById(checkedValues);
    }
}
