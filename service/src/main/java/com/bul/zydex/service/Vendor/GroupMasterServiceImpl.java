/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.GroupMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GroupMasterServiceImpl<T> extends GenericsServiceImpl<T> implements GroupMasterService<T> {

    private GroupMasterDao<T> groupMasterDao;

    public GroupMasterDao<T> getGroupMasterDao() {
        return groupMasterDao;
    }

    public void setGroupMasterDao(GroupMasterDao<T> groupMasterDao) {
        this.groupMasterDao = groupMasterDao;
        setGenericsDAO(groupMasterDao);
    }

    @Override
    public List getGroupMasterPagination(int start, int length, String search, String orderColumn, String orderDir) {
        return groupMasterDao.getGroupMasterPagination(start, length, search, orderColumn, orderDir);
    }

    @Override
    public int getTotalGroupMasterCount() {
        return groupMasterDao.getTotalGroupMasterCount();
    }

    @Override
    public int getFilteredGroupMasterCount(String searchValue) {
        return groupMasterDao.getFilteredGroupMasterCount(searchValue);
    }

}
