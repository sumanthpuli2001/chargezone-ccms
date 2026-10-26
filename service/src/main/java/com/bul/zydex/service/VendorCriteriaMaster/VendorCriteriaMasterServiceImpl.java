/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorCriteriaMaster;

import com.bul.zydex.dao.VendorCriteriaMaster.VendorCriteriaMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaMasterServiceImpl<T> extends GenericsServiceImpl<T> implements VendorCriteriaMasterService<T> {

    private VendorCriteriaMasterDao<T> vendorCriteriaMasterDao;

    public VendorCriteriaMasterDao<T> getVendorCriteriaMasterDao() {
        return vendorCriteriaMasterDao;
    }

    public void setVendorCriteriaMasterDao(VendorCriteriaMasterDao<T> vendorCriteriaMasterDao) {
        this.vendorCriteriaMasterDao = vendorCriteriaMasterDao;
        setGenericsDAO(vendorCriteriaMasterDao);
    }

    @Override
    public List readByAll(int vendorInvtId, String groupId, String groupCategoryId, String groupSubCategoryId, String departCategory) {
        return vendorCriteriaMasterDao.readByAll(vendorInvtId, groupId, groupCategoryId, groupSubCategoryId, departCategory);
    }

    @Override
    public List readByFirstTwo(int vendorInvtId, String groupId, String groupCategoryId, String departCategory) {
        return vendorCriteriaMasterDao.readByFirstTwo(vendorInvtId, groupId, groupCategoryId, departCategory);
    }

    @Override
    public List readByFirstOne(int vendorInvtId, String groupId, String departCategory) {
        return vendorCriteriaMasterDao.readByFirstOne(vendorInvtId, groupId, departCategory);
    }

    @Override
    public List getVendorCriteriaPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return vendorCriteriaMasterDao.getVendorCriteriaPagination(start, length, searchValue, orderColumn, orderDir);

    }

    @Override
    public int getTotalVendorCriteriaCount() {
        return vendorCriteriaMasterDao.getTotalVendorCriteriaCount();

    }

    @Override
    public int getFilteredVendorCriteriaCount(String searchValue) {

        return vendorCriteriaMasterDao.getFilteredVendorCriteriaCount(searchValue);

    }
}
