/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.EhMail;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EhMail;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class EhMailDaoImpl<T> extends GenericsDAOImpl<T> implements EhMailDao<T> {

    @Override
    protected Class getDomainClass() {
        return EhMail.class;

    }

    @Override
    public List getEhMailPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        try {
            if (orderColumn == null || orderColumn.trim().isEmpty()) {
                orderColumn = "a.id";
            }
            if (orderDir == null || orderDir.trim().isEmpty()) {
                orderDir = "asc";
            }
            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "asc";
            }

            String hql = "SELECT a.id, a.username, a.email "
                    + "FROM EhMail a "
                    + "WHERE 1 = 1 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                // ← Fix: was missing space + OR instead of AND for search
                hql += "AND ("
                        + "  lower(a.username) LIKE :search "
                        + "OR lower(a.email)   LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY " + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        } finally {
            session.close();
        }

    }

    @Override
    public int getTotalEhMailCount() {
        Session session = getSessionFactory().openSession();
        try {
            Long count = (Long) session.createQuery(
                    "SELECT COUNT(a.id) FROM EhMail a WHERE 1=1"
            ).uniqueResult();
            return count != null ? count.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close(); // ← Fix: added try/catch + finally for safe close
        }

    }

    @Override
    public int getEhMailPagination(String searchValue) {
        Session session = getSessionFactory().openSession();
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM EhMail a "
                    + "WHERE 1 = 1 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.username) LIKE :search "
                        + "OR lower(a.email)   LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            Long count = (Long) query.uniqueResult();
            return count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

}
