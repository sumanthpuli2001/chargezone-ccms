/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CtcAllowance;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class CtcAllowanceDAOImpl<T> extends GenericsDAOImpl<T> implements CtcAllowanceDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CtcAllowance.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        CtcAllowance policyMaster = (CtcAllowance) object;
        List list = getHibernateTemplate().find("from CtcAllowance where ctcName='" + policyMaster.getCtcName() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readsalSearch() {
        String query = "";
        query += " select a.id,a.ctcName"
                + " FROM CtcAllowance a ";

        return getHibernateTemplate().find(query);
    }

}
