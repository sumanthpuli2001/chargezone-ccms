/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.company;

import com.bul.zydex.dao.company.CompanyMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author OptiPlex
 */
public class CompanyMasterServiceImpl<T> extends GenericsServiceImpl<T> implements CompanyMasterService<T> {

    private CompanyMasterDAO<T> companyMasterDAO;

    public CompanyMasterDAO<T> getCompanyMasterDAO() {
        return companyMasterDAO;
    }

    public void setCompanyMasterDAO(CompanyMasterDAO<T> companyMasterDAO) {
        this.companyMasterDAO = companyMasterDAO;
        setGenericsDAO(companyMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
        return companyMasterDAO.isExist(object);
    }

}
