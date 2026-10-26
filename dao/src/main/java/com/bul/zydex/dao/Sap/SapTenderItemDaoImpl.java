/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SapTenderItem;
import com.bul.zydex.model.SapDeliSch;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class SapTenderItemDaoImpl<T> extends GenericsDAOImpl<T> implements SapTenderItemDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return SapTenderItemDao.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " select a.itemCode, a.itemDesc, a.uom, a.qty, a.location, a.purNo, a.itemNo , a.srNo, a.deliSch FROM SapTenderItem a "
                + " WHERE a.tenderNo like '%" + refNo + "' order by a.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readRefNo(String refNo) {
        String query = "";
        query += " FROM SapTenderItem a "
                + " WHERE a.tenderNo like '%" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from SapTenderItem a"
                + " WHERE a.tenderNo like '%" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public SapTenderItem readId(int id) {
        SapTenderItem sapTenderItem = new SapTenderItem();
        String query = "";
        query += " FROM SapTenderItem a"
                + " WHERE a.id = " + id + "";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            sapTenderItem = (SapTenderItem) list.get(0);
        }
        return sapTenderItem;
    }
}
