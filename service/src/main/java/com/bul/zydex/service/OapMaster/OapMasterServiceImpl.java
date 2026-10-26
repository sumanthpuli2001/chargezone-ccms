/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapMaster;

import com.bul.zydex.dao.OapMaster.OapMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapMasterServiceImpl<T> extends GenericsServiceImpl<T> implements OapMasterService<T> {
    
    private OapMasterDao<T> oapMasterDao;

    public OapMasterDao<T> getOapMasterDao() {
	return oapMasterDao;
    }

    public void setOapMasterDao(OapMasterDao<T> oapMasterDao) {
	this.oapMasterDao = oapMasterDao;
	 setGenericsDAO(oapMasterDao);
    }

    @Override
    public List getApprovalNamePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return oapMasterDao.getApprovalNamePagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalApprovalNameCount() {
        return oapMasterDao.getTotalApprovalNameCount();
    }

    @Override
    public int getFilteredApprovalNameCount(String search) {
        return oapMasterDao.getFilteredApprovalNameCount(search);
    }
    
    
}
