/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LiveTender;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class LiveTenderDaoImpl<T> extends GenericsDAOImpl<T> implements LiveTenderDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return LiveTender.class;
    }

    @Override
    public List readByTender(String tenderno) {
        String query = "";
        query += " FROM LiveTender a"
                + " WHERE a.tenderno = '" + tenderno + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readBySerch(String tender_no, String description) {
        String query = "";
        query += " FROM LiveTender a"
                + " WHERE a.tenderno like '%" + tender_no + "%' and a.description like '%"+description+"%'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateTender(String tenderno, String description, String technicalfile) {
        String query = "";
        query += " update LiveTender a"
                + " set a.description='"+description+"', "
                + " a.tenderdoc='"+technicalfile+"' "
                + " WHERE a.tenderno = '" + tenderno + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
