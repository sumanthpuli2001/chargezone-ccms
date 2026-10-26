/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorInviteSource;

import com.bul.zydex.dao.VendorInviteSource.VendorInviteSourceDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorInviteSourceServiceImpl<T> extends GenericsServiceImpl<T> implements VendorInviteSourceService<T> {

    private VendorInviteSourceDao<T> vendorInviteSourceDao;

    public VendorInviteSourceDao<T> getVendorInviteSourceDao() {
        return vendorInviteSourceDao;
    }

    public void setVendorInviteSourceDao(VendorInviteSourceDao<T> vendorInviteSourceDao) {
        this.vendorInviteSourceDao = vendorInviteSourceDao;
        setGenericsDAO(vendorInviteSourceDao);
    }

    @Override
    public List getVendorInviteSourcePagination(int start, int length, String search, String orderColumn, String orderDir) {
        return vendorInviteSourceDao.getVendorInviteSourcePagination(start, length, search, orderColumn, orderDir);
    }

    @Override
    public int getTotalVendorInviteSourceCount() {
        return vendorInviteSourceDao.getTotalVendorInviteSourceCount();
    }

    @Override
    public int getFilteredVendorInviteSourceCount(String searchValue) {
        return vendorInviteSourceDao.getFilteredVendorInviteSourceCount(searchValue);
    }

}
