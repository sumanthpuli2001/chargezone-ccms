/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapFormHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapFormHistory;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OapFormHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements OapFormHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return OapFormHistory.class;
    }

    @Override
    public List readBylasttimestatus(int id1) {
        String query = "";
        query += " FROM OapFormHistory a"
                + " WHERE a.oapId = '" + id1 + "'";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByoapid(String id) {
        String query = "";
        query += " FROM OapFormHistory a"
                + " WHERE a.oapId = '" + id + "'";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readBydocumentno(String documentNo) {

       
    String query = "";
    query += " FROM OapFormHistory a"
            + " WHERE a.documentNo = '" + documentNo + "'"
            + " ORDER BY CAST(SUBSTRING(a.documentRevisionNo, 2) AS int) DESC";

    List list = getHibernateTemplate().find(query);

    return (list != null && !list.isEmpty()) ? Arrays.asList(list.get(0)) : list;
    }

}
