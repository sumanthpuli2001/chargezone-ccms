/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PolicyCreate;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class PolicyCreateDAOImpl<T> extends GenericsDAOImpl<T> implements PolicyCreateDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PolicyCreate.class;
    }

    @Override
    public List<?> readpolicyCreate() {
        String query = "";
        query += " "
                + " SELECT a.id, a.name, a.attachment, a.status, b.name"
                + " FROM PolicyCreate a "
                + " LEFT JOIN a.policyDropDown b "
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> deletepolicy(String id) {
        String query = "";
        query += " "
                + " SELECT a"
                + " FROM PolicyReadHistory a "
                + " WHERE a.policyCreate.id= " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }
}
