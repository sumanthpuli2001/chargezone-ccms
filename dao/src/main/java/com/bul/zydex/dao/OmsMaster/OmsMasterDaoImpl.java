/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OmsMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OmsMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author bulwarks-2
 */
public class OmsMasterDaoImpl<T> extends GenericsDAOImpl<T> implements OmsMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return OmsMaster.class;
    }

    @Override
    public OmsMaster readByTickitNoAndPrId(String tickitId, String omsPrId) {
        String hql = "FROM OmsMaster a WHERE a.ticketId = :ticketId and a.omsPrId = :omsPrId";

        List<?> list = getHibernateTemplate().execute(session -> session
                .createQuery(hql)
                .setParameter("ticketId", tickitId)
                .setParameter("omsPrId", omsPrId)
                .setMaxResults(1)
                .list());

        return list.isEmpty() ? null : (OmsMaster) list.get(0);
    }

    @Override
    public OmsMaster readByTickitNo(String tickitId) {
        String hql = "FROM OmsMaster a WHERE a.ticketId = :ticketId";

        List<?> list = getHibernateTemplate().execute(session -> session
                .createQuery(hql)
                .setParameter("ticketId", tickitId)
                .setMaxResults(1)
                .list());

        return list.isEmpty() ? null : (OmsMaster) list.get(0);
    }

    @Override
    public OmsMaster readByPrNo(String prNo, int omsPrFlag) {
        String hql = "FROM OmsMaster a WHERE a.prNumber = :prNumber";
        if (omsPrFlag != 0) {
            hql += " AND a.prFlag =:prFlag ";
        }
        Query query = getSession().createQuery(hql);
        if (omsPrFlag != 0) {
            query.setParameter("prFlag", omsPrFlag);
        }
        query.setParameter("prNumber", prNo);
        query.setMaxResults(1);
        OmsMaster omsMaster = (OmsMaster) query.uniqueResult();
        return omsMaster;
    }

}
