/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectManagement;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PriorityMaster;
import java.util.List;

/**
 *
 * @author Aman
 */
public class PriorityMasterDAOImpl<T> extends GenericsDAOImpl<T> implements PriorityMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PriorityMaster.class;
    }

    @Override
    public List<?> readPriorityMaster() {
        String query = "";
        query += " Select a.id, a.name "
                + " FROM PriorityMaster a ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> deletePrioretyMaster(String prioretyId) {
        String query = " Select a"
                + " FROM PriorityMaster a "
                + " Where a.id = " + prioretyId;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
