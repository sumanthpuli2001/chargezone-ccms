/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProductTypeMaster;

import com.bul.zydex.dao.MaterialMaster.MaterialMasterDao;
import com.bul.zydex.dao.ProductTypeMaster.ProductTypeMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import com.bul.zydex.service.MaterialMaster.MaterialMasterService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class ProductTypeMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ProductTypeMasterService<T> {
     private ProductTypeMasterDao<T> productTypeMasterDao;

    public ProductTypeMasterDao<T> getProductTypeMasterDao() {
        return productTypeMasterDao;
    }

    public void setProductTypeMasterDao(ProductTypeMasterDao<T> productTypeMasterDao) {
        this.productTypeMasterDao = productTypeMasterDao;
        setGenericsDAO(productTypeMasterDao);
    }

    @Override
    public List getTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return productTypeMasterDao.getTypePagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalTypeCount() {
        return productTypeMasterDao.getTotalTypeCount();
    }

    @Override
    public int getFilteredTypeCount(String search) {
        return productTypeMasterDao.getFilteredTypeCount(search);
    }
     
}
