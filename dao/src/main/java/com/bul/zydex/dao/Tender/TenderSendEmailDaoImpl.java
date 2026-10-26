/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderSendEmail;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderSendEmailDaoImpl<T> extends GenericsDAOImpl<T> implements TenderSendEmailDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderSendEmail.class;
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
        query += " delete from TenderSendEmail a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM TenderSendEmail a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }
}
