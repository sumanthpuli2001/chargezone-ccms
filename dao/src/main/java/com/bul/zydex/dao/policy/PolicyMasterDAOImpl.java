/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PolicyMaster;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class PolicyMasterDAOImpl<T> extends GenericsDAOImpl<T> implements PolicyMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PolicyMaster.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        PolicyMaster policyMaster = (PolicyMaster) object;
        List list = getHibernateTemplate().find("from PolicyMaster where policyName='" + policyMaster.getPolicyName() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readBySalaryTypeID(String salaryTpe) {
        String query = "";
        query += "Select a.id"
                + " FROM PolicyMaster a"
                + " WHERE a.policyName = '" + salaryTpe + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readPolicyName() {
        String query = "";
        query += " Select a.policyName "
                + " FROM PolicyMaster a ";
        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readPolicyNameSalarySearch() {
        String query = "";
        query += " Select a.policyName "
                + " FROM PolicyMaster a "
                + " order by a.id asc";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
