/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.BpGroup;

import com.bul.zydex.dao.BpGroup.BpGroupDao;
import com.bul.zydex.model.BpGroup;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class BpGroupServiceImpl<T> extends GenericsServiceImpl<T> implements BpGroupService<T> {

    private BpGroupDao<T> bpGroupDao;

    public BpGroupDao<T> getBpGroupDao() {
        return bpGroupDao;
    }

    public void setBpGroupDao(BpGroupDao<T> bpGroupDao) {
        this.bpGroupDao = bpGroupDao;
        setGenericsDAO(bpGroupDao);
    }

    @Override
    public BpGroup readByBpCode(String extractedBpGroup) {
        return bpGroupDao.readByBpCode(extractedBpGroup);
    }

    @Override
    public List getbpGroupPagination(int start, int length, String search, String orderColumn, String orderDir) {
        return bpGroupDao.getbpGroupPagination(start, length, search, orderColumn, orderDir);

    }

    @Override
    public int getTotalbpGroupCount() {

        return bpGroupDao.getTotalbpGroupCount();

    }

    @Override
    public int getFilteredbpGroupCount(String searchValue) {
        return bpGroupDao.getFilteredbpGroupCount(searchValue);
    }

}
