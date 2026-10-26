/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupMaster;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GroupCategoryDao<T> extends GenericsDAO<T> {

    public List readAll();

    public GroupCategory readByIds(int id);

    public List readByGroupMasterId(int groupMasterId);

    public List getGroupCategoryPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalGroupCategoryCount();

    public int getFilteredGroupCategoryCount(String searchValue);

}
