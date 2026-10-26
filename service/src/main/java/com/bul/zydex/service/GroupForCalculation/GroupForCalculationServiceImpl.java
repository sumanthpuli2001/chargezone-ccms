/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.GroupForCalculation;

import com.bul.zydex.dao.GroupForCalculation.GroupForCalculationDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class GroupForCalculationServiceImpl<T> extends GenericsServiceImpl<T> implements GroupForCalculationService<T> {

    private GroupForCalculationDao<T> groupForCalculationDao;

    public GroupForCalculationDao<T> getGroupForCalculationDao() {
        return groupForCalculationDao;
    }

    public void setGroupForCalculationDao(GroupForCalculationDao<T> groupForCalculationDao) {
        this.groupForCalculationDao = groupForCalculationDao;
        setGenericsDAO(groupForCalculationDao);
    }

    @Override
    public List getGroupCalculationPagination(int start, int length, String search, String orderColumn, String orderDir) {
        return groupForCalculationDao.getGroupCalculationPagination(start, length, search, orderColumn, orderDir);

    }

    @Override
    public int getTotalGroupCalculationCount() {
        return groupForCalculationDao.getTotalGroupCalculationCount();
    }

    @Override
    public int getFilteredGroupCalculationCount(String searchValue) {

        return groupForCalculationDao.getFilteredGroupCalculationCount(searchValue);

    }

}
