/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TaxCategory;

import com.bul.zydex.dao.TaxCategory.TaxCategoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class TaxCategoryServiceImpl <T> extends GenericsServiceImpl<T> implements TaxCategoryService<T>{
   private TaxCategoryDao<T> taxCategoryDao; 

    public TaxCategoryDao<T> getTaxCategoryDao() {
        return taxCategoryDao;
    }

    public void setTaxCategoryDao(TaxCategoryDao<T> taxCategoryDao) {
        this.taxCategoryDao = taxCategoryDao;
        setGenericsDAO(taxCategoryDao);
    }

    @Override
    public List getTaxCategoryPagination(int start, int length, String search, String orderColumn, String orderDir) {
        return taxCategoryDao.getTaxCategoryPagination(start, length, search, orderColumn, orderDir);

    
    }

    @Override
    public int getTotalTaxCategoryCount() {
        return taxCategoryDao.getTotalTaxCategoryCount();
    }

    @Override
    public int getFilteredTaxCategoryCount(String searchValue) {
        return taxCategoryDao.getFilteredTaxCategoryCount(searchValue);
    }
   
}
