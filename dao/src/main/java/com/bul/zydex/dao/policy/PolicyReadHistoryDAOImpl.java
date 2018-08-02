/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PolicyReadHistory;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class PolicyReadHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements PolicyReadHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PolicyReadHistory.class;
    }

    @Override
    public PolicyReadHistory readByPolicyId(int id) {

        PolicyReadHistory policyReadHistory = new PolicyReadHistory();

        String query = " SELECT a"
                + " FROM PolicyReadHistory a "
                + " WHERE a.policyCreate.id = " + id;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            policyReadHistory = (PolicyReadHistory) list.get(0);
        } else {
            policyReadHistory = null;
        }
        return policyReadHistory;
    }

    @Override
    public List<?> readPolicyId(int id) {
        String query = "";
        query += "select a.id,a.readerDate,a.readerBy,a.policyAcept,a.policyAceptTime,b.name,b.attachment,b.createdDate,b.createdBy "
                + " FROM PolicyReadHistory a "
                + " LEFT JOIN a.policyCreate b "
                + " WHERE a.policyCreate.id = " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public PolicyReadHistory policyReadCheck(int policyId, String readerName) {

        PolicyReadHistory policyReadHistory = new PolicyReadHistory();

        String query = " SELECT a"
                + " FROM PolicyReadHistory a "
                + " WHERE a.policyCreate.id = " + policyId
                + " AND a.readerBy = " + readerName;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            policyReadHistory = (PolicyReadHistory) list.get(0);
        } else {
            policyReadHistory = null;
        }
        return policyReadHistory;
    }

}
