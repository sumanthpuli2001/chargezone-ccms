/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectManagement;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.StateMaster;
import java.util.List;

/**
 *
 * @author Aman
 */
public class StateMasterDAOImpl<T> extends GenericsDAOImpl<T> implements StateMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return StateMaster.class;
    }

    @Override
    public List<?> readStateMaster() {
        String query = "";
        query += " Select a.id,a.name "
                + " FROM StateMaster a";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
