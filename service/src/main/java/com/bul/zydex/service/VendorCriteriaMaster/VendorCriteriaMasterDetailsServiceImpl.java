/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorCriteriaMaster;

import com.bul.zydex.dao.VendorCriteriaMaster.VendorCriteriaMasterDetailsDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaMasterDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements VendorCriteriaMasterDetailsService<T> {

    private VendorCriteriaMasterDetailsDao<T> vendorCriteriaMasterDetailsDao;

    public VendorCriteriaMasterDetailsDao<T> getVendorCriteriaMasterDetailsDao() {
        return vendorCriteriaMasterDetailsDao;
    }

    public void setVendorCriteriaMasterDetailsDao(VendorCriteriaMasterDetailsDao<T> vendorCriteriaMasterDetailsDao) {
        this.vendorCriteriaMasterDetailsDao = vendorCriteriaMasterDetailsDao;
        setGenericsDAO(vendorCriteriaMasterDetailsDao);
    }

    @Override
    public List readByCriteriaMasterId(String criteriaMasterId) {
        return vendorCriteriaMasterDetailsDao.readByCriteriaMasterId(criteriaMasterId);
    }

    @Override
    public void deleteByCriteriaMasterId(int criteriaMasterId) {
        vendorCriteriaMasterDetailsDao.deleteByCriteriaMasterId(criteriaMasterId);
    }

}
