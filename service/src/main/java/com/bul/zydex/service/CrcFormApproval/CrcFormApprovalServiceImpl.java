/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CrcFormApproval;

import com.bul.zydex.dao.CrcFormApproval.CrcFormApprovalDao;
import com.bul.zydex.model.CrcFormApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class CrcFormApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements CrcFormApprovalService<T> {

    private CrcFormApprovalDao<T> crcFormApprovalDao;

    public CrcFormApprovalDao<T> getCrcFormApprovalDao() {
	return crcFormApprovalDao;
    }

    public void setCrcFormApprovalDao(CrcFormApprovalDao<T> crcFormApprovalDao) {
	this.crcFormApprovalDao = crcFormApprovalDao;
	setGenericsDAO(crcFormApprovalDao);

    }

    @Override
    public List approvaList(String username) {
	
	return crcFormApprovalDao.approvaList(username);
	
    }

    @Override
    public List readids(String id) {
	return crcFormApprovalDao.readids(id);
    }

    @Override
    public CrcFormApproval readByDeltecodes(String id) {
	return crcFormApprovalDao.readByDeltecodes(id);
	
    }

    @Override
    public CrcFormApproval readBycrcid(String id) {
	return crcFormApprovalDao.readBycrcid(id);
	
	
    }

    @Override
    public CrcFormApproval readBycrcFormid(int crcFormid) {
	return crcFormApprovalDao.readBycrcFormid(crcFormid);
    }

    @Override
    public CrcFormApproval readBycrcids(int id1) {
	return crcFormApprovalDao.readBycrcids(id1);
    }

    @Override
    public List getCrcApprovaListPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return crcFormApprovalDao.getCrcApprovaListPagination(start, length, searchValue, username, orderColumn, orderDir);

    
    }

    @Override
    public int getTotalCrcApprovaListCount(String username) {
	return crcFormApprovalDao.getTotalCrcApprovaListCount(username);
    }

    @Override
    public int getFilteredCrcApprovaListCount(String username, String searchValue) {
	return crcFormApprovalDao.getFilteredCrcApprovaListCount(username,searchValue);
    }

}
