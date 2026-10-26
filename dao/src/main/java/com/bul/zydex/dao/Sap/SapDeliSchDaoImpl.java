/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SapDeliSch;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class SapDeliSchDaoImpl<T> extends GenericsDAOImpl<T> implements SapDeliSchDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return SapDeliSch.class;
    }

    @Override
    public List readData(String refNo, String pur_no, String item_no) {
        String query = "";
        query += " FROM SapDeliSch a"
                + " WHERE a.rfqNo = '" + pur_no + "' and a.itemNumber = '"+ item_no +"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String item_code) {
        String query = "";
            query += " delete from SapDeliSch a"
                + " WHERE a.materialNumber = '" + item_code + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
}
