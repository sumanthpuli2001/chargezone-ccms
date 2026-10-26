/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ConnectorType;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ChargerMaster;
import com.bul.zydex.model.ConnectorType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class ConnectorTypeDaoImpl<T> extends GenericsDAOImpl<T> implements ConnectorTypeDao<T> {

    @Override
    protected Class getDomainClass() {
        return ConnectorType.class;
    }

    @Override
    public List getConnectorTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();

        try {

            String hql = "from ConnectorType a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and lower(a.connectorType)"
                        + " like :searchValue";
            }

            hql += " order by a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            List list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        } finally {
            session.close();
        }
    }

    @Override
    public int getTotalConnectorTypeCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from ConnectorType a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();
    }

    @Override
    public int getFilteredConnectorTypeCount(String searchValue) {
        Session session = getSessionFactory().openSession();

        try {
            String hql = "select count(a.id) "
                    + "from ConnectorType a "
                    + "where 1 = 1";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " and lower(a.connectorType) like :searchValue";
            }

            Query query = session.createQuery(hql);
            
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            return count.intValue();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }
}
