/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormApprovalUser;

import com.bul.zydex.dao.AocFormApprovalUser.AocFormApprovalUserDao;
import com.bul.zydex.model.AocFormApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocFormApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements AocFormApprovalUserService<T> {

    private AocFormApprovalUserDao<T> aocFormApprovalUserDao;

    public AocFormApprovalUserDao<T> getAocFormApprovalUserDao() {
        return aocFormApprovalUserDao;
    }

    public void setAocFormApprovalUserDao(AocFormApprovalUserDao<T> aocFormApprovalUserDao) {
        this.aocFormApprovalUserDao = aocFormApprovalUserDao;
        setGenericsDAO(aocFormApprovalUserDao);
    }

    @Override
    public AocFormApprovalUser appval(String username) {

        return aocFormApprovalUserDao.appval(username);
    }

    @Override
    public AocFormApprovalUser readLevel(String level, int aocFormid) {
        return aocFormApprovalUserDao.readLevel(level, aocFormid);

    }

    @Override
    public List readByDleteCode(int formid) {
        return aocFormApprovalUserDao.readByDleteCode(formid);

    }

    @Override
    public List readByApprovalStatus(String id) {
        return aocFormApprovalUserDao.readByApprovalStatus(id);
    }

    @Override
    public AocFormApprovalUser appvals(String username, String id) {
        return aocFormApprovalUserDao.appvals(username, id);

    }

    @Override
    public List readByaocId(String id) {
        return aocFormApprovalUserDao.readByaocId(id);
    }

    @Override
    public List readByaocId(int aocformid) {
         return aocFormApprovalUserDao.readByaocId(aocformid);
    }

    @Override
    public AocFormApprovalUser readByIdAndUsername(String id, String username) {
        return aocFormApprovalUserDao.readByIdAndUsername(id, username);

    
    
    }

  
}
