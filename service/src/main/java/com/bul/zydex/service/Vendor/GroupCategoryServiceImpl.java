/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.GroupCategoryDao;
import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GroupCategoryServiceImpl<T> extends GenericsServiceImpl<T> implements GroupCategoryService<T> {

    private GroupCategoryDao<T> groupCategoryDao;

    public GroupCategoryDao<T> getGroupCategoryDao() {
        return groupCategoryDao;
    }

    public void setGroupCategoryDao(GroupCategoryDao<T> groupCategoryDao) {
        this.groupCategoryDao = groupCategoryDao;
        setGenericsDAO(groupCategoryDao);
    }

    @Override
    public List readAll() {
        return groupCategoryDao.readAll();
    }

    @Override
    public GroupCategory readByIds(int id) {
        return groupCategoryDao.readByIds(id);
    }

    @Override
    public List readByGroupMasterId(int groupMasterId) {
        return groupCategoryDao.readByGroupMasterId(groupMasterId);
    }

    @Override
    public List getGroupCategoryPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return groupCategoryDao.getGroupCategoryPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalGroupCategoryCount() {
        return groupCategoryDao.getTotalGroupCategoryCount();
    }

    @Override
    public int getFilteredGroupCategoryCount(String searchValue) {
        return groupCategoryDao.getFilteredGroupCategoryCount(searchValue);
    }

}
