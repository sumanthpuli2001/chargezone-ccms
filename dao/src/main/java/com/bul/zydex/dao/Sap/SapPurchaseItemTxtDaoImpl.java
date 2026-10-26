/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SapPurchaseItemTxt;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class SapPurchaseItemTxtDaoImpl<T> extends GenericsDAOImpl<T> implements SapPurchaseItemTxtDao<T> {

    @Override
    protected Class getDomainClass() {
        return SapPurchaseItemTxt.class;
    }

    @Override
    public List readByRefNo(String refNo, String pur_no, String item_no) {
        String query = "";
        query += " FROM SapPurchaseItemTxt a"
                + " WHERE a.purNo = '" + pur_no + "' and a.itemNo = '"+ item_no +"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String pur_no, String item_no) {
        String query = "";
            query += " delete from SapPurchaseItemTxt a"
                + " WHERE a.purNo = '" + pur_no + "' and a.itemNo = '" + item_no + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}

