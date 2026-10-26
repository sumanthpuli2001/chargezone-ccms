/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRDoc;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;


/**
 *
 * @author Bulwark-5
 */
public class PRDocDaoImpl<T> extends GenericsDAOImpl<T> implements PRDocDao<T> {
 
    @Override
    protected Class getDomainClass() {
        return PRDoc.class;
    }

    @Override
    public List readByRefNo(String ref_no) {
        String query = "";
        query += " FROM PRDoc a"
                + " WHERE a.prNo = '" + ref_no + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updatePRNo(String refNo1, String refNo) {
        String query = "";
            query += " update PRDoc a"
                + " set a.prNo = '"+refNo+"'"
                + " WHERE a.prNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
