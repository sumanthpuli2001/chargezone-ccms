/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuthTenderTechnicalDoc;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuthTenderTechnicalDocDaoImpl<T> extends GenericsDAOImpl<T> implements AuthTenderTechnicalDocDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuthTenderTechnicalDoc.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM AuthTenderTechnicalDoc a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from AuthTenderTechnicalDoc a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByDoc(String refNo, String tenderTechnicalDocument1) {
        String query = "";
        query += " FROM AuthTenderTechnicalDoc a"
                + " WHERE a.refNo = '" + refNo + "' and a.document = '"+tenderTechnicalDocument1+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteDoc(String docid) {
        String query = "";
            query += " delete from AuthTenderTechnicalDoc a"
                + " WHERE a.document = '" + docid + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
