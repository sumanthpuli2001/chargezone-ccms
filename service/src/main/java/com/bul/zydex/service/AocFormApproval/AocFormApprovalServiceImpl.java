/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormApproval;

import com.bul.zydex.dao.AocFormApproval.AocFormApprovalDao;
import com.bul.zydex.model.AocFormApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocFormApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements AocFormApprovalService<T> {

    private AocFormApprovalDao<T> aocFormApprovalDao;

    public AocFormApprovalDao<T> getAocFormApprovalDao() {
        return aocFormApprovalDao;
    }

    public void setAocFormApprovalDao(AocFormApprovalDao<T> aocFormApprovalDao) {
        this.aocFormApprovalDao = aocFormApprovalDao;
        setGenericsDAO(aocFormApprovalDao);
    }

    @Override
    public List approvalList(String username) {

        return aocFormApprovalDao.approvaList(username);

    }

    @Override
    public List readByIds(String id) {
        return aocFormApprovalDao.readByIds(id);

    }

    @Override
    public AocFormApproval readByDeltecodes(String id) {

        return aocFormApprovalDao.readByDeltecodes(id);
    }

    @Override
    public List getAocApprovalPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return aocFormApprovalDao.getAocApprovalPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalAocApprovalCount(String username) {
        return aocFormApprovalDao.getTotalAocApprovalCount(username);
    }

    @Override
    public int getFilteredAocApprovalCount(String username, String searchValue) {
        return aocFormApprovalDao.getFilteredAocApprovalCount(username, searchValue);
    }

}
