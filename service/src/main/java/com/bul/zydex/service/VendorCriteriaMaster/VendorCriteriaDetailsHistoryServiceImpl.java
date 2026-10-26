/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorCriteriaMaster;

import com.bul.zydex.dao.VendorCriteriaMaster.VendorCriteriaDetailsHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaDetailsHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements VendorCriteriaDetailsHistoryService<T> {

    private VendorCriteriaDetailsHistoryDao<T> vendorCriteriaDetailsHistoryDao;

    public VendorCriteriaDetailsHistoryDao<T> getVendorCriteriaDetailsHistoryDao() {
        return vendorCriteriaDetailsHistoryDao;
    }

    public void setVendorCriteriaDetailsHistoryDao(VendorCriteriaDetailsHistoryDao<T> vendorCriteriaDetailsHistoryDao) {
        this.vendorCriteriaDetailsHistoryDao = vendorCriteriaDetailsHistoryDao;
        setGenericsDAO(vendorCriteriaDetailsHistoryDao);
    }

    @Override
    public List readByCriteriaMasterId(int id) {
        return vendorCriteriaDetailsHistoryDao.readByCriteriaMasterId(id);
    }

}
