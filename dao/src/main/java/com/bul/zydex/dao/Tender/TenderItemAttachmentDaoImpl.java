/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderItemAttachment;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderItemAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements TenderItemAttachmentDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderItemAttachment.class;
    }

    @Override
    public List readByRefNo(String refNo, String pur_no, String item_no) {
        String query = "";
        query += " FROM TenderItemAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and a.purNo = '"+pur_no+"' and a.itemNo = "+item_no+"";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDocRefNo(String refNo, String pur_no, String item_no, String attachment) {
        String query = "";
        query += " FROM TenderItemAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and a.purNo = '"+pur_no+"' and a.itemNo = '"+item_no+"' and a.attachment = '"+attachment+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteByRefNo(String refNo, String pur_no, String item_no) {
        String query = "";
            query += " delete from TenderItemAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and a.purNo = '"+pur_no+"' and a.itemNo = '"+item_no+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readByRefNo1(String refNo) {
        String query = "";
        query += " FROM TenderItemAttachment a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }
}
