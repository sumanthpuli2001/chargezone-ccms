/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffFormApproval;

import com.bul.zydex.dao.KickOffFormApproval.KickOffFormApprovalDao;
import com.bul.zydex.model.KickOffFormApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class KickOffFormApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements KickOffFormApprovalService<T> {

    private KickOffFormApprovalDao<T> kickOffFormApprovalDao;

    public KickOffFormApprovalDao<T> getKickOffFormApprovalDao() {
        return kickOffFormApprovalDao;
    }

    public void setKickOffFormApprovalDao(KickOffFormApprovalDao<T> kickOffFormApprovalDao) {
        this.kickOffFormApprovalDao = kickOffFormApprovalDao;
        setGenericsDAO(kickOffFormApprovalDao);

    }

    @Override
    public List approvaList(String username) {
        return kickOffFormApprovalDao.approvaList(username);
    }

    @Override
    public List readids(String id) {

        return kickOffFormApprovalDao.readids(id);

    }

    @Override
    public KickOffFormApproval readBykickapprid(String id) {
        return kickOffFormApprovalDao.readBykickapprid(id);
    }

    @Override
    public KickOffFormApproval readByDeltecodes(String id) {
        return kickOffFormApprovalDao.readByDeltecodes(id);
    }

    @Override
    public KickOffFormApproval readBykickid(int id1) {
        return kickOffFormApprovalDao.readBykickid(id1);
    }

    @Override
    public List getKomApprovalUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return kickOffFormApprovalDao.getKomApprovalUserPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalKomApprovalUserCount(String username) {
        return kickOffFormApprovalDao.getTotalKomApprovalUserCount(username);
    }

    @Override
    public int getFilteredKomApprovalUserCount(String username, String searchValue) {
        return kickOffFormApprovalDao.getFilteredKomApprovalUserCount(username,searchValue);
    }

}
