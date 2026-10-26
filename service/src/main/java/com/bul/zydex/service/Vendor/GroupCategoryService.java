/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GroupCategoryService<T> extends GenericsService<T> {

    public List readAll();

    public GroupCategory readByIds(int id);

    public List readByGroupMasterId(int groupMasterId);

    public List getGroupCategoryPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalGroupCategoryCount();

    public int getFilteredGroupCategoryCount(String searchValue);

}
