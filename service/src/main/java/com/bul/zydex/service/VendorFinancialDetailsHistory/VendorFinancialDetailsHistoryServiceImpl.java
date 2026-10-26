/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorFinancialDetailsHistory;

import com.bul.zydex.dao.VendorFinancialDetailsHistory.VendorFinancialDetailsHistoryDao;
import com.bul.zydex.model.VendorFinancialDetailsHistory;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class VendorFinancialDetailsHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements VendorFinancialDetailsHistoryService<T> {

    private VendorFinancialDetailsHistoryDao<T> vendorFinancialDetailsHistoryDao;

    public VendorFinancialDetailsHistoryDao<T> getVendorFinancialDetailsHistoryDao() {
        return vendorFinancialDetailsHistoryDao;
    }

    public void setVendorFinancialDetailsHistoryDao(VendorFinancialDetailsHistoryDao<T> vendorFinancialDetailsHistoryDao) {
        this.vendorFinancialDetailsHistoryDao = vendorFinancialDetailsHistoryDao;

        setGenericsDAO(vendorFinancialDetailsHistoryDao);
    }

    @Override
    public VendorFinancialDetailsHistory readByVendorinfoId(int id) {

        return vendorFinancialDetailsHistoryDao.readByVendorinfoId(id);

    }

    @Override
    public List readByVendorFinancialDetailsHistory() {

        return vendorFinancialDetailsHistoryDao.readByVendorFinancialDetailsHistory();

    }

    @Override
    public List readByVendorinfoIds(int id) {
        return vendorFinancialDetailsHistoryDao.readByVendorinfoIds(id);

    }

    @Override
    public List readByVendorFinanHistoryinfoid(String vendorInfoid) {
        return vendorFinancialDetailsHistoryDao.readByVendorFinanHistoryinfoid(vendorInfoid);
    }

    @Override
    public VendorFinancialDetailsHistory readyByReVisonR0(int id) {
        return vendorFinancialDetailsHistoryDao.VendorFinancialDetailsHistory(id);

    }

}
