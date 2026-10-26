/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CanopyVarient;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CanopyVarient;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class CanopyVarientDaoImpl<T> extends GenericsDAOImpl<T> implements CanopyVarientDao<T> {

    @Override
    protected Class getDomainClass() {
        return CanopyVarient.class;
    }

    @Override
    public int getTotalCanopyCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from CanopyVarient a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();
    }

    @Override
    public int getFilteredCanopyCount(String search) {
 Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(*) "
                    + "from CanopyVarient a "
                    + "where 1 = 1";

            if (search != null && !search.trim().isEmpty()) {
                hql += " and lower(a.name) like :search";
            }

            Query query = session.createQuery(hql);
            if (search != null && !search.trim().isEmpty()) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
    public List getCanopyPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
 Session session = getSessionFactory().openSession();
        try {
            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "name";
            }
            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "asc";
            }

            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "asc";
            }

            String hql = "from CanopyVarient a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and lower(a.name)"
                        + " like :search";
            }

            hql += " order by a."
                    + orderColumn
                    + " "
                    + orderDir;

            System.out.println("HQL : " + hql);
            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
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
        }    }

}
