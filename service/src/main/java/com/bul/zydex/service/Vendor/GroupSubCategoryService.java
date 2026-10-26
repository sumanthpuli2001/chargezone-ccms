/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.GroupSubCategory;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GroupSubCategoryService<T> extends GenericsService<T> {

    public List readAll();

    public GroupSubCategory readByIds(int id);

    public List readByGroupMasterId(int id);

    public List<?> readByCategoryId(int parseInt);

    public List getGroupSubCategoryPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalGroupSubCategoryCount();

    public int getFilteredGroupSubCategoryCount(String searchValue);

}
