/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.GroupMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class GroupMasterDaoImpl<T> extends GenericsDAOImpl<T> implements GroupMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return GroupMaster.class;
    }

    @Override
    public List getGroupMasterPagination(int start, int length, String search, String orderColumn, String orderDir) {

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

            String hql = "from GroupMaster a where 1 = 1 ";

            if (search != null && !search.trim().equals("")) {
                hql += " and lower(a.groupName)"
                        + " like :search";
            }

            hql += " order by a." + orderColumn + " " + orderDir;

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
    public int getTotalGroupMasterCount() {

        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from GroupMaster a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();
    }

    @Override
    public int getFilteredGroupMasterCount(String searchValue) {
        Session session = getSessionFactory().openSession();

        try {
            String hql = "select count(a.id) "
                    + "from GroupMaster a "
                    + "where 1 = 1";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " and lower(a.groupName) like :searchValue";
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
