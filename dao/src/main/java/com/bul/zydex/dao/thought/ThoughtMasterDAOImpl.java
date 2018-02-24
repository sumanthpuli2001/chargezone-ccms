/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.thought;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ThoughtMaster;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class ThoughtMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ThoughtMasterDAO<T>  {

    @Override
    protected Class getDomainClass() {
        return ThoughtMaster.class;
    }

     @Override
    public List<?> readthoughtmasterDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.thought, a.date"
                + " FROM ThoughtMaster a ";
               
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
