/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapFormApprovalUser;

import com.bul.zydex.dao.OapFormApprovalUser.OapFormApprovalUserDao;
import com.bul.zydex.model.OapFormApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapFormApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements OapFormApprovalUserService<T> {

    private OapFormApprovalUserDao<T> oapFormApprovalUserDao;

    public OapFormApprovalUserDao<T> getOapFormApprovalUserDao() {
        return oapFormApprovalUserDao;
    }

    public void setOapFormApprovalUserDao(OapFormApprovalUserDao<T> oapFormApprovalUserDao) {
        this.oapFormApprovalUserDao = oapFormApprovalUserDao;
        setGenericsDAO(oapFormApprovalUserDao);
    }

    @Override
    public OapFormApprovalUser appval(String username) {

        return oapFormApprovalUserDao.appval(username);

    }

    @Override
    public OapFormApprovalUser readLevel(String level, int oapFormid) {
        return oapFormApprovalUserDao.readLevel(level, oapFormid);
    }

    @Override
    public List readByDleteCode(int formid) {
        return oapFormApprovalUserDao.readByDleteCode(formid);
    }

    @Override
    public List readByapprovalStatus(String id) {
        return oapFormApprovalUserDao.readByapprovalStatus(id);
    }

    @Override
    public OapFormApprovalUser appvals(String username, String id) {
        return oapFormApprovalUserDao.appvals(username, id);
    }

    @Override
    public List readByoapid(int oapid) {
        return oapFormApprovalUserDao.readByoapid(oapid);
    }

    @Override
    public OapFormApprovalUser readByIdAndUsername(String id, String username) {
        return oapFormApprovalUserDao.readByIdAndUsername(username, id);
    }

}
