/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DiscomMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DiscomMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class DiscomMasterDaoImpl<T> extends GenericsDAOImpl<T> implements DiscomMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return DiscomMaster.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        DiscomMaster discomMaster = (DiscomMaster) object;
        List list = getHibernateTemplate().find(
                "from DiscomMaster l where l.discomType = ? and l.state = ?",
                discomMaster.getDiscomType(),
                discomMaster.getState());
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List readByStateName(String state) {
        String query = "";
        query += " FROM DiscomMaster a"
                + " WHERE a.state = '" + state + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getDiscomMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
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

            String hql = "from DiscomMaster a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.discomType) LIKE :searchValue "
                        + " OR lower(a.state) LIKE :searchValue "
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
    public int getTotalDiscomMasterCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from DiscomMaster a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();
    }

    @Override
    public int getFilteredDiscomMasterCount(String search) {
        Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(a.id) "
                    + "from DiscomMaster a "
                    + "where 1 = 1";

            if (search != null && !search.trim().isEmpty()) {
                hql += " AND ("
                        + " lower(a.discomType) LIKE :searchValue "
                        + " OR lower(a.state) LIKE :searchValue "
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
