/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.GroupSubCategoryDao;
import com.bul.zydex.model.GroupSubCategory;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GroupSubCategoryServiceImpl<T> extends GenericsServiceImpl<T> implements GroupSubCategoryService<T> {

    private GroupSubCategoryDao<T> groupSubCategoryDao;

    public GroupSubCategoryDao<T> getGroupSubCategoryDao() {
        return groupSubCategoryDao;
    }

    public void setGroupSubCategoryDao(GroupSubCategoryDao<T> groupSubCategoryDao) {
        this.groupSubCategoryDao = groupSubCategoryDao;
        setGenericsDAO(groupSubCategoryDao);
    }

    @Override
    public List readAll() {
        return groupSubCategoryDao.readAll();
    }

    @Override
    public GroupSubCategory readByIds(int id) {
        return groupSubCategoryDao.readByIds(id);
    }

    @Override
    public List readByGroupMasterId(int id) {
        return groupSubCategoryDao.readByGroupMasterId(id);
    }

    @Override
    public List<?> readByCategoryId(int id) {
        return groupSubCategoryDao.readByCategoryId(id);
    }

    @Override
    public List getGroupSubCategoryPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return groupSubCategoryDao.getGroupSubCategoryPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalGroupSubCategoryCount() {
        return groupSubCategoryDao.getTotalGroupSubCategoryCount();
    }

    @Override
    public int getFilteredGroupSubCategoryCount(String searchValue) {
        return groupSubCategoryDao.getFilteredGroupSubCategoryCount(searchValue);
    }
}
