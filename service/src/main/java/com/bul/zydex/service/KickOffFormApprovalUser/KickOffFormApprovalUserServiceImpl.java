/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffFormApprovalUser;

import com.bul.zydex.dao.KickOffFormApprovalUser.KickOffFormApprovalUserDao;
import com.bul.zydex.model.KickOffFormApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class KickOffFormApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements KickOffFormApprovalUserService<T> {

    private KickOffFormApprovalUserDao<T> kickOffFormApprovalUserDao;

    public KickOffFormApprovalUserDao<T> getKickOffFormApprovalUserDao() {
	return kickOffFormApprovalUserDao;
    }

    public void setKickOffFormApprovalUserDao(KickOffFormApprovalUserDao<T> kickOffFormApprovalUserDao) {
	this.kickOffFormApprovalUserDao = kickOffFormApprovalUserDao;
	setGenericsDAO(kickOffFormApprovalUserDao);

    }

    @Override
    public KickOffFormApprovalUser appval(String username) {

	return kickOffFormApprovalUserDao.appval(username);

    }

    @Override
    public List readByDleteCode(int formid) {
	return kickOffFormApprovalUserDao.readByDleteCode(formid);
    }

    @Override
    public List readByApprovestatus(String id) {
	return kickOffFormApprovalUserDao.readByApprovestatus(id);

    }

    @Override
    public List readBykomid(int komid) {
        return kickOffFormApprovalUserDao.readBykomid(komid);
        
    }

    @Override
    public KickOffFormApprovalUser appvals(String username, int kickOffFormid) {
        return kickOffFormApprovalUserDao.appvals(username,kickOffFormid);
    }

}
