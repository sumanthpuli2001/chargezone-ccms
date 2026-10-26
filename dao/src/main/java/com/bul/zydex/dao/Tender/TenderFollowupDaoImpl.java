/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderFollowup;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class TenderFollowupDaoImpl<T> extends GenericsDAOImpl<T> implements TenderFollowupDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderFollowup.class;
    }

    @Override
    public List readByTender(String tender_no) {
        String query = "";
        query += " FROM TenderFollowup a"
                + " WHERE a.tenderNo='"+tender_no+"'";
                
        return getHibernateTemplate().find(query);
    }
}
