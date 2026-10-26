/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.BpGroup;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.BpGroup;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bulwarks-2
 */
public class BpGroupDaoImpl<T> extends GenericsDAOImpl<T> implements BpGroupDao<T> {

    @Override
    protected Class getDomainClass() {
        return BpGroup.class;
    }

    @Override
    public BpGroup readByBpCode(String extractedBpGroup) {
        BpGroup bpGroup = new BpGroup();
        String query = "";
        query += " FROM BpGroup a"
                + " WHERE a.bpGroupName = '" + extractedBpGroup + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            bpGroup = (BpGroup) list.get(0);
        }
        return bpGroup;
    }

    @Override
    public List getbpGroupPagination(int start, int length, String search, String orderColumn, String orderDir) {

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

            String hql = "from BpGroup a where 1 = 1 ";

            if (search != null && !search.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.bpGroupName) LIKE :search "
                        + " OR lower(a.accountGroup) LIKE :search "
                        + " OR lower(a.discription) LIKE :search "
                        + ") ";
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
    public int getTotalbpGroupCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from BpGroup a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();

    }

    @Override
    public int getFilteredbpGroupCount(String searchValue) {
        Session session = getSessionFactory().openSession();

        try {
            String hql = "select count(a.id) "
                    + "from BpGroup a "
                    + "where 1 = 1";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                 hql += " AND ("
                        + " lower(a.bpGroupName) LIKE :search "
                        + " OR lower(a.accountGroup) LIKE :search "
                        + " OR lower(a.discription) LIKE :search "
                        + ") ";
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
