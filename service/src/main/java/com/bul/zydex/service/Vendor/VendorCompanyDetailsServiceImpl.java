/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.service.GenericsServiceImpl;
import com.bul.zydex.dao.Vendor.VendorCompanyDetailsDao;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorCompanyDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements VendorCompanyDetailsService<T> {
    
    private VendorCompanyDetailsDao<T> vendorCompanyDetailsDao;

    public VendorCompanyDetailsDao<T> getVendorCompanyDetailsDao() {
        return vendorCompanyDetailsDao;
    }

    public void setVendorCompanyDetailsDao(VendorCompanyDetailsDao<T> vendorCompanyDetailsDao) {
        this.vendorCompanyDetailsDao = vendorCompanyDetailsDao;
         setGenericsDAO(vendorCompanyDetailsDao);
    }

    @Override
    public List readByVendorMail(String email) {
       return vendorCompanyDetailsDao.readByVendorMail(email);
    }

    @Override
    public List readByInformationId(String vendorInformationid) {
       return vendorCompanyDetailsDao.readByInformationId(vendorInformationid);
    }

    
    
}
