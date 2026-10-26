/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.TermsCondition;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TermsConditionParameter;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class TermsConditionParameterDaoImpl<T> extends GenericsDAOImpl<T> implements TermsConditionParameterDao<T> {

    @Override
    protected Class getDomainClass() {
        return TermsConditionParameter.class;
    }

    @Override
    public List readAll() {
        String query = "SELECT a.id,a.name,b.name, a.description";
        query += " "
                + " FROM TermsConditionParameter a"
                + " left join a.termsCondition b";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByIds(int id) {
        String query = "SELECT a.id,a.name,b.name, a.description";
        query += " "
                + " FROM TermsConditionParameter a"
                + " left join a.termsCondition b"
                + " where a.id=" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readAllTerms(int termsParameterId) {
        String query = "SELECT a.id,a.name,b.name, a.description";
        query += " "
                + " FROM TermsConditionParameter a"
                + " left join a.termsCondition b"
                + " where a.termsCondition=" + termsParameterId;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List getTermsConditionParameterPagination(int start, int length, String search, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        try {
            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "id";
            }
            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "desc";
            }

            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "desc";
            }

            String hql = " select a.id, b.name, a.name, a.description "
                    + "from TermsConditionParameter a, TermsCondition b "
                    + " where b.id = a.termsCondition ";

            if (search != null && !search.trim().equals("")) {
                hql += " AND ("
                        + " lower(b.name) LIKE :search "
                        + " OR lower(a.name) LIKE :search "
                        + " OR lower(a.description) LIKE :search "
                        + ")";
            }

            hql += " order by "
                    + orderColumn
                    + " "
                    + orderDir;

            System.out.println("HQL : " + hql);
            Query query = session.createQuery(hql);

            if (search != null && !search.trim().equals("")) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
    public int getTermsConditionParameterCount() {
        Session session = getSessionFactory().openSession();
        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from TermsConditionParameter a "
                + "where 1=1"
        ).uniqueResult();

        session.close();
        return count.intValue();
    }

    @Override
    public int getFilteredTermsConditionParameterCount(String search) {
        Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(a.id) "
                    + "from TermsConditionParameter a, TermsCondition b "
                    + " where b.id = a.termsCondition ";

            if (search != null && !search.trim().isEmpty()) {
                hql += " AND ("
                        + " lower(b.name) LIKE :search "
                        + " OR lower(a.name) LIKE :search "
                        + " OR lower(a.description) LIKE :search "
                        + ")";
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

}
