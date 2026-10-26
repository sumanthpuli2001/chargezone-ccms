/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CrcFormApprovalUser;

import com.bul.zydex.dao.CrcFormApprovalUser.CrcFormApprovalUserDao;
import com.bul.zydex.model.CrcFormApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class CrcFormApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements CrcFormApprovalUserService<T> {

    private CrcFormApprovalUserDao<T> crcFormApprovalUserDao;

    public CrcFormApprovalUserDao<T> getCrcFormApprovalUserDao() {
	return crcFormApprovalUserDao;
    }

    public void setCrcFormApprovalUserDao(CrcFormApprovalUserDao<T> crcFormApprovalUserDao) {
	this.crcFormApprovalUserDao = crcFormApprovalUserDao;
	setGenericsDAO(crcFormApprovalUserDao);

    }

    @Override
    public CrcFormApprovalUser appvals(String username,String crcFormid) {
	
	return crcFormApprovalUserDao.appvals(username,crcFormid);
    }

    @Override
    public List readByDleteCode(int formid) {
	return crcFormApprovalUserDao.readByDleteCode(formid);
    }

    @Override
    public List readByApprovalStatus(String id) {
	return crcFormApprovalUserDao.readByApprovalStatus(id);
    }

    @Override
    public List readByApprovalStatuszero(int crcFormid) {
        return crcFormApprovalUserDao.readByApprovalStatuszero(crcFormid);
    }

    @Override
    public List readyByCrcId(int crcid) {
        
          return crcFormApprovalUserDao.readyByCrcId(crcid);
    }

}
