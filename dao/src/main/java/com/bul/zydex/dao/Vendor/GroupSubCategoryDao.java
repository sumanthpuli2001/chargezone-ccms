/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.GroupSubCategory;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GroupSubCategoryDao<T> extends GenericsDAO<T> {

    public List readAll();

    public GroupSubCategory readByIds(int id);

    public List readByGroupMasterId(int id);

    public List<?> readByCategoryId(int id);

    public List getGroupSubCategoryPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalGroupSubCategoryCount();

    public int getFilteredGroupSubCategoryCount(String searchValue);

}
