/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RiskCategory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Riskcategory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class RiskCategoryDaoImpl<T> extends GenericsDAOImpl<T> implements RiskCategoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return Riskcategory.class;
    }

    @Override
    public List getRiskCategoryPagination(int start, int length, String search, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {
            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "id";
            }
            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "asc";
            }

            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "asc";
            }

            String hql = "from Riskcategory a where 1 = 1 ";

            if (search != null && !search.trim().equals("")) {
                hql += " and lower(a.category)"
                        + " like :search";
            }

            hql += " order by a." + orderColumn + " " + orderDir;

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
    public int getTotalRiskCategoryCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from Riskcategory a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();

    }

    @Override
    public int getFilteredRiskCategoryCount(String searchValue) {

        Session session = getSessionFactory().openSession();

        try {
            String hql = "select count(a.id) "
                    + "from Riskcategory a "
                    + "where 1 = 1";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " and lower(a.category) like :search";
            }

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
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
