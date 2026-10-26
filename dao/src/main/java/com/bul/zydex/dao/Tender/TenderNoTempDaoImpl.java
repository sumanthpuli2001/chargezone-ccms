/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderNoTemp;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderNoTempDaoImpl<T> extends GenericsDAOImpl<T> implements TenderNoTempDao<T> {

    @Override
    protected Class getDomainClass() {
        return TenderNoTemp.class;
    }

    @Override
    public TenderNoTemp readLastRecord() {
        String hql = "FROM TenderNoTemp a ORDER BY a.id DESC";

        return (TenderNoTemp) getHibernateTemplate().execute(session
                -> session.createQuery(hql)
                .setMaxResults(1)
                .uniqueResult()
        );
    }

}
