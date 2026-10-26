/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Right;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RightMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aman Bahukhandi
 */
public class RightDaoImpl<T> extends GenericsDAOImpl<T> implements RightDao<T> {

    @Override
    protected Class getDomainClass() {
        return RightMaster.class;
    }

    @Override
    public RightMaster read(String rightName) {
        String query = " Select a "
                + " from RightMaster a "
                + " where a.rightName='" + rightName + "'";
        return (RightMaster) getHibernateTemplate().find(query).get(0);
    }

    @Override
    public void deleteByRightName(String checkedValues) {
        String query = "";
        query = " delete FROM RightMaster a"
                + " WHERE a.rightName = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByDrow() {
        String query = " Select a "
                + " from RightMaster a "
                + " where a.dRow='N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDrowDisable() {
        String query = " Select a "
                + " from RightMaster a "
                + " where a.dRow='Y'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getrightMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
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

            String hql = "from RightMaster a where a.dRow='N'";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.rightName) LIKE :searchValue "
                        + ")";
            }

            hql += " order by a."
                    + orderColumn
                    + " "
                    + orderDir;

            System.out.println("HQL : " + hql);
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
    public int getTotalrightMasterCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from RightMaster a "
                + "where a.dRow='N'"
        ).uniqueResult();

        session.close();
        return count.intValue();
    }

    @Override
    public int getFilteredrightMasterCount(String search) {
        Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(a.id) "
                    + "from RightMaster a "
                    + " where a.dRow='N'";

            if (search != null && !search.trim().isEmpty()) {
                hql += " AND ("
                        + " lower(a.rightName) LIKE :searchValue "
                        + ")";
            }
            Query query = session.createQuery(hql);
            if (search != null && !search.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + search.toLowerCase() + "%");
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
