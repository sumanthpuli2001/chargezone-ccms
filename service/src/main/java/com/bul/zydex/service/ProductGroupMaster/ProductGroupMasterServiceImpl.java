/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProductGroupMaster;

import com.bul.zydex.dao.ProductGroupMaster.ProductGroupMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class ProductGroupMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ProductGroupMasterService<T> {

    private ProductGroupMasterDao<T> productGroupMasterDao;

    public ProductGroupMasterDao<T> getProductGroupMasterDao() {
        return productGroupMasterDao;
    }

    public void setProductGroupMasterDao(ProductGroupMasterDao<T> productGroupMasterDao) {
        this.productGroupMasterDao = productGroupMasterDao;
        setGenericsDAO(productGroupMasterDao);
    }

    @Override
    public List readAll() {
        return productGroupMasterDao.readAll();
    }

    @Override
    public List getProGroupPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return productGroupMasterDao.getProGroupPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalProGroupCount() {
        return productGroupMasterDao.getTotalProGroupCount();
    }

    @Override
    public int getFilteredProGroupCount(String search) {
        return productGroupMasterDao.getFilteredProGroupCount(search);
    }

}
