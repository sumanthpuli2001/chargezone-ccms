/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorQualityCertificateDao;
import com.bul.zydex.model.VendorQualityCertificate;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorQualityCertificateServiceImpl<T> extends GenericsServiceImpl<T> implements VendorQualityCertificateService<T> {
    
    private VendorQualityCertificateDao<T> vendorQualityCertificateDao;

    public VendorQualityCertificateDao<T> getVendorQualityCertificateDao() {
        return vendorQualityCertificateDao;
    }

    public void setVendorQualityCertificateDao(VendorQualityCertificateDao<T> vendorQualityCertificateDao) {
        this.vendorQualityCertificateDao = vendorQualityCertificateDao;
        setGenericsDAO(vendorQualityCertificateDao);
    }
    
    @Override
    public List readId(int id) {
        return vendorQualityCertificateDao.readId(id);
    }
    
    @Override
    public void deleteById(String checkedValues) {
        vendorQualityCertificateDao.deleteById(checkedValues);
    }
}
