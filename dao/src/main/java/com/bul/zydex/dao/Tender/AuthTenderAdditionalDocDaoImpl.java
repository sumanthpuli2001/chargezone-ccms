/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuthTenderAdditionalDoc;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuthTenderAdditionalDocDaoImpl<T> extends GenericsDAOImpl<T> implements AuthTenderAdditionalDocDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuthTenderAdditionalDoc.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM AuthTenderAdditionalDoc a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from AuthTenderAdditionalDoc a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByDoc(String refNo, String tenderAdditionalDocument) {
        String query = "";
        query += " FROM AuthTenderAdditionalDoc a"
                + " WHERE a.refNo = '" + refNo + "' and a.document = '"+tenderAdditionalDocument+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteDoc(String docid) {
        String query = "";
            query += " delete from AuthTenderAdditionalDoc a"
                + " WHERE a.document = '" + docid + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
