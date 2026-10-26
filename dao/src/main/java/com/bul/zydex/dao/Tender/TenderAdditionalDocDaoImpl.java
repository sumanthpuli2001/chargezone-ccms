/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderAdditionalDoc;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderAdditionalDocDaoImpl<T> extends GenericsDAOImpl<T> implements TenderAdditionalDocDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderAdditionalDoc.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM TenderAdditionalDoc a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from TenderAdditionalDoc a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readByDoc(String refNo, String additionalfile) {
        String query = "";
        query += " FROM TenderAdditionalDoc a"
                + " WHERE a.refNo = '" + refNo + "' and a.document = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        String query = "";
            query += " update TenderAdditionalDoc a"
                + " set a.refNo = '"+refNo+"'"
                + " WHERE a.refNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
