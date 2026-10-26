/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRNoTemp;
import com.bul.zydex.model.TenderNo;
import com.bul.zydex.model.TenderNoTemp;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class PRNoTempDaoImpl<T> extends GenericsDAOImpl<T> implements PRNoTempDao<T> {

    @Override
    protected Class getDomainClass() {
        return PRNoTemp.class;
    }

    @Override
    public PRNoTemp readLastRecord() {

        String hql = "FROM PRNoTemp a ORDER BY a.id DESC";

        return (PRNoTemp) getHibernateTemplate().execute(session
                -> session.createQuery(hql)
                .setMaxResults(1)
                .uniqueResult()
        );

    }

    @Override
    public PRNoTemp readByPRNo() {

        String hql = "FROM PRNoTemp a ORDER BY a.prNo DESC";

        PRNoTemp prNoTemp = (PRNoTemp) getHibernateTemplate().execute(session
                -> session.createQuery(hql)
                .setMaxResults(1)
                .uniqueResult()
        );

        return prNoTemp;
    }

}
