/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorBusinessCertificateDao;
import com.bul.zydex.model.VendorBusinessCertificate;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorBusinessCertificateServiceImpl<T> extends GenericsServiceImpl<T> implements VendorBusinessCertificateService<T> {
    
    private VendorBusinessCertificateDao<T> vendorBusinessCertificateDao;

    public VendorBusinessCertificateDao<T> getVendorBusinessCertificateDao() {
        return vendorBusinessCertificateDao;
    }

    public void setVendorBusinessCertificateDao(VendorBusinessCertificateDao<T> vendorBusinessCertificateDao) {
        this.vendorBusinessCertificateDao = vendorBusinessCertificateDao;
        setGenericsDAO(vendorBusinessCertificateDao);
    }
    
    @Override
    public List readId(int id) {
        return vendorBusinessCertificateDao.readId(id);
    }
    
    @Override
    public void deleteById(String checkedValues) {
        vendorBusinessCertificateDao.deleteById(checkedValues);
    }
}
