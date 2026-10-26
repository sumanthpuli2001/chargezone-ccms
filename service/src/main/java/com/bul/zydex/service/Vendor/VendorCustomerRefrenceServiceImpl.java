/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorClearanceCertificateDao;
import com.bul.zydex.dao.Vendor.VendorCustomerRefrenceDao;
import com.bul.zydex.model.VendorClearanceCertificate;
import com.bul.zydex.model.VendorCustomerRefrence;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorCustomerRefrenceServiceImpl<T> extends GenericsServiceImpl<T> implements VendorCustomerRefrenceService<T> {

    private VendorCustomerRefrenceDao<T> vendorCustomerRefrenceDao;

    public VendorCustomerRefrenceDao<T> getVendorCustomerRefrenceDao() {
        return vendorCustomerRefrenceDao;
    }

    public void setVendorCustomerRefrenceDao(VendorCustomerRefrenceDao<T> vendorCustomerRefrenceDao) {
        this.vendorCustomerRefrenceDao = vendorCustomerRefrenceDao;
        setGenericsDAO(vendorCustomerRefrenceDao);
    }

    @Override
    public List readId(int id) {
        return vendorCustomerRefrenceDao.readId(id);
    }

    @Override
    public void deleteById(String checkedValues) {
        vendorCustomerRefrenceDao.deleteById(checkedValues);
    }

}
