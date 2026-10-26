/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ValuationClassMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ValuationClassMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bulwarks-2
 */
public class ValuationClassMasterDaoImpl<T> extends GenericsDAOImpl<T> implements ValuationClassMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return ValuationClassMaster.class;
    }

    @Override
    public List getValPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        try {

            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "valuationClass";
            }

            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "desc";
            }

            if (!orderDir.equalsIgnoreCase("asc")
                    && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "desc";
            }

            String hql = "from ValuationClassMaster a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and ("
                        + "lower(a.valuationClass) like :search "
                        + "or str(a.description) like :search"
                        + ")";
            }

            hql += " order by a." + orderColumn + " " + orderDir;

            System.out.println("HQL : " + hql);

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search",
                        "%" + searchValue.toLowerCase() + "%");
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
    public int getFilteredValCount(String search) {
        Session session = getSessionFactory().openSession();

        try {
            String hql = "select count(*) "
                    + "from ValuationClassMaster a "
                    + "where 1 = 1";

            if (search != null && !search.trim().isEmpty()) {
                hql += " and ("
                        + "lower(a.valuationClass) like :search "
                        + "or str(a.description) like :search"
                        + ")";
            }

            Query query = session.createQuery(hql);
            if (search != null && !search.trim().isEmpty()) {
                query.setParameter(
                        "search",
                        "%" + search.toLowerCase() + "%"
                );
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

    @Override
    public int getTotalValCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from ValuationClassMaster a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();
    }
}
