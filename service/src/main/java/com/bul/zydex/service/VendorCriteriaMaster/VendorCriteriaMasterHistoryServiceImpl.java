/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorCriteriaMaster;

import com.bul.zydex.dao.VendorCriteriaMaster.VendorCriteriaMasterHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaMasterHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements VendorCriteriaMasterHistoryService<T> {

    private VendorCriteriaMasterHistoryDao<T> vendorCriteriaMasterHistoryDao;

    public VendorCriteriaMasterHistoryDao<T> getVendorCriteriaMasterHistoryDao() {
        return vendorCriteriaMasterHistoryDao;
    }

    public void setVendorCriteriaMasterHistoryDao(VendorCriteriaMasterHistoryDao<T> vendorCriteriaMasterHistoryDao) {
        this.vendorCriteriaMasterHistoryDao = vendorCriteriaMasterHistoryDao;
        setGenericsDAO(vendorCriteriaMasterHistoryDao);
    }
    
}
