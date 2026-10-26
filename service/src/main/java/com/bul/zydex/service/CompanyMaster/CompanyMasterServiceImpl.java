/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CompanyMaster;

import com.bul.zydex.dao.CompanyMaster.CompanyMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class CompanyMasterServiceImpl<T> extends GenericsServiceImpl<T> implements CompanyMasterService<T> {

    private CompanyMasterDao<T> companyMasterDao;

    public CompanyMasterDao<T> getCompanyMasterDao() {
        return companyMasterDao;
    }

    public void setCompanyMasterDao(CompanyMasterDao<T> companyMasterDao) {
        this.companyMasterDao = companyMasterDao;
        setGenericsDAO(companyMasterDao);

    }

    @Override
    public List getCompanyMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return companyMasterDao.getCompanyMasterPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalMasterCount() {
        return companyMasterDao.getTotalMasterCount();
    }

    @Override
    public int getFilteredMasterCount(String search) {
        return companyMasterDao.getFilteredMasterCount(search);
    }

}
