/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TaxCategory;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface TaxCategoryService<T> extends GenericsService<T> {

    public List getTaxCategoryPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalTaxCategoryCount();

    public int getFilteredTaxCategoryCount(String searchValue);

}
