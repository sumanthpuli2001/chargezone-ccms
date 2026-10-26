/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SapItemLongTxt;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class SapItemLongTxtDaoImpl<T> extends GenericsDAOImpl<T> implements SapItemLongTxtDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return SapItemLongTxt.class;
    }

    @Override
    public List readByRefNo(String refNo, String pur_no, String item_no) {
        String query = "";
        query += " FROM SapItemLongTxt a"
                + " WHERE a.PNumber = '" + pur_no + "' and a.INumber = '"+ item_no +"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readTxt(String refNo, String pur_no) {
        String query = "";
        query += " FROM SapItemLongTxt a"
                + " WHERE a.PNumber = '" + pur_no + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String item_code, String pur_no, String item_no) {
        String query = "";
            query += " delete from SapItemLongTxt a"
                + " WHERE a.number = '" + item_code + "' and a.PNumber = '" + pur_no + "' and a.INumber = '" + item_no + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
}
