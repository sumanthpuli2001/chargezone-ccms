/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Employee;

import com.bul.zydex.dao.Employee.CompanyLocationDao;
import com.bul.zydex.model.CompanyLocation;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeString.search;
/**
 *
 * @author Bulwark-5
 */
public class CompanyLocationServiceImpl<T> extends GenericsServiceImpl<T> implements CompanyLocationService<T> {
    
    private CompanyLocationDao<T> companyLocationDao;

    public CompanyLocationDao<T> getCompanyLocationDao() {
        return companyLocationDao;
    }

    public void setCompanyLocationDao(CompanyLocationDao<T> companyLocationDao) {
        this.companyLocationDao = companyLocationDao;
        setGenericsDAO(companyLocationDao);
    }

    @Override
    public List getCompanyLocationPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return companyLocationDao.getCompanyLocationPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalCompanyLocationCount() {
        return companyLocationDao.getTotalCompanyLocationCount();
    }

    @Override
    public int getFilteredCompanyLocationCount(String search) {
        return companyLocationDao.getFilteredCompanyLocationCount(search);
    }
}
