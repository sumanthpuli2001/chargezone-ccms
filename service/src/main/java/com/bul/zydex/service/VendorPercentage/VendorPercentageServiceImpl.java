/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorPercentage;

import com.bul.zydex.dao.VendorPercentage.VendorPercentageDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorPercentageServiceImpl<T> extends GenericsServiceImpl<T> implements VendorPercentageService<T> {

    private VendorPercentageDao<T> vendorPercentageDao;

    public VendorPercentageDao<T> getVendorPercentageDao() {
        return vendorPercentageDao;
    }

    public void setVendorPercentageDao(VendorPercentageDao<T> vendorPercentageDao) {
        this.vendorPercentageDao = vendorPercentageDao;
        setGenericsDAO(vendorPercentageDao);
    }

    @Override
    public List getVendorPercentagePagination(int start, int length, String search, String orderColumn, String orderDir) {

        return vendorPercentageDao.getVendorPercentagePagination(start, length, search, orderColumn, orderDir);

    }

    @Override
    public int getTotalVendorPercentageCount() {
        return vendorPercentageDao.getTotalVendorPercentageCount();
    }

    @Override
    public int getFilteredVendorPercentageCount(String searchValue) {
        return vendorPercentageDao.getFilteredVendorPercentageCount(searchValue);
    }

}
