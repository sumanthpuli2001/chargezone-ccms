/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapFormApproval;

import com.bul.zydex.dao.OapFormApproval.OapFormApprovalDao;
import com.bul.zydex.model.OapFormApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapFormApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements OapFormApprovalService<T> {

    private OapFormApprovalDao<T> oapFormApprovalDao;

    public OapFormApprovalDao<T> getOapFormApprovalDao() {
        return oapFormApprovalDao;
    }

    public void setOapFormApprovalDao(OapFormApprovalDao<T> oapFormApprovalDao) {
        this.oapFormApprovalDao = oapFormApprovalDao;
        setGenericsDAO(oapFormApprovalDao);
    }

    @Override
    public List approvaList(String username) {
        return oapFormApprovalDao.approvaList(username);
    }

    @Override
    public List readByIds(String id) {
        return oapFormApprovalDao.readByIds(id);
    }

    @Override
    public List readByDeltecode(String id) {
        return oapFormApprovalDao.readByDeltecode(id);

    }

    @Override
    public OapFormApproval readByDeltecodes(String id) {
        return oapFormApprovalDao.readByDeltecodes(id);
    }

    @Override
    public OapFormApproval readByoapappid(String id) {
        return oapFormApprovalDao.readByoapappid(id);
    }

    @Override
    public OapFormApproval readByIdAndUsername(String id, String userName) {
        return oapFormApprovalDao.readByIdAndUsername(id, userName);
    }

    @Override
    public List getOapApprovaListPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return oapFormApprovalDao.getOapApprovaListPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalOapApprovaListCount(String username) {
        return oapFormApprovalDao.getTotalOapApprovaListCount(username);

    }

    @Override
    public int getFilteredOapApprovaListCount(String username, String searchValue) {

        return oapFormApprovalDao.getFilteredOapApprovaListCount(username, searchValue);

    }

}
