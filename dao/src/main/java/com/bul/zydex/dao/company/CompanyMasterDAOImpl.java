/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.company;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Company;
import java.util.List;

/**
 *
 * @author OptiPlex
 */
public class CompanyMasterDAOImpl<T> extends GenericsDAOImpl<T> implements CompanyMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return Company.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        Company companyMaster = (Company) object;
        List list = getHibernateTemplate().find("from Company where companyName='" + companyMaster.getCompanyName() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

}
